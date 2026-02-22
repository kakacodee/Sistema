package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasInterface extends JpaRepository<Tarefas, Long> {
}
