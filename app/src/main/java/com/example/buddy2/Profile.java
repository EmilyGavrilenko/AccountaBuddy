package com.example.buddy2;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.design.widget.BottomNavigationView;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.firestore.DocumentReference;
        import com.google.firebase.firestore.DocumentSnapshot;
        import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {

    private static final String TAG = "Profile";

    private TextView mTextMessage;
    private TextView mName;
    private TextView mEmail;
    private TextView mUserId;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mTextMessage = (TextView) findViewById(R.id.message);
        mName = (TextView) findViewById(R.id.public_name);
        mEmail = (TextView) findViewById(R.id.public_email);
        mUserId = (TextView) findViewById(R.id.public_userID);

        String userID;

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        currentUser = fAuth.getCurrentUser();

        if(currentUser == null){
            userID = "D0BGz0ksG0TY70dGqUCQOgjho1Z2";
        }

        else{
            userID = currentUser.getUid();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);

        loadProfile(userID);
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
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_new:
                            startIntent = new Intent(getApplicationContext(),CreateChallenge.class);
                            startActivity(startIntent);
                            break;
                        case R.id.nav_friends:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_profile:
                            //startIntent = new Intent(getApplicationContext(),Profile.class);
                            //startActivity(startIntent);
                            selectedFragment = new HomeFragment();
                            break;
                    }
                    if (selectedFragment != null)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

    public void loadProfile(String userID) {
        //String name = mName.getText().toString();
        //String email = mEmail.getText().toString();
        DocumentSnapshot document;

        mUserId.setText(userID);

        DocumentReference docRef = fStore.collection("users").document(userID);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                        String firstname =  document.getData().get("first").toString();
                        String lastname =  document.getData().get("last").toString();
                        String email = document.getData().get("email").toString();
                        int completedChallenges = Integer.parseInt(document.getData().get("completedChallenges").toString());
                        int totalChallenges = Integer.parseInt(document.getData().get("totalChallenges").toString());
                        int moneyDonated = Integer.parseInt(document.getData().get("moneyDonated").toString());

                        mName.setText(firstname + " " + lastname);
                        mEmail.setText(email);

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }
}
