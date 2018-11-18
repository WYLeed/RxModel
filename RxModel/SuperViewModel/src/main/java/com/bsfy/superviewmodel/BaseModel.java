package com.bsfy.superviewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * Created by bsfy on 2018/11/18 0018.
 */

public class BaseModel extends AndroidViewModel {

    public BaseModel(@NonNull Application application) {
        super(application);
    }

}
