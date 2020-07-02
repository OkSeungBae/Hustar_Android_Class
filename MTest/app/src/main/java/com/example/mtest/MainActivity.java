package com.example.mtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnConnectNaver;
    private Button btnConnectCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonConnectNaverClicked(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        Toast.makeText(this, "네이버로 연결합니다.", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }

    public void onButtonConnectCallClicked(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8528-1808"));
        Toast.makeText(this, "010-8528-1808로 연결합니다.", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }
}