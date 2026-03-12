package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.User;
import dev.java10x.Sistema.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class UserService implements UserDetailsService {
    private final UserInterface userInterface;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserService(UserInterface userInterface, PasswordEncoder passwordEncoder){
        this.userInterface = userInterface;
        this.passwordEncoder = passwordEncoder;
    }


public void salvarUser(User user){
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        userInterface.save(user);
}

@Override
public  UserDetails loadUserByUsername(String username){
   User user = userInterface.findByEmail(username).orElseThrow(() ->
            new UsernameNotFoundException("Usuário não encontrado"));
    return org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getSenha())
            .roles(user.getPapel().name())
            .build();
}
}