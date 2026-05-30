package br.ufrpe.cine_rural.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader loader1 = new FXMLLoader(
                Main.class.getResource("/br/ufrpe/cine_rural/gui/Assentos.fxml")
        );

        FXMLLoader loader2 = new FXMLLoader(
                Main.class.getResource("/br/ufrpe/cine_rural/gui/Filmes.fxml")
        );

        Stage stage1 = new Stage();
        stage1.setTitle("Assentos");
        stage1.setScene(new Scene(loader1.load()));

        Stage stage2 = new Stage();
        stage2.setTitle("Filmes");
        stage2.setScene(new Scene(loader2.load()));

        stage1.show();
        stage2.show();
    }

    public static void main(String[] args) {
        launch();
    }
}