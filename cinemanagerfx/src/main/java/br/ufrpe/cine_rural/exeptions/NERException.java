package br.ufrpe.cine_rural.exeptions;

import br.ufrpe.cine_rural.model.Filme;
import br.ufrpe.cine_rural.model.tiposala.Sala;

//NonExistingRoom
public class NERException extends RuntimeException {
    private Sala sala;

    public NERException(String message, Sala sala) {
        super("Sala inexistente");
        this.sala = null;
    }

    public Sala getSala() {
        return sala;
    }
}