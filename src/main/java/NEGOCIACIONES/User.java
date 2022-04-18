/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIACIONES;

import DATOS.Consultas;
import OBJETOs.ObjUser;
import java.util.ArrayList;

/**
 *
 * @author Guerrero
 */
public class User {
    Consultas DB = new Consultas(); 
    public ArrayList<ObjUser> loadAUser(){
        ArrayList<ObjUser> AUser = DB.loadUser();
        return AUser;       
    }
}
