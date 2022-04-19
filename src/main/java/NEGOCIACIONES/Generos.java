/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIACIONES;

import DATOS.Consultas;
import java.util.ArrayList;

/**
 *
 * @author Guerrero
 */
public class Generos {
    Consultas DB = new Consultas();
    public ArrayList<String> loadGender(){
        ArrayList<String> ALGenx = DB.loadPublisher();
        return ALGenx;       
    }
}
