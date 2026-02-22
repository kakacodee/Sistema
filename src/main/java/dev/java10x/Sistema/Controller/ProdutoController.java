package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.Model.Produto;
import dev.java10x.Sistema.repository.Produtointerface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Produtos")
public class ProdutoController {
    private final Produtointerface produtointerface;
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
        return "redirect:/Produtos";
    }
}
