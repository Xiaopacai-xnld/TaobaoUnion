package com.example.taobaounion.ui.fragment;


import android.view.View;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.databinding.FragmentHomeBinding;
import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.presenter.impl.HomePresenterImpl;
import com.example.taobaounion.ui.adapter.HomePagerAdapter;
import com.example.taobaounion.utils.LogUtils;
import com.example.taobaounion.view.IHomeCallback;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends BaseFragment implements IHomeCallback {

    private HomePresenterImpl mHomePresenter;
    private HomePagerAdapter mhomePagerAdapter;


    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        FragmentHomeBinding binding = FragmentHomeBinding.bind(rootView);
        //给ViewPager设置适配器
        mhomePagerAdapter = new HomePagerAdapter(this);
        //设置适配器
        binding.homePager.setAdapter(mhomePagerAdapter);
        new TabLayoutMediator(binding.homeIndicator, binding.homePager,
                (tab, position) -> tab.setText(mhomePagerAdapter.getPageTitle(position))
        ).attach();
    }

    @Override
    protected void initPresenter() {
        //创建Presenter
        mHomePresenter = new HomePresenterImpl();
        mHomePresenter.registerCallback(this);
    }

    @Override
    protected void loadData() {
        //加载数据
        mHomePresenter.getCategories();
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {
        LogUtils.d(this, "onCategoriesLoaded...");
        //加载的数据就会从这里回来
        if (mhomePagerAdapter != null) {
            mhomePagerAdapter.setCategories(categories);
        }
    }

    @Override
    protected void release() {
        //取消回调注册
        if (mHomePresenter != null) {
            mHomePresenter.unregisterCallback(this);
        }
    }
}
