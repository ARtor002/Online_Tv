package ir.ARtor.onlinetv.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_client {
    static Retrofit retrofit;
    public static Retrofit getRetrofit(String baseUrl){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
