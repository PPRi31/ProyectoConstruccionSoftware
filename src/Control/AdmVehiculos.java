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


public class AdmVehiculos {

// Creas un nuevo arraylist

    ArrayList<Vehiculo> vehiculos = null;
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
}
