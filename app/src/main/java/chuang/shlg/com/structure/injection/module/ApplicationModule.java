package chuang.shlg.com.structure.injection.module;

import android.content.Context;

import javax.inject.Singleton;

import chuang.shlg.com.structure.App;
import chuang.shlg.com.structure.injection.qualifier.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */
@Module
public class ApplicationModule {

    protected App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext() {
        return app;
    }
}
