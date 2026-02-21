package gastosPersonales;

import java.util.ArrayList;

public class Cuenta {
    private double saldo;
    private Usuario usuario;
    private ArrayList<Gastos> gastos = new ArrayList<>();
    private ArrayList<Ingreso> ingreso = new ArrayList<>();

    public Cuenta(Usuario usaurio) {
        this.saldo = 0;
        this.usuario = usuario;
    }

    public double addIngreso(String descripcion, double cantidad) {
        return saldo + cantidad;
    }

    public void addGastos(String descripcion, double cantidad) {
        if (saldo < 0 || cantidad > saldo) {
            System.out.println("No se pudo restar el saldo. Saldo insuficiente!!!!!");
        } else {
            double restarSaldo = cantidad - saldo;
            System.out.println("Tu saldo se ha actualizado correctamente!!!!" + restarSaldo);
        }
    }

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
