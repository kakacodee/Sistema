package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.TarefasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public void DeleteTarefas(Tarefas tarefas, Long id){
        tarefasInterface.deleteById(id);
        jdbcTemplate.execute("alter table financas_funcionario AUTO_INCREMENT = 1");
    }
    public void DeleteTodasTarefas(){
        tarefasInterface.deleteAll();
        jdbcTemplate.execute("alter table financas_funcionario AUTO_INCREMENT = 1");
    }


}
