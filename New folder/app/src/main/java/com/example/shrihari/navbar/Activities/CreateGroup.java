package com.example.shrihari.navbar.Activities;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.shrihari.navbar.R;

/**
 * Created by Shrihari on 11/10/2016.
 */
public class CreateGroup extends AppCompatActivity {

    ImageButton maddUser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);
        maddUser = (ImageButton) findViewById(R.id.addMem);

        assert maddUser != null;
        maddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),addContact.class);
                startActivityForResult(intent,1);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
