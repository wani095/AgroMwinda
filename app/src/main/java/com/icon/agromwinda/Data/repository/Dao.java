package com.icon.agromwinda.Data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Personne;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Ville;
import com.icon.agromwinda.R;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Dao extends SQLiteOpenHelper implements IDao {

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

    private Context context;

    public Dao(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
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

        init();

    }

    public void init() {

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
        Cursor rs = db.rawQuery("select * from province", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Province p = new Province();
            p.setId(rs.getInt(rs.getColumnIndex(PERSONNE_COLUMN__ID)));
            p.setNom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM)));
            provinces.add(p);
            rs.moveToNext();
        }
        db.close();
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
            c.setNom(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM)));
            communes.add(c);
            rs.moveToNext();
        }
        return communes;
    }

    @Override
    public long savePerson(Personne p) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(PERSONNE_COLUMN__NOM, p.getNom());
        values.put(PERSONNE_COLUMN__POSTNOM, p.getNom());
        values.put(PERSONNE_COLUMN__PRENOM, p.getNom());
        values.put(PERSONNE_COLUMN__SEXE, p.getNom());
        values.put(PERSONNE_COLUMN__NIVEAU_ETUDE, p.getNom());
        values.put(PERSONNE_COLUMN__AGE, p.getNom());
        values.put(PERSONNE_COLUMN__NOM_OPP, p.getNom());
        values.put(PERSONNE_COLUMN__NOM_COOPERATIVE, p.getNom());
        values.put(PERSONNE_COLUMN__PHONE, p.getNom());
        values.put(PERSONNE_COLUMN__EMAIL, p.getNom());
        values.put(PERSONNE_COLUMN__ADM, p.getNom());
        values.put(PERSONNE_COLUMN__QUARTIER, p.getNom());
        values.put(PERSONNE_COLUMN__AVENUE, p.getNom());
        values.put(PERSONNE_COLUMN__DOMICILE, p.getNom());
        values.put(PERSONNE_COLUMN__PROVINCE, p.getNom());
        values.put(PERSONNE_COLUMN__VILLE, p.getNom());
        values.put(PERSONNE_COLUMN__COMMUNE, p.getNom());

        long a = db.insert("personne", null, values);
        return a;
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
            p.setSexe(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__SEXE)));
            p.setNiveauEtude(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NIVEAU_ETUDE)));
            p.setAge(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__AGE)));
            p.setNom_op(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM_OPP)));
            p.setNom_cooperative(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__NOM_COOPERATIVE)));
            p.setPhone(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__PHONE)));
            p.setEmail(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__EMAIL)));
            p.setAdm(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__ADM)));
            p.setQuartier(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__QUARTIER)));
            p.setAvenue(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__AVENUE)));
            p.setDomicile(rs.getString(rs.getColumnIndex(PERSONNE_COLUMN__DOMICILE)));
            p.setProvince(rs.getInt(rs.getColumnIndex(PERSONNE_COLUMN__PROVINCE)));
            p.setVille(rs.getInt(rs.getColumnIndex(PERSONNE_COLUMN__VILLE)));
            p.setCommune(rs.getInt(rs.getColumnIndex(PERSONNE_COLUMN__COMMUNE)));

            personnes.add(p);
            rs.moveToNext();
        }
        return personnes;
    }

    @Override
    public Personne getPersonne(int id) {
        return null;
    }


    public void initProvinces() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.provinces);

        String queries = "";
        try {
            queries = IOUtils.toString(inputStream);
        } catch (IOException e) {
        }

        SQLiteDatabase db = this.getReadableDatabase();
        for (String query : queries.split(";")) {
            db.execSQL(query);
        }
    }

    public void initVilles() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.villes);

        String queries = "";
        try {
            queries = IOUtils.toString(inputStream);
        } catch (IOException e) {
        }

        SQLiteDatabase db = this.getReadableDatabase();
        for (String query : queries.split(";")) {
            Log.d("Query_Sql",query);
            db.execSQL(query);
        }
    }

    public void initCommunes() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.communes);

        String queries = "";
        try {
            queries = IOUtils.toString(inputStream);
        } catch (IOException e) {
        }

        SQLiteDatabase db = this.getReadableDatabase();
        for (String query : queries.split(";")) {
            db.execSQL(query);
        }
    }
}
