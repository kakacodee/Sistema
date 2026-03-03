package dev.java10x.Sistema.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class gerar {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }
}