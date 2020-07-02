package com.example.mydrawabletest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        imageView1 = (ImageView)findViewById(R.id.imageView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView1.getVisibility() == View.GONE)
                {
                    imageView1.setVisibility(View.VISIBLE);
                }
                else
                {
                    imageView1.setVisibility(View.GONE);
                }

            }
        });

    }
}