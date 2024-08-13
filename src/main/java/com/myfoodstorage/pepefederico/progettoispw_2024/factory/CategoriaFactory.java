package com.myfoodstorage.pepefederico.progettoispw_2024.factory;

import com.myfoodstorage.pepefederico.progettoispw_2024.model.Categoria;

public class CategoriaFactory {
    private static CategoriaFactory categoriaFactory = null;
    private CategoriaFactory(){}
    public static synchronized CategoriaFactory getInstance(){
        if(categoriaFactory == null){
            categoriaFactory = new CategoriaFactory();
        }
        return categoriaFactory;
    }
    public Categoria getCategoria(String nomeCategoria, String nomeAttivita, String nomeDispensa) throws Exception {
        Categoria categoria = new Categoria(nomeCategoria);
        categoria.setProdotti(nomeAttivita, nomeDispensa);
        return categoria;
    }
}
