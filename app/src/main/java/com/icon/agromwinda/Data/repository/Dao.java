package com.icon.agromwinda.Data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.icon.agromwinda.Data.model.Activity;
import com.icon.agromwinda.Data.model.Agricole_information;
import com.icon.agromwinda.Data.model.Trade_information;
import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Secteur;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Territoire;
import com.icon.agromwinda.Data.model.Town;
import com.icon.agromwinda.Data.model.Transport_information;
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
    public static  final String TAG = "Dao";

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
    public static final String SUBSCRIBER_COLUMN__GROUPMENT = "groupment";
    public static final String SUBSCRIBER_COLUMN__VILLAGE = "village";
    public static final String SUBSCRIBER_COLUMN__AGENT = "agent_id";
    public static final String SUBSCRIBER_COLUMN__CREATE_AT = "created_at";
    public static final String SUBSCRIBER_COLUMN__SECTEUR = "secteur_id";
    public static final String SUBSCRIBER_COLUMN__PHYSICAL_ENVIRONMENT = "physical_environment";
    public static final String SUBSCRIBER_COLUMN__UPDATED_AT = "update_at";
    public static final String SUBSCRIBER_COLUMN__COOPERATIVE = "cooperative";
    public static final String SUBSCRIBER_COLUMN__PEASANT_ORGANIZATION = "peasant_organization";
    public static final String SUBSCRIBER_COLUMN__MULTIPLIER_AGENT = "multiplier_agent";

    public static final String ACTIVITY_COLUMN__ID = "id";
    public static final String ACTIVITY_COLUMN__SUBSCRIBER = "subscriber_id ";
    public static final String ACTIVITY_COLUMN__QUARTER = "quarter";
    public static final String ACTIVITY_COLUMN__AVENUE = "avenue";
    public static final String ACTIVITY_COLUMN__HOME = "home";
    public static final String ACTIVITY_COLUMN__CITY = "city_id";
    public static final String ACTIVITY_COLUMN__TOWN = "town_id";
    public static final String ACTIVITY_COLUMN__GROUPMENT = "groupment";
    public static final String ACTIVITY_COLUMN__VILLAGE = "village";
    public static final String ACTIVITY_COLUMN__TERRITORY = "territory_id";
    public static final String ACTIVITY_COLUMN__PROVINCE = "province_id";
    public static final String ACTIVITY_COLUMN__NAME = "name";
    public static final String ACTIVITY_COLUMN__CREATE_DATE = "created_date";
    public static final String ACTIVITY_COLUMN__TYPE_ACTIVITY = "type_activity";
    public static final String ACTIVITY_COLUMN__CREATE_AT = "create_at";
    public static final String ACTIVITY_COLUMN__SLUG = "slug";
    public static final String ACTIVITY_COLUMN__PHYSIQUE_ENVIRONMENT = "physical_environment";
    public static final String ACTIVITY_COLUMN__SECTEUR = "secteur_id";

    public static final String ACTIVITY_COLUMN__TRADE_INFORMATION = "trade_information_id";
    public static final String ACTIVITY_COLUMN__AGRICOLE_INFORMATTION = "agricole_information_id";
    public static final String ACTIVITY_COLUMN__TRANSPORT_INFORMATION = "transport_information_id";


    public static final String AGRICOLE_INFORMATION_COLUMN__TYPE_ACTIVITY = "typeof_activity";
    public static final String AGRICOLE_INFORMATION_COLUMN__SOURCE_APPROVISIONNNEMENT = "sourceof_supply";
    public static final String AGRICOLE_INFORMATION_COLUMN__OBJECT_ACTIVITY = "activity_object";
    public static final String AGRICOLE_INFORMATION_COLUMN__ENTENDUE = "scope";

    public static final String COMMERCE_INFORMATION_COLUMN__TYPE_COMMERCE = "typeof_sale";
    public static final String COMMERCE_INFORMATION_COLUMN__SOURCE_COMMERCE = "sourceof_supply";
    public static final String COMMERCE_INFORMATION_COLUMN__CAPACITE_COMMERCE = "economic_capacity";


    public static final String TRANSPORT_INFORMATION_COLUMN__TYPE_TRANSPORT = "vehicule_type";
    public static final String TRANSPORT_INFORMATION_COLUMN__MARQUE_TRANSPORT = "vehicule_marque";
    public static final String TRANSPORT_INFORMATION_COLUMN__ANNNEE_TRANSPORT = "vehicule_marque";
    public static final String TRANSPORT_INFORMATION_COLUMN__CAPACITE_TRANSPORT = "transport_capacity";


    private Context context;
    private Object trade_information;
    private Object agricole_information;
    private Object transport_information;



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

        db.execSQL(
                "create table secteur " +
                        "(id integer primary key AUTOINCREMENT not null, name text)"
        );

        db.execSQL(
                "create table territoire " +
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
                "    groupment varchar(255),\n" +
                "    village varchar(255),\n" +
                "    agent_id varchar(255),\n" +
                "    created_at date,\n" +
                "    secteur_id integer,\n" +
                "    physical_environment varchar(255),\n" +
                "    update_at datetime,\n" +
                "    cooperative varchar(255),\n" +
                "    peasant_organization varchar(255),\n" +
                "    multiplier_agent varchar(255)\n" +
                ")");
        init();

        db.execSQL("CREATE TABLE activity(\n" +
                "   id integer PRIMARY KEY AUTOINCREMENT," +
                "   subscriber_id integer,\n" +
                "   type_activity varchar(255),\n" +
                "   town_id integer,\n" +
                "   city_id integer,\n" +
                "   territory_id integer,\n" +
                "   province_id integer,\n" +
                "   name varchar(255),\n" +
                "   quarter varchar(255),\n" +
                "   avenue varchar(255),\n" +
                "   home varchar(255),\n" +
                "   created_date varchar(255),\n" +
                "   slug varchar(255),\n" +
                "   created_at date,\n" +
                "   physical_environment varchar(255),\n" +
                "   secteur_id integer,\n" +
                "   groupment varchar(255),\n" +
                "   typeof_sale varchar(255),\n" +
                "   sourceof_supply varchar(255),\n" +
                "   economic_capacity varchar(255),\n"+
                "   trade_information_id integer,\n" +
                "   agricole_information_id integer,\n" +
                "   transport_information_id integer,\n" +
                "   idDomaine_id integer,"+
                "   village varchar(255))");
        init();

        db.execSQL("CREATE TABLE trade_information(\n" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "typeof_sale varchar(255),\n" +
                "sourceof_supply varchar(255),\n" +
                "economic_capacity varchar(255))");
        init();

        db.execSQL("CREATE TABLE agricole_information(\n" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "typeof_activity varchar(255),\n" +
                "sourceof_supply varchar(255),\n" +
                "activity_object varchar(255),\n" +
                "scope varchar(255))");
        init();

        db.execSQL("CREATE TABLE transport_information(\n" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "vehicule_type varchar(255),\n" +
                "vehicule_marque varchar(255),\n" +
                "acquisition_year varchar(255),\n" +
                "transport_capacity varchar(255))");
        init();

       // db.execSQL("CREATE TABLE type_activity(" +
                //"trade_informatiton_id integer,"+
                //"transport_information_id integer"+
                //"agricole_information_id integer)");

        db.execSQL("CREATE TABLE idDomaine("+
                "id integer PRIMARY KEY AUTOINCREMENT,"+
                "trade_information_id integer,"+
                "transport_information_id  integer,"+
                "agricole_informaation_id integer)");
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
        db.execSQL("DROP TABLE IF EXISTS activity");
        db.execSQL("DROP TABLE IF EXISTS territoire");
        db.execSQL("DROP TABLE IF EXISTS secteur");
        db.execSQL("DROP TABLE IF EXISTS agricole_information");
        db.execSQL("DROP TABLE IF EXISTS trade_information");
        db.execSQL("DROP TABLE IF EXISTS transport_information");
        db.execSQL("DROP TABLE IF EXISTS iDomaine");
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
    public List<Secteur> getSecteurs() {
        List<Secteur> secteurs = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from secteur order by name", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Secteur s = new Secteur();
            s.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            s.setNom(rs.getString(rs.getColumnIndex(COLUMN_NAME)));
            secteurs.add(s);
            rs.moveToNext();
        }
        return secteurs;
    }

    @Override
    public List<Territoire> getTerritoires() {
        List<Territoire> territoires = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from territoire order by name", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {

            Territoire t = new Territoire();
            t.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            t.setNom(rs.getString(rs.getColumnIndex(COLUMN_NAME)));
            territoires.add(t);
            rs.moveToNext();
        }
        return territoires;
    }

    @Override
    public long saveActivity(Activity pp) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        try {
            values.put(ACTIVITY_COLUMN__NAME, pp.getName());
            values.put(ACTIVITY_COLUMN__SUBSCRIBER, pp.getSubscriber_id());
            values.put(ACTIVITY_COLUMN__QUARTER, pp.getQuarter());
            values.put(ACTIVITY_COLUMN__AVENUE, pp.getAvenue());
            values.put(ACTIVITY_COLUMN__GROUPMENT, pp.getGroupment());
            values.put(ACTIVITY_COLUMN__VILLAGE, pp.getVillage());
            values.put(ACTIVITY_COLUMN__TYPE_ACTIVITY, pp.getType_activity());
            values.put(ACTIVITY_COLUMN__CITY, pp.getCity_id());
            values.put(ACTIVITY_COLUMN__TOWN, pp.getTown_id());
            values.put(ACTIVITY_COLUMN__TERRITORY, pp.getTerritory_id());
            values.put(ACTIVITY_COLUMN__PROVINCE, pp.getProvince_id());
            values.put(ACTIVITY_COLUMN__HOME, pp.getHome());
            values.put(ACTIVITY_COLUMN__CREATE_DATE, pp.getCreated_date());
            values.put(ACTIVITY_COLUMN__SLUG, pp.getSlug());
            values.put(ACTIVITY_COLUMN__PHYSIQUE_ENVIRONMENT, pp.getPhysical_environment());
            values.put(ACTIVITY_COLUMN__SECTEUR, pp.getSecteur_id());

            values.put(ACTIVITY_COLUMN__TRANSPORT_INFORMATION, pp.getTransport_information_id());
            values.put(ACTIVITY_COLUMN__AGRICOLE_INFORMATTION, pp.getAgricole_information_id());
            values.put(ACTIVITY_COLUMN__TRADE_INFORMATION, pp.getTrade_information_id());

            long a = db.insert("activity", null, values);
            Log.d("SAVEACTIVITY", "" + a);
            return a;
        } catch (Exception e) {
            Log.d("SAVEEXCEPTION", e.getMessage());
        }
        return 0;
    }

     // bd activity

@Override
    public List<Activity> getListActivitys(int subscriber_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from activity where id=" + subscriber_id + "", null);
        rs.moveToFirst();

        List<Activity> activities=new ArrayList<>();

        while (rs.isAfterLast() == false) {
            Activity pp  = new Activity();
            pp.setId(rs.getInt(rs.getColumnIndex(ACTIVITY_COLUMN__ID)));
            pp.setName(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__NAME)));
            pp.setType_activity(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__TYPE_ACTIVITY)));
            pp.setCreated_date(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__CREATE_DATE)));
            pp.setPhysical_environment(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__PHYSIQUE_ENVIRONMENT)));

            activities.add(pp);
            rs.moveToNext();
        }
        return activities;
    }

    @Override
    public Activity getListActivitys(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from activity where id=" + id + "", null);
        rs.moveToFirst();
        Activity pp = null;

        while (rs.isAfterLast() == false) {
            pp = new Activity();
            pp.setId(rs.getInt(rs.getColumnIndex(ACTIVITY_COLUMN__ID)));
            pp.setName(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__NAME)));
            pp.setType_activity(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__TYPE_ACTIVITY)));
            pp.setCreated_date(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__CREATE_DATE)));
            pp.setPhysical_environment(rs.getString(rs.getColumnIndex(ACTIVITY_COLUMN__PHYSIQUE_ENVIRONMENT)));

            rs.moveToNext();
        }
        return pp;
    }

     // bd subscriber
    @Override
    public long saveSubscriber(Subscriber p) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        try {
            values.put(SUBSCRIBER_COLUMN__NAME, p.getName());
            values.put(SUBSCRIBER_COLUMN__LASTNAME, p.getLastname());
            values.put(SUBSCRIBER_COLUMN__FIRSTNAME, p.getFirstname());
            values.put(SUBSCRIBER_COLUMN__SEXE, p.getSexe());
            values.put(SUBSCRIBER_COLUMN__AGE, p.getAge());
            values.put(SUBSCRIBER_COLUMN__LEVE_OF_STUDY, p.getLeve_of_study());
            values.put(SUBSCRIBER_COLUMN__PHONE_NUMBER, p.getPhone_number());
            values.put(SUBSCRIBER_COLUMN__EMAIL, p.getEmail());
            values.put(SUBSCRIBER_COLUMN__QUARTER, p.getQuarter());
            values.put(SUBSCRIBER_COLUMN__AVENUE, p.getAvenue());
            values.put(SUBSCRIBER_COLUMN__SLUG, p.getSlug());
            values.put(SUBSCRIBER_COLUMN__GROUPMENT, p.getGroupment());
            values.put(SUBSCRIBER_COLUMN__VILLAGE, p.getVillage());
            values.put(SUBSCRIBER_COLUMN__AGENT, p.getAgent_id());
            values.put(SUBSCRIBER_COLUMN__CREATE_AT, p.getCreated_at().toString());
            values.put(SUBSCRIBER_COLUMN__SECTEUR, p.getSecteur_id());
            values.put(SUBSCRIBER_COLUMN__PHYSICAL_ENVIRONMENT, p.getPhysical_environment());
            values.put(SUBSCRIBER_COLUMN__COOPERATIVE, p.getCooperative());
            values.put(SUBSCRIBER_COLUMN__PEASANT_ORGANIZATION, p.getPeasant_organization());
            values.put(SUBSCRIBER_COLUMN__MULTIPLIER_AGENT, p.getMultiplier_agent());
            values.put(SUBSCRIBER_COLUMN__TERRITORY, p.getTerritory_id());

            long a = db.insert("subscriber", null, values);
            Log.d("SAVEREP", "" + a);
            return a;
        } catch (Exception e) {
            Log.d("SAVEEXCEPTION", e.getMessage());
            return 0;
        }
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
            p.setPhone_number(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__PHONE_NUMBER)));
            p.setMultiplier_agent(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__MULTIPLIER_AGENT)));
            p.setSexe(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__SEXE)));
            p.setAge(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__AGE)));
            p.getPeasant_organization(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__PEASANT_ORGANIZATION)));
            subscribers.add(p);
            rs.moveToNext();
        }
        return subscribers;
    }

    @Override
    public Subscriber getSubscriber(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from subscriber where id=" + id + "", null);
        rs.moveToFirst();
        Subscriber p = null;

        while (rs.isAfterLast() == false) {
            p = new Subscriber();
            p.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            p.setName(rs.getString(rs.getColumnIndex(COLUMN_NAME)));
            p.setFirstname(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__FIRSTNAME)));
            p.setLastname(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__LASTNAME)));
            p.setPhone_number(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__PHONE_NUMBER)));
            p.setMultiplier_agent(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__MULTIPLIER_AGENT)));
            p.setSexe(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__SEXE)));
            p.setAge(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__AGE)));
            p.getPeasant_organization(rs.getString(rs.getColumnIndex(SUBSCRIBER_COLUMN__PEASANT_ORGANIZATION)));
            rs.moveToNext();
        }
        return p;
    }

    @Override
    public long saveAgricole_infomation(Agricole_information ag) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(AGRICOLE_INFORMATION_COLUMN__TYPE_ACTIVITY, ag.getTypeof_activity());
        values.put(AGRICOLE_INFORMATION_COLUMN__OBJECT_ACTIVITY, ag.getActivity_object());
        values.put(AGRICOLE_INFORMATION_COLUMN__SOURCE_APPROVISIONNNEMENT, ag.getSourceof_approvionnement());
        values.put(AGRICOLE_INFORMATION_COLUMN__ENTENDUE, ag.getScope());

        try {
            long a = db.insert("agricole_information", null, values);
            return a;
        } catch (Exception e) {
            Log.d("SAVEEXCEPTION", e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Agricole_information> getAgricole_informations() {
        List<Agricole_information> agricole_informations = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from agricole_information", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {
            Agricole_information ag = new Agricole_information();
            ag.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            ag.setTypeof_activity(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__TYPE_ACTIVITY)));
            ag.setActivity_object(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__OBJECT_ACTIVITY)));
            ag.setSourceof_approvionnement(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__SOURCE_APPROVISIONNNEMENT)));
            ag.setScope(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__ENTENDUE)));
            agricole_informations.add(ag);
            rs.moveToNext();
        }
        return agricole_informations;
    }

    @Override
    public Agricole_information getAgricole_information(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from agricole_information where id=" + id + "", null);
        rs.moveToFirst();

        Agricole_information ag = null;

        while (rs.isAfterLast() == false) {
            ag = new Agricole_information();
            ag.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            ag.setTypeof_activity(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__TYPE_ACTIVITY)));
            ag.setActivity_object(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__OBJECT_ACTIVITY)));
            ag.setSourceof_approvionnement(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__SOURCE_APPROVISIONNNEMENT)));
            ag.setScope(rs.getString(rs.getColumnIndex(AGRICOLE_INFORMATION_COLUMN__ENTENDUE)));

            rs.moveToNext();
        }
        return ag;
    }

    @Override
    public long saveTrade_information(Trade_information co) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(COMMERCE_INFORMATION_COLUMN__TYPE_COMMERCE, co.getTypeof_sale());
        values.put(COMMERCE_INFORMATION_COLUMN__CAPACITE_COMMERCE, co.getEconomic_capacity());
        values.put(COMMERCE_INFORMATION_COLUMN__SOURCE_COMMERCE, co.getSourceof_supply());

        try {
            long a = db.insert("trade_information", null, values);
            return a;
        } catch (Exception e) {
            Log.d("SAVEEXCEPTION", e.getMessage());
        }
        return 0;
    }


    @Override
    public List<Trade_information> getTrade_information() {
        List<Trade_information> trade_informations = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from trade_information", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {
            Trade_information co = new Trade_information();
            co.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            co.setTypeof_sale(rs.getString(rs.getColumnIndex(COMMERCE_INFORMATION_COLUMN__TYPE_COMMERCE)));
            co.setEconomic_capacity(rs.getString(rs.getColumnIndex(COMMERCE_INFORMATION_COLUMN__SOURCE_COMMERCE)));
            co.setSourceof_supply(rs.getString(rs.getColumnIndex(COMMERCE_INFORMATION_COLUMN__CAPACITE_COMMERCE)));
            trade_informations.add(co);
            rs.moveToNext();
        }
        return trade_informations;
    }

    @Override
    public Trade_information getTrade_information(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from trade_information where id=" + id + "", null);
        rs.moveToFirst();

        Trade_information co = null;

        while (rs.isAfterLast() == false) {
            co = new Trade_information();
            co.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            co.setTypeof_sale(rs.getString(rs.getColumnIndex(COMMERCE_INFORMATION_COLUMN__TYPE_COMMERCE)));
            co.setSourceof_supply(rs.getString(rs.getColumnIndex(COMMERCE_INFORMATION_COLUMN__SOURCE_COMMERCE)));
            co.setEconomic_capacity(rs.getString(rs.getColumnIndex(COMMERCE_INFORMATION_COLUMN__CAPACITE_COMMERCE)));
            rs.moveToNext();
        }
        return co;
    }


    @Override
    public long saveTransport_infomation(Transport_information tr) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(TRANSPORT_INFORMATION_COLUMN__TYPE_TRANSPORT, tr.getVehicule_type());
        values.put(TRANSPORT_INFORMATION_COLUMN__MARQUE_TRANSPORT, tr.getVehicule_marque());
        values.put(TRANSPORT_INFORMATION_COLUMN__ANNNEE_TRANSPORT, tr.getAcquisition_year());
        values.put(TRANSPORT_INFORMATION_COLUMN__CAPACITE_TRANSPORT, tr.getTransport_capacity());

        try {
            long a = db.insert("transport_information", null, values);
            return a;
        } catch (Exception e) {
            Log.d("SAVEEXCEPTION", e.getMessage());
        }
        return 0;
    }
    @Override
    public List<Transport_information> getTransport_informations() {
        List<Transport_information> transport_informations = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from transport_information", null);
        rs.moveToFirst();

        while (rs.isAfterLast() == false) {
            Transport_information tr = new Transport_information();
            tr.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            tr.setVehicule_type(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__TYPE_TRANSPORT)));
            tr.setVehicule_marque(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__MARQUE_TRANSPORT)));
            tr.setAcquisition_year(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__ANNNEE_TRANSPORT)));
            tr.setTransport_capacity(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__CAPACITE_TRANSPORT)));

            transport_informations.add(tr);
            rs.moveToNext();
        }
        return transport_informations;
    }

    @Override
    public Transport_information getTransport_information(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from transport_information where id=" + id + "", null);
        rs.moveToFirst();

        Transport_information tr = null;

        while (rs.isAfterLast() == false) {
            tr = new Transport_information();
            tr.setId(rs.getInt(rs.getColumnIndex(COLUMN_ID)));
            tr.setVehicule_type(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__TYPE_TRANSPORT)));
            tr.setVehicule_marque(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__MARQUE_TRANSPORT)));
            tr.setAcquisition_year(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__ANNNEE_TRANSPORT)));
            tr.setTransport_capacity(rs.getString(rs.getColumnIndex(TRANSPORT_INFORMATION_COLUMN__CAPACITE_TRANSPORT)));
            rs.moveToNext();
        }
        return tr;
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

    public void initTerritoires() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.territoires);

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

    public void initSecteurs() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.secteurs);

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
}
