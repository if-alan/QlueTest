package com.nurif.qluetest.server;

import com.nurif.qluetest.model.QlueModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by if_alan on 03/05/18.
 */
public interface QlueService {
    @GET("/example/top_report")
    Call<List<QlueModel>> getData();
}
