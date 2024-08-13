package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;

import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.categoriaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo.gestioneProdottiA;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.CategoryNotFoundException;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class categoriaController implements Initializable {
    @FXML
    private GridPane gridPane;
    @FXML
    private Button nuovaCategoria;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button backView;
    private ArrayList<categoriaBean> categoria;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backView.setOnAction(actionEvent -> onBackView());

        gestioneProdottiA gestioneProdottiA = new gestioneProdottiA(clientController.getInstance().getSessioneUtente());
        if (gestioneProdottiA.checkSessione()) {
            try {
                gestioneProdottiA.recuperoInfoCategoria();
                categoria = gestioneProdottiA.getCatBean();
                setGrafica();
            } catch (CategoryNotFoundException e) {
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
            for (categoriaBean categoriaBean : categoria) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/myfoodstorage/pepefederico/progettoispw_2024/Item/itemCategoria.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                itemCategoriaController itemCategoriaController = fxmlLoader.getController();
                itemCategoriaController.setItemCategoria(categoriaBean);

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

    private void onBackView() {
        clientController.getInstance().backToDashboardView();
        Model.getInstance().getViewFactory().setCategoriaView();
    }

}