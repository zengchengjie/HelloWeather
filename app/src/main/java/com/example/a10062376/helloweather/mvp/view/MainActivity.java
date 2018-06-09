package com.example.a10062376.helloweather.mvp.view;

import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10062376.helloweather.R;
import com.example.a10062376.helloweather.httpUtils.MovieService;
import com.example.a10062376.helloweather.mvp.model.MovieEntity;
import com.example.a10062376.helloweather.httpUtils.HttpMethods;
import com.example.a10062376.helloweather.mvp.model.WeatherDataEntity;
import com.example.a10062376.helloweather.utils.Constants;
import com.example.a10062376.helloweather.utils.GetLocation;
import com.example.a10062376.helloweather.utils.MacAddressUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnLocation)
    Button clickMe;
    @BindView(R.id.showResult)
    TextView showResult;
    @BindView(R.id.showCardView)
    WebView webView;
    //    豆瓣电影 https://api.douban.com/v2/movie/top250?start=0&count=10
    LocationManager locationManager;
    private String TAG = "testWeather";
    private List<Map<String, String>> list = new ArrayList<>();
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String webUrl = msg.getData().getString("webUrl");
            Log.d(TAG, "定时打印网址： " + webUrl);
//            openWeb("http://baidu.com");//需要我轮询的网址
            openWeb(webUrl);//需要我轮询的网址
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String Url = getWebUrl(MacAddressUtils.getMacAddressFromIp(getApplicationContext()));
        Log.d(TAG, "run-----------------------------    : " + Url);

//        webViewInit();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String webUrl = getWebUrl(MacAddressUtils.getMacAddressFromIp(getApplicationContext()));
                Log.d(TAG, "5秒打印一次mac地址 并打开网页：" + webUrl);
                Bundle bundle = new Bundle();
                bundle.putString("webUrl", webUrl);
                Message message = new Message();
                message.what = 1;
                message.setData(bundle);
                //发送消息
                handler.sendMessage(message);
            }
        }, new Date(), 5000);
    }

    void openWeb(String webUrl) {
        webView.getSettings().setJavaScriptEnabled(true);  //设置WebView属性，能够执行Javascript脚本
        webView.loadUrl(webUrl);
        //步骤3. 复写shouldOverrideUrlLoading()方法，使得打开网页时不调用系统浏览器， 而是在本WebView中显示
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    private void webViewInit() {
        //声明WebSettings子类
        WebSettings webSettings = webView.getSettings();

//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

//支持插件
//    webSettings.setPluginsEnabled(true);

//设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

//缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

//其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        return false;
    }

    @OnClick({R.id.btnLocation, R.id.btnNet})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLocation:
                list = GetLocation.getIncetance().getGps(this, this);
                if (list != null) {

                    if (list.size() > 0) {
                        showResult.setText(list.get(0).get("latitude") + "\n" + list.get(1).get("longitude"));
                    } else {
                        Toast.makeText(this, "经纬度数据为空", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnNet:
                Toast.makeText(this, "网络请求", Toast.LENGTH_SHORT).show();
                getWeatherData();
                break;
        }
//        getWeatherData();

    }

    private String getWebUrl(String macAddress) {
        //访问后台地址 获取网页数据
//        Subscriber
        
        return "http://10.1.144.244:8080/tag/display?tagMac="+macAddress;
    }

    /**
     * 获取天气数据
     */
    private void getWeatherData() {
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
        Subscriber<WeatherDataEntity> subscriber = new Subscriber<WeatherDataEntity>() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "GET TOP MOVIEW COMPLETE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                showResult.setText(e.getMessage());
            }

            @Override
            public void onNext(WeatherDataEntity weatherDataEntity) {

                showResult.setText(new Gson().toJson(weatherDataEntity).toString());
            }
        };

        HttpMethods.getIncetance().getWeatherData(subscriber, "北京", Constants.WEATHER_KEY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
//        locationManager.removeUpdates(listner);//退出时关闭GPS
    }


}

