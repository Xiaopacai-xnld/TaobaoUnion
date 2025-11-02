package com.example.taobaounion.ui.adapter;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.ui.fragment.HomePagerFragment;
import com.example.taobaounion.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePagerAdapter extends FragmentStateAdapter {

    private List<Categories.DataBean> categoryList = new ArrayList<>();

    public HomePagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @Nullable
    public CharSequence getPageTitle(int position) {
        return categoryList.get(position).getTitle();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setCategories(Categories categories) {
        categoryList.clear();
        LogUtils.d(this, "size -- > " + categoryList.size());
        List<Categories.DataBean> data = categories.getData();
        this.categoryList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        LogUtils.d(this, "getItem -> " + position);
        Categories.DataBean dataBean = categoryList.get(position);
        HomePagerFragment homePagerFragment = HomePagerFragment.newInstance(dataBean);
        return homePagerFragment;
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
