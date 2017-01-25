package it.atos.pl.mvp.data;

import java.util.ArrayList;
import java.util.List;

import it.atos.pl.mvp.rest.ApiService;
import mvp.model.Initiative;
import mvp.model.News;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.subjects.PublishSubject;

/**
 * Created by Karol Maciejewski_ on 14.09.2016.
 */
public class DataManager {

    private final String username;
    private final ApiService apiService;

    public Scheduler getScheduler() {
        return scheduler;
    }

    private final Scheduler scheduler;
    private Retrofit repository;
    private Subscription getInitiativesSubscription;

    public PublishSubject<List<Initiative>> initiativesList;

    public List requests = new ArrayList();

    public DataManager(Scheduler scheduler,Retrofit repository,String username){
        this.repository = repository;
        this.scheduler = scheduler;
        this.username = username;
        apiService = repository.create(ApiService.class);

        initiativesList = PublishSubject.create();
    }


    public Observable<List<Initiative>> getInitiativesFromRest(){


        /*
        getInitiativesSubscription = apiService.getInitiatives(username,"")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<List<Initiative>, ArrayList<Initiative>>() {
                    @Override
                    public ArrayList<Initiative> call(List<Initiative> initiatives) {
                        return new ArrayList<>(initiatives);
                    }
                }).subscribe(new Action1<ArrayList<Initiative>>() {
                    @Override
                    public void call(ArrayList<Initiative> initiatives) {;
                        Log.d("asdas",String.valueOf(initiatives.size()));
                        initiativesList.onNext(initiatives);
                    }
                });*/
        return apiService.getInitiatives(username,"");

    }

    public Observable<List<News>> getNewsFromRest(){

        return apiService.getNews(username,"").observeOn(scheduler);

    }

}
