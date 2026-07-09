package X;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.DigitsKeyListener;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class vb extends BaseActivity {
    public static boolean r;
    public static final int s = Color.parseColor("#F5F5F5");
    public static final int t = Color.parseColor("#1E1E1E");
    public static final int u = Color.parseColor("#858585");
    public static final int v = Color.parseColor("#888888");
    public static final int w = Color.parseColor("#777778");
    public static final int[] x = {-1142217, -12726936, -5616918, -1226807, -12165909, -12342807, -1424314, -7763575};
    public boolean a;
    public int b;
    public int c;
    public FrameLayout d;
    public FrameLayout e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public int j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public LinearLayout o;
    public LinearLayout p;
    public String q;

    public static int o() {
        return l8.a().d() ? hd.a() : Color.parseColor("#FE2B54");
    }

    public final void a(d5 d5Var, View view) {
        if (d5Var.a.equals(this.q)) {
            return;
        }
        String str = d5Var.a;
        this.q = str;
        e5.a((Context) this, str);
        if (this.p != null) {
            for (int i = 0; i < this.p.getChildCount(); i++) {
                View childAt = this.p.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (viewGroup.getChildCount() >= 2) {
                        String str2 = this.q;
                        boolean z = str2 != null && str2.equals(viewGroup.getTag());
                        View childAt2 = viewGroup.getChildAt(0);
                        if (childAt2 instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) childAt2;
                            if (viewGroup2.getChildCount() > 0) {
                                viewGroup2.getChildAt(0).setVisibility(z ? 0 : 4);
                            }
                        }
                        View childAt3 = viewGroup.getChildAt(1);
                        if (childAt3 instanceof TextView) {
                            ((TextView) childAt3).setTextColor(z ? o() : u);
                        }
                    }
                }
            }
        }
        s();
    }

    public final LinearLayout b() {
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        String strA = f5.a().a("antiburnout_show_on_main");
        boolean z = l8.a().f;
        final l8 l8VarA = l8.a();
        Objects.requireNonNull(l8VarA);
        linearLayoutF.addView(a(strA, "ic_antiburnin_show_on_main_page", z, new tb() {
            @Override
            public final void a(boolean z2) {
                l8VarA.d(z2);
            }
        }));
        String strA2 = f5.a().a("antiburnout_enable_on_start");
        boolean z2 = l8.a().g;
        final l8 l8VarA2 = l8.a();
        Objects.requireNonNull(l8VarA2);
        linearLayoutF.addView(a(strA2, "ic_antiburnin_enable_on_start", z2, new tb() {
            @Override
            public final void a(boolean z3) {
                l8VarA2.b(z3);
            }
        }));
        String strA3 = f5.a().a("feed_overlay_opacity");
        int i = l8.a().m;
        final l8 l8VarA3 = l8.a();
        Objects.requireNonNull(l8VarA3);
        sb sbVar = new sb() {
            @Override
            public final void a(int i2) {
                l8VarA3.b(i2);
            }
        };
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(a(16.0f), a(12.0f), a(16.0f), a(8.0f));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b("ic_antiburnin_opacity"));
        linearLayout2.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView = new TextView(this);
        textView.setText(strA3);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setTextColor(this.a ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout2.addView(textView, layoutParams);
        TextView textView2 = new TextView(this);
        textView2.setText(i + "%");
        textView2.setTextSize(2, 14.0f);
        int i2 = u;
        textView2.setTextColor(i2);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        SeekBar seekBar = new SeekBar(this);
        seekBar.setMax(100);
        seekBar.setProgress(i);
        seekBar.setOnSeekBarChangeListener(new pb(this, textView2, sbVar));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(4.0f);
        linearLayout.addView(seekBar, layoutParams2);
        linearLayoutF.addView(linearLayout);
        TextView textView3 = new TextView(this);
        textView3.setText(f5.a().a("feed_overlay_opacity_hint"));
        textView3.setTextSize(2, 13.0f);
        textView3.setTextColor(i2);
        textView3.setPadding(a(16.0f), a(4.0f), a(16.0f), a(8.0f));
        linearLayoutF.addView(textView3);
        return linearLayoutF;
    }

    public final LinearLayout c() {
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        final LinearLayout linearLayoutD = d();
        linearLayoutD.setVisibility(l8.a().n ? 0 : 8);
        linearLayoutF.addView(a(f5.a().a("auto_streak_toggle"), "ic_autotease", l8.a().n, new tb() {
            @Override
            public final void a(boolean z) {
                vb.a(linearLayoutD, z);
            }
        }));
        linearLayoutF.addView(linearLayoutD);
        return linearLayoutF;
    }

    public final LinearLayout d() {
        this.i = new TextView(this);
        LinearLayout linearLayoutA = a("ic_clock", f5.a().a("auto_streak_nudge_time"), this.i, new Runnable() {
            @Override
            public final void run() {
                this.f$0.r();
            }
        });
        TextView textView = this.i;
        if (textView == null) {
            return linearLayoutA;
        }
        textView.setText(String.format(Locale.US, "%02d:%02d", Integer.valueOf(l8.a().o), Integer.valueOf(l8.a().p)));
        return linearLayoutA;
    }

    public final void e(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, a(6.0f), 0.0f, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new CycleInterpolator(4.0f));
        view.startAnimation(translateAnimation);
    }

    public final  void f(View view) {
        startActivityForResult(new Intent((Context) this, (Class<?>) xa.class), 1002);
    }

    public final void g(View view) {
        ConcurrentHashMap concurrentHashMap = d1.a;
        d1.b((Activity) this, (Fragment) null, new f1("", "asset:supporter.png", true, false, null, null));
    }

    public final LinearLayout h() {
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        this.k = new TextView(this);
        linearLayoutF.addView(a("ic_pencil", f5.a().a("filter_words"), this.k, new Runnable() {
            @Override
            public final void run() {
                this.f$0.p();
            }
        }));
        this.l = new TextView(this);
        linearLayoutF.addView(a("ic_like", f5.a().a("filter_likes"), this.l, new Runnable() {
            @Override
            public final void run() {
                this.f$0.u();
            }
        }));
        this.m = new TextView(this);
        linearLayoutF.addView(a("ic_views", f5.a().a("filter_views"), this.m, new Runnable() {
            @Override
            public final void run() {
                this.f$0.v();
            }
        }));
        this.n = new TextView(this);
        linearLayoutF.addView(a("ic_clock", f5.a().a("filter_publish_date"), this.n, new Runnable() {
            @Override
            public final void run() {
                this.f$0.t();
            }
        }));
        x();
        return linearLayoutF;
    }

    public final LinearLayout i() {
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        String strA = f5.a().a("hide_lives");
        boolean z = l8.a().b;
        final l8 l8VarA = l8.a();
        Objects.requireNonNull(l8VarA);
        linearLayoutF.addView(a(strA, "ic_live", z, new tb() {
            @Override
            public final void a(boolean z2) {
                l8VarA.h(z2);
            }
        }));
        String strA2 = f5.a().a("hide_ads");
        boolean z2 = l8.a().c;
        final l8 l8VarA2 = l8.a();
        Objects.requireNonNull(l8VarA2);
        linearLayoutF.addView(a(strA2, "ic_ads", z2, new tb() {
            @Override
            public final void a(boolean z3) {
                l8VarA2.g(z3);
            }
        }));
        String strA3 = f5.a().a("hide_photos");
        boolean z3 = l8.a().d;
        final l8 l8VarA3 = l8.a();
        Objects.requireNonNull(l8VarA3);
        linearLayoutF.addView(a(strA3, "ic_photo_disable", z3, new tb() {
            @Override
            public final void a(boolean z4) {
                l8VarA3.i(z4);
            }
        }));
        String strA4 = f5.a().a("hide_stories");
        boolean z4 = l8.a().h;
        final l8 l8VarA4 = l8.a();
        Objects.requireNonNull(l8VarA4);
        linearLayoutF.addView(a(strA4, "ic_hidestory", z4, new tb() {
            @Override
            public final void a(boolean z5) {
                l8VarA4.j(z5);
            }
        }));
        return linearLayoutF;
    }

    public final LinearLayout j() {
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        RadioGroup radioGroup = new RadioGroup(this);
        char c = 1;
        radioGroup.setOrientation(1);
        String str = l8.a().i;
        final ArrayList arrayList = new ArrayList();
        int i = 2;
        arrayList.add(new String[]{"default", f5.a().a("font_default"), "ic_font"});
        arrayList.add(new String[]{"system", f5.a().a("font_system"), "ic_system_font"});
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
            radioButton.setTextSize(i, 16.0f);
            radioButton.setTypeface(Typeface.create("sans-serif-medium", 0));
            radioButton.setMinHeight(a(48.0f));
            radioButton.setTextColor(this.a ? -1 : -16777216);
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setBackground(null);
            radioButton.setPadding(a(16.0f), 0, a(16.0f), 0);
            int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_radio_active", o()));
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
            radioButton.setBackground(new RippleDrawable(ColorStateList.valueOf(this.a ? 872415231 : 520093696), null, new ColorDrawable(-1)));
            radioGroup.addView(radioButton);
            if (strArr[0].equals(str)) {
                i3 = i2;
            }
            i2++;
            c = 1;
            i = 2;
        }
        linearLayoutF.addView(radioGroup);
        linearLayoutF.addView(k());
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
        return linearLayoutF;
    }

    public final LinearLayout k() {
        this.f = new TextView(this);
        LinearLayout linearLayoutA = a("ic_font_file", f5.a().a("font_pick_file"), this.f, new Runnable() {
            @Override
            public final void run() {
                this.f$0.q();
            }
        });
        y();
        return linearLayoutA;
    }

    public final LinearLayout l() {
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        String strA = f5.a().a("skip_quality_picker");
        boolean z = l8.a().t;
        final l8 l8VarA = l8.a();
        Objects.requireNonNull(l8VarA);
        linearLayoutF.addView(a(strA, "ic_skip_download_selector", z, new tb() {
            @Override
            public final void a(boolean z2) {
                l8VarA.l(z2);
            }
        }));
        String strA2 = f5.a().a("force_progress_bar");
        boolean z2 = l8.a().j;
        final l8 l8VarA2 = l8.a();
        Objects.requireNonNull(l8VarA2);
        linearLayoutF.addView(a(strA2, "ic_videoslider", z2, new tb() {
            @Override
            public final void a(boolean z3) {
                l8VarA2.a(z3);
            }
        }));
        return linearLayoutF;
    }

    public final LinearLayout m() {
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        LinearLayout linearLayoutN = n();
        l8.a().getClass();
        linearLayoutN.setVisibility(0);
        CheckBox checkBoxA = a(f5.a().a("region_spoof"), "ic_globe", true, (tb) null);
        checkBoxA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                vb.a(compoundButton, z);
            }
        });
        checkBoxA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.e(view);
            }
        });
        linearLayoutF.addView(checkBoxA);
        linearLayoutF.addView(linearLayoutN);
        return linearLayoutF;
    }

    public final LinearLayout n() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(48.0f));
        linearLayout.setPadding(a(16.0f), 0, a(16.0f), 0);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.f(view);
            }
        });
        linearLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.a ? 872415231 : 520093696), null, new ColorDrawable(-1)));
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
        ia iaVarB = l8.a().b();
        ImageView imageView2 = this.h;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ka.a(this, iaVarB, a(20.0f)));
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            iaVarB.getClass();
            textView2.setText(f5.a().a(iaVarB.a, iaVarB.b));
        }
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageBitmap(b("ic_arrow_right"));
        imageView3.setColorFilter(w);
        linearLayout.addView(imageView3, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        return linearLayout;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        String string;
        int columnIndex;
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            if (i2 == -1) {
                if (this.h != null || this.g != null) {
                    ia iaVarB = l8.a().b();
                    ImageView imageView = this.h;
                    if (imageView != null) {
                        imageView.setImageDrawable(ka.a(this, iaVarB, a(20.0f)));
                    }
                    TextView textView = this.g;
                    if (textView != null) {
                        iaVarB.getClass();
                        textView.setText(f5.a().a(iaVarB.a, iaVarB.b));
                    }
                }
                s();
                return;
            }
            return;
        }
        if (i == 1004) {
            x();
            if (i2 == -1) {
                s();
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
                                l8.a().b("file:".concat(string));
                                x4.a = null;
                                x4.b = null;
                                x4.c.clear();
                                y();
                                s();
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
                int i4 = g5.a;
            }
            e3.getMessage();
            int i5 = g5.a;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l8.a((Context) this);
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
        this.d.setBackgroundColor(this.a ? -16777216 : s);
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
        textView.setText(f5.a().a("settings_title"));
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

    public final  void p() {
        startActivityForResult(new Intent((Context) this, (Class<?>) m4.class), 1004);
    }

    public final  void q() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "font/sfnt", "application/x-font-ttf", "application/x-font-otf", "application/octet-stream"});
        startActivityForResult(intent, 1001);
    }

    public final void r() {
        final l8 l8VarA = l8.a();
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                this.f$0.a(l8VarA, timePicker, i, i2);
            }
        }, l8VarA.o, l8VarA.p, DateFormat.is24HourFormat(this)).show();
    }

    public final void s() {
        if (this.e != null) {
            return;
        }
        this.e = e();
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

    public final void t() {
        boolean z = this.a;
        int i = z ? -14935010 : -1;
        int color = z ? -1 : Color.parseColor("#161823");
        boolean z2 = this.a;
        int i2 = z2 ? -6579293 : -9210757;
        int i3 = z2 ? -12961220 : -2434337;
        int iO = o();
        int color2 = this.a ? -13882322 : Color.parseColor("#F1F1F2");
        int i4 = this.a ? -1 : -16777216;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        float fA = a(20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(a(20.0f), a(10.0f), a(20.0f), a(22.0f));
        linearLayout.setClickable(true);
        a(linearLayout, i3);
        TextView textView = new TextView(this);
        textView.setText(f5.a().a("filter_date_sheet_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(color);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(f5.a().a("filter_date_sheet_desc"));
        textView2.setGravity(17);
        textView2.setTextSize(2, 13.5f);
        textView2.setTextColor(i2);
        textView2.setLineSpacing(a(2.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = a(6.0f);
        linearLayout.addView(textView2, layoutParams);
        int color3 = this.a ? -13882322 : Color.parseColor("#F1F1F2");
        int i5 = u;
        int i6 = this.a ? -1 : -16777216;
        final long[] jArr = {l8.a().z};
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        float fA2 = a(14.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color3);
        gradientDrawable2.setCornerRadius(fA2);
        linearLayout2.setBackground(gradientDrawable2);
        linearLayout2.setPadding(a(18.0f), a(4.0f), a(14.0f), a(4.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a(58.0f));
        layoutParams2.topMargin = a(24.0f);
        linearLayout.addView(linearLayout2, layoutParams2);
        TextView textView3 = new TextView(this);
        textView3.setText(f5.a().a("filter_input_from"));
        textView3.setTextSize(2, 16.0f);
        textView3.setTextColor(i5);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.rightMargin = a(12.0f);
        linearLayout2.addView(textView3, layoutParams3);
        final TextView textView4 = new TextView(this);
        textView4.setTextSize(2, 20.0f);
        textView4.setTextColor(i6);
        textView4.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView4.setSingleLine(true);
        long j = jArr[0];
        textView4.setText(j > 0 ? new SimpleDateFormat("dd.MM.yyyy", Locale.US).format(new Date(j * 1000)) : "");
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(jArr, textView4, view);
            }
        });
        linearLayout2.addView(textView4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView5 = new TextView(this);
        textView5.setText(f5.a().a("filter_reset"));
        textView5.setTextSize(2, 16.0f);
        textView5.setTextColor(iO);
        textView5.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView5.setPadding(a(12.0f), a(8.0f), a(4.0f), a(8.0f));
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(jArr, textView4, view);
            }
        });
        linearLayout2.addView(textView5, new LinearLayout.LayoutParams(-2, -2));
        TextView textView6 = new TextView(this);
        textView6.setText(f5.a().a("filter_save"));
        textView6.setGravity(17);
        textView6.setTextColor(-1);
        textView6.setTextSize(2, 15.0f);
        textView6.setTypeface(Typeface.create("sans-serif-medium", 1));
        float fA3 = a(26.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(iO);
        gradientDrawable3.setCornerRadius(fA3);
        textView6.setBackground(gradientDrawable3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, a(52.0f));
        layoutParams4.topMargin = a(24.0f);
        linearLayout.addView(textView6, layoutParams4);
        TextView textView7 = new TextView(this);
        textView7.setText(f5.a().a("filter_cancel"));
        textView7.setGravity(17);
        textView7.setTextColor(i4);
        textView7.setTextSize(2, 15.0f);
        textView7.setTypeface(Typeface.create("sans-serif-medium", 1));
        float fA4 = a(26.0f);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(color2);
        gradientDrawable4.setCornerRadius(fA4);
        textView7.setBackground(gradientDrawable4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, a(52.0f));
        layoutParams5.topMargin = a(12.0f);
        linearLayout.addView(textView7, layoutParams5);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 80));
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(frameLayout);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            attributes.dimAmount = 0.55f;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(jArr, dialog, view);
            }
        });
        dialog.show();
    }

    public final void u() {
        a(f5.a().a("filter_likes_sheet_title"), f5.a().a("filter_likes_sheet_desc"), l8.a().x, new rb() {
            @Override
            public final void a(long j) {
                this.f$0.a(j);
            }
        });
    }

    public final void v() {
        a(f5.a().a("filter_views_sheet_title"), f5.a().a("filter_views_sheet_desc"), l8.a().y, new rb() {
            @Override
            public final void a(long j) {
                this.f$0.b(j);
            }
        });
    }

    public final void w() {
        boolean z = this.a;
        int i = z ? -14935010 : -1;
        int color = z ? -1 : Color.parseColor("#161823");
        boolean z2 = this.a;
        int i2 = z2 ? -6579293 : -9210757;
        int i3 = z2 ? -12961220 : -2434337;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        float fA = a(20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(a(20.0f), a(10.0f), a(20.0f), a(22.0f));
        linearLayout.setClickable(true);
        a(linearLayout, i3);
        TextView textView = new TextView(this);
        textView.setText("DEBUG");
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(color);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText("Support list tools");
        textView2.setGravity(17);
        textView2.setTextSize(2, 13.5f);
        textView2.setTextColor(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = a(6.0f);
        linearLayout.addView(textView2, layoutParams);
        final Dialog dialog = new Dialog(this);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(22.0f);
        linearLayout.addView(linearLayout2, layoutParams2);
        linearLayout2.addView(a("ic_refresh", "Force refresh support list", (String) null, (String) null, 0, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(dialog, view);
            }
        }));
        linearLayout2.addView(a("ic_refresh", "Clean support list cache", (String) null, (String) null, 1, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.c(dialog, view);
            }
        }));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 80));
        dialog.requestWindowFeature(1);
        dialog.setContentView(frameLayout);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            attributes.dimAmount = 0.55f;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
        dialog.show();
    }

    public final void x() {
        l8 l8VarA = l8.a();
        TextView textView = this.k;
        if (textView != null) {
            if (l8VarA.w == null) {
                l8VarA.w = new LinkedHashSet();
            }
            textView.setText(String.valueOf(l8VarA.w.size()));
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setText(String.valueOf(l8VarA.x));
        }
        TextView textView3 = this.m;
        if (textView3 != null) {
            textView3.setText(String.valueOf(l8VarA.y));
        }
        TextView textView4 = this.n;
        if (textView4 != null) {
            long j = l8VarA.z;
            textView4.setText(j > 0 ? new SimpleDateFormat("dd.MM.yyyy", Locale.US).format(new Date(j * 1000)) : "");
        }
    }

    public final void y() {
        String strReplaceAll;
        if (this.f == null) {
            return;
        }
        String strSubstring = l8.a().i;
        if (strSubstring == null || !strSubstring.startsWith("file:")) {
            this.f.setText("");
            this.f.setVisibility(8);
            return;
        }
        Typeface typeface = x4.a;
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

    public final LinearLayout f() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.a ? t : -1);
        gradientDrawable.setCornerRadius(a(12.0f));
        linearLayout.setBackground(gradientDrawable);
        return linearLayout;
    }

    public final LinearLayout g() {
        BitmapDrawable bitmapDrawable;
        LinearLayout linearLayoutF = f();
        linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
        linearLayoutF.setClipToPadding(false);
        linearLayoutF.setClipChildren(false);
        boolean z = Build.VERSION.SDK_INT >= 31;
        boolean zD = l8.a().d();
        CheckBox checkBox = new CheckBox(this);
        checkBox.setSaveEnabled(false);
        checkBox.setText(f5.a().a("custom_colors"));
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(Typeface.create("sans-serif-medium", 0));
        checkBox.setMinHeight(a(48.0f));
        checkBox.setTextColor(this.a ? -1 : -16777216);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        checkBox.setPadding(a(16.0f), 0, a(16.0f), 0);
        int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_check_active", o()));
        stateListDrawable.addState(new int[0], a("ic_check_inactive", color));
        Bitmap bitmapB = b("ic_risovalca");
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
        checkBox.setChecked(zD);
        checkBox.setBackground(new RippleDrawable(ColorStateList.valueOf(this.a ? 872415231 : 520093696), null, new ColorDrawable(-1)));
        linearLayoutF.addView(checkBox);
        final HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setClipToPadding(false);
        horizontalScrollView.setClipChildren(false);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setPadding(a(16.0f), 0, a(16.0f), a(12.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.o = linearLayout;
        linearLayout.setOrientation(0);
        this.o.setPadding(0, 0, 0, 0);
        int i = l8.a().l;
        hd.c = false;
        if (z) {
            Context contextC = g5.c();
            FrameLayout frameLayoutA = a(contextC == null ? -16524603 : hd.a(contextC), i == 0);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(b("ic_system_colors"));
            int iA2 = a(16.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams.gravity = 17;
            frameLayoutA.addView(imageView, layoutParams);
            this.o.addView(frameLayoutA);
        }
        int[] iArr = x;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            this.o.addView(a(i3, i3 == i));
        }
        hd.c = true;
        horizontalScrollView.addView(this.o);
        horizontalScrollView.setVisibility(zD ? 0 : 8);
        linearLayoutF.addView(horizontalScrollView);
        final TextView textView = new TextView(this);
        textView.setText(f5.a().a("custom_colors_desc"));
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(u);
        textView.setPadding(a(16.0f), 0, a(16.0f), a(12.0f));
        textView.setVisibility(zD ? 0 : 8);
        linearLayoutF.addView(textView);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f$0.a(horizontalScrollView, textView, compoundButton, z2);
            }
        });
        return linearLayoutF;
    }

    public final FrameLayout e() {
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
        String strA = f5.a().a("bulletin_button");
        textView.setText(strA);
        textView.setTextColor(-1);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setGravity(17);
        textView.setPadding(a(20.0f), 0, a(20.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(o());
        gradientDrawable2.setCornerRadius(a(68.0f));
        textView.setBackground(gradientDrawable2);
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        int iA3 = a(16.0f) + a(40.0f) + ((int) paint.measureText(strA));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView textView2 = new TextView(this);
        textView2.setText(f5.a().a("bulletin_title"));
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(this.a ? -16777216 : -1);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this);
        textView3.setText(f5.a().a("bulletin_subtitle"));
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
                this.f$0.d(view);
            }
        });
        return frameLayout;
    }

    public final void d(View view) {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(335544320);
            startActivity(launchIntentForPackage);
        }
        Runtime.getRuntime().exit(0);
    }

    public final void a(FrameLayout frameLayout, final ScrollView scrollView, final TextView textView) {
        View view = new View(this);
        view.setBackgroundColor(this.a ? -16777216 : s);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a(56.0f) + this.b);
        layoutParams.gravity = 48;
        frameLayout.addView(view, layoutParams);
        final TextView textView2 = new TextView(this);
        textView2.setText(f5.a().a("settings_title"));
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

    public final  boolean c(View view) {
        w();
        return true;
    }

    public final void c(Dialog dialog, View view) {
        int i;
        Context applicationContext = getApplicationContext();
        ConcurrentHashMap concurrentHashMap = d1.a;
        if (applicationContext == null) {
            i = 0;
        } else {
            File file = new File(d0.a(applicationContext), "supporters_cache.txt");
            i = (file.exists() && file.delete()) ? 1 : 0;
            File file2 = new File(d0.a(applicationContext), "supporters_fetch.stamp");
            if (file2.exists() && file2.delete()) {
                i++;
            }
            d1.o.set(false);
            int i2 = g5.a;
        }
        Toast.makeText((Context) this, (CharSequence) ("Support list cache cleaned: " + i), 0).show();
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Throwable th) {
            }
        }
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
        int iA;
        int color;
        Bitmap bitmapDecodeStream;
        boolean z;
        BitmapDrawable bitmapDrawable;
        int i;
        ArrayList arrayListA;
        int size;
        d5 d5Var;
        InputStream inputStreamOpen;
        linearLayout.addView(textView);
        if (r) {
            linearLayout.addView(a("ic_mod_update", f5.a().a("mod_update"), (String) null, "https://t.me/tikyoutok", 0, true, (View.OnClickListener) null));
        }
        int i2 = 0;
        linearLayout.addView(a("ic_telegram", f5.a().a("telegram_channel"), (String) null, "https://t.me/tikyoutok", r ? 3 : 0, false, (View.OnClickListener) null));
        l8 l8VarA = l8.a();
        d5 d5Var2 = null;
        try {
            try {
                if (l8VarA != null && l8VarA.l == 0) {
                    try {
                        int identifier = getResources().getIdentifier("system_accent3_400", "color", "android");
                        if (identifier != 0) {
                            color = getResources().getColor(identifier, null);
                        } else {
                            Context contextC = g5.c();
                            if (contextC == null) {
                                color = -16524603;
                            } else {
                                iA = hd.a(contextC);
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
                        z = hd.c;
                        hd.c = false;
                        try {
                            paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
                            hd.c = z;
                            canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                            bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap);
                        } catch (Throwable th2) {
                            hd.c = z;
                            throw th2;
                        }
                    }
                    linearLayout.addView(a(bitmapDrawable, f5.a().a("support_project"), (String) null, (String) null, 1, false, new View.OnClickListener() {
                        @Override
                        public final void onClick(View view) {
                            this.f$0.g(view);
                        }
                    }));
                    linearLayout.addView(a(f5.a().a("section_region")));
                    linearLayout.addView(m());
                    linearLayout.addView(a(f5.a().a("section_content_filter")));
                    linearLayout.addView(h());
                    linearLayout.addView(a(f5.a().a("section_feed")));
                    linearLayout.addView(i());
                    linearLayout.addView(a(f5.a().a("section_misc")));
                    linearLayout.addView(l());
                    linearLayout.addView(a(f5.a().a("section_autostreak")));
                    linearLayout.addView(c());
                    linearLayout.addView(a(f5.a().a("anti_burnout")));
                    linearLayout.addView(b());
                    linearLayout.addView(a(f5.a().a("section_font")));
                    linearLayout.addView(j());
                    linearLayout.addView(a(f5.a().a("section_appearance")));
                    linearLayout.addView(g());
                    LinearLayout linearLayoutF = f();
                    linearLayoutF.setPadding(0, a(4.0f), 0, a(4.0f));
                    linearLayoutF.setClipToPadding(false);
                    linearLayoutF.setClipChildren(false);
                    LinearLayout linearLayout2 = new LinearLayout(this);
                    linearLayout2.setOrientation(0);
                    linearLayout2.setGravity(16);
                    linearLayout2.setMinimumHeight(a(48.0f));
                    linearLayout2.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
                    ImageView imageView = new ImageView(this);
                    imageView.setImageBitmap(b("ic_mod_logo"));
                    linearLayout2.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
                    TextView textView2 = new TextView(this);
                    textView2.setText(f5.a().a("app_icon"));
                    textView2.setTextSize(2, 16.0f);
                    textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
                    if (this.a) {
                        i = -1;
                    } else {
                        i = -16777216;
                    }
                    textView2.setTextColor(i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                    layoutParams.leftMargin = a(12.0f);
                    linearLayout2.addView(textView2, layoutParams);
                    linearLayoutF.addView(linearLayout2);
                    HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
                    horizontalScrollView.setHorizontalScrollBarEnabled(false);
                    horizontalScrollView.setClipToPadding(false);
                    horizontalScrollView.setClipChildren(false);
                    horizontalScrollView.setOverScrollMode(2);
                    horizontalScrollView.setPadding(a(16.0f), a(4.0f), a(16.0f), a(12.0f));
                    LinearLayout linearLayout3 = new LinearLayout(this);
                    this.p = linearLayout3;
                    linearLayout3.setOrientation(0);
                    this.q = e5.a();
                    boolean z2 = l8.a().r;
                    arrayListA = e5.a((Context) this);
                    size = arrayListA.size();
                    while (i2 < size) {
                        Object obj = arrayListA.get(i2);
                        i2++;
                        d5Var = (d5) obj;
                        if ("md".equals(d5Var.a)) {
                            d5Var2 = d5Var;
                        } else {
                            this.p.addView(a(d5Var, d5Var.a.equals(this.q)));
                        }
                    }
                    if (d5Var2 != null && z2) {
                        this.p.addView(a(d5Var2, "md".equals(this.q)));
                    }
                    horizontalScrollView.addView(this.p);
                    linearLayoutF.addView(horizontalScrollView);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = a(10.0f);
                    linearLayout.addView(linearLayoutF, layoutParams2);
                    linearLayout.addView(a(f5.a().a("section_about")));
                    linearLayout.addView(a());
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
                if (bitmapDecodeStream == null) {
                    bitmapDrawable = null;
                } else {
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                    Paint paint2 = new Paint(3);
                    z = hd.c;
                    hd.c = false;
                    paint2.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
                    hd.c = z;
                    canvas2.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint2);
                    bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap2);
                }
                linearLayout.addView(a(bitmapDrawable, f5.a().a("support_project"), (String) null, (String) null, 1, false, new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        this.f$0.g(view);
                    }
                }));
                linearLayout.addView(a(f5.a().a("section_region")));
                linearLayout.addView(m());
                linearLayout.addView(a(f5.a().a("section_content_filter")));
                linearLayout.addView(h());
                linearLayout.addView(a(f5.a().a("section_feed")));
                linearLayout.addView(i());
                linearLayout.addView(a(f5.a().a("section_misc")));
                linearLayout.addView(l());
                linearLayout.addView(a(f5.a().a("section_autostreak")));
                linearLayout.addView(c());
                linearLayout.addView(a(f5.a().a("anti_burnout")));
                linearLayout.addView(b());
                linearLayout.addView(a(f5.a().a("section_font")));
                linearLayout.addView(j());
                linearLayout.addView(a(f5.a().a("section_appearance")));
                linearLayout.addView(g());
                LinearLayout linearLayoutF2 = f();
                linearLayoutF2.setPadding(0, a(4.0f), 0, a(4.0f));
                linearLayoutF2.setClipToPadding(false);
                linearLayoutF2.setClipChildren(false);
                LinearLayout linearLayout4 = new LinearLayout(this);
                linearLayout4.setOrientation(0);
                linearLayout4.setGravity(16);
                linearLayout4.setMinimumHeight(a(48.0f));
                linearLayout4.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
                ImageView imageView2 = new ImageView(this);
                imageView2.setImageBitmap(b("ic_mod_logo"));
                linearLayout4.addView(imageView2, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
                TextView textView3 = new TextView(this);
                textView3.setText(f5.a().a("app_icon"));
                textView3.setTextSize(2, 16.0f);
                textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
                if (this.a) {
                    i = -1;
                } else {
                    i = -16777216;
                }
                textView3.setTextColor(i);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                layoutParams3.leftMargin = a(12.0f);
                linearLayout4.addView(textView3, layoutParams3);
                linearLayoutF2.addView(linearLayout4);
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(this);
                horizontalScrollView2.setHorizontalScrollBarEnabled(false);
                horizontalScrollView2.setClipToPadding(false);
                horizontalScrollView2.setClipChildren(false);
                horizontalScrollView2.setOverScrollMode(2);
                horizontalScrollView2.setPadding(a(16.0f), a(4.0f), a(16.0f), a(12.0f));
                LinearLayout linearLayout5 = new LinearLayout(this);
                this.p = linearLayout5;
                linearLayout5.setOrientation(0);
                this.q = e5.a();
                boolean z3 = l8.a().r;
                arrayListA = e5.a((Context) this);
                size = arrayListA.size();
                while (i2 < size) {
                    Object obj2 = arrayListA.get(i2);
                    i2++;
                    d5Var = (d5) obj2;
                    if ("md".equals(d5Var.a)) {
                        d5Var2 = d5Var;
                    } else {
                        this.p.addView(a(d5Var, d5Var.a.equals(this.q)));
                    }
                }
                if (d5Var2 != null) {
                    this.p.addView(a(d5Var2, "md".equals(this.q)));
                }
                horizontalScrollView2.addView(this.p);
                linearLayoutF2.addView(horizontalScrollView2);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.topMargin = a(10.0f);
                linearLayout.addView(linearLayoutF2, layoutParams4);
                linearLayout.addView(a(f5.a().a("section_about")));
                linearLayout.addView(a());
                linearLayout.addView(new Space(this), new LinearLayout.LayoutParams(-1, a(20.0f)));
            }
            inputStreamOpen = getAssets().open("developer.png");
        } catch (IOException e) {
            bitmapDecodeStream = null;
        }
        color = iA;
        if (bitmapDecodeStream == null) {
            bitmapDrawable = null;
        } else {
            Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(bitmapCreateBitmap3);
            Paint paint3 = new Paint(3);
            z = hd.c;
            hd.c = false;
            paint3.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
            hd.c = z;
            canvas3.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint3);
            bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap3);
        }
        linearLayout.addView(a(bitmapDrawable, f5.a().a("support_project"), (String) null, (String) null, 1, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.g(view);
            }
        }));
        linearLayout.addView(a(f5.a().a("section_region")));
        linearLayout.addView(m());
        linearLayout.addView(a(f5.a().a("section_content_filter")));
        linearLayout.addView(h());
        linearLayout.addView(a(f5.a().a("section_feed")));
        linearLayout.addView(i());
        linearLayout.addView(a(f5.a().a("section_misc")));
        linearLayout.addView(l());
        linearLayout.addView(a(f5.a().a("section_autostreak")));
        linearLayout.addView(c());
        linearLayout.addView(a(f5.a().a("anti_burnout")));
        linearLayout.addView(b());
        linearLayout.addView(a(f5.a().a("section_font")));
        linearLayout.addView(j());
        linearLayout.addView(a(f5.a().a("section_appearance")));
        linearLayout.addView(g());
        LinearLayout linearLayoutF3 = f();
        linearLayoutF3.setPadding(0, a(4.0f), 0, a(4.0f));
        linearLayoutF3.setClipToPadding(false);
        linearLayoutF3.setClipChildren(false);
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(16);
        linearLayout6.setMinimumHeight(a(48.0f));
        linearLayout6.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageBitmap(b("ic_mod_logo"));
        linearLayout6.addView(imageView3, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView4 = new TextView(this);
        textView4.setText(f5.a().a("app_icon"));
        textView4.setTextSize(2, 16.0f);
        textView4.setTypeface(Typeface.create("sans-serif-medium", 0));
        if (this.a) {
            i = -1;
        } else {
            i = -16777216;
        }
        textView4.setTextColor(i);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams5.leftMargin = a(12.0f);
        linearLayout6.addView(textView4, layoutParams5);
        linearLayoutF3.addView(linearLayout6);
        HorizontalScrollView horizontalScrollView3 = new HorizontalScrollView(this);
        horizontalScrollView3.setHorizontalScrollBarEnabled(false);
        horizontalScrollView3.setClipToPadding(false);
        horizontalScrollView3.setClipChildren(false);
        horizontalScrollView3.setOverScrollMode(2);
        horizontalScrollView3.setPadding(a(16.0f), a(4.0f), a(16.0f), a(12.0f));
        LinearLayout linearLayout7 = new LinearLayout(this);
        this.p = linearLayout7;
        linearLayout7.setOrientation(0);
        this.q = e5.a();
        boolean z4 = l8.a().r;
        arrayListA = e5.a((Context) this);
        size = arrayListA.size();
        while (i2 < size) {
            Object obj3 = arrayListA.get(i2);
            i2++;
            d5Var = (d5) obj3;
            if ("md".equals(d5Var.a)) {
                d5Var2 = d5Var;
            } else {
                this.p.addView(a(d5Var, d5Var.a.equals(this.q)));
            }
        }
        if (d5Var2 != null) {
            this.p.addView(a(d5Var2, "md".equals(this.q)));
        }
        horizontalScrollView3.addView(this.p);
        linearLayoutF3.addView(horizontalScrollView3);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = a(10.0f);
        linearLayout.addView(linearLayoutF3, layoutParams6);
        linearLayout.addView(a(f5.a().a("section_about")));
        linearLayout.addView(a());
        linearLayout.addView(new Space(this), new LinearLayout.LayoutParams(-1, a(20.0f)));
    }

    public final  void b(long j) {
        l8.a().c(j);
        x();
        s();
    }

    public final  void b(long[] jArr, TextView textView, View view) {
        jArr[0] = 0;
        textView.setText("");
        l8.a().b(0L);
        x();
        s();
    }

    public final void b(View view) {
        int i = this.j + 1;
        this.j = i;
        if (i < 7) {
            return;
        }
        this.j = 0;
        boolean z = l8.a().r;
        l8.a().k(!z);
        Toast.makeText((Context) this, (CharSequence) f5.a().a(!z ? "rainbow_mode_enabled" : "rainbow_mode_disabled"), 0).show();
        s();
    }

    public final void b(Dialog dialog, View view) {
        Toast.makeText((Context) this, (CharSequence) (d1.a(getApplicationContext(), true, new c1() {
            @Override
            public final void a(boolean z, int i, String str) {
                this.f$0.a(z, i, str);
            }
        }) ? "Support list refresh started" : "Support list refresh already running"), 0).show();
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Throwable th) {
            }
        }
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

    public static  void a(CompoundButton compoundButton, boolean z) {
        if (z) {
            return;
        }
        compoundButton.setChecked(true);
    }

    public final void a(HorizontalScrollView horizontalScrollView, TextView textView, CompoundButton compoundButton, boolean z) {
        l8.a().f(z);
        horizontalScrollView.setVisibility(z ? 0 : 8);
        textView.setVisibility(z ? 0 : 8);
        hd.a = 0;
        hd.b = 0;
        s();
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
        int iIndexOfChild = this.o.indexOfChild(frameLayout);
        if (Build.VERSION.SDK_INT >= 31 && iIndexOfChild == 0) {
            i = 0;
        }
        l8.a().a(i);
        hd.a = 0;
        hd.b = 0;
        hd.c = false;
        int i2 = 0;
        while (i2 < this.o.getChildCount()) {
            FrameLayout frameLayout2 = (FrameLayout) this.o.getChildAt(i2);
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
        hd.c = true;
        s();
    }

    public static void a(View view, boolean z) {
        l8.a().e(z);
        view.setVisibility(z ? 0 : 8);
        Handler handler = z.a;
        Context contextC = g5.c();
        if (contextC == null) {
            return;
        }
        z.b(contextC);
        if (l8.a().n) {
            z.c(contextC);
            if (z.b.compareAndSet(false, true)) {
                Handler handler2 = z.a;
                y yVar = z.e;
                handler2.removeCallbacks(yVar);
                handler2.postDelayed(yVar, 300000L);
            }
            z.c(contextC, "settings");
            return;
        }
        z.a(contextC);
        z.b.set(false);
        z.a.removeCallbacks(z.e);
    }

    public final LinearLayout a(final d5 d5Var, boolean z) {
        int iA = a(46.0f);
        int iA2 = a(4.0f);
        int i = (iA2 * 2) + iA;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setTag(d5Var.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = a(12.0f);
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        int iA3 = a(12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(iA2 + iA3);
        gradientDrawable.setStroke(a(2.0f), o());
        View view = new View(this);
        view.setBackground(gradientDrawable);
        view.setVisibility(z ? 0 : 4);
        frameLayout.addView(view, new FrameLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(this);
        Drawable drawableA = e5.a(this, d5Var);
        if (drawableA instanceof AdaptiveIconDrawable) {
            AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawableA;
            Drawable background = adaptiveIconDrawable.getBackground();
            Drawable foreground = adaptiveIconDrawable.getForeground();
            if (background == null) {
                background = new ColorDrawable(0);
            }
            if (foreground == null) {
                foreground = new ColorDrawable(0);
            }
            drawableA = new LayerDrawable(new Drawable[]{background, foreground});
        }
        if (drawableA != null) {
            imageView.setImageDrawable(drawableA);
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(new ob(iA3));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = 17;
        frameLayout.addView(imageView, layoutParams2);
        linearLayout.addView(frameLayout);
        TextView textView = new TextView(this);
        textView.setText(d5Var.a());
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setTextColor(z ? o() : u);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(a(8.0f) + i, -2);
        layoutParams3.topMargin = a(6.0f);
        linearLayout.addView(textView, layoutParams3);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                this.f$0.a(d5Var, view2);
            }
        });
        return linearLayout;
    }

    public final void a(l8 l8Var, TimePicker timePicker, int i, int i2) {
        l8Var.a(i, i2);
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(String.format(Locale.US, "%02d:%02d", Integer.valueOf(l8.a().o), Integer.valueOf(l8.a().p)));
        }
        Handler handler = z.a;
        Context contextC = g5.c();
        if (contextC == null) {
            return;
        }
        z.b(contextC);
        if (l8.a().n) {
            z.c(contextC);
            if (z.b.compareAndSet(false, true)) {
                Handler handler2 = z.a;
                y yVar = z.e;
                handler2.removeCallbacks(yVar);
                handler2.postDelayed(yVar, 300000L);
            }
            z.c(contextC, "settings");
            return;
        }
        z.a(contextC);
        z.b.set(false);
        z.a.removeCallbacks(z.e);
    }

    public final void a(List list, RadioGroup radioGroup, int i) {
        if (i < 0 || i >= list.size()) {
            return;
        }
        l8.a().b(((String[]) list.get(i))[0]);
        x4.a = null;
        x4.b = null;
        x4.c.clear();
        y();
        s();
    }

    public final LinearLayout a(String str, String str2, TextView textView, final Runnable runnable) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(48.0f));
        linearLayout.setPadding(a(16.0f), 0, a(16.0f), 0);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                runnable.run();
            }
        });
        linearLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.a ? 872415231 : 520093696), null, new ColorDrawable(-1)));
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b(str));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setTextColor(this.a ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(textView2, layoutParams);
        if (textView != null) {
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(u);
            textView.setSingleLine(true);
            linearLayout.addView(textView);
        }
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(b("ic_arrow_right"));
        imageView2.setColorFilter(w);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams2.leftMargin = a(8.0f);
        linearLayout.addView(imageView2, layoutParams2);
        return linearLayout;
    }

    public final  void a(long j) {
        l8.a().a(j);
        x();
        s();
    }

    public final void a(String str, String str2, long j, final rb rbVar) {
        final qb qbVarA = a(str, str2);
        final EditText editText = qbVarA.a;
        editText.setInputType(2);
        editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        if (j > 0) {
            editText.setText(String.valueOf(j));
        }
        editText.setSelection(editText.getText().length());
        Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                vb.a(editText, qbVarA);
            }
        };
        editText.addTextChangedListener(new ub(runnable));
        runnable.run();
        qbVarA.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                vb.a(editText, rbVar, qbVarA, view);
            }
        });
        qbVarA.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                vb.a(editText, rbVar, view);
            }
        });
        qbVarA.e.run();
    }

    public static  void a(EditText editText, qb qbVar) {
        String strTrim = editText.getText().toString().trim();
        if (strTrim.isEmpty()) {
            qbVar.a((String) null);
            qbVar.a(true);
            return;
        }
        try {
            if (Long.parseLong(strTrim) > 100000000000L) {
                qbVar.a(f5.a().a("filter_error_too_big"));
                qbVar.a(false);
            } else {
                qbVar.a((String) null);
                qbVar.a(true);
            }
        } catch (NumberFormatException e) {
            qbVar.a(f5.a().a("filter_error_too_big"));
            qbVar.a(false);
        }
    }

    public static  void a(EditText editText, rb rbVar, qb qbVar, View view) {
        long j;
        String strTrim = editText.getText().toString().trim();
        if (strTrim.isEmpty()) {
            j = 0;
        } else {
            try {
                j = Long.parseLong(strTrim);
                if (j > 100000000000L) {
                    return;
                }
            } catch (NumberFormatException e) {
                return;
            }
        }
        rbVar.a(j);
        qbVar.f.run();
    }

    public static  void a(EditText editText, rb rbVar, View view) {
        editText.setText("");
        rbVar.a(0L);
    }

    public final  void a(final long[] jArr, final TextView textView, View view) {
        Calendar calendar = Calendar.getInstance();
        long j = jArr[0];
        if (j > 0) {
            calendar.setTimeInMillis(j * 1000);
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.a(jArr, textView, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    public final void a(long[] jArr, TextView textView, DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3, 0, 0, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis() / 1000;
        jArr[0] = timeInMillis;
        textView.setText(new SimpleDateFormat("dd.MM.yyyy", Locale.US).format(new Date(timeInMillis * 1000)));
    }

    public final  void a(long[] jArr, Dialog dialog, View view) {
        l8.a().b(Math.max(0L, jArr[0]));
        x();
        s();
        try {
            dialog.dismiss();
        } catch (Throwable th) {
        }
    }

    public final qb a(String str, String str2) {
        boolean z = this.a;
        int i = z ? -14935010 : -1;
        int color = z ? -1 : Color.parseColor("#161823");
        boolean z2 = this.a;
        int i2 = z2 ? -6579293 : -9210757;
        int i3 = z2 ? -12961220 : -2434337;
        int color2 = z2 ? -13882322 : Color.parseColor("#F1F1F2");
        int i4 = u;
        int iO = o();
        int color3 = this.a ? -13882322 : Color.parseColor("#F1F1F2");
        int i5 = this.a ? -1 : -16777216;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        float fA = a(20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(a(20.0f), a(10.0f), a(20.0f), a(22.0f));
        linearLayout.setClickable(true);
        a(linearLayout, i3);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(color);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setGravity(17);
        textView2.setTextSize(2, 13.5f);
        textView2.setTextColor(i2);
        textView2.setLineSpacing(a(2.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = a(6.0f);
        linearLayout.addView(textView2, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        float fA2 = a(14.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color2);
        gradientDrawable2.setCornerRadius(fA2);
        linearLayout2.setBackground(gradientDrawable2);
        linearLayout2.setPadding(a(18.0f), a(4.0f), a(14.0f), a(4.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a(58.0f));
        layoutParams2.topMargin = a(24.0f);
        linearLayout.addView(linearLayout2, layoutParams2);
        TextView textView3 = new TextView(this);
        textView3.setText(f5.a().a("filter_input_from"));
        textView3.setTextSize(2, 16.0f);
        textView3.setTextColor(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.rightMargin = a(12.0f);
        linearLayout2.addView(textView3, layoutParams3);
        int i6 = this.a ? -1 : -16777216;
        final EditText editText = new EditText(this);
        editText.setBackground(null);
        editText.setPadding(0, 0, 0, 0);
        editText.setTextSize(2, 20.0f);
        editText.setTextColor(i6);
        editText.setTypeface(Typeface.create("sans-serif-medium", 1));
        editText.setSingleLine(true);
        editText.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout2.addView(editText);
        TextView textView4 = new TextView(this);
        textView4.setText(f5.a().a("filter_reset"));
        textView4.setTextSize(2, 16.0f);
        textView4.setTextColor(iO);
        textView4.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView4.setPadding(a(12.0f), a(8.0f), a(4.0f), a(8.0f));
        linearLayout2.addView(textView4, new LinearLayout.LayoutParams(-2, -2));
        TextView textView5 = new TextView(this);
        textView5.setText("");
        textView5.setGravity(17);
        textView5.setTextSize(2, 13.5f);
        textView5.setTextColor(iO);
        textView5.setSingleLine(true);
        textView5.setVisibility(4);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = a(12.0f);
        linearLayout.addView(textView5, layoutParams4);
        TextView textView6 = new TextView(this);
        textView6.setText(f5.a().a("filter_save"));
        textView6.setGravity(17);
        textView6.setTextColor(-1);
        textView6.setTextSize(2, 15.0f);
        textView6.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, a(52.0f));
        layoutParams5.topMargin = a(24.0f);
        linearLayout.addView(textView6, layoutParams5);
        TextView textView7 = new TextView(this);
        textView7.setText(f5.a().a("filter_cancel"));
        textView7.setGravity(17);
        textView7.setTextColor(i5);
        textView7.setTextSize(2, 15.0f);
        textView7.setTypeface(Typeface.create("sans-serif-medium", 1));
        float fA3 = a(26.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(color3);
        gradientDrawable3.setCornerRadius(fA3);
        textView7.setBackground(gradientDrawable3);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, a(52.0f));
        layoutParams6.topMargin = a(12.0f);
        linearLayout.addView(textView7, layoutParams6);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 80));
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(frameLayout);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            attributes.dimAmount = 0.55f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setSoftInputMode(20);
        }
        final qb qbVar = new qb();
        qbVar.a = editText;
        qbVar.b = textView5;
        qbVar.c = textView6;
        qbVar.d = textView4;
        qbVar.g = iO;
        qbVar.h = (16777215 & iO) | Integer.MIN_VALUE;
        qbVar.i = a(26.0f);
        qbVar.j = i6;
        qbVar.k = iO;
        qbVar.f = new Runnable() {
            @Override
            public final void run() {
                vb.a(dialog);
            }
        };
        qbVar.e = new Runnable() {
            @Override
            public final void run() {
                this.f$0.a(dialog, editText);
            }
        };
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                qbVar.f.run();
            }
        });
        qbVar.a(true);
        return qbVar;
    }

    public static  void a(Dialog dialog) {
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Throwable th) {
        }
    }

    public final  void a(Dialog dialog, EditText editText) {
        dialog.show();
        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 1);
        }
    }

    public final void a(LinearLayout linearLayout, int i) {
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(38.0f), a(4.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = a(18.0f);
        view.setLayoutParams(layoutParams);
        float fA = a(2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        view.setBackground(gradientDrawable);
        linearLayout.addView(view);
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        FrameLayout frameLayoutA = a("ic_mod_logo", "TikTok You", f5.a().a("mod_version"), (String) null, 0, false, (View.OnClickListener) null);
        frameLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        frameLayoutA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public final boolean onLongClick(View view) {
                return this.f$0.c(view);
            }
        });
        linearLayout.addView(frameLayoutA);
        linearLayout.addView(a("ic_document", f5.a().a("privacy_information"), f5.a().a("privacy_information_legal"), "https://telegra.ph/Pravovaya-informaciya-i-usloviya-ispolzovaniya-12-29", 1, false, (View.OnClickListener) null));
        return linearLayout;
    }

    public final  void a(boolean z, int i, String str) {
        String string;
        if (z) {
            string = "Support list refreshed: " + i;
        } else {
            StringBuilder sb = new StringBuilder("Support list refresh failed: ");
            if (TextUtils.isEmpty(str)) {
                str = "unknown error";
            }
            string = sb.append(str).toString();
        }
        Toast.makeText((Context) this, (CharSequence) string, 1).show();
    }

    public final FrameLayout a(BitmapDrawable bitmapDrawable, String str, String str2, final String str3, int i, boolean z, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = new FrameLayout(this);
        int iA = a(str2 != null ? 12.0f : 14.0f);
        frameLayout.setPadding(0, iA, 0, iA);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.a ? t : -1);
        gradientDrawable.setCornerRadii(a(i));
        frameLayout.setBackground(gradientDrawable);
        boolean z2 = (str3 == null && onClickListener == null) ? false : true;
        if (z2) {
            frameLayout.setOnClickListener(onClickListener != null ? onClickListener : new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    this.f$0.a(str3, view);
                }
            });
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(-1);
            gradientDrawable2.setCornerRadii(a(i));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(this.a ? t : -1);
            gradientDrawable3.setCornerRadii(a(i));
            frameLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.a ? 872415231 : 520093696), gradientDrawable3, gradientDrawable2));
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
            textView2.setTextColor(u);
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
                textView3.setText(f5.a().a("mod_update_download"));
                textView3.setTextSize(2, 13.0f);
                textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
                textView3.setTextColor(-1);
                textView3.setGravity(17);
                textView3.setPadding(a(14.0f), a(6.0f), a(14.0f), a(6.0f));
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setColor(o());
                gradientDrawable4.setCornerRadius(a(16.0f));
                textView3.setBackground(gradientDrawable4);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams4.rightMargin = a(16.0f);
                layoutParams4.gravity = 21;
                frameLayout.addView(textView3, layoutParams4);
                return frameLayout;
            }
            ImageView imageView2 = new ImageView(this);
            imageView2.setImageBitmap(b("ic_arrow_right"));
            imageView2.setColorFilter(w);
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
        textView.setTextColor(v);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setPadding(a(28.0f), a(16.0f), 0, a(12.0f));
        return textView;
    }

    public final CheckBox a(String str, String str2, boolean z, final tb tbVar) {
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
        checkBox.setPadding(a(16.0f), 0, a(16.0f), 0);
        int color = Color.parseColor(this.a ? "#555555" : "#BBBBBB");
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, a("ic_check_active", o()));
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
                this.f$0.a(tbVar, compoundButton, z2);
            }
        });
        checkBox.setBackground(new RippleDrawable(ColorStateList.valueOf(this.a ? 872415231 : 520093696), null, new ColorDrawable(-1)));
        return checkBox;
    }

    public final  void a(tb tbVar, CompoundButton compoundButton, boolean z) {
        if (tbVar != null) {
            tbVar.a(z);
        }
        s();
    }

    public final int a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open("mod_icons/" + str + ".png");
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

    public final float[] a(int i) {
        float fA = a(8.0f);
        if (i == 0) {
            return new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        if (i == 1) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, fA, fA, fA, fA};
        }
        if (i != 2) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        return new float[]{fA, fA, fA, fA, fA, fA, fA, fA};
    }

    public final FrameLayout a(String str, String str2, String str3, String str4, int i, boolean z, View.OnClickListener onClickListener) {
        BitmapDrawable bitmapDrawableA;
        if (!z) {
            Bitmap bitmapB = b(str);
            bitmapDrawableA = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
        } else {
            bitmapDrawableA = a(str, o());
        }
        return a(bitmapDrawableA, str2, str3, str4, i, z, onClickListener);
    }

    public final BitmapDrawable a(String str, int i) {
        Bitmap bitmapB = b(str);
        BitmapDrawable bitmapDrawable = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
        if (bitmapDrawable != null) {
            bitmapDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        return bitmapDrawable;
    }
}
