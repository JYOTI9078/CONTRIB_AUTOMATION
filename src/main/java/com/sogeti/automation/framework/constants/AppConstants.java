package com.sogeti.automation.framework.constants;

import com.sogeti.automation.framework.utils.PropertyReader;

public final class AppConstants {
    public static String UI_BASE_URL = null;
    public static String GRID_HUB_URL = null;
    public static String GRIP_HUB_PORT = null;

    static {
        try {
            UI_BASE_URL = PropertyReader.getFieldValue("UI_BASE_URL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            GRIP_HUB_PORT = PropertyReader.getFieldValue("GRID_HUB_PORT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            GRID_HUB_URL = "http://" + PropertyReader.getFieldValue("GRID_HUB_IP") + ":" +
                    GRIP_HUB_PORT + "/wd/hub";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
