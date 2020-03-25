package com.icon.agromwinda.Data.repository;

import com.icon.agromwinda.Data.model.Activity;
import com.icon.agromwinda.Data.model.Agricole_information;
import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Secteur;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Territoire;
import com.icon.agromwinda.Data.model.Town;
import com.icon.agromwinda.Data.model.Transport_information;
import com.icon.agromwinda.Data.model.trade_information;

import java.util.List;

public interface IDao {

    List<Province> getProvinces();

    List<Town> getTowns();

    List<Commune> getCommunes();

    List<Secteur> getSecteurs();

    List<Territoire> getTerritoires();

    long saveActivity(Activity pp);

    long SaveActivity(Activity pp);

    long saveSubscriber(Subscriber subscriber);

    List<Subscriber> getSubscribers();

    Subscriber getSubscriber(Integer id);

    long saveAgricole_infomation(Agricole_information a);

    List<Agricole_information> getAgricole_informations();

    Agricole_information getAgricole_information(Integer id);

    long saveTrade_information(trade_information co);

    List<trade_information> getTrade_information();

    trade_information getTrade_information(Integer id);

    long saveTransport_infomation(Transport_information tr);

    List<Transport_information> getTransport_informations();

    Transport_information getTransport_information(Integer id);

    List<Activity> getListActivitys(int subscriber_id);

}
