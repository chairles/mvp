package it.atos.pl.mvp.injector.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import it.atos.pl.mvp.MainApplication;
import it.atos.pl.mvp.injector.scope.PerApplication;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */

@Module
public class ApplicationModule {
    private final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides
    @PerApplication
    public MainApplication provideMvpApplication() {
        return application;
    }

    @Provides
    @PerApplication
    public Application provideApplication() {
        return application;
    }

}
