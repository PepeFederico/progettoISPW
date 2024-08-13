package com.myfoodstorage.pepefederico.progettoispw_2024.DAO;

import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Utente;
import com.myfoodstorage.pepefederico.progettoispw_2024.Factory.connectionFactory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.UserNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UtenteDAO {
    Connection connection;
    Utente utenteLoggato;

    public void verificaCredenziali(String email, String password) throws Exception{
        connection = connectionFactory.getConnection();
        ResultSet rs;

        try(InputStream input = new FileInputStream("risorseDB/queryDatabase.properties")){
            Properties properties = new Properties();
            properties.load(input);

            PreparedStatement query = connection.prepareStatement(properties.getProperty("QUERY_LOGIN"));
            query.setString(1,email);
            query.setString(2,password);
            rs = query.executeQuery();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(!rs.next()){
            throw new UserNotFoundException("Errore: Credenziali non valide");
        }

        utenteLoggato = com.myfoodstorage.pepefederico.progettoispw_2024.Factory.userFactory.getInstance().getUtente(
                rs.getString("tipoUtente"),
                rs.getString("email"),
                rs.getString("pass"),
                rs.getString("nome"),
                rs.getString("cognome"),
                rs.getString("partitaIva"),
                rs.getString("via"),
                Integer.parseInt(rs.getString("numeroCivico")),
                rs.getString("citta"),
                rs.getString("cap"),
                rs.getString("nomeAttivita"),
                rs.getString("telefono")
        );
    }

    public Utente getUtenteLoggato() {
        return utenteLoggato;
    }
}
