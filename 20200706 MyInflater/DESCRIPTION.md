Hustar_Android_Class 20200706
====================

# Layout Inflater


1. layout 위에 또 다른 layout을 올리고 싶을 때 Layout Inflater를 사용한다.

2. layout 디렉토리에 sub.xml을 추가한다

3. 다음과 같이 레이아웃과 위젯들을 추가하여 준다.

<img src ="/PracticeImage/20200706 inflater1.PNG" width="200px" height="100px"></img>

4. 마지막 LinearLayout의 id값은 container로 하고 비워둔다

5. MainActivity.java
```
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        container = (LinearLayout)findViewById(R.id.container);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity_main.xml에 sub.xml을 인플레이션 한다
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub, container, true);

                CheckBox checkBox = (CheckBox)container.findViewById(R.id.checkBox);
                checkBox.setText("로딩되었어요");
                checkBox.setChecked(true);
            }
        });
    }
```

* 중요부분
```
LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
inflater.inflate(R.layout.sub, container, true);
```

6. 실습 이미지

<img src ="/PracticeImage/20200706 inflater2.PNG" width="300px" height="500px"></img>

<img src ="/PracticeImage/20200706 inflater3.PNG" width="300px" height="500px"></img>

7.  2번째 실습 
# 하나의 화면에 infalter를 사용해서 두개의 xml을 번갈아서 사용하기

* 중요코드
```
public void onClick(View view) {
                //container에 포함된 모든 View들을 제거
                container.removeAllViews();

                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.add2, container, true);
}
```

```
btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //container에 포함된 모든 View들을 제거
                container.removeAllViews();

                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.add1, container, true);
}
```

* container 즉, layout에는 xml을 하나만 집어 넣을 수 있다. 따라서 다른 xml을 넣을려면 기존의 View를 모두 삭제하여야 한다
```
contiainer.removeAllViews();
```
를 사용한다.

8. 실습 이미지

<img src ="/PracticeImage/20200706 inflaterTest1.PNG" width="300px" height="500px"></img>

<img src ="/PracticeImage/20200706 inflaterTest2.PNG" width="300px" height="500px"></img>

<img src ="/PracticeImage/20200706 inflaterTest3.PNG" width="300px" height="500px"></img>


