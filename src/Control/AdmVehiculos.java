/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Vehiculo;
import Modelo.Cliente;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import Control.AdmCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
Grupo #4
Integrantes:
*  Ivonne Roxana Minchala Plúas 
 * Joseph Gabriel García Camacho 
 * Marcos Adonis Merchan Mendoza 
 * Alexander Jesús Zambrano Narváez
*/
public class AdmVehiculos {

// Creas un nuevo arraylist

    ArrayList<Vehiculo> vehiculos = null;
    //  ArrayList<Vehiculos> archivosfeligres=null;

    //DatosVehiculos datosA=null;  
    private static AdmVehiculos admvehiculo = null;

    private AdmVehiculos() {
        vehiculos = new ArrayList<Vehiculo>();
        
    }



    public static AdmVehiculos getAdmVehiculos() {

        if (admvehiculo == null) {
            admvehiculo = new AdmVehiculos();
        }
        return admvehiculo;
    }

    /* private void llenarTabla(JTable tblGanancias, ArrayList<Vehiculo>lista){
        int fila=0;
        DefaultTableModel venta=(DefaultTableModel)tblGanancias.getModel();
        venta.setNumRows(0);
        if(!lista.isEmpty()){
            for(Vehiculo v:lista){
                venta.addRow(new Object[1]);
                tblGanancias.setValueAt(v.getMarca(), fila, 0);
                tblGanancias.setValueAt(v.getModelo(), fila, 1);
                tblGanancias.setValueAt(v.getColor(), fila, 2);
                tblGanancias.setValueAt(v.getAnio(), fila, 3);
                tblGanancias.setValueAt(v.getPrecio(), fila, 4);
                //tblGanancias.setValueAt(v.getCliente(), fila, 4);//no sirve
                tblGanancias.setValueAt(v.getFechaCompra(), fila, 5);
                tblGanancias.setValueAt(v.getModoPago(), fila, 6);
                tblGanancias.setValueAt(v.getPrecioFinal(), fila, 7);
                
                fila++;
            }

}
 }*/
 /*public void llenarTabla(JTable tblGanancias, JLabel lblTotal){
        DefaultTableModel venta = (DefaultTableModel)tblGanancias.getModel(); // para agarrar el modelo de la tabla
        // se hace un casting DefaultTableModel modelo = (DefaultTableModel)tblAutores.getModel();
        
        int fila=0;
        if(vehiculos.size()>0){
            // hashmap con un entry e iterar
            
            for(Vehiculo v:vehiculos){
                venta.addRow(new Object [1]);
                tblGanancias.setValueAt(v.getMarca(), fila, 0);
                tblGanancias.setValueAt(v.getModelo(), fila, 1);
                tblGanancias.setValueAt(v.getColor(), fila, 2);
                tblGanancias.setValueAt(v.getAnio(), fila, 3);
                //tblGanancias.setValueAt(v.getCliente(), fila, 4);//no sirve
                tblGanancias.setValueAt(v.getFechaCompra(), fila, 5);
                tblGanancias.setValueAt(v.getModoPago(), fila, 6);
                tblGanancias.setValueAt(v.getPrecio(), fila, 7);
                fila++;
            }
            lblTotal.setText(vehiculos.size()+" "); // con set y fila o size();
            // autores.size()+" " da error por eso le agg +" " (un espacio).
        }
    }*/
}
