package gastosPersonales;

import java.util.ArrayList;

public class Cuenta {
    // Declaracion de Atributos
    private double saldo;
    private Usuario usuario;
    private ArrayList<Gastos> gastos = new ArrayList<>();
    private ArrayList<Ingreso> ingreso = new ArrayList<>();

    public Cuenta(Usuario usuario) { // Constructor
        this.saldo = 0;
        this.usuario = usuario;
    }

    public double addIngreso(String descripcion, double cantidad) { // Metodo Añadir Ingresos
        ingreso.add(new Ingreso(cantidad, descripcion));
        saldo = saldo + cantidad;
        return saldo;
    }

    public double addGastos(String descripcion, double cantidad) { // Metodo Añadir Gastos
        if (saldo < 0 || cantidad > saldo) {
            return saldo;
        } else {
            gastos.add(new Gastos(cantidad, descripcion));
            saldo = saldo - cantidad;
            return saldo;
        }
    }

    // Metodos Getters y Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Gastos> getGastos() {
        return gastos;
    }

    public void setGastos(ArrayList<Gastos> gastos) {
        this.gastos = gastos;
    }

    public ArrayList<Ingreso> getIngreso() {
        return ingreso;
    }

    public void setIngreso(ArrayList<Ingreso> ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
