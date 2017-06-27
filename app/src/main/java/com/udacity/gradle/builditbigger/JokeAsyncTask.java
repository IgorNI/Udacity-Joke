package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.ni.myapplication.backend.jokeApi.JokeApi;
import com.example.ni.myapplication.backend.jokeApi.model.MyBean;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.senthink.mylibrary.IntentExtraActivity;

import java.io.IOException;

/**
 * @Description :
 * @Author : ni
 * @Email : lifengni2015@gmail.com
 * @Date : 2017/6/27
 */

public class JokeAsyncTask extends AsyncTask<Pair<Context,String> ,Void, String> {
    public static JokeApi mApiService = null;
    private Context mContext;
    public JokeAsyncTask(Context context) {
        this.mContext = context;
    }
    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (mApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://udacity-builditbigger-1322.appspot.com/_ah/api/");
            mApiService = builder.build();
        }
        try {
            return mApiService.sendJoke(new MyBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, IntentExtraActivity.class);
        intent.putExtra(IntentExtraActivity.JOKE_KEY, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
