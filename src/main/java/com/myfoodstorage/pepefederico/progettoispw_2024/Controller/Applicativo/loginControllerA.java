package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo;

import java.io.IOException;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.UserNotFoundException;
import com.myfoodstorage.pepefederico.progettoispw_2024.DAO.UtenteDAO;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.utenteLoginBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Model;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Sessione;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Utente;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.sessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.utenteBean;

public class loginControllerA {
    utenteLoginBean utente;
    UtenteDAO utenteDAO;
    Utente utenteLoggato;
    Sessione sessioneUtente;
    sessioneBean sessioneBean;
    utenteBean utenteBean;

    public loginControllerA(utenteLoginBean utente) {
        this.utente = utente;
        this.utenteDAO = new UtenteDAO();
        this.utenteBean = new utenteBean();
    }
    public loginControllerA() {
    }

    public void autenticazioneUtente() throws Exception {
        try {
            utenteDAO.verificaCredenziali(utente.getEmail(), utente.getPassword());
            utenteLoggato = utenteDAO.getUtenteLoggato();
            sessioneUtente = com.myfoodstorage.pepefederico.progettoispw_2024.Factory.sessionFactory.getInstance().getSessione(utenteLoggato);

            fillUtenteBean(utenteLoggato);
            sessioneBean = new sessioneBean(sessioneUtente.getID_Sessione(), sessioneUtente.getData(), utenteBean, sessioneUtente.isStatusSessione());

            if(utenteLoggato.getTipoUtente().equals("Ristoratore")){
                Model.getInstance().addSessioneUtenteRistoratore(sessioneUtente);
                Model.getInstance().getViewFactory().showRistoratoreWindow(sessioneBean);
            }else{
                //Fornitore
            }

        } catch (UserNotFoundException unfe) {
            throw new UserNotFoundException("Errore: Credenziali non valide");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void logout(sessioneBean sessione){
        Model.getInstance().removeSessioneUtenteRistoratore(sessione.getID_Sessione());
    }
    private void fillUtenteBean(Utente utente){
        utenteBean.setNome(utente.getNome());
        utenteBean.setCognome(utente.getCognome());
        utenteBean.setEmail(utente.getEmail());
        utenteBean.setPassword(utente.getPassword());
        utenteBean.setTipoUtente(utente.getTipoUtente());

        utenteBean.setNomeAttivita(utente.getNomeAttivita());
        utenteBean.setViaAttivita(utente.getViaAttivita());
        utenteBean.setCAP(utente.getCAP());
        utenteBean.setCitta(utente.getCitta());
        utenteBean.setNumeroCivico(utente.getNumeroCivico());
        utenteBean.setPartitaIVA(utente.getPartitaIVA());
        utenteBean.setNumeroTelefono(utente.getNumeroTelefono());
    }

}

