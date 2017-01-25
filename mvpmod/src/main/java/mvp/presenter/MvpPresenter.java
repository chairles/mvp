package mvp.presenter;


import mvp.view.View;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public interface MvpPresenter<T extends View> {

    void onCreate();
    void onStart();
    void onStop();
    void onPause();
    void attachView(T v);

}
