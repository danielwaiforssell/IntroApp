package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("com.example.helloworld.SOMETHING")){
            TextView tv = (TextView) findViewById(R.id.textView2);
            String text = getIntent().getExtras().getString("com.example.helloworld.SOMETHING");
            tv.setText(text);
        }
    }
}
