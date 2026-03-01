package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.TarefasInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class TarefasService {

    private final TarefasInterface tarefasInterface;
    public TarefasService(TarefasInterface tarefasInterface){
        this.tarefasInterface = tarefasInterface;
    }
    public void SalvarTarefas(Tarefas tarefas){
        tarefasInterface.save(tarefas);
    }
    public void DeleteTarefas(Tarefas tarefas, Long id){
        tarefasInterface.deleteById(id);
    }
    public void DeleteTodasTarefas(){
        tarefasInterface.deleteAll();
    }


}
