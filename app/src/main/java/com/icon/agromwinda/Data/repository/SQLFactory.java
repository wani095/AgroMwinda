package com.icon.agromwinda.Data.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Personne;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Ville;

import java.util.ArrayList;
import java.util.List;

public class SQLFactory extends SQLiteOpenHelper implements IDao {

    public static final String DATABASE_NAME = "agraMwinda.db";

    public static final String PERSONNE_TABLE_NAME_PERSONNE = "personne";
    public static final String PERSONNE_TABLE_NAME_PROVINCE = "province";
    public static final String PERSONNE_TABLE_NAME_VILLE = "ville";
    public static final String PERSONNE_TABLE_NAME_COMMUNE = "commune";


    public static final String PERSONNE_COLUMN__ID = "id";
    public static final String PERSONNE_COLUMN__NOM = "nom";
    public static final String PERSONNE_COLUMN__POSTNOM = "postnom";
    public static final String PERSONNE_COLUMN__PRENOM = "prenom";
    public static final String PERSONNE_COLUMN__SEXE = "sexe";
    public static final String PERSONNE_COLUMN__NIVEAU_ETUDE = "niveauEtude";
    public static final String PERSONNE_COLUMN__AGE = "age";
    public static final String PERSONNE_COLUMN__NOM_OPP = "nomOp";
    public static final String PERSONNE_COLUMN__NOM_COOPERATIVE = "nom_cooperative";
    public static final String PERSONNE_COLUMN__PHONE = "phone";
    public static final String PERSONNE_COLUMN__EMAIL = "email";
    public static final String PERSONNE_COLUMN__ADM = "adm";
    public static final String PERSONNE_COLUMN__QUARTIER = "quartier";
    public static final String PERSONNE_COLUMN__AVENUE = "avenue";
    public static final String PERSONNE_COLUMN__DOMICILE = "domicile";
    public static final String PERSONNE_COLUMN__PROVINCE = "province";
    public static final String PERSONNE_COLUMN__VILLE = "ville";
    public static final String PERSONNE_COLUMN__COMMUNE = "commune";

    public SQLFactory(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table personne " +
                        "(id integer primary key AUTOINCREMENT not null, nom text,postnom text,prenom text, sexe text,niveauEtude text," +
                        "age text,nomOp text,nom_cooperative text,phone text,email text,adm text,quartier text," +
                        "avenue text,domicile text,province integer,ville integer,commune integer)"
        );
        db.execSQL(
                "create table province " +
                        "(id integer primary key AUTOINCREMENT not null, nom text)"
        );
        db.execSQL(
                "create table ville " +
                        "(id integer primary key AUTOINCREMENT not null, nom text)"
        );

        db.execSQL(
                "create table commune " +
                        "(id integer primary key AUTOINCREMENT not null, nom text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS personne");
        db.execSQL("DROP TABLE IF EXISTS province");
        db.execSQL("DROP TABLE IF EXISTS ville");
        db.execSQL("DROP TABLE IF EXISTS commune");
        onCreate(db);
    }


    @Override
    public List<Province> getProvinces() {
        List<Province> provinces = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from contacts", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Province p = new Province();
            p.setId(rs.getInt(rs.getColumnIndex(PERSONNE_COLUMN__ID)));
            p.setNom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM)));
            provinces.add(p);
            rs.moveToNext();
        }
        return provinces;
    }

    @Override
    public List<Ville> getVilles() {
        List<Ville> villes = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from contacts", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Ville v = new Ville();
            v.setId(rs.getInt(rs.getColumnIndex(PERSONNE_COLUMN__ID)));
            v.setNom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM)));
            villes.add(v);
            rs.moveToNext();
        }
        return villes;
    }

    @Override
    public List<Commune> getCommunes() {
        List<Commune> communes = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from contacts", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Commune c = new Commune();
            c.setId(rs.getInt(rs.getColumnIndex(PERSONNE_COLUMN__ID)));
            c.setNom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM)));
            communes.add(c);
            rs.moveToNext();
        }
        return communes;
    }

    @Override
    public boolean savePerson(Personne personne) {
        return false;
    }

    @Override
    public List<Personne> getPersonnes() {
        List<Personne> personnes = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from contacts", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Personne p = new Personne();
            p.setNom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM)));
            p.setPostnom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__POSTNOM)));
            p.setPrenom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__PRENOM)));
            p.setSexe(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__POSTNOM)));
            p.setNiveauEtude(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__POSTNOM)));
            p.setPostnom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__POSTNOM)));
            p.setPostnom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__POSTNOM)));
            p.setPostnom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__POSTNOM)));
            personnes.add(p);
            rs.moveToNext();
        }
        return personnes;
    }

    @Override
    public Personne getPersonne(int id) {
        return null;
    }
}
