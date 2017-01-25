package mvp.presenter;


import java.util.List;


import it.atos.pl.mvp.data.DataManager;
import mvp.model.Initiative;
import mvp.model.News;
import mvp.view.InitiativeView;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import sun.rmi.runtime.Log;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public class InitiativePresenter implements MvpPresenter<InitiativeView>{


    //private final FetchInitiativesUseCase fetchInitiativesUseCase;
    private final DataManager dataManager;
    private Subscription getInitiativesSubscription;
    private Subscription getNewsSubscription;
    private InitiativeView initiativeView;
    private int wynik=1;

   // @Inject
   // Retrofit retrofit;

    public InitiativePresenter(DataManager dataManager) {
       //his.fetchInitiativesUseCase = fetchInitiativesUseCase;
        this.dataManager = dataManager;
        //injectDependencies();
       // Log.d("silnia", String.valueOf(silnia(4)));


    }




    private void getData() {
       // retrofit.baseUrl();

        /*
        dataManager.initiativesList.subscribe(new Observer<List<Initiative>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Initiative> initiatives) {
                initiativeView.showInitiatives(initiatives);
            }
        });
        */

        /*
        getNewsSubscription = dataManager.getNewsFromRest().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<News> news) {
                        Log.d("InitPreList<News>",news.toString());
                    }
                });
*/
        getInitiativesSubscription = dataManager.getInitiativesFromRest().
                subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Initiative>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Initiative> initiatives) {
                        //g.d("InitPreList<Initiative>", initiatives.toString());
                    }
                });

        Observable<List<News>> concatenated = Observable.concat(dataManager.getNewsFromRest(), dataManager.getNewsFromRest());

        getNewsSubscription = concatenated.
                subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<News> news) {
                        //Log.d("InitPreList<news>",news.toString());

                    }
                });


        /*
        getInitiativesSubscription =dataManager.initiativesList
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Func1<Throwable, ArrayList<Initiative>>() {
                    @Override
                    public ArrayList<Initiative> call(Throwable throwable) {
                        throwable.printStackTrace();
                        return null;
                    }
                })
                .subscribe(new Observer<ArrayList<Initiative>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("on","Complete");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ArrayList<Initiative> initiatives) {

                    }
                });*/

        //dataManager.getInitiativesFromRest();
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (getInitiativesSubscription != null && !getInitiativesSubscription.isUnsubscribed()) {
            getInitiativesSubscription.unsubscribe();
        }
        if (getNewsSubscription != null && !getNewsSubscription.isUnsubscribed()) {
            getNewsSubscription.unsubscribe();
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(InitiativeView v) {
        this.initiativeView = v;
        getData();

    }
}
