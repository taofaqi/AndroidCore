package com.ttp.core.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author faqi.tao
 * @time 2020/2/27
 */
public abstract class BaseFragment<T extends BaseViewModel, B extends ViewDataBinding> extends Fragment {

    protected T mViewModel;
    protected B mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isUseDataBinding()) {
            mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);  //初始化ViewDataBinding
            mBinding.setLifecycleOwner(this);   //binding添加声明周期感知
            initViewModel();
            processLogic();
            return mBinding.getRoot();
        } else {
            processLogic();
            return inflater.inflate(getLayoutRes(), container, false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected abstract int getLayoutRes();

    //初始化ViewModel
    public void initViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {  //如果没有指定泛型参数，默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (T) ViewModelProviders.of(this).get(modelClass);
        }
    }

    //处理业务逻辑
    protected abstract void processLogic();

    protected boolean isUseDataBinding() {
        return true;
    }
}
