package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.sessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Model;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Sessione;
public class profiloControllerA {
    sessioneBean sessioneBean;

    public profiloControllerA(sessioneBean sessioneBean) {
        this.sessioneBean = sessioneBean;
    }

    public boolean checkSessione(){
        for(Sessione sessione: Model.getInstance().getSessioniUtentiRistoratori()){
            if(sessione.getID_Sessione() == sessioneBean.getID_Sessione()){
                return true;
            }
        }
        return false;
    }
}
