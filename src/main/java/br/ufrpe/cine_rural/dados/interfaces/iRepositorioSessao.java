package main.java.br.ufrpe.cine_rural.dados.interfaces;

import main.java.br.ufrpe.cine_rural.model.beans.Sessao;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface iRepositorioSessao {

    void cadastrar(Sessao sessao);

    Sessao buscar(LocalDateTime horario);

    void atualizar(Sessao sessao);

    void remover(LocalDateTime horario);

    ArrayList<Sessao> listar();
}