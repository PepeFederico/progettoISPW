package com.myfoodstorage.pepefederico.progettoispw_2024.bean;

import java.time.LocalDateTime;

public class SessioneBean {
    private int idSessione;
    private LocalDateTime data;
    private boolean statusSessione;
    private UtenteBean utente;

    public SessioneBean(int idSessione, LocalDateTime data, UtenteBean utente, boolean statusSessione) {
        this.idSessione = idSessione;
        this.data = data;
        this.utente = utente;
        this.statusSessione = statusSessione;
    }

    public int getIdSessione() {
        return idSessione;
    }
    public void setIdSessione(int idSessione) {
        this.idSessione = idSessione;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public UtenteBean getUtente() {
        return utente;
    }
    public void setUtente(UtenteBean utente) {
        this.utente = utente;
    }
    public boolean isStatusSessione() {
        return statusSessione;
    }
    public void setStatusSessione(boolean statusSessione) {
        this.statusSessione = statusSessione;
    }
}
