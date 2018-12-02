package com.bsfy.superviewmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.trello.rxlifecycle2.components.RxDialogFragment;

/**
 * Created by wangyu on 2018/12/2 0002.
 */

public abstract class BaseFragmentDialog extends RxDialogFragment {
    protected BaseActivity baseA;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseA = (BaseActivity) getActivity();
    }

    protected View fragmentRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (null == fragmentRoot) {
            fragmentRoot = initFragmentView(inflater, container, savedInstanceState);
        }
        if (null != fragmentRoot) {
            ViewGroup parent = (ViewGroup) fragmentRoot.getParent();
            if (null != parent)
                parent.removeAllViews();
        } else {
            fragmentRoot = super.onCreateView(inflater, container, savedInstanceState);
        }
        return fragmentRoot;
    }
    public abstract View initFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
