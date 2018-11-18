package com.bsfy.superhttpmodel.net.converter;

import com.google.gson.TypeAdapter;

import java.io.IOException;

import com.bsfy.superhttpmodel.net.common.BasicResponse;
import com.bsfy.superhttpmodel.net.common.ErrorCode;
import com.bsfy.superhttpmodel.net.exception.ServerResponseException;
import com.bsfy.superhttpmodel.net.exception.TokenInvalidException;
import com.bsfy.superhttpmodel.net.exception.TokenNotExistException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, Object> {

    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object convert(ResponseBody value) throws IOException {
        try {
            BasicResponse response = (BasicResponse) adapter.fromJson(value.charStream());
            if (response.getCode() == ErrorCode.TOKEN_NOT_EXIST) {
                throw new TokenNotExistException();
            } else if (response.getCode() == ErrorCode.TOKEN_INVALID) {
                throw new TokenInvalidException();
            } else if (response.isError()) {
                // 特定 API 的错误，在相应的 Subscriber 的 onError 的方法中进行处理
                throw new ServerResponseException(response.getCode(),response.getMessage());
            } else if (!response.isError()) {
                return response.getResults();
            }
        } finally {
            value.close();
        }
        return null;
    }
}
