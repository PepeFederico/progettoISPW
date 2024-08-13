package com.myfoodstorage.pepefederico.progettoispw_2024.DAO;

import com.myfoodstorage.pepefederico.progettoispw_2024.Exceptions.ProductNotFoundException;
import com.myfoodstorage.pepefederico.progettoispw_2024.Factory.connectionFactory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Factory.prodottoFactory;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.Prodotto;
import com.myfoodstorage.pepefederico.progettoispw_2024.Model.tipoAnimale;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class prodottoDAO {
    Connection connection;
    prodottoFactory prodottoFactory;
    ArrayList<Prodotto> prodotti = new ArrayList<>();

    public void recuperoProdotti(String nomeAttivita, String nomeCategoria, String nomeDispensa) throws Exception {
        connection = connectionFactory.getConnection();
        ResultSet rs;

        try(InputStream input = new FileInputStream("risorseDB/queryDatabase.properties")){
            Properties properties = new Properties();
            properties.load(input);

            PreparedStatement query = connection.prepareStatement(properties.getProperty("QUERY_PRODOTTI"));
            query.setString(1,nomeAttivita);
            query.setString(2,nomeDispensa);
            query.setString(3,nomeCategoria);
            rs = query.executeQuery();

        }catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        if(rs.next()){
            do{
                try {
                    prodotti.add(prodottoFactory.getInstance().getProdotto(
                                    rs.getString("nome"),
                                    rs.getString("numLotto"),
                                    rs.getDate("scadenza"),
                                    rs.getInt("taglia"),
                                    rs.getInt("numeroScorte"),
                                    rs.getDouble("costo"),
                                    tipoAnimale.valueOf(rs.getString("tipoAnimale"))
                            )
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }while(rs.next());
        }else{
            throw new ProductNotFoundException("Ops, come è vuota la tua dispensa. Inserisci qualche prodotto");
        }
    }

    public ArrayList<Prodotto> getProdotti() {
        return prodotti;
    }
}
