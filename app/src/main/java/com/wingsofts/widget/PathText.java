package com.wingsofts.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangcong on 2018/9/6
 */
public class PathText extends View {

    final  String DRAW_STR = "疯狂 Android 讲义非常好！哈哈哈哈哈哈哈嗝哈哈哈哈哈哈哈嗝";

    Paint paint;
    Path path;

    public PathText(Context context) {
        this(context, null);
    }

    public PathText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();
        //从右边开始绘制
        paint.setTextAlign(Paint.Align.RIGHT);//设置Paint文字对齐
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.FILL);

        path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制路径
        canvas.drawTextOnPath(DRAW_STR, path, 0, 0, paint);
    }
}
