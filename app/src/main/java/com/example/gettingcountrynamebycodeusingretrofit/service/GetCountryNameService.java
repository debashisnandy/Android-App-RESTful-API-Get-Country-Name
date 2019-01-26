package com.example.gettingcountrynamebycodeusingretrofit.service;

import com.example.gettingcountrynamebycodeusingretrofit.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetCountryNameService {
    @GET("country/get/iso2code/{alpha2_code}")
    Call<Info> getCountryName(@Path("alpha2_code")String countryName);
}
