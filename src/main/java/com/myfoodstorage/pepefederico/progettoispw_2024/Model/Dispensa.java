package com.myfoodstorage.pepefederico.progettoispw_2024.Model;

import java.util.ArrayList;
import com.myfoodstorage.pepefederico.progettoispw_2024.DAO.categoriaDAO;

public class Dispensa {
    private String nomeDispensa;
    private int numeroCategorie;
    private ArrayList<Categoria> categorie;
    private categoriaDAO categoriaDAO;

    public Dispensa(String nomeDispensa, int numeroCategorie) {
        this.nomeDispensa = nomeDispensa;
        this.numeroCategorie = numeroCategorie;
        this.categorie = new ArrayList<>();
        this.categoriaDAO = new categoriaDAO();
    }

    public String getNomeDispensa() {
        return nomeDispensa;
    }

    public void setNomeDispensa(String nomeDispensa) {
        this.nomeDispensa = nomeDispensa;
    }

    public int getNumeroCategorie() {
        return numeroCategorie;
    }

    public void setNumeroCategorie(int numeroCategorie) {
        this.numeroCategorie = numeroCategorie;
    }
}
