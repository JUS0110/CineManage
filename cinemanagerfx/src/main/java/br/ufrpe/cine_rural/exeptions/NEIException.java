package br.ufrpe.cine_rural.exeptions;

import br.ufrpe.cine_rural.model.loja.Produto;

//NonExistentItem
public class NEIException extends RuntimeException {
    private Produto produto;

    public NEIException(String message, Produto produto) {
        super("Item Inexistente no Estoque");
        this.produto = null;
    }

    public Produto getProduto() {
        return produto;
    }
}