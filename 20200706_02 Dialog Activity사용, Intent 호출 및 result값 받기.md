Hustar_Android_Class 20200706
====================

# Main Activity 에서 Diaglog Menu Activiy를 띄우기

1.  Activity생성
app 마우스 우클릭 -> New -> Activity -> Empty
하면 자동으로 Acitivty와 layout이 추가되며

manifests -> AndroidManifest.xml에도 자동으로 Activitiy가 추가된다.

2. manifest파일에서
```
<activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```
이 코드가 붙는 activity가 첫 화면이 된다.

3. Acitivty간에 데이터를 주고 받기

* MainActivity.java

3-1. intent로 Activity호출
```
Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
startActivityForResult(intent, REQUEST_CODE_MENU);
```

3-2. 호출한 Intent의 값 받아오기
```
@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU)
        {
            Toast.makeText(getApplicationContext(), "onActivityResult 메소드 호출됨. 요청코드 :: " + requestCode + ", 결과코드 :: " + resultCode, Toast.LENGTH_SHORT).show();
            if(resultCode == RESULT_OK)
            {
                String name = data.getExtras().getString("name");
                Toast.makeText(getApplicationContext(), "응답으로 전달된 name :: " + name, Toast.LENGTH_SHORT).show();
            }
        }
    }
```

* MenuActiviy.java

4. 값 보내기
```
Intent intent = new Intent();
intent.putExtra("name", "승배");
setResult(RESULT_OK, intent);
finish();
```