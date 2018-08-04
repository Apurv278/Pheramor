package com.example.pheramore.pheramor;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Signup extends AppCompatActivity {
        private EditText et_name, et_lname, et_email, et_pwd, et_height, et_date;
        private String name, lname, email, password, height;
        Button nxt;
        String userGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_name = (EditText)findViewById(R.id.name);
        et_lname = (EditText)findViewById(R.id.lname);
        et_email = (EditText)findViewById(R.id.email);
        et_pwd = (EditText)findViewById(R.id.pwd);
        et_height = (EditText)findViewById(R.id.height);
        et_date = findViewById(R.id.date);
        nxt = (Button)findViewById(R.id.next);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });


        final DialogFragment dialogFragment = new Datepicker();

        Spinner genderSpinner = findViewById(R.id.genderspin);
        ArrayAdapter<CharSequence> adapter_gender = ArrayAdapter.createFromResource(getApplicationContext(),R.array.genderArray,android.R.layout.simple_spinner_item);
        adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter_gender);
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                userGender = parent.getItemAtPosition(position).toString();
                Toast.makeText(Signup.this, "Gender: "+userGender, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogFragment.show(getSupportFragmentManager(),"Cal");
            }
        });
    }
            public void register(){
                intialize();
                if (!validate()) {
                    Toast.makeText(this,"SignUP has Failed", Toast.LENGTH_SHORT).show();
                }
                else {
                    onSignSuccess();
                }
            }

            public boolean validate(){
                boolean valid = true;
                if (name.isEmpty()||name.length()>30){
                    et_name.setError("Please Enter a Valid Name");
                    valid = false;
                }
                if (lname.isEmpty()||lname.length()>30){
                    et_lname.setError("Please Enter a Valid Last Name");
                    valid = false;
                }
                if (email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    et_email.setError("Please Enter a Valid Email Address");
                    valid = false;
                }
                if (password.isEmpty()||password.length()<8){
                    et_pwd.setError("Please Enter a Valid Password");
                    valid = false;
                }
                return valid;
            }

            public void onSignSuccess(){

            }

            public void intialize(){
                name = et_name.getText().toString().trim();
                lname = et_lname.getText().toString().trim();
                email = et_email.getText().toString().trim();
                password = et_pwd.getText().toString().trim();
                height = et_height.getText().toString().trim();

                Intent picIntent = new Intent(getApplicationContext(),picInt.class);
                startActivity(picIntent);
            }

         //Creating calendar class

        public static class Datepicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{


            @NonNull
            @Override
            public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),this,year,month,day);
                return datePickerDialog;
            }

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                TextView textView = (TextView)getActivity().findViewById(R.id.date);
                textView.setText((month+1)+"/"+day+"/"+year);

            }
        }

}
