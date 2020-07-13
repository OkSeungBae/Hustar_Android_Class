Hustar_Android_Class 20200713
=====================

## XmlParse , Service

# XmlPullParser

1. XmlParse를 사용해 .xml파일을 파싱받아 데이터를 불러올 수 있다.

1-1. res/raw/test.xml
raw디렉토리를 만들고 test.xml파일을 만든다
* 주의사항
raw디렉토리를 생성할 시 res에서 디렉토리 생성하고 Resource type을 raw로 한다.
```
<?xml version="1.0" encoding="utf-8"?><!--역대인물 27035명-->
<인명정보>
  <인물>
    <TITLENAME>이헌(李櫶)</TITLENAME>
    <JA>문숙(文叔)</JA>
    <HO></HO>
    <LIVE_YEAR>1669</LIVE_YEAR>
    <DIE_YEAR>1730</DIE_YEAR>
    <ORIGINNAME>전주(全州)</ORIGINNAME>
    <FIRST_NAME></FIRST_NAME>
    <TRAN_NAME></TRAN_NAME>
  </인물>
  <인물>
    <TITLENAME>이동녕(李東寧)</TITLENAME>
    <JA>봉소(鳳所)</JA>
    <HO>암산(巖山)</HO>
    <LIVE_YEAR>1869</LIVE_YEAR>
    <DIE_YEAR>1940</DIE_YEAR>
    <ORIGINNAME>연안(延安)</ORIGINNAME>
    <FIRST_NAME></FIRST_NAME>
    <TRAN_NAME></TRAN_NAME>
  </인물>
  <인물>
    <TITLENAME>최범술(崔凡述)</TITLENAME>
    <JA></JA>
    <HO>효당(曉堂)</HO>
    <LIVE_YEAR>1904</LIVE_YEAR>
    <DIE_YEAR>1979</DIE_YEAR>
    <ORIGINNAME>미상(未詳)</ORIGINNAME>
    <FIRST_NAME></FIRST_NAME>
    <TRAN_NAME></TRAN_NAME>
  </인물>
  <인물>
    <TITLENAME>김세정(金世鼎)</TITLENAME>
    <JA>자중(子重)</JA>
    <HO></HO>
    <LIVE_YEAR>1620</LIVE_YEAR>
    <DIE_YEAR>1686</DIE_YEAR>
    <ORIGINNAME>광산(光山)</ORIGINNAME>
    <FIRST_NAME></FIRST_NAME>
    <TRAN_NAME></TRAN_NAME>
  </인물>
  <인물>
    <TITLENAME>노진(盧禛)</TITLENAME>
    <JA>자응(子膺)</JA>
    <HO>옥계(玉溪)</HO>
    <LIVE_YEAR>1518</LIVE_YEAR>
    <DIE_YEAR>1578</DIE_YEAR>
    <ORIGINNAME>풍천(豊川)</ORIGINNAME>
    <FIRST_NAME></FIRST_NAME>
    <TRAN_NAME></TRAN_NAME>
  </인물>
  </인명정보>
```

xml파일은 다음과 같이 하고

1-2. MainActivity.java
```
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xml_Parse();
            }
        });
    }

    private void xml_Parse() {
        String TAG = "Parsing";
        InputStream inputStream=getResources().openRawResource(R.raw.test);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        XmlPullParser xmlPullParser;

        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(reader);

            Integer eventType = new Integer(xmlPullParser.getEventType());

            while(eventType != xmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        Log.d(TAG,"xml START");
                        break;
                    case XmlPullParser.START_TAG:
                        Log.d(TAG,"START:"+xmlPullParser.getName());
                        break;
                    case XmlPullParser.END_TAG:
                        Log.d(TAG,"End Tag: "+xmlPullParser.getName());
                        break;
                    case XmlPullParser.TEXT:
                        Log.d(TAG,"Text: "+xmlPullParser.getText());
                        break;
                }
                try {
                    eventType = xmlPullParser.next();
                }catch(IOException e){
                    e.getStackTrace();
                }
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try{
            if(reader !=null) reader.close();
            if(inputStreamReader !=null) inputStreamReader.close();
            if(inputStream !=null)inputStream.close();;

        }catch (Exception e){}
    }
```

onCreate()에서 Button 클릭이벤트에 xml_Parse();를 호출한다.

xml_Parse()에서는 BufferdReader reader를 사용해 raw/test.xml 파일을 받아온다
XmlPullParser객체를 사용하고
 
while문을 이용해 xml을 파싱받아 log에 띄운다.

XmlPullParser사용 형식은 위의 코드와 같은 형식을 사용하면 된다.


# Service

1. Service는 foreground에서 동작하는 것이 아니라 background에서 동작한다.

1-1. MainActivity.java
```
btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "android");
                intent.putExtra("name",name);

                startService(intent);
            }
        });
```

MainActivity에서 Intent객체를 생성 후 startService(); 메소드를 이용해 service를 호출한다.

```
@Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        //기존에 켜져있는데 재 사용 할 때 ( SINGLE_TOP 으로 호출 시 )
        //onCreate를 다시 호출 하지 않고 onNewIntent로 호출된다.
        processIntent(intent);

    }

    private void processIntent(Intent intent)
    {
        if(intent != null)
        {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "commnad :: " + command, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "name :: " + name, Toast.LENGTH_SHORT).show();
        }
    }
```

onNewIntent는 MainActivity.java 객체가 메모리에 이미 올라와 있음에도 불구하고 flag가 SINGLE_TOP처럼 호출 되는 경우에 onCreate()를 호출하지 않고
onNewIntent를 호출하기 때문에 작성을 해주어야 한다.

1-2. MyService.java
```
@Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "conStartCommand");

        String command;
        String name;
        if(intent == null)
        {
            //서비스 시작이 되지 않았으면 다시 시작해라
            return Service.START_STICKY;
        }
        else
        {
            command = intent.getStringExtra("command");
            name = intent.getStringExtra("name");

            processCommand(intent, command, name);
        }

        //메인액티비티에 인텐트 객체를 보낸다.
        Intent showIntent = new Intent(getApplication(), MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name);

        startActivity(showIntent);


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void processCommand(Intent intent, String command, String name)
    {


        Log.d(TAG, "넘어온 commane :: " + command);
        Log.d(TAG, "넘어온 name :: " + name);

        for(int i=0; i<2; i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.i(TAG, "Waiting " + (int)(i+1) + " seconds " + name);
        }
    }
```

MyService.java는 Service 클래스를 extends받았으며

이 프로젝트에서는 onCreate, onStartCommand, onDestroy를 오버라이드 했다.

Intent객체를 통해 getExtras()로 데이터를 받는것은 Activity호출과 다를게 없다.

이 후 Service에서 Intent객체를 통해 MainActivit.java에 데이터를 넘겨주게 될 경우를 살펴보자.

```
//메인액티비티에 인텐트 객체를 보낸다.
        Intent showIntent = new Intent(getApplication(), MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name);

        startActivity(showIntent);

```

.addFlags를 이용해 MainActivity.class를 호출할 때 flag를 설정해 준다.

startActivity()를 이용해 호출한다.






<img src ="/PracticeImage/20200709 Menu 01.PNG" width="400px" height="100px"></img>

