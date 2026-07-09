package X;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.InputStream;

public final class k8 {
    public String b;
    public String c;
    public String d;
    public Runnable e;
    public String a = "ic_mod_update";
    public long f = 0;

    public final  void a(LinearLayout linearLayout, Dialog dialog, View view) {
        try {
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
        }
        a(dialog, linearLayout);
    }

    public final void b(final int i) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                this.f$0.a(i);
            }
        }, i == 0 ? this.f : 1000L);
    }

    public final void a(int i) {
        Activity activity = (Activity) i2.f.get();
        if (activity != null && !activity.isFinishing()) {
            a(activity);
        } else if (i < 20) {
            b(i + 1);
        }
    }

    public static  boolean a(LinearLayout linearLayout, Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(dialog, linearLayout);
        return true;
    }

    public static void a(Activity activity, final LinearLayout linearLayout, final Dialog dialog) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(activity);
        final int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        final float scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 4.0f;
        final float[] fArr = {0.0f};
        final float[] fArr2 = {0.0f};
        final boolean[] zArr = {false};
        final VelocityTracker[] velocityTrackerArr = {null};
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return k8.a(linearLayout, fArr, fArr2, zArr, velocityTrackerArr, scaledTouchSlop, scaledMinimumFlingVelocity, dialog, view, motionEvent);
            }
        });
    }

    public static  boolean a(View view, float[] fArr, float[] fArr2, boolean[] zArr, VelocityTracker[] velocityTrackerArr, int i, float f, Dialog dialog, View view2, MotionEvent motionEvent) {
        float yVelocity;
        switch (motionEvent.getActionMasked()) {
            case 0:
                view.animate().cancel();
                fArr[0] = motionEvent.getRawY();
                fArr2[0] = view.getTranslationY();
                zArr[0] = false;
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                velocityTrackerArr[0] = velocityTrackerObtain;
                velocityTrackerObtain.addMovement(motionEvent);
                return true;
            case 1:
            case 3:
                VelocityTracker velocityTracker = velocityTrackerArr[0];
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.addMovement(motionEvent);
                    velocityTrackerArr[0].computeCurrentVelocity(1000);
                    yVelocity = velocityTrackerArr[0].getYVelocity();
                    velocityTrackerArr[0].recycle();
                    velocityTrackerArr[0] = null;
                }
                boolean z = zArr[0];
                if (z && motionEvent.getActionMasked() == 1) {
                    if (view.getTranslationY() <= view.getHeight() * 0.35f && yVelocity <= f) {
                        view.animate().translationY(0.0f).setDuration(200L).start();
                        return z;
                    }
                    a(dialog, view);
                }
                return z;
            case 2:
                float rawY = motionEvent.getRawY() - fArr[0];
                if (!zArr[0] && rawY > i) {
                    zArr[0] = true;
                }
                if (zArr[0]) {
                    view.setTranslationY(Math.max(0.0f, fArr2[0] + rawY));
                    VelocityTracker velocityTracker2 = velocityTrackerArr[0];
                    if (velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public static void a(final Dialog dialog, View view) {
        try {
            view.animate().translationY(view.getHeight()).setDuration(220L).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    k8.a(dialog);
                }
            }).start();
        } catch (Throwable th) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Throwable th2) {
            }
        }
    }

    public static void a(Dialog dialog) {
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Throwable th) {
        }
    }

    public final void a(Activity activity) {
        int color;
        try {
            boolean z = (activity.getResources().getConfiguration().uiMode & 48) == 32;
            try {
                if (l8.a().d()) {
                    color = hd.a();
                } else {
                    color = Color.parseColor("#FE2B54");
                }
            } catch (Throwable th) {
            }
            int i = z ? -14935010 : -1;
            int i2 = z ? -1 : -15329245;
            int i3 = z ? -6579293 : -9210757;
            int i4 = z ? -12961220 : -2434337;
            final LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(1);
            float fA = g5.a(20.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setPadding(g5.a(20.0f), g5.a(10.0f), g5.a(20.0f), g5.a(22.0f));
            linearLayout.setClickable(true);
            View view = new View(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g5.a(38.0f), g5.a(4.0f));
            layoutParams.gravity = 1;
            layoutParams.bottomMargin = g5.a(18.0f);
            view.setLayoutParams(layoutParams);
            float fA2 = g5.a(2.0f);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(i4);
            gradientDrawable2.setCornerRadius(fA2);
            view.setBackground(gradientDrawable2);
            linearLayout.addView(view);
            ImageView imageView = new ImageView(activity);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(g5.a(64.0f), g5.a(64.0f));
            layoutParams2.gravity = 1;
            layoutParams2.bottomMargin = g5.a(16.0f);
            imageView.setLayoutParams(layoutParams2);
            BitmapDrawable bitmapDrawableA = a(activity, this.a);
            if (bitmapDrawableA != null) {
                imageView.setImageDrawable(bitmapDrawableA);
            }
            linearLayout.addView(imageView);
            TextView textView = new TextView(activity);
            textView.setText(this.b);
            textView.setGravity(17);
            textView.setTextSize(2, 18.0f);
            textView.setTextColor(i2);
            textView.setTypeface(Typeface.create("sans-serif-medium", 0));
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(textView);
            String str = this.c;
            if (str != null && !str.isEmpty()) {
                TextView textView2 = new TextView(activity);
                textView2.setText(this.c);
                textView2.setGravity(17);
                textView2.setTextSize(2, 13.5f);
                textView2.setTextColor(i3);
                textView2.setLineSpacing(g5.a(2.0f), 1.0f);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = g5.a(6.0f);
                layoutParams3.leftMargin = g5.a(8.0f);
                layoutParams3.rightMargin = g5.a(8.0f);
                textView2.setLayoutParams(layoutParams3);
                linearLayout.addView(textView2);
            }
            TextView textView3 = new TextView(activity);
            textView3.setText(this.d);
            textView3.setGravity(17);
            textView3.setTextColor(-1);
            textView3.setTextSize(2, 15.0f);
            textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, g5.a(50.0f));
            layoutParams4.topMargin = g5.a(24.0f);
            textView3.setLayoutParams(layoutParams4);
            float fA3 = g5.a(13.0f);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(color);
            gradientDrawable3.setCornerRadius(fA3);
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setColor(-1);
            gradientDrawable4.setCornerRadius(fA3);
            textView3.setBackground(new RippleDrawable(ColorStateList.valueOf(872415231), gradientDrawable3, gradientDrawable4));
            final Dialog dialog = new Dialog(activity);
            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view2) {
                    this.f$0.a(linearLayout, dialog, view2);
                }
            });
            linearLayout.addView(textView3);
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 80));
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view2) {
                    k8.a(dialog, linearLayout);
                }
            });
            dialog.requestWindowFeature(1);
            dialog.setContentView(frameLayout);
            dialog.setCancelable(false);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public final boolean onKey(DialogInterface dialogInterface, int i5, KeyEvent keyEvent) {
                    return k8.a(linearLayout, dialog, dialogInterface, i5, keyEvent);
                }
            });
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                attributes.gravity = 80;
                attributes.dimAmount = 0.55f;
                window.setAttributes(attributes);
                window.addFlags(2);
                window.setWindowAnimations(0);
            }
            a(activity, linearLayout, dialog);
            linearLayout.getViewTreeObserver().addOnPreDrawListener(new j8(linearLayout));
            dialog.show();
        } catch (Throwable th2) {
            int i5 = g5.a;
        }
    }

    public static BitmapDrawable a(Activity activity, String str) {
        try {
            InputStream inputStreamOpen = activity.getAssets().open("mod_icons/" + str + ".png");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                BitmapDrawable bitmapDrawable = bitmapDecodeStream != null ? new BitmapDrawable(activity.getResources(), bitmapDecodeStream) : null;
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return bitmapDrawable;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            return null;
        }
    }
}
