package br.ufrpe.cine_rural.monitor;

import java.time.LocalTime;

public class Filme {
    private String titulo;
    private String sinopse;
    private String genero;
    private int classificaIndicativa;
    private LocalTime tempo;

    public Filme (String titulo, String sinopse, String genero, int classificaIndicativa, LocalTime tempo){
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.classificaIndicativa = classificaIndicativa;
        this.tempo = tempo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificaIndicativa() {
        return classificaIndicativa;
    }

    public void setClassificaIndicativa(int classificaIndicativa) {
        this.classificaIndicativa = classificaIndicativa;
    }

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }


}
