package com.bsfy.rxmodel.vm;



import dagger.Module;
import dagger.Provides;

/**
 * Created by wangyu on 2018/11/18 0018.
 */
@Module
public class MainModule{

    @Provides
    A providerA() {
        return new A();
    }
}

