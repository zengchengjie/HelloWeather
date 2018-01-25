package com.example.a10062376.helloweather;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10062376.helloweather.httpUtils.HttpMethods;
import com.example.a10062376.helloweather.httpUtils.MovieService;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.buttonClick)
    Button clickMe;
    @BindView(R.id.showResult)
    TextView showResult;
//    豆瓣电影 https://api.douban.com/v2/movie/top250?start=0&count=10


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonClick)
    void onClick(){
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        getMovie();
    }

    private void getMovie() {
       /* //进行网络请求
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

        HttpMethods.getIncetance().getTopMovie(subscriber,0,10);
    }
}
