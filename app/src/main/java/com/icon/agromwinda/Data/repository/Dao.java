package com.icon.agromwinda.Data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Town;
import com.icon.agromwinda.R;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Dao extends SQLiteOpenHelper implements IDao {

    public static final String DATABASE_NAME = "agraMwinda.db";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";


    public static final String SUBSCRIBER_COLUMN__ID = "id";
    public static final String SUBSCRIBER_COLUMN__CITY = "city_id";
    public static final String SUBSCRIBER_COLUMN__TOWN = "town_id";
    public static final String SUBSCRIBER_COLUMN__TERRITORY = "territory_id";
    public static final String SUBSCRIBER_COLUMN__PROVINCE = "province_id";
    public static final String SUBSCRIBER_COLUMN__NAME = "name";
    public static final String SUBSCRIBER_COLUMN__LASTNAME = "lastname";
    public static final String SUBSCRIBER_COLUMN__FIRSTNAME = "firstname";
    public static final String SUBSCRIBER_COLUMN__SEXE = "sexe";
    public static final String SUBSCRIBER_COLUMN__AGE = "age";
    public static final String SUBSCRIBER_COLUMN__LEVE_OF_STUDY = "leve_of_study";
    public static final String SUBSCRIBER_COLUMN__PHONE_NUMBER = "phone_number";
    public static final String SUBSCRIBER_COLUMN__EMAIL = "email";
    public static final String SUBSCRIBER_COLUMN__QUARTER = "quarter";
    public static final String SUBSCRIBER_COLUMN__AVENUE = "avenue";
    public static final String SUBSCRIBER_COLUMN__HOME = "home";
    public static final String SUBSCRIBER_COLUMN__SLUG = "slug";
    public static final String SUBSCRIBER_COLUMN__GROUPMENT = "groupment_id";
    public static final String SUBSCRIBER_COLUMN__VILLAGE = "village";
    public static final String SUBSCRIBER_COLUMN__AGENT = "agent_id";
    public static final String SUBSCRIBER_COLUMN__CREATE_AT = "created_at";
    public static final String SUBSCRIBER_COLUMN__SECTEUR = "secteur";
    public static final String SUBSCRIBER_COLUMN__PHYSICAL_ENVIRONMENT = "physical_environment";
    public static final String SUBSCRIBER_COLUMN__UPDATED_AT = "update_at";
    public static final String SUBSCRIBER_COLUMN__COOPERATIVE= "cooperative";
    public static final String SUBSCRIBER_COLUMN__PEASANT_ORGANIZATION = "peasant_organization";
    public static final String SUBSCRIBER_COLUMN__MULTIPLIER_AGENT = "multiplier_agent";



    private Context context;

    public Dao(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table province " +
                        "(id integer primary key AUTOINCREMENT not null, name text)"
        );
        db.execSQL(
                "create table town " +
                        "(id integer primary key AUTOINCREMENT not null, name text)"
        );

        db.execSQL(
                "create table commune " +
                        "(id integer primary key AUTOINCREMENT not null, name text)"
        );

        db.execSQL("CREATE TABLE subscriber(\n" +
                "    id integer PRIMARY KEY AUTOINCREMENT," +
                "    city_id integer,\n" +
                "    town_id integer,\n" +
                "    territory_id integer,\n" +
                "    province_id integer,\n" +
                "    name varchar(255),\n" +
                "    lastname varchar(255),\n" +
                "    firstname varchar(255),\n" +
                "    sexe varchar(10),\n" +
                "    age varchar(30),\n" +
                "    leve_of_study varchar(50),\n" +
                "    phone_number varchar(15),\n" +
                "    email varchar(100),\n" +
                "    quarter varchar(100),\n" +
                "    avenue varchar(100),\n" +
                "    home varchar(20),\n" +
                "    slug varchar(255),\n" +
                "    groupment_id int,\n" +
                "    village varchar(255),\n" +
                "    agent_id varchar(255),\n" +
                "    created_at date,\n" +
                "    secteur varchar(255),\n" +
                "    physical_environment varchar(255),\n" +
                "    update_at datetime,\n" +
                "    cooperative varchar(255),\n" +
                "    peasant_organization varchar(255),\n" +
                "    multiplier_agent varchar(255)\n" +
                ")");

        init();

    }

    public void init() {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS province");
        db.execSQL("DROP TABLE IF EXISTS town");
        db.execSQL("DROP TABLE IF EXISTS commune");
        db.execSQL("DROP TABLE IF EXISTS subscriber");
        onCreate(db);
    }


    @Override
    public List<Province> getProvinces() {
        List<Province> provinces = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from province order by name", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Province p = new Province();
            p.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            p.setNom(rs.getString(rs.getColumnIndex(COLUMN_NAME)));
            provinces.add(p);
            rs.moveToNext();
        }
        db.close();
        return provinces;
    }

    @Override
    public List<Town> getTowns() {
        List<Town> towns = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from town order by name", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Town v = new Town();
            v.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            v.setNom(rs.getString(rs.getColumnIndex(COLUMN_NAME)));
            towns.add(v);
            rs.moveToNext();
        }
        return towns;
    }

    @Override
    public List<Commune> getCommunes() {
        List<Commune> communes = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from commune order by name", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Commune c = new Commune();
            c.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            c.setNom(rs.getString(rs.getColumnIndex(COLUMN_NAME)));
            communes.add(c);
            rs.moveToNext();
        }
        return communes;
    }

    @Override
    public long saveSubscriber(Subscriber p) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUBSCRIBER_COLUMN__NAME,p.getName());
        values.put(SUBSCRIBER_COLUMN__LASTNAME,p.getLastname());
        values.put(SUBSCRIBER_COLUMN__FIRSTNAME,p.getFirstname());
        values.put(SUBSCRIBER_COLUMN__SEXE,p.getSexe());
        values.put(SUBSCRIBER_COLUMN__AGE,p.getAge());
        values.put(SUBSCRIBER_COLUMN__LEVE_OF_STUDY,p.getLeve_of_study());
        values.put(SUBSCRIBER_COLUMN__PHONE_NUMBER,p.getPhone_number());
        values.put(SUBSCRIBER_COLUMN__EMAIL,p.getEmail());
        values.put(SUBSCRIBER_COLUMN__QUARTER,p.getQuarter());
        values.put(SUBSCRIBER_COLUMN__AVENUE,p.getAvenue());
        values.put(SUBSCRIBER_COLUMN__SLUG,p.getSlug());
        values.put(SUBSCRIBER_COLUMN__GROUPMENT,p.getGroupment_id());
        values.put(SUBSCRIBER_COLUMN__VILLAGE,p.getVillage());
        values.put(SUBSCRIBER_COLUMN__AGENT,p.getAgent_id());
        values.put(SUBSCRIBER_COLUMN__CREATE_AT,p.getCreated_at().toString());
        values.put(SUBSCRIBER_COLUMN__SECTEUR,p.getSecteur());
        values.put(SUBSCRIBER_COLUMN__PHYSICAL_ENVIRONMENT,p.getPhysical_environment());
        values.put(SUBSCRIBER_COLUMN__UPDATED_AT,p.getUpdate_at().toString());
        values.put(SUBSCRIBER_COLUMN__COOPERATIVE,p.getCooperative());
        values.put(SUBSCRIBER_COLUMN__PEASANT_ORGANIZATION,p.getPeasant_organization());
        values.put(SUBSCRIBER_COLUMN__MULTIPLIER_AGENT,p.getMultiplier_agent());

        try {
            long a = db.insert("subscriber", null, values);
            return a;
        }catch (Exception e){
            Log.d("SAVEEXCEPTION",e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Subscriber> getSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from subscriber", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {
            Subscriber p = new Subscriber();
            p.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            p.setName(rs.getString(rs.getColumnIndex(COLUMN_NAME)));
            p.setFirstname(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__FIRSTNAME)));
            p.setLastname(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__LASTNAME)));
            subscribers.add(p);
            subscribers.add(p);
            rs.moveToNext();
        }
        return subscribers;
    }

    @Override
    public Subscriber getSubscriber(int id) {
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

    public void initTowns() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.villes);

        String queries = "";
        try {
            queries = IOUtils.toString(inputStream);
        } catch (IOException e) {
        }

        SQLiteDatabase db = this.getReadableDatabase();
        for (String query : queries.split(";")) {
            Log.d("Query_Sql", query);
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
