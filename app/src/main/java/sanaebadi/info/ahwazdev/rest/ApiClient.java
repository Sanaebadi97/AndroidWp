package sanaebadi.info.ahwazdev.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sanaebadi on 7/7/18.
 */

public class ApiClient {

  private static final String TAG = "ApiClient";
  private static final String BASE_URL = "https://sanaebadi.info/wp-json/wp/v2/";
  private static ApiInterface apiInterface;

  public static ApiInterface createApi() {
    if (apiInterface == null) {

      HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

      OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build();


      Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

      apiInterface = retrofit.create(ApiInterface.class);
    }

    return apiInterface;
  }


}
