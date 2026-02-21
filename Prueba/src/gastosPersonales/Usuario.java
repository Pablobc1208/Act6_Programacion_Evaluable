package gastosPersonales;

import tools.*; //Importamos el package tools
import java.time.*; //Importamos libreria time

public class Usuario implements Persona {

    private String nombre;
    private String fechaNacimiento;
    private String dni;
    public static final String FECHADEP = "^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[0-2])/([12][0-9]{3})$";

    public Usuario(String nombre, String fechaNacimiento, String dni) { // Constructor
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    @Override
    public int calcularEdad() { // Metodo para calcular la edad
        // 1. Separar y convertir
        String[] partes = fechaNacimiento.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        // 2. Obtener día, mes y año ACTUALES
        LocalDate hoy = LocalDate.now();
        int diaActual = hoy.getDayOfMonth();
        int mesActual = hoy.getMonthValue();
        int anioActual = hoy.getYear();

        // 3. Restar los años directamente
        int edad = anioActual - anio;

        // 4. Ajustar si aún no ha llegado su cumpleaños este año
        if (mesActual < mes || (mesActual == mes && diaActual < dia)) {
            edad--; // Le restamos 1 a la edad
        }
        return edad;
    }

    @Override
    public String saludar() {
        return "Bienvenido al programa de gestión de gastos personales" + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean setFechaNacimiento(String fechaNacimiento) {
        if (DepurarFecha.validarFechaCompleta(fechaNacimiento)) {
            this.fechaNacimiento = fechaNacimiento;
            return true;
        } else {
            return false;
        }
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni) {
        if (DepurarDni.validarDni(dni)) {
            this.dni = dni;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tu dni es: " + dni + " " + getDni() +
                "Tu nombre es: " + nombre + "Tu edad es: " + calcularEdad();
    }
}
