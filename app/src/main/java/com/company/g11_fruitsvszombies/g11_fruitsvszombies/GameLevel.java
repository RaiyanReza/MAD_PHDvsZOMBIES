package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level);

    }

    public void Phd(View view) {
        Intent intent = new Intent(this,PhdGameActivity.class);
        finish();
        startActivity(intent);
    }

    public void Master(View view) {
        Intent intent = new Intent(this,MasterActivity.class);
        finish();
        startActivity(intent);
    }

    public void UnderGrad(View view) {
        Intent intent = new Intent(this,GameActivity.class);
        finish();
        startActivity(intent);
    }

    public void FreeRider(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }
}
