package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private BigDecimal Valor;
    @Getter
    @Setter
    private TipoTransacao Tipo;
    @Getter
    @Setter
    private BigDecimal total;
    @Getter
    @Setter
    private LocalDate data;

}
