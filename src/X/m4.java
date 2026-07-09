package X;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.util.LinkedHashSet;

public class m4 extends BaseActivity {
    public static final int j = Color.parseColor("#F5F5F5");
    public static final int k = Color.parseColor("#1E1E1E");
    public static final int l = Color.parseColor("#F1F1F2");
    public static final int m = Color.parseColor("#858585");
    public static final int n = Color.parseColor("#888888");
    public boolean a;
    public int b;
    public int c;
    public final LinkedHashSet d = new LinkedHashSet();
    public l4 e;
    public TextView f;
    public LinearLayout g;
    public TextView h;
    public ScrollView i;

    public final FrameLayout a() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(this.a ? -16777216 : j);
        ScrollView scrollView = new ScrollView(this);
        this.i = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setPadding(a(16.0f), a(56.0f) + this.b, a(16.0f), a(96.0f) + this.c);
        scrollView.setClipToPadding(false);
        frameLayout.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(this);
        textView.setText(f5.a().a("filter_words"));
        textView.setTextSize(2, 28.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = a(8.0f);
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this);
        textView2.setText(f5.a().a("filter_words_desc"));
        textView2.setTextSize(2, 15.0f);
        int i = m;
        textView2.setTextColor(i);
        textView2.setLineSpacing(a(3.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(10.0f);
        linearLayout.addView(textView2, layoutParams2);
        int i2 = this.a ? k : l;
        int iA = l8.a().d() ? hd.a() : Color.parseColor("#FE2B54");
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        float fA = a(14.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(fA);
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setPadding(a(20.0f), a(4.0f), a(12.0f), a(4.0f));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, a(60.0f));
        layoutParams3.topMargin = a(22.0f);
        linearLayout.addView(linearLayout2, layoutParams3);
        final EditText editText = new EditText(this);
        editText.setBackground(null);
        editText.setPadding(0, 0, 0, 0);
        editText.setHint(f5.a().a("filter_words_input_hint"));
        editText.setHintTextColor(i);
        editText.setTextSize(2, 17.0f);
        editText.setTextColor(this.a ? -1 : -16777216);
        editText.setTypeface(Typeface.create("sans-serif-medium", 1));
        editText.setSingleLine(true);
        editText.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(editText);
        TextView textView3 = new TextView(this);
        textView3.setText(f5.a().a("filter_words_add"));
        textView3.setTextSize(2, 16.0f);
        textView3.setTextColor(iA);
        textView3.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView3.setPadding(a(12.0f), a(8.0f), a(4.0f), a(8.0f));
        textView3.setVisibility(8);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(editText, view);
            }
        });
        linearLayout2.addView(textView3, new LinearLayout.LayoutParams(-2, -2));
        editText.addTextChangedListener(new k4(textView3));
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.g = linearLayout3;
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = a(22.0f);
        linearLayout.addView(linearLayout3, layoutParams4);
        TextView textView4 = new TextView(this);
        textView4.setText(f5.a().a("filter_words_added"));
        textView4.setTextSize(2, 15.0f);
        int i3 = n;
        textView4.setTextColor(i3);
        textView4.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout3.addView(textView4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView5 = new TextView(this);
        this.f = textView5;
        textView5.setTextSize(2, 15.0f);
        this.f.setTextColor(i3);
        linearLayout3.addView(this.f);
        l4 l4Var = new l4(this);
        this.e = l4Var;
        l4Var.a = a(8.0f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = a(14.0f);
        linearLayout.addView(this.e, layoutParams5);
        b();
        a(frameLayout);
        b(frameLayout);
        c(frameLayout);
        return frameLayout;
    }

    public final void b() {
        if (this.e == null) {
            return;
        }
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            linearLayout.setVisibility(this.d.isEmpty() ? 8 : 0);
        }
        this.e.removeAllViews();
        this.f.setText(String.valueOf(this.d.size()));
        for (final String str : new LinkedHashSet(this.d)) {
            this.e.addView(a(str, new Runnable() {
                @Override
                public final void run() {
                    this.f$0.a(str);
                }
            }));
        }
    }

    public final void c(FrameLayout frameLayout) {
        TextView textView = new TextView(this);
        this.h = textView;
        textView.setText(f5.a().a("filter_save"));
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        int iA = l8.a().d() ? hd.a() : Color.parseColor("#FE2B54");
        float fA = a(28.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iA);
        gradientDrawable.setCornerRadius(fA);
        textView.setBackground(gradientDrawable);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a(56.0f));
        layoutParams.gravity = 80;
        layoutParams.setMargins(a(16.0f), 0, a(16.0f), a(20.0f) + this.c);
        frameLayout.addView(textView, layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l8.a((Context) this);
        this.a = (getResources().getConfiguration().uiMode & 48) == 32;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.b = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        int identifier2 = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.c = identifier2 > 0 ? getResources().getDimensionPixelSize(identifier2) : 0;
        LinkedHashSet linkedHashSet = this.d;
        l8 l8VarA = l8.a();
        if (l8VarA.w == null) {
            l8VarA.w = new LinkedHashSet();
        }
        linkedHashSet.addAll(l8VarA.w);
        Window window = getWindow();
        window.setSoftInputMode(16);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i = !this.a ? 9984 : 1792;
        if (!this.a) {
            i |= 16;
        }
        window.getDecorView().setSystemUiVisibility(i);
        FrameLayout frameLayoutA = a();
        setContentView(frameLayoutA);
        frameLayoutA.getViewTreeObserver().addOnGlobalLayoutListener(new j4(this, frameLayoutA));
    }

    public final void b(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(vb.a((Context) this, "ic_restart_line"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams.rightMargin = a(16.0f);
        layoutParams.topMargin = a(16.0f) + this.b;
        layoutParams.gravity = 53;
        frameLayout.addView(imageView, layoutParams);
    }

    public final  void b(View view) {
        c();
    }

    public final  void b(Dialog dialog, View view) {
        try {
            dialog.dismiss();
        } catch (Throwable th) {
        }
        this.d.clear();
        b();
        l8.a().a(this.d);
        setResult(-1);
    }

    public final  void c(View view) {
        l8.a().a(this.d);
        setResult(-1);
        finish();
    }

    public final void c() {
        int color;
        boolean z = this.a;
        int i = z ? -14935010 : -1;
        int color2 = z ? -1 : Color.parseColor("#161823");
        int i2 = this.a ? -6579293 : -9210757;
        if (l8.a().d()) {
            color = hd.a();
        } else {
            color = Color.parseColor("#FE2B54");
        }
        boolean z2 = this.a;
        int i3 = z2 ? -13882322 : l;
        int i4 = z2 ? -1 : -16777216;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        float fA = a(24.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(a(22.0f), a(24.0f), a(22.0f), a(20.0f));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(vb.a((Context) this, "ic_restart_line"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(34.0f), a(34.0f));
        layoutParams.bottomMargin = a(16.0f);
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(f5.a().a("filter_words_clear_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(color2);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(f5.a().a("filter_words_clear_desc"));
        textView2.setGravity(17);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(i2);
        textView2.setLineSpacing(a(2.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(8.0f);
        layoutParams2.bottomMargin = a(22.0f);
        linearLayout.addView(textView2, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        final Dialog dialog = new Dialog(this);
        TextView textView3 = new TextView(this);
        textView3.setText(f5.a().a("filter_cancel"));
        textView3.setGravity(17);
        textView3.setTextColor(i4);
        textView3.setTextSize(2, 15.0f);
        textView3.setTypeface(Typeface.create("sans-serif-medium", 1));
        float fA2 = a(26.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i3);
        gradientDrawable2.setCornerRadius(fA2);
        textView3.setBackground(gradientDrawable2);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, a(52.0f), 1.0f);
        layoutParams3.rightMargin = a(6.0f);
        linearLayout2.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(this);
        textView4.setText(f5.a().a("filter_words_clear_confirm"));
        textView4.setGravity(17);
        textView4.setTextColor(-1);
        textView4.setTextSize(2, 15.0f);
        textView4.setTypeface(Typeface.create("sans-serif-medium", 1));
        float fA3 = a(26.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(color);
        gradientDrawable3.setCornerRadius(fA3);
        textView4.setBackground(gradientDrawable3);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(dialog, view);
            }
        });
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, a(52.0f), 1.0f);
        layoutParams4.leftMargin = a(6.0f);
        linearLayout2.addView(textView4, layoutParams4);
        linearLayout.addView(linearLayout2);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setPadding(a(28.0f), 0, a(28.0f), 0);
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

    public final  void a(EditText editText, View view) {
        String strTrim = editText.getText().toString().trim();
        if (strTrim.isEmpty()) {
            return;
        }
        this.d.add(strTrim);
        editText.setText("");
        b();
    }

    public final  void a(String str) {
        this.d.remove(str);
        b();
    }

    public final LinearLayout a(String str, final Runnable runnable) {
        int i = this.a ? k : l;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        float fA = a(20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(a(16.0f), a(10.0f), a(12.0f), a(10.0f));
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView.setSingleLine(true);
        linearLayout.addView(textView);
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(vb.a((Context) this, "ic_close"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(16.0f), a(16.0f));
        layoutParams.leftMargin = a(10.0f);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                runnable.run();
            }
        });
        return linearLayout;
    }

    public final void a(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(vb.a((Context) this, "ic_back"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
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

    public final int a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
