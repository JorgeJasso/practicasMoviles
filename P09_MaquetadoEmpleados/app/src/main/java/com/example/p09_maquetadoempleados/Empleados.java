package com.example.p09_maquetadoempleados;

public class Empleados {


    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoP() {
        return this.apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoM() {
        return this.apellidoM;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return this.edad;
    }
}
