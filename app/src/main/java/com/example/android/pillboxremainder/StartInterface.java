package com.example.android.pillboxremainder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Reem_ on 26/06/19.
 */

public class StartInterface extends AppCompatActivity {
    private Button signInB;
    private Button signUpB;
    private Button backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_interface);
        signInB = (Button) findViewById(R.id.sign_in_button);
        signUpB = (Button) findViewById(R.id.sign_up_button);
        backArrow = (Button) findViewById(R.id.backarrow2);

        signUpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartInterface.this, SignUp.class));
            }
        });

        signInB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartInterface.this, SignIn.class));
            }
        });
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartInterface.this, MainActivity.class));
            }
        });


    }
}
