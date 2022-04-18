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
   
    
    
    
    public ArrayList<String> obtenerSKN() {
        ArrayList<String> columns = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
             rs = s.executeQuery("select skincolor from superheroes where skincolor <>'-' group by skincolor");
            
            while(rs.next()) {
                columns.add(rs.getString("skincolor"));
            }
        } catch (Exception e) {
        }
        return columns;
    }
    
    
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
    public ArrayList<String> obtenerSHWNH(){
        ArrayList<String> columns = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select haircolor as cabello From superheroes");
            while (rs.next()){
               columns.add(rs.getString("cabello"));
               
            }
        } catch (Exception e) {
        }
        return columns;
    }

    
    
    public ArrayList<String[]> obtenerHSH() {
        ArrayList<String[]> columnsS = new ArrayList();
        String QueryStatment = "";
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.name as name, sh.gender as gender, sh.eyecolor as eyecolor, sh.race as race, sh.haircolor as haircolor, sh.height as height, sh.publisher as publisher from superheroes sh where sh.race != '-' and sh.haircolor != 'No Hair' and sh.haircolor != '-' order by sh.height DESC limit 10");
            while (rs.next()) {
                String [] row = {rs.getString("name"), rs.getString("gender"), rs.getString("eyecolor"), rs.getString("race"), rs.getString("haircolor"), rs.getString("height"), rs.getString("publisher")};
                columnsS.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
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
            rs = s.executeQuery("select hero_names as nombre, (select count(*) from jsonb_each_text(to_jsonb(s) - 'hero_names') as x(k,v) where x.v = 'True') as cantidad_poderes from superpowers s INNER JOIN superheroes sh ON sh.name = s.hero_names WHERE sh.publisher = '"+ casa_publicacion +"' Order by cantidad_poderes DESC limit 10");
            while (rs.next()) {
                String[] row = {rs.getString("nombre"), rs.getString("cantidad_poderes")};
                columnsS.add(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return columnsS;
    }
    
     public ArrayList<String> loadPublisher2(){   
        ArrayList<String> casaPubli = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.publisher as casa_publi from superheroes sh group by sh.publisher");           
            while(rs.next()){
                casaPubli.add(rs.getString("casa_publi"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return casaPubli;        
    }
     public ArrayList<String> loadPublisher(){   
        ArrayList<String> casaPubli = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.publisher as casa_publi from superheroes sh");           
            while(rs.next()){
                casaPubli.add(rs.getString("casa_publi"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return casaPubli;        
    }
     
     public ArrayList<String> loadGender(){   
        ArrayList<String> lGender = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.gender as genero from superheroes sh");           
            while(rs.next()){
                lGender.add(rs.getString("genero"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return lGender;        
    }
     
     public ArrayList<String> loadheigen(){   
        ArrayList<String> heigen = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.height as altura, sh.gender as genero from superheroes sh");           
            while(rs.next()){
                heigen.add(rs.getString("altura" + "genero"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return heigen;        
    }
    
     public ArrayList<String> loadposfem(){   
        ArrayList<String> posfem = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.alignment as posicion from superheroes sh where sh.gender = 'Female'");           
            while(rs.next()){
                posfem.add(rs.getString("posicion"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return posfem;        
    }
    
}
