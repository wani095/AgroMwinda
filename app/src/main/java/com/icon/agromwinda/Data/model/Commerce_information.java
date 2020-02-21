package com.icon.agromwinda.Data.model;

public class Commerce_information {

    private String typeof_commerce;
    private String sourceof_commerce;
    private String capaciteof_commerce;
    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeof_commerce() {
        return typeof_commerce;
    }

    public void setTypeof_commerce(String typeof_commerce) {
        this.typeof_commerce = typeof_commerce;
    }

    public String getSourceof_commerce() {
        return sourceof_commerce;
    }

    public void setSourceof_commerce(String sourceof_commerce) {
        this.sourceof_commerce = sourceof_commerce;
    }

    public String getCapaciteof_commerce() {
        return capaciteof_commerce;
    }

    public void setCapaciteof_commerce(String capaciteof_commerce) {
        this.capaciteof_commerce = capaciteof_commerce;
    }

}
