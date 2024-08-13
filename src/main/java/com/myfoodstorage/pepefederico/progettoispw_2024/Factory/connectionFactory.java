package com.myfoodstorage.pepefederico.progettoispw_2024.Factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionFactory {
    private static final Connection connection;
    private connectionFactory(){}

    static {
        try(InputStream input = new FileInputStream("risorseDB/credenzialiDB.properties")){
            Properties properties = new Properties();
            properties.load(input);

            String connection_url   = properties.getProperty("CONNECTION_URL");
            String user             = properties.getProperty("LOGIN_USER");
            String password         = properties.getProperty("LOGIN_PASS");

            connection = DriverManager.getConnection(connection_url,user,password);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
