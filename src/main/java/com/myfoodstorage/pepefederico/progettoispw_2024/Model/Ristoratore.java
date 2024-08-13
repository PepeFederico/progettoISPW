package com.myfoodstorage.pepefederico.progettoispw_2024.Model;

public class Ristoratore extends Utente{
    public Ristoratore(String email, String password, String nome, String cognome, String partitaIVA, String viaAttivita, int numeroCivico, String citta, String CAP, String nomeAttivita, String numeroTelefono) {
        super(email, password, nome, cognome, partitaIVA, viaAttivita, numeroCivico, citta, CAP, nomeAttivita, numeroTelefono);
        setTipoUtente("Ristoratore");
    }
}
