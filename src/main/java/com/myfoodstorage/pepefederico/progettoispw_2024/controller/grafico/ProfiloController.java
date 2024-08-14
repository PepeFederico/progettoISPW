package com.myfoodstorage.pepefederico.progettoispw_2024.controller.grafico;
import com.myfoodstorage.pepefederico.progettoispw_2024.bean.SessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.controller.applicativo.ProfiloControllerA;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfiloController implements Initializable{
    @FXML
    private Label labelCap;
    @FXML
    private Label labelCittaAttivita;
    @FXML
    private Label labelCivicoAttivita;
    @FXML
    private Label labelCognomeUtente;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelPartitaIva;
    @FXML
    private Label labelPassword;
    @FXML
    private Label labelTelefono;
    @FXML
    private Label labelViaAttivita;
    @FXML
    private Label labelNomeAttivita;
    @FXML
    private Label labelNomeUtente;
    @FXML
    private Label labelTipoUtente;
    private SessioneBean sessioneBean;

    public void setInfoGrafica(){
        labelTipoUtente.setText         (sessioneBean.getUtente().getTipoUtente());
        labelEmail.setText              (sessioneBean.getUtente().getEmail());
        labelPassword.setText           (sessioneBean.getUtente().getPassword());
        labelNomeUtente.setText         (sessioneBean.getUtente().getNome());
        labelCognomeUtente.setText      (sessioneBean.getUtente().getCognome());
        labelPartitaIva.setText         (sessioneBean.getUtente().getPartitaIva());
        labelViaAttivita.setText        (sessioneBean.getUtente().getViaAttivita());
        labelCivicoAttivita.setText     (String.valueOf(sessioneBean.getUtente().getNumeroCivico()));
        labelCittaAttivita.setText      (sessioneBean.getUtente().getCitta());
        labelCap.setText                (sessioneBean.getUtente().getCap());
        labelNomeAttivita.setText       (sessioneBean.getUtente().getNomeAttivita());
        labelTelefono.setText           (sessioneBean.getUtente().getNumeroTelefono());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProfiloControllerA profiloControllerA = new ProfiloControllerA(ClientController.getInstance().getSessioneUtente());
        if(profiloControllerA.checkSessione()){
            sessioneBean = ClientController.getInstance().getSessioneUtente();
            setInfoGrafica();
        }
    }
}
