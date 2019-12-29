package com.icon.agromwinda.Data.repository;

import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Personne;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Ville;

import java.util.List;

public interface IDao {

    List<Province> getProvinces();

    List<Ville> getVilles();

    List<Commune> getCommunes();

    boolean savePerson(Personne personne);

    List<Personne> getPersonnes();

    Personne getPersonne(int id);

}
