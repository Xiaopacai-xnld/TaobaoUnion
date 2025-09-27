package com.example.taobaounion.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.databinding.ActivityMainBinding;
import com.example.taobaounion.ui.fragment.HomeFragment;
import com.example.taobaounion.ui.fragment.RedPacketFragment;
import com.example.taobaounion.ui.fragment.SearchFragment;
import com.example.taobaounion.ui.fragment.SelectedFragment;
import com.example.taobaounion.utils.LogUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HomeFragment mhomeFragment;
    private RedPacketFragment mredPacketFragment;
    private SearchFragment msearchFragment;
    private SelectedFragment mselectedFragment;
    private FragmentManager mfm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initFragments();
        initListener();
    }

    private void initFragments() {
        mhomeFragment = new HomeFragment();
        mredPacketFragment = new RedPacketFragment();
        msearchFragment = new SearchFragment();
        mselectedFragment = new SelectedFragment();
        mfm = getSupportFragmentManager();
        switchFragment(mhomeFragment);
    }

    private void initListener() {
        binding.mainNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d(TAG, "title -- > " + item.getTitle() + "id -- > " + item.getItemId());
                if (item.getItemId() == R.id.home) {
                    LogUtils.d(MainActivity.class, "切换到首页");
                    switchFragment(mhomeFragment);
                } else if (item.getItemId() == R.id.selected) {
                    LogUtils.d(MainActivity.class, "切换到精选");
                    switchFragment(mselectedFragment);
                } else if (item.getItemId() == R.id.red_packet) {
                    LogUtils.d(MainActivity.class, "切换到特惠");
                    switchFragment(mredPacketFragment);
                } else if (item.getItemId() == R.id.search) {
                    LogUtils.d(MainActivity.class, "切换到搜索");
                    switchFragment(msearchFragment);
                }
                return true;
            }
        });
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentTransaction fragmentTransaction = mfm.beginTransaction();
        fragmentTransaction.replace(binding.mainPageContainer.getId(), targetFragment);
        fragmentTransaction.commit();
    }


    @Override
    protected void onDestroy() {
        LogUtils.d(MainActivity.class, "onDestroy----- ");
        super.onDestroy();

        binding = null;
    }
}