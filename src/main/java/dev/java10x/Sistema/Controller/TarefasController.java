package dev.java10x.Sistema.Controller;


import dev.java10x.Sistema.Model.Status;
import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.FinancasInterface;
import dev.java10x.Sistema.repository.TarefasInterface;
import dev.java10x.Sistema.services.FinancasService;
import dev.java10x.Sistema.services.TarefasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Tarefas")
public class TarefasController {
    private final TarefasInterface tarefasInterface;
    private final TarefasService tarefasService;



    public TarefasController(TarefasInterface tarefasInterface, TarefasService tarefasService){
        this.tarefasInterface = tarefasInterface;
        this.tarefasService = tarefasService;

    }
    @PostMapping
    public String salvar(Tarefas tarefas){
        tarefasService.SalvarTarefas(tarefas);
        return "redirect:/Tarefas";
    }
    @GetMapping
    public String listar(Model model){
        List<Tarefas> emAndamento = tarefasInterface.findByStatus(Status.EM_ANDAMENTO);
        List<Tarefas> concluido = tarefasInterface.findByStatus(Status.CONCLUIDO);
        model.addAttribute("emAndamento", emAndamento);
        model.addAttribute("concluido", concluido);
        return "tarefas";
    }
    @GetMapping("/delete/{id}")
    public String Deletar(@PathVariable Long id, Tarefas tarefas){
        tarefasService.DeleteTarefas(tarefas, id);

        return "redirect:/Tarefas";
    }
    @GetMapping("/deleteall")
    public String DeletarTudo(){
        tarefasService.DeleteTodasTarefas();
        return "redirect:/Tarefas";
    }
}
