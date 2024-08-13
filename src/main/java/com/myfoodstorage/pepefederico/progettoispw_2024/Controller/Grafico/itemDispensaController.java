package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.dispensaBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class itemDispensaController {
    @FXML
    private Label nomeDispensa;
    @FXML
    private ImageView iconaDispensa;
    private dispensaBean dispensaBean = new dispensaBean();

    public void setItemDispensa(dispensaBean dispensa){
        nomeDispensa.setText(dispensa.getNomeDispensa());
        switch (dispensa.getNomeDispensa()){
            case "Frigorifero":
                iconaDispensa.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageDispensa/fridge.png"))));
            break;
            case "Congelatore":
                iconaDispensa.setImage(new Image(String.valueOf(getClass().getResource("/Image/ImageDispensa/freezer.png"))));
            break;
        }
    }

    public void richiestaCategorie() {
        dispensaBean.setNomeDispensa(nomeDispensa.getText());
        clientController.getInstance().setDispensaBean(dispensaBean);
        clientController.getInstance().setClient_parent_Categoria();
    }
}
