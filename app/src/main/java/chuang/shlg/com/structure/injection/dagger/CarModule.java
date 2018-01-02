package chuang.shlg.com.structure.injection.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/30.
 * @author MagicRain
 */

@Module
public class CarModule {

    @Provides
    static Car provideCar() {
        return new Car();
    }
}
