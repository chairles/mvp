package it.atos.pl.mvp.rest;

import java.util.ArrayList;
import java.util.List;


import mvp.model.Initiative;
import mvp.model.News;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public interface ApiService {

    @GET("initiatives/groups/user/{email}")
    Observable<List<Initiative>> getInitiatives(@Path("email") String email,@Query("searchText") String searchText);

    @GET("breakingNews/groups/user/{email}")
    Observable<List<News>> getNews(@Path("email") String email,@Query("searchText") String searchText);


    //@POST("calendars/{calendar_id}/events")
    //Observable<ResponseWrapper<Initiative>> postEvent(@Path("calendar_id") int calendarId, @Body Initiative event);
}
