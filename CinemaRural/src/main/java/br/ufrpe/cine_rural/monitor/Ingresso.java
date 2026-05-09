package br.ufrpe.cine_rural.monitor;

public class Ingresso {
    private String assento;
    private boolean acompanhante;
    private boolean meiaEntrada;
    private double preco;

    private Sessao sessao;
    private Cliente cliente;

    public Ingresso (String assento, boolean acompanhante, boolean meiaEntrada, double preco, Cliente cliente, Sessao sessao){
        this.assento = assento;
        this.acompanhante = acompanhante;
        this.meiaEntrada = meiaEntrada;
        this.preco = preco;
        this.cliente = cliente;
        this.sessao = sessao;
    }



    //Verificar idade
    public boolean VerificarIdade(Sessao sessao,Cliente cliente, boolean acompanhante){
         boolean res = false;

        if(cliente.getIdade() > sessao.getFilme().getClassificaIndicativa() || acompanhante == true ){
           res = true;
        }

        return res;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public boolean getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(boolean acompanhante) {
        this.acompanhante = acompanhante;
    }

    public boolean getMeiaEntrada() {
        return meiaEntrada;
    }

    public void setMeiaEntrada(boolean meiaEntrada) {
        this.meiaEntrada = meiaEntrada;
    }

    public double getPreco() {
        return preco;
    }

    //alteração da compra
    public void setPreco(double preco,Sessao sessao, boolean meiaEntrada) {
        if (sessao.getSala().getPreco() == 1.0) {
            this.preco = preco * 1.0d;
        } else if (sessao.getSala().getPreco() == 2.0) {
            this.preco = preco * 2.0d;
        } else if (sessao.getSala().getPreco() == 3.0) {
            this.preco = preco * 3.0d;
        }

        if(meiaEntrada){
            this.preco = preco/2;
        }


    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
}
