/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Cris
 */
public class BDConexion {
 
    private Connection connection = null;

    public Connection Conexion() {
        //String url = "jdbc:postgresql://localhost:5432/SuperHeroes";
        String url = "jdbc:postgresql://localhost:5432/superheroesDB";
        //String password = "Postgres3620";
        String password = "guerrero6";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);
            if (connection != null) {
                System.out.println("Conectándo a la base de datos...");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e);
            System.out.println("Problema conectándose a la base de datos.");
        }
        return connection;
    }   
}
