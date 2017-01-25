package it.atos.pl.mvp;

import android.app.Application;

import it.atos.pl.mvp.injector.component.ApplicationComponent;
import it.atos.pl.mvp.injector.component.DaggerApplicationComponent;
import it.atos.pl.mvp.injector.component.NetComponent;
import it.atos.pl.mvp.injector.module.ApplicationModule;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public class MainApplication extends Application{

    private ApplicationComponent applicationComponent;
    private NetComponent netComponent;
    //private DataManagerComponent dataManagerComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupInjector();
    }

    private void setupInjector() {
        ApplicationModule applicationModule = new ApplicationModule(this);
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(applicationModule)
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }


}
