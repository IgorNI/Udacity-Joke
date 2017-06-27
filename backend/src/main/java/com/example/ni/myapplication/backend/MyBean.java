package com.example.ni.myapplication.backend;

import com.example.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    public String getJoke() {
        return Joke.getRandomJoke();
    }
}