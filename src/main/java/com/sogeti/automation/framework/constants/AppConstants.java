package com.sogeti.automation.framework.constants;

import com.sogeti.automation.framework.utils.PropertyReader;

public class AppConstants {

    public static final String INTERFACE_TYPE = PropertyReader.getFieldValue("InterfaceType");
    public static final String AZURE_KEYVAULT_URL = PropertyReader.getFieldValue("AZURE_KEYVAULT_URL");

    /*static {
        try {
            INTERFACE_TYPE = PropertyReader.getFieldValue("InterfaceType");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            AZURE_KEYVAULT_URL = PropertyReader.getFieldValue("AZURE_KEYVAULT_URL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static class Web {
        public static final String UI_BASE_URL = PropertyReader.getFieldValue("UI_BASE_URL");
        public static final String GRIP_HUB_PORT = PropertyReader.getFieldValue("GRID_HUB_PORT");
        public static final String GRID_HUB_URL = "http://" + PropertyReader.getFieldValue("GRID_HUB_IP")
                + ":" + GRIP_HUB_PORT + "/wd/hub";
        public static final String UI_USERNAME = PropertyReader.getFieldValue("UI_USERNAME");
        public static final String UI_PASSWORD = PropertyReader.getFieldValue("UI_PASSWORD");

        /*static {
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

        static {
            try {
                UI_USERNAME = PropertyReader.getFieldValue("UI_USERNAME");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                UI_PASSWORD = PropertyReader.getFieldValue("UI_PASSWORD");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

    }

    public static class Api {
        public static final String API_BASE_URL = PropertyReader.getFieldValue("API_BASE_URL");
        public static final String API_USERNAME = PropertyReader.getFieldValue("API_USERNAME");
        public static final String API_PASSWORD = PropertyReader.getFieldValue("API_PASSWORD");
        public static final String API_GRANT_TYPE = PropertyReader.getFieldValue("API_GRANT_TYPE");
        public static final String API_TOKEN = PropertyReader.getFieldValue("API_TOKEN");
        public static final String API_SCOPE = PropertyReader.getFieldValue("API_SCOPE");
        public static final String API_ACCESS_TOKEN_URL = PropertyReader.getFieldValue("API_ACCESS_TOKEN_URL");
        public static final String API_CLIENT_ID = PropertyReader.getFieldValue("API_CLIENT_ID");
        public static final String API_CLIENT_SECRET = PropertyReader.getFieldValue("API_CLIENT_SECRET");
        public static final String API_REDIRECT_URL = PropertyReader.getFieldValue("API_REDIRECT_URL");
        public static final String API_RESPONSE_TYPE = PropertyReader.getFieldValue("API_RESPONSE_TYPE");
        public static final String API_AUTHORIZATION_CODE = PropertyReader.getFieldValue("API_AUTHORIZATION_CODE");
        public static final String API_CODE_CHALLENGE = PropertyReader.getFieldValue("API_CODE_CHALLENGE");
        public static final String API_CODE_CHALLENGE_METHOD = PropertyReader.getFieldValue("API_CODE_CHALLENGE_METHOD");

        public static final String GITHUB_USER_URL = "/users/";
        public static final String GITHUB_USER_REPOS = "/user/repos";
        public static final String GITHUB_REPOS = "/repos/";

        public enum AuthenticationType {
            BASIC,
            DIGEST,
            TOKEN,
            OAUTH2
        }

        public enum GrantType {
            AUTHORIZATION_CODE,
            CLIENT_CREDENTIALS,
            PASSWORD
        }

        /*static {
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
                API_TOKEN = PropertyReader.getFieldValue("API_TOKEN");
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

        static {
            try {
                API_CLIENT_ID = PropertyReader.getFieldValue("API_CLIENT_ID");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_CLIENT_SECRET = PropertyReader.getFieldValue("API_CLIENT_SECRET");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_REDIRECT_URL = PropertyReader.getFieldValue("API_REDIRECT_URL");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_RESPONSE_TYPE = PropertyReader.getFieldValue("API_RESPONSE_TYPE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_AUTHORIZATION_CODE = PropertyReader.getFieldValue("API_AUTHORIZATION_CODE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_CODE_CHALLENGE = PropertyReader.getFieldValue("API_CODE_CHALLENGE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static {
            try {
                API_CODE_CHALLENGE_METHOD = PropertyReader.getFieldValue("API_CODE_CHALLENGE_METHOD");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

}
