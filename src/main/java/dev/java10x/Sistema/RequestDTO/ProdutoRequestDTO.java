package dev.java10x.Sistema.RequestDTO;

import lombok.Getter;
import lombok.Setter;

public class ProdutoRequestDTO {
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private double preco;
    @Getter
    @Setter
    private int estoque;
}
