package com.myfoodstorage.pepefederico.progettoispw_2024.Factory;

import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Prodotto;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.tipoAnimale;
import java.util.Date;

public class prodottoFactory {
    private static prodottoFactory prodottoFactory = null;
    private prodottoFactory(){}
    public static synchronized prodottoFactory getInstance(){
        if(prodottoFactory == null){
            prodottoFactory = new prodottoFactory();
        }
        return prodottoFactory;
    }

    public Prodotto getProdotto(String nomeProdotto,
                                String numeroLotto,
                                Date scadenza,
                                int taglia,
                                int scorte,
                                double costo,
                                tipoAnimale tipoAnimale){
        return new Prodotto(nomeProdotto,numeroLotto,scadenza,taglia,scorte,costo,tipoAnimale);
    }
}
