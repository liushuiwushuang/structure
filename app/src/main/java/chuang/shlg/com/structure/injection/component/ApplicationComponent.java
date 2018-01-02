package chuang.shlg.com.structure.injection.component;

import javax.inject.Singleton;

import chuang.shlg.com.structure.App;
import chuang.shlg.com.structure.injection.module.ApplicationModule;
import chuang.shlg.com.structure.injection.module.HelperModule;
import chuang.shlg.com.structure.injection.module.RemoteModule;
import dagger.Component;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */
@Singleton
@Component(modules = { ApplicationModule.class, HelperModule.class, RemoteModule.class})
public interface ApplicationComponent {

    void inject(App app);

    ActivityComponent newActivityComponent();

}
