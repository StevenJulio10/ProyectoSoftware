package Controlador;
import Modelo.Modelo;
import Vista.Vista;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {      //Conectar controlador con la vista

    Modelo modelo = new Modelo();                         //Instanciar clase modelo
    Vista vista = new Vista();                            //Instanciar clase vista
    
    public Controlador(Vista v) {
        this.vista = v;
        this.vista.burbuja.addActionListener(this);
        this.vista.quick.addActionListener(this);          //Constructor para llamar los botones
        this.vista.opcion.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        if(e.getSource() == vista.burbuja){
            String tipo = String.valueOf( vista.opcion.getSelectedItem());                //Variable que me guarda la opcion de ordenamiento
            burbuja(tipo);
            //Abre el archivo organizado automaticamente
            if(tipo.equals("Ascendente")) {
                try {
                File objetofile = new File ("C:\\Users\\danie\\Documents\\archivos\\asc.txt");
                Desktop.getDesktop().open(objetofile);
            }catch (IOException ex) {
                System.out.println(ex);
            }
            } else {
                try {
                File objetofile = new File ("C:\\Users\\danie\\Documents\\archivos\\desc.txt");
                Desktop.getDesktop().open(objetofile);
            }catch (IOException ex) {
                System.out.println(ex);
            }
          }
            
        }
        else if(e.getSource() == vista.quick){
            String tipo = String.valueOf( vista.opcion.getSelectedItem());                //Variable que me guarda la opcion de ordenamiento
            quicksort(tipo);
            //Abre el archivo organizado automaticamente
            if(tipo.equals("Ascendente")) {
                try {
                File objetofile = new File ("C:\\Users\\danie\\Documents\\archivos\\asc.txt");
                Desktop.getDesktop().open(objetofile);
            }catch (IOException ex) {
                System.out.println(ex);
            }
            } else {
                try {
                File objetofile = new File ("C:\\Users\\danie\\Documents\\archivos\\desc.txt");
                Desktop.getDesktop().open(objetofile);
            }catch (IOException ex) {
                System.out.println(ex);
            }
          }
            
        } 
    }
            
    public void burbuja(String tipo){
         ArrayList<Integer> arreglo = new ArrayList();                       //Crea un nuevo array
         arreglo = modelo.lectura2();                                        //En el nuevo array guarda el retorno del metodo lectura, es decir los datos pero desordenados
         ArrayList<Integer> arr = new ArrayList();                           //Crea un nuevo array     
         arr = modelo.MetodoBurbuja(arreglo);                                //En el nuevo array guarda el retorno del metodo burbuja, es decir los datos ya ordenados
         modelo.orden(arr, tipo);                                            //Se envia el array ordenado y el tipo de orden con el fin de crear el nuevo archivo con los parametros deseados
    }
    
    public void quicksort(String tipo){
         ArrayList<Integer> arreglo = new ArrayList();                       //Crea un nuevo array
         arreglo = modelo.lectura2();                                        //En el nuevo array guarda el retorno del metodo lectura, es decir los datos pero desordenados
         ArrayList<Integer> arr = new ArrayList();                           //Crea un nuevo array
         //arr = modelo.MetodoQuickSort(arreglo);                            //Se envia el array ordenado y el tipo de orden con el fin de crear el nuevo archivo con los parametros deseados
         modelo.orden(arr, tipo);   
    }
    
}
