package dev.java10x.Sistema.interfaces;

import dev.java10x.Sistema.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Produtointerface extends JpaRepository<Produto, Long> {

}
