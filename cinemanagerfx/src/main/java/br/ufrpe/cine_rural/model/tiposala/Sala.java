package br.ufrpe.cine_rural.model.tiposala;

public class Sala {
    protected int id;
    protected int capacidade;
    protected double preco;
    public Sala(int id, int capacidade, double preco){
        this.id = id;
        this.capacidade = capacidade;
        this.preco = preco;

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (Sala " + id + ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}