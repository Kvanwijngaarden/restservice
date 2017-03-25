package nl.hu.iac.service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvanwijngaarden on 25/03/2017.
 */
public class ValidateDate {

    public static boolean validateDate(String date){
        List<String> dateAccpet = Arrays.asList("today", "yesterday", "tomorrow", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday");

        for(String str: dateAccpet) {
            if(str.trim().contains(date.toLowerCase()))
                return true;
        }
        return false;
    }
}
