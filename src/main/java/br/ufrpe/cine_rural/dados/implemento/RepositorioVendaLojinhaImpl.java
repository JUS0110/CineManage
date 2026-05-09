package br.ufrpe.cine_rural.dados.implemento;

import br.ufrpe.cine_rural.dados.interfaces.RepositorioVendaLojinha;
import br.ufrpe.cine_rural.negocio.loja.VendaLojinha;
import java.util.ArrayList;


public class RepositorioVendaLojinhaImpl implements RepositorioVendaLojinha {

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