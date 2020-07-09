Hustar_Android_Class 20200709
=====================

# Menu, ActionBar, ViewPager

## Menu

1-1. res마우스 우클릭 -> Directory추가 -> menu
1-2. menu디렉토리 -> menu_main.xml파일 추가를 하면 자동으로 menu layout으로 추가가된다.

2-1. menu_main.xml에 각각의 item을 추가하면 다음과 같은 모양으로 추가가된다.
```
<item android:id="@+id/menu_refresh"
        android:title="새로고침"
        android:icon="@drawable/refresh"
        app:showAsAction="always"
        />

    <item android:id="@+id/menu_search"
        android:title="검색"
        app:showAsAction="always|withText"
        app:actionLayout="@layout/search_layout"
        />

    <item android:id="@+id/menu_setting"
        android:title="설정"
        android:icon="@drawable/setting"
        app:showAsAction="always"
        />
```

<img src ="/PracticeImage/20200709 Menu 01.PNG" width="400px" height="100px"></img>

2-2. 
```
<item android:id="@+id/menu_search"
        android:title="검색"
        app:showAsAction="always|withText"
        app:actionLayout="@layout/search_layout"
        />
```
해당 코드는 icon으로 하는것이 아니다
```
        app:actionLayout="@layout/search_layout"
```
로 인해 layout을 넣을 수 있다. (search_layout.xml)

3. MainActivity.java
```
@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        View v = menu.findItem((R.id.menu_search)).getActionView();

        if(v != null)
        {
            final EditText editText = v.findViewById(R.id.editText);
            if(editText != null)
            {
                editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_refresh :
                Toast.makeText(this, "menu_refresh", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_search :
                Toast.makeText(this, "menu_search", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_setting :
                Toast.makeText(this, "menu_setting", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
```

onCreateOptionsMenu(); 와 onOptionsItemSelected();를 오버라이드 한다

onCreateOptionsMenu()함수에서
```
getMenuInflater().inflate(R.menu.menu_main, menu);
```
코드로 acitivt_main.xml에 menu_main.xml을 menu로 적용한다.

```
View v = menu.findItem((R.id.menu_search)).getActionView();
```
해당 코드는 mene_main.xml파일의 리소스인 R.id.menu_search를 받아올 수 있다.
menu_search는 layout이므로 View타입으로 받아오며 해당 layout의 EditText를 control 할 수 있다.

onOptionsItemSelected();함수는 매개변수 MenuItem을 통해 어떤 item이 선택 되었는지 여부를 판단할 수 있다.


## ActionBar

1. activity_main.xml와 이미지.
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    
    <androidx.coordinatorlayout.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.google.android.material.appbar.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

            <androidx.appcompat.widget.Toolbar
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@color/colorPrimaryDark"
                android:theme="@style/ThemeOverlay.AppCompat.Dark"
                android:elevation="1dp"
                android:id="@+id/toolbar">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:id="@+id/titleText"
                    android:textAppearance="@style/TextAppearance.AppCompat.Title"
                    android:text="타이틀"/>

            </androidx.appcompat.widget.Toolbar>

            <com.google.android.material.tabs.TabLayout
                android:id="@+id/tabs"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:tabMode="fixed"
                app:tabGravity="fill"
                app:tabTextColor="@color/colorAccent"
                android:elevation="1dp"
                android:background="@android:color/background_light"
                />
        </com.google.android.material.appbar.AppBarLayout>

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior"
            android:id="@+id/container">

        </FrameLayout>

    </androidx.coordinatorlayout.widget.CoordinatorLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

<img src ="/PracticeImage/20200709 Menu 02.PNG" width="500px" height="500px"></img>

2. MainActivity.java
```
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        //붙이는 역할
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment1).commit();

        //tab인플레이션 및 tab추가
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position)
                {
                    case 0:
                        fragmentManager.beginTransaction().replace(R.id.container, fragment1).commit();
                        break;

                    case 1:
                        fragmentManager.beginTransaction().replace(R.id.container, fragment2).commit();
                        break;

                    case 2:
                        fragmentManager.beginTransaction().replace(R.id.container, fragment3).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
```

toolbar는 실습용으로 만들었기 때문에 없애도 된다.

Fragment를 3개 만들고 각각 객체생성을 하였다.
Fragment를 사용하기 위해서는 항상 FragmentManager를 사용해야 한다.


getSupportFragmentManager();는 return 타입이 FragmentManager이다. 사용법은 
```
getSupportFragmentManager..beginTransaction()
```
을 써야하며 뒤에는 .replace() , .remove(), .add()등을 사용할 수 있으며 마지막에는 꼭 .commit()을 붙여야 한다.


TabLayout의 객체인 tabs는 인플레이션 후 다음과 같은 리스너를 등록하여 사용할 수 있다.
```
tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position)
                {
                    case 0:
                        fragmentManager.beginTransaction().replace(R.id.container, fragment1).commit();
                        break;

                    case 1:
                        fragmentManager.beginTransaction().replace(R.id.container, fragment2).commit();
                        break;

                    case 2:
                        fragmentManager.beginTransaction().replace(R.id.container, fragment3).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
```

<img src ="/PracticeImage/20200709 Menu 02.PNG" width="300px" height="500px"></img>

## ViewPager

1. activity_main.xml
```
<androidx.viewpager.widget.ViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

안드로이드 스튜디오에서 다운받은 버전은 <androidx.viewpager2.widget.ViewPager2 였지만 
<androidx.viewpager.widget.ViewPager을 사용하였다.


2. MainActivity.java
```
public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(3);

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addItem(fragment1);
        adapter.addItem(fragment2);
        adapter.addItem(fragment3);

        viewPager.setAdapter(adapter);
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter
    {

        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }

        public void addItem(Fragment fragment)
        {
            items.add(fragment);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}
```

```
viewPager.setOffscreenPageLimit(3);
```
을 사용하여 페이지 갯수를 정한다.

FragmentStatePagerAdapter를 extends받은 MyPagerAdapter클래스를 정의하여 adapter객체를 생성한다.

```
viewpager.setAdapter(adapter);
```
를 사용해 viewPgaer에 어뎁터를 등록한다.





