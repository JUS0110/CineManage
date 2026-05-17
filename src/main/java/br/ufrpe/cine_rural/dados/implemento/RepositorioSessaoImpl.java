package main.java.br.ufrpe.cine_rural.dados.implemento;

import main.java.br.ufrpe.cine_rural.dados.interfaces.iRepositorioSessao;
import main.java.br.ufrpe.cine_rural.model.beans.Sessao;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class RepositorioSessaoImpl implements iRepositorioSessao {

    private ArrayList<Sessao> sessoes;

    public RepositorioSessaoImpl() {
        sessoes = new ArrayList<>();
    }

    @Override
    public void cadastrar(Sessao sessao) {
        sessoes.add(sessao);
    }

    @Override
    public Sessao buscar(LocalDateTime horario) {

        for (Sessao sessao : sessoes) {

            if (sessao.getHorario().equals(horario)) {
                return sessao;
            }
        }

        return null;
    }

    @Override
    public void atualizar(Sessao sessaoAtualizada) {

        Sessao sessao = buscar(sessaoAtualizada.getHorario());

        if (sessao != null) {

            sessao.setIdioma(sessaoAtualizada.getIdioma());
            sessao.setStatus(sessaoAtualizada.getStatus());
            sessao.setFilme(sessaoAtualizada.getFilme());
            sessao.setSala(sessaoAtualizada.getSala());
        }
    }

    @Override
    public void remover(LocalDateTime horario) {

        Sessao sessao = buscar(horario);

        if (sessao != null) {
            sessoes.remove(sessao);
        }
    }

    @Override
    public ArrayList<Sessao> listar() {
        return sessoes;
    }
}