package br.ufrpe.cine_rural.gui.controllers_telas;

import br.ufrpe.cine_rural.gui.models_telas.SalasMapas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

public class AssentoController {

    @FXML
    private AnchorPane painel;

    private int heranca = 3;

    private boolean[][] layoutAtual;

    @FXML
    public void initialize() {

        switch (heranca) {

            case 1 -> layoutAtual = SalasMapas.salaComum;

            case 2 -> layoutAtual = SalasMapas.salaImax;

            case 3 -> layoutAtual = SalasMapas.salaVip;

            default -> layoutAtual = SalasMapas.salaComum;
        }

        gerarAssentos();
    }

    private void gerarAssentos() {

        int tamanho = layoutAtual.length;

        double areaX = 40;
        double areaY = 90;

        double areaLargura = 620;
        double areaAltura = 340;

        double espacamento = 5;

        double larguraBotao =
                (areaLargura - ((tamanho - 1) * espacamento))
                        / tamanho;

        double alturaBotao =
                (areaAltura - ((tamanho - 1) * espacamento))
                        / tamanho;

        for (int i = 0; i < tamanho; i++) {

            for (int j = 0; j < layoutAtual[i].length; j++) {

                if (!layoutAtual[i][j]) {
                    continue;
                }

                Button botao = new Button();

                botao.setPrefSize(
                        larguraBotao,
                        alturaBotao
                );

                botao.setLayoutX(
                        areaX + j * (larguraBotao + espacamento)
                );

                botao.setLayoutY(
                        areaY + i * (alturaBotao + espacamento)
                );

                botao.setText(
                        (char)('A' + i) + "" + (j + 1)
                );

                String verde =
                        "-fx-background-color: #00c853;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-weight: bold;";

                String azul =
                        "-fx-background-color: #2962ff;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-weight: bold;";

                botao.setStyle(verde);

                botao.setOnMouseClicked(event -> {

                    if (event.getButton() == MouseButton.PRIMARY) {

                        botao.setStyle(azul);
                    }

                    if (event.getButton() == MouseButton.SECONDARY) {

                        botao.setStyle(verde);
                    }
                });

                painel.getChildren().add(botao);
            }
        }
    }
}