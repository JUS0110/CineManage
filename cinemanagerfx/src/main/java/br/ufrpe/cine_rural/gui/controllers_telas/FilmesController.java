package br.ufrpe.cine_rural.gui.controllers_telas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import br.ufrpe.cine_rural.model.Sessao;

public class FilmesController {

    @FXML
    private VBox containerFilmes;

    @FXML
    public void initialize() {
        Image poster1 = new Image(
                getClass().getResourceAsStream("Project_Hail_Mary_poster.jpg")
        );

        Image poster2 = new Image(
                getClass().getResourceAsStream("Odisseia.jpg")
        );

        Image poster3 = new Image(
                getClass().getResourceAsStream("Zootopia_2.jpg")
        );


        List<Sessao> sessoes = List.of(

                new Sessao(
                        poster1,
                        "Devoradores de Estrelas",
                        "14:30",
                        "VIP",
                        "14 Anos",
                        "2h10",
                        "Dublado"
                ),

                new Sessao(
                        poster2,
                        "A Odisseia",
                        "18:00",
                        "IMAX",
                        "16 Anos",
                        "2h30",
                        "Legendado"
                ),

                new Sessao(
                        poster3,
                        "Zootopia 2",
                        "20:00",
                        "Comum",
                        "Livre",
                        "1h30",
                        "Dublado"
                ),

                new Sessao(
                        poster3,
                        "Zootopia 2",
                        "18:00",
                        "Comum",
                        "Livre",
                        "1h30",
                        "Dublado"
                ),

                new Sessao(
                        poster3,
                        "Zootopia 2",
                        "20:00",
                        "IMAX",
                        "Livre",
                        "1h30",
                        "Dublado"
                ),

        new Sessao(
                poster3,
                "Zootopia 2",
                "10:00",
                "VIP",
                "Livre",
                "1h30",
                "Dublado"
        ),
                new Sessao(
                        poster3,
                        "A Odisseia",
                        "20:00",
                        "VIP",
                        "Livre",
                        "1h30",
                        "Dublado"
                )
        );

        Map<String, List<Sessao>> porFilme = new LinkedHashMap<>();

        for (Sessao s : sessoes) {porFilme.computeIfAbsent(s.getFilme(), k -> new ArrayList<>()).add(s);}

        for (List<Sessao> grupo : porFilme.values()) {
            criarCard(grupo);
        }
    }

    private void criarCard(List<Sessao> grupo) {

        Sessao sessao = grupo.get(0);

        HBox card = new HBox(15);

        VBox poster = new VBox();

        ImageView posterImage = new ImageView(sessao.getPoster());

        posterImage.setFitWidth(150);
        posterImage.setFitHeight(220);

        poster.getChildren().addAll(posterImage);

        VBox info = new VBox(5);

        Label titulo = new Label(sessao.getFilme());
        titulo.getStyleClass().add("titulo-filme");

        Label classificacao = new Label(sessao.getClassificacao());

        Label duracao = new Label(sessao.getDuracao());

        Label idioma = new Label(sessao.getIdioma());

        HBox horarios = new HBox(15);

        Map<String, HBox> salasMap = new LinkedHashMap<>();

        for (Sessao s : grupo) {

            if (!salasMap.containsKey(s.getSala())) {

                VBox blocoSessao = new VBox(5);

                Label sala = new Label(s.getSala());
                sala.getStyleClass().add("sala");


                HBox horariosSala = new HBox(5);

                blocoSessao.getChildren().addAll(sala, horariosSala);

                salasMap.put(s.getSala(), horariosSala);

                horarios.getChildren().add(blocoSessao);
            }

            Button horario = new Button(s.getHorario());

            salasMap.get(s.getSala()).getChildren().add(horario);
        }

        info.getChildren().addAll(titulo, classificacao, duracao, idioma, horarios);

        card.getChildren().addAll(poster, info);

        containerFilmes.getChildren().add(card);

    }

}