package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mensagem")
public class Mensagem {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Getter
    @ManyToOne
    private User user;
    @Getter
    @Setter
    private String mensagem;
}

