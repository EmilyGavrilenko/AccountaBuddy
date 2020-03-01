package com.example.buddy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseCharity extends AppCompatActivity implements View.OnClickListener {
    private Button aButton;
    private Button bButton;
    private Button cButton;
//    private Button dButton;
//    private Button eButton;
//    private Button fButton;

    @Override
    public void onClick(View view)
    {
//        DataManager dm = new DataManager();
//        dm.doData();

        DataManager.doData();

        //replace with user search
        User user = new User();

//        switch (view.getId()) {
//            case R.id.charity1:
//                //
//            case R.id.charity2:
//                //
//            case R.id.charity3:
                //
//            case R.id.charity4:
//                user.setCharity(DataManager.charities.get(3));
//            case R.id.charity5:
//                user.setCharity(DataManager.charities.get(4));
//            case R.id.charity6:
//                user.setCharity(DataManager.charities.get(5));



        //
        Intent startIntent = new Intent (getApplicationContext(),MainActivity.class);
        startActivity(startIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_charity);

        aButton = findViewById(R.id.charity1);
        aButton.setOnClickListener(this);

        bButton = findViewById(R.id.charity2);
        bButton.setOnClickListener(this);

        cButton = findViewById(R.id.charity3);
        cButton.setOnClickListener(this);
    }
}