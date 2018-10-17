package br.com.naosai.breno.gincapp_010.Entidades;

public class Gincana {

    private String id;
    private String nome;
    private String chaveamento;



    public Gincana() {


    }

    public String getChaveamento() {
        return chaveamento;
    }

    public void setChaveamento(String chaveamento) {
        this.chaveamento = chaveamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
