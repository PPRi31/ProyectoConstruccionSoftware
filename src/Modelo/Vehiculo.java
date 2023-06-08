package Modelo;

import java.time.LocalDate;
import java.util.Date;

public class Vehiculo {

    public String marca, modelo, color, anio, precio, modoPago, precioFinal, cuota,numchasis;
    LocalDate fechaCompra;
   
    public Vehiculo(String numchasis,String marca, String modelo, String color, String anio,String precio, String modoPago, String precioFinal, String cuota){
    LocalDate fechaCompra = null;
        this.numchasis=numchasis;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.precio=precio;
        this.fechaCompra=fechaCompra;
        this.modoPago=modoPago;
        this.precioFinal=precioFinal;
        this.cuota=cuota;
    }

    public String getNumchasis() {
        return numchasis;
    }

    public void setNumchasis(String numchasis) {
        this.numchasis = numchasis;
    }

    public Vehiculo() {
     
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }   
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getAnio() {
        return anio;
    }
    public void setAnio(String anio) {
        this.anio = anio;
    }
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public String getModoPago() {
        return modoPago;
    }
    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }
    public String getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(String precioFinal) {
        this.precioFinal = precioFinal;
    }
    public String getCuota() {
        return cuota;
    }
    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

@Override
public String toString() {
    return marca + "," + modelo + "," + color + "," + anio + "," + precio + 
      "," + fechaCompra + "," + modoPago + "," + precioFinal + "," + cuota;
}


}
