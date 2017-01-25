package it.atos.pl.mvp;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import javax.inject.Inject;

import it.atos.pl.mvp.injector.component.DaggerNetComponent;
import it.atos.pl.mvp.injector.component.NetComponent;
import it.atos.pl.mvp.injector.module.NetworkModule;
import it.atos.pl.mvp.rest.ApiService;
import mvp.model.Initiative;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.observers.TestSubscriber;


/**
 * Created by Karol Maciejewski_ on 16.01.2017.
 */
public class SilniaUnitTest {


    List<Initiative> mUser;
    private ApiService apiService;

    @Inject
    Retrofit retrofit;

    @Before
    public void setupData(){


        TestNetComp netComponent = DaggerTestNetComp.builder()
                .testNetworkModule(new TestNetworkModule())
                .build();

        netComponent.inject(this);

        apiService = retrofit.create(ApiService.class);

        /*
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

    @Test
    public void testSilnia(){

        TestSubscriber<List<Initiative>> testSubscriber = new TestSubscriber<List<Initiative>>();
        apiService.getInitiatives("marco.capozzo@siemens.com","").subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

    }

}
