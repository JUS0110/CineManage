package main.java.br.ufrpe.cine_rural.model.beans;

import main.java.br.ufrpe.cine_rural.enums.TipoAssento;

public class Assento {
    private String codigo;
    private TipoAssento status;
    private int frequenciaOcupacao;

    public Assento(String codigo) {
        this.codigo = codigo;
        this.status = TipoAssento.LIVRE;
        this.frequenciaOcupacao = 0;
    }



    public String getCodigo() {
        return codigo;
    }

    public TipoAssento getStatus() {
        return status;
    }

    public void ocupar() {
        status = TipoAssento.OCUPADO;
        frequenciaOcupacao++;
    }

    public void liberar() {
        status = TipoAssento.LIVRE;
    }

    public int getFrequenciaOcupacao() {
        return frequenciaOcupacao;
    }
}
