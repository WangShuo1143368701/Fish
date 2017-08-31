package com.qijing.fish.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qijing.fish.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by baiyuliang on 2016-7-14.
 */
public class ApiUtil {
    static String TAG = "Apiutil";

    private static int CONNECT_TIME = 15;
    private static int RADE_TIMEOUR = 15;

    public static ApiService createApiService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.e(TAG, "----request   " + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(CONNECT_TIME, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(RADE_TIMEOUR , TimeUnit.SECONDS);
        okHttpClientBuilder.retryOnConnectionFailure(true);
        OkHttpClient client = okHttpClientBuilder.addInterceptor(httpLoggingInterceptor).build();
       Gson mGson  = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.HTTP_post_URL)
                .client(client)
                .addConverterFactory(MyGsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
