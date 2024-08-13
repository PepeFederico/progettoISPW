package com.myfoodstorage.pepefederico.progettoispw_2024.Model;

import java.util.ArrayList;
import  com.myfoodstorage.pepefederico.progettoispw_2024.DAO.prodottoDAO;

public class Categoria {
    private String nomeCategoria;
    private ArrayList<Prodotto> prodotti;
    prodottoDAO prodottoDAO;

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.prodotti = new ArrayList<>();
        prodottoDAO = new prodottoDAO();
    }

    public void setProdotti(String nomeAttivita, String nomeDispensa) throws Exception {
        //prodottoDAO.recuperoProdotti(nomeAttivita, this.nomeCategoria, nomeDispensa);
        //prodotti = prodottoDAO.getProdotti();
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
