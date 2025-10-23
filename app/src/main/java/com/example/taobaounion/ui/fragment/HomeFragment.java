package com.example.taobaounion.ui.fragment;


import android.view.View;
import android.widget.TableLayout;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.presenter.impl.HomePresenterImpl;
import com.example.taobaounion.view.IHomeCallback;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeCallback {

    @BindView(R.id.home_indicator)
    private TableLayout mTableLayout;
    private HomePresenterImpl mHomePresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        mTableLayout.setupWithViewPager();
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
        //加载的数据就会从这里回来

    }

    @Override
    protected void release() {
        //取消回调注册
        if (mHomePresenter != null) {
            mHomePresenter.unregisterCallback(this);
        }
    }
}
