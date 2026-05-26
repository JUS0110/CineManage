package br.ufrpe.cine_rural.dados.interfaces;

import java.util.ArrayList;
import br.ufrpe.cine_rural.model.tiposala.Sala;


public interface iRepositorioSala {
    void cadastrar(Sala sala);
    Sala buscar(int id);
    void remover(int id);
    ArrayList<Sala> listar();
}