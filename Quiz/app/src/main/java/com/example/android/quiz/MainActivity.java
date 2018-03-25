package com.example.android.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void calculateScore(View view) {

        //Question 1's Logic
        int question1 = 0;
        RadioButton a1 = findViewById(R.id.a1);
        RadioButton b1 = findViewById(R.id.b1);
        RadioButton c1 = findViewById(R.id.c1);

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
        RadioButton a2 = findViewById(R.id.a2);
        RadioButton b2 = findViewById(R.id.b2);
        RadioButton c2 = findViewById(R.id.c2);

        if (a2.isChecked() && !b2.isChecked() && !c2.isChecked()) {
            question2 ++;
        }
        else {
            if (question2 != 0) {
                question2--;
            }
        }

        //Question 3's Logic
        int question3 = 0;
        RadioButton a3 = findViewById(R.id.a3);
        RadioButton b3 = findViewById(R.id.b3);
        RadioButton c3 = findViewById(R.id.c3);

        if (a3.isChecked() && !b3.isChecked() && !c3.isChecked()) {
            question3 ++;
        }
        else {
            if (question3 != 0) {
                question3--;
            }
        }
//Question 4's Logic
        int question4 = 0;
        RadioButton a4 = findViewById(R.id.a4);
        RadioButton b4 = findViewById(R.id.b4);
        RadioButton c4 = findViewById(R.id.c4);

        if (!a4.isChecked() && !b4.isChecked() && c4.isChecked()) {
            question4 ++;
        }
        else {
            if (question4 != 0) {
                question4--;
            }
        }

        TextView scoreOutput = findViewById(R.id.scoreTextView);
        String messageScore = createScoreSummary(question1 + question2 + question3 + question4, scoreOutput);

    }




    private String createScoreSummary (int Score, TextView txt) {

        Context context = getApplicationContext();
        CharSequence text = getString(R.string.greatjob);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox CB1 = findViewById(R.id.checkMr);
        CheckBox CB2 = findViewById(R.id.checkMs);

        if (CB1.isChecked()) {
            name = "Mr. " + name;
        }
        if (CB2.isChecked()){
            name = "Ms. " + name;
        }

        String goodJob = getString(R.string.goodJob);
        String scoreMessage = "\n" + getString(R.string.scoreMessage) + ": " + String.valueOf(Score)
                + " out of 4! " +" " + goodJob + " " + name + "!";
        txt.setText(scoreMessage);
        return getString(R.string.scoreMessage);
    }

}