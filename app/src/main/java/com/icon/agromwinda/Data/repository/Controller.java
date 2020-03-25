package com.icon.agromwinda.Data.repository;

import android.content.Context;
import android.util.Log;

import java.io.File;

public class Controller {

    private static Dao dao;

    public static void initDB(Context context){

        File dbtest = new File("/data/data/com.icon.agromwinda/databases/agraMwinda.db");

        if (dbtest.exists()) {
            Log.d("DataBaseInit","already exist");
        } else {
            dao=new Dao(context);
            Log.d("DataBaseInit","doesn't exist");
            dao.initProvinces();
            dao.initTowns();
            dao.initCommunes();
            dao.initTerritoires();
            dao.initSecteurs();
        }
    }


}
