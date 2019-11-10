package com.eddy.androidutilityframework;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.eddy.androidutilityframework.base.ActivityCollector;
import com.eddy.androidutilityframework.base.BaseActivity;
import com.eddy.androidutilityframework.model.Book;
import com.eddy.androidutilityframework.model.Person;
import com.eddy.androidutilityframework.util.HttpUtil;
import com.eddy.androidutilityframework.util.LogUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends BaseActivity {

    private Button serializable, parceable, finish;
    private TextView httpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        serializable = findViewById(R.id.serializable);
        parceable = findViewById(R.id.parcelable);
        finish = findViewById(R.id.finish);
        httpView = findViewById(R.id.http_text);

        serializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setName("Tom");
                person.setAge(24);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data1", person);

                startActivity(intent);
            }
        });

        parceable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("US History");
                book.setAuthor("Tom Max");

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data2", book);

                startActivity(intent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        Toast.makeText(MyApplication.getContext(), "Got Application Context", Toast.LENGTH_LONG).show();

        LogUtil.d("TAG", "Log Util");

        requestAlert();
    }

    private void requestAlert() {

        String url = "https://api-v3.mbta.com/alerts?filter[route_type]=0,1&sort=lifecycle";

        HttpUtil.sendOkHttpGetRequest(url, new Callback() {
            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                final String info = response.body().string().trim();

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        httpView.setText(info);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyApplication.getContext(), "Internet Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
