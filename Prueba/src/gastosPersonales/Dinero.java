package gastosPersonales;

public abstract class Dinero {
    // Declaracion de Atributos
    protected double dinero;
    protected String descripcion;

    public Dinero(double dinero, String descripcion) { // Constructor
        this.dinero = dinero;
        this.descripcion = descripcion;
    }

    // Metodos Getters y Setters
    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
