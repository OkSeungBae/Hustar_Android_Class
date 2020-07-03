Hustar_Android_Class 20200703
====================

1.  onTouchListener() 교육 
```
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
```

2. GestureDetector 교육
```
view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
```

```
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
```