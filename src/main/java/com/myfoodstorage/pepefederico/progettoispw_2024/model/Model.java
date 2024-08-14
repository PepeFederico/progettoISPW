package com.myfoodstorage.pepefederico.progettoispw_2024.model;

import com.myfoodstorage.pepefederico.progettoispw_2024.factory.ViewFactory;
import java.util.ArrayList;

public class Model {
    private final ViewFactory viewFactory;
    private static Model model;
    private final ArrayList<Sessione> sessioniUtentiRistoratori = new ArrayList<>();
    private final ArrayList<Sessione> sessioniUtentiFornitori = new ArrayList<>();

    private Model(){
        this.viewFactory = new ViewFactory();
    }
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }
    public ViewFactory getViewFactory(){
        return viewFactory;
    }

    /*
    ***Sessione utenti tipo Ristoratore***
     */
    public void addSessioneUtenteRistoratore(Sessione sessione) {
        this.sessioniUtentiRistoratori.add(sessione);
    }
    public void removeSessioneUtenteRistoratore(int sessionID){
        sessioniUtentiRistoratori.removeIf(sessione -> sessione.getIdSessione() == sessionID);
    }
    public ArrayList<Sessione> getSessioniUtentiRistoratori() {
        return sessioniUtentiRistoratori;
    }

    /*
     ***Sessione utenti tipo Fornitore***
     */
    public void addSessioneUtenteFornitore(Sessione sessione) {
        this.sessioniUtentiFornitori.add(sessione);
    }
    public ArrayList<Sessione> getSessioniUtentiFornitori() {
        return sessioniUtentiFornitori;
    }
}
