package com.app.notificacionesoreo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView textViewTitle2, textViewMessage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textViewTitle2 = (TextView)findViewById(R.id.textViewTitle2);
        textViewMessage2 = (TextView)findViewById(R.id.textViewMessage2);
    }

    private void setIntentValues(){
        if (getIntent() != null){
            textViewTitle2.setText(getIntent().getStringExtra("title"));
            textViewMessage2.setText(getIntent().getStringExtra("message"));
        }
    }
}