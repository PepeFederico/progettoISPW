package com.myfoodstorage.pepefederico.progettoispw_2024.Factory;

import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Dispensa;

public class dispensaFactory {
    private static dispensaFactory dispensaFactory = null;

    private dispensaFactory() {
    }

    public static synchronized dispensaFactory getInstance() {
        if (dispensaFactory == null) {
            dispensaFactory = new dispensaFactory();
        }
        return dispensaFactory;
    }

    public Dispensa getDispensa(String nomeDispensa, String nomeAttivita, int numeroCategorie) throws Exception {
        Dispensa dispensa = new Dispensa(nomeDispensa, numeroCategorie);
        return dispensa;
    }
}
