package it.atos.pl.mvp.injector.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.atos.pl.mvp.BuildConfig;
import it.atos.pl.mvp.data.DataManager;
import it.atos.pl.mvp.injector.scope.PerApplication;
import it.atos.pl.mvp.network.Repository;
import it.atos.pl.mvp.rest.RetrofitRestRepository;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
@Module
public class NetworkModule {

    public static final String API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ";
    public static final FieldNamingPolicy API_JSON_NAMING_POLICY = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;


    @Provides
    @PerApplication
    RetrofitRestRepository provideRepository(Retrofit retrofit) {
        return new RetrofitRestRepository(retrofit);

    }

    @Provides
    @PerApplication
    Scheduler provideAndroidScheduler(){
        return AndroidSchedulers.mainThread();
    }


    @Provides
    @PerApplication
    public Retrofit provideRetrofit() {
        String endpointUrl = BuildConfig.ENVIRONMENT;
        /*
        Gson gson = new GsonBuilder()
                .setDateFormat(API_DATE_FORMAT)
                .setFieldNamingPolicy(API_JSON_NAMING_POLICY)
                .registerTypeAdapter(ResponseWrapper.class, new ResponseDeserializer())
                .addSerializationExclusionStrategy(new JsonExclusionStrategy())
                .addDeserializationExclusionStrategy(new JsonExclusionStrategy())
                .create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        */

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        /*
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpointUrl)
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
        */

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.interceptors().add(logging);


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .baseUrl(endpointUrl)
                .client(httpClient.build())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }



}