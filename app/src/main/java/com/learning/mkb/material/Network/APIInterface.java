package com.learning.mkb.material.Network;

import com.learning.mkb.material.Model.MovieResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("movie/top_rated")

    Call<MovieResponce> getTopRatedMovies(@Query("api_key") String apiKey);


}
