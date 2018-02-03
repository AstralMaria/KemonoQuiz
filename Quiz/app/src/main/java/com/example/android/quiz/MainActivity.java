package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculateScore(View view) {
        //There's no need to assign new Booleans to the states of the checkboxes;
        //We can use them as arguments for if statements, since their datatype defaults to bool

        //Question 1's Logic
        int question1 = 0;
        CheckBox a1 = (CheckBox) findViewById(R.id.a1);
        CheckBox b1 = (CheckBox) findViewById(R.id.b1);
        CheckBox c1 = (CheckBox) findViewById(R.id.c1);

        if (b1.isChecked() && !a1.isChecked() && !c1.isChecked()) {
            question1 ++;
        }
        else {
            if (question1 !=0){
                question1 --;
            }
        }

        //Question 2's Logic
        int question2 = 0;
        CheckBox a2 = (CheckBox) findViewById(R.id.a2);
        CheckBox b2 = (CheckBox) findViewById(R.id.b2);
        CheckBox c2 = (CheckBox) findViewById(R.id.c2);

        if (a2.isChecked() && !b2.isChecked() && !c2.isChecked()) {
            question2 ++;
        }
        else {
            if (question2 != 0) {
                question2--;
            }
        }

        //To add more Checkboxes you can copy the above blocks of code and link new id's of new checkboxes
        //Then just sum them up in the score argument below

        TextView scoreOutput = findViewById(R.id.scoreTextView);
        String messageScore = createScoreSummary(question1 + question2, scoreOutput);

    }

    private String createScoreSummary (int Score, TextView txt) {
        String goodJob = getString(R.string.goodJob);
        String scoreMessage = "\n" + getString(R.string.scoreMessage) + ": " + String.valueOf(Score);
        txt.setText(scoreMessage);
        return getString(R.string.scoreMessage);
    }

}