package Z;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TypefaceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.util.LinkedHashSet;

public class c6 extends BaseActivity {
    public static final int j = Color.parseColor("#1E1E1E");
    public static final int k = Color.parseColor("#F2F2F2");
    public static final int l = Color.parseColor("#838383");
    public static final int m = Color.parseColor("#838383");
    public boolean a;
    public int b;
    public int c;
    public final LinkedHashSet d = new LinkedHashSet();
    public b6 e;
    public TextView f;
    public LinearLayout g;
    public TextView h;
    public ScrollView i;

    public final FrameLayout a() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(this.a ? -16777216 : -1);
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
        textView.setText(k7.a("filter_words"));
        textView.setTextSize(2, 28.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = a(8.0f);
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this);
        textView2.setText(k7.a("filter_words_desc"));
        textView2.setTextSize(2, 14.0f);
        int i = l;
        textView2.setTextColor(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(16.0f);
        linearLayout.addView(textView2, layoutParams2);
        int i2 = this.a ? j : k;
        int iA = ac.a().g() ? zh.a() : Color.parseColor("#FE2B54");
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        float fA = a(16.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(fA);
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setPadding(a(16.0f), 0, a(16.0f), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, a(48.0f));
        layoutParams3.topMargin = a(16.0f);
        linearLayout.addView(linearLayout2, layoutParams3);
        final EditText editText = new EditText(this);
        editText.setBackground(null);
        editText.setPadding(0, 0, 0, 0);
        SpannableString spannableString = new SpannableString(k7.a("filter_words_input_hint"));
        spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString.length(), 33);
        spannableString.setSpan(new TypefaceSpan("sans-serif"), 0, spannableString.length(), 33);
        editText.setHint(spannableString);
        editText.setHintTextColor(i);
        editText.setTextSize(2, 16.0f);
        editText.setTextColor(this.a ? -1 : -16777216);
        editText.setTypeface(hi.f());
        editText.setSingleLine(true);
        editText.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(editText);
        TextView textView3 = new TextView(this);
        textView3.setText(k7.a("filter_words_add"));
        textView3.setTextSize(2, 14.0f);
        textView3.setTextColor(iA);
        (textView3).setTypeface(android.graphics.Typeface.create("sans-serif-medium", 0));
        textView3.setPadding(a(12.0f), a(8.0f), 0, a(8.0f));
        textView3.setVisibility(8);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                c6.this.a(editText, view);
            }
        });
        linearLayout2.addView(textView3, new LinearLayout.LayoutParams(-2, -2));
        editText.addTextChangedListener(new a6(textView3));
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.g = linearLayout3;
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setPadding(0, a(20.0f), 0, a(12.0f));
        linearLayout.addView(linearLayout3, layoutParams4);
        TextView textView4 = new TextView(this);
        textView4.setText(k7.a("filter_words_added"));
        textView4.setTextSize(2, 12.0f);
        int i3 = m;
        textView4.setTextColor(i3);
        textView4.setTypeface(hi.f());
        linearLayout3.addView(textView4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView5 = new TextView(this);
        this.f = textView5;
        textView5.setTextSize(2, 12.0f);
        this.f.setTextColor(i3);
        this.f.setTypeface(hi.f());
        linearLayout3.addView(this.f);
        b6 b6Var = new b6(this);
        this.e = b6Var;
        b6Var.a = a(4.0f);
        linearLayout.addView(this.e, new LinearLayout.LayoutParams(-1, -2));
        c();
        a(frameLayout);
        b(frameLayout);
        c(frameLayout);
        return frameLayout;
    }

    public final void b(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(hi.a((Context) this, "ic_restart_line"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                c6.this.b(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams.rightMargin = a(16.0f);
        layoutParams.topMargin = a(16.0f) + this.b;
        layoutParams.gravity = 53;
        frameLayout.addView(imageView, layoutParams);
    }

    public final void c() {
        if (this.e == null) {
            return;
        }
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            linearLayout.setVisibility(this.d.isEmpty() ? 8 : 0);
        }
        this.e.removeAllViews();
        this.f.setText(String.valueOf(this.d.size()));
        for (final String str : new LinkedHashSet<String>(this.d)) {
            this.e.addView(a(str, new Runnable() {
                @Override
                public final void run() {
                    c6.this.a(str);
                }
            }));
        }
    }

    public final void d() {
        fc fcVarA = new fc(this).b((CharSequence) k7.a("filter_words_clear_title")).a((CharSequence) k7.a("filter_words_clear_desc"));
        fcVarA.b(k7.a("filter_words_clear_confirm"), new Runnable() {
            @Override
            public final void run() {
                c6.this.b();
            }
        });
        fcVarA.d(k7.a("filter_cancel"), null);
        fcVarA.g();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ac.a((Context) this);
        this.a = (getResources().getConfiguration().uiMode & 48) == 32;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.b = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        int identifier2 = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.c = identifier2 > 0 ? getResources().getDimensionPixelSize(identifier2) : 0;
        LinkedHashSet linkedHashSet = this.d;
        bc bcVarA = y5.a();
        if (bcVarA.A == null) {
            bcVarA.A = new LinkedHashSet();
        }
        LinkedHashSet linkedHashSet2 = bcVarA.A;
        linkedHashSet.addAll(linkedHashSet2);
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
        frameLayoutA.getViewTreeObserver().addOnGlobalLayoutListener(new z5(this, frameLayoutA));
    }

    public final void c(FrameLayout frameLayout) {
        int color;
        TextView textView = new TextView(this);
        this.h = textView;
        textView.setText(k7.a("filter_save"));
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(hi.f());
        if (ac.a().g()) {
            color = zh.a();
        } else {
            color = Color.parseColor("#FE2B54");
        }
        float fA = a(24.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(fA);
        textView.setBackground(gradientDrawable);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                c6.this.c(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a(48.0f));
        layoutParams.gravity = 80;
        layoutParams.setMargins(a(24.0f), 0, a(24.0f), a(24.0f) + this.c);
        frameLayout.addView(textView, layoutParams);
    }

    public final  void b(View view) {
        d();
    }

    public final void b() {
        this.d.clear();
        c();
        ac acVarA = ac.a();
        LinkedHashSet linkedHashSet = this.d;
        acVarA.getClass();
        ac.e().a(linkedHashSet);
        setResult(-1);
    }

    public final void c(View view) {
        ac acVarA = ac.a();
        LinkedHashSet linkedHashSet = this.d;
        acVarA.getClass();
        ac.e().a(linkedHashSet);
        setResult(-1);
        finish();
    }

    public final  void a(EditText editText, View view) {
        String strTrim = editText.getText().toString().trim();
        if (strTrim.isEmpty()) {
            return;
        }
        this.d.add(strTrim);
        editText.setText("");
        c();
    }

    public final  void a(String str) {
        this.d.remove(str);
        c();
    }

    public final LinearLayout a(String str, final Runnable runnable) {
        int i = this.a ? j : k;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        float fA = a(12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(a(12.0f), 0, a(12.0f), 0);
        linearLayout.setMinimumHeight(a(32.0f));
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(hi.f());
        textView.setLetterSpacing(-0.02f);
        textView.setSingleLine(true);
        linearLayout.addView(textView);
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(hi.a((Context) this, "ic_close"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(16.0f), a(16.0f));
        layoutParams.leftMargin = a(8.0f);
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
        imageView.setImageBitmap(hi.a((Context) this, "ic_back"));
        imageView.setColorFilter(this.a ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                c6.this.a(view);
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
