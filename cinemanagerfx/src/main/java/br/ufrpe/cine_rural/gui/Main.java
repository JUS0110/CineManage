package br.ufrpe.cine_rural.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        Main.class.getResource("tela.fxml")
                );

        Scene scene = new Scene(
                loader.load()
        );

        stage.setTitle("Cinema Rural");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        FXMLLoader fxmlLoader =
                new FXMLLoader(
                        Main.class.getResource("Filmes.fxml")
                );

        Scene scene2 = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("Estilo.css").toExternalForm());

        stage.setScene(scene2);
        stage.show();
        stage.setScene(scene2);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}