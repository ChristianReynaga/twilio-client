package dev.chrislancer.twilioclient.client;

import dev.chrislancer.twilioclient.client.interceptors.BasicAuthInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitClient {

    private static final int TIME_OUT = 60;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static Retrofit client;

    private RetrofitClient() {
    }

    public static Retrofit initializeClient(String baseUrl, String authUsername, String authPassword) {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(TIME_OUT, TIME_UNIT)
                .connectTimeout(TIME_OUT, TIME_UNIT)
                .addInterceptor(new BasicAuthInterceptor(authUsername, authPassword))
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("EEE, dd MMM yyyy HH:mm:ss Z")
                .create();

        client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return client;
    }

    public static Retrofit getInstance() {
        return client;
    }

}
