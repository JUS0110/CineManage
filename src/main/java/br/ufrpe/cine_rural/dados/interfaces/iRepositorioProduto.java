package main.java.br.ufrpe.cine_rural.dados.interfaces;

import main.java.br.ufrpe.cine_rural.model.beans.loja.Produto;
import java.util.ArrayList;

public interface iRepositorioProduto {

    void cadastrar(Produto produto);

    Produto buscar(int id);

    void atualizar(Produto produto);

    void remover(int id);

    ArrayList<Produto> listar();
}