package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.Mensagem;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemInterface extends JpaRepository<Mensagem, Long> {
}
