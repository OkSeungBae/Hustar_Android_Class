Hustar_Android_Class 20200706
====================

# 안드로이드 화면 세로 <-> 가로 변환 교육

1.  layout-land 디렉토리 만들기
layout디렉토리 -> layout-land디렉토리 생성 -> (layout 폴더의 )activity_main.xml 파일을 카피해서 (layout-land 폴더로 )activity_main.xml파일을 붙여넣기

2. 화면 전환 될 때 activity 주기

어플 시작 : onCreate -> onStart
화면 전환 : onStop -> onSaveInstanceState -> onCreate -> onStart

3. onCreate()
```
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if(savedInstanceState != null)
        {
            //saveInstanceState에 저장된 값이 있다면.
            name = savedInstanceState.getString("name");
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        }
    }
```

4. onSaveInstanceState()
```
@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();

        //화면이 전환될 때 정보를 저장 ( 화면이 전환될 때 onStop 이후 자동으로 호출 )
        outState.putString("name", name);
    }
```