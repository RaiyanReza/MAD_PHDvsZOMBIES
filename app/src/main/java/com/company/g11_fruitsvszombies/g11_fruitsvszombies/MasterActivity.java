package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MasterActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    int touches = 0;
    float score = 0;
    float time = 0;

    public ConstraintLayout cLayout;

    MediaPlayer hitSound = null;
    MediaPlayer warningSound = null;
    MediaPlayer levelUp1 = null;
    MediaPlayer levelUp2 = null;
    MediaPlayer gameOver = null;
    MediaPlayer backgroundMusic = null;
    MediaPlayer wrongSound = null;

    List <String> list = new ArrayList<>();

    public String randomBetween() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public void yeet(int i, ImageView[] monster) {
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/"+randomBetween(), null, c.getPackageName());
        monster[i].setImageResource(id);
    }

    public float randStart() {
        Random random = new Random();
        return random.nextFloat()*400;
    }

    @Override
    protected void onPause(){
        super.onPause();
        backgroundMusic.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        backgroundMusic.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g11_game);
        cLayout = findViewById(R.id.cLayout);

        final float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        final int pixels = (int) (48 * scale + 0.5f);

        backgroundMusic = MediaPlayer.create(this,R.raw.game_background_music);
        backgroundMusic.start();

        final ImageView character = (ImageView) findViewById(R.id.character);
        final ImageView monster1 = (ImageView) findViewById(R.id.monster1);
        final ImageView monster2 = (ImageView) findViewById(R.id.monster2);
        final ImageView monster3 = (ImageView) findViewById(R.id.monster3);
        final ImageView monster4 = (ImageView) findViewById(R.id.monster4);
        final ImageView monster5 = (ImageView) findViewById(R.id.monster5);
        final ImageView[] monster = new ImageView[5];
        monster[0] = monster1;
        monster[1] = monster2;
        monster[2] = monster3;
        monster[3] = monster4;
        monster[4] = monster5;
        list.add("apple");
        list.add("pear");
        list.add("banana");

        for (int i = 0; i < 5; i++) {
            Context c = getApplicationContext();
            int id = c.getResources().getIdentifier("drawable/"+randomBetween(), null, c.getPackageName());
            monster[i].setImageResource(id);
            monster[i].setX(randStart());
        }

        final Button restart = (Button) findViewById(R.id.restartButton);
        restart.setEnabled(false);

        //character moving part
        cLayout.setOnTouchListener(
                new ConstraintLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent m){
                        float mX = m.getX();
                        if (mX > cLayout.getWidth()-character.getWidth()+pixels)
                            mX = cLayout.getWidth()-character.getWidth()+pixels;
                        character.setX(mX-pixels);
                        return true;
                    }
                });


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        monsterRelated();
                    }
                });
            }
        },0,50);
    }

    private boolean isTouching(ImageView firstView, ImageView secondView) {
        final int[] location = new int[2];

        firstView.getLocationInWindow(location);
        Rect rect1 = new Rect(location[0], location[1],location[0] + firstView.getWidth(), location[1] + firstView.getHeight());

        secondView.getLocationInWindow(location);
        Rect rect2 = new Rect(location[0], location[1],location[0] + secondView.getWidth(), location[1] + secondView.getHeight());

        return rect1.intersect(rect2);
    }

    private void monsterRelated() {
        final ImageView character = (ImageView) findViewById(R.id.character);
        final ImageView monster1 = (ImageView) findViewById(R.id.monster1);
        final ImageView monster2 = (ImageView) findViewById(R.id.monster2);
        final ImageView monster3 = (ImageView) findViewById(R.id.monster3);
        final ImageView monster4 = (ImageView) findViewById(R.id.monster4);
        final ImageView monster5 = (ImageView) findViewById(R.id.monster5);
        ImageView[] monster = new ImageView[5];
        monster[0] = monster1;
        monster[1] = monster2;
        monster[2] = monster3;
        monster[3] = monster4;
        monster[4] = monster5;


        final Button restart = (Button) findViewById(R.id.restartButton);
        final Button backToMenu = (Button) findViewById(R.id.backToMenuButton);
        final TextView scoreText = (TextView) findViewById(R.id.score);
        final TextView timeText = (TextView) findViewById(R.id.elapsedTime);
        scoreText.setVisibility(View.INVISIBLE);
        timeText.setText(String.format("Time: %.2f", time));
        time += 0.05;
        score = score+100*time;

        for(int i=0;i<5;i++) {
            float mX = monster[i].getX();
            float mY = monster[i].getY();

            Rect rcCharacter = new Rect(character.getLeft(), character.getTop(), character.getRight(), character.getBottom());
            Rect rcMonster = new Rect(monster[i].getLeft(), monster[i].getTop(), monster[i].getRight(), monster[i].getBottom());
            character.getDrawingRect(rcCharacter);
            monster[i].getDrawingRect(rcMonster);

            if (mY > findViewById(R.id.cLayout).getHeight()) {
                monster[i].setX((float) (Math.random() * (findViewById(R.id.cLayout).getWidth() - mX)));
                monster[i].setY(-10);
                yeet(i, monster);
                if(time > 59.5) {  //lose, then pop up restart button
                    timeText.setText("Time: 60");
                    timer.cancel();

                    restart.setEnabled(true);
                    restart.setVisibility(View.VISIBLE);
                    backToMenu.setEnabled(true);
                    backToMenu.setVisibility(View.VISIBLE);

                    //save highest score
                    SharedPreferences settings = getSharedPreferences("Data",MODE_PRIVATE);
                    float highScore = settings.getFloat("HighestScore",  0);
                    if (score > highScore){
                        scoreText.setText("Score:" + score +"\nHighest Score:" + score);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putFloat("HighestScore", score);
                        editor.apply();
                    }else{
                        scoreText.setText("Score:" + score + "\nHighest Score:" + highScore);
                    }
                    scoreText.setVisibility(View.VISIBLE);
                }
            } else {
                monster[i].setY(mY + 10 + time);  // speed of monsters
                if (isTouching(character, monster[i])) {    //when monster intersects with character
                    touches++;
                    yeet(i, monster);
                    hitSound = MediaPlayer.create(this,R.raw.hit_sound);
                    hitSound.setVolume(60,60);
                    hitSound.start();

                    hitSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            hitSound.release();
                        }
                    });

                    score = (score+100*time) + (touches*10);

                    if (touches%30 == 0 && touches != 0) {
                        Toast.makeText(this,"30 BOMB!",Toast.LENGTH_LONG).show();
                        levelUp1 = MediaPlayer.create(this,R.raw.level_up_1);
                        levelUp1.start();
                    }else if (touches%100 == 0 && touches != 0) {
                        Toast.makeText(this,"100 BOMB!!!",Toast.LENGTH_LONG).show();
                        levelUp2 = MediaPlayer.create(this,R.raw.level_up_2);
                        levelUp2.start();
                    }
                    monster[i].setX((float) (Math.random() * (findViewById(R.id.cLayout).getWidth() - mX)));
                    monster[i].setY(-10);
                }
            }
        }
    }


    public void gameRestart(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void backToMenu (View view){
        Intent intent = new Intent (this, MainActivity.class);
        finish();
        startActivity(intent);
    }


    @Override
    public void onBackPressed(){
        timer.cancel();
        finish();
    }

}

