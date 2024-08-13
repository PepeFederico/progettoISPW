package com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions;

import java.io.Serial;

public class FoodStorageNotFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;
    public FoodStorageNotFoundException(String message) {
        super(message);
    }

}
