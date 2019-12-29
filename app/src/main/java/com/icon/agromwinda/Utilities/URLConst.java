package com.icon.agromwinda.Utilities;

public class URLConst {
    private static final String PROTOCOLE = "http";
    //private static final String HOST = "192.168.137.1";
    private static final String HOST = "192.168.1.115";
    //private static final String HOST = "192.168.7.23";
    private static final String PORT = "8080";


    public static String BASE_URL() {
        //return PROTOCOLE + "://" + HOST + ":" + PORT + "/TaxeMobilierUrbain";
        return PROTOCOLE + "://" + HOST + ":" + PORT + "/mobilierurbainwebnew";
    }


    public static String LoadSupportPub() {
        return BASE_URL()+"/api-loadSupportPub";
    }

    public static String mobilHost() {
        return BASE_URL()+"/MobilHost";
    }
}
