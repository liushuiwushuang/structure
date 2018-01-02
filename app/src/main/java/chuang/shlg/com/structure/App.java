package chuang.shlg.com.structure;

import android.support.multidex.MultiDexApplication;

import chuang.shlg.com.structure.injection.component.ApplicationComponent;
import chuang.shlg.com.structure.injection.component.DaggerApplicationComponent;
import chuang.shlg.com.structure.injection.module.ApplicationModule;
import chuang.shlg.com.structure.injection.module.HelperModule;
import chuang.shlg.com.structure.injection.module.RemoteModule;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */

public class App extends MultiDexApplication {

    ApplicationComponent applicationComponent;

    private String baseUrl;

    @Override
    public void onCreate() {
        super.onCreate();

        injectComponent();

        initBaseUrl();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void injectComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .helperModule(new HelperModule())
                .remoteModule(new RemoteModule())
                .build();
        applicationComponent.inject(this);
    }

    private void initBaseUrl() {
        // TODO: should modify
        this.baseUrl = "http://192.168.23.1:12306/";
    }
}
