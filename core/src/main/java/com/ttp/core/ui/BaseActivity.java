package com.ttp.core.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author faqi.tao
 * @time 2020/1/6
 */
public abstract class BaseActivity<T extends BaseViewModel, B extends ViewDataBinding> extends AppCompatActivity {

    protected T mViewModel;
    protected B mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isUseDataBinding()) {
            mBinding = DataBindingUtil.setContentView(this, getLayoutRes());  //初始化ViewDataBinding
            mBinding.setLifecycleOwner(this);   //binding添加声明周期感知
            initViewModel();
        } else {
            setContentView(getLayoutRes());
        }

        processLogic();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //初始化ViewModel
    public void initViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (T) ViewModelProviders.of(this).get(modelClass);
        }
    }

    //获取当前Activity的布局文件，并初始化Binding
    protected abstract int getLayoutRes();

    //处理业务逻辑
    protected abstract void processLogic();

    protected boolean isUseDataBinding() {
        return true;
    }
}