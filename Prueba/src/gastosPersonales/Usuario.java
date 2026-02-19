package gastosPersonales;

import tools.*;
import java.util.*;

public class Usuario implements Persona {

    Scanner scan = new Scanner(System.in);
    private String nombre;
    private String fechaNacimiento;
    private String dni;
    public static final String DNI = "^[0-9]{8}[A-Z]$";

    public Usuario(String nombre, String fechaNacimiento, String dni) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    public void validarDni() { // Validcion del dni
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Dime tu dni: ");
            dni = scan.nextLine().trim().toUpperCase();
            if (dni.matches(DNI)) {
                entradaValida = true;
            } else {
                System.out.println("dni no valido");
            }
        }
    }

    @Override
    public int calcularEdad() {
        throw new UnsupportedOperationException("Unimplemented method 'calcularEdad'");
    }

    @Override
    public String saludar() {
        throw new UnsupportedOperationException("Unimplemented method 'saludar'");
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

    public void setDni(String dni) {
        this.dni = dni;
    }

}
