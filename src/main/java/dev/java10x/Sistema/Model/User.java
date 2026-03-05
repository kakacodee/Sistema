package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long Id;
    @Setter
    @Getter
    private String nome;
    @Setter
    @Getter
    private String senha;
    @Setter
    @Getter
    @Column(unique = true)
    private String email;
    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    private Papel papel;
    public User(){}
    public User(String nome, String senha, String email, Papel papel){
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.papel = papel;

    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
