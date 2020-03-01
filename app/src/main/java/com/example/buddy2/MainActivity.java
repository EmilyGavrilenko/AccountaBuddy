package com.example.buddy2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    Intent startIntent;
                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_home:
                            startIntent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(startIntent);
                            break;
                        case R.id.nav_new:
                            startIntent = new Intent(getApplicationContext(),CreateChallenge.class);
                            startActivity(startIntent);
                            break;
                        case R.id.nav_friends:
                            selectedFragment = new SocialFragment();
                            break;
                        case R.id.nav_profile:
                            startIntent = new Intent(getApplicationContext(),Profile.class);
                            startActivity(startIntent);
                            break;
                    }
                    if (selectedFragment != null)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}
