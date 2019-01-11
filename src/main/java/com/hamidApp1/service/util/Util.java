package com.hamidApp1.service.util;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import com.hamidApp1.controller.usersGisController.aesTsete.Encryptor;

import java.time.LocalDate;
import java.util.Date;

// this is the util
public class Util {
    public Util() {
    }

    public static String getJwtsSecretKey() {
        //get the key and return back the decryption
        //return Encryptor.decrypt("Bar12345Bar12345","RandomInitVector","a6660dc7d766da18042395d21cc031306fe61e0c2a7a0a92c7167566ebd8d91e");
    return "personalSecretKey";
    }

    public static String getFirstDay(int month, String formatting) {
        LocalDate begin = LocalDate.now().withMonth(month).with(TemporalAdjusters.firstDayOfMonth()).minusMonths(1);

        if (formatting == null){
            formatting = "dd/MM/yyyy";
        }
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(formatting);

        String startDay = begin.format(formatDate);
        return startDay;
    }

    public static String geLastDay(int month, String formatting) {
        LocalDate last =LocalDate.now().withMonth(month).with(TemporalAdjusters.lastDayOfMonth());

        if (formatting == null ){
            formatting = "dd/MM/yyyy";
        }
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(formatting);

        String lastDay = last.format(formatDate);
        return lastDay;
    }

    public static String getStrDate(LocalDate date, String formatting) {
        if (formatting == null ){
            formatting = "dd/MM/yyyy";
        }
        DateTimeFormatter formattera = DateTimeFormatter.ofPattern(formatting);
        return date.format(formattera);
    }
}
