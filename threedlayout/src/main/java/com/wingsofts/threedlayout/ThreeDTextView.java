package com.wingsofts.threedlayout;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by huangcong on 2018/9/6
 */
public class ThreeDTextView extends AppCompatTextView {

    private int mCenterX;
    private int mCenterY;

    private Camera mCamera;
    private Matrix mMatrix;
    private float mDensity;
    private float[] mValues = new float[9];

    private float mDegreeY = 30;
    private float mDegreeX = 20;

    public ThreeDTextView(Context context) {
        this(context, null);
    }

    public ThreeDTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThreeDTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mCamera = new Camera();
        mMatrix = new Matrix();
        mDensity = getResources().getDisplayMetrics().density;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2;
        mCenterY = h / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("ThreeDLayout", "===>>> onDraw");
        mMatrix.reset();
        mCamera.save();

        mCamera.rotateY(mDegreeY);
        mCamera.rotateX(mDegreeX);

        mCamera.getMatrix(mMatrix);

        // fix the Camera bug,

        mMatrix.getValues(mValues);
        mValues[6] = mValues[6] / mDensity;
        mValues[7] = mValues[7] / mDensity;
        mMatrix.setValues(mValues);
        mCamera.restore();
        mMatrix.preTranslate(-mCenterX, -mCenterY);
        mMatrix.postTranslate(mCenterX, mCenterY);

        canvas.concat(mMatrix);

        super.onDraw(canvas);
    }

}
