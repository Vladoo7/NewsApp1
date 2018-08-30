package ua.vladoo.newsapp;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiStreams {

    private static final String API_KEY = "e4a81278fcbb4c69a7c215599de9f679";



    // TODO use this to fetch Most Popular
    public static Observable<MostPopular> streamMostPopular(){
        ApiServices mApiServices = ApiServices.retrofit.create(ApiServices.class);
        return mApiServices.getMostEmailed(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<MostPopular> streamMostShared(){
        ApiServices mApiServices = ApiServices.retrofit.create(ApiServices.class);
        return mApiServices.getMostShared(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

    public static Observable<MostPopular> streamMostEmailed(){
        ApiServices mApiServices = ApiServices.retrofit.create(ApiServices.class);
        return mApiServices.getMostViewed(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


}
