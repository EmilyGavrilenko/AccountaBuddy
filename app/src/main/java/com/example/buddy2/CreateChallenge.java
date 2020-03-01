package com.example.buddy2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreateChallenge extends AppCompatActivity {
    TextView nameChallenge;
    TextView amountDonate;
    TextView description;
    TextView completionDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);

        nameChallenge = findViewById(R.id.name_of_challenge);
        amountDonate = findViewById(R.id.Betting_amount);
        description = findViewById(R.id.challenge_description);
        completionDay = findViewById(R.id.completion_day);

        Button challenge_btn = (Button)findViewById(R.id.Create_challenge_btn);
        challenge_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(validateForm()){
                    Intent startIntent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(startIntent);
                }
                else{
                    Toast.makeText(CreateChallenge.this, "Please Complete All Fields.",
                            Toast.LENGTH_SHORT).show();
                    Intent startIntent = new Intent(getApplicationContext(),CreateChallenge.class);
                    startActivity(startIntent);
                }
            }
        });

        Button cancel_btn = (Button)findViewById(R.id.cancel_challenge);
        cancel_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(startIntent);
            }
        });
    }

    private boolean validateForm() {
        boolean valid = true;

        String name = nameChallenge.getText().toString();
        if (TextUtils.isEmpty(name)) {
            nameChallenge.setError("Required.");
            valid = false;
        } else {
            nameChallenge.setError(null);
        }

        String donation = amountDonate.getText().toString();
        if (TextUtils.isEmpty(donation)) {
            amountDonate.setError("Required.");
            valid = false;
        } else {
            amountDonate.setError(null);
        }

        String descrip = description.getText().toString();
        if (TextUtils.isEmpty(descrip)) {
            description.setError("Required.");
            valid = false;
        } else {
            description.setError(null);
        }

        String deadline = completionDay.getText().toString();
        if (TextUtils.isEmpty(deadline)) {
            completionDay.setError("Required.");
            valid = false;
        } else {
            completionDay.setError(null);
        }

        return valid;
    }
}
