package mvp.presenter;


import java.util.List;

import it.atos.pl.mvp.data.DataManager;

import mvp.model.News;
import mvp.view.NewsView;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by Karol Maciejewski_ on 10.01.2017.
 */
public class NewsPresenter implements MvpPresenter<NewsView> {

    private DataManager dataManager;
    private NewsView newsView;
    private Observable<List<News>> request;

    public NewsPresenter(DataManager dataManager){

        this.dataManager = dataManager;

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        newsView = null;

        
    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(NewsView v) {
        newsView = v;
        getData();
        //Log.d("view Attached","");
    }

    private void getData(){
        newsView.showLoading(true);
        //request = dataManager.getNewsFromRest().cache();

        Subscription newsSubscription = dataManager.getNewsFromRest()
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<News> newses) {
                        //Log.d("NewsPresenter", "List<News>");
                        newsView.showLoading(false);
                        //request = null;
                    }
                });

    }
}
