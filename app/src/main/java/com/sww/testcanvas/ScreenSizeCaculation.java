package com.sww.testcanvas;

import android.content.Context;

public class ScreenSizeCaculation {

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
