package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.Model.Produto;
import dev.java10x.Sistema.repository.Produtointerface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
@Controller
@RequestMapping("/Produtos")
public class ProdutoController {
    private final Produtointerface produtointerface;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ProdutoController(Produtointerface produtointerface){

        this.produtointerface = produtointerface;
    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("produtos", produtointerface.findAll());
        return "produtos";
    }
    @PostMapping
    public String Salvar(Produto produto){
        produtointerface.save(produto);
        return "redirect:/Produtos";
    }
    @GetMapping("/delete/produto/{id}")
    public String Deletar(@PathVariable Long id){
        produtointerface.deleteById(id);
        jdbcTemplate.execute("alter table usuarios AUTO_INCREMENT = 1");
        return "redirect:/Produtos";
    }
}
