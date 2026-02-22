package gastosPersonales;

import tools.DepurarScan;
import java.util.Scanner;

public class Main {
    public static final String AMARILLO = "\u001B[33m"; // Color amarillo en constante
    public static final String RESET = "\u001B[0m"; // Para volver al color actual

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Declaramos Scanner

        // Creamos un usuario vacio al que le iremos metiendo los datos
        Usuario usuario = new Usuario("", "", "");

        // Creación del usuario y sus datos
        System.out.println("Introduce tu nombre:");
        usuario.setNombre(scan.nextLine());

        boolean fechaCorrecta = false;
        while (!fechaCorrecta) { // Depuracion de fechas
            System.out.println("Introduce tu fecha de nacimiento (dd/MM/yyyy):");
            fechaCorrecta = usuario.setFechaNacimiento(scan.nextLine());
            if (!fechaCorrecta) {
                System.out.println("La fecha introducida no es válida o no tiene el formato correcto.");
            }
        }

        boolean dniCorrecto = false;
        while (!dniCorrecto) { // Depuracion DNI
            System.out.println("Introduce tu DNI (Ejemplo: 12345678 A):");
            dniCorrecto = usuario.setDni(scan.nextLine());
            if (!dniCorrecto) {
                System.out.println(
                        "El DNI introducido no es correcto o le falta el espacio antes de la letra en mayúscula.");
            }
        }

        // Mostrar edad
        System.out.println("Acceso autorizado a la aplicación. Tu edad es " + usuario.calcularEdad());

        // Creación de la cuenta y bienvenida
        Cuenta cuenta = new Cuenta(usuario);
        cuenta.setUsuario(usuario);

        // Llamada a saludar
        System.out.println(cuenta.getUsuario().saludar());

        // Menu
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Realiza una nueva acción:");
            System.out.println("1 Introduce un nuevo gasto");
            System.out.println("2 Introduce un nuevo ingreso");
            System.out.println("3 Mostrar los gastos");
            System.out.println("4 Mostrar ingresos");
            System.out.println("5 Mostrar saldo");
            System.out.println("0 Salir");

            opcion = DepurarScan.scanInt("");

            switch (opcion) {
                case 1:
                    System.out.println("Introduce la descripción del gasto:");
                    String descGasto = scan.nextLine();
                    double cantGasto = DepurarScan.scanDouble("Introduce la cantidad del gasto: ");

                    // Llama al método añadir gastos
                    if (cantGasto > cuenta.getSaldo() || cuenta.getSaldo() < 0) {
                        System.out.println("No es posible gestionar este gasto. Saldo Insuficiente !!!!!!");
                    } else {
                        cuenta.setSaldo(cuenta.addGastos(descGasto, cantGasto));
                        System.out
                                .println("Saldo actualizado correctamente!!!! ." + "Tu Saldo es: " + cuenta.getSaldo());
                    }

                    break;
                case 2:
                    System.out.println("Introduce la descripción del ingreso:");
                    String descIngreso = scan.nextLine();
                    double cantIngreso = DepurarScan.scanDouble("Introduce la cantidad del ingreso: ");

                    cuenta.setSaldo(cuenta.addIngreso(descIngreso, cantIngreso)); // Llamada a metodo AddIngreso
                    System.out.println("Saldo actualizado correctamente!!!! ." + "Tu Saldo es: " + cuenta.getSaldo());

                    break;
                case 3:
                    System.out.println("--- Gastos ---");
                    for (Gastos gastos : cuenta.getGastos()) { // Mostramos Gastos
                        System.out.println("- " + gastos.getDescripcion() + ": " + gastos.getDinero() + "€");
                    }
                    break;
                case 4:
                    System.out.println("--- Ingresos ---");
                    for (Ingreso ingreso : cuenta.getIngreso()) { // Mostramos Ingresos
                        System.out.println("- " + ingreso.getDescripcion() + ": " + ingreso.getDinero() + "€");
                    }
                    break;
                case 5:
                    System.out.println("El saldo actual de la cuenta es: " + cuenta.getSaldo() + "€"); // Mostramos
                                                                                                       // Saldo
                    break;
                case 0:
                    // Case 0 que acaba el programa
                    System.out.println(AMARILLO + "Fin del programa.\nGracias por utilizar la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
        scan.close(); // Cerramos Scan
    }

}
