package com.hy.powerplatform.my_utils.myViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;

public class CircleView extends TextView {

    private Paint mBgPaint = new Paint();
    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBgPaint.setColor(Color.WHITE);
        mBgPaint.setAntiAlias(true);
    }
    public CircleView(Context context) {
        super(context);
        mBgPaint.setColor(Color.WHITE);
        mBgPaint.setAntiAlias(true);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        setMeasuredDimension(max, max);
    }
    @Override
    public void setBackgroundColor(int color) {
        mBgPaint.setColor(color);
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(getWidth()/2, getHeight()/2, Math.max(getWidth(), getHeight())/2, mBgPaint);
        super.draw(canvas);
    }
}
