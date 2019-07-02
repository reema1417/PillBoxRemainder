package com.example.android.pillboxremainder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.pillboxremainder.Models.Caretaker;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Reem_ on 29/06/19.
 */

public class SignIn extends AppCompatActivity {
    private Button signIn;
    private Button back;
    private EditText user_password, user_email;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        signIn = (Button) findViewById(R.id.sign_in_button2);
        user_email=(EditText)findViewById(R.id.emailL);
        user_password=(EditText)findViewById(R.id.passwordL);
        realm = Realm.getDefaultInstance();
        back = (Button) findViewById(R.id.backarrow3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, StartInterface.class));
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_email.getText().length()==0 || user_password.getText().length()==0){
                    Toast.makeText(SignIn.this, "fill all fields!", Toast.LENGTH_SHORT).show();
                }else{
                    validateLogin(user_email.getText().toString(),user_password.getText().toString());
                }
            }
        });

    }

    public void validateLogin(String email, String password){

        RealmResults<Caretaker> ValRes = realm.where(Caretaker.class)
                .equalTo("caretaker_email", email)
                .findAll();

        if(ValRes.size()>0){
            //check password
            RealmResults<Caretaker> loginRes = realm.where(Caretaker.class)
                    .equalTo("caretaker_email", email)
                    .equalTo("caretaker_password", password)
                    .findAll();
            if(loginRes.size()>0){
//                SessionManager sessionManager = new SessionManager(LoginActivity.this);
//                sessionManager.saveLoginCredenetials(user);
//                SharedPreference SP=new SharedPreference(UserLogin.this);
//                SP.saveLoginCredenetials(email);

                // here we put the home page!!!!

                Intent home = new Intent(SignIn.this, StartInterface.class);
                startActivity(home);
                SignIn.this.finish();
            }else{
                Toast.makeText(SignIn.this, "email & password does not maatch!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(SignIn.this, "email not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

}
