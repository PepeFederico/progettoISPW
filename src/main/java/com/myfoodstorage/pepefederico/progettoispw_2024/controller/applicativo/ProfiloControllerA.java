package com.myfoodstorage.pepefederico.progettoispw_2024.controller.applicativo;
import com.myfoodstorage.pepefederico.progettoispw_2024.bean.SessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.model.Model;
import com.myfoodstorage.pepefederico.progettoispw_2024.model.Sessione;
public class ProfiloControllerA {
    private final SessioneBean sessioneBean;

    public ProfiloControllerA(SessioneBean sessioneBean) {
        this.sessioneBean = sessioneBean;
    }

    public boolean checkSessione(){
        for(Sessione sessione: Model.getInstance().getSessioniUtentiRistoratori()){
            if(sessione.getIdSessione() == sessioneBean.getIdSessione()){
                return true;
            }
        }
        return false;
    }
}
