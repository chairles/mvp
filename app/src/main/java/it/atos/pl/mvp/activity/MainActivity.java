package it.atos.pl.mvp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.atos.pl.mvp.R;
import it.atos.pl.mvp.fragment.InitiativesFragment;
import it.atos.pl.mvp.fragment.NewsFragment;
import it.atos.pl.mvp.injector.component.InitiativeComponent;
import mvp.model.Initiative;
import mvp.view.InitiativeView;


public class MainActivity extends AppCompatActivity implements InitiativeView, View.OnClickListener {

   // @Inject
   // InitiativesFragment initiativesFragment;

    @Bind(R.id.fragment_holder)
    ViewGroup fragmentHolder;

    @Bind(R.id.buttonOne)
    Button buttonOne;

    @Bind(R.id.buttonTwo)
    Button buttonTwo;

    private FragmentManager fragmentManager;
    private InitiativesFragment initiativesFragment;
    private NewsFragment newsFragment;

   // private InitiativeComponent initiativeComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        ButterKnife.bind(this);
		//test1
        /*
        ApplicationComponent appComponent = ((MainApplication) getApplication()).getApplicationComponent();


        initiativeComponent = DaggerInitiativeComponent.builder()
                .initiativeModule(new InitiativeModule())
                .activityModule(new ActivityModule(this))
                .applicationComponent(appComponent)
                .build();
        initiativeComponent.inject(this);
*/
       // initializePresenter();

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        if(savedInstanceState==null) {
            buildFragment();
        }
    }

    /*private void initializePresenter(){
        initiativePresenter.attachView(this);
    }*/

    private void buildFragment(){

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(fragmentManager.findFragmentById(R.id.fragment_holder)!=null && fragmentManager.findFragmentById(R.id.fragment_holder) instanceof InitiativesFragment)
            initiativesFragment = (InitiativesFragment) fragmentManager.findFragmentById(R.id.fragment_holder);

        if(initiativesFragment == null) {
            initiativesFragment = InitiativesFragment.newInstance(1);
            fragmentTransaction.add(R.id.fragment_holder, initiativesFragment);
            fragmentTransaction.commit();
        }
    }

   // public InitiativeComponent getInitiativeComponent() {
    //    return initiativeComponent;
    //}



    @Override
    public void showInitiatives(List<Initiative> initiatives) {
        Log.d("asda11", String.valueOf(initiatives.size()));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.buttonOne:
                if(initiativesFragment==null)
                    initiativesFragment = InitiativesFragment.newInstance(1);
                fragmentTransaction.replace(R.id.fragment_holder, initiativesFragment);
                break;
            case R.id.buttonTwo:
                if(newsFragment == null) {
                    newsFragment = NewsFragment.newInstance();
                }
                fragmentTransaction.replace(R.id.fragment_holder, newsFragment);
                break;
        }


        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();


    }
}
