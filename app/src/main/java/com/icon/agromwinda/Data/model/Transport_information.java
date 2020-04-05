package com.icon.agromwinda.Data.model;

public class Transport_information {
    private int id;
    private String vehicule_type;
    private String vehicule_marque;
    private String acquisition_year;
    private String transport_capacity;
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


    public String getVehicule_type() {
        return vehicule_type;
    }

    public void setVehicule_type(String vehicule_type) {
        this.vehicule_type = vehicule_type;
    }

    public String getVehicule_marque() {
        return vehicule_marque;
    }

    public void setVehicule_marque(String vehicule_marque) {
        this.vehicule_marque = vehicule_marque;
    }

    public String getAcquisition_year() {
        return acquisition_year;
    }

    public void setAcquisition_year(String acquisition_year) {
        this.acquisition_year = acquisition_year;
    }

    public String getTransport_capacity() {
        return transport_capacity;
    }

    public void setTransport_capacity(String transport_capacity) {
        this.transport_capacity = transport_capacity;
    }
}
