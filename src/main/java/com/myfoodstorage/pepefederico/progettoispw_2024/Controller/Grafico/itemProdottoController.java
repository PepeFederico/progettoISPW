package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;

import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.prodottoBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class itemProdottoController {
    @FXML
    private ImageView iconaProdotto;
    @FXML
    private Label nomeProdotto;
    @FXML
    private Label scadenza;
    @FXML
    private Label scorte;
    @FXML
    private Label taglia;

    public void setItemProdotto(prodottoBean prodotto){
        nomeProdotto.setText(prodotto.getNomeProdotto());
        scadenza.setText(String.valueOf(prodotto.getScadenza()));
        scorte.setText(String.valueOf(prodotto.getScorte()));
        taglia.setText(String.valueOf(prodotto.getTaglia()));

        String nomeCategoria = clientController.getInstance().getCategoriaBean().getNomeCategoria();
        switch (nomeCategoria){
            case "Carne":
                switch (prodotto.getTipoAnimale()) {
                    case Manzo:
                        iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/cow.png"))));
                        break;
                    case Vitella:
                        iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/dinosaur.png"))));
                        break;
                    case Maiale:
                        iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/pig.png"))));
                        break;
                    case Pollo:
                        iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/hen.png"))));
                        break;
                    case Tacchino:
                        iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/turkey.png"))));
                        break;
                }
            break;

            case "Pesce":
                switch (prodotto.getTipoAnimale()) {
                    case Salmone:
                        iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/fish.png"))));
                        break;
                    case Tonno:
                        iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/tuna.png"))));
                        break;
                }
            break;

            case "Verdura":
                iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/vegetable.png"))));
                break;

            case "Frutta":
                iconaProdotto.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageProdotti/fruits.png"))));
                break;
        }
    }
}
