package com.icon.agromwinda.Data.repository;

import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Town;

import java.util.List;

public interface IDao {

    List<Province> getProvinces();

    List<Town> getTowns();

    List<Commune> getCommunes();

    long saveSubscriber(Subscriber subscriber);

    List<Subscriber> getSubscribers();

    Subscriber getSubscriber(Integer id);

}
