package com.hr.autoresize.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import humblerookie.com.myapplication.R;

/**
 * *****************************************************
 * This is a simple resizable text view for android.
 * It uses a dummy view
 *
 * @see #measuredView
 * to calculate whether the assigned text
 * fits in.
 * It keeps reassigning the text sizes until it can find the best match.
 * @see #setResizableText(CharSequence)
 * *****************************************************
 */
public class AutoResizeTextView extends TextView {

    /**
     * This would be min text size for this widget.
     */
    private int minTextSize;

    /**
     * This would be max text size for this widget.
     */
    private int maxTextSize;
    /**
     * This would be max height for this widget.
     */
    private int maxHeight;

    /**
     * This would be max width for this widget.
     */
    private int maxWidth;

    /**
     * This would be the dummy view against which we measure
     */
    private TextView measuredView;

    public AutoResizeTextView(Context context) {

        super(context);

    }

    public AutoResizeTextView(final Context context, final AttributeSet attrs) {

        super(context, attrs);
        TypedArray resizableTypedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.AutoResizeTextView,
                0, 0);


        try {
            minTextSize = resizableTypedArray.getDimensionPixelSize(R.styleable.AutoResizeTextView_minTextSize, 0);
            maxTextSize = resizableTypedArray.getDimensionPixelSize(R.styleable.AutoResizeTextView_maxTextSize, 0);
            maxWidth = resizableTypedArray.getDimensionPixelSize(R.styleable.AutoResizeTextView_maxResizedWidth, 0);
            maxHeight = resizableTypedArray.getDimensionPixelSize(R.styleable.AutoResizeTextView_maxResizedHeight, 0);
            measuredView = new TextView(context, attrs);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(getMaxWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
            measuredView.setLayoutParams(lp);

            //Initialize with the default text
            CharSequence charSequence = getText();
            if (charSequence != null && charSequence.length() > 0) {
                setResizableText(charSequence);
            }
        } finally {
            resizableTypedArray.recycle();

        }
    }

    public AutoResizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }


    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public int getMaxWidth() {
        return maxWidth;
    }

    @Override
    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * This function needs to be used when setting text dynamically
     */
    public void setResizableText(CharSequence charSequence) {

        int currentTextSize = (int) (getTextSize() / getResources().getDisplayMetrics().density);

        measuredView.setText(charSequence);
        measuredView.setTextSize(currentTextSize);

        boolean shouldIncreaseTextSize = getMaxHeight() > getMeasuredViewHeight();
        boolean shouldExit = false;

        while ((shouldIncreaseTextSize && currentTextSize < maxTextSize && !shouldExit) || (!shouldIncreaseTextSize && currentTextSize > minTextSize && !shouldExit)) {


            if (shouldIncreaseTextSize) {

                currentTextSize++;
                measuredView.setTextSize(currentTextSize);
                if (maxHeight < getMeasuredViewHeight()) {

                    --currentTextSize;
                    shouldExit = true;
                }

            } else {
                currentTextSize--;
                measuredView.setTextSize(currentTextSize);
                if (maxHeight > getMeasuredViewHeight()) {
                    shouldExit = true;
                }

            }
        }

        setTextSize(currentTextSize);
        setText(charSequence);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private int getMeasuredViewHeight() {
        measuredView.measure(MeasureSpec.makeMeasureSpec(maxWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        return measuredView.getMeasuredHeight();
    }
}
