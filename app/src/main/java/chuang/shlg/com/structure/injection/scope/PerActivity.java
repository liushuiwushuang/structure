package chuang.shlg.com.structure.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
