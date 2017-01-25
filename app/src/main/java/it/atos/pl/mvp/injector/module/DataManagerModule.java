package it.atos.pl.mvp.injector.module;

import dagger.Module;
import dagger.Provides;
import it.atos.pl.mvp.data.DataManager;
import it.atos.pl.mvp.injector.scope.PerApplication;
import retrofit2.Retrofit;
import rx.Scheduler;

/**
 * Created by Karol Maciejewski_ on 14.09.2016.
 */
@Module
public class DataManagerModule {

    @PerApplication
    @Provides
    public DataManager provideDataManager(Scheduler scheduler, Retrofit repository,String username) {
        return new DataManager(scheduler,repository,username);
    }
}
