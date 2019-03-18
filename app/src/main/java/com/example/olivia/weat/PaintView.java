package com.example.olivia.weat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class PaintView extends View {


    private Paint PaintArc = new Paint();
    private Paint PaintText = new Paint();
    private int[] mColors = {0xFF7B68EE, 0xFFF3D7B5, 0xFF8AABF2, 0xFFDAF9CA, 0xFFC7B3E5, 0xFFCBE2F0, 0xFFDCE7E9,
            0xFFFFA3A3, 0xFFF2EADD, 0xFFDDF6F2};
//    private String str;
////
////    public void setString(String str){
////        this.str = str;
////    }


    public PaintView(Context context) {
        super(context);
        init(null, 0);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        PaintArc.setColor(Color.BLUE);
        PaintArc.setStyle(Paint.Style.FILL);
        PaintArc.setStrokeWidth(0);
        PaintArc.setAntiAlias(true);
        PaintText.setAntiAlias(true);
        PaintText.setColor(Color.WHITE);
        PaintText.setTextSize(48);
        PaintText.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int mWidth = 1000;
        int mHeight = 1000;
        String name[] ={"1","2","3","4","5","6","7","8","9","10"};
        canvas.translate(mWidth / 2, mHeight / 2);
        float r = (float) (Math.min(mWidth, mHeight) / 2 *1.1-50);
        RectF rect = new RectF(-r, -r, r, r);
        float currentStartAngle = -90;
        int num = name.length;//need to change intent length
        float angle = 360/num;
        for (int i = 0; i < num; i++) {
            PaintArc.setColor(mColors[i]);
            canvas.drawArc(rect, currentStartAngle, angle, true, PaintArc);
            float x = (float) ((r / 2 + 70) * Math.cos((currentStartAngle + (angle/2)) * Math.PI * 2 / 360));
            float y = (float) ((r / 2 + 70) * Math.sin((currentStartAngle + (angle/2)) * Math.PI * 2 / 360));
            canvas.drawText(name[i], x, y, PaintText);

            currentStartAngle += angle;
        }

    }

}
