package dev.java10x.Sistema.services;

import dev.java10x.Sistema.Model.Mensagem;
import dev.java10x.Sistema.repository.MensagemInterface;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    private final MensagemInterface mensagemInterface;
    public MensagemService(MensagemInterface mensagemInterface){
        this.mensagemInterface = mensagemInterface;
    }
    public void Mensagens(Mensagem mensagem){
        mensagemInterface.save(mensagem);
    }
}
