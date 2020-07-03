Hustar_Android_Class 20200703
====================

# 개인 과제

## roate변환 버튼을 누르면 이미지의 rotation이 변하도록 만들기


*MainActivity.java
```
btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setRotation(imageView.getRotation()-2);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setRotation(imageView.getRotation()+2);
            }
        });
```

*image

<img src ="/PracticeImage/20200703 Hustar-Android_02.PNG" width="300px" height="500px"></img>
