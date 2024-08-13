package com.myfoodstorage.pepefederico.progettoispw_2024.Bean;

import java.time.LocalDateTime;

public class sessioneBean {
    private int ID_Sessione;
    private LocalDateTime data;
    private boolean statusSessione;
    private utenteBean utente;

    public sessioneBean(int ID_Sessione, LocalDateTime data, utenteBean utente, boolean statusSessione) {
        this.ID_Sessione = ID_Sessione;
        this.data = data;
        this.utente = utente;
        this.statusSessione = statusSessione;
    }

    public int getID_Sessione() {
        return ID_Sessione;
    }
    public void setID_Sessione(int ID_Sessione) {
        this.ID_Sessione = ID_Sessione;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public utenteBean getUtente() {
        return utente;
    }
    public void setUtente(utenteBean utente) {
        this.utente = utente;
    }
    public boolean isStatusSessione() {
        return statusSessione;
    }
    public void setStatusSessione(boolean statusSessione) {
        this.statusSessione = statusSessione;
    }
}
