package com.ucucite.edu.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText signuser, signpass, signname;
    Button btnsign;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signuser=findViewById(R.id.signuser);
        signpass=findViewById(R.id.signpass);
        signname=findViewById(R.id.signname);

        btnsign=findViewById(R.id.btnsign);

        preferences = getSharedPreferences("Userinfo", 0);

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = signuser.getText().toString();
                String password = signpass.getText().toString();
                String name = signname.getText().toString();

                if (username.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("signuser", username);
                    editor.putString("signpass", password);
                    editor.putString("signname", name);
                    editor.apply();

                    Toast.makeText(SignUp.this, "New Account Created!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignUp.this, "Field cannot be Empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}