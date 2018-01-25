package com.example.a10062376.helloweather;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10062376.helloweather.httpUtils.MovieService;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.buttonClick)
    Button clickMe;
    @BindView(R.id.showResult)
    TextView showResult;
//    豆瓣电影 https://api.douban.com/v2/movie/top250?start=0&count=10
ProgressDialog dialog = new ProgressDialog(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonClick)
    void onClick(){
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        dialog.show();
        getMovie();
    }

    private void getMovie() {
        //进行网络请求
        String baseUrl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Call<MovieEntity> movieEntityCall = movieService.getTopMovie(0, 10);
        movieEntityCall.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                showResult.setText(new Gson().toJson(response.body()).toString());
                dialog.cancel();

            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {
                dialog.cancel();
                showResult.setText(t.getMessage());
            }
        });
    }
}
