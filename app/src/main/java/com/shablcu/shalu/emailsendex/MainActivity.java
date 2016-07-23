package com.shablcu.shalu.emailsendex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText To, Subject, Message;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        To = (EditText) findViewById(R.id.edTo);
        Subject = (EditText) findViewById(R.id.edSubject);
        Message = (EditText) findViewById(R.id.edMessage);
        btnSend = (Button) findViewById(R.id.btnsend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = To.getText().toString();
                String subject = Subject.getText().toString();
                String message = Message.getText().toString();
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                Email.putExtra(Intent.EXTRA_SUBJECT, subject);
                Email.putExtra(Intent.EXTRA_TEXT, message);
                Email.setType("message/rfc822");
                startActivity(Intent.createChooser(Email, "Select Email Client"));
            }
        });

    }
}
