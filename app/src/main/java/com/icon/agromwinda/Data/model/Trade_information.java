package com.icon.agromwinda.Data.model;

public class Trade_information {

    private int id;
    private String typeof_sale;
    private String sourceof_supply;
    private String economic_capacity;
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

    public String getTypeof_sale() {
        return typeof_sale;
    }

    public void setTypeof_sale(String typeof_sale) {
        this.typeof_sale = typeof_sale;
    }

    public String getSourceof_supply() {
        return sourceof_supply;
    }

    public void setSourceof_supply(String sourceof_supply) {
        this.sourceof_supply = sourceof_supply;
    }

    public String getEconomic_capacity() {
        return economic_capacity;
    }

    public void setEconomic_capacity(String economic_capacity) {
        this.economic_capacity = economic_capacity;
    }

}
