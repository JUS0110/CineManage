package br.ufrpe.cine_rural.dados.interfaces;

import br.ufrpe.cine_rural.negocio.beans.Sessao;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface RepositorioSessao {

    void cadastrar(Sessao sessao);

    Sessao buscar(LocalDateTime horario);

    void atualizar(Sessao sessao);

    void remover(LocalDateTime horario);

    ArrayList<Sessao> listar();
}