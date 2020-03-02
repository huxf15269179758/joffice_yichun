package com.hy.powerplatform.my_utils.utils;

import com.hy.powerplatform.my_utils.base.HttpResultNew;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dell on 2017/4/20.
 */

public class HttpUtilsTest {
    private static HttpUtilsTest instance;

    private Retrofit retrofit;



    private static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(100000, TimeUnit.SECONDS).
            readTimeout(100000, TimeUnit.SECONDS).
            writeTimeout(100000, TimeUnit.SECONDS).build();

    private HttpUtilsTest() {
        instance = this;
        String BASE_URL="http://112.230.201.22:9000/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static HttpUtilsTest getInstance() {
        if (instance == null) {
            synchronized (HttpUtilsTest.class) {
                if (instance == null) {
                    return new HttpUtilsTest();
                }
            }
        }
        return instance;
    }

    public static <T> T getService(Class<T> c) {
        return getInstance().retrofit.create(c);
    }

    public static <T> void init(Observable<HttpResultNew<T>> observable, Subscriber<HttpResultNew<T>> subscriber) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public static <T> void initlist(Observable<T> observable, Subscriber<T> subscriber) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
