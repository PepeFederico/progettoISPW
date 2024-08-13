package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;

import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.dispensaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo.gestioneProdottiA;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.FoodStorageNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    @FXML
    private GridPane gridPane;
    @FXML
    private ScrollPane scrollPane;
    private ArrayList<dispensaBean> dispensa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gestioneProdottiA gestioneProdottiA = new gestioneProdottiA(clientController.getInstance().getSessioneUtente());
        if (gestioneProdottiA.checkSessione()) {
            try {
                gestioneProdottiA.recuperoInfoDispensa();
                dispensa = gestioneProdottiA.getDispBean();
                setGrafica();
            } catch (FoodStorageNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Attenzione!");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    private void setGrafica(){
        int colonna = 0, riga = 1;
        try {
            for (int i = 0; i < dispensa.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/myfoodstorage/pepefederico/progettoispw_2024/Item/itemDispensa.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                itemDispensaController itemController = fxmlLoader.getController();
                itemController.setItemDispensa(dispensa.get(i));

                if (colonna == 2) {
                    colonna = 0;
                    riga += 1;
                }
                gridPane.add(anchorPane, colonna++, riga);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
