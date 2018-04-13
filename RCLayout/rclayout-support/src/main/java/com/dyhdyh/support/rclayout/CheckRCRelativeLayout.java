package com.dyhdyh.support.rclayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Checkable;

import com.gcssloop.widget.RCRelativeLayout;

/**
 * 有Check状态的RCRelativeLayout
 *
 * @author dengyuhan
 *         created 2018/4/13 16:55
 */
public class CheckRCRelativeLayout extends RCRelativeLayout implements Checkable {
    private final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};

    private ColorStateList mStrokeColorStateList;
    private boolean mChecked;
    private OnCheckedChangeListener mOnCheckedChangeListener;

    public CheckRCRelativeLayout(Context context) {
        this(context, null);
    }

    public CheckRCRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CheckRCRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CheckRCRelativeLayout);
        mChecked = a.getBoolean(R.styleable.CheckRCRelativeLayout_android_checked, false);
        mStrokeColorStateList = a.getColorStateList(R.styleable.CheckRCRelativeLayout_stroke_color);
        a.recycle();

        setChecked(mChecked);
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

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mStrokeColorStateList != null && mStrokeColorStateList.isStateful()) {
            int stateColor = mStrokeColorStateList.getColorForState(getDrawableState(), mRCHelper.mStrokeColor);

            setStrokeColor(stateColor);
        }
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();
            if (mOnCheckedChangeListener != null) {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            }
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }


    public interface OnCheckedChangeListener {

        void onCheckedChanged(CheckRCRelativeLayout layout, boolean isChecked);
    }
}
