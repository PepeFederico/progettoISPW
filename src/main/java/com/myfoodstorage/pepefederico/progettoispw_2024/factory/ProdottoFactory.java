package com.myfoodstorage.pepefederico.progettoispw_2024.factory;

import com.myfoodstorage.pepefederico.progettoispw_2024.model.Prodotto;
import com.myfoodstorage.pepefederico.progettoispw_2024.model.TipoAnimale;
import java.util.Date;

public class ProdottoFactory {
    private static ProdottoFactory prodottoFactory = null;
    private ProdottoFactory(){}
    public static synchronized ProdottoFactory getInstance(){
        if(prodottoFactory == null){
            prodottoFactory = new ProdottoFactory();
        }
        return prodottoFactory;
    }

    public Prodotto getProdotto(String nomeProdotto,
                                String numeroLotto,
                                Date scadenza,
                                int taglia,
                                int scorte,
                                double costo,
                                TipoAnimale tipoAnimale){
        return new Prodotto(nomeProdotto,numeroLotto,scadenza,taglia,scorte,costo,tipoAnimale);
    }
}
