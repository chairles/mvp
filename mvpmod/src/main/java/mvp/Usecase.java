package mvp;

import rx.Observable;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public interface Usecase<T> {
    Observable<T> execute();
}
