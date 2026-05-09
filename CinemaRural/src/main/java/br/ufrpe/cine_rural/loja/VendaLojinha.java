package br.ufrpe.cine_rural.loja;

import java.util.ArrayList;
import java.util.List;
 
public class VendaLojinha {
 
    private final List<ItemVenda> itens;
 
    public VendaLojinha() {
        this.itens = new ArrayList<>();
    }
 
 
    public void adicionarItem(Produto produto, int quantidade) {
        verificarEstoque(produto);
        ItemVenda NovoItem = new ItemVenda(quantidade, produto);
        itens.add(NovoItem);
        produto.reduzirEstoque(quantidade);
    }

    public void removerItem(Produto produto, int quantidade) {  
        for (ItemVenda i: itens)
        {
            if (i.getProduto() == produto)
            {
                if(quantidade >= i.getQuantidade())
                {
                    itens.remove(i);
                    produto.aumentarEstoque(i.getQuantidade());
                    System.out.println("Item removido completamente: " + produto.getNome());
                }
                else
                {
                    i.setQuantidade(i.getQuantidade() - quantidade);
                    produto.aumentarEstoque(quantidade);
                    System.out.println("Quantidade reduzida: " + produto.getNome() + " x" + i.getQuantidade());

                }
                return;
            }
        }
        System.out.println("Produto não encontrado na venda.");
    }
    
    public void verificarEstoque(Produto produto) {
        if (produto.getQtdEstoque() <= 0)
        {
            throw new RuntimeException("Estoque insuficiente para: " + produto.getNome());
        }
    }
 
    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda i: itens){
            total += i.getSubtotal();
        }
        return total;
    }
 
    public void finalizarVenda() {
         for (ItemVenda i : itens) {
            System.out.println("- " + i.getProduto().getNome()
                + " x" + i.getQuantidade()
                + " = R$ " + i.getSubtotal());
        }
        System.out.println("TOTAL: R$ " + calcularTotal());
    }
}