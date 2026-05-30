package br.ufrpe.cine_rural.model;

import br.ufrpe.cine_rural.enums.ClassificacaoIndicativa;
import br.ufrpe.cine_rural.enums.Genero;
import javafx.scene.image.Image;
import java.time.LocalTime;

public class Filme {

    private String titulo;
    private String sinopse;
    private int duracao; // em minutos
    private Genero genero;
    private ClassificacaoIndicativa classificacao;
    private LocalTime localTime; // Horário ou duração formatada se necessário
    private Image poster;

    public Filme(String titulo,
                 String sinopse,
                 int duracao,
                 Genero genero,
                 ClassificacaoIndicativa classificacao,
                 LocalTime localTime,
                 Image poster) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.genero = genero;
        this.classificacao = classificacao;
        this.localTime = localTime;
        this.poster = poster;
    }

    public Image getPoster() { return poster; }
    public void setPoster(Image poster) { this.poster = poster; }

    public String getTitulo() { return titulo; }
    public String getSinopse() { return sinopse; }
    public int getDuracao() { return duracao; }
    public Genero getGenero() { return genero; }

    public ClassificacaoIndicativa getClassificacao() { return classificacao; }
    public void setClassificacao(ClassificacaoIndicativa classificacao) { this.classificacao = classificacao; }

    public LocalTime getLocalTime() { return localTime; }
    public void setLocalTime(LocalTime localTime) { this.localTime = localTime; }
}