package Control;


import Modelo.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import static javax.print.attribute.Size2DSyntax.MM;

/*
Grupo #4
Integrantes:
*  Ivonne Roxana Minchala Plúas 
 * Joseph Gabriel García Camacho 
 * Marcos Adonis Merchan Mendoza 
 * Alexander Jesús Zambrano Narváez
*/
public class AdmCliente {

    private String administradorCedula = "0123456789";
    private String administradorClave = "1234";

    ArrayList<Cliente> clientes = null;
    ArrayList<Cliente> archivosclientes = null;
    Cliente cliente = null;
    //DatosCliente datosC = null;
    private static AdmCliente admcliente = null;

    public AdmCliente() {
        clientes = new ArrayList<>();
        this.fileToArrayList(); //llamamos a este método para que los datos se carguen al llamar al constructor
    }

    public static AdmCliente getAdmCliente() {
        if (admcliente == null) {
            admcliente = new AdmCliente();
        }
        return admcliente;
    }

    public boolean CedulasRepetidas(String cedula) {
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                x = true;
            }

        }/*if(x==false){
         datosC=new DatosCliente();
    for(Cliente f:datosC.cargarArchivo){
    if(cedula.compareTo(f.getCedula())==0){
    x=true;
    }
    }
    }*/
        return x;
    }

    /* Método que guarda un arraylist a un archivo */
    public void arrayListToFile(Cliente client) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File("files/Clientes.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(client.toString() + "\n");
            System.out.println("información agregada!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /* Método que lee un archivo y posteriormente los guarda en el arraylist */
    public void fileToArrayList() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("files/Clientes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Object[] datos = linea.split(",");
                cliente = new Cliente();
                cliente.setCedula((String) datos[0]);
                cliente.setContrasenia((String) datos[1]);
                cliente.setNombre((String) datos[2]);
                cliente.setApellido((String) datos[3]);
                //default, ISO_LOCAL_DATE
                LocalDate localDate = LocalDate.parse((String) datos[4]);
                cliente.setFechaNac(localDate);
                cliente.setCorreo((String) datos[5]);
                cliente.setTelefono((String) datos[6]);
                cliente.setSexo((String) datos[7]);
                cliente.setCiudad((String) datos[8]);
                cliente.setDireccion((String) datos[9]);
                clientes.add(cliente);
            }
            System.out.println("Lectura exitosa");
        } catch (IOException e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
            }
        }
    }

    public String guardar(String cedula, String contrasenia, String nombre, String apellido, Date fechaNac, String correo, String telefono, String sexo, String ciudad, String direccion) {
        String x = "";

        LocalDate fecha = null;
        if (!cedula.isEmpty() && !contrasenia.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && fechaNac != null && !correo.isEmpty() && !telefono.isEmpty() && !sexo.isEmpty() && !ciudad.isEmpty() && !direccion.isEmpty()) {
            if (cedula.length() == 10) {
                cliente = new Cliente();
                cliente.setCedula(cedula);
                cliente.setContrasenia(contrasenia);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                fecha = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                cliente.setFechaNac(fecha);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);
                cliente.setSexo(sexo);
                cliente.setCiudad(ciudad);
                cliente.setDireccion(direccion);
                clientes.add(cliente);
                this.arrayListToFile(cliente);
                x = cliente.toString();
            } else {
                JOptionPane.showMessageDialog(null, "Error: \nEl numero de cedula esta incompleto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: \nPor Favor llenar todos los datos");
        }
        return x;
    }

    public String GuardarEditado(String cedula, String contrasenia, String nombre, String apellido, Date fechaNac, String correo, String telefono, String sexo, String ciudad, String direccion) {

        String x = " ";
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                a.setNombre(nombre);
                a.setApellido(apellido);
                LocalDate fecha = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                a.setFechaNac(fecha);
                a.setCorreo(correo);
                a.setTelefono(telefono);
                a.setSexo(sexo);
                a.setCiudad(ciudad);
                a.setDireccion(direccion);
                x = a.toString();
            }
        }
        return x;
    }

    public boolean BuscarAdm(String Cedula, String contrasenia) {

        boolean x = false;

        if (Cedula.length() == 10) {
            if (((Cedula.compareTo(administradorCedula) == 0) && contrasenia.compareTo(administradorClave) == 0)) {

                x = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: \nEl numero de cedula esta incompleto");
        }
        return x;
    }

    public boolean BuscarCedula(String cedula, String contrasenia) {
        boolean x = false;

        if (cedula.length() == 10) {
            for (Cliente a : clientes) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    if (contrasenia.compareTo(a.getContrasenia()) == 0) {
                        x = true;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: \nEl numero de cedula esta incompleto");
        }
        return x;
        //if (cedula.length() == 10) {
        //   for (Cliente a : clientes) {

        //      if (cedula.compareTo(a.getCedula()) == 0) {
        //         x = true;
        //     }
        //  }
        /* if (x == false) {
                datosC = new DatosCliente();
                if (datosC.BuscarArchivo()) {
                    for (Cliente a : datosC.cargarArchivo()) {
                        if (cedula.compareTo(a.getCedula()) == 0) {
                            x = true;
                            System.out.print(a.getCedula());
                        }
                    }
                }
            }*/
        // } else {
        //     JOptionPane.showMessageDialog(null, "Error: \nEl numero de cedula esta incompleto");
        // }
        // return x;
    }

    public String EnviarContrasenia(String cedula) {
        String contrasenia = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                contrasenia = a.getContrasenia();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    contrasenia = a.getContrasenia();
                }
            }
        }*/
        return contrasenia;
    }

    public String EnviarNombre(String cedula) {
        String nombre = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                nombre = a.getNombre();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    nombre = a.getNombre();
                }
            }
        }*/
        return nombre;
    }

    public String EnviarApellido(String cedula) {
        String apellido = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                apellido = a.getApellido();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    apellido = a.getApellido();
                }
            }
        }*/
        return apellido;
    }

    public LocalDate EnviarFechaNa(String cedula) {
        LocalDate fecha = null;
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                fecha = a.getFechaNac();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    fecha = a.getFechaNac();
                }
            }
        }*/
        return fecha;
    }

    public String EnviarCorreo(String cedula) {
        String correo = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                correo = a.getCorreo();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    correo = a.getCorreo();
                }
            }
        }*/
        return correo;
    }

    public String EnviarTelefono(String cedula) {
        String telefono = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                telefono = a.getTelefono();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    telefono = a.getTelefono();
                }
            }
        }*/
        return telefono;
    }

    public String EnviarSexo(String cedula) {
        String sexo = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                sexo = a.getSexo();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    sexo = a.getSexo();
                }
            }
        }*/
        return sexo;
    }

    public String EnviarCiudad(String cedula) {
        String ciudad = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                ciudad = a.getCiudad();
                x = true;
            }
        }
        /*if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                   ciudad = a.getCiudad();
                }
            }
        }*/
        return ciudad;
    }

    public String EnviarDireccion(String cedula) {
        String direccion = "";
        boolean x = false;
        for (Cliente a : clientes) {
            if (cedula.compareTo(a.getCedula()) == 0) {
                direccion = a.getDireccion();
                x = true;
            }
        }
        /* if (x == false) {
            for (Cliente a : datosC.cargarArchivo()) {
                if (cedula.compareTo(a.getCedula()) == 0) {
                    direccion = a.getDireccion();
                }
            }
        }*/
        return direccion;
    }

    public void llenarTabla(JTable tblConCliente, JLabel lblTotal) {
        DefaultTableModel modelo = (DefaultTableModel) tblConCliente.getModel(); // para agarrar el modelo de la tabla
        // se hace un casting DefaultTableModel modelo = (DefaultTableModel)tblAutores.getModel();

        int fila = 0;
        if (clientes.size() > 0) {
            // hashmap con un entry e iterar

            for (Cliente a : clientes) {
                modelo.addRow(new Object[1]); // una fila añadida
                tblConCliente.setValueAt(a.getCedula(), fila, 0);
                //tblConCliente.setValueAt(a.getContrasenia(), fila, 1);
                tblConCliente.setValueAt(a.getNombre(), fila, 1);
                tblConCliente.setValueAt(a.getApellido(), fila, 2);
                tblConCliente.setValueAt(a.getFechaNac(), fila, 3);
                tblConCliente.setValueAt(a.getCorreo(), fila, 4);
                tblConCliente.setValueAt(a.getTelefono(), fila, 5);
                tblConCliente.setValueAt(a.getSexo(), fila, 6);
                tblConCliente.setValueAt(a.getCiudad(), fila, 7);
                tblConCliente.setValueAt(a.getDireccion(), fila, 8);
                fila++;
            }
            lblTotal.setText(clientes.size() + " "); // con set y fila o size();
            // autores.size()+" " da error por eso le agg +" " (un espacio).
        }
    }

    /* public void verArchivo(JDialog frmVer, JTextArea txtContenido) {
        String contenido = "";
        datosC = new DatosCliente();
        contenido = datosC.leerArchivo();
        if (contenido.compareTo("") != 0) {//si no esta vacia la cadena
            //control para cuando se da clic en cancel
            txtContenido.append(contenido);
            txtContenido.setEditable(false);
            frmVer.setVisible(true);
        }
    }

    public void guardarArchivo() {
        String resultado = "";
        if (clientes.size() > 0) {
            datosC = new DatosCliente();
            resultado = datosC.guardarClientes(clientes);
            if (resultado.charAt(0) == '1') {
                JOptionPane.showMessageDialog(null, "el archivo se a guardado exitosamente", "informacion",
                        JOptionPane.INFORMATION_MESSAGE);

            } else if (resultado.charAt(0) == '0') {
                JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado. Error" + resultado,
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe infromacion para guardar", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void eliminar(JTable tblAutores, JLabel lblTotal) {
        DefaultTableModel modelo = (DefaultTableModel) tblAutores.getModel();
        int fila = tblAutores.getSelectedRow();
        if (fila >= 0) {
            modelo.removeRow(fila);
            clientes.remove(fila);
        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila para eliminar");
        }

    }*/
}
