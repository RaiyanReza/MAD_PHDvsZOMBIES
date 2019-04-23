package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewStoryActivity extends AppCompatActivity {
    int buttonClickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_story);
        final TextView storyTextView = findViewById(R.id.storyTextView);
        final Button continueButton = findViewById(R.id.storyContinueButton);
        storyTextView.setText("You’re a PhD farmer living in a post-apocalyptic world, where majority of life on earth has been wiped out or turned into zombies from the outbreak of the L-virus. \n" +
                "\n" +
                "With no livestock or game for you to kill for food, the only source of nutrients you can rely on are fruits. \n" +
                "\n" +
                "As the man of the family, it is your job to venture into the woods daily to scavenge for fruits and bring them home for your family so that they can survive the day.\n");

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView storyView = findViewById(R.id.storyTextView);
                Button continueBut = findViewById(R.id.storyContinueButton);
                if(buttonClickCount == 0){
                    //Second slide of the story page
                    buttonClickCount++;
                    storyView.setText("Use your fingers to slide the basket so that you are able to catch the fruits before they fall onto the ground. " +
                            "Since food is scarce, try not to drop too many fruits. If you do, " +
                            "you may not have enough food for your whole family.\"");
                }else if(buttonClickCount == 1){
                    //Last story page
                    buttonClickCount++;
                    storyView.setText("But be aware, not all fruits are safe to eat. Some fruits have been infected by the living dead. Unless you have a death wish for you or your family, " +
                            "it is best if you avoid these contaminated fruits. If any of these infected fruits come into contact with the fresh fruits you have scavenged, " +
                            "your whole basket will become contaminated and inedible.\n" +
                            "\n" +
                            "Contaminated fruits will be distinguished from the fresh fruits by the mouldy and rotten patches visible on them.\n" +
                            "\n" +
                            "You have been warned.\n");
                    continueBut.setText("START THE GAME!");
                    continueBut.setTextSize(30);
                }else{
                    //Start the game
                    Intent startGame = new Intent (NewStoryActivity.this, GameActivity.class);
                    finish();
                    startActivity(startGame);
                }
            }
        });
    }
}