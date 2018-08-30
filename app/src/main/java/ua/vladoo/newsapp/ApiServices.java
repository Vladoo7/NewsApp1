package ua.vladoo.newsapp;

import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    // ApiServices Request for "Most Emailed" tab
    @GET("svc/mostpopular/v2/mostemailed/all-sections/30.json")
    Observable<MostPopular> getMostEmailed(@Query("api-key") String apiKey);

    // ApiServices Request for "Most Shared" tab
    @GET("svc/mostpopular/v2/mostshared/all-sections/30.json")
    Observable<MostPopular> getMostShared(@Query("api-key") String apiKey);

    // ApiServices Request for "Most Viewed" tab
    @GET("svc/mostpopular/v2/mostviewed/all-sections/30.json")
    Observable<MostPopular> getMostViewed(@Query("api-key") String apiKey);


    // Retrofit builder with New York Times base URL
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create(
                    new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
