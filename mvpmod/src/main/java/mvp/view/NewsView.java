package mvp.view;

import java.util.List;

import mvp.model.News;


/**
 * Created by Karol Maciejewski_ on 10.01.2017.
 */
public interface NewsView extends View {

    void showInitiatives(List<News> news);
    void showLoading(boolean isShow);
    void showError();
}
