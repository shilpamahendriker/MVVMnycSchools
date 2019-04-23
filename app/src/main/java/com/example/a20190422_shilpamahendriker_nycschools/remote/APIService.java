package com.example.a20190422_shilpamahendriker_nycschools.remote;

import com.example.a20190422_shilpamahendriker_nycschools.model.School;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    String BASE_URL = "https://data.cityofnewyork.us/";

    @GET("resource/97mf-9njv.json?$select=borough,dbn,school_name,location")
    Call<ArrayList<School>> getSchools();

}
