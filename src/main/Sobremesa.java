package main;

public class Sobremesa extends Dispositivo{
    private int capacidadHDD;
    private int capacidadRAM;
    private String marcaTeclado;
    private String marcaRaton;
    private String marcaMonitor;
    private static int contador = 0;
    private int numeroDispositivo;

    @Override
    public String toString() {
        return "Sobremesa{" +
                "numeroDispositivo=" + numeroDispositivo + " numero de serie: " + super.getNumSerie() + " modelo: " + super.getModelo() + " marca: " + super.getMarca() +
                '}';
    }

    public Sobremesa(String numSerie, String marca, String modelo, double pulgadasPantalla, int numEmpleado, boolean activo, int capacidadHDD, int capacidadRAM, String marcaTeclado, String marcaRaton, String marcaMonitor) {
        super(numSerie, marca, modelo, pulgadasPantalla, numEmpleado, activo);
        this.capacidadHDD = capacidadHDD;
        this.capacidadRAM = capacidadRAM;
        this.marcaTeclado = marcaTeclado;
        this.marcaRaton = marcaRaton;
        this.marcaMonitor = marcaMonitor;
        this.numeroDispositivo = contador;
        contador++;
    }

    public Sobremesa(boolean activo) {
        super(activo);
        this.numeroDispositivo = this.getNumeroDispositivo();
        this.numeroDispositivo++;
    }

    public int getCapacidadHDD() {
        return capacidadHDD;
    }

    public void setCapacidadHDD(int capacidadHDD) {
        this.capacidadHDD = capacidadHDD;
    }

    public int getCapacidadRAM() {
        return capacidadRAM;
    }

    public void setCapacidadRAM(int capacidadRAM) {
        this.capacidadRAM = capacidadRAM;
    }

    public String getMarcaTeclado() {
        return marcaTeclado;
    }

    public void setMarcaTeclado(String marcaTeclado) {
        this.marcaTeclado = marcaTeclado;
    }

    public String getMarcaRaton() {
        return marcaRaton;
    }

    public void setMarcaRaton(String marcaRaton) {
        this.marcaRaton = marcaRaton;
    }

    public String getMarcaMonitor() {
        return marcaMonitor;
    }

    public void setMarcaMonitor(String marcaMonitor) {
        this.marcaMonitor = marcaMonitor;
    }

    public int getNumeroDispositivo() {
        return numeroDispositivo;
    }

    public void setNumeroDispositivo(int numeroDispositivo) {
        this.numeroDispositivo = numeroDispositivo;
    }


}
