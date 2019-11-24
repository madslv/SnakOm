package com.example.myapp9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp9.BlivKlogere.BlivKlogereActivity;
import com.example.myapp9.Gem.GemActivity;
import com.example.myapp9.HentData.APIActivity;
import com.example.myapp9.Hvor.HvorActivity;
import com.example.myapp9.TagSnakken.TagSnakkenActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private TextView Email;
    private Button logout;
    private Button tagsnakken;
    private Button gemdine;
    private Button bliv;
    private Button hvor;
    private Button hent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Email = (TextView)findViewById(R.id.profileEmail);
        mAuth = FirebaseAuth.getInstance();
        logout = (Button)findViewById(R.id.button_logout);
        tagsnakken = (Button)findViewById(R.id.button_tagsnakken);
        gemdine = (Button)findViewById(R.id.button_gemdine);
        bliv = (Button)findViewById(R.id.button_bliv);
        hvor = (Button)findViewById(R.id.button_hvor);
        hent = (Button) findViewById(R.id.button_hent);
        user = mAuth.getCurrentUser();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==logout){
                    if (user != null) {
                        mAuth.signOut();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                }
            }
        });

        tagsnakken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==tagsnakken){
                    if (user != null) {
                        startActivity(new Intent(getApplicationContext(), TagSnakkenActivity.class));
                    }
                }
            }
        });

        gemdine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==gemdine){
                    if (user != null) {
                        startActivity(new Intent(getApplicationContext(), GemActivity.class));
                    }
                }
            }
        });

        bliv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==bliv){
                    if (user != null) {
                        startActivity(new Intent(getApplicationContext(), BlivKlogereActivity.class));
                    }
                }
            }
        });

        hvor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==hvor){
                    if (user != null) {
                        startActivity(new Intent(getApplicationContext(), HvorActivity.class));
                    }
                }
            }
        });

        hent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==hent){
                    if (user != null) {
                        startActivity(new Intent(getApplicationContext(), APIActivity.class));
                    }
                }
            }
        });


        if (user != null){
            String email = user.getEmail();
            Email.setText(email);

        }
    }
}
