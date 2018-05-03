package com.nurif.qluetest.server;

/**
 * Created by if_alan on 03/05/18.
 */

public class APIUtils {
    public static final String BASE_URL = "https://qlue-external-api.appspot.com";

    public static QlueService getQlueService() {
        return RetrofitClient.getClient(BASE_URL).create(QlueService.class);
    }
}
