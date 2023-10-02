package com.example.pr12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private int num_input;
    private int randomNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editTextNumber);
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNumber();
            }
        });
    }

    private void checkNumber() {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Input Field must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        num_input = Integer.parseInt(editText.getText().toString());
        if (num_input < randomNumber) {
            Toast.makeText(this, "Number is higher", Toast.LENGTH_SHORT).show();
        } else if (num_input > randomNumber) {
            Toast.makeText(this, "Number is lower", Toast.LENGTH_SHORT).show();
        } else if (num_input == randomNumber) {
            correctAnswer();
        }
    }


    private void correctAnswer() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Congratulations! You guessed the correct number.");
        alertDialog.setPositiveButton("Play again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               Toast.makeText(MainActivity.this, "Game restarted", Toast.LENGTH_LONG);
            }
        });
        alertDialog.setNegativeButton("Exit app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }

}