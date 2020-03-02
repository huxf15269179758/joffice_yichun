package com.hy.powerplatform.my_utils.utils;

import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.HttpResultNew;
import com.hy.powerplatform.my_utils.base.MyApplication;

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

public class HttpUtils3 {
    private static HttpUtils3 instance;

    private Retrofit retrofit;
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    private static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(100000, TimeUnit.SECONDS).
            readTimeout(100000, TimeUnit.SECONDS).
            writeTimeout(100000, TimeUnit.SECONDS).build();

    private HttpUtils3() {
        instance = this;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static HttpUtils3 getInstance() {
        if (instance == null) {
            synchronized (HttpUtils3.class) {
                if (instance == null) {
                    return new HttpUtils3();
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
