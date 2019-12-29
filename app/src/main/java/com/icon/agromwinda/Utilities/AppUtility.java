package com.icon.agromwinda.Utilities;

import android.text.TextUtils;

/**
 * Created by c.eboma on 09/02/2018.
 */

public class AppUtility {

    public static void controlValue(String value, String s) throws ValueDataException {
        if(value==null || (value!=null && TextUtils.isEmpty(value)))
            throw new ValueDataException(s);
    }

    public static void controlValue(Integer value, String message) throws ValueDataException{
        if(value==null || (value!=null && value<=0))
            throw new ValueDataException(message);
    }

    public static void controlValue(Double value, String message) throws ValueDataException{
        if(value==null || (value!=null && value<=0))
            throw new ValueDataException(message);
    }

}
