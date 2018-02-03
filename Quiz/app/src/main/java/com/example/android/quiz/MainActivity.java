package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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

        //Question 3's Logic
        int question3 = 0;
        CheckBox a3 = (CheckBox) findViewById(R.id.a3);
        CheckBox b3 = (CheckBox) findViewById(R.id.b3);
        CheckBox c3 = (CheckBox) findViewById(R.id.c3);

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
        CheckBox a4 = (CheckBox) findViewById(R.id.a4);
        CheckBox b4 = (CheckBox) findViewById(R.id.b4);
        CheckBox c4 = (CheckBox) findViewById(R.id.c4);

        if (!a4.isChecked() && !b4.isChecked() && c4.isChecked()) {
            question4 ++;
        }
        else {
            if (question4 != 0) {
                question4--;
            }
        }
        //To add more Checkboxes you can copy the above blocks of code and link new id's of new checkboxes
        //Then just sum them up in the score argument below
        //Radio Buttons Logic

        TextView scoreOutput = findViewById(R.id.scoreTextView);
        String messageScore = createScoreSummary(question1 + question2 + question3 + question4, scoreOutput);

    }




    private String createScoreSummary (int Score, TextView txt) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        RadioButton rB1 = findViewById(R.id.radioMr);
        RadioButton rB2 = findViewById(R.id.radioMs);

        if (rB1.isChecked()) {
            name = "Mr. " + name;
        }
        if (rB2.isChecked()){
            name = "Ms. " + name;
        }

        String goodJob = getString(R.string.goodJob);
        String scoreMessage = "\n" + getString(R.string.scoreMessage) + ": " + String.valueOf(Score)
                + " out of 4! " +" " + goodJob + " " + name + "!";
        txt.setText(scoreMessage);
        return getString(R.string.scoreMessage);
    }

}