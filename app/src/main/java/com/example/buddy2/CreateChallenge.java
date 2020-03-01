package com.example.buddy2;

import java.util.List;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class CreateChallenge extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "CreateChallenge";

    TextView mnameofchallenge;
    TextView mDescript;
    TextView mdeadline;
    TextView mbetAmt;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);

        mnameofchallenge = findViewById(R.id.name_of_challenge);
        mDescript = findViewById(R.id.challenge_description);
        mdeadline = findViewById(R.id.completion_day);
        mbetAmt = findViewById(R.id.Betting_amount);

        fStore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.Create_challenge_btn).setOnClickListener(this);


        }


    private void getUser(){
            DocumentSnapshot document;
            final String name = mnameofchallenge.getText().toString();
            final String descript = mDescript.getText().toString();
            String deadline = mdeadline.getText().toString();
            final Double bet =Double.parseDouble(mbetAmt.getText().toString());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date deadlinedate = date.parse(deadline);
            } catch (ParseException e){
                mdeadline.setError(null);
            }

            // get currentuser
            FirebaseUser user1 = mAuth.getCurrentUser();
            final String userID;
            if(user1==null){
                userID = (new Random()).toString();
            }
            else{
                userID=user1.getUid();
            }

            Challenge challenge = new Challenge(name,descript,bet);
            DocumentReference docRef = fStore.collection("users").document(userID);
            docRef.update("currentChallenges", name).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully updated!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating document", e);
                    }
                });

            //List<Challenge> challenges = new ArrayList<>();
            //challenges.add(challenge);
            //docRef.update("currentChallenges", name);


        }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Create_challenge_btn) {
            Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
            startActivity(startIntent);
        }
        }
    }

