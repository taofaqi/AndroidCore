package com.ttp.androidcore.lifecycle;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/**
 * @author faqi.tao
 * @time 2020/3/3
 */
public class MyObserver implements DefaultLifecycleObserver {

    public static final String TAG = "MyObserver";
    private Lifecycle lifecycle;

    public MyObserver(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onCreate()");
        Log.d(TAG, "当前生命周期状态=" + lifecycle.getCurrentState().name());
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onStart()");
        Log.d(TAG, "当前生命周期状态=" + lifecycle.getCurrentState().name());
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onResume()");
        Log.d(TAG, "当前生命周期状态=" + lifecycle.getCurrentState().name());

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onPause()");
        Log.d(TAG, "当前生命周期状态=" + lifecycle.getCurrentState().name());
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onStop()");
        Log.d(TAG, "当前生命周期状态=" + lifecycle.getCurrentState().name());
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onDestroy() ");
        Log.d(TAG, "当前生命周期状态=" + lifecycle.getCurrentState().name());
    }
}