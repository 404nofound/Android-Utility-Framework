package com.eddy.androidutilityframework.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.eddy.androidutilityframework.util.LogUtil;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCollector.addActivity(this);

        LogUtil.d("BaseActivity", getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
