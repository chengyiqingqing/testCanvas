package com.sww.testcanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class BottomView extends View {

    private static final String TAG = "BottomView";

    private Handler handler = new Handler(Looper.getMainLooper());

    private Paint mPaint;
    private String text0 = "英勇青铜00000";
    private String text1 = "英勇白银11111";
    private int status = 0;
    private int visibility = -1;

    public BottomView(Context context) {
        super(context);
        initPaint();
        setBackgroundColor(Color.parseColor("#00ff00"));
    }

    /**
     * 初始化画笔设置
     */
    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#FF4081"));
        mPaint.setTextSize(90f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: " + status);
        if (status % 2 == 0) {
            canvas.drawText(text0, 0, getHeight() / 2, mPaint);
        } else {
            canvas.drawText(text1, 0, getHeight() / 2, mPaint);
        }
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.e(TAG, "onVisibilityChanged: " + visibility);
        if (visibility == View.VISIBLE) {
//            postInvalidateDelayed(2000);
            if (status == 0) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        status++;
                        postInvalidate();
                    }
                }, 2000);
            }
        } else {
//            status--;
        }
        /*if (this.visibility != visibility) {
            this.visibility = visibility;
            if (this.visibility == View.VISIBLE) {

            }
        }*/
    }

}
