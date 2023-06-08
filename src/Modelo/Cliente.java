package Modelo;

import java.time.LocalDate;
import java.util.Date;

/*
Grupo #4
Integrantes:
*  Ivonne Roxana Minchala Plúas 
 * Joseph Gabriel García Camacho 
 * Marcos Adonis Merchan Mendoza 
 * Alexander Jesús Zambrano Narváez
*/
public class Cliente {

    private String cedula, contrasenia, nombre, apellido, correo, telefono, sexo, ciudad, direccion;
    private LocalDate fechaNac;

    public Cliente(String cedula, String contrasenia, String nombre, String apellido, LocalDate fechaNac, String correo, String telefono, String sexo, String ciudad, String direccion) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.telefono = telefono;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.direccion = direccion;

    }

    public Cliente() {
        cedula = " ";
        contrasenia = " ";
        nombre = " ";
        apellido = " ";
        fechaNac = LocalDate.now();
        correo = " ";
        telefono = " ";
        sexo = " ";
        ciudad = " ";
        direccion = " ";

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return cedula + ","+contrasenia + "," + nombre + "," + apellido + "," + fechaNac + "," + correo + "," + telefono + "," + sexo + "," + ciudad + "," + direccion;
    }

}
