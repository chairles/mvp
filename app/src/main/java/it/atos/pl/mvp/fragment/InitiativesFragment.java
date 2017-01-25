package it.atos.pl.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.atos.pl.mvp.MainApplication;
import it.atos.pl.mvp.R;
import it.atos.pl.mvp.activity.MainActivity;
import it.atos.pl.mvp.helper.RxHelper;
import it.atos.pl.mvp.injector.component.ApplicationComponent;
import it.atos.pl.mvp.injector.component.DaggerInitiativeComponent;
import it.atos.pl.mvp.injector.component.InitiativeComponent;
import it.atos.pl.mvp.injector.module.ActivityModule;
import it.atos.pl.mvp.injector.module.InitiativeModule;
import mvp.model.Initiative;
import mvp.presenter.InitiativePresenter;
import mvp.view.InitiativeView;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public class InitiativesFragment extends Fragment implements InitiativeView {


    private static final String KEY_ROOM_ID = "key_room_id";

    @Inject
    InitiativePresenter initiativePresenter;

    @Bind(R.id.mainText)
    TextView title;
    @Bind(R.id.inputTextOne)
    EditText inputTextOne;
    @Bind(R.id.inputTextTwo)
    EditText inputTextTwo;

    @Bind(R.id.mainButton)
    Button mainButton;


    private int roomId;
    private InitiativeComponent initiativeComponent;

    public static InitiativesFragment newInstance(int roomId) {
        InitiativesFragment initiativesFragment = new InitiativesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ROOM_ID, roomId);
        initiativesFragment.setArguments(bundle);
        return initiativesFragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_ROOM_ID, roomId);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();



    }

    private void initEvents() {
        initiativePresenter.attachView(this);
        //eventsCollectionPresenter.setCalendarId(roomId);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_initiatives, container, false);
        ButterKnife.bind(this, root);
        //initAdapter();
        //initList();


        if (savedInstanceState != null) {
            roomId = savedInstanceState.getInt(KEY_ROOM_ID);
        } else {
            roomId = getArguments().getInt(KEY_ROOM_ID);
        }
        initEvents();
        setupRx();
        return root;
    }

    private void setupRx(){
        /*
        Observable<String> valueOneObservable = RxHelper.getTextWatcherObservable(inputTextOne);
        Observable<String> valueTwoObservable = RxHelper.getTextWatcherObservable(inputTextTwo);

        Subscription valueSubscription = Observable.combineLatest(valueOneObservable, valueTwoObservable, new Func2<String, String, Boolean>() {
            @Override
            public Boolean call(String s, String s2) {
                return false;
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                Log.i("aaa", "submit button enabled: " + aBoolean);
            }
        });*/
        mainButton.setEnabled(false);
        Observable<Boolean> valueOneObservable = validationResult(inputTextOne);

        Observable<Boolean> valueTwoObservable = RxHelper.getTextWatcherObservable(inputTextTwo)
                .debounce(800, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        Boolean result = StringUtils.isNotBlank(s)?true:false;
                        //Log.i(TAG, "validate email: " + s);
                        //ValidationResult result = validateEmail(s);
                        //emailView.setError(result.getReason());
                        return result;
                    }
                });

        Subscription valueSubscription = Observable.combineLatest(valueOneObservable, valueTwoObservable, new Func2<Boolean, Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean s, Boolean s2) {
                return s&&s2;
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                Log.i("aaa", "submit button enabled: " + aBoolean);
                mainButton.setEnabled(aBoolean);
            }
        });

    }

    private Observable<Boolean> validationResult(EditText input){

        return RxHelper.getTextWatcherObservable(input)
                .debounce(800, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        Boolean result = StringUtils.isNotBlank(s)?true:false;
                        //Log.i(TAG, "validate email: " + s);
                        //ValidationResult result = validateEmail(s);
                        //emailView.setError(result.getReason());
                        return result;
                    }
                });
    }

    private  void injectDependencies() {
        /*
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            InitiativeComponent initiativeComponent = activity.getInitiativeComponent();
            initiativeComponent.inject(this);
        }*/

        ApplicationComponent appComponent = ((MainApplication) getActivity().getApplication()).getApplicationComponent();
        initiativeComponent = DaggerInitiativeComponent.builder()
                .initiativeModule(new InitiativeModule())
                .activityModule(new ActivityModule(getActivity()))
                .applicationComponent(appComponent)
                .build();
        initiativeComponent.inject(this);
    }

    @OnClick(R.id.mainButton)
    public void action() {
        title.setText(inputTextOne.getText().toString());
    }

    @Override
    public void showInitiatives(List<Initiative> initiatives) {
        Log.d("asda",String.valueOf(initiatives.size()));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onStop() {
        super.onStop();
        initiativePresenter.onStop();

    }
}
