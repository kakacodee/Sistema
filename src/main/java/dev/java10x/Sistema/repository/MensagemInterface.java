package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.Mensagem;
import dev.java10x.Sistema.Model.Papel;
import dev.java10x.Sistema.Model.Status;
import dev.java10x.Sistema.Model.Tarefas;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensagemInterface extends JpaRepository<Mensagem, Long> {
    List<Mensagem>findByPapel(Papel papel);
}
