package chuang.shlg.com.structure.injection.dagger;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/30.
 * @author MagicRain
 */

@Module
public class NameAnotation {

    @Named("小车")
    @Provides
    Car provideCar1(int c) {
        return new Car();
    }

    @Named("大车")
    @Provides
    Car provideCar2() {
        return new Car();
    }


}
