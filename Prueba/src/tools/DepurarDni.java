package tools;

public class DepurarDni {

    private static final String DNI = "^([0-9]{8} | [XxZzYy] -? [0-9]{7}) -? [A-Z]$";

    public static boolean validarDni(String dni) { // Validcion del dni y nie
        return dni != null && dni.matches(DNI);
    }
}
