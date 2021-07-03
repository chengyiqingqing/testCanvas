package com.sww.testcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                ScreenSizeCaculation.dip2px(this, 200));
        layoutParams.topMargin = ScreenSizeCaculation.dip2px(this, 400);
        BottomView bottomView = new BottomView(this);
        ((FrameLayout) findViewById(R.id.rootView)).addView(bottomView, layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}