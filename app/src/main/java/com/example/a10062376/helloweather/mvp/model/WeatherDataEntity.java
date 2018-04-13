package com.example.a10062376.helloweather.mvp.model;

import java.util.List;

/**
 * Created by zengchengjie on 2018/4/13.
 */

public class WeatherDataEntity {

    /**
     * error_code : 0
     * reason : successed!
     * result : {"future":[{"date":"20180413","temperature":"6℃~12℃","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期五","wind":"南风微风"},{"date":"20180414","temperature":"5℃~19℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"week":"星期六","wind":"北风4-5级"},{"date":"20180415","temperature":"10℃~20℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"week":"星期日","wind":"西南风微风"},{"date":"20180416","temperature":"12℃~23℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期一","wind":"南风微风"},{"date":"20180417","temperature":"11℃~24℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"week":"星期二","wind":"南风微风"},{"date":"20180418","temperature":"5℃~19℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"week":"星期三","wind":"北风4-5级"},{"date":"20180419","temperature":"12℃~23℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期四","wind":"南风微风"}],"sk":{"humidity":"77%","temp":"10","time":"13:09","wind_direction":"西风","wind_strength":"1级"},"today":{"city":"北京","comfort_index":"","date_y":"2018年04月13日","dressing_advice":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","dressing_index":"较冷","drying_index":"","exercise_index":"较不宜","temperature":"6℃~12℃","travel_index":"较不宜","uv_index":"最弱","wash_index":"不宜","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期五","wind":"南风微风"}}
     * resultcode : 200
     */

    private int error_code;
    private String reason;
    private ResultBean result;
    private String resultcode;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public static class ResultBean {
        /**
         * future : [{"date":"20180413","temperature":"6℃~12℃","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期五","wind":"南风微风"},{"date":"20180414","temperature":"5℃~19℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"week":"星期六","wind":"北风4-5级"},{"date":"20180415","temperature":"10℃~20℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"week":"星期日","wind":"西南风微风"},{"date":"20180416","temperature":"12℃~23℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期一","wind":"南风微风"},{"date":"20180417","temperature":"11℃~24℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"week":"星期二","wind":"南风微风"},{"date":"20180418","temperature":"5℃~19℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"week":"星期三","wind":"北风4-5级"},{"date":"20180419","temperature":"12℃~23℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期四","wind":"南风微风"}]
         * sk : {"humidity":"77%","temp":"10","time":"13:09","wind_direction":"西风","wind_strength":"1级"}
         * today : {"city":"北京","comfort_index":"","date_y":"2018年04月13日","dressing_advice":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","dressing_index":"较冷","drying_index":"","exercise_index":"较不宜","temperature":"6℃~12℃","travel_index":"较不宜","uv_index":"最弱","wash_index":"不宜","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期五","wind":"南风微风"}
         */

        private SkBean sk;
        private TodayBean today;
        private List<FutureBean> future;

        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class SkBean {
            /**
             * humidity : 77%
             * temp : 10
             * time : 13:09
             * wind_direction : 西风
             * wind_strength : 1级
             */

            private String humidity;
            private String temp;
            private String time;
            private String wind_direction;
            private String wind_strength;

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }
        }

        public static class TodayBean {
            /**
             * city : 北京
             * comfort_index :
             * date_y : 2018年04月13日
             * dressing_advice : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
             * dressing_index : 较冷
             * drying_index :
             * exercise_index : 较不宜
             * temperature : 6℃~12℃
             * travel_index : 较不宜
             * uv_index : 最弱
             * wash_index : 不宜
             * weather : 小雨转多云
             * weather_id : {"fa":"07","fb":"01"}
             * week : 星期五
             * wind : 南风微风
             */

            private String city;
            private String comfort_index;
            private String date_y;
            private String dressing_advice;
            private String dressing_index;
            private String drying_index;
            private String exercise_index;
            private String temperature;
            private String travel_index;
            private String uv_index;
            private String wash_index;
            private String weather;
            private WeatherIdBean weather_id;
            private String week;
            private String wind;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 07
                 * fb : 01
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }

        public static class FutureBean {
            /**
             * date : 20180413
             * temperature : 6℃~12℃
             * weather : 小雨转多云
             * weather_id : {"fa":"07","fb":"01"}
             * week : 星期五
             * wind : 南风微风
             */

            private String date;
            private String temperature;
            private String weather;
            private WeatherIdBeanX weather_id;
            private String week;
            private String wind;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBeanX getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBeanX weather_id) {
                this.weather_id = weather_id;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public static class WeatherIdBeanX {
                /**
                 * fa : 07
                 * fb : 01
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }
    }
}
