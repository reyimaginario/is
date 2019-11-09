package com.hexsoft.athos.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtils {

    public static String fechaToString(Date fechaDate) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String fechaString = df.format(fechaDate);
        return fechaString;
    }


    public static Date stringToDate(String fechaString) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        Date fechaDate;
        try {
            fechaDate = df.parse(fechaString);
        }
        catch (ParseException e) {
            fechaDate = null;
        }
        return fechaDate;
    }

    public static Date obtenerFechaActual() {
        return new Date();
    }

}
