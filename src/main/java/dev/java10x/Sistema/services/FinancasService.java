package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Conta;
import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.Model.TipoTransacao;
import dev.java10x.Sistema.repository.ContaInterface;
import dev.java10x.Sistema.repository.FinancasInterface;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class FinancasService {

    private final FinancasInterface financasInterface;

    public FinancasService(FinancasInterface financasInterface) {
        this.financasInterface = financasInterface;
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
    public BigDecimal TratarAoDeletar(Financas financas, Conta conta, Long id, ContaInterface contaInterface){
        Optional<Financas> financaOpt = financasInterface.findById(id);
        if(financaOpt.isPresent()){
            Financas financa = financaOpt.get();
            BigDecimal total = conta.getTotal();
            if(financas.getTipo() == TipoTransacao.ENTRADA){
                total = total.subtract(financas.getValor());
            }
            else if(financas.getTipo() == TipoTransacao.SAIDA){
                total = total.add(financas.getValor());
            }


        conta.setTotal(total);
            financasInterface.deleteById(id);
            contaInterface.save(conta);
            return  total;
        }
        return conta.getTotal();
    }

}
