package dev.java10x.Sistema.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class User {
    @Getter
    private Integer Id;
    @Setter
    @Getter
    private String nome;
    @Setter
    @Getter
    private String senha;

    public User(){}
    public User(String nome, String senha){
        this.senha = senha;
        this.nome = nome;

    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
