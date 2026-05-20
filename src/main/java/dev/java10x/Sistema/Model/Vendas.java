package dev.java10x.Sistema.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vendas")
public class Vendas {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Getter
    @Setter
    private String Cliente;
    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedidos Pedidos;
}
