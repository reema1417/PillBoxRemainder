package com.example.android.pillboxremainder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Reem_ on 29/06/19.
 */

public class SignIn extends AppCompatActivity {
    private Button signIn;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        signIn = (Button) findViewById(R.id.sign_in_button2);
        back = (Button) findViewById(R.id.backarrow3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, StartInterface.class));
            }
        });









    }

}
