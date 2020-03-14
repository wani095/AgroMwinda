package com.icon.agromwinda.Data.repository;

import com.icon.agromwinda.Data.model.Activity;
import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Secteur;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Territoire;
import com.icon.agromwinda.Data.model.Town;

import java.util.List;

public interface IDao {

    List<Province> getProvinces();

    List<Town> getTowns();

    List<Commune> getCommunes();

    List<Secteur> getSecteurs();

    List<Territoire> getTerritoires();

    long saveActivity(Activity pp);

    long SaveActivity(Activity pp);

    List<Activity> getActivitys();

    Activity getActivitys(Integer id);

    long saveSubscriber(Subscriber subscriber);

    List<Subscriber> getSubscribers();

    Subscriber getSubscriber(Integer id);

    List<Activity> getActivities(int fkSubscriber);



}
