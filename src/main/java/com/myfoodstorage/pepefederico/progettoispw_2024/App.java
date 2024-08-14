package com.myfoodstorage.pepefederico.progettoispw_2024;
import com.myfoodstorage.pepefederico.progettoispw_2024.model.Model;
import javafx.stage.Stage;

public class App extends javafx.application.Application {
    @Override
    public void start(Stage stage){
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
