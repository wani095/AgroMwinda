package com.icon.agromwinda.Data.model;

public class Agricole_information {
    private String typeof_activity;
    private String activity_object;
    private String sourceof_approvionnement;
    private String scope;
    private int id;
    private int name;
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

    public String getTypeof_activity() {return typeof_activity;}

    public void setTypeof_activity(String typeof_activity) { this.typeof_activity = typeof_activity;}

    public String getActivity_object() { return activity_object; }

    public void setActivity_object(String activity_object) { this.activity_object = activity_object; }

    public String getSourceof_approvionnement() { return sourceof_approvionnement; }

    public void setSourceof_approvionnement(String sourceof_approvionnement) { this.sourceof_approvionnement = sourceof_approvionnement; }

    public String getScope() { return scope; }

    public void setScope(String scope) { this.scope = scope; }


    public void setName(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }
}
