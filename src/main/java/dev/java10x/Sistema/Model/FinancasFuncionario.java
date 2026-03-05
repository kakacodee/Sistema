package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financasFuncionario")
public class FinancasFuncionario {
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
    private LocalDate data;

}
