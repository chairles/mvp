package it.atos.pl.mvp.injector.module;

import dagger.Module;
import dagger.Provides;
import it.atos.pl.mvp.data.DataManager;
import it.atos.pl.mvp.fragment.InitiativesFragment;
import it.atos.pl.mvp.injector.scope.PerActivity;
import mvp.presenter.InitiativePresenter;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */

@Module
public class InitiativeModule {

    /*
    @PerActivity
    @Provides
    public InitiativesFragment provideInitiativesFragment(InitiativePresenter initiativePresenter) {
        return new InitiativesFragment();
    }*/

    @PerActivity
    @Provides
    public InitiativePresenter provideInitiativesPresenter(DataManager dataManager) {
        return new InitiativePresenter(dataManager);
    }
}
