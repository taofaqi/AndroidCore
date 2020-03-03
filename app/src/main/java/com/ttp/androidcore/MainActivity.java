package com.ttp.androidcore;

import android.os.Bundle;

import com.ttp.androidcore.databinding.ActivityMainBinding;
import com.ttp.core.ui.BaseActivity;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void processLogic() {

    }
}
