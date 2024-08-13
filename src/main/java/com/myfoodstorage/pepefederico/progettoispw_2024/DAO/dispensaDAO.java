package com.myfoodstorage.pepefederico.progettoispw_2024.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.FoodStorageNotFoundException;
import com.myfoodstorage.pepefederico.progettoispw_2024.Factory.connectionFactory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Factory.dispensaFactory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Dispensa;

public class dispensaDAO {
    Connection connection;
    ArrayList<Dispensa> dispensa = new ArrayList<>();
    dispensaFactory dispensaFactory;

    public void recuperoDispensa(String nomeAttivita) throws Exception {
        connection = connectionFactory.getConnection();
        ResultSet rs;

        try(
            InputStream input = new FileInputStream("risorseDB/queryDatabase.properties")
        ){
            Properties properties = new Properties();
            properties.load(input);

            PreparedStatement query = connection.prepareStatement(properties.getProperty("QUERY_CATEGORIE_DISPENSA"));
            query.setString(1,nomeAttivita);
            rs = query.executeQuery();

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        if(rs.next()){
            do{
                dispensa.add(dispensaFactory.getInstance().getDispensa(rs.getString("Dispensa"), nomeAttivita, rs.getInt("numeroBoxCategorie")));
            }while (rs.next());
        }else{
            throw new FoodStorageNotFoundException("Ops, come è vuota la tua dispensa. Prova ad inserire una nuova dispensa!");
        }

    }

    public ArrayList<Dispensa> getDispensa() {
        return dispensa;
    }
}
