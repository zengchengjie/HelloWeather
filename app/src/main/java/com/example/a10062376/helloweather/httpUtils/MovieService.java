package com.example.a10062376.helloweather.httpUtils;

import com.example.a10062376.helloweather.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 10062376 on 2018/1/24.
 */

public interface MovieService {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start,@Query("count") int count);
}
