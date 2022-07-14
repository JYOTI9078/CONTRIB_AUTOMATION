package com.sogeti.automation.framework.constants;

import com.sogeti.automation.framework.utils.PropertyReader;

public class AppConstants {
    public static String UI_BASE_URL = null;
    public static String GRID_HUB_URL = null;
    public static String GRIP_HUB_PORT = null;

    public static class Web {

        static {
            try {
                UI_BASE_URL = PropertyReader.getFieldValue("UI_BASE_URL");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static class Api {
        public static String API_BASE_URL = null;
        public static String API_USERNAME = null;
        public static String API_PASSWORD = null;
        public static String API_GRANT_TYPE = null;
        public static String API_SCOPE = null;
        public static String API_ACCESS_TOKEN_URL = null;

        static {
            try {
                API_BASE_URL = PropertyReader.getFieldValue("API_BASE_URL");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_USERNAME = PropertyReader.getFieldValue("API_USERNAME");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_PASSWORD = PropertyReader.getFieldValue("API_PASSWORD");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_GRANT_TYPE = PropertyReader.getFieldValue("API_GRANT_TYPE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_SCOPE = PropertyReader.getFieldValue("API_SCOPE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_ACCESS_TOKEN_URL = PropertyReader.getFieldValue("API_ACCESS_TOKEN_URL");
            } catch (Exception e) {
                e.printStackTrace();
            }
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
