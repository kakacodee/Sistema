package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financas")
public class Financas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private BigDecimal valor;
    @Getter
    @Setter
    private TipoTransacao tipo;
    @Getter
    @Setter
    public class Conta {
        private BigDecimal total = BigDecimal.ZERO;
        public BigDecimal Saldo(Financas financas){
            this.total = BigDecimal.ZERO;
            if(financas.getTipo() == TipoTransacao.ENTRADA){
                return this.total.add(financas.getValor());

            }
            else if(financas.getTipo() == TipoTransacao.SAIDA){

                return this.total.subtract(financas.getValor());
            }
            return  this.total;
        }
    }
    @Getter
    @Setter
    private LocalDate data;

}
