package it.atos.pl.mvp.injector.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import it.atos.pl.mvp.data.DataManager;
import it.atos.pl.mvp.injector.scope.PerActivity;
import mvp.presenter.NewsPresenter;

/**
 * Created by Karol Maciejewski_ on 10.01.2017.
 */
@Module
public class NewsModule {

    @PerActivity
    @Provides
    public NewsPresenter provideNewsPresenter(DataManager dataManager) {
        return new NewsPresenter(dataManager);
    }
}
