package com.keating.vivian.omgandroid;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Rainbow on 11/10/15.
 */
public class IntroSignifierView extends View {

    private Paint mArrowPaint;
    private int mRadius = 300;

    private SVGHelper.SvgPath mSignifierPath;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    private int mArrowLength = 300;  //32
    private int mArrowHeight = 500; //18


    private int mDuration = 32000;

    private float mWait;


    public float getWait() {
        return mWait;
    }

    public void setWait(float wait) {
        mWait = wait;
        mSignifierPath.paint.setPathEffect(createConcaveArrowPathEffect(mSignifierPath.length, mWait, 0.0f));

        invalidate();
    }

    private ObjectAnimator mWaitAnimator;


    public IntroSignifierView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public IntroSignifierView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }
    private void init() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(64.0f);
        mPaint.setColor(getResources().getColor(R.color.paintColor));

        setLayerType(LAYER_TYPE_SOFTWARE, null);

        createSignifierPath();

        mWaitAnimator = ObjectAnimator.ofFloat(this, "wait", 2.0f, 0.0f).setDuration(mDuration);
        mWaitAnimator.setRepeatMode(ObjectAnimator.RESTART);
        mWaitAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        mWaitAnimator.setInterpolator(new LinearInterpolator());
        mWaitAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.translate(0.0f,  - mRadius * 3.0f);
        canvas.translate(getWidth() / 2.0f, -getHeight() /2.0f);
        canvas.drawPath(mSignifierPath.path, mSignifierPath.paint);

    }

    private void createSignifierPath() {
        Paint paint = new Paint(mPaint);
        paint.setStrokeWidth(paint.getStrokeWidth() * 4.0f);

        Path p = new Path();
        p.moveTo(0.0f, 0.0f);
        p.lineTo(0.0f, mRadius * 6.0f);

        mSignifierPath = new SVGHelper.SvgPath(p, paint);
        mArrowPaint = new Paint(mSignifierPath.paint);

    }

    private PathEffect createConcaveArrowPathEffect(float pathLength, float phase, float offset) {
        return new PathDashPathEffect(makeConcaveArrow(mArrowLength, mArrowHeight), mArrowLength * 1.2f,
                Math.max(phase * pathLength, offset), PathDashPathEffect.Style.ROTATE);
    }

    private static Path makeConcaveArrow(float length, float height) {
        Path p = new Path();
        p.moveTo(-2.0f, -height / 2.0f);
        p.lineTo(length - height / 4.0f, -height / 2.0f);
        p.lineTo(length, 0.0f);
        p.lineTo(length - height / 4.0f, height / 2.0f);
        p.lineTo(-2.0f, height / 2.0f);
        p.lineTo(-2.0f + height / 4.0f, 0.0f);
        p.close();
        return p;
    }



}
