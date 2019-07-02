package com.example.android.pillboxremainder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Reem_ on 02/07/19.
 */

public class SignUp extends AppCompatActivity {
    private Button backA;
    private Button signU;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        signU = (Button) findViewById(R.id.sign_up_button3);

        backA = (Button) findViewById(R.id.backarrow4);
        backA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, StartInterface.class));
            }
        });









    }

}
