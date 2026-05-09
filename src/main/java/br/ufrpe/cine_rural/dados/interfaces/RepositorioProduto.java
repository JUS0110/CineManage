package br.ufrpe.cine_rural.dados.interfaces;

import br.ufrpe.cine_rural.negocio.loja.Produto;
import java.util.ArrayList;

public interface RepositorioProduto {

    void cadastrar(Produto produto);

    Produto buscar(int id);

    void atualizar(Produto produto);

    void remover(int id);

    ArrayList<Produto> listar();
}