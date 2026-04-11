package X;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
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
import androidx.fragment.app.Fragment;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class a4 extends BaseActivity {
    public static boolean j;
    public static final int k = Color.parseColor("#F5F5F5");
    public static final int l = Color.parseColor("#1E1E1E");
    public static final int m = Color.parseColor("#858585");
    public static final int n = Color.parseColor("#888888");
    public static final int o = Color.parseColor("#777778");
    public static final int[] p = {-1142217, -12726936, -5616918, -1226807, -12165909, -12342807, -1424314, -7763575};
    public boolean a;
    public int b;
    public int c;
    public FrameLayout d;
    public FrameLayout e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public LinearLayout i;

    public final void a(FrameLayout frameLayout, final ScrollView scrollView, final TextView textView) {
        View view = new View(this);
        view.setBackgroundColor(this.a ? -16777216 : k);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a(56.0f) + this.b);
        layoutParams.gravity = 48;
        frameLayout.addView(view, layoutParams);
        final TextView textView2 = new TextView(this);
        textView2.setText(o2.a().a("settings_title"));
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
        gradientDrawable.setColor(this.a ? l : -1);
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
        boolean zD = r2.a().d();
        CheckBox checkBox = new CheckBox(this);
        checkBox.setSaveEnabled(false);
        checkBox.setText(o2.a().a("custom_colors"));
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(Typeface.create("sans-serif-medium", 0));
        checkBox.setMinHeight(a(48.0f));
        checkBox.setTextColor(this.a ? -1 : -16777216);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_check_active", r2.a().d() ? k5.a() : Color.parseColor("#FE2B54")));
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
        this.i = linearLayout;
        linearLayout.setOrientation(0);
        this.i.setPadding(0, 0, 0, 0);
        int i = r2.a().j;
        k5.c = false;
        if (z) {
            Context contextB = p2.b();
            FrameLayout frameLayoutA = a(contextB == null ? -16524603 : k5.a(contextB), i == 0);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(b("ic_system_colors"));
            int iA2 = a(16.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams.gravity = 17;
            frameLayoutA.addView(imageView, layoutParams);
            this.i.addView(frameLayoutA);
        }
        int[] iArr = p;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            this.i.addView(a(i3, i3 == i));
        }
        k5.c = true;
        horizontalScrollView.addView(this.i);
        horizontalScrollView.setVisibility(zD ? 0 : 8);
        linearLayoutB.addView(horizontalScrollView);
        final TextView textView = new TextView(this);
        textView.setText(o2.a().a("custom_colors_desc"));
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(m);
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

    public final  void d(View view) {
        startActivityForResult(new Intent((Context) this, (Class<?>) j3.class), 1002);
    }

    public final void e(View view) {
        ConcurrentHashMap concurrentHashMap = k0.a;
        k0.b((Activity) this, (Fragment) null, new d0("", "asset:supporter.png", true, false, null));
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
        textView.setText(o2.a().a("font_pick_file"));
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setTextColor(this.a ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this);
        this.f = textView2;
        textView2.setTextSize(2, 14.0f);
        this.f.setTextColor(m);
        k();
        linearLayout.addView(this.f);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(b("ic_arrow_right"));
        imageView2.setColorFilter(o);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams2.leftMargin = a(8.0f);
        linearLayout.addView(imageView2, layoutParams2);
        return linearLayout;
    }

    public final LinearLayout g() {
        LinearLayout linearLayoutB = b();
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        String strA = o2.a().a("force_progress_bar");
        boolean z = r2.a().h;
        final r2 r2VarA = r2.a();
        Objects.requireNonNull(r2VarA);
        linearLayoutB.addView(a(strA, "ic_videoslider", z, new z3() {
            @Override
            public final void a(boolean z2) {
                r2VarA.a(z2);
            }
        }));
        linearLayoutB.addView(a(o2.a().a("auto_streak_nudge"), "ic_autotease", r2.a().k, new z3() {
            @Override
            public final void a(boolean z2) {
                a4.a(z2);
            }
        }));
        return linearLayoutB;
    }

    public final LinearLayout h() {
        LinearLayout linearLayoutB = b();
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        final LinearLayout linearLayoutI = i();
        linearLayoutI.setVisibility(r2.a().a ? 0 : 8);
        linearLayoutB.addView(a(o2.a().a("region_spoof"), "ic_globe", r2.a().a, new z3() {
            @Override
            public final void a(boolean z) {
                a4.a(linearLayoutI, z);
            }
        }));
        linearLayoutB.addView(linearLayoutI);
        return linearLayoutB;
    }

    public final LinearLayout i() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(48.0f));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        });
        ImageView imageView = new ImageView(this);
        this.h = imageView;
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView = new TextView(this);
        this.g = textView;
        textView.setTextSize(2, 16.0f);
        this.g.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.g.setTextColor(this.a ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(this.g, layoutParams);
        x2 x2VarB = r2.a().b();
        ImageView imageView2 = this.h;
        if (imageView2 != null) {
            imageView2.setImageDrawable(z2.a(this, x2VarB, a(20.0f)));
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            x2VarB.getClass();
            textView2.setText(o2.a().a(x2VarB.a, x2VarB.b));
        }
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageBitmap(b("ic_arrow_right"));
        imageView3.setColorFilter(o);
        linearLayout.addView(imageView3, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        return linearLayout;
    }

    public final void j() {
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

    public final void k() {
        String strReplaceAll;
        if (this.f == null) {
            return;
        }
        String strSubstring = r2.a().g;
        if (strSubstring == null || !strSubstring.startsWith("file:")) {
            this.f.setText("");
            this.f.setVisibility(8);
            return;
        }
        Typeface typeface = h2.a;
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

    public final void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        String string;
        int columnIndex;
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            if (i2 == -1) {
                if (this.h != null || this.g != null) {
                    x2 x2VarB = r2.a().b();
                    ImageView imageView = this.h;
                    if (imageView != null) {
                        imageView.setImageDrawable(z2.a(this, x2VarB, a(20.0f)));
                    }
                    TextView textView = this.g;
                    if (textView != null) {
                        x2VarB.getClass();
                        textView.setText(o2.a().a(x2VarB.a, x2VarB.b));
                    }
                }
                j();
                return;
            }
            return;
        }
        if (i != 1001 || i2 != -1 || intent == null || (data = intent.getData()) == null) {
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
                            int i3 = inputStreamOpenInputStream.read(bArr);
                            if (i3 <= 0) {
                                fileOutputStream.close();
                                inputStreamOpenInputStream.close();
                                r2.a().b("file:".concat(string));
                                h2.a = null;
                                h2.b = null;
                                h2.c.clear();
                                k();
                                j();
                                return;
                            }
                            fileOutputStream.write(bArr, 0, i3);
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
                ArrayList arrayList = p2.a;
            }
            e3.getMessage();
            ArrayList arrayList2 = p2.a;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r2.a((Context) this);
        this.a = (getResources().getConfiguration().uiMode & 48) == 32;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.b = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        int identifier2 = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.c = identifier2 > 0 ? getResources().getDimensionPixelSize(identifier2) : 0;
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
        this.d = frameLayout;
        frameLayout.setTag("ModSettingsView");
        this.d.setClickable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.setBackgroundColor(this.a ? -16777216 : k);
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
        textView.setText(o2.a().a("settings_title"));
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
        a(linearLayout, textView);
        setContentView(this.d);
    }

    public final LinearLayout d() {
        LinearLayout linearLayoutB = b();
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        String strA = o2.a().a("hide_lives");
        boolean z = r2.a().c;
        final r2 r2VarA = r2.a();
        Objects.requireNonNull(r2VarA);
        linearLayoutB.addView(a(strA, "ic_live", z, new z3() {
            @Override
            public final void a(boolean z2) {
                r2VarA.e(z2);
            }
        }));
        String strA2 = o2.a().a("hide_ads");
        boolean z2 = r2.a().d;
        final r2 r2VarA2 = r2.a();
        Objects.requireNonNull(r2VarA2);
        linearLayoutB.addView(a(strA2, "ic_ads", z2, new z3() {
            @Override
            public final void a(boolean z3) {
                r2VarA2.d(z3);
            }
        }));
        String strA3 = o2.a().a("hide_photos");
        boolean z3 = r2.a().e;
        final r2 r2VarA3 = r2.a();
        Objects.requireNonNull(r2VarA3);
        linearLayoutB.addView(a(strA3, "ic_photo_disable", z3, new z3() {
            @Override
            public final void a(boolean z4) {
                r2VarA3.f(z4);
            }
        }));
        String strA4 = o2.a().a("hide_stories");
        boolean z4 = r2.a().f;
        final r2 r2VarA4 = r2.a();
        Objects.requireNonNull(r2VarA4);
        linearLayoutB.addView(a(strA4, "ic_hidestory", z4, new z3() {
            @Override
            public final void a(boolean z5) {
                r2VarA4.g(z5);
            }
        }));
        return linearLayoutB;
    }

    public final LinearLayout e() {
        int color;
        LinearLayout linearLayoutB = b();
        float f = 16.0f;
        linearLayoutB.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        RadioGroup radioGroup = new RadioGroup(this);
        char c = 1;
        radioGroup.setOrientation(1);
        String str = r2.a().g;
        final ArrayList arrayList = new ArrayList();
        int i = 2;
        arrayList.add(new String[]{"default", o2.a().a("font_default"), "ic_font"});
        arrayList.add(new String[]{"system", o2.a().a("font_system"), "ic_system_font"});
        int i2 = 0;
        int i3 = -1;
        while (i2 < arrayList.size()) {
            String[] strArr = (String[]) arrayList.get(i2);
            String str2 = strArr[c];
            String str3 = strArr[i];
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i2);
            radioButton.setSaveEnabled(false);
            radioButton.setText(str2);
            radioButton.setTextSize(i, f);
            radioButton.setTypeface(Typeface.create("sans-serif-medium", 0));
            radioButton.setMinHeight(a(48.0f));
            radioButton.setTextColor(this.a ? -1 : -16777216);
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setBackground(null);
            int color2 = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
            StateListDrawable stateListDrawable = new StateListDrawable();
            int[] iArr = {R.attr.state_checked};
            if (r2.a().d()) {
                color = k5.a();
            } else {
                color = Color.parseColor("#FE2B54");
            }
            stateListDrawable.addState(iArr, a("ic_radio_active", color));
            stateListDrawable.addState(new int[0], a("ic_radio_inactive", color2));
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
                i3 = i2;
            }
            i2++;
            f = 16.0f;
            c = 1;
            i = 2;
        }
        linearLayoutB.addView(radioGroup);
        linearLayoutB.addView(f());
        if (str != null && str.startsWith("file:")) {
            radioGroup.clearCheck();
        } else if (i3 >= 0) {
            radioGroup.check(i3);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(RadioGroup radioGroup2, int i4) {
                this.f$0.a(arrayList, radioGroup2, i4);
            }
        });
        return linearLayoutB;
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

    public final void a(LinearLayout linearLayout, TextView textView) {
        a4 a4Var;
        int iA;
        int color;
        Bitmap bitmapDecodeStream;
        boolean z;
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapB;
        BitmapDrawable bitmapDrawable2;
        InputStream inputStreamOpen;
        int color2;
        linearLayout.addView(textView);
        if (!j) {
            a4Var = this;
        } else {
            String strA = o2.a().a("mod_update");
            if (r2.a().d()) {
                color2 = k5.a();
            } else {
                color2 = Color.parseColor("#FE2B54");
            }
            a4 a4Var2 = this;
            linearLayout.addView(a4Var2.a(a("ic_mod_update", color2), strA, null, "https://t.me/tikyoutok", 0, true, null));
            a4Var = a4Var2;
        }
        String strA2 = o2.a().a("telegram_channel");
        int i = j ? 3 : 0;
        Bitmap bitmapB2 = b("ic_telegram");
        linearLayout.addView(a4Var.a(bitmapB2 != null ? new BitmapDrawable(getResources(), bitmapB2) : null, strA2, null, "https://t.me/tikyoutok", i, false, null));
        r2 r2VarA = r2.a();
        try {
            try {
                if (r2VarA != null && r2VarA.j == 0) {
                    try {
                        int identifier = getResources().getIdentifier("system_accent3_400", "color", "android");
                        if (identifier != 0) {
                            color = getResources().getColor(identifier, null);
                        } else {
                            Context contextB = p2.b();
                            if (contextB == null) {
                                color = -16524603;
                            } else {
                                iA = k5.a(contextB);
                            }
                        }
                    } catch (Throwable th) {
                    }
                    inputStreamOpen = getAssets().open("developer.png");
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    if (bitmapDecodeStream == null) {
                        bitmapDrawable = null;
                    } else {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        Paint paint = new Paint(3);
                        z = k5.c;
                        k5.c = false;
                        try {
                            paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
                            k5.c = z;
                            canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                            bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap);
                        } catch (Throwable th2) {
                            k5.c = z;
                            throw th2;
                        }
                    }
                    linearLayout.addView(a4Var.a(bitmapDrawable, o2.a().a("support_project"), null, null, 1, false, new View.OnClickListener() {
                        @Override
                        public final void onClick(View view) {
                            this.f$0.e(view);
                        }
                    }));
                    linearLayout.addView(a(o2.a().a("section_region")));
                    linearLayout.addView(h());
                    linearLayout.addView(a(o2.a().a("section_feed")));
                    linearLayout.addView(d());
                    linearLayout.addView(a(o2.a().a("section_font")));
                    linearLayout.addView(e());
                    linearLayout.addView(a(o2.a().a("section_colors")));
                    linearLayout.addView(c());
                    linearLayout.addView(a(o2.a().a("section_other")));
                    linearLayout.addView(g());
                    linearLayout.addView(a(o2.a().a("section_about")));
                    LinearLayout linearLayout2 = new LinearLayout(this);
                    linearLayout2.setOrientation(1);
                    String strA3 = o2.a().a("mod_version");
                    bitmapB = b("ic_mod_logo");
                    if (bitmapB != null) {
                        bitmapDrawable2 = new BitmapDrawable(getResources(), bitmapB);
                    } else {
                        bitmapDrawable2 = null;
                    }
                    linearLayout2.addView(a4Var.a(bitmapDrawable2, "TikTok You", strA3, null, 0, false, null));
                    String strA4 = o2.a().a("privacy_information");
                    String strA5 = o2.a().a("privacy_information_legal");
                    Bitmap bitmapB3 = b("ic_document");
                    linearLayout2.addView(a4Var.a(bitmapB3 != null ? new BitmapDrawable(getResources(), bitmapB3) : null, strA4, strA5, "https://telegra.ph/Pravovaya-informaciya-i-usloviya-ispolzovaniya-12-29", 1, false, null));
                    linearLayout.addView(linearLayout2);
                    linearLayout.addView(new Space(this), new LinearLayout.LayoutParams(-1, a(20.0f)));
                }
                iA = -185258;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (Throwable th3) {
                if (inputStreamOpen == null) {
                    throw th3;
                }
                try {
                    inputStreamOpen.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
            inputStreamOpen = getAssets().open("developer.png");
        } catch (IOException e) {
            bitmapDecodeStream = null;
        }
        color = iA;
        if (bitmapDecodeStream == null) {
            bitmapDrawable = null;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            Paint paint2 = new Paint(3);
            z = k5.c;
            k5.c = false;
            paint2.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
            k5.c = z;
            canvas2.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint2);
            bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap2);
        }
        linearLayout.addView(a4Var.a(bitmapDrawable, o2.a().a("support_project"), null, null, 1, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.e(view);
            }
        }));
        linearLayout.addView(a(o2.a().a("section_region")));
        linearLayout.addView(h());
        linearLayout.addView(a(o2.a().a("section_feed")));
        linearLayout.addView(d());
        linearLayout.addView(a(o2.a().a("section_font")));
        linearLayout.addView(e());
        linearLayout.addView(a(o2.a().a("section_colors")));
        linearLayout.addView(c());
        linearLayout.addView(a(o2.a().a("section_other")));
        linearLayout.addView(g());
        linearLayout.addView(a(o2.a().a("section_about")));
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        String strA6 = o2.a().a("mod_version");
        bitmapB = b("ic_mod_logo");
        if (bitmapB != null) {
            bitmapDrawable2 = new BitmapDrawable(getResources(), bitmapB);
        } else {
            bitmapDrawable2 = null;
        }
        linearLayout3.addView(a4Var.a(bitmapDrawable2, "TikTok You", strA6, null, 0, false, null));
        String strA7 = o2.a().a("privacy_information");
        String strA8 = o2.a().a("privacy_information_legal");
        Bitmap bitmapB4 = b("ic_document");
        linearLayout3.addView(a4Var.a(bitmapB4 != null ? new BitmapDrawable(getResources(), bitmapB4) : null, strA7, strA8, "https://telegra.ph/Pravovaya-informaciya-i-usloviya-ispolzovaniya-12-29", 1, false, null));
        linearLayout.addView(linearLayout3);
        linearLayout.addView(new Space(this), new LinearLayout.LayoutParams(-1, a(20.0f)));
    }

    public final  void c(View view) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "font/sfnt", "application/x-font-ttf", "application/x-font-otf", "application/octet-stream"});
        startActivityForResult(intent, 1001);
    }

    public static  void a(View view, boolean z) {
        r2.a().h(z);
        view.setVisibility(z ? 0 : 8);
    }

    public final void a(HorizontalScrollView horizontalScrollView, TextView textView, CompoundButton compoundButton, boolean z) {
        r2.a().c(z);
        horizontalScrollView.setVisibility(z ? 0 : 8);
        textView.setVisibility(z ? 0 : 8);
        k5.a = 0;
        k5.b = 0;
        j();
    }

    public final FrameLayout a(final int i, boolean z) {
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
        gradientDrawable.setStroke(a(2.0f), i);
        View view = new View(this);
        view.setBackground(gradientDrawable);
        view.setVisibility(z ? 0 : 4);
        frameLayout.addView(view, new FrameLayout.LayoutParams(iA2, iA2));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i);
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
                this.f$0.a(frameLayout, i, view3);
            }
        });
        return frameLayout;
    }

    public final void a(FrameLayout frameLayout, int i, View view) {
        int iIndexOfChild = this.i.indexOfChild(frameLayout);
        if (Build.VERSION.SDK_INT >= 31 && iIndexOfChild == 0) {
            i = 0;
        }
        r2.a().a(i);
        k5.a = 0;
        k5.b = 0;
        k5.c = false;
        int i2 = 0;
        while (i2 < this.i.getChildCount()) {
            FrameLayout frameLayout2 = (FrameLayout) this.i.getChildAt(i2);
            boolean z = i2 == iIndexOfChild;
            View childAt = frameLayout2.getChildAt(0);
            GradientDrawable gradientDrawable = (GradientDrawable) frameLayout2.getChildAt(1).getBackground();
            if (z) {
                gradientDrawable.setCornerRadius(a(8.0f));
                childAt.setVisibility(0);
            } else {
                gradientDrawable.setCornerRadius(a(32.0f) / 2.0f);
                childAt.setVisibility(4);
            }
            i2++;
        }
        k5.c = true;
        j();
    }

    public static void a(boolean z) {
        r2.a().b(z);
        Handler handler = m.a;
        Context contextB = p2.b();
        if (contextB == null) {
            return;
        }
        if (r2.o == null || r2.a() == null) {
            r2.a(contextB);
        }
        if (r2.a().k) {
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

    public final void a(List list, RadioGroup radioGroup, int i) {
        if (i < 0 || i >= list.size()) {
            return;
        }
        r2.a().b(((String[]) list.get(i))[0]);
        h2.a = null;
        h2.b = null;
        h2.c.clear();
        k();
        j();
    }

    public final FrameLayout a(BitmapDrawable bitmapDrawable, String str, String str2, final String str3, int i, boolean z, View.OnClickListener onClickListener) {
        float[] fArr;
        int color;
        FrameLayout frameLayout = new FrameLayout(this);
        int iA = a(str2 != null ? 12.0f : 14.0f);
        frameLayout.setPadding(0, iA, 0, iA);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.a ? l : -1);
        float fA = a(8.0f);
        if (i == 0) {
            fArr = new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i == 1) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, fA, fA, fA, fA};
        } else if (i != 2) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        } else {
            fArr = new float[]{fA, fA, fA, fA, fA, fA, fA, fA};
        }
        gradientDrawable.setCornerRadii(fArr);
        frameLayout.setBackground(gradientDrawable);
        boolean z2 = (str3 == null && onClickListener == null) ? false : true;
        if (z2) {
            frameLayout.setOnClickListener(onClickListener != null ? onClickListener : new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    this.f$0.a(str3, view);
                }
            });
        }
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(bitmapDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams.leftMargin = a(16.0f);
        layoutParams.gravity = 19;
        frameLayout.addView(imageView, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(this.a ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout.addView(textView);
        if (str2 != null) {
            TextView textView2 = new TextView(this);
            textView2.setText(str2);
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(m);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = a(4.0f);
            linearLayout.addView(textView2, layoutParams2);
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = a(48.0f);
        layoutParams3.rightMargin = z2 ? a(52.0f) : a(16.0f);
        layoutParams3.gravity = 19;
        frameLayout.addView(linearLayout, layoutParams3);
        if (z2) {
            if (z) {
                TextView textView3 = new TextView(this);
                textView3.setText(o2.a().a("mod_update_download"));
                textView3.setTextSize(2, 13.0f);
                textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
                textView3.setTextColor(-1);
                textView3.setGravity(17);
                textView3.setPadding(a(14.0f), a(6.0f), a(14.0f), a(6.0f));
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                if (r2.a().d()) {
                    color = k5.a();
                } else {
                    color = Color.parseColor("#FE2B54");
                }
                gradientDrawable2.setColor(color);
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
            imageView2.setColorFilter(o);
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
        textView.setTextColor(n);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setPadding(a(28.0f), a(16.0f), 0, a(12.0f));
        return textView;
    }

    public final CheckBox a(String str, String str2, boolean z, final z3 z3Var) {
        int color;
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
        int color2 = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = {R.attr.state_checked};
        if (r2.a().d()) {
            color = k5.a();
        } else {
            color = Color.parseColor("#FE2B54");
        }
        stateListDrawable.addState(iArr, a("ic_check_active", color));
        stateListDrawable.addState(new int[0], a("ic_check_inactive", color2));
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
                this.f$0.a(z3Var, compoundButton, z2);
            }
        });
        return checkBox;
    }

    public final  void a(z3 z3Var, CompoundButton compoundButton, boolean z) {
        if (z3Var != null) {
            z3Var.a(z);
        }
        j();
    }

    public final int a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public static Bitmap a(j3 j3Var, String str) {
        try {
            InputStream inputStreamOpen = j3Var.getAssets().open("mod_icons/" + str + ".png");
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

    public final BitmapDrawable a(String str, int i) {
        Bitmap bitmapB = b(str);
        BitmapDrawable bitmapDrawable = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
        if (bitmapDrawable != null) {
            bitmapDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
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
        String strA = o2.a().a("bulletin_button");
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
        textView2.setText(o2.a().a("bulletin_title"));
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(this.a ? -16777216 : -1);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this);
        textView3.setText(o2.a().a("bulletin_subtitle"));
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
