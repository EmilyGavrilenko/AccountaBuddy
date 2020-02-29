package com.example.buddy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button signup_btn = (Button)findViewById(R.id.sign_up);
        signup_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            //currently creates a new database with each "click to begin"
            public void onClick(View v) {
                TextView Email = findViewById(R.id.create_email);
                TextView pWord = findViewById(R.id.create_password);
                String username = Email.getText().toString();
                String password = pWord.getText().toString();
                Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(startIntent);
            }
        });

        Button haveAccount_btn = (Button)findViewById(R.id.have_account);
        haveAccount_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            //currently creates a new database with each "click to begin"
            public void onClick(View v) {
                Intent startIntent = new Intent (getApplicationContext(),Login.class);
                startActivity(startIntent);
            }
        });
    }
}
