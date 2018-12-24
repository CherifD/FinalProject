package com.cherifcodes.androidjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private static final String JOKE_KEY = "joke key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = findViewById(R.id.tv_joke);
        String joke = getIntent().getStringExtra(JOKE_KEY);
        jokeTextView.setText(joke);
    }
}
