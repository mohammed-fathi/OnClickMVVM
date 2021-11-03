package com.example.onclickmvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onclickmvvm.pojo.MovieModle;

public class MovieViewModel extends ViewModel {
    MutableLiveData<String> movieNameMutableLiveData = new MutableLiveData<>();

    private MovieModle getMovieFromDatabase(){
        return new MovieModle("Avatar", "2010" , "I love it" , 10);
    }

    public void getMovieName(){
        String movieName = getMovieFromDatabase().getName();
        movieNameMutableLiveData.setValue(movieName);
    }


}
