package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico;

import java.net.URL;
import java.util.ResourceBundle;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Model;
import javafx.fxml.FXML;
import com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo.loginControllerA;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.utenteLoginBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.UserNotFoundException;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController implements Initializable {
    @FXML
    private TextField email_inputField;
    @FXML
    private Label error_label;
    @FXML
    private Button login_button;
    @FXML
    private PasswordField password_inputField;
    utenteLoginBean utente;
    loginControllerA controller;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_button.setOnAction(actionEvent -> onLogin());
    }
    private void onLogin(){
        utente = new utenteLoginBean();
        String email = email_inputField.getText();
        String password = password_inputField.getText();

        if((!email.isEmpty() && !password.isEmpty())){
            if(utente.mailSyntaxCheck(email)){
                try {
                    utente.setEmail(email);
                    utente.setPassword(password);
                    controller = new loginControllerA(utente);
                    controller.autenticazioneUtente();

                    Stage stage = (Stage) error_label.getScene().getWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                }catch (UserNotFoundException e) {
                    error_label.setVisible(true);
                    error_label.setText(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                error_label.setVisible(true);
                error_label.setText("Errore : Email non conforme. Riprova!!");
            }
        }else{
            error_label.setVisible(true);
            error_label.setText("Errore : Input non conforme. Controlla i campi");
        }
    }
}




