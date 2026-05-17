package main.java.br.ufrpe.cine_rural.dados.implemento;

import main.java.br.ufrpe.cine_rural.dados.interfaces.iRepositorioVendaLojinha;
import main.java.br.ufrpe.cine_rural.model.beans.loja.VendaLojinha;
import java.util.ArrayList;


public class RepositorioVendaLojinhaImpl implements iRepositorioVendaLojinha {

    private ArrayList<VendaLojinha> vendas;

    public RepositorioVendaLojinhaImpl() {
        vendas = new ArrayList<>();
    }

    @Override
    public void cadastrar(VendaLojinha venda) {
        vendas.add(venda);
    }

    @Override
    public VendaLojinha buscar(int indice) {

        if (indice >= 0 && indice < vendas.size()) {
            return vendas.get(indice);
        }

        return null;
    }

    @Override
    public void remover(int indice) {

        if (indice >= 0 && indice < vendas.size()) {
            vendas.remove(indice);
        }
    }

    @Override
    public ArrayList<VendaLojinha> listar() {
        return vendas;
    }
}