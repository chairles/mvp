package it.atos.pl.mvp.rest;

import java.util.ArrayList;
import java.util.List;


import it.atos.pl.mvp.network.Repository;
import mvp.model.Initiative;
import mvp.model.ResponseWrapper;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public class RetrofitRestRepository implements Repository{

    private ApiService apiService;

    public RetrofitRestRepository(Retrofit retrofit) {
        apiService = retrofit.create(ApiService.class);
    }

    @Override
    public Observable<List<Initiative>> getInitiatives(String email,String searchText) {
        return apiService.getInitiatives(email,searchText);
    }

    @Override
    public Observable<ResponseWrapper<List<Initiative>>> getInitiatives() {
        return null;
    }
}
