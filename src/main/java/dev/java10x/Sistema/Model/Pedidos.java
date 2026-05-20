package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Getter
    @Setter
    private String Nome;
    @Getter
    @Setter
    private int Quantidade;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
