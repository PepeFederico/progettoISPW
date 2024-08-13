package com.myfoodstorage.pepefederico.progettoispw_2024.bean;
import java.util.regex.Pattern;

public class UtenteLoginBean {
    private String email;
    private String password;

    public boolean mailSyntaxCheck(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern regExp = Pattern.compile(emailRegex);
        return regExp.matcher(email).matches();
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
