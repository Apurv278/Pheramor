package com.example.pheramore.pheramor;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class picInt extends AppCompatActivity {

    String userGenderInt;
    String userAgeInt;
    Button pickImage;
    ImageView profilePic;
    private static final int PICK_CODE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_int);

        profilePic = findViewById(R.id.profilePicture);
        pickImage = findViewById(R.id.selectImage);

        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPicture();
            }


        });




        Spinner genderInterstSpinner = findViewById(R.id.genderInterest);
        ArrayAdapter<CharSequence> adapter_genderInt = ArrayAdapter.createFromResource(getApplicationContext(),R.array.genderArray,android.R.layout.simple_spinner_item);
        adapter_genderInt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderInterstSpinner.setAdapter(adapter_genderInt);
        genderInterstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                userGenderInt = parent.getItemAtPosition(position).toString();
                Toast.makeText(picInt.this, "Gender: "+userGenderInt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Spinner ageInterstSpinner = findViewById(R.id.ageInterest);
        ArrayAdapter<CharSequence> adapter_ageInt = ArrayAdapter.createFromResource(getApplicationContext(),R.array.ageArray,android.R.layout.simple_spinner_item);
        adapter_genderInt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageInterstSpinner.setAdapter(adapter_ageInt);
        ageInterstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                userAgeInt = parent.getItemAtPosition(position).toString();
                Toast.makeText(picInt.this, "Gender: "+userAgeInt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void selectPicture() {
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(pickImage, PICK_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && resultCode == PICK_CODE){
            imageUri = data.getData();



                profilePic.setImageURI(imageUri);



        }
    }
}
