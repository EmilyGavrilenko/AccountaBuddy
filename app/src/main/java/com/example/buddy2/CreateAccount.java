package com.example.buddy2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "CreateAccount";

    TextView mFirstname;
    TextView mLastname;
    TextView mEmail;
    TextView mPassword;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mEmail = findViewById(R.id.create_email);
        mPassword = findViewById(R.id.create_password);
        mFirstname = findViewById(R.id.create_firstName);
        mLastname = findViewById(R.id.create_lastName);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        findViewById(R.id.sign_up).setOnClickListener(this);
        findViewById(R.id.have_account).setOnClickListener(this);

    }

    private void addToDatabase(){
        String email = mEmail.getText().toString();
        String fName = mFirstname.getText().toString();
        String lName = mLastname.getText().toString();

        // Create a new user with a first, middle, and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", fName);
        user.put("last", lName);
        user.put("email", email);
        user.put("moneyDonated", 0);
        user.put("totalChallenges", 0);
        user.put("completedChallenges", 0);

        // Add a new document with a generated ID
        fStore.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(CreateAccount.this, "Succeeded???.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Name, email address, and profile photo Url
                                String email = user.getEmail();
                                String uid = user.getUid();
                                Toast.makeText(CreateAccount.this, email + " " + uid,
                                        Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateAccount.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                });
        // [END create_user_with_email]

        addToDatabase();
        Toast.makeText(CreateAccount.this, "Reached end.",
                Toast.LENGTH_SHORT).show();
        Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
        startActivity(startIntent);
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Required.");
            valid = false;
        } else {
            mEmail.setError(null);
        }

        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Required.");
            valid = false;
        } else {
            mPassword.setError(null);
        }

        String fName = mFirstname.getText().toString();
        if (TextUtils.isEmpty(fName)) {
            mFirstname.setError("Required.");
            valid = false;
        } else {
            mFirstname.setError(null);
        }

        String lName = mLastname.getText().toString();
        if (TextUtils.isEmpty(lName)) {
            mLastname.setError("Required.");
            valid = false;
        } else {
            mLastname.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.sign_up) {
            createAccount(mEmail.getText().toString(), mPassword.getText().toString());
            Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
            startActivity(startIntent);
        } else if (i == R.id.have_account) {
            Intent startIntent = new Intent (getApplicationContext(),Login.class);
            startActivity(startIntent);
        }
    }
}
