package com.example.a20190422_shilpamahendriker_nycschools.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import android.util.Log;
import android.widget.Toast;

import com.example.a20190422_shilpamahendriker_nycschools.model.School;
import com.example.a20190422_shilpamahendriker_nycschools.remote.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolViewModel extends ViewModel {
    //this is the data that we will fetch asynchronously
    private MutableLiveData<ArrayList<School>> schoolList;

    //we will call this method to get the data
    public LiveData<ArrayList<School>> getSchools() {
        //if the list is null
        if (schoolList == null) {
            schoolList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadSchools();
        }

        //finally we will return the list
        return schoolList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadSchools() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        Call<ArrayList<School>> call = api.getSchools();


        call.enqueue(new Callback<ArrayList<School>>() {
            @Override
            public void onResponse(Call<ArrayList<School>> call, Response<ArrayList<School>> response) {

                //finally we are setting the list to our MutableLiveData

                schoolList.setValue(response.body());

                Log.v("myLogs", "log: " + response);
                Log.v ("myLogs", "schoolList " + response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<School>> call, Throwable t) {

                schoolList.setValue(null);
                Log.v("myLogs"," Failed to retrieve data");

            }
        });
    }


   // public Response
}
