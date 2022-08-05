package com.example.playmeasong;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music;
    Button play,pause,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this,R.raw.sound);
        Log.d("MainActivity","Song Loaded!");
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.Stop);
        play();

    }

    public void play(){
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity","Play!");
                musicPlay();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity","Stop!");
                musicStop();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity","Pause!");
                musicPause();
            }
        });

    }




    public void musicPlay(){
        music.start();
        Log.d("MainActivity","Play");

    }

    public void musicPause(){
        music.pause();
        Log.d("MainActivity","Pause");
    }

    public void musicStop(){

        music.stop();
        music = MediaPlayer.create(this,R.raw.sound);
        Log.d("MainActivity","Stop");
    }
}