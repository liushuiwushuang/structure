package chuang.shlg.com.structure.injection.dagger;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/30.
 * @author MagicRain
 */

public class Car {

    @Inject
    Tyre tyre;

    public Car() {
        DaggerCarComponent.builder().build().injectCar(this);
    }
}
