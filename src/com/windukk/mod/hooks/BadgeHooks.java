package com.windukk.mod.hooks;
import Z.*;


import android.app.Activity;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

public final class BadgeHooks implements View.OnTouchListener {
    public float a;
    public final  int b;
    public final  FrameLayout c;
    public final  int d;
    public final  Activity e;
    public final  FrameLayout f;

    public BadgeHooks(int i, FrameLayout frameLayout, int i2, Activity activity, FrameLayout frameLayout2) {
        this.b = i;
        this.c = frameLayout;
        this.d = i2;
        this.e = activity;
        this.f = frameLayout2;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.a = motionEvent.getRawY();
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 1:
            case 3:
                ViewParent parent2 = view.getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                }
                float rawY = motionEvent.getRawY() - this.a;
                if (rawY > this.d) {
                    v1.a(this.e, this.f, this.c);
                } else {
                    this.c.animate().translationY(0.0f).alpha(1.0f).setDuration(200L).start();
                    if (motionEvent.getActionMasked() == 1 && Math.abs(rawY) <= this.b && view.isClickable()) {
                        view.performClick();
                    }
                }
                return true;
            case 2:
                float rawY2 = motionEvent.getRawY() - this.a;
                Math.abs(rawY2);
                if (rawY2 > 0.0f) {
                    this.c.setTranslationY(rawY2);
                    this.c.setAlpha(Math.max(0.0f, 1.0f - (rawY2 / ((int) TypedValue.applyDimension(1, 120.0f, view.getContext().getResources().getDisplayMetrics())))));
                } else {
                    this.c.setTranslationY(rawY2 * 0.15f);
                }
                return true;
            default:
                return false;
        }
    }
}
