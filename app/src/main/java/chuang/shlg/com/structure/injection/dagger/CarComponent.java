package chuang.shlg.com.structure.injection.dagger;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/30.
 * @author MagicRain
 */
@Component(modules = CarModule.class)
public interface CarComponent {

    void injectCar(Car car);
}
