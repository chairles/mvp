package mvp.view;

import java.util.List;

import mvp.model.Initiative;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */

public interface InitiativeView extends View {
    void showInitiatives(List<Initiative> initiatives);
    void showLoading();
    void showError();
}
