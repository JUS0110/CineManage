package br.ufrpe.cine_rural.gui.controllers_telas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IngressoController {

    @FXML
    private Button btnEmissaoIngresso;

    public IngressoController() {
    }

    public Button getBtnEmissaoIngresso() {
        return btnEmissaoIngresso;
    }

    public void setBtnEmissaoIngresso(Button btnEmissaoIngresso) {
        this.btnEmissaoIngresso = btnEmissaoIngresso;
    }

    @FXML
    public void btnEmissaoIngressoImprimir(){
        System.out.println("Botao foi clicado");

    }


}
