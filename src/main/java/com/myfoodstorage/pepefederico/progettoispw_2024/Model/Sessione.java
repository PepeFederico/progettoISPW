package com.myfoodstorage.pepefederico.progettoispw_2024.Model;
import java.time.LocalDateTime;
import java.util.Random;

public class Sessione {
    private int ID_Sessione;
    private boolean statusSessione;
    private LocalDateTime data;
    private Utente utente;

    public Sessione(Utente utente) {
        this.ID_Sessione = new Random().nextInt(400);
        this.data = LocalDateTime.now();
        this.utente = utente;
        this.statusSessione = true;
    }

    public void setID_Sessione(int ID_Sessione) {
        this.ID_Sessione = ID_Sessione;
    }
    public void setStatusSessione(boolean statusSessione) {
        this.statusSessione = statusSessione;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    public int getID_Sessione() {
        return ID_Sessione;
    }
    public LocalDateTime getData() {
        return data;
    }
    public Utente getUtente() {
        return utente;
    }
    public boolean isStatusSessione() {
        return statusSessione;
    }
}
