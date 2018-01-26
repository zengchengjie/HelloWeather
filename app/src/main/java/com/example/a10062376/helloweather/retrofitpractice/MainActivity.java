package com.example.a10062376.helloweather.retrofitpractice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import com.google.gson.Gson;

import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonClick)
    void onClick() {
//        getMovie();
        getGps();
    }

    private void getGps() {
        long minTime = 1000;
        float minDistance = 10;
        LocationListener listener = null;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(this, "请打开系统定位权限！", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
            }

//            return;
        }

        locationManager = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);
        List<String> locationList = locationManager.getAllProviders();


        LocationProvider locationGpsProvider = locationManager.getProvider(locationManager.GPS_PROVIDER);//通过Gps定位,精确，耗电
        LocationProvider locationNetProvider = locationManager.getProvider(locationManager.NETWORK_PROVIDER);//通过网络定位，对定位精度不高或者省电的情况可以考虑
        if (locationGpsProvider != null || locationNetProvider != null) {
            //判断定位是否存在

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    String latitude = location.getLatitude() + "";//纬度
                    String longitude = location.getLongitude() + "";//经度
                    showResult.setText("纬度：" + latitude + "\n" + "经度：" + longitude);
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    Log.d(TAG, "onStatusChanged: ");
                }

                @Override
                public void onProviderEnabled(String provider) {
                    Log.d(TAG, "onProviderEnabled: ");
                }

                @Override
                public void onProviderDisabled(String provider) {
                    Log.d(TAG, "onProviderDisabled: ");
                }
            });
        } else {
            //无法定位：1、提示用户打开定位服务；2、跳转到设置界面
            Toast.makeText(this, "无法定位，请打开定位服务", Toast.LENGTH_SHORT).show();
            Intent i = new Intent();
            i.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(i);
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
}
