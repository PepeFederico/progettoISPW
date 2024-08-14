package com.myfoodstorage.pepefederico.progettoispw_2024.controller.grafico;
import com.myfoodstorage.pepefederico.progettoispw_2024.bean.CategoriaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.bean.DispensaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.bean.SessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.controller.applicativo.LoginControllerA;
import com.myfoodstorage.pepefederico.progettoispw_2024.model.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane clientParent;
    private SessioneBean sessioneUtente;
    private DispensaBean dispensaBean;
    private CategoriaBean categoriaBean;
    private static ClientController clientController;

    private ClientController() {}

    public static synchronized ClientController getInstance(){
        if(clientController == null){
            clientController = new ClientController();
        }
        return clientController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((valoreOsservato, oldVal, newVal) -> {
            switch (newVal){
                case "profilo":
                    clientParent.setCenter(Model.getInstance().getViewFactory().getProfiloView());
                    break;

                case "logout":
                    LoginControllerA loginControllerA = new LoginControllerA();
                    loginControllerA.logout(sessioneUtente);

                    Stage stage = (Stage) clientParent.getScene().getWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().closeApplication();
                    Model.getInstance().getViewFactory().showLoginWindow();
                break;

                case "contratti":
                    clientParent.setCenter(Model.getInstance().getViewFactory().getContrattiView());
                break;

                default:
                    clientParent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }

    public void setSessioneUtente(SessioneBean sessioneUtente) {
        this.sessioneUtente = sessioneUtente;
    }
    public void setDispensaBean(DispensaBean dispensaBean) {
        this.dispensaBean = dispensaBean;
    }
    public SessioneBean getSessioneUtente() {
        return sessioneUtente;
    }
    public DispensaBean getDispensaBean() {
        return dispensaBean;
    }
    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }
    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }
    public void setClientParentCategoria() {
        clientParent.setCenter(Model.getInstance().getViewFactory().getCategoriaView());
    }
    public void setClientParentProdotti(){
        clientParent.setCenter(Model.getInstance().getViewFactory().getProdottiView());
    }
    public void backToDashboardView() {
        clientParent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
    }
    public void backToCategoriaView(){
        clientParent.setCenter(Model.getInstance().getViewFactory().getCategoriaView());
    }
}
