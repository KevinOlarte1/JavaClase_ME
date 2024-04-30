package com.kevinolarte.lib;

import java.time.LocalDate;
import java.util.Date;

public class LibConversion {
    public static LocalDate dateToLocalDate(Date date){
        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }
}
