package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Conta;
import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.Model.TipoTransacao;
import dev.java10x.Sistema.repository.ContaInterface;
import dev.java10x.Sistema.repository.FinancasInterface;
import jakarta.transaction.Transactional;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class FinancasService {

    private final FinancasInterface financasInterface;
    private final ContaInterface contaInterface;

    public FinancasService(FinancasInterface financasInterface, ContaInterface contaInterface) {
        this.financasInterface = financasInterface;
        this.contaInterface = contaInterface;
    }
    public Conta obterOuCriarConta() {

        return contaInterface.findAll().stream().findFirst()
                .orElseGet(() -> {
                    Conta nova = new Conta();
                    nova.setTotal(BigDecimal.ZERO);
                    return contaInterface.save(nova);
                });
    }
    public BigDecimal TratamentoTipoDinheiro(Financas financas, Conta conta){
        BigDecimal total = conta.getTotal();
        if (financas.getValor() == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo");
        }
        if (financas.getTipo() == null)
        {
            throw new IllegalArgumentException("Tipo da transação não pode ser nulo");
        }
        if(total.compareTo(financas.getValor()) < 0 && financas.getTipo() == TipoTransacao.SAIDA){
            throw new RuntimeException("Saldo insuficiente");
        }

        if(financas.getTipo() == TipoTransacao.ENTRADA){
            total = total.add(financas.getValor());
        }
        else if(financas.getTipo() == TipoTransacao.SAIDA){
            total = total.subtract(financas.getValor());
        }
        conta.setTotal(total);
        return  total;
    }
    public void TratarAoDeletar(Conta conta, Long id, Financas financas){
        if (conta == null || financas == null) {
            throw new IllegalArgumentException("Conta ou transação inválida");
        }
        BigDecimal totalAtual = conta.getTotal() != null ? conta.getTotal() : BigDecimal.ZERO;
        BigDecimal valor = financas.getValor() != null ? financas.getValor() : BigDecimal.ZERO;
        if(financas.getTipo() == TipoTransacao.ENTRADA){
            totalAtual = totalAtual.subtract(valor);
        }
        else if(financas.getTipo() == TipoTransacao.SAIDA){
            totalAtual = totalAtual.add(valor);
        }
        conta.setTotal(totalAtual);
    }
    public void ApagarTudo(){
        financasInterface.deleteAll();
        contaInterface.deleteAll();
    }
    @Transactional
    public void salvarTransacao(Financas financas) {
        Conta conta = obterOuCriarConta();

        TratamentoTipoDinheiro(financas, conta);
        contaInterface.save(conta);
        financasInterface.save(financas);
    }
    public void deletar(Long id) {
        Financas financas = financasInterface.findById(id).orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        Conta conta = obterOuCriarConta();

        TratarAoDeletar(conta, id, financas);
        contaInterface.save(conta);
        financasInterface.delete(financas);
    }
}
