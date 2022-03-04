package Modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Modelo {
       
    //Lee el archivo y guarda los numeros en el arraylist
    public ArrayList<Integer> lectura2(){
        try{
            File archivo = new File("C:\\Users\\danie\\Documents\\archivos\\numeros.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
        
            //Variables de Control
            String bfRead;       
            int i=0;
            ArrayList<Integer> arreglo = new ArrayList();
            //Ciclo que me almacena en un arreglo lo numeros mientras existan
            while( (bfRead = br.readLine()) != null  ){ 
                arreglo.add(Integer.parseInt(bfRead));
                i++;
            }
            fr.close();
            return(arreglo);
        } catch (IOException e){
            System.out.println("Error: "+e);
            return(null);
        }        
    }
    
    //Metodo Burbuja
    public ArrayList<Integer> MetodoBurbuja(ArrayList<Integer> arreglo){
        long Tinicio, Tfin, tiempo;                                            //Variables para medir el tiempo de ejecucion
        Tinicio = System.currentTimeMillis();
        int aux;                                                               //Variable auxiliar de cambio
        for (int i = 0; i < (arreglo.size()-1); i++) {                         //For para saber cuantas vueltas tiene que dar   
            for (int j = 0; j < (arreglo.size()-1); j++) {                     //For para ordenar los numeros para irlos intercambiando
                if(arreglo.get(j) > arreglo.get(j+1)) {
                    aux = arreglo.get(j);
                    arreglo.set(j, arreglo.get(j+1));
                    arreglo.set(j+1, aux);
                }
            }
        }
        Tfin = System.currentTimeMillis();
        long seconds_ini = (Tinicio / 1000) % 60;
        long seconds_fin = (Tfin / 1000) % 60;
        tiempo = seconds_fin - seconds_ini;
        JOptionPane.showMessageDialog(null," Orden finalizado con Metodo Burbuja y tomo: " + tiempo + " Segundos");
        return(arreglo);
    }
    
    public void MetodoQuickSort(){
    }
    
    //Metodo para crear el archivo y guardar los numeros segun el orden
    public void orden(ArrayList<Integer> arreglo, String tipo){
        FileWriter fichero = null;
        PrintWriter pw = null;
        if(tipo.equals("Ascendente")){
            try{
                File ficheros = new File("C:\\Users\\danie\\Documents\\archivos\\asc.txt");         //Busca el archivo asc
                ficheros.delete();                                                                  //Borra el archivo asc, esto con el fin de que no se sobreescriba si se ejecuta otra vez 
                fichero = new FileWriter("C:\\Users\\danie\\Documents\\archivos\\asc.txt", true);   //Lo vuelve a crear
                pw = new PrintWriter(fichero);
                for(int i = 0; i < arreglo.size();  i++){
                    pw.println(arreglo.get(i));
                } 
            } catch (IOException e){
                System.out.println("Error: "+e);
            } finally {
                try{
                    if(null != fichero)
                        fichero.close();        
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        
        }
        else {
            try{
                File ficheros = new File("C:\\Users\\danie\\Documents\\archivos\\desc.txt");
                ficheros.delete();
                fichero = new FileWriter("C:\\Users\\danie\\Documents\\archivos\\desc.txt", true);
                pw = new PrintWriter(fichero);
                for(int i = arreglo.size()-1; i>=0; i--){
                    pw.println(arreglo.get(i));
                } 
            } catch (IOException e){
                System.out.println("Error: "+e);
            } finally {
                try{
                    if(null != fichero)
                        fichero.close();        
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }      
        }
       
    } 
}
