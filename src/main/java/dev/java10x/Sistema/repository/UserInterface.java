package dev.java10x.Sistema.repository;

import dev.java10x.Sistema.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User, Long> {
Optional<User> findByEmail(String email);

}
