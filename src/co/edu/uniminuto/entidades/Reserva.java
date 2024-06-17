/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.entidades;

/**
 *
 * @author JAIR - PC
 */
public class Reserva {
    private Habitacion habitacion;
    private Cliente cliente;

    public Reserva(Habitacion habitacion, Cliente cliente) {
        this.habitacion = habitacion;
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calcularCosto() {
        return habitacion.getPrecio();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva{");
        sb.append("habitacion=").append(habitacion);
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }

    
    }

