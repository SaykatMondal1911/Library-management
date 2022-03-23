package com.example.sdp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private int spinnerPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//-------------------for spinner------------------------------------

        Spinner spinner = (Spinner) findViewById(R.id.roles_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roles_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

//---------------------------------for signIn Button------------------------------
        Button button = (Button) findViewById(R.id.btnLogIn);
        TextView textView = (TextView) findViewById(R.id.gotoRegister);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinnerPosition==0){
                    Intent intent = new Intent(login.this,user.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(login.this,admin.class);
                   startActivity(intent);
                }
            }
        });
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Do something in response to button click
        Intent intent = new Intent(login.this, signup.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        spinnerPosition = i;

//        if (!isSpinnerTouched) return;
//        if(pos==0){
//            Intent intent = new Intent(login.this,user.class);
//            startActivity(intent);
//            Toast.makeText(getApplicationContext(),"User", Toast.LENGTH_SHORT).show();
//        }
//
//        else{
//            Intent intent = new Intent(login.this,admin.class);
//            startActivity(intent);
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
//        Intent intent = new Intent(login.this,user.class);
//        startActivity(intent);
    }

//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        isSpinnerTouched = true;
//        return false;
//    }

}