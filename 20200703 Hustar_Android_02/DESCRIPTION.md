Hustar_Android_Class 20200703
====================

#개인과제

##화살표 버튼을 누를 시 이미지가 회전하도록 만들기

*MainActivity.java
```
btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setRotation(imageView.getRotation()-1);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setRotation(imageView.getRotation()+1);
            }
        });
```

*image

![Alt text](.\PracticeImage\20200703 Hustar-Android_02.png)