package it.atos.pl.mvp.network;

import java.util.ArrayList;
import java.util.List;


import mvp.model.Initiative;
import mvp.model.ResponseWrapper;
import rx.Observable;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public interface Repository {

    Observable<ResponseWrapper<List<Initiative>>> getInitiatives();

    Observable<List<Initiative>> getInitiatives(String email,String searchText);
}
