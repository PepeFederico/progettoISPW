module com.myfoodstorage.pepefederico.progettoispw_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.myfoodstorage.pepefederico.progettoispw_2024 to javafx.fxml;
    exports com.myfoodstorage.pepefederico.progettoispw_2024;
    exports com.myfoodstorage.pepefederico.progettoispw_2024.controller.grafico;
    opens com.myfoodstorage.pepefederico.progettoispw_2024.controller.grafico to javafx.fxml;
}