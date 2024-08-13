package com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Applicativo;

import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.categoriaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.dispensaBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.prodottoBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Bean.sessioneBean;
import com.myfoodstorage.pepefederico.progettoispw_2024.Controller.Grafico.clientController;
import com.myfoodstorage.pepefederico.progettoispw_2024.DAO.categoriaDAO;
import com.myfoodstorage.pepefederico.progettoispw_2024.DAO.prodottoDAO;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.CategoryNotFoundException;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.FoodStorageNotFoundException;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.ProductNotFoundException;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.*;
import com.myfoodstorage.pepefederico.progettoispw_2024.DAO.dispensaDAO;
import java.util.ArrayList;

public class gestioneProdottiA {
    sessioneBean sessioneBean;
    dispensaBean dispensaBean;
    categoriaBean categoriaBean;
    dispensaDAO dispensaDAO;
    categoriaDAO categoriaDAO;
    prodottoDAO prodottoDAO;
    ArrayList<Dispensa> disp;
    ArrayList<Categoria> categorias;
    ArrayList<Prodotto> prodotti;
    ArrayList<dispensaBean> dispBean = new ArrayList<>();
    ArrayList<categoriaBean> catBean = new ArrayList<>();
    ArrayList<prodottoBean> prodBean = new ArrayList<>();

    public gestioneProdottiA(sessioneBean sessioneBean) {
        this.sessioneBean = sessioneBean;
    }

    public boolean checkSessione(){
        for(Sessione sessione: Model.getInstance().getSessioniUtentiRistoratori()){
            if(sessione.getID_Sessione() == sessioneBean.getID_Sessione()){
                return true;
            }
        }
        return false;
    }

    public void recuperoInfoDispensa() throws FoodStorageNotFoundException {
        try{
            dispensaDAO = new dispensaDAO();
            dispensaDAO.recuperoDispensa(sessioneBean.getUtente().getNomeAttivita());
            disp = dispensaDAO.getDispensa();
            for(Dispensa dispensa : disp){
                dispensaBean dispensaBean = new dispensaBean(dispensa.getNomeDispensa());
                dispBean.add(dispensaBean);
            }
        }catch (FoodStorageNotFoundException e){
            throw new FoodStorageNotFoundException("Ops, come è vuota la tua dispensa. Prova ad inserire una nuova dispensa!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void recuperoInfoCategoria() throws CategoryNotFoundException {
        try {
            setDispensaBean(clientController.getInstance().getDispensaBean());
            categoriaDAO = new categoriaDAO();
            categoriaDAO.recuperoCategorie(sessioneBean.getUtente().getNomeAttivita(), dispensaBean.getNomeDispensa());
            categorias = categoriaDAO.getCategoria();
            for (Categoria categoria : categorias) {
                categoriaBean categoriaBean = new categoriaBean(categoria.getNomeCategoria());
                catBean.add(categoriaBean);
            }
        }catch (CategoryNotFoundException e){
            throw new CategoryNotFoundException("La dispensa non presenta alcuna Categoria di Prodotti. Aggiungi una categoria");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void recuperoInfoProdotti() throws ProductNotFoundException {
        try{
            setDispensaBean(clientController.getInstance().getDispensaBean());
            setCategoriaBean(clientController.getInstance().getCategoriaBean());
            prodottoDAO = new prodottoDAO();
            prodottoDAO.recuperoProdotti(sessioneBean.getUtente().getNomeAttivita(), categoriaBean.getNomeCategoria() ,dispensaBean.getNomeDispensa());
            prodotti = prodottoDAO.getProdotti();
            for (Prodotto prodotto : prodotti) {
                prodottoBean prodottoBean = new prodottoBean(
                                                prodotto.getNomeProdotto(),
                                                prodotto.getNumeroLotto(),
                                                prodotto.getScadenza(),
                                                prodotto.getTaglia(),
                                                prodotto.getScorte(),
                                                prodotto.getCosto(),
                                                prodotto.getTipoAnimale());
                prodBean.add(prodottoBean);
            }
        }catch (ProductNotFoundException e){
            throw new ProductNotFoundException("Ops, come è vuota la tua dispensa. Inserisci qualche prodotto");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<categoriaBean> getCatBean() {
        return catBean;
    }
    public ArrayList<dispensaBean> getDispBean() {
        return dispBean;
    }
    public ArrayList<prodottoBean> getProdBean() {
        return prodBean;
    }
    public void setDispensaBean(dispensaBean dispensaBean) {
        this.dispensaBean = dispensaBean;
    }
    public void setCategoriaBean(categoriaBean categoriaBean){
        this.categoriaBean = categoriaBean;
    }
}
