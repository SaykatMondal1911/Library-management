package com.example.sdp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailsBook extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_book);

        textView = findViewById(R.id.detailsBooksTextViewId);
        imageView = findViewById(R.id.detailsBooksImageViewId);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String value = bundle.getString("tag");
            if(value.equals("Java")){
                imageView.setImageResource(R.drawable.java);
                textView.setText(value);
            }
            else{
                imageView.setImageResource(R.drawable.python);
                textView.setText(value);
            }
        }
    }
}