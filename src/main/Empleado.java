package main;

public class Empleado {
    private String nombre;
    private String apellidos;
    private String dni;
    private int numeroEmpleado;
    private static int contadorEmpleado = 0;
    private boolean alta;
    private int numeroSobremesa;
    private int numeroPortatil;
    private int numeroMovil;

    public Empleado(String nombre, String apellidos, String dni, boolean alta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.alta = alta;
        this.numeroEmpleado = this.contadorEmpleado;
        contadorEmpleado++;
        this.numeroSobremesa = -1;
        this.numeroPortatil = -1;
        this.numeroMovil = -1;
    }

    public Empleado(boolean alta) {
        this.alta = alta;
        this.numeroEmpleado = this.contadorEmpleado;
        contadorEmpleado++;
        this.numeroSobremesa = -1;
        this.numeroPortatil = -1;
        this.numeroMovil = -1;
    }

//toString

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", numeroEmpleado=" + numeroEmpleado +
                '}';
    }
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public static int getContadorEmpleado() {
        return contadorEmpleado;
    }

    public static void setContadorEmpleado(int contadorEmpleado) {
        Empleado.contadorEmpleado = contadorEmpleado;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public int getNumeroSobremesa() {
        return numeroSobremesa;
    }

    public void setNumeroSobremesa(int numeroSobremesa) {
        this.numeroSobremesa = numeroSobremesa;
    }

    public int getNumeroPortatil() {
        return numeroPortatil;
    }

    public void setNumeroPortatil(int numeroPortatil) {
        this.numeroPortatil = numeroPortatil;
    }

    public int getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(int numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    //metodos

    public static void empleadoListar(Empleado[] misEmpleados){
        for (Empleado empleado:misEmpleados
             ) {
            if (empleado.isAlta()){
                System.out.println(empleado);
            }
        }
    }
}
