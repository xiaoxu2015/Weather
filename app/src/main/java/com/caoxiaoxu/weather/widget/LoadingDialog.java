package com.caoxiaoxu.weather.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.caoxiaoxu.weather.R;

import java.util.ArrayList;

public class LoadingDialog implements ValueAnimator.AnimatorUpdateListener {

    private final ValueAnimator valueAnimator;
    public PopupWindow mPopupWindow;
    private ArrayList<ImageView> imageViews = new ArrayList<>(4);

    private static final float OFFSET = 0.25f;
    private int padding = 0;
    private Activity activity;

    public LoadingDialog(Activity context) {
        activity = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.progress_view, null);

        for (int i = 0; i < 4; i++) {
            imageViews.add((ImageView) view.getChildAt(i + 1));
            final Drawable wrappedDrawable = DrawableCompat.wrap(imageViews.get(i).getDrawable());
            DrawableCompat.setTintList(wrappedDrawable, ColorStateList.valueOf(Color.BLACK));
            imageViews.get(i).setImageDrawable(wrappedDrawable);
        }
        valueAnimator = ValueAnimator.ofFloat(-1f, 9f);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(this);

        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setFocusable(true);
    }

    public void show() {
        try {
            startAnim();
            mPopupWindow.showAtLocation(activity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startAnim() {
        if (padding > 0) {
            valueAnimator.start();
        } else {
            imageViews.get(0).getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    imageViews.get(0).getViewTreeObserver().removeOnPreDrawListener(this);
                    valueAnimator.start();
                    padding = (int) (imageViews.get(0).getWidth() * 0.1);
                    return false;
                }
            });
        }
    }

    public void dismiss() {
        if (mPopupWindow.isShowing()) {
            try {
                mPopupWindow.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stopAnimation();
        }
    }

    private void stopAnimation() {
        valueAnimator.cancel();
    }

    public boolean isShowing() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float destValue = ((Float) animation.getAnimatedValue());
        float value;
        if (destValue <= 4 && destValue >= 0) {
            for (int i = 0; i < imageViews.size(); i++) {
                if (1 + (i - destValue) / 2 > 1) {
                    value = 1f;
                } else if (1 + (i - destValue) / 2 <= 0.5) {
                    value = 0.5f;
                } else {
                    value = 1 + (i - destValue) / 2;
                }
                int paddingValue = (int) (padding * (1 - value) * 2);
                imageViews.get(i).setPadding(paddingValue, paddingValue, paddingValue, paddingValue);
                imageViews.get(i).setAlpha(value);
                imageViews.get(i).postInvalidate();
            }
        } else if (destValue > 5) {
            destValue -= 5;
            for (int i = 0; i < imageViews.size(); i++) {
                if ((destValue - i + 1) / 2 < 0.5f) {
                    value = 0.5f;
                } else if ((destValue - i + 1) / 2 > 1) {
                    value = 1f;
                } else {
                    value = (destValue - i + 1) / 2;
                }
                int paddingValue = (int) (padding * (1 - value) * 2);
                imageViews.get(i).setPadding(paddingValue, paddingValue, paddingValue, paddingValue);
                imageViews.get(i).setAlpha(value);
                imageViews.get(i).postInvalidate();
            }
        }
    }
}
