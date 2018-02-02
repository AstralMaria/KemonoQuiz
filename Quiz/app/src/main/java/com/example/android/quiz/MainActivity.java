package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


        CheckBox a1 = (CheckBox) findViewById(R.id.a1);
        CheckBox b1 = (CheckBox) findViewById(R.id.b1);
        CheckBox c1 = (CheckBox) findViewById(R.id.c1);
        CheckBox a2 = (CheckBox) findViewById(R.id.a2);
        CheckBox b2 = (CheckBox) findViewById(R.id.b2);
        CheckBox c2 = (CheckBox) findViewById(R.id.c2);

        boolean a1BoolCheck = a1.isChecked();
        boolean a2BoolCheck = b1.isChecked();
        boolean a3BoolCheck = c1.isChecked();
        boolean b1BoolCheck = a2.isChecked();
        boolean b2BoolCheck = b2.isChecked();
        boolean b3BoolCheck = c2.isChecked();
        int score = calculateScore(a1BoolCheck, a2BoolCheck, a3BoolCheck, b1BoolCheck, b2BoolCheck, b3BoolCheck);
        String messageScore = createScoreSummary(score, a1BoolCheck, a2BoolCheck, a3BoolCheck, b1BoolCheck, b2BoolCheck, b3BoolCheck);
        displayMessage(messageScore);
    }

    private String createScoreSummary (int Score, boolean a1BoolCheck, boolean a2BoolCheck, boolean a3BoolCheck,
                                       boolean b1BoolCheck, boolean b2BoolCheck, boolean b3BoolCheck) {
        String goodJob = getString(R.string.goodJob);
        String scoreMessage = "\n" + getString(R.string.scoreMessage) + ": " + Score;
        return getString(R.string.scoreMessage);
    }
    private int calculateScore ( boolean a1Bool, boolean a2Bool, boolean a3Bool,
                                 boolean b1Bool, boolean b2Bool, boolean b3Bool) {
        int baseScore = 0;

        if (!a1Bool && a2Bool && !a3Bool) {
            baseScore = baseScore + 2;
        }

        else if (b1Bool && !b2Bool && !b3Bool ) {
            baseScore = baseScore +2;
        }

        else {
            baseScore = baseScore;
        }
        baseScore=baseScore;
        return baseScore;
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.scoreTextView);
        orderSummaryTextView.setText(message);
    }
}