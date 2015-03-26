# FlowLayoutDemo
流式布局例子。onLayout实战。  

![](https://github.com/passionli/FlowLayoutDemo/blob/master/device-2015-03-26-150036.png)
# Usage
<pre><code>
        mFlowLayout = (FlowLayout) findViewById(R.id.flowLayout);
        for (final String str : mData) {
            TextView textView = (TextView) getLayoutInflater().inflate(R.layout.tag_text_view, null);
            textView.setText(str);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String keywords = str;
                    Toast.makeText(MainActivity.this, keywords, Toast.LENGTH_SHORT).show();
                }
            });
            FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(TAG_MARGIN, TAG_MARGIN, TAG_MARGIN, TAG_MARGIN);
            textView.setPadding(TAG_PADDING, TAG_PADDING, TAG_PADDING, TAG_PADDING);
            mFlowLayout.addView(textView, params);
        }
</code></pre>
