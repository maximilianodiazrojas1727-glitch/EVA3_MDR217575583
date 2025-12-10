/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PCXX
 */
public class Arma {

    private int id;
    private String nombre;
    private double precision;

    public Arma() {
    }

    public Arma(int id, String nombre, double precision) {
        this.id = id;
        this.nombre = nombre;
        this.precision = precision;
    }

    public Arma(String nombre, double precision) {
        this.nombre = nombre;
        this.precision = precision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return "Arma{" + "id=" + id + ", nombre=" + nombre + ", precision=" + precision + '}';
    }
}
