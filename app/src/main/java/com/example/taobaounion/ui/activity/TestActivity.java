package com.example.taobaounion.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taobaounion.R;
import com.example.taobaounion.databinding.ActivityTestBinding;
import com.example.taobaounion.utils.LogUtils;

public class TestActivity extends Activity {

    private @NonNull ActivityTestBinding mBinding;
    public RadioGroup navigationBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        initListener();
    }

    private void initListener() {
        mBinding.testNavigationBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int checkedId) {
//                LogUtils.d(TestActivity.class, "checkedId -- > " + checkedId);
                if (checkedId == R.id.test_home) {
                    LogUtils.d(TestActivity.class, "切换到首页");
                } else if (checkedId == R.id.test_selected) {
                    LogUtils.d(TestActivity.class, "切换到精选");
                } else if (checkedId == R.id.test_red_packet) {
                    LogUtils.d(TestActivity.class, "切换到特惠");
                } else if (checkedId == R.id.test_search) {
                    LogUtils.d(TestActivity.class, "切换到搜索");
                }
            }
        });
    }
}
