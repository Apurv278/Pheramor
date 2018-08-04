package com.example.pheramore.pheramor;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText user, pswd;
    Button login,signup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    CheckBox savebox;
    Boolean savelogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        signup = findViewById(R.id.button2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Signup.class);
                startActivity(i);
            }
        });


        user = (EditText)findViewById(R.id.editText);
        pswd = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);
        savebox = (CheckBox)findViewById(R.id.cbox);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        editor =  sharedPreferences.edit();

       /* login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     login();
            }
        });*/


//        Button signup = (Button) findViewById(R.id.button2);
//        signup.setOnClickListener(
//                new Button.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent sign = new Intent(v.getContext(), Signup.class);
//                        startActivity(sign);
//                    }
//                }
//        );


    }
}