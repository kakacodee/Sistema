package dev.java10x.Sistema.Controller;
import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.repository.FinancasInterface;
import dev.java10x.Sistema.services.FinancasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
@RequestMapping("/Financas")
public class FinancasController {
    private final FinancasInterface financasInterface;
    private final FinancasService financasService;
    public FinancasController( FinancasService financasService, FinancasInterface financasInterface){
        this.financasService = financasService;
        this.financasInterface = financasInterface;
    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("financas", financasInterface.findAll());
        return "financas";
    }
    @PostMapping
    public String Salvar(Financas financas, RedirectAttributes redirectAttributes){
        BigDecimal totalAtual = financasInterface.findAll()
                .stream()
                .map(Financas::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        financas.setTotal(totalAtual);
        BigDecimal novoTotal = financasService.TratamentoTipoDinheiro(financas, totalAtual);

        financasInterface.save(financas);
        redirectAttributes.addFlashAttribute("resultado", novoTotal);
        return "redirect:/Financas";
    }
    @GetMapping("/delete/{id}")
    public String Deletar(@PathVariable Long id){
        financasInterface.deleteById(id);
        return "redirect:/Financas";
    }
}

