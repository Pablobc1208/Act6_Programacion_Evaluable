package gastosPersonales;

import tools.*;
import java.util.*;

public class Usuario implements Persona {

    private String nombre;
    private String fechaNacimiento;
    private String dni;

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

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
