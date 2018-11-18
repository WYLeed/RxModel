package com.bsfy.rxmodel.vm;

import com.bsfy.rxmodel.MainActivity;

import dagger.Component;

/**
 * Created by wangyu on 2018/11/18 0018.
 */
@Component(modules = {MainModule.class})
public interface  MainComponent {

    void inject(MainActivity activity);

}
