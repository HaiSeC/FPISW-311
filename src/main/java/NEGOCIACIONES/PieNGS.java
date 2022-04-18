/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIACIONES;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Cris
 */
public class PieNGS {
        public PieDataset createDataset(ArrayList<String> dataname) throws FileNotFoundException{

        int tam =  dataname.size(); 
        System.out.println( dataname);           
        System.out.println( dataname.size());

        DefaultPieDataset result = new DefaultPieDataset();
        for (int j = 0; j <  dataname.size(); j++){
                String datos = String.valueOf( dataname.get(j)) ;
                int c = Collections.frequency( dataname, datos);
                if (datos.equals("null")){
                    datos = "Desconocido";
                } 
                result.setValue(datos,c);
            }
        
        return result;
    }
        public PieDataset createDataset2(ArrayList<String> dataname) throws FileNotFoundException{

        int tam =  dataname.size(); 
        System.out.println( dataname);           
        System.out.println( dataname.size());

        DefaultPieDataset result = new DefaultPieDataset();
        for (int j = 0; j <  dataname.size(); j++){
                String datos = String.valueOf( dataname.get(j)) ;
                int c = Collections.frequency( dataname, datos);
                if (datos.equals("null") || datos.equals("-")){
                    datos = "Desconocido";
                } else if (!datos.equals("No Hair")) {
                    datos = "Con cabello";
                } else {
                    datos = "Calvos";
                }
                result.setValue(datos,c);
            }
        
        return result;
    }
        
    public PieDataset createDataset3(ArrayList<String[]> dataname) throws FileNotFoundException{

        int tam =  dataname.size(); 
        System.out.println( dataname);           
        System.out.println( dataname.size());

        DefaultPieDataset result = new DefaultPieDataset();
        for (int j = 0; j <  dataname.size(); j++){
                String datos = String.valueOf( dataname.get(j)[0]) ;
                int c = Integer.valueOf(dataname.get(j)[1]);
                result.setValue(datos,c);
            }
        
        return result;
    }
}
