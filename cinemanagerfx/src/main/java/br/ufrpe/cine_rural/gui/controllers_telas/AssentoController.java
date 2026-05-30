package br.ufrpe.cine_rural.gui.controllers_telas;

import br.ufrpe.cine_rural.enums.ClassificacaoIndicativa;
import br.ufrpe.cine_rural.enums.Idioma;
import br.ufrpe.cine_rural.gui.models_telas.SalasMapas;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssentoController {

    @FXML
    private AnchorPane painel;
    @FXML
    private Text textoSessaoInfo;
    @FXML
    private Text textoContador;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnIngressos;

    private List<String> nomeAssentosSelecionados = new ArrayList<>();

    // ── campos preenchidos pelo setDados ─────────────────────────
    private int heranca;
    private int numeroSessao;
    private String nomeSala;
    private String dataHorario;
    private Idioma idioma;
    private int duracao;
    private ClassificacaoIndicativa classificacao;
    private Image poster;
    private String tituloFilme;

    private int[][] layoutAtual;
    private int assentosSelecionados = 0;

    // ── chamado pelo FilmesController após load() ─────────────────
    public void setDados(int heranca,
                         int numeroSessao,
                         String nomeSala,
                         String dataHorario,
                         Idioma idioma,
                         int duracao,
                         ClassificacaoIndicativa classificacao,
                         Image poster,
                         String tituloFilme) {

        this.heranca = heranca;
        this.numeroSessao  = numeroSessao;
        this.nomeSala = nomeSala;
        this.dataHorario = dataHorario;
        this.idioma = idioma;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.poster = poster;
        this.tituloFilme = tituloFilme;

        switch (heranca) {
            case 1 -> layoutAtual = SalasMapas.copiar(SalasMapas.salaComum);
            case 2 -> layoutAtual = SalasMapas.copiar(SalasMapas.salaImax);
            case 3 -> layoutAtual = SalasMapas.copiar(SalasMapas.salaVip);
            default -> layoutAtual = SalasMapas.copiar(SalasMapas.salaComum);
        }

        textoSessaoInfo.setText(
                "Cinema Rural — Sessão " + numeroSessao
                        + " | " + nomeSala
                        + " | " + dataHorario
        );

        textoContador.setText("N. de cadeiras selecionadas  x00 Ingressos");

        ocuparAssentosAleatorios();
        gerarAssentos();
        exibirPoster();
        configurarBotaoVoltar();
        configurarBotaoIngressos();
    }

    private void exibirPoster() {
        ImageView posterView = new ImageView(poster);
        posterView.setFitWidth(210);
        posterView.setFitHeight(280);
        posterView.setLayoutX(685);
        posterView.setLayoutY(65);
        painel.getChildren().add(posterView);
    }

    private void configurarBotaoVoltar() {

        Platform.runLater(() -> {

            Button btnVoltar = (Button) painel.lookup(".botao-vermelho");

            if (btnVoltar != null) {
                btnVoltar.setOnAction(event -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(
                                getClass().getResource("/br/ufrpe/cine_rural/gui/Filmes.fxml")
                        );

                        Scene scene = new Scene(loader.load());
                        scene.getStylesheets().add(
                                getClass().getResource("/br/ufrpe/cine_rural/gui/EstiloFilmes.css")
                                        .toExternalForm()
                        );

                        Stage stageAtual = (Stage) painel.getScene().getWindow();
                        stageAtual.setTitle("Filmes");
                        stageAtual.setScene(scene);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }

    private void configurarBotaoIngressos() {
        btnIngressos.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/br/ufrpe/cine_rural/gui/EmissaoIngresso.fxml")
                );
                Scene scene = new Scene(loader.load());
                scene.getStylesheets().add(
                        getClass().getResource("/br/ufrpe/cine_rural/gui/EstiloIngresso.css")
                                .toExternalForm()
                );

                IngressoController ic = loader.getController();
                ic.setAssentosSelecionados(nomeAssentosSelecionados);
                ic.setTipoSala(nomeSala);

                Stage stageAtual = (Stage) painel.getScene().getWindow();
                stageAtual.setTitle("Ingresso");
                stageAtual.setScene(scene);

                ic.setTituloFilme(tituloFilme);
                ic.setHorario(dataHorario);
                ic.setAssentosSelecionados(nomeAssentosSelecionados);
                ic.setTipoSala(nomeSala);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private void ocuparAssentosAleatorios() {
        Random random = new Random();
        int totalAssentos = 0;

        for (int[] linha : layoutAtual) {
            for (int assento : linha) {
                if (assento == 1) totalAssentos++;  // só conta livres
            }
        }

        int quantidade = (int)(totalAssentos * (0.1 + random.nextDouble() * 0.2));

        int ocupados = 0;
        while (ocupados < quantidade) {
            int i = random.nextInt(layoutAtual.length);
            int j = random.nextInt(layoutAtual[i].length);

            if (layoutAtual[i][j] == 1) {   // só marca se for livre
                layoutAtual[i][j] = 2;      // 2 = ocupado
                ocupados++;
            }
        }
    }

    @FXML
    public void initialize() {

    }

    private void gerarAssentos() {

        int tamanho = layoutAtual.length;

        double areaX = 40 ;
        double areaY = 90;
        double areaLargura = 620;
        double areaAltura = 340;
        double espacamento = 5;

        double larguraBotao = (areaLargura - ((tamanho - 1) * espacamento)) / tamanho;
        double alturaBotao  = (areaAltura  - ((tamanho - 1) * espacamento)) / tamanho;

        String verde    = "-fx-background-color: #00c853; -fx-text-fill: white; -fx-font-weight: bold;";
        String azul     = "-fx-background-color: #2962ff; -fx-text-fill: white; -fx-font-weight: bold;";
        String vermelho = "-fx-background-color: #fc4949; -fx-text-fill: white; -fx-font-weight: bold;";


        for (int i = 0; i < layoutAtual.length; i++) {
            for (int j = 0; j < layoutAtual[i].length; j++) {

                if (layoutAtual[i][j] == 0) continue;

                boolean estaOcupado = layoutAtual[i][j] == 2;

                Button botao = new Button((char)('A' + i) + "" + (j + 1));
                botao.setPrefSize(larguraBotao, alturaBotao);
                botao.setLayoutX(areaX + j * (larguraBotao + espacamento));
                botao.setLayoutY(areaY + i * (alturaBotao  + espacamento));
                botao.setStyle(estaOcupado ? vermelho : verde);

                botao.setOnAction(event -> {
                    if (estaOcupado) return;

                    boolean estaSelecionado = botao.getStyle().equals(azul);

                    if (estaSelecionado) {
                        botao.setStyle(verde);
                        assentosSelecionados--;
                        nomeAssentosSelecionados.remove(botao.getText());
                    } else {
                        botao.setStyle(azul);
                        assentosSelecionados++;
                        nomeAssentosSelecionados.add(botao.getText());
                    }

                    textoContador.setText(
                            "N. de cadeiras selecionadas  x"
                                    + String.format("%02d", assentosSelecionados)
                                    + " Ingressos"
                    );
                });

                painel.getChildren().add(botao);
            }
        }
    }
}