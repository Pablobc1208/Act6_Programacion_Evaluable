package tools;

public class DepurarDni {

    private static final String DNI = "^[0-9]{8}-?[A-Z]$";

    public static boolean validarDni(String dni) { // Validcion del dni
        return dni != null && dni.matches(DNI);
    }
}
