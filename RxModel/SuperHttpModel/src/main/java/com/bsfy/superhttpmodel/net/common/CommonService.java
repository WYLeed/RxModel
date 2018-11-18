package com.bsfy.superhttpmodel.net.common;


import io.reactivex.Observable;
import com.bsfy.superhttpmodel.net.token.RefreshTokenResponse;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by bsfy 2017/4/1.
 */

public interface CommonService {
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);

    @GET("refresh_token")
    Observable<RefreshTokenResponse> refreshToken();
}
