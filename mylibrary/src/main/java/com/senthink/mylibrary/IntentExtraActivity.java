package com.senthink.mylibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * @Description :
 * @Author : ni
 * @Email : lifengni2015@gmail.com
 * @Date : 2017/6/26
 */

public class IntentExtraActivity extends Activity {
    public static final String JOKE_KEY = "joke_key";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_view);
        String joke = getIntent().getStringExtra(JOKE_KEY);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_view);
        jokeTextView.setText(joke);
    }
}
