package main.java.br.ufrpe.cine_rural;

import main.java.br.ufrpe.cine_rural.enums.*;

import main.java.br.ufrpe.cine_rural.model.beans.loja.Produto;
import main.java.br.ufrpe.cine_rural.model.beans.loja.VendaLojinha;

import main.java.br.ufrpe.cine_rural.model.beans.Assento;
import main.java.br.ufrpe.cine_rural.model.beans.Cliente;
import main.java.br.ufrpe.cine_rural.model.beans.Filme;
import main.java.br.ufrpe.cine_rural.model.beans.Ingresso;
import main.java.br.ufrpe.cine_rural.model.beans.Sessao;

import main.java.br.ufrpe.cine_rural.model.beans.tiposala.Comum;
import main.java.br.ufrpe.cine_rural.model.beans.tiposala.Imax;
import main.java.br.ufrpe.cine_rural.model.beans.tiposala.Sala;
import main.java.br.ufrpe.cine_rural.model.beans.tiposala.Vip;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // PRODUTOS

        Produto p1 = new Produto(1, "Pipoca", 10.00, 50);
        Produto p2 = new Produto(2, "Refrigerante", 7.50, 30);
        Produto p3 = new Produto(3, "Chocolate", 5.00, 0);

        // VENDA LOJINHA

        VendaLojinha venda = new VendaLojinha();

        System.out.println("=== ADICIONANDO ITENS ===");

        venda.adicionarItem(p1, 2);
        venda.adicionarItem(p2, 3);

        // TESTE ESTOQUE

        System.out.println("\n=== TESTANDO ESTOQUE ===");

        try {

            venda.adicionarItem(p3, 1);

        } catch (RuntimeException e) {

            System.out.println(
                    "Erro esperado: "
                            + e.getMessage()
            );
        }

        // REMOVENDO ITEM

        System.out.println("\n=== REMOVENDO REFRIGERANTE ===");

        venda.removerItem(p2, 1);

        System.out.println("\n=== REMOVENDO PIPOCA ===");

        venda.removerItem(p1, 10);

        // FINALIZANDO VENDA

        System.out.println("\n=== FINALIZANDO VENDA ===");

        venda.finalizarVenda();

        // SALAS

        Comum salaComum = new Comum(1, 100);
        Imax salaImax = new Imax(2, 50);
        Vip salaVip = new Vip(3, 20);

        // FILMES

        Filme filmeAcao = new Filme(
                "Vingadores",
                "Herois que salvam o mundo",
                Genero.ACAO,
                ClassificacaoIndicativa.DOZE,
                LocalTime.of(2, 30)
        );

        Filme filmeDrama = new Filme(
                "O Poderoso Chefao",
                "Familia mafiosa italiana",
                Genero.DRAMA,
                ClassificacaoIndicativa.DEZESSEIS,
                LocalTime.of(2, 55)
        );

        // CLIENTES

        Cliente clienteAdulto = new Cliente(
                "Gededias God",
                "123.456.789-00",
                69
        );

        Cliente clienteMenor = new Cliente(
                "Gededias God Jr.",
                "987-654-321-00",
                14
        );

        // SESSOES

        Sessao sessaoAcao = new Sessao(
                Idioma.DUBLADO,
                StatusSessao.ABERTA,
                LocalDateTime.now(),
                filmeAcao,
                salaComum
        );

        Sessao sessaoDrama = new Sessao(
                Idioma.LEGENDADO,
                StatusSessao.ABERTA,
                LocalDateTime.now().plusHours(3),
                filmeDrama,
                salaImax
        );

        // INGRESSOS

        System.out.println("\n=== SISTEMA DO CINEMA ===");

        Assento assento1 = new Assento("A1");

        Ingresso ingresso1 = new Ingresso(
                sessaoAcao,
                assento1,
                50.0,
                CategoriaMeiaEntrada.INTEIRA
        );

        ingresso1.setCliente(clienteAdulto);

        sessaoAcao.adicionarIngressos(ingresso1);

        System.out.println(
                "Ingresso criado: "
                        + clienteAdulto.getNome()
                        + " - Assento: "
                        + ingresso1.getAssento().getCodigo()
                        + " - Preco: R$"
                        + ingresso1.getPreco()
        );

        // VERIFICACAO IDADE

        System.out.println(
                "Gededias-Pai pode assistir? "
                        + clienteAdulto.podeAssistir(
                        sessaoAcao.getFilme(),
                        false
                )
        );

        // MEIA ENTRADA TESTE

        Assento assento2 = new Assento("A2");

        Ingresso ingresso2 = new Ingresso(
                sessaoAcao,
                assento2,
                50.0,
                CategoriaMeiaEntrada.ESTUDANTE
        );

        ingresso2.setCliente(clienteMenor);

        sessaoAcao.adicionarIngressos(ingresso2);

        System.out.println(
                "Junior pode assistir com acompanhante? "
                        + clienteMenor.podeAssistir(
                        sessaoAcao.getFilme(),
                        true
                )
        );

        // LISTAR INGRESSOS

        System.out.println("\n=== INGRESSOS DA SESSAO ===");

        for (Ingresso i : sessaoAcao.getIngressos()) {

            System.out.println(
                    "- "
                            + i.getCliente().getNome()
                            + " | "
                            + i.getAssento().getCodigo()
                            + " | R$"
                            + i.getPreco()
                            + " | Categoria: "
                            + i.getCategoria()
            );
        }

        // INFORMACOES DA SESSAO

        System.out.println("\n=== INFORMACOES DA SESSAO ===");

        System.out.println(
                "Filme: "
                        + sessaoAcao.getFilme().getTitulo()
        );

        System.out.println(
                "Genero: "
                        + sessaoAcao.getFilme().getGenero()
        );

        System.out.println(
                "Classificacao: "
                        + sessaoAcao.getFilme().getClassificacao()
        );

        System.out.println(
                "Idioma: "
                        + sessaoAcao.getIdioma()
        );

        System.out.println(
                "Status: "
                        + sessaoAcao.getStatus()
        );

        System.out.println(
                "Sala: "
                        + sessaoAcao.getSala().getId()
                        + " (Preco base: R$"
                        + sessaoAcao.getSala().getPreco()
                        + ")"
        );

        System.out.println(
                "Total ingressos: "
                        + sessaoAcao.getTotalIngressos()
        );

        // SALAS

        System.out.println("\n=== SALAS DO CINEMA ===");

        exibirSala(salaComum);
        exibirSala(salaImax);
        exibirSala(salaVip);

        // POLIMORFISMO

        Sala[] salas = {
                salaComum,
                salaImax,
                salaVip
        };

        System.out.println("\n=== LISTA DE SALAS ===");

        for (Sala sala : salas) {

            System.out.println(
                    "Sala ID: "
                            + sala.getId()
                            + " | Capacidade: "
                            + sala.getCapacidade()
                            + " | Preco: R$"
                            + sala.getPreco()
            );
        }
    }

    // EXIBIR SALAS

    public static void exibirSala(Sala sala) {

        System.out.println(
                "Tipo: "
                        + sala.getClass().getSimpleName()
                        + " | ID: "
                        + sala.getId()
                        + " | Capacidade: "
                        + sala.getCapacidade()
                        + " | Preco: R$"
                        + sala.getPreco()
        );
    }
}