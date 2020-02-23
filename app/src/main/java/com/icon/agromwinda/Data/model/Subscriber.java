package com.icon.agromwinda.Data.model;

import java.util.Date;
import java.util.List;

public class Subscriber {

    private int id;
    private int city_id;
    private int town_id;
    private int territory_id;
    private int province_id;
    private String name;
    private String lastname;
    private String firstname;
    private String sexe;
    private String age;
    private String leve_of_study;
    private String phone_number;
    private String email;
    private String quarter;
    private String avenue;
    private String home;
    private String slug;
    private String groupment;
    private String village;
    private int agent_id;
    private Date created_at;
    private int secteur_id;
    private String physical_environment;
    private Date update_at;
    private String cooperative;
    private String peasant_organization;
    private String multiplier_agent;

    private List<Activity> activityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLeve_of_study() {
        return leve_of_study;
    }

    public void setLeve_of_study(String leve_of_study) {
        this.leve_of_study = leve_of_study;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGroupment() {
        return groupment;
    }

    public void setGroupment_id(String groupment) {
        this.groupment= groupment;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }


    public String getPhysical_environment() {
        return physical_environment;
    }

    public void setPhysical_environment(String physical_environment) {
        this.physical_environment = physical_environment;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getCooperative() {
        return cooperative;
    }

    public void setCooperative(String cooperative) {
        this.cooperative = cooperative;
    }

    public String getPeasant_organization() {
        return peasant_organization;
    }

    public void setPeasant_organization(String peasant_organization) {
        this.peasant_organization = peasant_organization;
    }

    public String getMultiplier_agent() {
        return multiplier_agent;
    }

    public void setMultiplier_agent(String multiplier_agent) {
        this.multiplier_agent = multiplier_agent;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public void getPeasant_organization(String string) {
    }

    public int getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(int secteur_id) {
        this.secteur_id = secteur_id;
    }
}
