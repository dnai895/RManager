/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Dani
 */
public class General {
    
    public static void log(String ubicacion, String nota) {
        Calendar calendario = new GregorianCalendar();
        int hora        = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos     = calendario.get(Calendar.MINUTE);
        int segundos    = calendario.get(Calendar.SECOND);
        int year        = calendario.get(Calendar.YEAR);
        int month       = calendario.get(Calendar.MONTH);
        int day         = calendario.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+"-"+month+"-"+day+" "+hora+":"+minutos+":"+segundos+"   "+ubicacion+", "+nota);
    }
    
}
