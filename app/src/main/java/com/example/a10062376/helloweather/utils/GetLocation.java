package com.example.a10062376.helloweather.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10062376 on 2018/1/29.
 */

public class GetLocation {
    private List<Map<String, String>> locationMapList = new ArrayList<>();
    private Map<String, String> latitudeMap = new HashMap<>();//纬度
    private Map<String, String> longitudeMap = new HashMap<>();//经度
    private static GetLocation location;
    private String TAG= "testWeather";

    private GetLocation() {
    }

    public static synchronized GetLocation getIncetance() {
        if (location == null) {
            location = new GetLocation();
        }
        return location;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            /*switch (msg.toString()) {
                case "a":

                    break;
                default:
                    break;
            }*/
            
        }
    };

    public List<Map<String, String>> getGps(Context context, Activity activity) {
        long minTime = 1000;
        float minDistance = 10;
        LocationListener listener = null;
        LocationManager locationManager;

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(context, "请打开系统定位权限！", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                activity.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
            }

            return null;
        }

        locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        List<String> locationList = locationManager.getAllProviders();
        for (String string1 : locationList) {
            System.out.println(string1);
        }
        // 2.2 获取最佳的定位方式
        Criteria criteria = new Criteria();
        criteria.setAltitudeRequired(true);  // 设置是否可以定位海拔高度的,如果设置为true 则一定会返回GPS定位
        listener = new MyLocationListner();


        LocationProvider locationGpsProvider = locationManager.getProvider(locationManager.GPS_PROVIDER);//通过Gps定位,精确，耗电
        LocationProvider locationNetProvider = locationManager.getProvider(locationManager.NETWORK_PROVIDER);//通过网络定位，对定位精度不高或者省电的情况可以考虑
        if (locationGpsProvider != null || locationNetProvider != null) {
            //判断定位是否存在
            Log.d(TAG, "getGps:1 ");
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
            if (locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER))
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);

            if (locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER))
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
            Log.d(TAG, "getGps: 2");
        } else {
            //无法定位：1、提示用户打开定位服务；2、跳转到设置界面
            Toast.makeText(context, "无法定位，请打开定位服务", Toast.LENGTH_SHORT).show();
            Intent i = new Intent();
            i.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            context.startActivity(i);
        }
        return locationMapList;
    }

    private class MyLocationListner implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            String latitude = location.getLatitude() + "";//纬度
            String longitude = location.getLongitude() + "";//经度
            latitudeMap.put("latitude", latitude);
            longitudeMap.put("longitude", longitude);
            locationMapList.clear();
            locationMapList.add(latitudeMap);
            locationMapList.add(longitudeMap);
            Log.d(TAG, "onLocationChanged: ");
//            handler.sendEmptyMessage(0);
            /*Message msg = new Message();
            msg.what = 0;
            msg.obj = locationMapList;
            handler.sendMessage(msg);*/

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    }
}
