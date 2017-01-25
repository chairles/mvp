package it.atos.pl.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.atos.pl.mvp.MainApplication;
import it.atos.pl.mvp.R;
import it.atos.pl.mvp.injector.component.ApplicationComponent;
import it.atos.pl.mvp.injector.component.DaggerNewsComponent;
import it.atos.pl.mvp.injector.component.NewsComponent;
import it.atos.pl.mvp.injector.module.ActivityModule;
import it.atos.pl.mvp.injector.module.NewsModule;
import mvp.model.News;
import mvp.presenter.NewsPresenter;
import mvp.view.NewsView;


/**
 * Created by Karol Maciejewski_ on 10.01.2017.
 */
public class NewsFragment extends Fragment implements NewsView {

    private NewsComponent newsComponent;

    @Inject
    NewsPresenter newsPresenter;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onStop() {
        super.onStop();
        newsPresenter.onStop();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, root);
        newsPresenter.attachView(this);
        return root;
    }

    private  void injectDependencies() {

        ApplicationComponent appComponent = ((MainApplication) getActivity().getApplication()).getApplicationComponent();
        newsComponent = DaggerNewsComponent.builder()
                .newsModule(new NewsModule())
                .activityModule(new ActivityModule(getActivity()))
                .applicationComponent(appComponent)
                .build();
        newsComponent.inject(this);
    }

    @Override
    public void showInitiatives(List<News> initiatives) {

    }

    @Override
    public void showLoading(boolean isShow) {
        progressBar.setVisibility(isShow?View.VISIBLE:View.GONE);
    }



    @Override
    public void showError() {

    }
}
