package tools;

import java.util.Scanner;

public class DepurarScan {

    // Scan
    private static Scanner scan = new Scanner(System.in);

    // INT
    public static int scanInt(String mensaje) { // Metemos String para poder mandar el mensaje en el scan
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scan.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un número entero.");
            }
        }
        return valor;
    }

    // Double
    public static double scanDouble(String mensaje) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(scan.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println(" Error: debes introducir un número decimal.");
            }
        }
        return valor;
    }

    // Long
    public static long scanLong(String mensaje) {
        long valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = Long.parseLong(scan.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un número válido.");
            }
        }
        return valor;
    }

    // Boolean
    public static boolean scanBoolean(String mensaje) {
        String respuesta;

        while (true) {
            System.out.print(mensaje + " (si/no): ");
            respuesta = scan.nextLine().trim().toLowerCase();

            if (respuesta.equals("si") || respuesta.equals("sí")) {
                return true;
            } else if (respuesta.equals("no")) {
                return false;
            } else {
                System.out.println("Responde solo con 'si' o 'no'");
            }
        }
    }
}
