package com.myfoodstorage.pepefederico.progettoispw_2024.Factory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Utente;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Fornitore;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Ristoratore;

public class userFactory {
    private static userFactory userFactory = null;
    private userFactory(){}
    public static synchronized userFactory getInstance(){
        if(userFactory == null){
            userFactory = new userFactory();
        }
        return userFactory;
    }
    public Utente getUtente(String tipoUtente, String email, String password, String nome, String cognome, String partitaIVA, String viaAttivita, int numeroCivico, String citta, String CAP, String nomeAttivita, String numeroTelefono){
        return switch (tipoUtente) {
            case "Ristoratore" ->
                    new Ristoratore(email, password, nome, cognome, partitaIVA, viaAttivita, numeroCivico, citta, CAP, nomeAttivita, numeroTelefono);
            case "Fornitore" ->
                    new Fornitore(email, password, nome, cognome, partitaIVA, viaAttivita, numeroCivico, citta, CAP, nomeAttivita, numeroTelefono);
            default -> null;
        };
    }
}
