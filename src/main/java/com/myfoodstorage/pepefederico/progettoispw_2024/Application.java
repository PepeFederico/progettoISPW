package com.myfoodstorage.pepefederico.progettoispw_2024;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Model;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage){
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
