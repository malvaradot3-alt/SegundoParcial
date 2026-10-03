/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Estudiante {

    int id;
    String carnet;
    String primerNombre;
    String apellido;
    String direccion;
    int telefono;
    String carrera;
    String fechaIngreso;
    double cuotaMensual;

    // Constructor vacío
    public Estudiante() {
        this.id = 0;
        this.carnet = "";
        this.primerNombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = 0;
        this.carrera = "";
        this.fechaIngreso = "";
        this.cuotaMensual = 0.0;
    }

    // Constructor completo
    public Estudiante(int id, String carnet, String primerNombre,
            String apellido, String direccion, int telefono,
            String carrera, String fechaIngreso, double cuotaMensual) {

        this.id = id;
        this.carnet = carnet;
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.carrera = carrera;
        this.fechaIngreso = fechaIngreso;
        this.cuotaMensual = cuotaMensual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }
}
