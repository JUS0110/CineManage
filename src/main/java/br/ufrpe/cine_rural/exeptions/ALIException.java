package br.ufrpe.cine_rural.exeptions;

import br.ufrpe.cine_rural.model.loja.Produto;

//AlreadyExistingItem
public class ALIException extends RuntimeException {
    private Produto produto;

    public ALIException(String message, Produto produto) {
        super(message);
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }
}