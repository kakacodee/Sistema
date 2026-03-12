package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Tarefas;
import dev.java10x.Sistema.repository.TarefasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TarefasService {

    private final TarefasInterface tarefasInterface;
    public TarefasService(TarefasInterface tarefasInterface){
        this.tarefasInterface = tarefasInterface;
    }
    public void SalvarTarefas(Tarefas tarefas){

        tarefasInterface.save(tarefas);
    }
    @Transactional
    public void DeleteTarefas(Tarefas tarefas, Long id){
        tarefasInterface.deleteById(id);
    }
    @Transactional
    public void DeleteTodasTarefas(){
        tarefasInterface.deleteAll();
    }


}
