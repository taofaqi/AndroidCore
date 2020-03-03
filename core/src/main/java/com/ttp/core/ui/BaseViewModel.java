package com.ttp.core.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author faqi.tao
 * @time 2020/1/6
 */
public class BaseViewModel<T> extends AndroidViewModel implements LifecycleOwner {

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
//        Transformations.map()
//        Transformations.switchMap()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
//        HttpTaskManager.getInstance().cancelByTarget(this);
    }
}
