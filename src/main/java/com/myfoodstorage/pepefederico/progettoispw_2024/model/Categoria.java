package com.myfoodstorage.pepefederico.progettoispw_2024.model;

import java.util.ArrayList;

import com.myfoodstorage.pepefederico.progettoispw_2024.dao.ProdottoDao;

public class Categoria {
    private String nomeCategoria;
    private ArrayList<Prodotto> prodotti;
    ProdottoDao prodottoDAO;

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.prodotti = new ArrayList<>();
        prodottoDAO = new ProdottoDao();
    }

    public void setProdotti(String nomeAttivita, String nomeDispensa) throws Exception {
        //ProdottoDao.recuperoProdotti(nomeAttivita, this.nomeCategoria, nomeDispensa);
        //prodotti = ProdottoDao.getProdotti();
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
