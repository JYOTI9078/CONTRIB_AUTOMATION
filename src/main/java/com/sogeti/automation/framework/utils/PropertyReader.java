package com.sogeti.automation.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties valueMap = new Properties();
    private static Logging log = new Logging(PropertyReader.class.getName());

    public void valueMap(String fileName) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        valueMap.load(inputStream);
        assert inputStream != null;
        inputStream.close();
    }

    public static String getFieldValue(String fieldName) {
        String fieldValue = valueMap.getProperty(fieldName);
        log.info("Received parameter '" + fieldName + "' = " + fieldValue);
        if (fieldValue == null) {
            log.error("INCORRECT PARAMETER '" + fieldName + "' WAS SUPPLIED FOR RETRIEVAL FROM CONFIG");
            return "false";
        } else {return fieldValue;}
    }

    public static void setFieldValue(String fieldName, String fieldValue) {
        valueMap.setProperty(fieldName, fieldValue);
        log.info("Set parameter '" + fieldName + "' = " + fieldValue);
    }
}
