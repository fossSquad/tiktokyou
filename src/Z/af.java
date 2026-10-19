package Z;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class af extends BaseActivity {
    public static final int q = Color.parseColor("#F5F5F5");
    public static final int r = Color.parseColor("#1E1E1E");
    public static final int s = Color.parseColor("#858585");
    public static final int t = Color.parseColor("#888888");
    public static final int u = Color.parseColor("#EBEBED");
    public static final int v = Color.parseColor("#2A2A2A");
    public static final int w = Color.parseColor("#8E8E93");
    public boolean b;
    public int c;
    public int d;
    public LinearLayout e;
    public Collator f;
    public LinearLayout g;
    public TextView h;
    public LinearLayout i;
    public LinearLayout j;
    public EditText k;
    public EditText l;
    public ImageView m;
    public ImageView n;
    public boolean p;
    public final ArrayList a = new ArrayList();
    public String o = "";

    public final void a(int i, View view) {
        int i2 = y5.a().b;
        if (i2 < 0 || i2 >= 191) {
            i2 = 0;
        }
        if (i2 == i) {
            finish();
            return;
        }
        ac.a().getClass();
        ac.e().c(i);
        setResult(-1);
        finish();
    }

    public final void b(ScrollView scrollView, TextView textView) {
        if (this.h == null || this.j == null || this.i == null) {
            return;
        }
        int scrollY = scrollView.getScrollY();
        this.h.setVisibility(scrollY >= textView.getHeight() + textView.getTop() ? 0 : 4);
        boolean z = scrollY >= this.j.getTop();
        this.i.setVisibility(z ? 0 : 8);
        this.j.setVisibility(z ? 4 : 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ac.a((Context) this);
        this.b = (getResources().getConfiguration().uiMode & 48) == 32;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.c = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        int identifier2 = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.d = identifier2 > 0 ? getResources().getDimensionPixelSize(identifier2) : 0;
        Collator collator = Collator.getInstance(Locale.getDefault());
        this.f = collator;
        collator.setStrength(0);
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i = !this.b ? 9984 : 1792;
        if (!this.b) {
            i |= 16;
        }
        window.getDecorView().setSystemUiVisibility(i);
        b();
        setContentView(a());
    }

    public final void b() {
        this.a.clear();
        for (int i = 0; i < 191; i++) {
            this.a.add(Integer.valueOf(i));
        }
        this.a.sort(new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return this.f$0.a((Integer) obj, (Integer) obj2);
            }
        });
    }

    public final  void b(View view) {
        a("", (EditText) null);
    }

    public final void b(String str) {
        String lowerCase;
        String strA;
        String str2;
        int iCodePointAt;
        String lowerCase2;
        LinearLayout linearLayout = this.e;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (str == null) {
            lowerCase = "";
        } else {
            lowerCase = str.trim().toLowerCase(Locale.getDefault());
        }
        int i = y5.a().b;
        if (i < 0 || i >= 191) {
            i = 0;
        }
        boolean zIsEmpty = TextUtils.isEmpty(lowerCase);
        if (zIsEmpty) {
            LinearLayout linearLayout2 = this.e;
            String strA2 = k7.a("region_selected_country");
            TextView textView = new TextView(this);
            textView.setText(strA2);
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(t);
            x5.a("yAeV9YZmFhjfINhThgEJMMS40IVwO0O8BtRfWr2bkjfd1Ryb2u4YqY4WQswsfspw", "lWIUhXyZN45rS8Nz", "aes", 0, textView);
            textView.setPadding(a(20.0f), a(10.0f), 0, a(10.0f));
            linearLayout2.addView(textView);
            this.e.addView(a(Collections.singletonList(Integer.valueOf(i)), i));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            Integer num = (Integer) obj;
            int iIntValue = num.intValue();
            if (!zIsEmpty || iIntValue != i) {
                te teVar = ue.a[iIntValue];
                if (!TextUtils.isEmpty(lowerCase)) {
                    String strA3 = k7.a(teVar.b, teVar.c);
                    if (strA3 == null) {
                        lowerCase2 = "";
                    } else {
                        lowerCase2 = strA3.trim().toLowerCase(Locale.getDefault());
                    }
                    if (lowerCase2.contains(lowerCase) || teVar.c.trim().toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                        strA = k7.a(teVar.b, teVar.c);
                        str2 = "#";
                        if (strA != null) {
                            iCodePointAt = strA.codePointAt(0);
                            if (Character.isLetter(iCodePointAt)) {
                                str2 = new String(Character.toChars(Character.toUpperCase(iCodePointAt)));
                            }
                        }
                        ((List) linkedHashMap.computeIfAbsent(str2, new Function() {
                            @Override
                            public final Object apply(Object obj2) {
                                return af.a((String) obj2);
                            }
                        })).add(num);
                    }
                } else {
                    strA = k7.a(teVar.b, teVar.c);
                    str2 = "#";
                    if (strA != null && !af$$ExternalSyntheticBackport0.m(strA)) {
                        iCodePointAt = strA.codePointAt(0);
                        if (Character.isLetter(iCodePointAt)) {
                            str2 = new String(Character.toChars(Character.toUpperCase(iCodePointAt)));
                        }
                    }
                    ((List) linkedHashMap.computeIfAbsent(str2, new Function() {
                        @Override
                        public final Object apply(Object obj2) {
                            return af.a((String) obj2);
                        }
                    })).add(num);
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            if (zIsEmpty) {
                return;
            }
            LinearLayout linearLayout3 = this.e;
            TextView textView2 = new TextView(this);
            textView2.setText(k7.a("region_search_empty"));
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(s);
            textView2.setGravity(1);
            textView2.setPadding(0, a(18.0f), 0, a(4.0f));
            linearLayout3.addView(textView2);
            return;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            LinearLayout linearLayout4 = this.e;
            String str3 = (String) entry.getKey();
            TextView textView3 = new TextView(this);
            textView3.setText(str3);
            textView3.setTextSize(2, 14.0f);
            textView3.setTextColor(t);
            x5.a("yAeV9YZmFhjfINhThgEJMMS40IVwO0O8BtRfWr2bkjfd1Ryb2u4YqY4WQswsfspw", "lWIUhXyZN45rS8Nz", "aes", 0, textView3);
            textView3.setPadding(a(20.0f), a(10.0f), 0, a(10.0f));
            linearLayout4.addView(textView3);
            this.e.addView(a((List) entry.getValue(), i));
        }
    }

    public final FrameLayout a() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(this.b ? -16777216 : q);
        final ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setPadding(0, a(56.0f) + this.c, 0, this.d);
        scrollView.setClipToPadding(false);
        frameLayout.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(a(8.0f), 0, a(8.0f), a(20.0f) + this.d);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        final TextView textView = new TextView(this);
        textView.setText(k7.a("region_picker_title"));
        textView.setTextSize(2, 28.0f);
        textView.setTextColor(this.b ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.topMargin = a(8.0f);
        layoutParams.bottomMargin = a(14.0f);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        LinearLayout linearLayoutA = a(false);
        this.j = linearLayoutA;
        linearLayout.addView(linearLayoutA);
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.e = linearLayout2;
        linearLayout2.setOrientation(1);
        linearLayout.addView(this.e, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.g = linearLayout3;
        linearLayout3.setOrientation(1);
        this.g.setBackgroundColor(this.b ? -16777216 : q);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        frameLayout.addView(this.g, layoutParams2);
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, a(56.0f) + this.c));
        this.g.addView(frameLayout2);
        TextView textView2 = new TextView(this);
        textView2.setText(k7.a("region_picker_title"));
        textView2.setTextSize(2, 16.0f);
        x5.a("AGS6Z0u03M+oD7+MYUwNBY6aSPj0nkAbkudwS6rI3oE=", "4A0Xv91sALNJIu8B", "aes", 1, textView2);
        textView2.setTextColor(this.b ? -1 : -16777216);
        textView2.setVisibility(4);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 49;
        layoutParams3.topMargin = a(16.0f) + this.c;
        textView2.setLayoutParams(layoutParams3);
        this.h = textView2;
        frameLayout2.addView(textView2);
        LinearLayout linearLayoutA2 = a(true);
        this.i = linearLayoutA2;
        linearLayoutA2.setVisibility(8);
        this.g.addView(this.i);
        a(frameLayout);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public final void onScrollChanged() {
                this.f$0.a(scrollView, textView);
            }
        });
        scrollView.post(new Runnable() {
            @Override
            public final void run() {
                this.f$0.b(scrollView, textView);
            }
        });
        b("");
        return frameLayout;
    }

    public final int a(Integer num, Integer num2) {
        Collator collator = this.f;
        te[] teVarArr = ue.a;
        te teVar = teVarArr[num.intValue()];
        String strA = k7.a(teVar.b, teVar.c);
        te teVar2 = teVarArr[num2.intValue()];
        return collator.compare(strA, k7.a(teVar2.b, teVar2.c));
    }

    public final LinearLayout a(boolean z) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(44.0f));
        linearLayout.setPadding(a(12.0f), 0, a(12.0f), 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? v : u);
        gradientDrawable.setCornerRadius(a(16.0f));
        linearLayout.setBackground(gradientDrawable);
        if (z) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = a(8.0f);
            layoutParams.rightMargin = a(8.0f);
            layoutParams.bottomMargin = a(8.0f);
            linearLayout.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.leftMargin = a(8.0f);
            layoutParams2.rightMargin = a(8.0f);
            layoutParams2.bottomMargin = a(8.0f);
            linearLayout.setLayoutParams(layoutParams2);
        }
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(hi.a((Context) this, "ic_search"));
        int i = w;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(i, mode);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(18.0f), a(18.0f)));
        EditText editText = new EditText(this);
        editText.setBackground(null);
        editText.setHint(k7.a("region_search_hint"));
        editText.setHintTextColor(i);
        editText.setTextColor(this.b ? -1 : -16777216);
        editText.setTextSize(2, 15.0f);
        editText.setTypeface(Typeface.create("sans-serif", 0));
        editText.setSingleLine(true);
        editText.setInputType(1);
        editText.setImeOptions(3);
        editText.setPadding(a(10.0f), a(12.0f), 0, a(12.0f));
        editText.addTextChangedListener(new ze(this, editText));
        linearLayout.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(hi.a((Context) this, "ic_close"));
        imageView2.setColorFilter(i, mode);
        imageView2.setVisibility(TextUtils.isEmpty(this.o) ? 8 : 0);
        imageView2.setClickable(true);
        imageView2.setFocusable(true);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(a(18.0f), a(18.0f));
        layoutParams3.leftMargin = a(10.0f);
        linearLayout.addView(imageView2, layoutParams3);
        if (z) {
            this.k = editText;
            this.m = imageView2;
            return linearLayout;
        }
        this.l = editText;
        this.n = imageView2;
        return linearLayout;
    }

    public final void a(String str, EditText editText) {
        if (str == null) {
            str = "";
        }
        this.o = str;
        EditText editText2 = this.l;
        if (editText2 != null && editText2 != editText && !TextUtils.equals(editText2.getText(), this.o)) {
            this.p = true;
            editText2.setText(this.o);
            editText2.setSelection(editText2.getText().length());
            this.p = false;
        }
        EditText editText3 = this.k;
        if (editText3 != null && editText3 != editText && !TextUtils.equals(editText3.getText(), this.o)) {
            this.p = true;
            editText3.setText(this.o);
            editText3.setSelection(editText3.getText().length());
            this.p = false;
        }
        int i = TextUtils.isEmpty(this.o) ? 8 : 0;
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
        ImageView imageView2 = this.m;
        if (imageView2 != null) {
            imageView2.setVisibility(i);
        }
        b(this.o);
    }

    public static  List a(String str) {
        return new ArrayList();
    }

    public final LinearLayout a(final int i, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        int color;
        te teVar = ue.a[i];
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(48.0f));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(i, view);
            }
        });
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(we.a(this, teVar, a(20.0f)));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView = new TextView(this);
        textView.setText(k7.a(teVar.b, teVar.c));
        textView.setTextSize(2, 16.0f);
        x5.a("4TfCsknNEEAvVoabcpKNDvwcrXhhjt6OtXIgt2vyM4TwVhmltVNL7IuztmHswARr", "V7DgYtZN6zg8uEJT", "aes", 0, textView);
        textView.setTextColor(this.b ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(textView, layoutParams);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(hi.a((Context) this, (z ? "ic_radio_active" : "ic_radio_inactive")));
        if (z) {
            if (ac.a().g()) {
                color = zh.a();
            } else {
                color = Color.parseColor("#FE2B54");
            }
        } else {
            color = Color.parseColor((this.b ? "#555555" : "#BBBBBB"));
        }
        imageView2.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        return linearLayout;
    }

    public final LinearLayout a(List list, int i) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? r : -1);
        gradientDrawable.setCornerRadius(a(16.0f));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            linearLayout.addView(a(iIntValue, iIntValue == i));
        }
        return linearLayout;
    }

    public final void a(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(hi.a((Context) this, "ic_back"));
        imageView.setColorFilter(this.b ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams.leftMargin = a(16.0f);
        layoutParams.topMargin = a(16.0f) + this.c;
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
