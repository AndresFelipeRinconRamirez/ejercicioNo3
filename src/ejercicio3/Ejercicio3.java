
package ejercicio3;


import co.edu.uniminuto.entidades.Cliente;
import co.edu.uniminuto.entidades.Habitacion;
import co.edu.uniminuto.entidades.Reserva;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/*
3. Crea un sistema para gestionar reservas en un hotel. Se desea emitir un ticket donde esté
la habitación reservada, datos personales del cliente y el pago por la habitación. Crear un
menú que simule gestionar habitaciones, usuarios y crear la reserva (impresión de ticket).
*/
public class Ejercicio3 {
 private static List<Habitacion> habitaciones = new ArrayList<>();
    public static void main(String[] args) {
        // TODO code application logic here
                inicializarHabitaciones();

        int opcion;
        do {
            opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    gestionarHabitaciones();
                    break;
                case 2:
                    gestionarReserva();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", 
                            "Error",  JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } while (opcion != 3);
    }

    private static void inicializarHabitaciones() {
        // Inicializar algunas habitaciones
        habitaciones.add(new Habitacion(10, 100));
        habitaciones.add(new Habitacion(20, 120));
        habitaciones.add(new Habitacion(30, 150));
    }

    private static int mostrarMenu() {
        String[] opciones = {"Gestionar Habitaciones", "Crear Reserva", "Salir"};
        return JOptionPane.showOptionDialog(null, "Seleccione una opción:", 
                "Menú Principal", JOptionPane.DEFAULT_OPTION,
             JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]) + 1;
    }

    private static void gestionarHabitaciones() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Habitaciones Disponibles:\n");
        for (Habitacion hab : habitaciones) {
            sb.append(hab.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), 
                "Habitaciones Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void gestionarReserva() {
        // Selección de habitación y cliente para la reserva
        Habitacion habitacionSeleccionada = seleccionarHabitacion();
        if (habitacionSeleccionada != null) {
            Cliente cliente = ingresarDatosCliente();
            if (cliente != null) {
                realizarReserva(habitacionSeleccionada, cliente);
            }
        }
    }

    private static Habitacion seleccionarHabitacion() {
        String[] opciones = new String[habitaciones.size()];
        for (int i = 0; i < habitaciones.size(); i++) {
            opciones[i] = "Habitación " + habitaciones.get(i).getNumero();
        }
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una "
                + "habitación:", "Selección de Habitación",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, opciones, opciones[0]);
        
        if (seleccion >= 0 && seleccion < habitaciones.size()) {
            return habitaciones.get(seleccion);
        } else {
            return null;
        }
    }

    private static Cliente ingresarDatosCliente() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre "
                + "del "
                + "cliente:", "Datos del Cliente", JOptionPane.QUESTION_MESSAGE);
        if (nombre != null && !nombre.isEmpty()) {
            String documento = JOptionPane.showInputDialog(null, "Ingrese el "
                    + "documento del cliente:", "Datos del Cliente", 
                    JOptionPane.QUESTION_MESSAGE);
            if (documento != null && !documento.isEmpty()) {
                return new Cliente(nombre, documento);
            }
        }
        return null;
    }

    private static void realizarReserva(Habitacion habitacion, Cliente cliente) {
        Reserva reserva = new Reserva(habitacion, cliente);
        JOptionPane.showMessageDialog(null, reserva.toString(), 
                "Reserva Realizada", JOptionPane.INFORMATION_MESSAGE);
        habitacion.reservar(); // Marcar la habitación como reservada
    }
}
        
    
    

