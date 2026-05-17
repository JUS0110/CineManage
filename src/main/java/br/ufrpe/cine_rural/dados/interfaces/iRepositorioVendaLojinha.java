package main.java.br.ufrpe.cine_rural.dados.interfaces;

import main.java.br.ufrpe.cine_rural.model.beans.loja.VendaLojinha;
import java.util.ArrayList;

public interface iRepositorioVendaLojinha {

    void cadastrar(VendaLojinha venda);

    VendaLojinha buscar(int indice);

    void remover(int indice);

    ArrayList<VendaLojinha> listar();
}