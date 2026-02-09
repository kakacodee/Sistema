package dev.java10x.Sistema.Controller;

import dev.java10x.Sistema.Model.User;
import dev.java10x.Sistema.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private User user;

    @PostMapping("/post")
    public String Hwp(@RequestBody User body){
        return "Olá, " + user.getNome();
    }
}
