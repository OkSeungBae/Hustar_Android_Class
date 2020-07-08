Hustar_Android_Class 20200707
====================

# Activity Flag사용

1. Activity플래그의 종류는 많지만 그 중 자주 사용되는 FLAG
* FLAG_ACTIVITY_SINGLE_TOP
* FLAG_ACTIVITY_NO_HISTORY
* FLAG_ACTIVITY_CLEAR_TOP

<img src ="/PracticeImage/20200707 Acitivity Flag.PNG" width="800px" height="500px"></img>

1-1. 사용법
```
Intent intent = new Intent(getBaseContext(), AnotherActivity.class );	//인텐트 객체 생성
intent.putExtra("startCount", String. valueOf ( startCount ));		//부가 데이터 넣기
intent.setFlags(Intent. FLAG_ACTIVITY_SINGLE_TOP );		//인텐트 플래그 설정
startActivityForResult(intent, REQUEST_CODE_ANOTHER ); 		//인텐트 띄우기
```

2. Intent로 데이터를 전송하는 방법에는 putExtra("key", "value")로 전송을 할 수도 있지만
Object 즉, 객체형태로 전송이 가능하다

Parcelable을 사용해서 Intent를 통해 데이터 전송이 가능하다.

2-1. 첫 번째로 Parcelable인터페이스를 implements받은 클래스를 하나 정의한다
```
public class SimpleData implements Parcelable
{
	//int 또는 String이 여러개 일 경우에는 넣는 순서에 따라 달라진다.
private int number;
    private String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    protected SimpleData(Parcel parcel) {
        number = parcel.readInt();
        message = parcel.readString();
    }
public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

	//꼭 writeToParcel을 재 정의해 주어야 한다.
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(message);
    }

	//꼭 CREATER상수를 new로 정의 해주어야 한다.
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
        @Override
        public SimpleData createFromParcel(Parcel parcel) {
            return new SimpleData(parcel);
        }

        @Override
        public SimpleData[] newArray(int i) {
            return new SimpleData[i];
        }
    };
}
```
2-2. MainActivity.java 에서는 Intent를 통해 데이터 전송을 하는 코드이다.
```
Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                SimpleData data = new SimpleData(100, "Hello World!");
                intent.putExtra("data", data);
                startActivityForResult(intent, REQUEST_CODE_MENU);
```

2-3. MenuActivity.java 에서는 MainActivity에서 전송한 데이터를 얻어온다.
```
//1. 메인 엑티비티 객체에서 보낸 인텐트 객체를 얻어온다.
        Intent intent = getIntent();
        if(intent != null)
        {
            Bundle bundle = intent.getExtras();
            SimpleData data = (SimpleData)bundle.getParcelable("data");
            textView.setText("받은 int :: " + data.getNumber() + "\n빋은 message :: " + data.getMessage() );
        }
```


