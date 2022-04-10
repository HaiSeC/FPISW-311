/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris
 */
public class Consultas {
     private ResultSet rs = null;
    private Statement s = null;
    BDConexion conexion = new BDConexion();
    private Connection connection = null;
   
    
    
    
    
    public ArrayList<String> obtenerLHNH() {
        ArrayList<String> columns = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select name From superheroes where haircolor  like 'No Hair'");
            while(rs.next()) {
                columns.add(rs.getString("name"));
            }
        } catch (Exception e) {
        }
        return columns;
    }
    public int obtenerSHWNH(){
        int cant = 0;
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select count(*) as cantidad From superheroes where haircolor not like 'No Hair'");
            while (rs.next()){
               cant = rs.getInt("cantidad");
               
            }
        } catch (Exception e) {
        }
        return cant;
    }
    public int obtenerSHWH(){
        int cant = 0;
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select count(*) as cantidad From superheroes where haircolor like 'No Hair'");
            while (rs.next()){
               cant = rs.getInt("cantidad");
               
            }
        } catch (Exception e) {
        }
        return cant;
    }
    
    
    public ArrayList<String[]> obtenerHSH() {
        ArrayList<String[]> columnsS = new ArrayList();
        String QueryStatment = "";
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.name as name, sh.gender as gender, sh.eyecolor as eyecolor, sh.race as race, sh.haircolor as haircolor, sh.height as height, sh.publisher as publisher From superheroes sh" +
                                    "where sh.race != '-' and sh.haircolor != 'No Hair' and sh.haircolor != '-'" +
                                    "order by sh.height DESC" +
                                    "limit 10");
            while (rs.next()) {
                String [] row = {rs.getString("name"), rs.getString("gender"), rs.getString("eyercolor"), rs.getString("race"), rs.getString("haircolor"), rs.getString("height"), rs.getString("publisher")};
                columnsS.add(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return columnsS;
    }
    
    
    public ArrayList<String[]> obtenerEstPoderes(String casa_publicacion) {
        ArrayList<String[]> columnsS = new ArrayList();
        String QueryStatment = "";
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select hero_names as nombre, (select count(*) from jsonb_each_text(to_jsonb(s) - 'hero_names') as x(k,v) where x.v = 'True') as cantidad_poderes from superpowers s" +
                                "INNER JOIN superheroes sh ON sh.name = s.hero_names" +
                                "WHERE sh.publisher = '"+ casa_publicacion +"'" +
                                "Order by cantidad_poderes DESC" +
                                "limit 10");
            while (rs.next()) {
                String [] row = {rs.getString("nombre"), rs.getString("cantidad_poderes")};
                columnsS.add(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return columnsS;
    }
    
    
}
