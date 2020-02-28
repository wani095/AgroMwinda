package com.icon.agromwinda.Data.model;

import java.util.Date;

public class Activity {



    private int id;

    private int fkSubscriber;
    private  int city_id;
    private  int town_id;
    private  int territory_id;
    private  int province_id;
    private int secteur_id;
    private int agricole_information_id;
    private int trade_information_id;
    private int transport_information_id;

    private String name;

    private  String groupment;
    private String quarter;
    private String avenue;
    private String home ;
    private String slug;
    private String village ;
    private String physical_environment;

    private String typeActivity;
    private String type_activity;


    private String typeof_sale;
    private String sourceof_supply;
    private String economic_capacity;

    private String created_at ;
    private Date update_at;
    private String created_date;
    private String physique_environment;

    public int getAgricole_information_id;

    public void setAgricole_information_id(int agricole_information_id){this.agricole_information_id= agricole_information_id;}

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

    public String  getGroupment() {
        return groupment;
    }

    public void setGroupment(String groupment) {
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

    public String getType_activity() { return type_activity; }

    public void setType_activity(String type_activity) { this.type_activity = type_activity; }

    public int getTrade_information_id() { return trade_information_id; }

    public void setTrade_information_id(int trade_information_id) { this.trade_information_id = trade_information_id; }

    public String getCreated_date() { return created_date; }

    public void setCreated_date(String created_date) { this.created_date = created_date; }

    public String getCreated_at() { return created_at; }

    public String getPhysique_environment() { return physique_environment; }

    public void setPhysique_environment(String physique_environment) { this.physique_environment = physique_environment; }

    public int getSecteur_id() { return secteur_id; }

    public void setSecteur_id(int secteur_id) { this.secteur_id = secteur_id; }

    public int getTransport_information_id() { return transport_information_id; }

    public void setTransport_information_id(int transport_information_id) { this.transport_information_id = transport_information_id; }


    public int getAgricole_information_id() {
        return agricole_information_id;
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
