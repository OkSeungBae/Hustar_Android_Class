Hustar_Android_Class 20200702
====================

# Intent로 웹 연결 및 tel연결 하기

```
public void onButtonConnectNaverClicked(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        Toast.makeText(this, "네이버로 연결합니다.", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }

    public void onButtonConnectCallClicked(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8528-1808"));
        Toast.makeText(this, "010-8528-1808로 연결합니다.", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }
```

* Uri.parse("http://...") -> 웹으로 자동 연결
* Uri.parse("tel...") -> 전화로 자동 연결