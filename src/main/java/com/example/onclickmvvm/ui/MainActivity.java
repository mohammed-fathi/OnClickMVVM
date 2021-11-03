package com.example.onclickmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviderKt;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.onclickmvvm.R;

public class MainActivity extends AppCompatActivity {
    TextView movieNameTV;
    Button getMovieButton;
    MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieNameTV = findViewById(R.id.textView);
        getMovieButton = findViewById(R.id.button);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.movieNameMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                movieNameTV.setText(s);
            }
        });

        getMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieViewModel.getMovieName();

            }
        });
    }
}