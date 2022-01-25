package com.app.notificacionesoreo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextMessage;

    private Switch switchImportance;

    private TextView textViewTitle, textViewMessage;

    private Button buttonSend;

    private boolean isHighImportance = false;
    private NotificationHandler notificationHandler;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        switchImportance = (Switch) findViewById(R.id.switchImportance);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        notificationHandler = new NotificationHandler(MainActivity.this);

        switchImportance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isHighImportance = isChecked;
                if (isChecked){
                    switchImportance.setText("HIGH");
                } else {
                    switchImportance.setText("LOW");
                }
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    private void sendNotification() {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(message)){
            Notification.Builder nb = notificationHandler.createNotification(title, message, isHighImportance);
            notificationHandler.getManager().notify(++counter, nb.build());
            notificationHandler.publishNotificationSummaryGroup(isHighImportance);
        }
    }
}