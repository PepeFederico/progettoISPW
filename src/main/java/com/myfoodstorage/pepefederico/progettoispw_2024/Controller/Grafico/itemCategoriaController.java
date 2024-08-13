package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;

import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.categoriaBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class itemCategoriaController {
    @FXML
    private Label nomeCategoria;
    @FXML
    private ImageView iconaCategoria;
    private final categoriaBean categoriaBean = new categoriaBean();

    public void setItemCategoria(categoriaBean categoria){
        nomeCategoria.setText(categoria.getNomeCategoria());
        switch (categoria.getNomeCategoria()){
            case "Carne":
                iconaCategoria.setImage(new Image(String.valueOf(getClass().getResource("/Image/imageCategoria/meat.png"))));
            break;
            case "Pesce":
                iconaCategoria.setImage(new Image(String.valueOf(getClass().getResource("/Image/imageCategoria/fish.png"))));
            break;
            case "Verdura":
                iconaCategoria.setImage(new Image(String.valueOf(getClass().getResource("/Image/imageCategoria/vegetable.png"))));
            break;
            case "Frutta":
                iconaCategoria.setImage(new Image(String.valueOf(getClass().getResource("/Image/imageCategoria/fruits.png"))));
            break;
            case "Formaggio":
                iconaCategoria.setImage(new Image(String.valueOf(getClass().getResource("/Image/imageCategoria/cheese.png"))));
            break;
        }
    }

    public void richiestaProdotti(){
        categoriaBean.setNomeCategoria(nomeCategoria.getText());
        clientController.getInstance().setCategoriaBean(categoriaBean);
        clientController.getInstance().setClient_parent_Prodotti();
    }
}
