package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitSetup {

    public static final String AUTH_HEADER_NAME = "Authorization";

    private Endpoints endpoints;

    private static final String BASE_URL = "https://reqres.in/";

    public RetrofitSetup(String JWT) {
        createRequest(JWT);
    } //If endpoint requests authorization

    public RetrofitSetup() {
        createRequest("");
    }

    private void createRequest(String JWT) {
        Gson gson = new GsonBuilder()
                .setLenient().create();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HTTPLogInterceptor())
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader(AUTH_HEADER_NAME, "JWT " + JWT)
                            .addHeader("X-Forwarded-For", "193.0.220.199")
                            .build();
                    return chain.proceed(request);
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        endpoints = retrofit.create(Endpoints.class);
    }

    public Endpoints endpoints() {
        return endpoints;
    }
}