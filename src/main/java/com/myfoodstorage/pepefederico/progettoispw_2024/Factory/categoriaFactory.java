package com.myfoodstorage.pepefederico.progettoispw_2024.Factory;

import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Categoria;

public class categoriaFactory {
    private static categoriaFactory categoriaFactory = null;
    private categoriaFactory(){}
    public static synchronized categoriaFactory getInstance(){
        if(categoriaFactory == null){
            categoriaFactory = new categoriaFactory();
        }
        return categoriaFactory;
    }
    public Categoria getCategoria(String nomeCategoria, String nomeAttivita, String nomeDispensa) throws Exception {
        Categoria categoria = new Categoria(nomeCategoria);
        categoria.setProdotti(nomeAttivita, nomeDispensa);
        return categoria;
    }
}
