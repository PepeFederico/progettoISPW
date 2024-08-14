package com.myfoodstorage.pepefederico.progettoispw_2024.factory;
import com.myfoodstorage.pepefederico.progettoispw_2024.model.Sessione;
import com.myfoodstorage.pepefederico.progettoispw_2024.model.Utente;
public class SessionFactory {
    private static SessionFactory sessionFactory = null;
    private SessionFactory(){}

    public static synchronized SessionFactory getInstance(){
        if(sessionFactory == null){
            sessionFactory = new SessionFactory();
        }
        return sessionFactory;
    }
    public Sessione getSessione(Utente utente){
        return new Sessione(utente);
    }
}
