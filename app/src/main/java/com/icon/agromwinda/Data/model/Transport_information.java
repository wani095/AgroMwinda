package com.icon.agromwinda.Data.model;

public class Transport_information {
    private String typeof_transport;
    private String marqueof_transport;
    private String anneeof_transport;
    private String capaciteof_transport;
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


    public String getTypeof_transport() {
        return typeof_transport;
    }

    public void setTypeof_transport(String typeof_transport) {
        this.typeof_transport = typeof_transport;
    }

    public String getMarqueof_transport() {
        return marqueof_transport;
    }

    public void setMarqueof_transport(String marqueof_transport) {
        this.marqueof_transport = marqueof_transport;
    }

    public String getAnneeof_transport() {
        return anneeof_transport;
    }

    public void setAnneeof_transport(String anneeof_transport) {
        this.anneeof_transport = anneeof_transport;
    }

    public String getCapaciteof_transport() {
        return capaciteof_transport;
    }

    public void setCapaciteof_transport(String capaciteof_transport) {
        this.capaciteof_transport = capaciteof_transport;
    }
}
