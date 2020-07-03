Hustar_Android_Class 20200702
====================

# textView setBackGroundColor실습

```
btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.rgb(0,100,255));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container.setBackgroundColor(Color.parseColor("#00ffff"));
            }
        });
```