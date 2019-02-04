package com.example.uitest;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

public class CustomTitleText extends AppCompatTextView {

    private final StringBuilder stringBuilder = new StringBuilder();

    public CustomTitleText(Context context) {
        super(context);
    }

    public CustomTitleText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTitleText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        return "title";
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
