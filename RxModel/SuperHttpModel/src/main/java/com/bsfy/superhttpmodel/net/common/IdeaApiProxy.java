package com.bsfy.superhttpmodel.net.common;


import java.lang.reflect.Proxy;

import com.bsfy.superhttpmodel.net.token.IGlobalManager;
import com.bsfy.superhttpmodel.net.token.ProxyHandler;

/**
 * Created by bsfy 2017/4/1.
 */

public class IdeaApiProxy  {

    @SuppressWarnings("unchecked")
    public <T> T getApiService(Class<T> tClass, String baseUrl, IGlobalManager manager) {
        T t = RetrofitService.getRetrofitBuilder(baseUrl)
                .build().create(tClass);
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class<?>[] { tClass }, new ProxyHandler(t, manager));
    }
}
