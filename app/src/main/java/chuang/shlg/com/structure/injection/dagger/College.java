package chuang.shlg.com.structure.injection.dagger;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/30.
 * @author MagicRain
 */

public class College {

    @Inject
    Student student;

    public College() {
        DaggerCollegeComponent.builder().build().inject(this);
    }

}
