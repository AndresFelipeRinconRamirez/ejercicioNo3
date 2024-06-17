/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.entidades;

/**
 *
 * @author JAIR - PC
 */
public class Habitacion {
    private int numero;
    private boolean disponible;
    private double precio;

    public Habitacion(int numero, double precio) {
        this.numero = numero;
        this.disponible = true;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void reservar() {
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion{");
        sb.append("numero=").append(numero);
        sb.append(", disponible=").append(disponible);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }

    
    
}
