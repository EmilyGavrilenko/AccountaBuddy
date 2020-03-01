package com.example.buddy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class CreateChallenge extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Create_Challenge";
    TextView mchallengename;
    TextView mchallengeDescript;
    TextView mchallengeCompletionDate;
    //TextView mchallengeCompletionTime;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);
        mchallengename = findViewById(R.id.name_of_challenge);
        mchallengeDescript = findViewById(R.id.challenge_description);
        mchallengeCompletionDate = findViewById(R.id.completion_day);
        //mchallengeCompletionTime = findViewById(R.id.completion_time);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.Create_challenge).setOnClickListener(this);


    }
    private void createChallenge(String name, String descript, String date, Integer bet ){
        Log.d(TAG, "createChallenge:" + name);
        if (!validateForm()) {
            return;
        }
        // [Start create_challenge]

    }
    }
