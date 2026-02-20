package gastosPersonales;

import tools.*;
import java.time.*;

public class Usuario implements Persona {

    private String nombre;
    private String fechaNacimiento;
    private String dni;
    public static final String FECHADEP = "^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[0-2])/([12][0-9]{3})$";

    public Usuario(String nombre, String fechaNacimiento, String dni) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    @Override
    public int calcularEdad() {
        return 0;
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
