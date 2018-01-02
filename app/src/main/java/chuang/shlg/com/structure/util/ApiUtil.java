package chuang.shlg.com.structure.util;

import chuang.shlg.com.structure.remote.Result;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */
public class ApiUtil {

//    public static <E> Observable<E> invokeAsync(Observable<Result> apiObservable, final Class<E> clazz, final String key) {
//        return apiObservable.observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .map(new Func1<Result, E>() {
//
//                    @Override
//                    public E call(Result result) {
//                        if (result.isValid()) {
//                            return result.getData().getObject(key, clazz);
//                        } else {
//                            throw new RuntimeException(result.getMessage());
//                        }
//                    }
//                });
//    }

    public static <E> Observable<E> invokeAsync(Observable<E> apiObservable) {
        return apiObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
