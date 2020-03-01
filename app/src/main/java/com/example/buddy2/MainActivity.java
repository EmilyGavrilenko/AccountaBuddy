package com.example.buddy2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and user id
            String name = user.getDisplayName();
            String email = user.getEmail();
            String uid = user.getUid();

            Toast.makeText(MainActivity.this, email + " " + uid,
                    Toast.LENGTH_SHORT).show();
        }
        else{

        }
    }
}
