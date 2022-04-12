/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIACIONES;

import OBJETOs.ObjPublisher;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Guerrero
 */
public class PieChartBar extends JFrame{
private Publisher data = new Publisher();
    
   public void BarChartz(){
      ObjPublisher.casaPubli = new ArrayList<>();
        ArrayList<String> casaPubliX = data.loadPublishers(); 

        int tam = casaPubliX.size(); 
        System.out.println(casaPubliX);           
        System.out.println(casaPubliX.size());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int j = 0; j < casaPubliX.size(); j++){
                String datos = String.valueOf(casaPubliX.get(j)) ;
                int c = Collections.frequency(casaPubliX, datos);
                if (datos.equals("null")){
                    datos = "Desconocido";
                }
                dataset.setValue(c,datos,datos);
            }
       
       JFreeChart chart =ChartFactory.createBarChart("Cantidad de Super Heroes", "Publisher", "Cantidad", dataset,PlotOrientation.HORIZONTAL,false,true,false);
       CategoryPlot p=chart.getCategoryPlot();
       p.setRangeGridlinePaint(Color.black);
       ChartFrame frame = new ChartFrame("Gráfico de Publishers", chart);
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
       frame.setSize(450,800);
   }

    
}
