package com.example.pc_gaming.madridcontaminacion;

import java.io.Serializable;

/**
 * Created by PC_Gaming on 19/11/2017.
 */

public class Ciudad implements Serializable{

    private String nombre;
    private int imagenGV;

    public Ciudad(String nombre, int imagenGV){
        this.nombre = nombre;
        this.imagenGV = imagenGV;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenGV() {
        return imagenGV;
    }

    public void setImagenGV(int imagenGV) {
        this.imagenGV = imagenGV;
    }
}
