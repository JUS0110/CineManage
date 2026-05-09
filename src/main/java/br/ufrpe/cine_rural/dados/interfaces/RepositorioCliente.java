package br.ufrpe.cine_rural.dados.interfaces;

import br.ufrpe.cine_rural.negocio.beans.Cliente;
import java.util.ArrayList;

public interface RepositorioCliente {

    void cadastrar(Cliente cliente);

    Cliente buscar(String cpf);

    void atualizar(Cliente cliente);

    void remover(String cpf);

    ArrayList<Cliente> listar();
}