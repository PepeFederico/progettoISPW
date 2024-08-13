package com.myfoodstorage.pepefederico.progettoispw_2024.model;
import java.time.LocalDateTime;
import java.util.Random;

public class Sessione {
    private int idSessione;
    private boolean statusSessione;
    private LocalDateTime data;
    private Utente utente;

    public Sessione(Utente utente) {
        this.idSessione = new Random().nextInt(3000);
        this.data = LocalDateTime.now();
        this.utente = utente;
        this.statusSessione = true;
    }

    public void setIdSessione(int idSessione) {
        this.idSessione = idSessione;
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
    public int getIdSessione() {
        return idSessione;
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
