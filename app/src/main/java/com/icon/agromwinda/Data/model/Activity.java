package com.icon.agromwinda.Data.model;

public class Activity {

    private int id;
    private String typeActivity;
    private int fkSubscriber;
    private String name;

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
}
