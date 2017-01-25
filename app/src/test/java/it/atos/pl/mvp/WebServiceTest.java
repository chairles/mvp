package it.atos.pl.mvp;

import android.test.InstrumentationTestCase;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import it.atos.pl.mvp.data.DataManager;
import it.atos.pl.mvp.mvp.model.Initiative;
import it.atos.pl.mvp.rest.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.functions.Action1;
import rx.observers.TestSubscriber;

/**
 * Created by Karol Maciejewski_ on 16.01.2017.
 */

public class WebServiceTest  extends InstrumentationTestCase{


    List<Initiative> mUser;

    @Mock Retrofit retrofit;


    @Test
    public void test(){

        DataManager dm = new DataManager(retrofit,"marco.capozzo@siemens.com");

        TestSubscriber<List<Initiative>> testSubscriber = new TestSubscriber<>();
        dm.getInitiativesFromRest().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
/*
        String endpointUrl = BuildConfig.ENVIRONMENT;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .baseUrl(endpointUrl)
                .client(httpClient.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        ApiService apiService = retrofit.create(ApiService.class);
        /*
        TestSubscriber<List<Initiative>> testSubscriber = new TestSubscriber<>();
        apiService.getInitiatives("marco.capozzo@siemens.com","").subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        apiService.getInitiatives("marco.capozzo@siemens.com", "")
                 .subscribe(new Action1<List<Initiative>>() {
                     @Override
                     public void call(List<Initiative> user) {
                         mUser = user;
                     }
                 });

        assertNotNull(mUser);

*/
    }
}
