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
import OBJETOs.ObjUser;
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
            rs = s.executeQuery("select sh.publisher as casa_publi from superheroes sh order by sh.publisher");           
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
     public ArrayList<String> loadAlt170(String Gen){   
        ArrayList<String> Alt170 = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.height as altura, sh.gender as genero from superheroes sh where sh.gender = '" + Gen + "' and sh.height between '62.5' and '170.0' order by sh.height");           
            while(rs.next()){
                Alt170.add(rs.getString("altura"));               
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return Alt170;        
    }
     public ArrayList<String> loadAltD(String Gen){   
        ArrayList<String> AltD = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.height as altura, sh.gender as genero from superheroes sh where sh.gender = '" + Gen + "' and sh.height = '-99.0'");           
            while(rs.next()){
                AltD.add(rs.getString("altura"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return AltD;        
    }
     public ArrayList<String> loadAltR(String Gen){   
        ArrayList<String> AltDR = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select sh.height as altura, sh.gender as genero from superheroes sh where sh.gender = '" + Gen + "' and sh.height between '173.0' and '975.0' order by sh.height");           
            while(rs.next()){
                AltDR.add(rs.getString("altura"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return AltDR;        
    }
     
     public ArrayList<String[]> loadheigen(String Gen){   
        ArrayList<String[]> heigen = new ArrayList<>();
        try{
            System.out.println(Gen);
            connection = conexion.Conexion();
            s = connection.createStatement();             
            rs = s.executeQuery("select sh.height as altura, sh.gender as genero from superheroes sh where sh.gender = '" + Gen + "' order by sh.height");           
            while(rs.next()){
                String[] row = {rs.getString("altura"), rs.getString("genero")};
                heigen.add(row);
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
    
    public ArrayList<ObjUser> loadUser(){     
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT us.username, us.password from users us");           
            while(rs.next()){
                ObjUser.ALUsers.add(new ObjUser(rs.getString("username"),rs.getString("password")));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return ObjUser.ALUsers;
    }
    
    public ArrayList<String> loadSuperPowers() {
        ArrayList<String> superpoderes = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT c.column_name AS superpoder FROM information_schema.columns c WHERE table_schema = 'public' AND table_name   = 'superpowers' and c.column_name <> 'hero_names'");           
            while(rs.next()){
                superpoderes.add(rs.getString("superpoder"));
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return superpoderes;
    }
    
    public ArrayList<Boolean> getPowersInfo(String superheroe, int loop) {
        ArrayList<Boolean> superheroeData = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select * from superpowers where hero_names = '"+ superheroe +"'");           
            while(rs.next()){
                for (int i = 1; i < loop+1; i++) {
                  Boolean data = Boolean.parseBoolean(rs.getString(i));
                superheroeData.add(data);  
                }
                
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return superheroeData;
        
    }
    
    public ArrayList<String> getSuperHeroesName(String cond1, String cond2 ) {
        ArrayList<String> superheroeData = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select sh.name as nombre from superheroes sh where sh.name between '"+cond1+"' and '"+cond2+"' UNION Select sh2.name as nombre from superheroes sh2 where sh2.name like '"+ cond2 + "%' Order by nombre ASC");           
            while(rs.next()){
                superheroeData.add(rs.getString("nombre"));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return superheroeData;
        
    }
    public ArrayList<String[]> getSuperHeroesInfo(String HeroName) {
        ArrayList<String[]> superheroeData = new ArrayList<>();
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select sh.name as nombre, sh.gender as genero, sh.eyecolor as ojos, sh.race as raza, sh.haircolor as cabello, sh.height as altura, sh.publisher as editorial, sh.skincolor as color_piel, sh.alignment as alineacion, sh.weight as peso, sh.image as imagen from superheroes sh where sh.name = '"+ HeroName +"'");           
            while(rs.next()){
                String[] data = {rs.getString("nombre"), rs.getString("genero"), rs.getString("ojos"), rs.getString("raza"), rs.getString("cabello"), rs.getString("altura"), rs.getString("editorial"), rs.getString("color_piel"), rs.getString("alineacion"), rs.getString("peso"), rs.getString("imagen")};
                superheroeData.add(data);
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        return superheroeData;
        
    }
     
}
