package com.example.utsika;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("bins/vd36p")
    Call<List<Sayuran>> getSayuran2();
}
