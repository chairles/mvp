package it.atos.pl.mvp.injector.component;

import dagger.Component;
import it.atos.pl.mvp.fragment.NewsFragment;
import it.atos.pl.mvp.injector.module.ActivityModule;
import it.atos.pl.mvp.injector.module.NetworkModule;
import it.atos.pl.mvp.injector.module.NewsModule;
import it.atos.pl.mvp.injector.scope.PerActivity;

/**
 * Created by Karol Maciejewski_ on 10.01.2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {
                NewsModule.class,
                ActivityModule.class,
        })

public interface NewsComponent {
    void inject(NewsFragment newsFragment);
}