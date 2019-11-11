package com.eddy.androidutilityframework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.eddy.androidutilityframework.base.BaseActivity;
import com.eddy.androidutilityframework.model.Book;
import com.eddy.androidutilityframework.model.Person;

public class SecondActivity extends BaseActivity {

    private TextView textView;

    public static void actionStart(Context context, Book data) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param", data);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);

        Person person = (Person) getIntent().getSerializableExtra("data1");

        Book book = (Book) getIntent().getParcelableExtra("data2");

        if (person != null) {
            textView.setText(person.getName() + ", " + person.getAge());
        }

        if (book != null) {
            textView.setText(book.getName() + ", " + book.getAuthor());
        }
    }
}
