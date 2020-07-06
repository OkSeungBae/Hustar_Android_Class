package com.example.intenttest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnActivity;
    final int REQUEST_CODE_TEST = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity = findViewById(R.id.btnActivity);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivityForResult(intent, REQUEST_CODE_TEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_TEST)
        {
            if(resultCode == RESULT_OK)
            {
                String name = data.getExtras().getString("name");
                String age = data.getExtras().getString("age");

                //현재 년도
                int year = Calendar.getInstance().get(Calendar.YEAR);

                String birthYear = "19" + age.substring(0,2);
                int realAge = year - Integer.parseInt(birthYear);

                Toast.makeText(getApplicationContext(), "name :: " + name +", birthYear :: " + realAge, Toast.LENGTH_SHORT).show();
            }
        }
    }
}