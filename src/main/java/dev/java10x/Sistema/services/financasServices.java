package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.Model.TipoTransacao;
import dev.java10x.Sistema.interfaces.FinancasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class financasServices {
    public BigDecimal TratamentoTipoDinheiro(Financas financas, BigDecimal Total){
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
