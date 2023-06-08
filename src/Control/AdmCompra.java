
package Control;
/*
Grupo #4
Integrantes:
*  Ivonne Roxana Minchala Plúas 
 * Joseph Gabriel García Camacho 
 * Marcos Adonis Merchan Mendoza 
 * Alexander Jesús Zambrano Narváez
*/
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import Modelo.Vehiculo;
import Control.AdmVehiculos;

import Modelo.Cliente;
import excepcion.miExcepcion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class AdmCompra {

    private String camaro = "Camaro";
    private String sail = "Sail";
    private String venue = "Venue";
    private String elantra = "Elantra";
    private String rush = "Rush";
    private String corolla = "Corolla";
    private String camaro2 = "25.500"; //Precios Normales
    private String sail2 = "15.000";
    private String venue2 = "15.200";
    private String elantra2 = "18.000";
    private String rush2 = "20.000";
    private String corolla2 = "15.000";
    private String camarof = "28.560"; //Precio final con Iva al contado
    private String sailf = "16.800";
    private String venuef = "17.024";
    private String elantraf = "20.160";
    private String rushf = "22.400";
    private String corollaf = "16.800";
    private String camaroC = "30.560"; //Precio final CON CREDITO
    private String sailC = "18.800";
    private String venueC = "19.024";
    private String elantraC = "22.160";
    private String rushC = "24.400";
    private String corollaC = "18.800";
    private String Ccamaro = "6 Años"; //Cuotas de los Creditos
    private String Csail = "5 Años";
    private String Cvenue = "5 Años";
    private String Celantra = "6 Años";
    private String Crush = "6 Años";
    private String Ccorolla = "5 Años";
    private String Icamaro = "+3.060"; //Iva del contado
    private String Isail = "+1.800";
    private String Ivenue = "+1.824";
    private String Ielantra = "+2.160";
    private String Irush = "+2.400";
    private String Icorolla = "+1.800";
    // Creas un nuevo arraylist
    ArrayList<Vehiculo> listaVehiculosEliminados = new ArrayList<>();
    AdmCliente admCliente = AdmCliente.getAdmCliente();
    ArrayList<Vehiculo> vehiculos = null;
    Vehiculo compraVehiculo = null;
    //DatosCompra  datosc=null;
    private static AdmCompra admcompra = null;

    public AdmCompra() {
        vehiculos = new ArrayList<>();
        //this.vehiculoToArrayList();
      
    }

    public static AdmCompra getAdmCompra() {
        if (admcompra == null) {
            admcompra = new AdmCompra();
        }
        return admcompra;
    }

    public ArrayList<Vehiculo> getListadoCompras() {
        return vehiculos;
    }
// Agregas este método

    public void añadircancelados(Vehiculo p,String fecha) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File("VehiculosEliminados.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter("VehiculosEliminados.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(p.getNumchasis()+"#"+p.getMarca()+"#"+p.getModelo()+"#"+p.getColor()+"#"+p.getAnio()+"#"+p.getPrecio()+"#"+p.getModoPago()+"#"+p.getPrecioFinal()+"#"+p.getCuota()+"#"+fecha+"\r\n");
            bw.close();
            System.out.println("Archivo guardado.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("falló al guardar");

        }
    }
// Luego agregas este método
   

    

    public String BuscarModelo(String modelo) {

        String Precio = "dfsdf";

        if (modelo.compareTo(camaro) == 0) {
            Precio = camaro2;
            return Precio;

        } else if (modelo.compareTo(sail) == 0) {
            Precio = sail2;
            return Precio;
        } else if (modelo.compareTo(venue) == 0) {
            return Precio = venue2;

        } else if (modelo.compareTo(elantra) == 0) {
            return Precio = elantra2;

        } else if (modelo.compareTo(rush) == 0) {
            return Precio = rush2;

        } else if (modelo.compareTo(corolla) == 0) {
            return Precio = corolla2;

        } else {

            JOptionPane.showMessageDialog(null, "Error: \nNo se encontro precio");
        }
        return Precio;

    }

    public String BuscarContado(String modelo) {

        String Precio = "dfsdf";

        if (modelo.compareTo(camaro2) == 0) {
            Precio = camarof;
            return Precio;

        } else if (modelo.compareTo(sail2) == 0) {
            Precio = sailf;
            return Precio;
        } else if (modelo.compareTo(venue2) == 0) {
            return Precio = venuef;

        } else if (modelo.compareTo(elantra2) == 0) {
            return Precio = elantraf;

        } else if (modelo.compareTo(rush2) == 0) {
            return Precio = rushf;

        } else if (modelo.compareTo(corolla2) == 0) {
            return Precio = corollaf;

        } else {

            JOptionPane.showMessageDialog(null, "Error: \nNo se encontro precio");
        }
        return Precio;

    }

    public String BuscarCredito(String modelo) {

        String Precio = "dfsdf";

        if (modelo.compareTo(camaro2) == 0) {
            Precio = camaroC;
            return Precio;

        } else if (modelo.compareTo(sail2) == 0) {
            Precio = sailC;
            return Precio;
        } else if (modelo.compareTo(venue2) == 0) {
            return Precio = venueC;

        } else if (modelo.compareTo(elantra2) == 0) {
            return Precio = elantraC;

        } else if (modelo.compareTo(rush2) == 0) {
            return Precio = rushC;

        } else if (modelo.compareTo(corolla2) == 0) {
            return Precio = corollaC;

        } else {

            JOptionPane.showMessageDialog(null, "Error: \nNo se encontro precio");
        }
        return Precio;

    }

    public String BuscarCuota(String Cuota) {

        String Precio = "dfsdf";

        if (Cuota.compareTo(camaro2) == 0) {
            Precio = Ccamaro;
            return Precio;

        } else if (Cuota.compareTo(sail2) == 0) {
            Precio = Csail;
            return Precio;
        } else if (Cuota.compareTo(venue2) == 0) {
            return Precio = Cvenue;

        } else if (Cuota.compareTo(elantra2) == 0) {
            return Precio = Celantra;

        } else if (Cuota.compareTo(rush2) == 0) {
            return Precio = Crush;

        } else if (Cuota.compareTo(corolla2) == 0) {
            return Precio = Ccorolla;

        } else {

            JOptionPane.showMessageDialog(null, "Error: \nNo se encontro precio");
        }
        return Precio;

    }

    public boolean BuscarCedula(String cedula) {
        boolean x = false;

        if (cedula.length() == 10) {
            for (Cliente a : admCliente.clientes) {
                if (cedula.compareTo(a.getCedula()) == 0) {

                    x = true;

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: \nEl numero de cedula esta incompleto");
        }
        return x;
    }

    private boolean compraExiste(String marca) {
        boolean retorno = false;
        for (Vehiculo c : vehiculos) {
            if (c.getMarca().compareTo(marca) == 0) {
                retorno = true;
            }
        }
        return retorno;
    }

   

    public String BuscarIva(String modelo) {

        String Iva = "dfsdf";

        if (modelo.compareTo(camaro2) == 0) {
            Iva = Icamaro;
            return Iva;

        } else if (modelo.compareTo(sail2) == 0) {
            Iva = Isail;
            return Iva;
        } else if (modelo.compareTo(venue2) == 0) {
            return Iva = Ivenue;

        } else if (modelo.compareTo(elantra2) == 0) {
            return Iva = Ielantra;

        } else if (modelo.compareTo(rush2) == 0) {
            return Iva = Irush;

        } else if (modelo.compareTo(corolla2) == 0) {
            return Iva = Icorolla;

        } else {

            JOptionPane.showMessageDialog(null, "Error: \nNo se encontro Iva");
        }
        return Iva;

    }
    

    public void GuardarCompra(String chevrolet, String hyundai, String toyota, String camaro, String sail, String venue, String elantra, String rush, String corolla, String precio, Date fecha, String contado, String precioIva, String credito, String precioCredito, String cuotas, String tarjeta, String clave) {
        LocalDate fechaC = null;
        Cliente admCliente = new Cliente();
        if (!chevrolet.isEmpty() && !hyundai.isEmpty() && !toyota.isEmpty() && !camaro.isEmpty() && !sail.isEmpty() && !venue.isEmpty() && !elantra.isEmpty() && !rush.isEmpty() && !corolla.isEmpty() && !precio.isEmpty() && fecha != null && !contado.isEmpty()
                && !precioIva.isEmpty() && !credito.isEmpty() && !precioCredito.isEmpty() && !cuotas.isEmpty() && !tarjeta.isEmpty() && !clave.isEmpty()) {

            compraVehiculo = new Vehiculo();
            compraVehiculo.setMarca(chevrolet);
            compraVehiculo.setMarca(hyundai);
            compraVehiculo.setMarca(toyota);
            compraVehiculo.setModelo(camaro);
            compraVehiculo.setModelo(sail);
            compraVehiculo.setModelo(venue);
            compraVehiculo.setModelo(elantra);
            compraVehiculo.setModelo(rush);
            compraVehiculo.setModelo(corolla);
            compraVehiculo.setPrecio(precio);
            compraVehiculo.setFechaCompra(fechaC);
            compraVehiculo.setModoPago(contado);
            compraVehiculo.setModoPago(credito);
            compraVehiculo.setPrecioFinal(precioIva);
            compraVehiculo.setPrecioFinal(precioCredito);
            compraVehiculo.setCuota(cuotas);

            vehiculos.add(compraVehiculo);
            JOptionPane.showMessageDialog(null, "Compra Guardada Correctamente ");
        } else {
            JOptionPane.showMessageDialog(null, "Error: \nNo se guardaron los datos");

        }

    }

}
