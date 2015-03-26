package com.google.android.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 流式布局
 * Created by passionli on 2015/3/25.
 */
public class FlowLayout extends ViewGroup {
    private static final String TAG = FlowLayout.class.getSimpleName();

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int childCount = getChildCount();
        int right = getMeasuredWidth() - getPaddingRight();
        int sumWidth = getPaddingLeft();
        int sumHeight = getPaddingTop();
        //当前行的最大高度
        int maxRowHeight = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();
                LayoutParams params = (LayoutParams) child.getLayoutParams();
                if (sumWidth + childWidth + params.leftMargin + params.rightMargin >= right) {
                    //下一行left
                    sumWidth = getPaddingLeft();
                    //下一行top
                    sumHeight += maxRowHeight;
                    //重置下一行的最大高度为0
                    maxRowHeight = 0;
                }
                maxRowHeight = Math.max(maxRowHeight, childHeight + params.topMargin + params.bottomMargin);
                child.layout(sumWidth + params.leftMargin, sumHeight + params.topMargin, sumWidth + params.leftMargin + childWidth, sumHeight + params.topMargin
                        + childHeight);
                sumWidth += childWidth + params.leftMargin + params.rightMargin;
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }
    }

    /**
     * 考虑MARGIN时需要返回自定义的LayoutParams
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new FlowLayout.LayoutParams(getContext(), attrs);
    }
}
