package dev.java10x.Sistema.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private double preco;
    @Getter
    @Setter
    private int estoque;

    public Produto(){}
    public Produto(String nome, double preco, int estoque){
        this.preco = preco;
        this.nome = nome;
        this.estoque = estoque;

    }

    @Override
    public String toString() {
        return "Produto{" +
                "estoque=" + estoque +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
