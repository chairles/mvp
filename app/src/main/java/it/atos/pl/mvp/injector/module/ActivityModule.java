package it.atos.pl.mvp.injector.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import it.atos.pl.mvp.injector.scope.PerActivity;
import mvp.presenter.MainActivityPresenter;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Context context() {
        return activity;
    }

    @PerActivity
    @Provides
    public MainActivityPresenter provideMainActivityPresenter(MainActivityPresenter usecase) {
        return new MainActivityPresenter();
    }
}