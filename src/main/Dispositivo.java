package main;

public class Dispositivo {
    private String numSerie; //TODO que no se repita
    private String marca;
    private String modelo;
    private double pulgadasPantalla;
    private int numEmpleado;
    private boolean activo;
    private boolean reparacion;

    public Dispositivo() {
    }

    public Dispositivo(String numSerie, String marca, String modelo, double pulgadasPantalla, int numEmpleado, boolean activo) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.pulgadasPantalla = pulgadasPantalla;
        this.numEmpleado = -1;
        this.activo = activo;
        this.reparacion = false;
    }

    public Dispositivo(boolean activo) {
        this.activo = activo;
        this.numEmpleado = -1;
        this.reparacion = false;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "numSerie='" + numSerie + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", pulgadasPantalla=" + pulgadasPantalla +
                ", numEmpleado=" + numEmpleado +
                '}';
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPulgadasPantalla() {
        return pulgadasPantalla;
    }

    public void setPulgadasPantalla(double pulgadasPantalla) {
        this.pulgadasPantalla = pulgadasPantalla;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isReparacion() {
        return reparacion;
    }

    public void setReparacion(boolean reparacion) {
        this.reparacion = reparacion;
    }
}
