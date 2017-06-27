package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import junit.framework.TestSuite;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.assertNotNull;

/**
 * @Description :
 * @Author : ni
 * @Email : lifengni2015@gmail.com
 * @Date : 2017/6/27
 */

@RunWith(AndroidJUnit4.class)
public class CloudModuleTest extends TestSuite{

    @Test
    public void runCloudModuleTest() {
        String joke = null;
        JokeAsyncTask jokesAsyncTask = new JokeAsyncTask(getContext());
        jokesAsyncTask.execute();
        try {
            joke = jokesAsyncTask.get();
            Log.d("CloudModuleTest", "Retrieved a non-empty string successfully: " + joke);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(joke);
    }
}
