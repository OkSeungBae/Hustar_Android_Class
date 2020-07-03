package com.example.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    View view, view2;
    TextView textView;
    GestureDetector detector;
    ImageView imageView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Toast.makeText(this, "한번만 더 누르면 꺼집니다.", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout)findViewById(R.id.container);
        view = (View)findViewById(R.id.view);
        view2 = (View)findViewById(R.id.view2);
        textView = (TextView)findViewById(R.id.textView);

        //이미지 뷰 생성
        imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.finger);
        

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action ==MotionEvent.ACTION_DOWN)
                {
                    println("손가락 눌림 :  " + curX + ", " + curY);
                    imageView.setX(curX);
                    imageView.setY(curY);
                    //Toast.makeText(getApplicationContext(), "손가락 눌림:" + (int)curX + ", " + (int)curY, Toast.LENGTH_SHORT).show();
                }
                else if(action == MotionEvent.ACTION_MOVE)
                {
                    println("손가락 움직임 :  " + curX + ", " + curY);
                    //Toast.makeText(getApplicationContext(), "손가락 움직임:" + (int)curX + ", " + (int)curY, Toast.LENGTH_SHORT).show();
                }
                else if(action == MotionEvent.ACTION_UP)
                {
                    println("손가락 땜 :  " + curX + ", " + curY);
                    //Toast.makeText(getApplicationContext(), "손가락 땜:" + (int)curX + ", " + (int)curY, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                //println("onScroll");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling = " + v + ", " + v1);
                return false;
            }

        });

    }

    private void println(String message)
    {
        textView.append(message+"\n");
    }
}