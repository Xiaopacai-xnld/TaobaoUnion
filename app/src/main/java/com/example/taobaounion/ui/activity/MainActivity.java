package com.example.taobaounion.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.taobaounion.R;
import com.example.taobaounion.databinding.ActivityMainBinding;
import com.example.taobaounion.ui.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initListener();
    }

    private void initListener() {
        binding.mainNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, "title -- > " + item.getTitle() + "id -- > " + item.getItemId());
                if (item.getItemId() == R.id.home) {
                    Log.d(TAG, "切换到首页");

                } else if (item.getItemId() == R.id.selected) {
                    Log.d(TAG, "切换到精选");

                } else if (item.getItemId() == R.id.red_packet) {
                    Log.d(TAG, "切换到特惠");

                } else if (item.getItemId() == R.id.search) {
                    Log.d(TAG, "切换到搜索");

                }
                return true;
            }
        });
    }

    private void initView() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(binding.mainPageContainer.getId(), homeFragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy----- ");
        super.onDestroy();

        binding = null;
    }
}