package mvp.view;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public interface MvpView extends View{

    void showLoading();
    void presentData(Object data);
    void showError(Exception e);
}
