package com.ods.myapplication;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord<Usuario> {


    private String nombre;
    private String apellido;
    private int documento;
    private int telefono;
    private String uselog;
    private String clav;

    public Usuario(){

    }

    public Usuario(String nombre, String apellido, int documento, int telefono, String uselog, String clav) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.uselog = uselog;
        this.clav = clav;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUselog() {
        return uselog;
    }

    public void setUselog(String uselog) {
        this.uselog = uselog;
    }

    public String getClav() {
        return clav;
    }

    public void setClav(String clav) {
        this.clav = clav;
    }
}





