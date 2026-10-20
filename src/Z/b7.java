package Z;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.util.ArrayList;

public class b7 extends BaseActivity {
    public static final int f = Color.parseColor("#F5F5F5");
    public static final int g = Color.parseColor("#1E1E1E");
    public static final int h = Color.parseColor("#858585");
    public boolean a;
    public int b;
    public int c;
    public LinearLayout d;
    public String e;

    public final LinearLayout a(final i7 i7Var) {
        String str;
        String str2;
        String str3;
        String str4;
        int color;
        boolean zEquals = i7Var.a.equals(this.e);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(60.0f));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                b7.this.a(i7Var, view);
            }
        });
        ImageView imageView = new ImageView(this);
        Drawable drawableA = j7.a(this, i7Var);
        if (drawableA != null) {
            imageView.setImageDrawable(drawableA);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(44.0f), a(44.0f));
        layoutParams.topMargin = a(8.0f);
        layoutParams.bottomMargin = a(8.0f);
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(i7Var.a());
        textView.setTextSize(2, 16.0f);
        (textView).setTypeface(android.graphics.Typeface.create("sans-serif-medium", 0));
        textView.setTextColor(this.a ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.leftMargin = a(14.0f);
        linearLayout.addView(textView, layoutParams2);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(hi.a((Context) this, (zEquals ? "ic_radio_active" : "ic_radio_inactive")));
        if (zEquals) {
            color = ac.a().g() ? zh.a() : Color.parseColor("#FE2B54");
        } else {
            color = Color.parseColor((this.a ? "#555555" : "#BBBBBB"));
        }
        imageView2.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        return linearLayout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ac.a((Context) this);
        this.a = (getResources().getConfiguration().uiMode & 48) == 32;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.b = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        int identifier2 = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.c = identifier2 > 0 ? getResources().getDimensionPixelSize(identifier2) : 0;
        this.e = j7.a();
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i = !this.a ? 9984 : 1792;
        if (!this.a) {
            i |= 16;
        }
        window.getDecorView().setSystemUiVisibility(i);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(this.a ? -16777216 : f);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setPadding(0, a(56.0f) + this.b, 0, this.c);
        scrollView.setClipToPadding(false);
        frameLayout.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(a(8.0f), 0, a(8.0f), a(20.0f) + this.c);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(this);
        textView.setText(k7.a("icon_picker_title"));
        textView.setTextSize(2, 28.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.topMargin = a(8.0f);
        layoutParams.bottomMargin = a(14.0f);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.d = linearLayout2;
        linearLayout2.setOrientation(1);
        linearLayout.addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundColor(this.a ? -16777216 : f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        frameLayout.addView(linearLayout3, layoutParams2);
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, a(56.0f) + this.b));
        linearLayout3.addView(frameLayout2);
        TextView textView2 = new TextView(this);
        textView2.setText(k7.a("icon_picker_title"));
        textView2.setTextSize(2, 16.0f);
        (textView2).setTypeface(android.graphics.Typeface.create("sans-serif", 1));
        textView2.setTextColor(this.a ? -1 : -16777216);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 49;
        layoutParams3.topMargin = a(16.0f) + this.b;
        textView2.setLayoutParams(layoutParams3);
        frameLayout2.addView(textView2);
        a(frameLayout);
        a();
        setContentView(frameLayout);
    }

    public final void a(i7 i7Var, View view) {
        if (i7Var.a.equals(this.e)) {
            finish();
            return;
        }
        String str = i7Var.a;
        this.e = str;
        j7.a((Context) this, str);
        setResult(-1);
        a();
    }

    public final void a() {
        LinearLayout linearLayout = this.d;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        ArrayList arrayListA = j7.a((Context) this);
        int i = 0;
        if (arrayListA.isEmpty()) {
            LinearLayout linearLayout2 = this.d;
            TextView textView = new TextView(this);
            textView.setText(k7.a("icon_picker_empty"));
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(h);
            textView.setGravity(1);
            textView.setPadding(0, a(18.0f), 0, a(4.0f));
            linearLayout2.addView(textView);
            return;
        }
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.a ? g : -1);
        gradientDrawable.setCornerRadius(a(12.0f));
        linearLayout3.setBackground(gradientDrawable);
        linearLayout3.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        int size = arrayListA.size();
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            linearLayout3.addView(a((i7) obj));
        }
        this.d.addView(linearLayout3);
    }

    public final void a(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(hi.a((Context) this, "ic_back"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                b7.this.a(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams.leftMargin = a(16.0f);
        layoutParams.topMargin = a(16.0f) + this.b;
        layoutParams.gravity = 51;
        frameLayout.addView(imageView, layoutParams);
    }

    public final  void a(View view) {
        finish();
    }

    public final int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }
}
