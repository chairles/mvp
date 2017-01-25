package it.atos.pl.mvp.injector.component;

import android.app.Application;

import dagger.Component;
import it.atos.pl.mvp.MainApplication;
import it.atos.pl.mvp.data.DataManager;
import it.atos.pl.mvp.injector.module.ApplicationModule;
import it.atos.pl.mvp.injector.module.ConfigurationModule;
import it.atos.pl.mvp.injector.module.DataManagerModule;
import it.atos.pl.mvp.injector.module.NetworkModule;
import it.atos.pl.mvp.injector.scope.PerApplication;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
@PerApplication
@Component(modules = {ApplicationModule.class,
        NetworkModule.class,
        DataManagerModule.class,
        ConfigurationModule.class
}
)
public interface ApplicationComponent {

    Application application();

    MainApplication mainApplication();

    DataManager dataManager();


}