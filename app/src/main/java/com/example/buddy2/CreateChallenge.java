package com.example.buddy2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
// <<<<<<< meha
// import android.util.Log;
// import android.view.View;
// import android.widget.Button;
// import android.widget.TextView;

// import com.google.android.gms.tasks.OnFailureListener;
// import com.google.android.gms.tasks.OnSuccessListener;
// import com.google.firebase.auth.FirebaseAuth;
// import com.google.firebase.auth.FirebaseUser;
// import com.google.firebase.firestore.DocumentReference;
// import com.google.firebase.firestore.DocumentSnapshot;
// import com.google.firebase.firestore.FieldValue;
// import com.google.firebase.firestore.FirebaseFirestore;

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;



// public class CreateChallenge extends AppCompatActivity implements View.OnClickListener{
//     private static final String TAG = "CreateChallenge";

//     TextView mnameofchallenge;
//     TextView mDescript;
//     TextView mdeadline;
//     TextView mbetAmt;
//     FirebaseAuth mAuth;
//     FirebaseFirestore fStore;

// =======
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

// <<<<<<< meha
//         mnameofchallenge = findViewById(R.id.name_of_challenge);
//         mDescript = findViewById(R.id.challenge_description);
//         mdeadline = findViewById(R.id.completion_day);
//         mbetAmt = findViewById(R.id.Betting_amount);

//         fStore = FirebaseFirestore.getInstance();
//         mAuth = FirebaseAuth.getInstance();

//         findViewById(R.id.Create_challenge_btn).setOnClickListener(this);


//         };


//     private void getUser(){
//             DocumentSnapshot document;
//             final String name = mnameofchallenge.getText().toString();
//             final String descript = mDescript.getText().toString();
//             String deadline = mdeadline.getText().toString();
//             final Double bet =Double.parseDouble(mbetAmt.getText().toString());
//             SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//             try {
//                 Date deadlinedate = date.parse(deadline);
//             } catch (ParseException e){
//                 mdeadline.setError(null);
//             }

//             // get currentuser
//             FirebaseUser user1 = mAuth.getCurrentUser();
//             final String userID = user1.getUid();
//             DocumentReference docRef = fStore.collection("users").document(userID);
//                     docRef.get()
//                     .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                         @Override
//                         public void onSuccess(DocumentSnapshot documentSnapshot) {
//                             User user = documentSnapshot.toObject(User.class);
//                             user.newChallenge(name,descript,bet);

//                         }
//                     }) //user in user1
//                     .addOnFailureListener(new OnFailureListener() {
//                         @Override
//                         public void onFailure(@NonNull Exception e) {
//                             Log.w(TAG, "Error adding document", e);
//                         }
//                     });
//              docRef.collection("users").document(userID)
//                      .update("currentChallenges", FieldValue.arrayUnion());

//         }

//     @Override
//     public void onClick(View v) {
//         int i = v.getId();
//         if (i == R.id.Create_challenge_btn) {
//             Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
//             startActivity(startIntent);
//         }
      
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

