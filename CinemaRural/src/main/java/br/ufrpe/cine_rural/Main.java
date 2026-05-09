package br.ufrpe.cine_rural;
import br.ufrpe.cine_rural.loja.Produto;
import br.ufrpe.cine_rural.loja.VendaLojinha;
import br.ufrpe.cine_rural.monitor.Cliente;
import br.ufrpe.cine_rural.monitor.Filme;
import br.ufrpe.cine_rural.monitor.HerancaSala.Comum;
import br.ufrpe.cine_rural.monitor.HerancaSala.Imax;
import br.ufrpe.cine_rural.monitor.HerancaSala.Sala;
import br.ufrpe.cine_rural.monitor.HerancaSala.Vip;
import br.ufrpe.cine_rural.monitor.Ingresso;
import br.ufrpe.cine_rural.monitor.Sessao;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // Criando produtos
        Produto p1 = new Produto(1, "Pipoca", 10.00, 50);
        Produto p2 = new Produto(2, "Refrigerante", 7.50, 30);
        Produto p3 = new Produto(3, "Chocolate", 5.00, 0); // sem estoque

        // Criando uma venda
        VendaLojinha venda = new VendaLojinha();

        // Teste 1: Adicionar itens normais
        System.out.println("=== Adicionando itens ===");
        venda.adicionarItem(p1, 2); // 2 pipocas
        venda.adicionarItem(p2, 3); // 3 refrigerantes

        // Teste 2: Tentar adicionar produto sem estoque
        System.out.println("\n=== Testando estoque vazio ===");
        try {
            venda.adicionarItem(p3, 1);
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // Teste 3: Remover quantidade parcial
        System.out.println("\n=== Removendo 1 refrigerante ===");
        venda.removerItem(p2, 1); // remove 1 dos 3

        // Teste 4: Remover item completamente
        System.out.println("\n=== Removendo todas as pipocas ===");
        venda.removerItem(p1, 10); // quantidade maior que o adicionado → remove tudo

        // Teste 5: Tentar remover produto que não está na venda
        System.out.println("\n=== Removendo produto não adicionado ===");
        venda.removerItem(p3, 1);

        // Teste 6: Finalizar venda
        System.out.println("\n=== Finalizando venda ===");
        venda.finalizarVenda();

        //Criando Salas
        Comum salaComum = new Comum(1, 100);
        Imax salaImax = new Imax(2, 50);
        Vip salaVip = new Vip(3, 20);

        //Criando Filme (teste 1)
        Filme filmeAcao = new Filme("Vingadores",
                "Herois que salvam o mundo",
                "Acao",
                12,
                LocalTime.of(2,30)
        );
        //Criando Filme (teste 2)
        Filme filmeDrama = new Filme(
                "O Poderoso Chefão",
                "Família mafiosa italiana",
                "Drama",
                16,
                LocalTime.of(2, 55)
        );

        //Criando Clientes (teste)

        Cliente clienteAdulto = new Cliente("Gededias God", "123.456.789-00", 69);
        Cliente clienteMenor = new Cliente ("Gededias God Jr.", "987-654-321-00", 14);

        //Criando Sessões (teste)

        Sessao sessaoAcao = new Sessao("Dublado",
                "Disponível",
                LocalDateTime.now(),
                filmeAcao,
                salaComum);
        Sessao sessaoDrama = new Sessao("Legendado",
                "Disponível",
                LocalDateTime.now().plusHours(3),
                filmeDrama,
                salaImax);

        // Criando Ingressos (teste)
        System.out.println("\n=== SISTEMA DO CINEMA ===");

        // Ingresso Adulto
        Ingresso ingresso1 = new Ingresso("A1", false, false, 50.0, clienteAdulto, sessaoAcao);
        sessaoAcao.adicionarIngressos(ingresso1);

        System.out.println("Ingresso criado: " + clienteAdulto.getNome() +
                " - Assento: " + ingresso1.getAssento() +
                " - Preço: R$" + ingresso1.getPreco());

        // Testar verificação de idade
        System.out.println("Gededias-Pai pode assistir? " + ingresso1.VerificarIdade(sessaoAcao, clienteAdulto, false));

        // Ingresso meia-entrada para menor com acompanhante (Caso Especial)
        Ingresso ingresso2 = new Ingresso("A2", true, true, 25.0, clienteMenor, sessaoAcao);
        ingresso2.setPreco(25.0, sessaoAcao, true); // Testando meia entrada
        sessaoAcao.adicionarIngressos(ingresso2);

        System.out.println("Junior (meia) pode assistir com acompanhante? " +
                ingresso2.VerificarIdade(sessaoAcao, clienteMenor, true));

        // Listar ingressos da sessão
        System.out.println("\n=== INGRESSOS DA SESSÃO ===");
        for (Ingresso i : sessaoAcao.getIngressos()) {
            System.out.println("- " + i.getCliente().getNome() +
                    " | " + i.getAssento() +
                    " | R$" + i.getPreco() +
                    " | Meia: " + i.getMeiaEntrada());
        }

        // Informações da sessão
        System.out.println("\n=== INFORMAÇÕES DA SESSÃO ===");
        System.out.println("Filme: " + sessaoAcao.getFilme().getTitulo());
        System.out.println("Sala: " + sessaoAcao.getSala().getId() +
                " (Preço base: R$" + sessaoAcao.getSala().getPreco() + ")");
        System.out.println("Total ingressos: " + sessaoAcao.getTotalIngressos());

        // Exibindo informações das salas
        System.out.println("\n=== SALAS DO CINEMA ===");
        exibirSala(salaComum);
        exibirSala(salaImax);
        exibirSala(salaVip);

        // Impressão de Salas teste usando Polimorfismo
        Sala[] salas = {salaComum, salaImax, salaVip};
        System.out.println("\n=== LISTA DE SALAS ===");
        for (Sala sala : salas) {
            System.out.println("Sala ID: " + sala.getId()
                    + " | Capacidade: " + sala.getCapacidade()
                    + " | Preço: R$" + sala.getPreco());
    }
}
    // Método para exibirSalas
    public static void exibirSala(Sala sala) {
        System.out.println("Tipo: " + sala.getClass().getSimpleName()
                + " | ID: " + sala.getId()
                + " | Capacidade: " + sala.getCapacidade()
                + " | Preço: R$" + sala.getPreco());
    }
}