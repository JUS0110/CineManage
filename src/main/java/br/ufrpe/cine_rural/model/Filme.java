package br.ufrpe.cine_rural.model;

import br.ufrpe.cine_rural.enums.ClassificacaoIndicativa;
import br.ufrpe.cine_rural.enums.Genero;

import java.time.LocalTime;


public class Filme {

    private String titulo;
    private String sinopse;
    private int duracao;
    private Genero genero;
    private ClassificacaoIndicativa classificacao;
    private LocalTime localTime;

    public Filme(String titulo,
                 String sinopse,
                 int duracao,
                 Genero genero,
                 ClassificacaoIndicativa classificacao,
                 LocalTime localTime) {

        this.genero = genero;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.localTime = localTime;
    } // arrumei o construtor do Filme, faltou adicionar o localTime e a duração corretamente no construtor para rodar na main


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