package dev.java10x.Sistema.Model;

public class MensagemDTO {
    private Papel papel;
    private String mensagem;

    public Papel getPapel() { return papel; }
    public void setPapel(Papel papel) { this.papel = papel; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}