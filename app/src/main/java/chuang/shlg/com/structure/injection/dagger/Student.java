package chuang.shlg.com.structure.injection.dagger;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/30.
 * @author MagicRain
 */

public class Student {

    private int id;

    private String name;

    @Inject  // @Inject说明Student 通过这个构造函数完成对象的创建
    public Student() {
        System.out.println("Imooc student create");
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
