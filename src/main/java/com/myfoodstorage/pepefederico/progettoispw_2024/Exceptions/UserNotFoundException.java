package com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions;
import java.io.Serial;

public class UserNotFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;
    public UserNotFoundException(String message) {
        super(message);
    }
}
