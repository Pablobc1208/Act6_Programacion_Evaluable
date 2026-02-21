package gastosPersonales;

import tools.DepurarScan;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creamos un usuario "vacio" al que le iremos metiendo los datos directamente
        Usuario usuario = new Usuario("", "", "");

        // 1. Creación del usuario y sus datos
        System.out.println("Introduce tu nombre:");
        usuario.setNombre(scanner.nextLine());

        boolean fechaCorrecta = false;
        while (!fechaCorrecta) {
            System.out.println("Introduce tu fecha de nacimiento (dd/MM/yyyy):");
            fechaCorrecta = usuario.setFechaNacimiento(scanner.nextLine());
            if (!fechaCorrecta) {
                System.out.println("La fecha introducida no es válida o no tiene el formato correcto.");
            }
        }

        boolean dniCorrecto = false;
        while (!dniCorrecto) {
            System.out.println("Introduce tu DNI (Ejemplo: 12345678 A):");
            dniCorrecto = usuario.setDni(scanner.nextLine());
            if (!dniCorrecto) {
                System.out.println("El DNI introducido no es correcto o le falta el espacio antes de la letra en mayúscula.");
            }
        }

        // Mostrar edad tras verificar
        System.out.println("Acceso autorizado a la aplicación. Tu edad es " + usuario.calcularEdad());

        // 2. Creación de la cuenta y bienvenida
        Cuenta cuenta = new Cuenta(usuario);
        cuenta.setUsuario(usuario);

        // Llamada a saludar (proveniente de la interfaz Persona)
        System.out.println(cuenta.getUsuario().saludar());

        // 3. Menú de opciones
        String opcion = "";
        while (!opcion.equals("0")) {
            System.out.println("Realiza una nueva acción:");
            System.out.println("1 Introduce un nuevo gasto");
            System.out.println("2 Introduce un nuevo ingreso");
            System.out.println("3 Mostrar los gastos");
            System.out.println("4 Mostrar ingresos");
            System.out.println("5 Mostrar saldo");
            System.out.println("0 Salir");

            opcion = scanner.nextLine();

            // 4. Cada acción realizará una operación
            switch (opcion) {
                case "1":
                    System.out.println("Introduce la descripción del gasto:");
                    String descGasto = scanner.nextLine();
                    double cantGasto = DepurarScan.scanDouble("Introduce la cantidad del gasto: ");

                    // Llama al método de cuenta
                    cuenta.addGastos(descGasto, cantGasto);
                    // Como el método addGastos solo imprime mensajes, nosotros manejamos el
                    // ArrayList aquí
                    if (cuenta.getSaldo() >= cantGasto && cuenta.getSaldo() >= 0) {
                        cuenta.setSaldo(cuenta.getSaldo() - cantGasto);
                        // Añadimos el gasto al ArrayList de Cuenta (Clase abstracta Dinero -> Gastos)
                        cuenta.getGastos().add(new Gastos(cantGasto, descGasto));
                    }
                    break;
                case "2":
                    System.out.println("Introduce la descripción del ingreso:");
                    String descIngreso = scanner.nextLine();
                    double cantIngreso = DepurarScan.scanDouble("Introduce la cantidad del ingreso: ");

                    // Llama al método de cuenta que devuelve el saldo
                    cuenta.setSaldo(cuenta.addIngreso(descIngreso, cantIngreso));
                    // Añadimos el ingreso al ArrayList de Cuenta (Clase abstracta Dinero ->
                    // Ingreso)
                    cuenta.getIngreso().add(new Ingreso(cantIngreso, descIngreso));
                    break;
                case "3":
                    System.out.println("--- Gastos ---");
                    for (int i = 0; i < cuenta.getGastos().size(); i++) {
                        // Polimorfismo / herencia: Usamos los métodos de la clase abstracta Dinero
                        Dinero gasto = cuenta.getGastos().get(i);
                        System.out.println("- " + gasto.getDescripcion() + ": " + gasto.getDinero() + "€");
                    }
                    break;
                case "4":
                    System.out.println("--- Ingresos ---");
                    for (int i = 0; i < cuenta.getIngreso().size(); i++) {
                        // Polimorfismo / herencia: Usamos los métodos de la clase abstracta Dinero
                        Dinero ingreso = cuenta.getIngreso().get(i);
                        System.out.println("- " + ingreso.getDescripcion() + ": " + ingreso.getDinero() + "€");
                    }
                    break;
                case "5":
                    System.out.println("El saldo actual de la cuenta es: " + cuenta.getSaldo() + "€");
                    break;
                case "0":
                    // 5. Fin de la aplicación
                    System.out.println("Fin del programa.\nGracias por utilizar la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

    }
}
