package com.example.a10062376.helloweather.retrofitpractice.httpUtils;

import com.example.a10062376.helloweather.retrofitpractice.MovieEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 10062376 on 2018/1/24.
 */

public interface MovieService {
    @GET("top250")
    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
