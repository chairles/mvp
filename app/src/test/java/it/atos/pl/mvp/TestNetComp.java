package it.atos.pl.mvp;

import dagger.Component;
import it.atos.pl.mvp.injector.component.NetComponent;
import it.atos.pl.mvp.injector.scope.PerApplication;

/**
 * Created by Karol Maciejewski_ on 17.01.2017.
 */
@PerApplication
@Component(modules = TestNetworkModule.class)
public interface TestNetComp extends NetComponent{
    void inject(SilniaUnitTest test);
}
