package com.dyhdyh.support.rclayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.gcssloop.widget.RCRelativeLayout;

/**
 * 有Check状态的RCRelativeLayout
 *
 * @author dengyuhan
 *         created 2018/4/13 16:55
 */
public class CheckRCRelativeLayout extends RCRelativeLayout {

    public CheckRCRelativeLayout(Context context) {
        super(context);
    }

    public CheckRCRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckRCRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        mRCHelper.onSizeChanged(this, getMeasuredWidth(), getMeasuredHeight());
        super.dispatchDraw(canvas);
    }

    public void setClipBackground(boolean clipBackground) {
        mRCHelper.mClipBackground = clipBackground;
        invalidate();
    }

    public void setRoundAsCircle(boolean roundAsCircle) {
        mRCHelper.mRoundAsCircle = roundAsCircle;
        invalidate();
    }

    public void setTopLeftRadius(int topLeftRadius) {
        mRCHelper.radii[0] = topLeftRadius;
        mRCHelper.radii[1] = topLeftRadius;
        invalidate();
    }

    public void setTopRightRadius(int topRightRadius) {
        mRCHelper.radii[2] = topRightRadius;
        mRCHelper.radii[3] = topRightRadius;
        invalidate();
    }

    public void setBottomLeftRadius(int bottomLeftRadius) {
        mRCHelper.radii[4] = bottomLeftRadius;
        mRCHelper.radii[5] = bottomLeftRadius;
        invalidate();
    }

    public void setBottomRightRadius(int bottomRightRadius) {
        mRCHelper.radii[6] = bottomRightRadius;
        mRCHelper.radii[7] = bottomRightRadius;
        invalidate();
    }

    public void setStrokeWidth(int strokeWidth) {
        mRCHelper.mStrokeWidth = strokeWidth;
        invalidate();
    }

    public void setStrokeColor(int strokeColor) {
        mRCHelper.mStrokeColor = strokeColor;
        invalidate();
    }

}
