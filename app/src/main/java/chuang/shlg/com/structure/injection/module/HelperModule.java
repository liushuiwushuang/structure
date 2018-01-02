package chuang.shlg.com.structure.injection.module;

import android.content.Context;

import javax.inject.Singleton;

import chuang.shlg.com.structure.helper.CacheHelper;
import chuang.shlg.com.structure.injection.qualifier.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */
@Module
public class HelperModule {

    @Provides
    @Singleton
    CacheHelper provideCacheHelper(@ApplicationContext Context context) {
        return new CacheHelper(context);
    }
}
