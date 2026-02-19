package tools;

import java.util.Scanner;

public class DepurarDni {

    private static final String DNI = "^[0-9]{8}-?[A-Z]$";
    private String dni;

    public static boolean validarDni(String dni) { // Validcion del dni
        return dni != null && dni.matches(DNI);
    }
}
