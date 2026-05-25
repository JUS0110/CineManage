package br.ufrpe.cine_rural.exeptions;

import br.ufrpe.cine_rural.model.Assento;
import br.ufrpe.cine_rural.model.loja.Produto;
import br.ufrpe.cine_rural.model.tiposala.Sala;

//AlreadyFullRoom
public class AFRException extends RuntimeException {
    private Sala sala;

    public AFRException(String message, Sala sala) {
        super("Esta sala ja esta cheia");
        this.sala = sala;
    }

    public Sala getSala() {
        return sala;
    }
}