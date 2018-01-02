package chuang.shlg.com.structure.injection.component;

import chuang.shlg.com.structure.ui.MainActivity;
import chuang.shlg.com.structure.injection.module.ActivityModule;
import chuang.shlg.com.structure.injection.scope.PerActivity;
import dagger.Subcomponent;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
