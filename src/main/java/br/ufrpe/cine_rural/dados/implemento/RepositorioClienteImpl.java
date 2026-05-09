package br.ufrpe.cine_rural.dados.implemento;

import br.ufrpe.cine_rural.dados.interfaces.RepositorioCliente;
import br.ufrpe.cine_rural.negocio.beans.Cliente;
import java.util.ArrayList;


public class RepositorioClienteImpl implements RepositorioCliente {

    private ArrayList<Cliente> clientes;

    public RepositorioClienteImpl() {
        clientes = new ArrayList<>();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscar(String cpf) {

        for (Cliente cliente : clientes) {

            if(cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;
    }

    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public void remover(String cpf) {

        Cliente cliente = buscar(cpf);

        if(cliente != null) {
            clientes.remove(cliente);
        }
    }

    @Override
    public ArrayList<Cliente> listar() {
        return clientes;
    }


}