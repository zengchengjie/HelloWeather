package com.example.a10062376.helloweather.httpUtils;

import com.example.a10062376.helloweather.mvp.model.MovieEntity;
import com.example.a10062376.helloweather.mvp.model.WeatherDataEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 10062376 on 2018/1/24.
 */

public interface MovieService {
    //    String url = "https://api.douban.com/v2/movie/top250?start=0&count=10";
    @GET("top250")
    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
    //    http://v.juhe.cn/weather/index?format=2&cityname=%E5%8C%97%E4%BA%AC&key=xxx

    /**
     * 根据城市名/id查询天气
     * @param cityName
     * @param key
     * @return
     */
    @GET("index")
    Observable<WeatherDataEntity> getWeatherData(@Query("cityname") String cityName,@Query("key") String key);
    /**
     * 根据城市名/id查询天气
     * @param key
     * @return
     */
    @GET("uni")
    Observable<WeatherDataEntity> getWeatherType(@Query("key") String key);

}
