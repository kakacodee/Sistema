package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.Model.TipoTransacao;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FinancasService {
    public BigDecimal TratamentoTipoDinheiro(Financas financas, BigDecimal Total){
        if (financas.getValor() == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo");
        }
        if (financas.getTipo() == null)
        {
            throw new IllegalArgumentException("Tipo da transação não pode ser nulo");
        }
        if(Total.compareTo(financas.getValor()) < 0 && financas.getTipo() == TipoTransacao.SAIDA){
            throw new RuntimeException("Saldo insuficiente");
        }
        if(financas.getTipo() == TipoTransacao.ENTRADA){
            return Total.add(financas.getValor());

        }
        else if(financas.getTipo() == TipoTransacao.SAIDA){

            return Total.subtract(financas.getValor());
        }
        return  Total;
    }
}
