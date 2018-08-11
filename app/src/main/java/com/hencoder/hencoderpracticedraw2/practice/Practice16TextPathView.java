package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice16TextPathView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path textPath = new Path();
    private String text = "Hello HenCoder";
    private int mWidth;
    private int mHeight;

    public Practice16TextPathView(Context context) {
        super(context);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(120);
        paint.setTextAlign(Paint.Align.CENTER);
        pathPaint.setTextSize(120);
        pathPaint.setTextAlign(Paint.Align.CENTER);
        pathPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text, mWidth / 2, 200, paint);
        canvas.save();

        // 使用 Paint.getTextPath() 来获取文字的 Path
        paint.getTextPath(text, 0, text.length(), mWidth / 2, 300, textPath);
        Matrix matrix = new Matrix();
        matrix.setTranslate(0, 100);
        textPath.transform(matrix);
        canvas.drawPath(textPath, pathPaint);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }
}
