package br.ufrpe.cine_rural.exeptions;

import br.ufrpe.cine_rural.model.Cliente;

//AlreadyExistingClient
public class AECException extends RuntimeException {
    private Cliente cliente;

    public AECException(String message,  Cliente cliente) {
        super(message);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}