package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.sessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo.profiloControllerA;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class profiloController implements Initializable{
    @FXML
    private Label LabelCap;
    @FXML
    private Label LabelCittaAttivita;
    @FXML
    private Label LabelCivicoAttivita;
    @FXML
    private Label LabelCognomeUtente;
    @FXML
    private Label LabelEmail;
    @FXML
    private Label LabelPartitaIVA;
    @FXML
    private Label LabelPassword;
    @FXML
    private Label LabelTelefono;
    @FXML
    private Label LabelViaAttivita;
    @FXML
    private Label labelNomeAttivita;
    @FXML
    private Label labelNomeUtente;
    @FXML
    private Label labelTipoUtente;
    private sessioneBean sessioneBean;
    profiloControllerA profiloControllerA;

    public void setInfoGrafica(){
        labelTipoUtente.setText         (sessioneBean.getUtente().getTipoUtente());
        LabelEmail.setText              (sessioneBean.getUtente().getEmail());
        LabelPassword.setText           (sessioneBean.getUtente().getPassword());
        labelNomeUtente.setText         (sessioneBean.getUtente().getNome());
        LabelCognomeUtente.setText      (sessioneBean.getUtente().getCognome());
        LabelPartitaIVA.setText         (sessioneBean.getUtente().getPartitaIVA());
        LabelViaAttivita.setText        (sessioneBean.getUtente().getViaAttivita());
        LabelCivicoAttivita.setText     (String.valueOf(sessioneBean.getUtente().getNumeroCivico()));
        LabelCittaAttivita.setText      (sessioneBean.getUtente().getCitta());
        LabelCap.setText                (sessioneBean.getUtente().getCAP());
        labelNomeAttivita.setText       (sessioneBean.getUtente().getNomeAttivita());
        LabelTelefono.setText           (sessioneBean.getUtente().getNumeroTelefono());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profiloControllerA = new profiloControllerA(clientController.getInstance().getSessioneUtente());
        if(profiloControllerA.checkSessione()){
            sessioneBean = clientController.getInstance().getSessioneUtente();
            setInfoGrafica();
        }
    }
}
