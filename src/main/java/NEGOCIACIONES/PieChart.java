/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIACIONES;

import OBJETOs.ObjPublisher;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Guerrero
 */
public class PieChart extends JFrame{
    private Publisher data = new Publisher();
    public PieChart(String appTitle, String chartTitle) throws FileNotFoundException{
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
        setContentPane(chartPanel);           
    }


    
    private PieDataset createDataset() throws FileNotFoundException{
        ObjPublisher.casaPubli = new ArrayList<>();
        ArrayList<String> casaPubliX = data.loadPublishers(); 

        int tam = casaPubliX.size(); 
        System.out.println(casaPubliX);           
        System.out.println(casaPubliX.size());

        DefaultPieDataset result = new DefaultPieDataset();
        for (int j = 0; j < casaPubliX.size(); j++){
                String datos = String.valueOf(casaPubliX.get(j)) ;
                int c = Collections.frequency(casaPubliX, datos);
                if (datos.equals("null")){
                    datos = "Desconocido";
                }
                result.setValue(datos,c);
            }
        
        return result;
    }
            
    private JFreeChart createChart (PieDataset dataset, String title){
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
    
}
