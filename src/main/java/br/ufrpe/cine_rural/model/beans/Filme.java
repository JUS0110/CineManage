package main.java.br.ufrpe.cine_rural.model.beans;

import main.java.br.ufrpe.cine_rural.enums.ClassificacaoIndicativa;
import main.java.br.ufrpe.cine_rural.enums.Genero;

import java.time.LocalTime;


public class Filme {

    private String titulo;
    private String sinopse;
    private int duracao;
    private Genero genero;
    private ClassificacaoIndicativa classificacao;

    public Filme(String titulo,
                 String sinopse,
                 Genero genero,
                 ClassificacaoIndicativa classificacao,
                 LocalTime localTime) {

        this.genero = genero;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public ClassificacaoIndicativa getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoIndicativa classificacao) {
        this.classificacao = classificacao;
    }
}
