package com.myfoodstorage.pepefederico.progettoispw_2024.exceptions;

import java.io.Serial;

public class CategoryNotFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
