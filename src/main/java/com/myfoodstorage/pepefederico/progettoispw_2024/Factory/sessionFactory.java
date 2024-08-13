package com.myfoodstorage.pepefederico.progettoispw_2024.Factory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Sessione;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Utente;
public class sessionFactory {
    private static sessionFactory sessionFactory = null;
    private sessionFactory(){}

    public static synchronized sessionFactory getInstance(){
        if(sessionFactory == null){
            sessionFactory = new sessionFactory();
        }
        return sessionFactory;
    }
    public Sessione getSessione(Utente utente){
        return new Sessione(utente);
    }
}
