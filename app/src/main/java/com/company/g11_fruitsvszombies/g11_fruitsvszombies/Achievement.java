package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Achievement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        int firstDead = 1;
        int unlock_dominic = 1;

        TextView textView = (TextView) findViewById(R.id.first_time_dead);
        TextView textView1 =(TextView) findViewById(R.id.Unlocked_Dominique);

        SharedPreferences setting = getSharedPreferences("Data",MODE_PRIVATE);


        firstDead = setting.getInt("FirstDead",0);
        unlock_dominic = setting.getInt("LordDominic",0);

        if(firstDead == 10)
            textView.setText("Your first time dead");

        if(unlock_dominic == 12)
            textView1.setText("Dominic Award");


    }
}
