package com.example.buddy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "CreateAccount";

    TextView mFirstname;
    TextView mLastname;
    TextView mEmail;
    TextView mPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mEmail = findViewById(R.id.create_email);
        mPassword = findViewById(R.id.create_password);
        mFirstname = findViewById(R.id.create_firstName);
        mLastname = findViewById(R.id.create_lastName);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.sign_up).setOnClickListener(this);
        findViewById(R.id.have_account).setOnClickListener(this);

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
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
                            startActivity(startIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateAccount.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
        // [END create_user_with_email]
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
        } else if (i == R.id.have_account) {
            Intent startIntent = new Intent (getApplicationContext(),Login.class);
            startActivity(startIntent);
        }
    }
}
