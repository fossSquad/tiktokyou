package com.windukk.mod.hooks;
import Z.*;


import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
public abstract class EdgeSpeedupHooks {
    public static void a(jc jcVar, LinearLayout linearLayout, int i, float f) {
        if (jcVar == null || linearLayout == null) {
            return;
        }
        try {
            jcVar.a = linearLayout;
            jcVar.c = Math.max(0.0f, f);
            a(linearLayout, jcVar);
            linearLayout.getViewTreeObserver().addOnPreDrawListener(new hc(linearLayout, jcVar));
            a(jcVar.getWindow(), i, 0.0f);
            a(linearLayout);
            linearLayout.addOnAttachStateChangeListener(new gc(jcVar, i, 0.0f));
        } catch (Throwable th) {
            String strDecrypt = "Sheet window bind failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static FrameLayout a(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setFitsSystemWindows(false);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (onClickListener != null) {
            frameLayout.setOnClickListener(onClickListener);
        }
        linearLayout.setClickable(true);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 80));
        return frameLayout;
    }

    public static void a(final jc jcVar, float f, long j, TimeInterpolator timeInterpolator, Runnable runnable) {
        ValueAnimator valueAnimator = jcVar.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(jcVar.d, f);
        valueAnimatorOfFloat.setDuration(j);
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                EdgeSpeedupHooks.a(jcVar, ((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.addListener(new ic(jcVar, runnable));
        jcVar.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
    }

    public static void a(jc jcVar, float f) {
        View view = jcVar.a;
        if (view == null) {
            return;
        }
        jcVar.d = f;
        int iMax = Math.max(1, view.getHeight());
        if (f >= 0.0f) {
            view.setTranslationY(f);
            view.setScaleY(1.0f);
        } else {
            float f2 = view.getResources().getDisplayMetrics().density * 28.0f;
            float fExp = (1.0f - ((float) Math.exp(f / (2.0f * f2)))) * f2;
            view.setTranslationY(0.0f);
            float f3 = iMax;
            view.setPivotY(f3);
            view.setScaleY((fExp / f3) + 1.0f);
        }
        if (jcVar.b != null) {
            jcVar.b.setAlpha(Math.round(jcVar.c * 255.0f * (1.0f - Math.max(0.0f, Math.min(1.0f, f / iMax)))));
        }
    }

    public static void a(final View view, final jc jcVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        final int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        final float scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 4.0f;
        final float f = view.getResources().getDisplayMetrics().density * 40.0f;
        final float[] fArr = {0.0f};
        final float[] fArr2 = {0.0f};
        final boolean[] zArr = {false};
        final boolean[] zArr2 = {false};
        final VelocityTracker[] velocityTrackerArr = {null};
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return EdgeSpeedupHooks.a(jcVar, f, zArr, zArr2, fArr, fArr2, velocityTrackerArr, scaledTouchSlop, view, scaledMinimumFlingVelocity, view2, motionEvent);
            }
        });
    }

    public static boolean a(jc jcVar, float f, boolean[] zArr, boolean[] zArr2, float[] fArr, float[] fArr2, VelocityTracker[] velocityTrackerArr, int i, View view, float f2, View view2, MotionEvent motionEvent) {
        float yVelocity;
        boolean z = false;
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (!jcVar.f && motionEvent.getY() <= f) {
                    ValueAnimator valueAnimator = jcVar.g;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    zArr[0] = true;
                    zArr2[0] = false;
                    fArr[0] = motionEvent.getRawY();
                    fArr2[0] = jcVar.d;
                    VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                    velocityTrackerArr[0] = velocityTrackerObtain;
                    if (velocityTrackerObtain != null) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                        velocityTrackerObtain.addMovement(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (view2.getParent() != null) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                zArr[0] = false;
                return false;
            case 1:
            case 3:
                if (!zArr[0]) {
                    return false;
                }
                zArr[0] = false;
                VelocityTracker velocityTracker = velocityTrackerArr[0];
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                    motionEventObtain2.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                    velocityTracker.addMovement(motionEventObtain2);
                    motionEventObtain2.recycle();
                    velocityTrackerArr[0].computeCurrentVelocity(1000);
                    yVelocity = velocityTrackerArr[0].getYVelocity();
                    velocityTrackerArr[0].recycle();
                    velocityTrackerArr[0] = null;
                }
                boolean z2 = motionEvent.getActionMasked() == 1;
                if (jcVar.d > view.getHeight() * 0.3f && yVelocity > (-f2)) {
                    z = true;
                }
                if (z2 && jcVar.e && (z || yVelocity > f2)) {
                    jcVar.dismiss();
                } else if (jcVar.d != 0.0f) {
                    a(jcVar, 0.0f, 320L, new OvershootInterpolator(1.5f), null);
                }
                return true;
            case 2:
                if (!zArr[0]) {
                    return false;
                }
                VelocityTracker velocityTracker2 = velocityTrackerArr[0];
                if (velocityTracker2 != null) {
                    MotionEvent motionEventObtain3 = MotionEvent.obtain(motionEvent);
                    motionEventObtain3.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                    velocityTracker2.addMovement(motionEventObtain3);
                    motionEventObtain3.recycle();
                }
                float rawY = motionEvent.getRawY() - fArr[0];
                if (!zArr2[0]) {
                    float f3 = i;
                    if (Math.abs(rawY) > f3) {
                        zArr2[0] = true;
                        fArr[0] = (Math.signum(rawY) * f3) + fArr[0];
                        rawY = motionEvent.getRawY() - fArr[0];
                    }
                }
                if (zArr2[0]) {
                    float f4 = fArr2[0] + rawY;
                    if (!jcVar.e && f4 > 0.0f) {
                        f4 *= 0.25f;
                    }
                    a(jcVar, f4);
                }
                return true;
            default:
                return zArr[0];
        }
    }

    public static void a(Window window, int i, float f) {
        WindowInsetsController insetsController;
        if (window == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 80;
        if (f >= 0.0f) {
            attributes.dimAmount = f;
        }
        attributes.flags = (attributes.flags | (-2147483392)) & (-201327105);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
        if (f > 0.0f) {
            window.addFlags(2);
        } else if (f == 0.0f) {
            window.clearFlags(2);
        }
        View decorView = window.getDecorView();
        decorView.setFitsSystemWindows(false);
        if (i2 >= 30) {
            window.setDecorFitsSystemWindows(false);
        }
        View viewFindViewById = window.findViewById(R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setFitsSystemWindows(false);
            if (viewFindViewById instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) viewFindViewById;
                viewGroup.setClipToPadding(false);
                viewGroup.setClipChildren(false);
            }
        }
        boolean z = Color.luminance(i) > 0.5f;
        decorView.setSystemUiVisibility(z ? 1808 : 1792);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(i);
        if (i2 >= 27) {
            window.setNavigationBarDividerColor(i);
        }
        if (i2 >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        if (i2 < 30 || (insetsController = window.getInsetsController()) == null) {
            return;
        }
        insetsController.setSystemBarsAppearance(z ? 16 : 0, 16);
    }

    public static void a(View view) {
        final int paddingLeft = view.getPaddingLeft();
        final int paddingTop = view.getPaddingTop();
        final int paddingRight = view.getPaddingRight();
        final int paddingBottom = view.getPaddingBottom();
        view.setFitsSystemWindows(false);
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                return EdgeSpeedupHooks.a(paddingLeft, paddingTop, paddingRight, paddingBottom, view2, windowInsets);
            }
        });
        view.requestApplyInsets();
    }

    public static WindowInsets a(int i, int i2, int i3, int i4, View view, WindowInsets windowInsets) {
        int systemWindowInsetBottom;
        if (Build.VERSION.SDK_INT >= 30) {
            systemWindowInsetBottom = Math.max(windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom, windowInsets.getInsets(WindowInsets.Type.ime()).bottom);
        } else {
            systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        }
        view.setPadding(i, i2, i3, i4 + systemWindowInsetBottom);
        return windowInsets;
    }
}
