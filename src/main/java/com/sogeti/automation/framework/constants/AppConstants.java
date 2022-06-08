package com.sogeti.automation.framework.constants;

import com.sogeti.automation.framework.utils.PropertyReader;

public final class AppConstants {
    public static String UI_BASE_URL = null;

    static {
        try {
            UI_BASE_URL = PropertyReader.getFieldValue("UI_BASE_URL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
