package com.project.studentmanagement.Util;

public class StringUtil {
    //String convert to StringArray
    public static String[] stringConvertToStringArr(String id, String regex) {
        String[] stringArray = id.split(regex);
        return stringArray;
    }
}
