package it.atos.pl.mvp.injector.component;

import dagger.Component;
import it.atos.pl.mvp.injector.module.NetworkModule;
import it.atos.pl.mvp.injector.scope.PerApplication;


/**
 * Created by Karol Maciejewski_ on 24.08.2016.
 */
@PerApplication
@Component(modules = {
        NetworkModule.class

}
)
public interface NetComponent {
    //void inject(InitiativePresenter initiativePresenter);

}
