Hustar_Android_Class 20200702
====================

# imageView.setVisibility 실습

```
btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView1.getVisibility() == View.GONE)
                {
                    imageView1.setVisibility(View.VISIBLE);
                }
                else
                {
                    imageView1.setVisibility(View.GONE);
                }

            }
        });
```