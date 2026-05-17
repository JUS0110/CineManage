package main.java.br.ufrpe.cine_rural.dados.interfaces;

import main.java.br.ufrpe.cine_rural.model.beans.Cliente;
import java.util.ArrayList;

public interface iRepositorioCliente {

    void cadastrar(Cliente cliente);

    Cliente buscar(String cpf);

    void atualizar(Cliente cliente);

    void remover(String cpf);

    ArrayList<Cliente> listar();
}