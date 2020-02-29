package com.example.buddy2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_btn = (Button)findViewById(R.id.login);
        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            //currently creates a new database with each "click to begin"
            public void onClick(View v) {
                TextView uName = findViewById(R.id.login_username);
                TextView pWord = findViewById(R.id.login_password);
                String username = uName.getText().toString();
                String password = pWord.getText().toString();

                Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(startIntent);
            }
        });
        Button create_btn = (Button)findViewById(R.id.createNew);
        create_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            //currently creates a new database with each "click to begin"
            public void onClick(View v) {
                TextView uName = findViewById(R.id.login_username);
                TextView pWord = findViewById(R.id.login_password);
                String username = uName.getText().toString();
                String password = pWord.getText().toString();

                Intent startIntent = new Intent (getApplicationContext(),CreateAccount.class);
                startActivity(startIntent);
            }
        });
    }

}
