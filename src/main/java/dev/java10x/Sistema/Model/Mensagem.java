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
    private Long id;
    @Getter
    @Enumerated(EnumType.ORDINAL)
    @Setter
    private Papel papel;
    @Getter
    @Setter
    private String mensagem;
    public Mensagem(){}
    public Mensagem(Papel papel, String mensagem){
        this.papel = papel;
        this.mensagem = mensagem;
    }
}

