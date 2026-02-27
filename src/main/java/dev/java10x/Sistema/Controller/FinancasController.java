package dev.java10x.Sistema.Controller;
import dev.java10x.Sistema.Model.Conta;
import dev.java10x.Sistema.Model.Financas;
import dev.java10x.Sistema.repository.ContaInterface;
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
    private final ContaInterface contaInterface;
    public FinancasController( FinancasService financasService, FinancasInterface financasInterface, ContaInterface contaInterface){
        this.financasService = financasService;
        this.financasInterface = financasInterface;
        this.contaInterface = contaInterface;

    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("financas", financasInterface.findAll());
        BigDecimal resultado = contaInterface.findById(1L)
                .map(Conta::getTotal)
                .orElse(BigDecimal.ZERO);

        model.addAttribute("resultado", resultado);

        return "financas";
    }


    @PostMapping
    public String Salvar(Financas financas, Conta conta){
        conta = contaInterface.findById(1L).orElse(new Conta());
        BigDecimal totalAtual = financasService.TratamentoTipoDinheiro(financas, conta);
        financasInterface.save(financas);
        contaInterface.save(conta);
        return "redirect:/Financas";
    }
    @GetMapping("/delete/{id}")
    public String Deletar(@PathVariable Long id, Financas financas, Conta conta){
        financasInterface.deleteById(id);
        conta = contaInterface.findById(1L) .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        contaInterface.save(conta);
        financasService.TratarAoDeletar(financas, conta, id, contaInterface);
        return "redirect:/Financas";
    }
}

