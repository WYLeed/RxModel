package com.bsfy.superhttpmodel.net.https;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import com.bsfy.superhttpmodel.net.common.Constants;

/**
 * Created by bsfy 2018/3/21.
 */

public class SafeHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        if (Constants.IP.equals(hostname)) {//校验hostname是否正确，如果正确则建立连接
            return true;
        }
        return false;
    }
}
