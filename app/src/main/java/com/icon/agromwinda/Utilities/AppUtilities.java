
package com.icon.agromwinda.Utilities;

/**
 *
 * @author emmanueltombo
 */
public class AppUtilities {
    
    public static void checkValue(Object value,String message) throws ValueException{
        if(value==null || value.equals("")){
            throw new ValueException(message);
        }
    }
}
