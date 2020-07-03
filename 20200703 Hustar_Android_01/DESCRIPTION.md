Hustar_Android_Class 20200703
====================

# 개인 과제

## 어플리케이션 위에 Touch시 imageView가 따라오도록 만들기


*MainActivity.java
```
container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float x = motionEvent.getX();
                float y = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN)
                {
                    imageView.setX(x-imageView.getWidth()/2);
                    imageView.setY(y);
                }
                return true;
            }
        });
```

*image

<img src ="/PracticeImage/20200703 Hustar-Android_01.PNG" width="300px" height="500px"></img>
