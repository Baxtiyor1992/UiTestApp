package com.example.uitest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class CustomLinearLayout extends LinearLayout {

    private final StringBuilder stringBuilder = new StringBuilder();

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        stringBuilder.setLength(0);
        stringBuilder.append("onMeasure: id=")
                .append(getTag())
                .append(", widthSpec=")
                .append(getSpecName(widthMode))
                .append(", widthSize=")
                .append(widthSize)
                .append(", heightSpec=")
                .append(getSpecName(heightMode))
                .append(", heightSize=")
                .append(heightSize);

        Log.i(MainActivity.MEASURING_TAG, stringBuilder.toString());
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public Object getTag() {
        return "linearLayout";
    }

    private String getSpecName(int spec) {
        switch (spec) {
            case MeasureSpec.EXACTLY: return "Exactly";
            case MeasureSpec.AT_MOST: return "At most";
            case MeasureSpec.UNSPECIFIED: return "Unspecified";
        }
        return "Undefined";
    }
}
