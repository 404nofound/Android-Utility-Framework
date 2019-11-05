package com.eddy.androidutilityframework;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.eddy.androidutilityframework.model.Book;
import com.eddy.androidutilityframework.model.Person;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

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
