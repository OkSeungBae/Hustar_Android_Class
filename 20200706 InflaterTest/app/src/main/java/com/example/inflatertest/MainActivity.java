package com.example.inflatertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        container = (LinearLayout)findViewById(R.id.container);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //container에 포함된 모든 View들을 제거
                container.removeAllViews();

                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.add2, container, true);

                final CheckBox[] checkBox = new CheckBox[3];
                checkBox[0] = container.findViewById(R.id.checkBox1);
                checkBox[1] = container.findViewById(R.id.checkBox2);
                checkBox[2] = container.findViewById(R.id.checkBox3);
                Button btnOK = container.findViewById(R.id.btnOK);
                final TextView textView = container.findViewById(R.id.textViewReal);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answer = "제가 좋아하는 차종은 ";

                        for(int i=0; i<3; i++)
                        {
                            if(checkBox[i].isChecked()){
                                switch (i)
                                {
                                    case 0:
                                        answer += "아반떼 ";
                                        break;
                                    case 1:
                                        answer += "소나타 ";
                                        break;
                                    case 2:
                                        answer += "그랜져 ";
                                        break;
                                }
                            }
                        }
                        answer += "입니다.";

                        textView.setText(answer);
                    }
                });
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //container에 포함된 모든 View들을 제거
                container.removeAllViews();

                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.add1, container, true);

                RadioGroup radioGroup = container.findViewById(R.id.radioGroup);
                RadioButton rBtn45 = container.findViewById(R.id.rBtn45);
                RadioButton rBtn90 = container.findViewById(R.id.rBtn90);
                final Button btnRotate = container.findViewById(R.id.buttonRotate);

                rBtn45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b)
                            btnRotate.setRotation(45);
                    }
                });

                rBtn90.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b)
                            btnRotate.setRotation(90);
                    }
                });

            }
        });
    }
}