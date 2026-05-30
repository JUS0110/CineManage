package br.ufrpe.cine_rural.gui.controllers_telas;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.List;

public class IngressoController {

    @FXML
    private Button btnEmissaoIngresso;
    private String tituloFilme;
    private String horario;
    private List<String> assentosSelecionados;
    private String tipoSala;

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public void setAssentosSelecionados(List<String> assentos) {
        this.assentosSelecionados = assentos;
    }
    public void setTipoSala(String tipoSala){
        this.tipoSala = tipoSala;
    }

    @FXML
    private void btnEmissaoIngressoImprimir() {

        if (assentosSelecionados == null || assentosSelecionados.isEmpty()) {
            Alert erro = new Alert(Alert.AlertType.WARNING);
            erro.setTitle("Atenção");
            erro.setHeaderText("Nenhum assento selecionado");
            erro.setContentText("Por favor, selecione pelo menos um assento antes de emitir o ingresso.");
            erro.showAndWait();
            return;
        }

        int qtdIngressos = assentosSelecionados.size();

        String listaAssentos = String.join(", ", assentosSelecionados);

        String linhaQuantidade = qtdIngressos == 1
                ? "Quantidade de ingressos: 1 ingresso"
                : "Quantidade de ingressos: " + qtdIngressos + " ingressos";

        String linhaAssentos = qtdIngressos == 1
                ? "Assento selecionado: " + listaAssentos
                : "Assentos selecionados: " + listaAssentos;

        String horarioFormatado = horario != null ? horario : "—";

        String conteudo = String.format(
                """
                Filme: %s
                Sessão: %s
                Sala: %s
                %s
                %s
                """,
                tituloFilme != null ? tituloFilme : "—",
                horario     != null ? horario     : "—",
                tipoSala    != null ? tipoSala    : "—",
                linhaAssentos,
                linhaQuantidade
        );

        Alert alert = new Alert(Alert.AlertType.INFORMATION, conteudo, ButtonType.OK);
        alert.setTitle("Emissão de Ingresso");
        alert.setHeaderText("Resumo do(s) Ingresso(s)");
        
        alert.getDialogPane().setMinHeight(javafx.scene.layout.Region.USE_PREF_SIZE);

        alert.showAndWait();
    }
}
