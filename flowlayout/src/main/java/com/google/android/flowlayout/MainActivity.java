package com.google.android.flowlayout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private String[] mData = {"快赚", "快来赚钱", "www.kuailaizhuanqian.com", "手机导航", "文件管理", "导航软件", "3D赛车", "团购", "卡牌", "Root", "桌面", "疯狂猜图"};
    private FlowLayout mFlowLayout;
    private static final int TAG_MARGIN = 10;
    private static final int TAG_PADDING = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlowLayout = (FlowLayout) findViewById(R.id.flowLayout);
        mFlowLayout.removeAllViews();
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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
