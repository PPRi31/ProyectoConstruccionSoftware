/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Modelo.Vehiculo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Grupo #4
Integrantes:
*  Ivonne Roxana Minchala Plúas 
 * Joseph Gabriel García Camacho 
 * Marcos Adonis Merchan Mendoza 
 * Alexander Jesús Zambrano Narváez
*/

public class Archivo {
    ArrayList <Vehiculo> vehiculo=new ArrayList <Vehiculo>();
    File archivo;
    FileWriter escribir;
    public void añadir(String numchasis,String marca, String modelo, String color, String anio,String precio, String modoPago, String precioFinal, String cuota)
    {
        Vehiculo x=new Vehiculo(numchasis,marca, modelo, color, anio, precio, modoPago, precioFinal, cuota);
        vehiculo.add(x);
    }
    public void archivoVehiculos(){
       archivo=new File("vehiculos.txt");
        try {
            if(archivo.createNewFile())
            {
                System.out.println("ARCHIVO CREADO");
            }} catch (IOException ex) {
            System.out.println("EL ARCHIVO YA EXISTE CRACK");
        }
    }
    public void elimnarCancelados(String chasis)
    {
        for(int i=0;i<vehiculo.size();i++)
        {
            if(vehiculo.get(i).getNumchasis().equalsIgnoreCase(chasis))
            {
                vehiculo.remove(i);
            }
        }
    }
    public void llenarArreglo()
    {String linea,vector[];
        try {
            FileReader lector=new FileReader("vehiculos.txt");
            BufferedReader lectura=new BufferedReader(lector);
       
            linea=lectura.readLine();
            while(linea!=null)
            {
                vector=linea.split("#");
                vehiculo.add(new Vehiculo(vector[0],vector[1],vector[2],vector[3],vector[4],vector[5],vector[6],vector[7],vector[8]));
                linea=lectura.readLine(); 
            }
            lectura.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void eliminartxt()
    {
            archivo=new File("vehiculos.txt");
       
        if(archivo.exists())
        {
            archivo.delete();
            System.out.println("ARCHIVO BORRADO");
        }
    }
    public void volverallenar(String fecha)
    {
           for(Vehiculo p:vehiculo)
        {
            try {
                escribir=new FileWriter("vehiculos.txt",true);
                escribir.write(p.getNumchasis()+"#"+p.getMarca()+"#"+p.getModelo()+"#"+p.getColor()+"#"+p.getAnio()+"#"+p.getPrecio()+"#"+p.getModoPago()+"#"+p.getPrecioFinal()+"#"+p.getCuota()+"#"+fecha+"\r\n");
                escribir.close();
                System.out.println("SE ESCRIBIO");
            } catch (IOException ex) {
                System.out.println("NO SE PUDO ESCRIBIR");
            }
               
        }
    }
    public void vaciarArreglo()
    {
        vehiculo.clear();
    }
    public void llenar(String fecha)
    {
        for(Vehiculo p:vehiculo)
        {
            try {
                escribir=new FileWriter("vehiculos.txt",true);
                escribir.write(p.getNumchasis()+"#"+p.getMarca()+"#"+p.getModelo()+"#"+p.getColor()+"#"+p.getAnio()+"#"+p.getPrecio()+"#"+p.getModoPago()+"#"+p.getPrecioFinal()+"#"+p.getCuota()+"#"+fecha+"\r\n");
                escribir.close();
                System.out.println("SE ESCRIBIO");
            } catch (IOException ex) {
                System.out.println("NO SE PUDO ESCRIBIR");
            }
               
        }
    }
   
}
