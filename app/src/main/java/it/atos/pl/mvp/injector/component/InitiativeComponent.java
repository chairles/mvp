package it.atos.pl.mvp.injector.component;

import dagger.Component;
import it.atos.pl.mvp.activity.MainActivity;
import it.atos.pl.mvp.fragment.InitiativesFragment;
import it.atos.pl.mvp.injector.module.ActivityModule;
import it.atos.pl.mvp.injector.module.InitiativeModule;
import it.atos.pl.mvp.injector.module.NetworkModule;
import it.atos.pl.mvp.injector.scope.PerActivity;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {
                InitiativeModule.class,
                ActivityModule.class,
        })
public interface InitiativeComponent {

    //void inject(MainActivity mainActivity);

    void inject(InitiativesFragment initiativesFragment);

}