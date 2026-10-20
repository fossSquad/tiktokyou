package Z;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Consumer;

public final class a7 {
    public final Activity a;
    public final hi b;
    public final Runnable c;
    public final Runnable d;
    public final Runnable e;

    public a7(sf sfVar, hi hiVar, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        this.a = sfVar;
        this.b = hiVar;
        this.c = runnable;
        this.d = runnable2;
        this.e = runnable3;
    }

    public final void a(View view) {
        int iA = this.b.a(16.0f);
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setPadding(iA, iA, iA, iA);
        frameLayout.setClipToPadding(false);
        final LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, this.b.a(8.0f), 0, this.b.a(8.0f));
        hi hiVar = this.b;
        int i = hiVar.b ? -13882322 : -1;
        float fA = hiVar.a(22.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClipToOutline(true);
        linearLayout.setElevation(this.b.a(12.0f));
        final PopupWindow popupWindow = new PopupWindow((View) frameLayout, -2, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(0);
        final boolean[] zArr = {false};
        final Consumer consumer = new Consumer() {
            @Override
            public final void accept(Object obj) {
                a7.a(zArr, linearLayout, popupWindow, (Runnable) obj);
            }
        };
        linearLayout.addView(a(consumer, "ic_copy", k7.a("hub_menu_my_uid"), this.c));
        linearLayout.addView(a(consumer, "ic_mod_update", k7.a("dynamic_import_signed"), this.d));
        linearLayout.addView(a(consumer, "ic_restart", k7.a("reset_settings"), new Runnable() {
            @Override
            public final void run() {
                a7.this.a();
            }
        }));
        linearLayout.addView(a(consumer, "ic_settings", k7.a("hub_menu_debug"), this.e));
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int iMax = Math.max(linearLayout.getMeasuredWidth(), this.b.a(240.0f));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(iMax, -2));
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return a7.a(linearLayout, consumer, view2, motionEvent);
            }
        });
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = ((view.getWidth() + iArr[0]) - iMax) - iA;
        int i2 = iArr[1] - iA;
        linearLayout.setPivotX(iMax);
        linearLayout.setPivotY(0.0f);
        linearLayout.setAlpha(0.0f);
        linearLayout.setScaleX(0.6f);
        linearLayout.setScaleY(0.6f);
        for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
            View childAt = linearLayout.getChildAt(i3);
            childAt.setAlpha(0.0f);
            childAt.setTranslationY(-this.b.a(8.0f));
            childAt.animate().alpha(1.0f).translationY(0.0f).setStartDelay((((long) i3) * 30) + 60).setDuration(220L).setInterpolator(new DecelerateInterpolator(2.0f)).start();
        }
        popupWindow.showAtLocation(view, 51, width, i2);
        linearLayout.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(220L).setInterpolator(new OvershootInterpolator(0.8f)).start();
    }

    public final void b(Dialog dialog, View view) {
        try {
            dialog.dismiss();
        } catch (Throwable th) {
        }
        bc bcVar = ac.c;
        if (bcVar != null) {
            int i = 0;
            HashSet hashSet = new HashSet(Arrays.asList("spoofed_device_id", "random_android_id", "launched_first_time", "startup_consent_accepted", "update_notice_snooze_until", "auto_streak_nudge_last_run_date"));
            SharedPreferences.Editor editorEdit = bcVar.a.edit();
            ArrayList arrayList = new ArrayList(bcVar.a.getAll().keySet());
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                String str = (String) obj;
                if (!hashSet.contains(str)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.commit();
            bcVar.a();
        }
        n3.a(this.a);
    }

    public static  void a(boolean[] zArr, LinearLayout linearLayout, final PopupWindow popupWindow, final Runnable runnable) {
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        linearLayout.animate().cancel();
        linearLayout.animate().alpha(0.0f).scaleX(0.85f).scaleY(0.85f).setStartDelay(0L).setDuration(130L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() {
            @Override
            public final void run() {
                a7.a(popupWindow, runnable);
            }
        }).start();
    }

    public static  void a(PopupWindow popupWindow, Runnable runnable) {
        try {
            popupWindow.dismiss();
        } catch (Throwable th) {
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static  boolean a(LinearLayout linearLayout, Consumer consumer, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (motionEvent.getX() >= linearLayout.getLeft() && motionEvent.getX() <= linearLayout.getRight() && motionEvent.getY() >= linearLayout.getTop() && motionEvent.getY() <= linearLayout.getBottom()) {
                return false;
            }
        }
        consumer.accept(null);
        return true;
    }

    public final LinearLayout a(final Consumer consumer, String str, String str2, final Runnable runnable) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(this.b.a(24.0f), 0, this.b.a(32.0f), 0);
        linearLayout.setMinimumHeight(this.b.a(56.0f));
        this.b.a(linearLayout);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, str));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setColorFilter(this.b.b ? -6579293 : -7697519, PorterDuff.Mode.SRC_IN);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b.a(24.0f), this.b.a(24.0f));
        layoutParams.rightMargin = this.b.a(20.0f);
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.a);
        textView.setText(str2);
        textView.setTextColor(this.b.e());
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(hi.f());
        textView.setSingleLine(true);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                consumer.accept(runnable);
            }
        });
        return linearLayout;
    }

    public final void a() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        hi hiVar = this.b;
        int i = hiVar.b ? -14935010 : -1;
        float fA = hiVar.a(24.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(this.b.a(22.0f), this.b.a(24.0f), this.b.a(22.0f), this.b.a(20.0f));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, "ic_restart_line"));
        imageView.setColorFilter(this.b.e(), PorterDuff.Mode.SRC_IN);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b.a(34.0f), this.b.a(34.0f));
        layoutParams.bottomMargin = this.b.a(16.0f);
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.a);
        textView.setText(k7.a("reset_settings_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(this.b.b ? -1 : Color.parseColor("#161823"));
        x5.a("+UMAsam1bzJJ0O0kV2HjEQmUOqhNpPMXfOPIfQaknxAE7SGaMUysV4sKN4BeHnen", "72YBafCi9pJ9cJhm", "aes", 1, textView);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this.a);
        textView2.setText(k7.a("reset_settings_desc"));
        textView2.setGravity(17);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(this.b.b ? -6579293 : -9210757);
        textView2.setLineSpacing(this.b.a(2.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.b.a(8.0f);
        layoutParams2.bottomMargin = this.b.a(22.0f);
        linearLayout.addView(textView2, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(0);
        final Dialog dialog = new Dialog(this.a);
        TextView textView3 = new TextView(this.a);
        textView3.setText(k7.a("filter_cancel"));
        textView3.setGravity(17);
        textView3.setTextColor(this.b.e());
        textView3.setTextSize(2, 15.0f);
        x5.a("wg9W1rWNwklpO/49j+aY9wxkoRecEyNQNHZx0o5veNTFD9r8HEITVqDjw2aVvOBp", "wfvXh0XqQ8slLES8", "aes", 1, textView3);
        int color = this.b.b ? -13882322 : Color.parseColor("#F1F1F2");
        float fA2 = this.b.a(26.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color);
        gradientDrawable2.setCornerRadius(fA2);
        textView3.setBackground(gradientDrawable2);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                a7.a(dialog, view);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, this.b.a(52.0f), 1.0f);
        layoutParams3.rightMargin = this.b.a(6.0f);
        linearLayout2.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(this.a);
        textView4.setText(k7.a("reset_settings_confirm"));
        textView4.setGravity(17);
        textView4.setTextColor(-1);
        textView4.setTextSize(2, 15.0f);
        x5.a("RJsUwIDIX85uL9a1gkPeejJlWHGl+sqivXgfpibSb8n6nciIdkoy4knTlT/b1jUk", "uKbwmFxgalSZWQGq", "aes", 1, textView4);
        this.b.getClass();
        int iA = hi.a();
        float fA3 = this.b.a(26.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(iA);
        gradientDrawable3.setCornerRadius(fA3);
        textView4.setBackground(gradientDrawable3);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                a7.this.b(dialog, view);
            }
        });
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, this.b.a(52.0f), 1.0f);
        layoutParams4.leftMargin = this.b.a(6.0f);
        linearLayout2.addView(textView4, layoutParams4);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setPadding(this.b.a(28.0f), 0, this.b.a(28.0f), 0);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 17));
        dialog.requestWindowFeature(1);
        dialog.setContentView(frameLayout);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.dimAmount = 0.55f;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
        dialog.show();
    }

    public static void a(Dialog dialog, View view) {
        try {
            dialog.dismiss();
        } catch (Throwable th) {
        }
    }
}
