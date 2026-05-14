package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Status;
import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.TarefasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TarefasService {

    private final TarefasInterface tarefasInterface;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public TarefasService(TarefasInterface tarefasInterface){
        this.tarefasInterface = tarefasInterface;
    }
    public void SalvarTarefas(Tarefas tarefas){

        tarefasInterface.save(tarefas);
    }
    public void ListarTarefas(Model model){
        List<Tarefas> emAndamento = tarefasInterface.findByStatus(Status.EM_ANDAMENTO);
        List<Tarefas> concluido = tarefasInterface.findByStatus(Status.CONCLUIDO);
        model.addAttribute("emAndamento", emAndamento);
        model.addAttribute("concluido", concluido);
    }

    @Transactional
    public void DeleteTarefas(Tarefas tarefas, Long id){
        tarefasInterface.deleteById(id);
        jdbcTemplate.execute("alter table tarefas AUTO_INCREMENT = 1");
    }
    @Transactional
    public void DeleteTodasTarefas(){
        tarefasInterface.deleteAll();
        jdbcTemplate.execute("alter table tarefas AUTO_INCREMENT = 1");
    }


}
