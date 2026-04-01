package X;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class z2 extends BaseActivity {
    public static boolean h;
    public static final int i = Color.parseColor("#F5F5F5");
    public static final int j = Color.parseColor("#1E1E1E");
    public static final int k = Color.parseColor("#858585");
    public static final int l = Color.parseColor("#888888");
    public static final int m = Color.parseColor("#777778");
    public static final int[] n = {-1142217, -12726936, -5616918, -1226807, -12165909, -12342807, -1424314, -7763575};
    public boolean a;
    public int b;
    public int c;
    public FrameLayout d;
    public FrameLayout e;
    public TextView f;
    public LinearLayout g;

    public static int j() {
        return t1.a().d() ? j4.a() : Color.parseColor("#FE2B54");
    }

    public final void a(FrameLayout frameLayout, final ScrollView scrollView, final TextView textView) {
        View view = new View(this);
        view.setBackgroundColor(this.a ? -16777216 : i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a(56.0f) + this.b);
        layoutParams.gravity = 48;
        frameLayout.addView(view, layoutParams);
        final TextView textView2 = new TextView(this);
        textView2.setText(q1.a().a("settings_title"));
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(Typeface.create("sans-serif", 1));
        textView2.setTextColor(this.a ? -1 : -16777216);
        textView2.setVisibility(4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = a(16.0f) + this.b;
        textView2.setLayoutParams(layoutParams2);
        frameLayout.addView(textView2);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public final void onScrollChanged() {
                TextView textView3 = textView;
                textView2.setVisibility(scrollView.getScrollY() >= textView3.getHeight() + textView3.getTop() ? 0 : 4);
            }
        });
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.a ? j : -1);
        gradientDrawable.setCornerRadius(a(12.0f));
        linearLayout.setBackground(gradientDrawable);
        return linearLayout;
    }

    public final LinearLayout c() {
        LinearLayout linearLayoutB = b();
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        linearLayoutB.setClipToPadding(false);
        linearLayoutB.setClipChildren(false);
        boolean z = Build.VERSION.SDK_INT >= 31;
        boolean zD = t1.a().d();
        CheckBox checkBox = new CheckBox(this);
        checkBox.setSaveEnabled(false);
        checkBox.setText(q1.a().a("custom_colors"));
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(Typeface.create("sans-serif-medium", 0));
        checkBox.setMinHeight(a(48.0f));
        checkBox.setTextColor(this.a ? -1 : -16777216);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_check_active", j()));
        stateListDrawable.addState(new int[0], a("ic_check_inactive", color));
        Bitmap bitmapB = b("ic_risovalca");
        BitmapDrawable bitmapDrawable = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
        int iA = a(20.0f);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, iA, iA);
        }
        stateListDrawable.setBounds(0, 0, iA, iA);
        checkBox.setCompoundDrawables(bitmapDrawable, null, stateListDrawable, null);
        checkBox.setCompoundDrawablePadding(a(12.0f));
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        checkBox.setChecked(zD);
        linearLayoutB.addView(checkBox);
        final HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setClipToPadding(false);
        horizontalScrollView.setClipChildren(false);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setPadding(0, 0, 0, a(12.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.g = linearLayout;
        linearLayout.setOrientation(0);
        this.g.setPadding(0, 0, 0, 0);
        int i2 = t1.a().j;
        j4.c = false;
        if (z) {
            Context contextB = r1.b();
            FrameLayout frameLayoutA = a(contextB == null ? -16524603 : j4.a(contextB), i2 == 0);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(b("ic_system_colors"));
            int iA2 = a(16.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams.gravity = 17;
            frameLayoutA.addView(imageView, layoutParams);
            this.g.addView(frameLayoutA);
        }
        int[] iArr = n;
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            this.g.addView(a(i4, i4 == i2));
        }
        j4.c = true;
        horizontalScrollView.addView(this.g);
        horizontalScrollView.setVisibility(zD ? 0 : 8);
        linearLayoutB.addView(horizontalScrollView);
        final TextView textView = new TextView(this);
        textView.setText(q1.a().a("custom_colors_desc"));
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(k);
        textView.setPadding(0, 0, 0, a(12.0f));
        textView.setVisibility(zD ? 0 : 8);
        linearLayoutB.addView(textView);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.a(horizontalScrollView, textView, compoundButton, z2);
            }
        });
        return linearLayoutB;
    }

    public final LinearLayout d() {
        LinearLayout linearLayoutB = b();
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        String strA = q1.a().a("hide_lives");
        boolean z = t1.a().c;
        final t1 t1VarA = t1.a();
        Objects.requireNonNull(t1VarA);
        linearLayoutB.addView(a(strA, "ic_live", z, new y2() {
            @Override
            public final void a(boolean z2) {
                t1VarA.e(z2);
            }
        }));
        String strA2 = q1.a().a("hide_ads");
        boolean z2 = t1.a().d;
        final t1 t1VarA2 = t1.a();
        Objects.requireNonNull(t1VarA2);
        linearLayoutB.addView(a(strA2, "ic_ads", z2, new y2() {
            @Override
            public final void a(boolean z3) {
                t1VarA2.d(z3);
            }
        }));
        String strA3 = q1.a().a("hide_photos");
        boolean z3 = t1.a().e;
        final t1 t1VarA3 = t1.a();
        Objects.requireNonNull(t1VarA3);
        linearLayoutB.addView(a(strA3, "ic_photo_disable", z3, new y2() {
            @Override
            public final void a(boolean z4) {
                t1VarA3.f(z4);
            }
        }));
        String strA4 = q1.a().a("hide_stories");
        boolean z4 = t1.a().f;
        final t1 t1VarA4 = t1.a();
        Objects.requireNonNull(t1VarA4);
        linearLayoutB.addView(a(strA4, "ic_hidestory", z4, new y2() {
            @Override
            public final void a(boolean z5) {
                t1VarA4.g(z5);
            }
        }));
        return linearLayoutB;
    }

    public final LinearLayout e() {
        LinearLayout linearLayoutB = b();
        float f = 16.0f;
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        RadioGroup radioGroup = new RadioGroup(this);
        char c = 1;
        radioGroup.setOrientation(1);
        String str = t1.a().g;
        final ArrayList arrayList = new ArrayList();
        int i2 = 2;
        arrayList.add(new String[]{"default", q1.a().a("font_default"), "ic_font"});
        arrayList.add(new String[]{"system", q1.a().a("font_system"), "ic_system_font"});
        int i3 = 0;
        int i4 = -1;
        while (i3 < arrayList.size()) {
            String[] strArr = (String[]) arrayList.get(i3);
            String str2 = strArr[c];
            String str3 = strArr[i2];
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i3);
            radioButton.setSaveEnabled(false);
            radioButton.setText(str2);
            radioButton.setTextSize(i2, f);
            radioButton.setTypeface(Typeface.create("sans-serif-medium", 0));
            radioButton.setMinHeight(a(48.0f));
            radioButton.setTextColor(this.a ? -1 : -16777216);
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setBackground(null);
            int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_radio_active", j()));
            stateListDrawable.addState(new int[0], a("ic_radio_inactive", color));
            Bitmap bitmapB = b(str3);
            BitmapDrawable bitmapDrawable = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
            int iA = a(20.0f);
            if (bitmapDrawable != null) {
                bitmapDrawable.setBounds(0, 0, iA, iA);
            }
            stateListDrawable.setBounds(0, 0, iA, iA);
            radioButton.setCompoundDrawables(bitmapDrawable, null, stateListDrawable, null);
            radioButton.setCompoundDrawablePadding(a(12.0f));
            radioButton.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            radioGroup.addView(radioButton);
            if (strArr[0].equals(str)) {
                i4 = i3;
            }
            i3++;
            f = 16.0f;
            c = 1;
            i2 = 2;
        }
        linearLayoutB.addView(radioGroup);
        linearLayoutB.addView(f());
        if (str != null && str.startsWith("file:")) {
            radioGroup.clearCheck();
        } else if (i4 >= 0) {
            radioGroup.check(i4);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(RadioGroup radioGroup2, int i5) {
                this.f$0.a(arrayList, radioGroup2, i5);
            }
        });
        return linearLayoutB;
    }

    public final LinearLayout f() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(48.0f));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b("ic_font_file"));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView = new TextView(this);
        textView.setText(q1.a().a("font_pick_file"));
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setTextColor(this.a ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this);
        this.f = textView2;
        textView2.setTextSize(2, 14.0f);
        this.f.setTextColor(k);
        l();
        linearLayout.addView(this.f);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(b("ic_arrow_right"));
        imageView2.setColorFilter(m);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams2.leftMargin = a(8.0f);
        linearLayout.addView(imageView2, layoutParams2);
        return linearLayout;
    }

    public final LinearLayout g() {
        LinearLayout linearLayoutB = b();
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        String strA = q1.a().a("force_progress_bar");
        boolean z = t1.a().h;
        final t1 t1VarA = t1.a();
        Objects.requireNonNull(t1VarA);
        linearLayoutB.addView(a(strA, "ic_videoslider", z, new y2() {
            @Override
            public final void a(boolean z2) {
                t1VarA.a(z2);
            }
        }));
        linearLayoutB.addView(a(q1.a().a("auto_streak_nudge"), "ic_autotease", t1.a().k, new y2() {
            @Override
            public final void a(boolean z2) {
                z2.a(z2);
            }
        }));
        return linearLayoutB;
    }

    public final LinearLayout h() {
        String str;
        ?? gradientDrawable;
        ?? B = b();
        float f = 16.0f;
        B.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        ?? radioGroup = new RadioGroup(this);
        radioGroup.setTag("RegionRadioGroup");
        radioGroup.setOrientation(1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            z1[] z1VarArr = a2.a;
            if (i3 >= 6) {
                radioGroup.check(t1.a().b);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public final void onCheckedChanged(RadioGroup radioGroup2, int i4) {
                        this.f$0.a(radioGroup2, i4);
                    }
                });
                B.addView(radioGroup);
                return B;
            }
            z1 z1Var = z1VarArr[i3];
            z1Var.getClass();
            String strA = q1.a().a(z1Var.a);
            String str2 = z1Var.a;
            ?? radioButton = new RadioButton(this);
            if (i3 != -1) {
                radioButton.setId(i3);
            }
            radioButton.setSaveEnabled(i2);
            radioButton.setText(strA);
            ?? r8 = 2;
            radioButton.setTextSize(2, f);
            radioButton.setTypeface(Typeface.create("sans-serif-medium", (int) i2));
            radioButton.setMinHeight(a(48.0f));
            radioButton.setTextColor(this.a ? -1 : -16777216);
            radioButton.setButtonDrawable(null);
            radioButton.setBackground(null);
            int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_radio_active", j()));
            stateListDrawable.addState(new int[i2], a("ic_radio_inactive", color));
            switch (str2.hashCode()) {
                case -1990164040:
                    r8 = !str2.equals("region_usa") ? -1 : i2;
                    break;
                case -1394777067:
                    r8 = !str2.equals("region_poland") ? -1 : 1;
                    break;
                case -1302302896:
                    if (!str2.equals("region_egypt")) {
                        r8 = -1;
                    }
                    break;
                case -743130581:
                    r8 = !str2.equals("region_finland") ? -1 : 3;
                    break;
                case -114852787:
                    r8 = !str2.equals("region_belarus") ? -1 : 4;
                    break;
                case 1093032083:
                    r8 = !str2.equals("region_kazakhstan") ? -1 : 5;
                    break;
                default:
                    r8 = -1;
                    break;
            }
            switch (r8) {
                case 0:
                    str = "ic_flag_usa";
                    break;
                case 1:
                    str = "ic_flag_poland";
                    break;
                case 2:
                    str = "ic_flag_egypt";
                    break;
                case 3:
                    str = "ic_flag_finland";
                    break;
                case 4:
                    str = "ic_flag_belarus";
                    break;
                case 5:
                    str = "ic_flag_kazakhstan";
                    break;
                default:
                    str = "ic_flag_custom";
                    break;
            }
            Bitmap bitmapB = b(str);
            if (bitmapB != null) {
                int iA = a(20.0f);
                Resources resources = getResources();
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapB, iA, iA, true);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, iA, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                float f2 = iA / 2.0f;
                canvas.drawCircle(f2, f2, f2, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
                gradientDrawable = new BitmapDrawable(resources, bitmapCreateBitmap);
            } else {
                int iA2 = a(20.0f);
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(Color.parseColor("#444444"));
                gradientDrawable.setSize(iA2, iA2);
            }
            int iA3 = a(20.0f);
            i2 = 0;
            gradientDrawable.setBounds(0, 0, iA3, iA3);
            stateListDrawable.setBounds(0, 0, iA3, iA3);
            radioButton.setCompoundDrawables(gradientDrawable, null, stateListDrawable, null);
            radioButton.setCompoundDrawablePadding(a(12.0f));
            radioButton.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            radioGroup.addView(radioButton);
            i3++;
            f = 16.0f;
        }
    }

    public final LinearLayout i() {
        LinearLayout linearLayoutB = b();
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        String strA = q1.a().a("region_spoof");
        boolean z = t1.a().a;
        final t1 t1VarA = t1.a();
        Objects.requireNonNull(t1VarA);
        linearLayoutB.addView(a(strA, "ic_globe", z, new y2() {
            @Override
            public final void a(boolean z2) {
                t1VarA.h(z2);
            }
        }));
        return linearLayoutB;
    }

    public final void k() {
        if (this.e != null) {
            return;
        }
        this.e = a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.setMargins(a(8.0f), 0, a(8.0f), a(16.0f) + this.c);
        this.e.setTranslationY(a(100.0f));
        this.e.setAlpha(0.0f);
        this.d.addView(this.e, layoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationY", a(100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    public final void l() {
        String strReplaceAll;
        if (this.f == null) {
            return;
        }
        String strSubstring = t1.a().g;
        if (strSubstring == null || !strSubstring.startsWith("file:")) {
            this.f.setText("");
            this.f.setVisibility(8);
            return;
        }
        Typeface typeface = j1.a;
        if ("default".equals(strSubstring) || "system".equals(strSubstring)) {
            strReplaceAll = null;
        } else {
            if (strSubstring.startsWith("file:")) {
                strSubstring = strSubstring.substring(5);
            } else if (strSubstring.startsWith("asset:")) {
                strSubstring = strSubstring.substring(6);
            }
            strReplaceAll = strSubstring.replaceAll("(?i)\\.(ttf|otf)$", "");
        }
        this.f.setText(strReplaceAll != null ? strReplaceAll : "");
        this.f.setVisibility(0);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        String string;
        int columnIndex;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1001 || i3 != -1 || intent == null || (data = intent.getData()) == null) {
            return;
        }
        try {
            Cursor cursorQuery = getContentResolver().query(data, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) < 0) {
                        string = null;
                    } else {
                        string = cursorQuery.getString(columnIndex);
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } else {
                string = null;
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            string = null;
        }
        if (string == null) {
            string = "custom_font.ttf";
        }
        String lowerCase = string.toLowerCase();
        if (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf")) {
            File file = new File(getFilesDir(), "fonts");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, string);
            try {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(data);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    if (inputStreamOpenInputStream == null) {
                        fileOutputStream.close();
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                            return;
                        }
                        return;
                    }
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i4 = inputStreamOpenInputStream.read(bArr);
                            if (i4 <= 0) {
                                fileOutputStream.close();
                                inputStreamOpenInputStream.close();
                                t1.a().a("file:".concat(string));
                                j1.a = null;
                                j1.b = null;
                                j1.c.clear();
                                l();
                                k();
                                return;
                            }
                            fileOutputStream.write(bArr, 0, i4);
                            if (inputStreamOpenInputStream != null) {
                                throw th;
                            }
                            try {
                                inputStreamOpenInputStream.close();
                                throw th;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        try {
                            fileOutputStream.close();
                            throw th4;
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                            throw th4;
                        }
                    }
                } catch (Throwable th6) {
                    if (inputStreamOpenInputStream != null) {
                        throw th6;
                    }
                    inputStreamOpenInputStream.close();
                    throw th6;
                }
            } catch (IOException e3) {
                e3.getMessage();
                ArrayList arrayList = r1.a;
            }
            e3.getMessage();
            ArrayList arrayList2 = r1.a;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (t1.m == null) {
            t1.m = getSharedPreferences("ttmod_settings", 0);
        }
        if (t1.n == null) {
            t1.n = new t1();
        }
        this.a = (getResources().getConfiguration().uiMode & 48) == 32;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.b = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        int identifier2 = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.c = identifier2 > 0 ? getResources().getDimensionPixelSize(identifier2) : 0;
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i2 = !this.a ? 9984 : 1792;
        if (!this.a) {
            i2 |= 16;
        }
        window.getDecorView().setSystemUiVisibility(i2);
        FrameLayout frameLayout = new FrameLayout(this);
        this.d = frameLayout;
        frameLayout.setTag("ModSettingsView");
        this.d.setClickable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.setBackgroundColor(this.a ? -16777216 : i);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setPadding(0, a(56.0f) + this.b, 0, this.c);
        scrollView.setClipToPadding(false);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(a(8.0f), 0, a(8.0f), a(20.0f) + this.c);
        scrollView.addView(linearLayout);
        this.d.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(this);
        textView.setText(q1.a().a("settings_title"));
        textView.setTextSize(2, 28.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.topMargin = a(8.0f);
        layoutParams.bottomMargin = a(22.0f);
        textView.setLayoutParams(layoutParams);
        a(this.d, scrollView, textView);
        a(this.d);
        linearLayout.addView(textView);
        if (h) {
            linearLayout.addView(a("ic_mod_update", q1.a().a("mod_update"), null, "https://t.me/tikyoutok", 0, true));
        }
        linearLayout.addView(a("ic_telegram", q1.a().a("telegram_channel"), null, "https://t.me/tikyoutok", h ? 1 : 2, false));
        linearLayout.addView(a(q1.a().a("section_region")));
        linearLayout.addView(i());
        Space space = new Space(this);
        space.setMinimumHeight(a(8.0f));
        linearLayout.addView(space);
        linearLayout.addView(h());
        linearLayout.addView(a(q1.a().a("section_feed")));
        linearLayout.addView(d());
        linearLayout.addView(a(q1.a().a("section_font")));
        linearLayout.addView(e());
        linearLayout.addView(a(q1.a().a("section_colors")));
        linearLayout.addView(c());
        linearLayout.addView(a(q1.a().a("section_other")));
        linearLayout.addView(g());
        linearLayout.addView(a(q1.a().a("section_about")));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.addView(a("ic_mod_logo", "TikTok You", q1.a().a("mod_version"), null, 0, false));
        linearLayout2.addView(a("ic_document", q1.a().a("privacy_information"), q1.a().a("privacy_information_legal"), "https://telegra.ph/Pravovaya-informaciya-i-usloviya-ispolzovaniya-12-29", 1, false));
        linearLayout.addView(linearLayout2);
        linearLayout.addView(new Space(this), new LinearLayout.LayoutParams(-1, a(20.0f)));
        setContentView(this.d);
    }

    public final Bitmap b(String str) {
        try {
            InputStream inputStreamOpen = getAssets().open("mod_icons/" + str + ".png");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return bitmapDecodeStream;
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
        } catch (IOException e) {
            return null;
        }
    }

    public final void b(View view) {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(335544320);
            startActivity(launchIntentForPackage);
        }
        Runtime.getRuntime().exit(0);
    }

    public final void a(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b("ic_back"));
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
        imageView.bringToFront();
    }

    public final  void a(View view) {
        finish();
    }

    public final  void a(RadioGroup radioGroup, int i2) {
        t1.a().b(i2);
        k();
    }

    public final void a(HorizontalScrollView horizontalScrollView, TextView textView, CompoundButton compoundButton, boolean z) {
        t1.a().c(z);
        horizontalScrollView.setVisibility(z ? 0 : 8);
        textView.setVisibility(z ? 0 : 8);
        j4.a = 0;
        j4.b = 0;
        k();
    }

    public final FrameLayout a(final int i2, boolean z) {
        float fA;
        int iA = a(32.0f);
        int iA2 = (a(4.0f) * 2) + iA;
        final FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA2, iA2);
        layoutParams.rightMargin = a(6.0f);
        frameLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(a(10.0f));
        gradientDrawable.setStroke(a(2.0f), i2);
        View view = new View(this);
        view.setBackground(gradientDrawable);
        view.setVisibility(z ? 0 : 4);
        frameLayout.addView(view, new FrameLayout.LayoutParams(iA2, iA2));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i2);
        if (!z) {
            fA = iA / 2.0f;
        } else {
            fA = a(8.0f);
        }
        gradientDrawable2.setCornerRadius(fA);
        View view2 = new View(this);
        view2.setBackground(gradientDrawable2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = 17;
        frameLayout.addView(view2, layoutParams2);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view3) {
                this.f$0.a(frameLayout, i2, view3);
            }
        });
        return frameLayout;
    }

    public final void a(FrameLayout frameLayout, int i2, View view) {
        int iIndexOfChild = this.g.indexOfChild(frameLayout);
        if (Build.VERSION.SDK_INT >= 31 && iIndexOfChild == 0) {
            i2 = 0;
        }
        t1.a().a(i2);
        j4.a = 0;
        j4.b = 0;
        j4.c = false;
        int i3 = 0;
        while (i3 < this.g.getChildCount()) {
            FrameLayout frameLayout2 = (FrameLayout) this.g.getChildAt(i3);
            boolean z = i3 == iIndexOfChild;
            View childAt = frameLayout2.getChildAt(0);
            GradientDrawable gradientDrawable = (GradientDrawable) frameLayout2.getChildAt(1).getBackground();
            if (z) {
                gradientDrawable.setCornerRadius(a(8.0f));
                childAt.setVisibility(0);
            } else {
                gradientDrawable.setCornerRadius(a(32.0f) / 2.0f);
                childAt.setVisibility(4);
            }
            i3++;
        }
        j4.c = true;
        k();
    }

    public final  void c(View view) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "font/sfnt", "application/x-font-ttf", "application/x-font-otf", "application/octet-stream"});
        startActivityForResult(intent, 1001);
    }

    public static void a(boolean z) {
        t1.a().b(z);
        Handler handler = m.a;
        Context contextB = r1.b();
        if (contextB == null) {
            return;
        }
        if (t1.m == null || t1.a() == null) {
            if (t1.m == null) {
                t1.m = contextB.getSharedPreferences("ttmod_settings", 0);
            }
            if (t1.n == null) {
                t1.n = new t1();
            }
        }
        if (t1.a().k) {
            m.b(contextB);
            if (m.b.compareAndSet(false, true)) {
                Handler handler2 = m.a;
                h hVar = m.d;
                handler2.removeCallbacks(hVar);
                handler2.postDelayed(hVar, 300000L);
            }
            m.d(contextB, "settings");
            return;
        }
        m.a(contextB);
        m.b.set(false);
        m.a.removeCallbacks(m.d);
    }

    public final void a(List list, RadioGroup radioGroup, int i2) {
        if (i2 < 0 || i2 >= list.size()) {
            return;
        }
        t1.a().a(((String[]) list.get(i2))[0]);
        j1.a = null;
        j1.b = null;
        j1.c.clear();
        l();
        k();
    }

    public final FrameLayout a(String str, String str2, String str3, final String str4, int i2, boolean z) {
        float[] fArr;
        FrameLayout frameLayout = new FrameLayout(this);
        int iA = a(str3 != null ? 12.0f : 14.0f);
        frameLayout.setPadding(0, iA, 0, iA);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.a ? j : -1);
        float fA = a(8.0f);
        if (i2 == 0) {
            fArr = new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i2 == 1) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, fA, fA, fA, fA};
        } else if (i2 != 2) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        } else {
            fArr = new float[]{fA, fA, fA, fA, fA, fA, fA, fA};
        }
        gradientDrawable.setCornerRadii(fArr);
        frameLayout.setBackground(gradientDrawable);
        if (str4 != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    this.f$0.a(str4, view);
                }
            });
        }
        ImageView imageView = new ImageView(this);
        if (z) {
            imageView.setImageDrawable(a(str, j()));
        } else {
            imageView.setImageBitmap(b(str));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams.leftMargin = a(16.0f);
        layoutParams.gravity = 19;
        frameLayout.addView(imageView, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setText(str2);
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout.addView(textView);
        if (str3 != null) {
            TextView textView2 = new TextView(this);
            textView2.setText(str3);
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(k);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = a(4.0f);
            linearLayout.addView(textView2, layoutParams2);
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = a(48.0f);
        layoutParams3.gravity = 19;
        frameLayout.addView(linearLayout, layoutParams3);
        if (str4 != null) {
            if (z) {
                TextView textView3 = new TextView(this);
                textView3.setText(q1.a().a("mod_update_download"));
                textView3.setTextSize(2, 13.0f);
                textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
                textView3.setTextColor(-1);
                textView3.setGravity(17);
                textView3.setPadding(a(14.0f), a(6.0f), a(14.0f), a(6.0f));
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(j());
                gradientDrawable2.setCornerRadius(a(16.0f));
                textView3.setBackground(gradientDrawable2);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams4.rightMargin = a(16.0f);
                layoutParams4.gravity = 21;
                frameLayout.addView(textView3, layoutParams4);
                return frameLayout;
            }
            ImageView imageView2 = new ImageView(this);
            imageView2.setImageBitmap(b("ic_arrow_right"));
            imageView2.setColorFilter(m);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a(20.0f), a(20.0f));
            layoutParams5.rightMargin = a(16.0f);
            layoutParams5.gravity = 21;
            frameLayout.addView(imageView2, layoutParams5);
        }
        return frameLayout;
    }

    public final  void a(String str, View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final TextView a(String str) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(l);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setPadding(a(28.0f), a(16.0f), 0, a(12.0f));
        return textView;
    }

    public final CheckBox a(String str, String str2, boolean z, final y2 y2Var) {
        BitmapDrawable bitmapDrawable;
        CheckBox checkBox = new CheckBox(this);
        checkBox.setSaveEnabled(false);
        checkBox.setText(str);
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(Typeface.create("sans-serif-medium", 0));
        checkBox.setMinHeight(a(48.0f));
        checkBox.setTextColor(this.a ? -1 : -16777216);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_check_active", j()));
        stateListDrawable.addState(new int[0], a("ic_check_inactive", color));
        Bitmap bitmapB = b(str2);
        if (bitmapB == null) {
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(getResources(), bitmapB);
        }
        int iA = a(20.0f);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, iA, iA);
        }
        stateListDrawable.setBounds(0, 0, iA, iA);
        checkBox.setCompoundDrawables(bitmapDrawable, null, stateListDrawable, null);
        checkBox.setCompoundDrawablePadding(a(12.0f));
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        checkBox.setChecked(z);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.a(y2Var, compoundButton, z2);
            }
        });
        return checkBox;
    }

    public final  void a(y2 y2Var, CompoundButton compoundButton, boolean z) {
        if (y2Var != null) {
            y2Var.a(z);
        }
        k();
    }

    public final int a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public final BitmapDrawable a(String str, int i2) {
        Bitmap bitmapB = b(str);
        BitmapDrawable bitmapDrawable = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
        if (bitmapDrawable != null) {
            bitmapDrawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
        return bitmapDrawable;
    }

    public final FrameLayout a() {
        FrameLayout frameLayout = new FrameLayout(this);
        int iA = a(16.0f);
        int iA2 = a(16.0f);
        frameLayout.setPadding(iA, iA2, iA, iA2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.a ? -1 : Color.parseColor("#1E1E1E"));
        gradientDrawable.setCornerRadius(a(8.0f));
        frameLayout.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(8.0f), 0, a(8.0f), 0);
        frameLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(this);
        String strA = q1.a().a("bulletin_button");
        textView.setText(strA);
        textView.setTextColor(-1);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setGravity(17);
        textView.setPadding(a(20.0f), 0, a(20.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FE2B54"));
        gradientDrawable2.setCornerRadius(a(68.0f));
        textView.setBackground(gradientDrawable2);
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        int iA3 = a(16.0f) + a(40.0f) + ((int) paint.measureText(strA));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView textView2 = new TextView(this);
        textView2.setText(q1.a().a("bulletin_title"));
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(this.a ? -16777216 : -1);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this);
        textView3.setText(q1.a().a("bulletin_subtitle"));
        textView3.setTextSize(2, 12.0f);
        textView3.setTextColor(Color.parseColor("#838383"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = a(2.0f);
        linearLayout.addView(textView3, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 19;
        layoutParams3.rightMargin = iA3;
        frameLayout.addView(linearLayout, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, a(36.0f));
        layoutParams4.gravity = 21;
        frameLayout.addView(textView, layoutParams4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        return frameLayout;
    }
}
