package tools;

public class DepurarFecha {
    public static final String FECHADEP = "^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[0-2])/([12][0-9]{3})$";

    public boolean validarFechaCompleta(String fechaInput) {
        // PASO 1: ¿Cumple el formato de tu RegEx?
        if (!fechaInput.matches(FECHADEP)) {
            return false;
        }

        // PASO 2: Extraer partes (suponiendo formato dd/mm/aaaa)
        String[] partes = fechaInput.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        // PASO 3: Lógica de días por mes y bisiestos
        return esFechaReal(dia, mes, anio);
    }

    private boolean esFechaReal(int dia, int mes, int anio) {
        int diasMaximos;

        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                diasMaximos = 30;
                break;
            case 2:
                // Lógica de bisiesto: divisible por 4 pero no por 100, o divisible por 400
                if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                    diasMaximos = 29;
                } else {
                    diasMaximos = 28;
                }
                break;
            default:
                diasMaximos = 31;
                break;
        }

        return dia <= diasMaximos;
    }
}
