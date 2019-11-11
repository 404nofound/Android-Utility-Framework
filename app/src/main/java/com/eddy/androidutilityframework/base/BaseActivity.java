package com.eddy.androidutilityframework.base;

import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eddy.androidutilityframework.broadcast.MyBroadcastReceiver;
import com.eddy.androidutilityframework.util.LogUtil;

abstract public class BaseActivity extends AppCompatActivity implements
        MyBroadcastReceiver.Event {

    public MyBroadcastReceiver broadcastReceiver;
    public static MyBroadcastReceiver.Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCollector.addActivity(this);

        LogUtil.d("BaseActivity", getClass().getSimpleName());

        event = this;
        broadcastReceiver = new MyBroadcastReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction(LocationManager.PROVIDERS_CHANGED_ACTION);
        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);

        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override
    public void onNetChange(int netMobile) {
        //MyApplication.NET_STATUS = netMobile;
        Toast.makeText(this, "NET: " + netMobile, Toast.LENGTH_SHORT).show();
        LogUtil.d("BaseActivity", "NET: "+netMobile);
    }

    @Override
    public void onGpsChange(boolean is_gps_enabled) {
        //MyApplication.GPS_ENABLED = is_gps_enabled;
        Toast.makeText(this, "GPS: " + is_gps_enabled, Toast.LENGTH_SHORT).show();
        LogUtil.d("BaseActivity", "GPS: "+is_gps_enabled);
    }
}
