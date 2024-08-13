package com.myfoodstorage.pepefederico.progettoispw_2024.DAO;

import com.myfoodstorage.pepefederico.progettoispw_2024.Factory.connectionFactory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Factory.categoriaFactory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Categoria;
import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.CategoryNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class categoriaDAO {
    Connection connection;
    ArrayList<Categoria> categoria = new ArrayList<>();
    categoriaFactory categoriaFactory;

    public void recuperoCategorie(String nomeAttivita, String nomeDispensa) throws Exception{
        connection = connectionFactory.getConnection();
        ResultSet rs;

        try(InputStream input = new FileInputStream("risorseDB/queryDatabase.properties")){
            Properties properties = new Properties();
            properties.load(input);

            PreparedStatement query = connection.prepareStatement(properties.getProperty("QUERY_NOME_CATEGORIE"));
            query.setString(1,nomeAttivita);
            query.setString(2, nomeDispensa);
            rs = query.executeQuery();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        if(rs.next()){
            do{
                categoria.add(categoriaFactory.getInstance().getCategoria(rs.getString("nomeCategoria"), nomeAttivita, nomeDispensa));
            }while(rs.next());
        }else{
            throw new CategoryNotFoundException("La dispensa non presenta alcuna Categoria di Prodotti. Aggiungi una categoria");
        }
    }
    public ArrayList<Categoria> getCategoria() {
        return categoria;
    }
}
