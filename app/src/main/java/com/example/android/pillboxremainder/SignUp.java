package com.example.android.pillboxremainder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.pillboxremainder.Models.Caretaker;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Reem_ on 02/07/19.
 */

public class SignUp extends AppCompatActivity {

    private EditText Username, Password, Email;
    private Button backA;
    private Button signUp;
    private Realm realm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        signUp = (Button) findViewById(R.id.sign_up_button3);

        backA = (Button) findViewById(R.id.backarrow4);
        backA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, StartInterface.class));
            }
        });

        Username=(EditText)findViewById(R.id.Username);
        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.Password);

        realm = Realm.getDefaultInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Username.getText().length()==0 || Password.getText().length()==0 || Email.getText().length()==0){
                    Toast.makeText(SignUp.this,"fill all fields!",Toast.LENGTH_SHORT).show();
                }else{
                    RealmResults<Caretaker> resultCT = realm.where(Caretaker.class)
                            .equalTo("caretaker_name", Username.getText().toString())
                            .or()
                            .equalTo("caretaker_password", Password.getText().toString())
                            .or()
                            .equalTo("caretaker_email", Email.getText().toString())
                            .findAll();
                    //check if any user already registered
                    if(resultCT.size()>0){
                        //found users, get last userID
                        Toast.makeText(SignUp.this,"ALREADY REGISTERD",Toast.LENGTH_SHORT).show();
                    }else{
                        saveToDB(Username.getText().toString(),Password.getText().toString(), Email.getText().toString());
                        Toast.makeText(SignUp.this, "Account Created", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }

            }
        });

    }

    private void saveToDB(final String CTusername, final String CTpassword, final String CTemail) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgrealm) {
                Caretaker caretaker = bgrealm.createObject(Caretaker.class, UUID.randomUUID().toString());
                caretaker.setCaretaker_name(CTusername);
                caretaker.setCaretaker_password(CTpassword);
                caretaker.setCaretaker_email(CTemail);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.v("Success","ADDED!!!!");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.v("Failed",error.getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

}
