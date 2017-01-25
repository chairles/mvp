package it.atos.pl.mvp.injector.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import it.atos.pl.mvp.BuildConfig;
import it.atos.pl.mvp.injector.scope.PerApplication;

/**
 * Created by Karol Maciejewski_ on 24.08.2016.
 */
@Module
public class ConfigurationModule {

    @Provides
    @PerApplication
    String provideUserName() {
        return "marco.capozzo@siemens.com";
    }


}
