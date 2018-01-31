package com.example.a10062376.helloweather.retrofitpractice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10062376.helloweather.R;
import com.example.a10062376.helloweather.retrofitpractice.httpUtils.HttpMethods;
import com.example.a10062376.helloweather.utils.GetLocation;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.buttonClick)
    Button clickMe;
    @BindView(R.id.showResult)
    TextView showResult;
    //    豆瓣电影 https://api.douban.com/v2/movie/top250?start=0&count=10
    LocationManager locationManager;
    private String TAG = "testWeather";
    private List<Map<String,String>> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonClick)
    void onClick() {
//        getMovie();
        list = GetLocation.getIncetance().getGps(this,this);
        if (list.size()>0){
            showResult.setText(list.get(0).get("latitude")+"\n"+list.get(1).get("longitude"));
        }else {
            Toast.makeText(this, "经纬度数据为空", Toast.LENGTH_SHORT).show();
        }
    }



    private void getMovie() {
       /* //使用Retrofit+RxJava方式进行网络请求
        String baseUrl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();//addCallAdapterFactory添加对RxJava的支持

        MovieService movieService = retrofit.create(MovieService.class);

        movieService.getTopMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieEntity>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "GET TOP MOVIEW COMPLETE", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        showResult.setText(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieEntity movieEntity) {
                        showResult.setText(new Gson().toJson(movieEntity).toString());
                    }
                });*/
        //用RxJava的方式进行进一步封装
        Subscriber<MovieEntity> subscriber = new Subscriber<MovieEntity>() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "GET TOP MOVIEW COMPLETE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                showResult.setText(e.getMessage());
            }

            @Override
            public void onNext(MovieEntity movieEntity) {
                showResult.setText(new Gson().toJson(movieEntity).toString());
            }
        };

        HttpMethods.getIncetance().getTopMovie(subscriber, 0, 10);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        locationManager.removeUpdates(listner);//退出时关闭GPS
    }
}
