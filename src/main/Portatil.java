package main;

public class Portatil extends Dispositivo{
    private boolean tipoDisco; // false hdd, true ssd
    private int capacidadDisco;
    private int capacidadRAM;
    private int numeroDispositivo;
    private static int contador = 0;

    @Override
    public String toString() {
        return "Portatil{" +
                "numeroDispositivo=" + numeroDispositivo + " numero de serie: " + super.getNumSerie() + " modelo: " + super.getModelo() + " marca: " + super.getMarca() +
                '}';
    }

    public Portatil() {
    }

    public Portatil(String numSerie, String marca, String modelo, double pulgadasPantalla, int numEmpleado, boolean activo, boolean tipoDisco, int capacidadDisco, int capacidadRAM) {
        super(numSerie, marca, modelo, pulgadasPantalla, numEmpleado, activo);
        this.tipoDisco = tipoDisco;
        this.capacidadDisco = capacidadDisco;
        this.capacidadRAM = capacidadRAM;
        this.numeroDispositivo = contador;
        contador++;
    }

    public Portatil(boolean activo) {
        super(activo);
        this.numeroDispositivo = this.getNumeroDispositivo();
        this.numeroDispositivo++;
    }

    public boolean isTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(boolean tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public int getCapacidadDisco() {
        return capacidadDisco;
    }

    public void setCapacidadDisco(int capacidadDisco) {
        this.capacidadDisco = capacidadDisco;
    }

    public int getCapacidadRAM() {
        return capacidadRAM;
    }

    public void setCapacidadRAM(int capacidadRAM) {
        this.capacidadRAM = capacidadRAM;
    }

    public int getNumeroDispositivo() {
        return numeroDispositivo;
    }

    public void setNumeroDispositivo(int numeroDispositivo) {
        this.numeroDispositivo = numeroDispositivo;
    }
}
