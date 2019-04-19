package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button btn_aboutUs,btn_game, btn_story;
    MediaPlayer mainMenuBackgroundMusic = null;

    @Override
    protected void onResume(){
        super.onResume();
        if (mainMenuBackgroundMusic != null){
            mainMenuBackgroundMusic.start();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (mainMenuBackgroundMusic != null){
            mainMenuBackgroundMusic.pause();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainMenuBackgroundMusic = MediaPlayer.create(this,R.raw.about_us_music);
        mainMenuBackgroundMusic.start();

        btn_aboutUs = (Button)findViewById(R.id.btn_aboutUs);
        btn_game = (Button)findViewById(R.id.btn_game);
        btn_story = (Button)findViewById(R.id.btn_story);

        btn_aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_aboutUs();
            }
        });

        btn_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_game();
            }
        });

        btn_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_story();
            }
        });
    }

    public void openActivity_aboutUs(){
        Intent intent = new Intent(this, AboutUsActivity.class);
        finish();
        startActivity(intent);
    }

    public void openActivity_game(){
        Intent intent = new Intent(this, GameLevel.class);
        finish();
        startActivity(intent);
    }

    public void openActivity_story(){
        Intent intent = new Intent(this, NewStoryActivity.class);
        startActivity(intent);
    }

}
