package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.*;
import dev.java10x.Sistema.repository.ContaFuncionarioInterface;

import dev.java10x.Sistema.repository.FinancasFuncionarioInterface;
import dev.java10x.Sistema.repository.FinancasInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Service
public class FinancasFuncionarioService {

    private final FinancasFuncionarioInterface financasFuncionarioInterface;
    private final ContaFuncionarioInterface contaFuncionarioInterface;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public FinancasFuncionarioService(FinancasFuncionarioInterface financasFuncionarioInterface, ContaFuncionarioInterface contaFuncionarioInterface) {
        this.financasFuncionarioInterface = financasFuncionarioInterface;
        this.contaFuncionarioInterface = contaFuncionarioInterface;
    }
    public ContaFuncionario obterOuCriarConta() {

        return contaFuncionarioInterface.findAll().stream().findFirst()
                .orElseGet(() -> {
                    ContaFuncionario nova = new ContaFuncionario();
                    nova.setTotal(BigDecimal.ZERO);
                    return contaFuncionarioInterface.save(nova);
                });
    }
    public BigDecimal TratamentoTipoDinheiro(FinancasFuncionario financasFuncionario, ContaFuncionario contaFuncionario){
        BigDecimal total = contaFuncionario.getTotal();
        if (financasFuncionario.getValor() == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo");
        }
        if (financasFuncionario.getTipo() == null)
        {
            throw new IllegalArgumentException("Tipo da transação não pode ser nulo");
        }
        if(total.compareTo(financasFuncionario.getValor()) < 0 && financasFuncionario.getTipo() == TipoTransacao.SAIDA){
            throw new RuntimeException("Saldo insuficiente");
        }

        if(financasFuncionario.getTipo() == TipoTransacao.ENTRADA){
            total = total.add(financasFuncionario.getValor());
        }
        else if(financasFuncionario.getTipo() == TipoTransacao.SAIDA){
            total = total.subtract(financasFuncionario.getValor());
        }
        contaFuncionario.setTotal(total);
        return  total;
    }
    public void TratarAoDeletar(ContaFuncionario contaFuncionario, Long id, FinancasFuncionario financasFuncionario){
        if (contaFuncionario == null || financasFuncionario == null) {
            throw new IllegalArgumentException("Conta ou transação inválida");
        }
        BigDecimal totalAtual = contaFuncionario.getTotal() != null ? contaFuncionario.getTotal() : BigDecimal.ZERO;
        BigDecimal valor = financasFuncionario.getValor() != null ? financasFuncionario.getValor() : BigDecimal.ZERO;
        if(financasFuncionario.getTipo() == TipoTransacao.ENTRADA){
            totalAtual = totalAtual.subtract(valor);
        }
        else if(financasFuncionario.getTipo() == TipoTransacao.SAIDA){
            totalAtual = totalAtual.add(valor);
        }
        contaFuncionario.setTotal(totalAtual);
    }
    @org.springframework.transaction.annotation.Transactional
    public void ApagarTudo(){
        financasFuncionarioInterface.deleteAll();
        contaFuncionarioInterface.deleteAll();
        jdbcTemplate.execute("alter table financas_funcionario AUTO_INCREMENT = 1");
        jdbcTemplate.execute("ALTER TABLE conta_funcionario AUTO_INCREMENT = 1");
    }
    @Transactional
    public void salvarTransacao(FinancasFuncionario financasFuncionario) {
        ContaFuncionario contaFuncionario = obterOuCriarConta();

        TratamentoTipoDinheiro(financasFuncionario, contaFuncionario);
        contaFuncionarioInterface.save(contaFuncionario);
        financasFuncionarioInterface.save(financasFuncionario);
    }
    @Transactional
    public void deletar(Long id) {
        FinancasFuncionario financasFuncionario = financasFuncionarioInterface.findById(id).orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        ContaFuncionario contaFuncionario = obterOuCriarConta();

        TratarAoDeletar(contaFuncionario, id, financasFuncionario);
        contaFuncionarioInterface.save(contaFuncionario);

        financasFuncionarioInterface.delete(financasFuncionario);
        jdbcTemplate.execute("alter table financas_funcionario AUTO_INCREMENT = 1");
    }
}
