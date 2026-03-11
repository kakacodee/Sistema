package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private LocalDate data_inicio;
    @Getter
    @Setter
    private LocalDate data_fim;
    @Getter
    @Setter
    private Status status;
}
