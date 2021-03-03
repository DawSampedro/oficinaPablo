package main;

public class Movil extends Dispositivo{
    private int resolucionCamara;
    private int numeroDispositivo;
    private static int contador = 0;

    @Override
    public String toString() {
        return "Movil{" +
                "numeroDispositivo=" + numeroDispositivo + " numero de serie: " + super.getNumSerie() + " modelo: " + super.getModelo() + " marca: " + super.getMarca() +
                '}';
    }

    public Movil() {
    }

    public Movil(String numSerie, String marca, String modelo, double pulgadasPantalla, int numEmpleado, boolean activo, int resolucionCamara) {
        super(numSerie, marca, modelo, pulgadasPantalla, numEmpleado, activo);
        this.resolucionCamara = resolucionCamara;
        this.numeroDispositivo = contador;
        contador++;
    }

    public Movil(boolean activo) {
        super(activo);
        this.numeroDispositivo = contador;
        contador++;
    }

    public Movil(int resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
        this.numeroDispositivo = contador;
        contador++;
    }

    public int getResolucionCamara() {
        return resolucionCamara;
    }

    public void setResolucionCamara(int resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
    }

    public int getNumeroDispositivo() {
        return numeroDispositivo;
    }

    public void setNumeroDispositivo(int numeroDispositivo) {
        this.numeroDispositivo = numeroDispositivo;
    }
}
