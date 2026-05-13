package main.java.br.ufrpe.cine_rural.model.beans;

import main.java.br.ufrpe.cine_rural.enums.Idioma;
import main.java.br.ufrpe.cine_rural.enums.StatusSessao;

import main.java.br.ufrpe.cine_rural.model.beans.tiposala.Sala;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sessao {

    private Idioma idioma;
    private StatusSessao status;

    private LocalDateTime horario;

    private Filme filme;
    private Sala sala;

    private ArrayList<Ingresso> ingressos;

    public Sessao(Idioma idioma,
                  StatusSessao status,
                  LocalDateTime horario,
                  Filme filme,
                  Sala sala) {

        this.idioma = idioma;
        this.status = status;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.ingressos = new ArrayList<>();
    }

    public void adicionarIngressos(Ingresso ingresso) {

        ingressos.add(ingresso);
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public int getTotalIngressos() {
        return ingressos.size();
    }

    public Filme getFilme() {
        return filme;
    }

    public Sala getSala() {
        return sala;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public StatusSessao getStatus() {
        return status;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public void setStatus(StatusSessao status) {
        this.status = status;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
}