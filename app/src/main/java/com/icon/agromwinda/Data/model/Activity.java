package com.icon.agromwinda.Data.model;

import java.util.Date;

public class Activity {


    private int id;

    private int fkSubscriber;

    private  int city_id;
    private  int town_id;
    private  int territory_id;
    private  int province_id;
    private  int groupment_id;
    public String getAgricole_information;
    private String name;
    private String typeActivity;
    private String quarter;
    private String avenue;
    private String home ;
    private String slug;
    private String village ;
    private Date created_at ;
    private String secteur;
    private String physical_environment;
    private Date update_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeActivity() {
        return typeActivity;
    }

    public void setTypeActivity(String typeActivity) {
        this.typeActivity = typeActivity;
    }

    public int getFkSubscriber() {
        return fkSubscriber;
    }

    public void setFkSubscriber(int fkSubscriber) {
        this.fkSubscriber = fkSubscriber;
    }

    public String getName() {
        return name;
    }

    public void setName(String string) {this.name = name; }

    public void setCreated_at(Date date) {
    }

    public void getAgricole_information() { }

    public int getSubscriber_id() {return id;}

    public void SetSubscriber_id(int id){this.id = id; }


}
