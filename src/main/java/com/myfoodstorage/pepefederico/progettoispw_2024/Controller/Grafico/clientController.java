package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.categoriaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.dispensaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.sessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo.loginControllerA;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class clientController implements Initializable {
    public BorderPane client_parent;
    private sessioneBean sessioneUtente;
    private dispensaBean dispensaBean;
    private categoriaBean categoriaBean;
    private static  clientController clientController;

    public static synchronized clientController getInstance(){
        if(clientController == null){
            clientController = new clientController();
        }
        return clientController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((valoreOsservato, oldVal, newVal) -> {
            switch (newVal){
                case "profilo":
                    client_parent.setCenter(Model.getInstance().getViewFactory().getProfiloView());
                    break;

                case "logout":
                    loginControllerA loginControllerA = new loginControllerA();
                    loginControllerA.logout(sessioneUtente);

                    Stage stage = (Stage) client_parent.getScene().getWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().closeApplication();
                    Model.getInstance().getViewFactory().showLoginWindow();
                break;

                case "contratti":
                    client_parent.setCenter(Model.getInstance().getViewFactory().getContrattiView());
                break;

                default:
                    client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }

    public void setSessioneUtente(sessioneBean sessioneUtente) {
        this.sessioneUtente = sessioneUtente;
    }
    public void setDispensaBean(dispensaBean dispensaBean) {
        this.dispensaBean = dispensaBean;
    }
    public sessioneBean getSessioneUtente() {
        return sessioneUtente;
    }
    public dispensaBean getDispensaBean() {
        return dispensaBean;
    }
    public categoriaBean getCategoriaBean() {
        return categoriaBean;
    }
    public void setCategoriaBean(categoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }
    public void setClient_parent_Categoria() {
        client_parent.setCenter(Model.getInstance().getViewFactory().getCategoriaView());
    }
    public void setClient_parent_Prodotti(){
        client_parent.setCenter(Model.getInstance().getViewFactory().getProdottiView());
    }
    public void backToDashboardView() {
        client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
    }
    public void backToCategoriaView(){
        client_parent.setCenter(Model.getInstance().getViewFactory().getCategoriaView());
    }
}
