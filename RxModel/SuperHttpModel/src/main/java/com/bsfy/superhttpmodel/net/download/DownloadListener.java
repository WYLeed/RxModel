package com.bsfy.superhttpmodel.net.download;

import okhttp3.ResponseBody;

/**
 * Created by bsfy 2018/3/21.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess(ResponseBody responseBody);

    void onFail(String message);

    void onComplete();
}
