package com.example.day3.anli.util;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtil implements InNetInterface{

    private static RetrofitUtil retrofitUtil;

    private ApIservice api;

    public RetrofitUtil() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(UrlConstant.Bannerurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = build.create(ApIservice.class);
    }

    public static RetrofitUtil getRetrofitUtil() {
        if (retrofitUtil ==null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil==null){
                    retrofitUtil=new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    @Override
    public <T> void get(String url, InNetCallback callback) {
        api.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] types = callback.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) types[0]).getActualTypeArguments();
                            Type argument = arguments[0];
                            Gson gson = new Gson();
                            T result = gson.fromJson(string, argument);
                            callback.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, InNetCallback callback) {
        api.post(url)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] types = callback.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) types[0]).getActualTypeArguments();
                            Type argument = arguments[0];
                            Gson gson = new Gson();
                            T result = gson.fromJson(string, argument);
                            callback.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, InNetCallback callback) {
        api.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] types = callback.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) types[0]).getActualTypeArguments();
                            Type argument = arguments[0];
                            Gson gson = new Gson();
                            T result = gson.fromJson(string, argument);
                            callback.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
