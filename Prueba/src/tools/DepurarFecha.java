package tools;

public class DepurarFecha {
    public static final String FECHADEP = "^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[0-2])/([12][0-9]{3})$";

    public static boolean validarFechaCompleta(String fecha) {
        // Comprobamos Regex
        if (!fecha.matches(FECHADEP)) {
            return false;
        }

        // Separamos por dd mm aaaa
        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        return esFechaReal(dia, mes, anio);
    }

    public static boolean esFechaReal(int dia, int mes, int anio) {
        int diasMaximos;
        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                diasMaximos = 30;
                break;
            case 2:
                // Comprobacion de años bisiesto
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

        return dia <= diasMaximos; /*
                                    * Usamos "<=" para ahorrarnos un if devuelve true o false dependiendo de si dia
                                    * es <= a diamax
                                    */
    }
}
