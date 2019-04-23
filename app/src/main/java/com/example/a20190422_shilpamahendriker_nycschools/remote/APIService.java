package com.example.a20190422_shilpamahendriker_nycschools.remote;

import com.example.a20190422_shilpamahendriker_nycschools.model.School;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    String BASE_URL = "https://data.cityofnewyork.us/resource/";

    @GET("97mf-9njv.json?$select=borough,dbn,school_name,location")
    Call<ArrayList<School>> getSchools();

    @GET("734v-jeq5.json?")
    Response getSchoolDetails(@Query("dbn") String dbn);


}
