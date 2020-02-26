package com.icon.agromwinda.Data.model;

import java.util.Date;

public class Activity {


    private int id;

    private int fkSubscriber;

    private  int city_id;
    private  int town_id;
    private  int territory_id;
    private  int province_id;
    private  int groupment;
    private int transport_information_id;
    private int secteur_id;
    public String getAgricole_information;
    private String name;
    private String typeActivity;
    private String quarter;
    private String avenue;
    private String home ;
    private String slug;
    private String village ;
    private Date created_at ;
    private String created_date;
    private String secteur;
    private String physical_environment;
    private Date update_at;
    private int type_activity;
    private int trade_information_id;
    private String physique_environment;

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

    public void getSubscriber_id(int id) {this.id =id; }

    public void SetSubscriber_id(int id){this.id = id; }


    public int getCity_id() { return city_id; }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getTown_id() {
        return town_id;
    }

    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }

    public int getTerritory_id() {
        return territory_id;
    }

    public void setTerritory_id(int territory_id) {
        this.territory_id = territory_id;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }


    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getGroupment() {
        return groupment;
    }

    public void setGroupment(int groupment) {
        this.groupment = groupment;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public void setPhysical_environment(String physical_environment) { this.physical_environment = physical_environment; }

    public Date getUpdate_at() {
        return update_at;
    }

    public int getType_activity() { return type_activity; }

    public void setType_activity(int type_activity) { this.type_activity = type_activity; }

    public int getTrade_information_id() { return trade_information_id; }

    public void setTrade_information_id(int trade_information_id) { this.trade_information_id = trade_information_id; }

    public String getCreated_date() { return created_date; }

    public void setCreated_date(String created_date) { this.created_date = created_date; }

    public Date getCreated_at() { return created_at; }

    public String getPhysique_environment() { return physique_environment; }

    public void setPhysique_environment(String physique_environment) { this.physique_environment = physique_environment; }

    public int getSecteur_id() { return secteur_id; }

    public void setSecteur_id(int secteur_id) { this.secteur_id = secteur_id; }

    public int getTransport_information_id() { return transport_information_id; }

    public void setTransport_information_id(int transport_information_id) { this.transport_information_id = transport_information_id; }


}
