package com.anamuc.jsonReader.model;

import java.util.UUID;

public class Usuario {
    private String id = UUID.randomUUID().toString();
    private String nombre;
    private String rol;
    private String pais;
    private String estado;
    private String email;
    private int anioIngreso;
    private String experiencia;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getAnioIngreso() { return anioIngreso; }
    public void setAnioIngreso(int anioIngreso) { this.anioIngreso = anioIngreso; }
    public String getExperiencia() { return experiencia; }
    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }
}
