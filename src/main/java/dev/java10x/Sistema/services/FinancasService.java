package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Conta;
import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.Model.TipoTransacao;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FinancasService {

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

}
