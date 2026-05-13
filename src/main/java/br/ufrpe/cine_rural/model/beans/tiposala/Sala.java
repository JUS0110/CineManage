package main.java.br.ufrpe.cine_rural.model.beans.tiposala;

public abstract class Sala {
    protected int id;
    protected int capacidade;
    protected double preco;

    public Sala(int id, int capacidade, double preco){
        this.id = id;
        this.capacidade = capacidade;
        this.preco = preco;

    }

    public int getId() {
        return id;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public double getPreco() {
        return preco;
    }
}
