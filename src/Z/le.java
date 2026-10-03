package Z;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.DigitsKeyListener;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
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
import com.windukk.mod.Main;
import Z.BadgeHooks;
import Z.FontHooks;
import Z.ThemeHooks;
import com.windukk.stable.ResourceOverlay;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.text.StringsKt;

public class le extends BaseActivity {
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final AtomicBoolean E;
    public static final AtomicBoolean F;
    public static final int[] G;
    public static boolean y;
    public static final int z;
    public final AtomicBoolean a = new AtomicBoolean(false);
    public boolean b;
    public int c;
    public int d;
    public FrameLayout e;
    public FrameLayout f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public LinearLayout m;
    public LinearLayout n;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public LinearLayout v;
    public LinearLayout w;
    public String x;

    static {
        y = false;
        z = Color.parseColor("#F5F5F5");
        A = Color.parseColor("#1E1E1E");
        B = Color.parseColor("#858585");
        C = Color.parseColor("#888888");
        D = Color.parseColor("#777778");
        E = new AtomicBoolean(false);
        F = new AtomicBoolean(false);
        G = new int[]{-1142217, -12726936, -5616918, -1226807, -12165909, -12342807, -1424314, -7763575};
    }

    public static int t() {
        return ta.a().f() ? ThemeHooks.a() : Color.parseColor("#FE2B54");
    }

    public final void A() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/octet-stream");
        startActivityForResult(intent, 1005);
    }

    public final void B() {
        final ta taVarA = ta.a();
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                le.this.a(taVarA, timePicker, i, i2);
            }
        };
        taVarA.getClass();
        new TimePickerDialog(this, onTimeSetListener, ta.d().p, ta.d().q, DateFormat.is24HourFormat(this)).show();
    }

    public final void C() {
        if (this.f != null) {
            return;
        }
        this.f = f();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.setMargins(a(8.0f), 0, a(8.0f), a(16.0f) + this.d);
        this.f.setTranslationY(a(100.0f));
        this.f.setAlpha(0.0f);
        this.e.addView(this.f, layoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f, "translationY", a(100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    public final void D() {
        boolean z2 = this.b;
        int i = z2 ? -14935010 : -1;
        int color = z2 ? -1 : Color.parseColor("#161823");
        boolean z3 = this.b;
        int i2 = z3 ? -6579293 : -9210757;
        int i3 = z3 ? -12961220 : -2434337;
        int iT = t();
        int color2 = this.b ? -13882322 : Color.parseColor("#F1F1F2");
        int i4 = this.b ? -1 : -16777216;
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
        textView.setText(l6.a("filter_date_sheet_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        textView.setTextColor(color);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(l6.a("filter_date_sheet_desc"));
        textView2.setGravity(17);
        textView2.setTextSize(2, 13.5f);
        textView2.setTextColor(i2);
        textView2.setLineSpacing(a(2.0f), 1.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = a(6.0f);
        linearLayout.addView(textView2, layoutParams);
        int color3 = this.b ? -13882322 : Color.parseColor("#F1F1F2");
        int i5 = B;
        int i6 = this.b ? -1 : -16777216;
        final long[] jArr = {d5.a().y};
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
        textView3.setText(l6.a("filter_input_from"));
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
                le.this.a(jArr, textView4, view);
            }
        });
        linearLayout2.addView(textView4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView5 = new TextView(this);
        textView5.setText(l6.a("filter_reset"));
        textView5.setTextSize(2, 16.0f);
        textView5.setTextColor(iT);
        textView5.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView5.setPadding(a(12.0f), a(8.0f), a(4.0f), a(8.0f));
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.b(jArr, textView4, view);
            }
        });
        linearLayout2.addView(textView5, new LinearLayout.LayoutParams(-2, -2));
        TextView textView6 = new TextView(this);
        textView6.setText(l6.a("filter_save"));
        textView6.setGravity(17);
        textView6.setTextColor(-1);
        textView6.setTextSize(2, 15.0f);
        textView6.setTypeface(Typeface.create("sans-serif-medium", 1));
        float fA3 = a(26.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(iT);
        gradientDrawable3.setCornerRadius(fA3);
        textView6.setBackground(gradientDrawable3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, a(52.0f));
        layoutParams4.topMargin = a(24.0f);
        linearLayout.addView(textView6, layoutParams4);
        TextView textView7 = new TextView(this);
        textView7.setText(l6.a("filter_cancel"));
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
        final Dialog dialogA = wa.a((Activity) this);
        dialogA.setContentView(wa.a((Activity) this, (ViewGroup) linearLayout, -2, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialogA.dismiss();
            }
        }));
        dialogA.setCancelable(true);
        wa.a(dialogA, linearLayout, i, 0.55f);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialogA.dismiss();
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.a(jArr, dialogA, view);
            }
        });
        dialogA.show();
    }

    public final void E() {
        a(l6.a("filter_likes_sheet_title"), l6.a("filter_likes_sheet_desc"), d5.a().w, new he() {
            @Override
            public final void a(long j) {
                le.this.a(j);
            }
        });
    }

    public final void F() {
        a(l6.a("filter_views_sheet_title"), l6.a("filter_views_sheet_desc"), d5.a().x, new he() {
            @Override
            public final void a(long j) {
                le.this.b(j);
            }
        });
    }

    public final void G() {
        boolean z2 = this.b;
        int i = z2 ? -14935010 : -1;
        int color = z2 ? -1 : Color.parseColor("#161823");
        boolean z3 = this.b;
        int i2 = z3 ? -6579293 : -9210757;
        int i3 = z3 ? -12961220 : -2434337;
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
        textView2.setText("Developer tools");
        textView2.setGravity(17);
        textView2.setTextSize(2, 13.5f);
        textView2.setTextColor(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = a(6.0f);
        linearLayout.addView(textView2, layoutParams);
        final Dialog dialogA = wa.a((Activity) this);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(22.0f);
        linearLayout.addView(linearLayout2, layoutParams2);
        linearLayout2.addView(a("ic_refresh", "Force refresh support list", (String) null, (String) null, 0, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.g(dialogA, view);
            }
        }));
        linearLayout2.addView(a("ic_refresh", "Clean support list cache", (String) null, (String) null, 3, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.h(dialogA, view);
            }
        }));
        linearLayout2.addView(a("ic_document", "Export logs (.zip)", (String) null, (String) null, 3, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.d(dialogA, view);
            }
        }));
        linearLayout2.addView(a("ic_document", "Export heap dump (.hprof)", (String) null, (String) null, 1, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.e(dialogA, view);
            }
        }));
        dialogA.setContentView(wa.a((Activity) this, (ViewGroup) linearLayout, -2, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.f(dialogA, view);
            }
        }));
        dialogA.setCancelable(true);
        dialogA.setCanceledOnTouchOutside(true);
        wa.a(dialogA, linearLayout, i, 0.55f);
        dialogA.show();
    }

    public final void H() {
        if (this.k == null) {
            return;
        }
        ta.a().getClass();
        SharedPreferences sharedPreferences = ta.b;
        if (sharedPreferences != null ? sharedPreferences.getBoolean("auto_streak_recipients_all", true) : true) {
            this.k.setText(l6.a("auto_streak_recipients_all"));
            return;
        }
        TextView textView = this.k;
        Locale locale = Locale.getDefault();
        String strA = l6.a("auto_streak_recipients_selected");
        List<w> listA = Z.y.a();
        int i = 0;
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            int i2 = 0;
            for (w wVar : listA) {
                ta taVar = ta.a;
                String str = wVar.a;
                taVar.getClass();
                SharedPreferences sharedPreferences2 = ta.b;
                if (((sharedPreferences2 != null ? sharedPreferences2.getBoolean("auto_streak_recipients_all", true) : true) || !(str == null || ta.b().contains(str))) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            i = i2;
        }
        textView.setText(String.format(locale, strA, Integer.valueOf(i)));
    }

    public final void I() {
        String string;
        ImageView imageView = this.l;
        if (imageView != null) {
            t1 t1Var = h0.a;
            k0.a.getClass();
            ta.a.getClass();
            SharedPreferences sharedPreferences = ta.b;
            String strDecrypt = "";
            if (sharedPreferences != null && (string = sharedPreferences.getString("auto_streak_sticker_url", "")) != null) {
                strDecrypt = string;
            }
            if (StringsKt.isBlank(strDecrypt)) {
                strDecrypt = "https://p16-tiktokcdn-com.akamaized.net/obj/im-resource-tiktok/fire.webp";
            }
            t1 t1Var2 = h0.a;
            h0.a(strDecrypt, (Activity) this, imageView);
        }
    }

    public final void J() {
        ta taVarA = ta.a();
        TextView textView = this.r;
        if (textView != null) {
            taVarA.getClass();
            ua uaVarD = ta.d();
            if (uaVarD.D == null) {
                uaVarD.D = new LinkedHashSet();
            }
            LinkedHashSet linkedHashSet = uaVarD.D;
            textView.setText(String.valueOf(linkedHashSet.size()));
        }
        TextView textView2 = this.s;
        if (textView2 != null) {
            taVarA.getClass();
            textView2.setText(String.valueOf(ta.d().w));
        }
        TextView textView3 = this.t;
        if (textView3 != null) {
            taVarA.getClass();
            textView3.setText(String.valueOf(ta.d().x));
        }
        if (this.u != null) {
            taVarA.getClass();
            long j = ta.d().y;
            this.u.setText(j > 0 ? new SimpleDateFormat("dd.MM.yyyy", Locale.US).format(new Date(j * 1000)) : "");
        }
    }

    public final void K() {
        String strReplaceAll;
        if (this.g == null) {
            return;
        }
        ta.a().getClass();
        String strE = ta.e();
        if (strE == null || !strE.startsWith("file:")) {
            this.g.setText("");
            this.g.setVisibility(8);
            return;
        }
        Typeface typeface = FontHooks.a;
        if ("default".equals(strE) || "system".equals(strE)) {
            strReplaceAll = null;
        } else {
            if (strE.startsWith("file:")) {
                strE = strE.substring("file:".length());
            } else if (strE.startsWith("asset:")) {
                strE = strE.substring("asset:".length());
            }
            strReplaceAll = strE.replaceAll("(?i)\\.(ttf|otf)$", "");
        }
        this.g.setText(strReplaceAll != null ? strReplaceAll : "");
        this.g.setVisibility(0);
    }

    public final void a(j6 j6Var, View view) {
        if (j6Var.a.equals(this.x)) {
            return;
        }
        String str = j6Var.a;
        this.x = str;
        k6.a((Context) this, str);
        if (this.w != null) {
            for (int i = 0; i < this.w.getChildCount(); i++) {
                View childAt = this.w.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (viewGroup.getChildCount() >= 2) {
                        String str2 = this.x;
                        boolean z2 = str2 != null && str2.equals(viewGroup.getTag());
                        View childAt2 = viewGroup.getChildAt(0);
                        if (childAt2 instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) childAt2;
                            if (viewGroup2.getChildCount() > 0) {
                                viewGroup2.getChildAt(0).setVisibility(z2 ? 0 : 4);
                            }
                        }
                        View childAt3 = viewGroup.getChildAt(1);
                        if (childAt3 instanceof TextView) {
                            ((TextView) childAt3).setTextColor(z2 ? t() : B);
                        }
                    }
                }
            }
        }
        C();
    }

    public final void b(View view) {
    }

    public final LinearLayout c() {
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        String strA = l6.a("antiburnout_show_on_main");
        String strDecrypt = "ic_antiburnin_show_on_main_page";
        boolean z2 = d5.a().g;
        final ta taVarA = ta.a();
        Objects.requireNonNull(taVarA);
        linearLayoutG.addView(a(strA, strDecrypt, z2, new je() {
            @Override
            public final void a(boolean z3) {
                taVarA.c(z3);
            }
        }, true));
        String strA2 = l6.a("antiburnout_enable_on_start");
        String strDecrypt2 = "ic_antiburnin_enable_on_start";
        boolean z3 = d5.a().h;
        final ta taVarA2 = ta.a();
        Objects.requireNonNull(taVarA2);
        linearLayoutG.addView(a(strA2, strDecrypt2, z3, new je() {
            @Override
            public final void a(boolean z4) {
                taVarA2.b(z4);
            }
        }, true));
        String strA3 = l6.a("feed_overlay_opacity");
        String strDecrypt3 = "ic_antiburnin_opacity";
        int i = d5.a().n;
        final ta taVarA3 = ta.a();
        Objects.requireNonNull(taVarA3);
        ie ieVar = new ie() {
            @Override
            public final void a(int i2) {
                taVarA3.a(i2);
            }
        };
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(a(16.0f), a(12.0f), a(16.0f), a(8.0f));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b(strDecrypt3));
        linearLayout2.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView = new TextView(this);
        textView.setText(strA3);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setTextColor(this.b ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout2.addView(textView, layoutParams);
        TextView textView2 = new TextView(this);
        textView2.setText(i + "%");
        textView2.setTextSize(2, 14.0f);
        int i2 = B;
        textView2.setTextColor(i2);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        SeekBar seekBar = new SeekBar(this);
        seekBar.setMax(100);
        seekBar.setProgress(i);
        seekBar.setOnSeekBarChangeListener(new fe(this, textView2, ieVar));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(4.0f);
        linearLayout.addView(seekBar, layoutParams2);
        linearLayoutG.addView(linearLayout);
        TextView textView3 = new TextView(this);
        textView3.setText(l6.a("feed_overlay_opacity_hint"));
        textView3.setTextSize(2, 13.0f);
        textView3.setTextColor(i2);
        textView3.setPadding(a(16.0f), a(4.0f), a(16.0f), a(8.0f));
        linearLayoutG.addView(textView3);
        return linearLayoutG;
    }

    public final LinearLayout d() {
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        final LinearLayout linearLayoutE = e();
        this.k = new TextView(this);
        ImageView imageView = new ImageView(this);
        this.l = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.l.setClipToOutline(true);
        this.l.setOutlineProvider(new de(this));
        this.m = a("ic_autotease_order", l6.a("auto_streak_recipients"), this.k, new Runnable() {
            @Override
            public final void run() {
                le.this.u();
            }
        });
        LinearLayout linearLayoutA = a("ic_autotease_opt", l6.a("auto_streak_sticker"), (TextView) null, new Runnable() {
            @Override
            public final void run() {
                le.this.v();
            }
        });
        this.n = linearLayoutA;
        int iMax = Math.max(0, linearLayoutA.getChildCount() - 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams.leftMargin = a(8.0f);
        linearLayoutA.addView(this.l, iMax, layoutParams);
        ta.a().getClass();
        boolean z2 = ta.d().o;
        linearLayoutE.setVisibility(z2 ? 0 : 8);
        linearLayoutG.addView(a(l6.a("auto_streak_toggle"), "ic_autotease", z2, new je() {
            @Override
            public final void a(boolean z3) {
                le.this.a(linearLayoutE, z3);
            }
        }, true));
        linearLayoutG.addView(linearLayoutE);
        this.n.setVisibility(z2 ? 0 : 8);
        linearLayoutG.addView(this.n);
        this.m.setVisibility(z2 ? 0 : 8);
        linearLayoutG.addView(this.m);
        I();
        H();
        return linearLayoutG;
    }

    public final LinearLayout e() {
        this.j = new TextView(this);
        LinearLayout linearLayoutA = a("ic_clock", l6.a("auto_streak_nudge_time"), this.j, new Runnable() {
            @Override
            public final void run() {
                le.this.B();
            }
        });
        TextView textView = this.j;
        if (textView == null) {
            return linearLayoutA;
        }
        textView.setText(String.format(Locale.US, "%02d:%02d", Integer.valueOf(d5.a().p), Integer.valueOf(d5.a().q)));
        return linearLayoutA;
    }

    public final  void f(View view) {
        startActivityForResult(new Intent((Context) this, (Class<?>) ld.class), 1002);
    }

    public final  void g(View view) {
        a();
    }

    public final void h(View view) {
        String[] strArr = BadgeHooks.a;
        BadgeHooks.b((Activity) this, (Fragment) null, n1.a());
    }

    public final LinearLayout i() {
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        this.r = new TextView(this);
        linearLayoutG.addView(a("ic_pencil", l6.a("filter_words"), this.r, new Runnable() {
            @Override
            public final void run() {
                le.this.w();
            }
        }));
        this.s = new TextView(this);
        linearLayoutG.addView(a("ic_like", l6.a("filter_likes"), this.s, new Runnable() {
            @Override
            public final void run() {
                le.this.E();
            }
        }));
        this.t = new TextView(this);
        linearLayoutG.addView(a("ic_views", l6.a("filter_views"), this.t, new Runnable() {
            @Override
            public final void run() {
                le.this.F();
            }
        }));
        this.u = new TextView(this);
        linearLayoutG.addView(a("ic_clock", l6.a("filter_publish_date"), this.u, new Runnable() {
            @Override
            public final void run() {
                le.this.D();
            }
        }));
        J();
        return linearLayoutG;
    }

    public final LinearLayout j() {
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        String strA = l6.a("hide_lives");
        String strDecrypt = "ic_live";
        boolean z2 = d5.a().c;
        final ta taVarA = ta.a();
        Objects.requireNonNull(taVarA);
        linearLayoutG.addView(a(strA, strDecrypt, z2, new je() {
            @Override
            public final void a(boolean z3) {
                taVarA.f(z3);
            }
        }, true));
        String strA2 = l6.a("hide_ads");
        String strDecrypt2 = "ic_ads";
        boolean z3 = d5.a().d;
        final ta taVarA2 = ta.a();
        Objects.requireNonNull(taVarA2);
        linearLayoutG.addView(a(strA2, strDecrypt2, z3, new je() {
            @Override
            public final void a(boolean z4) {
                taVarA2.e(z4);
            }
        }, true));
        String strA3 = l6.a("hide_photos");
        String strDecrypt3 = "ic_photo_disable";
        boolean z4 = d5.a().e;
        final ta taVarA3 = ta.a();
        Objects.requireNonNull(taVarA3);
        linearLayoutG.addView(a(strA3, strDecrypt3, z4, new je() {
            @Override
            public final void a(boolean z5) {
                taVarA3.g(z5);
            }
        }, true));
        String strA4 = l6.a("hide_stories");
        String strDecrypt4 = "ic_hidestory";
        boolean z5 = d5.a().i;
        final ta taVarA4 = ta.a();
        Objects.requireNonNull(taVarA4);
        linearLayoutG.addView(a(strA4, strDecrypt4, z5, new je() {
            @Override
            public final void a(boolean z6) {
                taVarA4.h(z6);
            }
        }, true));
        return linearLayoutG;
    }

    public final LinearLayout k() {
        String str;
        String str2;
        int i;
        LinearLayout linearLayoutG = g();
        int r4 = 0;
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        RadioGroup radioGroup = new RadioGroup(this);
        char c = 1;
        radioGroup.setOrientation(1);
        ta.a().getClass();
        String strE = ta.e();
        final ArrayList arrayList = new ArrayList();
        int i2 = 2;
        arrayList.add(new String[]{"default", l6.a("font_default"), "ic_font"});
        arrayList.add(new String[]{"system", l6.a("font_system"), "ic_system_font"});
        int i3 = 0;
        int i4 = -1;
        while (i3 < arrayList.size()) {
            String[] strArr = (String[]) arrayList.get(i3);
            String str3 = strArr[c];
            String str4 = strArr[i2];
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i3);
            radioButton.setSaveEnabled(r4 != 0);
            radioButton.setText(str3);
            radioButton.setTextSize(i2, 16.0f);
            radioButton.setTypeface(Typeface.create("sans-serif-medium", (int) r4));
            radioButton.setMinHeight(a(48.0f));
            radioButton.setTextColor(this.b ? -1 : -16777216);
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setBackground(null);
            radioButton.setPadding(a(16.0f), r4, a(16.0f), r4);
            int color = Color.parseColor((this.b ? "#555555" : "#BBBBBB"));
            StateListDrawable stateListDrawable = new StateListDrawable();
            int[] iArr = {R.attr.state_checked};
            String strDecrypt = "ic_radio_active";
            int iT = t();
            Bitmap bitmapB = b(strDecrypt);
            BitmapDrawable bitmapDrawable = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
            if (bitmapDrawable != null) {
                bitmapDrawable.setColorFilter(iT, PorterDuff.Mode.SRC_IN);
            }
            stateListDrawable.addState(iArr, bitmapDrawable);
            int[] iArr2 = new int[0];
            Bitmap bitmapB2 = b("ic_radio_inactive");
            BitmapDrawable bitmapDrawable2 = bitmapB2 != null ? new BitmapDrawable(getResources(), bitmapB2) : null;
            if (bitmapDrawable2 != null) {
                bitmapDrawable2.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }
            stateListDrawable.addState(iArr2, bitmapDrawable2);
            Bitmap bitmapB3 = b(str4);
            BitmapDrawable bitmapDrawable3 = bitmapB3 != null ? new BitmapDrawable(getResources(), bitmapB3) : null;
            int iA = a(20.0f);
            if (bitmapDrawable3 != null) {
                i = 0;
                bitmapDrawable3.setBounds(0, 0, iA, iA);
            } else {
                i = 0;
            }
            stateListDrawable.setBounds(i, i, iA, iA);
            radioButton.setCompoundDrawables(bitmapDrawable3, null, stateListDrawable, null);
            radioButton.setCompoundDrawablePadding(a(12.0f));
            radioButton.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            radioButton.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), null, new ColorDrawable(-1)));
            radioGroup.addView(radioButton);
            if (strArr[0].equals(strE)) {
                i4 = i3;
            }
            i3++;
            r4 = 0;
            c = 1;
            i2 = 2;
        }
        linearLayoutG.addView(radioGroup);
        linearLayoutG.addView(l());
        if (strE != null && strE.startsWith("file:")) {
            radioGroup.clearCheck();
        } else if (i4 >= 0) {
            radioGroup.check(i4);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(RadioGroup radioGroup2, int i5) {
                le.this.a(arrayList, radioGroup2, i5);
            }
        });
        return linearLayoutG;
    }

    public final LinearLayout l() {
        this.g = new TextView(this);
        LinearLayout linearLayoutA = a("ic_font_file", l6.a("font_pick_file"), this.g, new Runnable() {
            @Override
            public final void run() {
                le.this.x();
            }
        });
        K();
        return linearLayoutA;
    }

    public final LinearLayout m() {
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        String strA = l6.a("skip_quality_picker");
        String strDecrypt = "ic_skip_download_selector";
        boolean z2 = d5.a().u;
        final ta taVarA = ta.a();
        Objects.requireNonNull(taVarA);
        linearLayoutG.addView(a(strA, strDecrypt, z2, new je() {
            @Override
            public final void a(boolean z3) {
                taVarA.i(z3);
            }
        }, true));
        String strA2 = l6.a("force_progress_bar");
        String strDecrypt2 = "ic_videoslider";
        boolean z3 = d5.a().k;
        final ta taVarA2 = ta.a();
        Objects.requireNonNull(taVarA2);
        linearLayoutG.addView(a(strA2, strDecrypt2, z3, new je() {
            @Override
            public final void a(boolean z4) {
                taVarA2.a(z4);
            }
        }, true));
        return linearLayoutG;
    }

    public final LinearLayout n() {
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        String strA = l6.a("startup_auto_updates");
        String strDecrypt = "ic_startup_download";
        boolean z2 = d5.a().A;
        final ta taVarA = ta.a();
        Objects.requireNonNull(taVarA);
        linearLayoutG.addView(a(strA, strDecrypt, z2, new je() {
            @Override
            public final void a(boolean z3) {
                taVarA.d(z3);
            }
        }, false));
        String strA2 = l6.a("startup_statistics");
        String strDecrypt2 = "ic_startup_stats";
        boolean z3 = d5.a().z;
        final ta taVarA2 = ta.a();
        Objects.requireNonNull(taVarA2);
        linearLayoutG.addView(a(strA2, strDecrypt2, z3, new je() {
            @Override
            public final void a(boolean z4) {
                taVarA2.j(z4);
            }
        }, false));
        return linearLayoutG;
    }

    public final LinearLayout o() {
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        LinearLayout linearLayoutP = p();
        ta.a().getClass();
        ta.d();
        linearLayoutP.setVisibility(0);
        CheckBox checkBoxA = a(l6.a("region_spoof"), "ic_globe", true, null, true);
        checkBoxA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                le.a(compoundButton, z2);
            }
        });
        checkBoxA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.e(view);
            }
        });
        linearLayoutG.addView(checkBoxA);
        linearLayoutG.addView(linearLayoutP);
        return linearLayoutG;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Throwable th = null;
        Uri data;
        String strDecrypt;
        int columnIndex;
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            if (i2 == -1) {
                if (this.i != null || this.h != null) {
                    ta.a().getClass();
                    ed edVarC = ta.c();
                    ImageView imageView = this.i;
                    if (imageView != null) {
                        imageView.setImageDrawable(hd.a(this, edVarC, a(20.0f)));
                    }
                    TextView textView = this.h;
                    if (textView != null) {
                        textView.setText(l6.a(edVarC.b, edVarC.c));
                    }
                }
                C();
                return;
            }
            return;
        }
        if (i == 1004) {
            J();
            if (i2 == -1) {
                C();
                return;
            }
            return;
        }
        if (i == 1005) {
            if (i2 != -1 || intent == null || intent.getData() == null) {
                return;
            }
            Uri data2 = intent.getData();
            try {
                getContentResolver().takePersistableUriPermission(data2, 1);
            } catch (Throwable th_9) {
            }
            Intent intent2 = new Intent((Context) this, (Class<?>) gh.class);
            intent2.setData(data2);
            intent2.setClipData(ClipData.newRawUri("", data2));
            intent2.addFlags(1);
            intent2.putExtra("fromSettings", true);
            startActivity(intent2);
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
                        strDecrypt = null;
                    } else {
                        strDecrypt = cursorQuery.getString(columnIndex);
                    }
                } catch (Throwable th2) {
                    try {
                        cursorQuery.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                }
            } else {
                strDecrypt = null;
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            strDecrypt = null;
        }
        if (strDecrypt == null) {
            strDecrypt = "custom_font.ttf";
        }
        String lowerCase = strDecrypt.toLowerCase();
        if (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf")) {
            File file = new File(getFilesDir(), "fonts");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, strDecrypt);
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
                                String strA = new StringBuilder().append("file:").append(strDecrypt).toString();
                                ta.a().getClass();
                                ta.d().c(strA);
                                FontHooks.a = null;
                                FontHooks.b = null;
                                FontHooks.c.clear();
                                K();
                                C();
                                return;
                            }
                            fileOutputStream.write(bArr, 0, i3);
                            if (inputStreamOpenInputStream != null) {
                                throw th;
                            }
                            try {
                                inputStreamOpenInputStream.close();
                                throw th;
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            fileOutputStream.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    if (inputStreamOpenInputStream != null) {
                        throw new RuntimeException(th7);
                    }
                    inputStreamOpenInputStream.close();
                    throw new RuntimeException(th7);
                }
            } catch (IOException e3) {
                String strDecrypt2 = "Failed to copy font: %s";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt2), e3);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ta.a((Context) this);
        this.b = (getResources().getConfiguration().uiMode & 48) == 32;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        this.c = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        int identifier2 = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.d = identifier2 > 0 ? getResources().getDimensionPixelSize(identifier2) : 0;
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i = !this.b ? 9984 : 1792;
        if (!this.b) {
            i |= 16;
        }
        window.getDecorView().setSystemUiVisibility(i);
        FrameLayout frameLayout = new FrameLayout(this);
        this.e = frameLayout;
        frameLayout.setTag("ModSettingsView");
        this.e.setClickable(true);
        this.e.setFocusableInTouchMode(true);
        this.e.setBackgroundColor(this.b ? -16777216 : z);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setPadding(0, a(56.0f) + this.c, 0, this.d);
        scrollView.setClipToPadding(false);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(a(8.0f), 0, a(8.0f), a(20.0f) + this.d);
        scrollView.addView(linearLayout);
        this.e.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(this);
        textView.setText(l6.a("settings_title"));
        textView.setTextSize(2, 28.0f);
        textView.setTextColor(this.b ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.topMargin = a(8.0f);
        layoutParams.bottomMargin = a(22.0f);
        textView.setLayoutParams(layoutParams);
        a(this.e, scrollView, textView);
        a(this.e);
        a(linearLayout, textView);
        setContentView(this.e);
    }

    public final LinearLayout p() {
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
                le.this.f(view);
            }
        });
        linearLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), null, new ColorDrawable(-1)));
        ImageView imageView = new ImageView(this);
        this.i = imageView;
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView = new TextView(this);
        this.h = textView;
        textView.setTextSize(2, 16.0f);
        this.h.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.h.setTextColor(this.b ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(this.h, layoutParams);
        ta.a().getClass();
        ed edVarC = ta.c();
        ImageView imageView2 = this.i;
        if (imageView2 != null) {
            imageView2.setImageDrawable(hd.a(this, edVarC, a(20.0f)));
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setText(l6.a(edVarC.b, edVarC.c));
        }
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageBitmap(b("ic_arrow_right"));
        imageView3.setColorFilter(D);
        linearLayout.addView(imageView3, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        return linearLayout;
    }

    public final LinearLayout q() {
        return a("ic_mod_update_gray", l6.a("dynamic_import_signed"), (TextView) null, new Runnable() {
            @Override
            public final void run() {
                le.this.A();
            }
        });
    }

    public final void r() {
        if (!E.compareAndSet(false, true)) {
            Toast.makeText((Context) this, (CharSequence) "Heap dump export is already running", 0).show();
        } else {
            Toast.makeText((Context) this, (CharSequence) "Creating heap dump. The app may pause for a moment...", 1).show();
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    le.this.y();
                }
            }, "TTModHeapDumpExporter").start();
        }
    }

    public final void s() {
        if (!F.compareAndSet(false, true)) {
            Toast.makeText((Context) this, (CharSequence) "Log export is already running", 0).show();
        } else {
            Toast.makeText((Context) this, (CharSequence) "Creating log archive...", 0).show();
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    le.this.z();
                }
            }, "TTModLogExporter").start();
        }
    }

    public final  void u() {
        Z.z.a(this, new Runnable() {
            @Override
            public final void run() {
                le.this.H();
            }
        });
    }

    public final  void v() {
        h0.a(this, new Runnable() {
            @Override
            public final void run() {
                le.this.I();
            }
        });
    }

    public final  void w() {
        startActivityForResult(new Intent((Context) this, (Class<?>) h5.class), 1004);
    }

    public final  void x() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"font/ttf", "font/otf", "font/sfnt", "application/x-font-ttf", "application/x-font-otf", "application/octet-stream"});
        startActivityForResult(intent, 1001);
    }

    public final void y() {
        try {
            final t5 t5VarA = u5.a(getApplicationContext());
            runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    le.this.a(t5VarA);
                }
            });
            E.set(false);
        } catch (Throwable th) {
            try {
                String strDecrypt = "Heap dump export failed";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
                runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        le.this.a(th);
                    }
                });
            } finally {
                E.set(false);
            }
        }
    }

    public final void z() {
        try {
            final g6 g6VarA = h6.a(getApplicationContext());
            runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    le.this.a(g6VarA);
                }
            });
            F.set(false);
        } catch (Throwable th) {
            try {
                String strDecrypt = "Log export failed";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
                runOnUiThread(new Runnable() {
                    @Override
                    public final void run() {
                        le.this.b(th);
                    }
                });
            } finally {
                F.set(false);
            }
        }
    }

    public static  void f(Dialog dialog, View view) {
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Throwable th) {
        }
    }

    public final void b(long j) {
        ta.a().getClass();
        ta.d().c(j);
        J();
        C();
    }

    public final void g(Dialog dialog, View view) {
        String str;
        String str2;
        Toast.makeText((Context) this, (CharSequence) (BadgeHooks.a(getApplicationContext(), true, new k1() {
            @Override
            public final void a(boolean z2, int i, String str3) {
                le.this.a(z2, i, str3);
            }
        }) ? "Support list refresh started" : "Support list refresh already running"), 0).show();
        a(dialog);
    }

    public final FrameLayout f() {
        FrameLayout frameLayout = new FrameLayout(this);
        int iA = a(16.0f);
        int iA2 = a(16.0f);
        frameLayout.setPadding(iA, iA2, iA, iA2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? -1 : Color.parseColor("#1E1E1E"));
        gradientDrawable.setCornerRadius(a(8.0f));
        frameLayout.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(8.0f), 0, a(8.0f), 0);
        frameLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(this);
        String strA = l6.a("bulletin_button");
        textView.setText(strA);
        textView.setTextColor(-1);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setGravity(17);
        textView.setPadding(a(20.0f), 0, a(20.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(t());
        gradientDrawable2.setCornerRadius(a(68.0f));
        textView.setBackground(gradientDrawable2);
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        int iA3 = a(16.0f) + a(40.0f) + ((int) paint.measureText(strA));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        TextView textView2 = new TextView(this);
        textView2.setText(l6.a("bulletin_title"));
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(this.b ? -16777216 : -1);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this);
        textView3.setText(l6.a("bulletin_subtitle"));
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
                le.this.d(view);
            }
        });
        return frameLayout;
    }

    public final LinearLayout h() {
        String str;
        String str2;
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        linearLayoutG.setClipToPadding(false);
        linearLayoutG.setClipChildren(false);
        boolean z2 = Build.VERSION.SDK_INT >= 31;
        boolean zF = ta.a().f();
        CheckBox checkBox = new CheckBox(this);
        checkBox.setSaveEnabled(false);
        checkBox.setText(l6.a("custom_colors"));
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(Typeface.create("sans-serif-medium", 0));
        checkBox.setMinHeight(a(48.0f));
        checkBox.setTextColor(this.b ? -1 : -16777216);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        checkBox.setPadding(a(16.0f), 0, a(16.0f), 0);
        int color = Color.parseColor((this.b ? "#555555" : "#BBBBBB"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = {R.attr.state_checked};
        String strDecrypt = "ic_check_active";
        int iT = t();
        Bitmap bitmapB = b(strDecrypt);
        if (bitmapB == null) {
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(getResources(), bitmapB);
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setColorFilter(iT, PorterDuff.Mode.SRC_IN);
        }
        stateListDrawable.addState(iArr, bitmapDrawable);
        int[] iArr2 = new int[0];
        Bitmap bitmapB2 = b("ic_check_inactive");
        if (bitmapB2 == null) {
            bitmapDrawable2 = null;
        } else {
            bitmapDrawable2 = new BitmapDrawable(getResources(), bitmapB2);
        }
        if (bitmapDrawable2 != null) {
            bitmapDrawable2.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        stateListDrawable.addState(iArr2, bitmapDrawable2);
        Bitmap bitmapB3 = b("ic_risovalca");
        if (bitmapB3 == null) {
            bitmapDrawable3 = null;
        } else {
            bitmapDrawable3 = new BitmapDrawable(getResources(), bitmapB3);
        }
        int iA = a(20.0f);
        if (bitmapDrawable3 != null) {
            bitmapDrawable3.setBounds(0, 0, iA, iA);
        }
        stateListDrawable.setBounds(0, 0, iA, iA);
        checkBox.setCompoundDrawables(bitmapDrawable3, null, stateListDrawable, null);
        checkBox.setCompoundDrawablePadding(a(12.0f));
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        checkBox.setChecked(zF);
        checkBox.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), null, new ColorDrawable(-1)));
        linearLayoutG.addView(checkBox);
        final HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setClipToPadding(false);
        horizontalScrollView.setClipChildren(false);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setPadding(a(16.0f), 0, a(16.0f), a(12.0f));
        LinearLayout linearLayout = new LinearLayout(this);
        this.v = linearLayout;
        linearLayout.setOrientation(0);
        this.v.setPadding(0, 0, 0, 0);
        ta.a().getClass();
        int i = ta.d().m;
        ThemeHooks.d = false;
        if (z2) {
            Context contextA = Main.getApplicationContext();
            FrameLayout frameLayoutA = a(contextA == null ? -16524603 : ThemeHooks.a(contextA), i == 0);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(b("ic_system_colors"));
            int iA2 = a(16.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams.gravity = 17;
            frameLayoutA.addView(imageView, layoutParams);
            this.v.addView(frameLayoutA);
        }
        int[] iArr3 = G;
        int length = iArr3.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr3[i2];
            this.v.addView(a(i3, i3 == i));
        }
        ThemeHooks.d = true;
        horizontalScrollView.addView(this.v);
        horizontalScrollView.setVisibility(zF ? 0 : 8);
        linearLayoutG.addView(horizontalScrollView);
        final TextView textView = new TextView(this);
        textView.setText(l6.a("custom_colors_desc"));
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(B);
        textView.setPadding(a(16.0f), 0, a(16.0f), a(12.0f));
        textView.setVisibility(zF ? 0 : 8);
        linearLayoutG.addView(textView);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                le.this.a(horizontalScrollView, textView, compoundButton, z3);
            }
        });
        return linearLayoutG;
    }

    public final void b(long[] jArr, TextView textView, View view) {
        jArr[0] = 0;
        textView.setText("");
        ta.a().getClass();
        ta.d().b(0L);
        J();
        C();
    }

    public final LinearLayout g() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? A : -1);
        gradientDrawable.setCornerRadius(a(12.0f));
        linearLayout.setBackground(gradientDrawable);
        return linearLayout;
    }

    public static  void b(Dialog dialog) {
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Throwable th) {
        }
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        FrameLayout frameLayoutA = a("ic_mod_logo", "TikTok You", l6.a("mod_version"), (String) null, 0, false, (View.OnClickListener) null);
        frameLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.b(view);
            }
        });
        frameLayoutA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public final boolean onLongClick(View view) {
                return le.this.c(view);
            }
        });
        linearLayout.addView(frameLayoutA);
        linearLayout.addView(a("ic_document", l6.a("privacy_information"), l6.a("privacy_information_legal"), "https://tiktokyou.ru/legal.html", 1, false, (View.OnClickListener) null));
        return linearLayout;
    }

    public final  void e(Dialog dialog, View view) {
        r();
        a(dialog);
    }

    public final void a(FrameLayout frameLayout, final ScrollView scrollView, final TextView textView) {
        View view = new View(this);
        view.setBackgroundColor(this.b ? -16777216 : z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a(56.0f) + this.c);
        layoutParams.gravity = 48;
        frameLayout.addView(view, layoutParams);
        final TextView textView2 = new TextView(this);
        textView2.setText(l6.a("settings_title"));
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(Typeface.create("sans-serif", 1));
        textView2.setTextColor(this.b ? -1 : -16777216);
        textView2.setVisibility(4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = a(16.0f) + this.c;
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

    public final void e(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, a(6.0f), 0.0f, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new CycleInterpolator(4.0f));
        view.startAnimation(translateAnimation);
    }

    public final  void b(Throwable th) {
        Toast.makeText((Context) this, (CharSequence) ("Log export failed: " + th.getMessage()), 1).show();
    }

    public final Bitmap b(String str) {
        try {
            InputStream inputStreamOpen = ResourceOverlay.open(this, "mod_icons/" + str + ".png");
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

    public final void a(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b("ic_back"));
        imageView.setColorFilter(this.b ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.a(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams.leftMargin = a(16.0f);
        layoutParams.topMargin = a(16.0f) + this.c;
        layoutParams.gravity = 51;
        frameLayout.addView(imageView, layoutParams);
        imageView.bringToFront();
    }

    public final  void a(View view) {
        finish();
    }

    public final  void d(Dialog dialog, View view) {
        s();
        a(dialog);
    }

    public final void a(LinearLayout linearLayout, TextView textView) {
        int iA = 0;
        int color = 0;
        Bitmap bitmapDecodeStream = null;
        boolean z2;
        BitmapDrawable bitmapDrawable;
        int i;
        ArrayList arrayListA;
        int size;
        int i2;
        j6 j6Var;
        j6 j6Var2;
        InputStream inputStreamOpen = null;
        linearLayout.addView(textView);
        if (y) {
            linearLayout.addView(a("ic_mod_update", l6.a("mod_update"), (String) null, "https://t.me/tikyoutok", 0, true, (View.OnClickListener) null));
        }
        linearLayout.addView(a("ic_telegram", l6.a("telegram_channel"), (String) null, "https://t.me/tikyoutok", y ? 3 : 0, false, (View.OnClickListener) null));
        linearLayout.addView(a("ic_refresh", l6.a("check_updates"), (String) null, (String) null, 3, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.g(view);
            }
        }));
        String strDecrypt = "developer.png";
        if (ta.a() != null && ta.d().m == 0) {
            try {
                int identifier = getResources().getIdentifier("system_accent3_400", "color", "android");
                if (identifier != 0) {
                    color = getResources().getColor(identifier, null);
                } else {
                    Context contextA = Main.getApplicationContext();
                    if (contextA == null) {
                        color = -16524603;
                    } else {
                        color = ThemeHooks.a(contextA);
                    }
                }
            } catch (Throwable th) {
                color = -16524603;
            }
        } else {
            color = -185258;
        }
        try {
            inputStreamOpen = ResourceOverlay.open(this, strDecrypt);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
        } catch (Throwable th) {
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream == null) {
            bitmapDrawable = null;
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(3);
            z2 = ThemeHooks.d;
            ThemeHooks.d = false;
            try {
                paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
                ThemeHooks.d = z2;
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap);
            } catch (Throwable th2) {
                ThemeHooks.d = z2;
                throw th2;
            }
        }
        linearLayout.addView(a(bitmapDrawable, l6.a("support_project"), (String) null, (String) null, 1, false, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.this.h(view);
            }
        }));
        linearLayout.addView(a(l6.a("section_region")));
        linearLayout.addView(o());
        linearLayout.addView(a(l6.a("section_content_filter")));
        linearLayout.addView(i());
        linearLayout.addView(a(l6.a("section_feed")));
        linearLayout.addView(j());
        linearLayout.addView(a(l6.a("section_misc")));
        linearLayout.addView(m());
        linearLayout.addView(a(l6.a("section_autostreak")));
        linearLayout.addView(d());
        linearLayout.addView(a(l6.a("anti_burnout")));
        linearLayout.addView(c());
        linearLayout.addView(a(l6.a("section_font")));
        linearLayout.addView(k());
        linearLayout.addView(a(l6.a("section_appearance")));
        linearLayout.addView(h());
        LinearLayout linearLayoutG = g();
        linearLayoutG.setPadding(0, a(4.0f), 0, a(4.0f));
        linearLayoutG.setClipToPadding(false);
        linearLayoutG.setClipChildren(false);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setMinimumHeight(a(48.0f));
        linearLayout2.setPadding(a(16.0f), a(4.0f), a(16.0f), a(4.0f));
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b("ic_mod_logo"));
        linearLayout2.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView2 = new TextView(this);
        textView2.setText(l6.a("app_icon"));
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        if (this.b) {
            i = -1;
        } else {
            i = -16777216;
        }
        textView2.setTextColor(i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout2.addView(textView2, layoutParams);
        linearLayoutG.addView(linearLayout2);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setClipToPadding(false);
        horizontalScrollView.setClipChildren(false);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setPadding(a(16.0f), a(4.0f), a(16.0f), a(12.0f));
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.w = linearLayout3;
        linearLayout3.setOrientation(0);
        this.x = k6.a();
        arrayListA = k6.a((Context) this);
        size = arrayListA.size();
        i2 = 0;
        j6Var = null;
        while (i2 < size) {
            Object obj = arrayListA.get(i2);
            i2++;
            j6Var2 = (j6) obj;
            if ("md".equals(j6Var2.a)) {
                j6Var = j6Var2;
            } else {
                this.w.addView(a(j6Var2, j6Var2.a.equals(this.x)));
            }
        }
        if (j6Var != null) {
            this.w.addView(a(j6Var, "md".equals(this.x)));
        }
        horizontalScrollView.addView(this.w);
        linearLayoutG.addView(horizontalScrollView);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = a(10.0f);
        linearLayout.addView(linearLayoutG, layoutParams2);
        linearLayout.addView(a(l6.a("section_other")));
        LinearLayout linearLayoutG2 = g();
        linearLayoutG2.setPadding(0, a(4.0f), 0, a(4.0f));
        linearLayoutG2.addView(q());
        linearLayout.addView(linearLayoutG2);
        View viewN = n();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = a(10.0f);
        linearLayout.addView(viewN, layoutParams3);
        linearLayout.addView(a(l6.a("section_about")));
        linearLayout.addView(b());
        linearLayout.addView(new Space(this), new LinearLayout.LayoutParams(-1, a(20.0f)));
    }

    public final void d(View view) {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(335544320);
            startActivity(launchIntentForPackage);
        }
        Runtime.getRuntime().exit(0);
    }

    public final  boolean c(View view) {
        G();
        return true;
    }

    public final void h(Dialog dialog, View view) {
        int i;
        Context applicationContext = getApplicationContext();
        String[] strArr = BadgeHooks.a;
        if (applicationContext == null) {
            i = 0;
        } else {
            char[] cArr = m0.a;
            File file = new File(m0.a(applicationContext), "supporters_cache.txt");
            i = (file.exists() && file.delete()) ? 1 : 0;
            File file2 = new File(m0.a(applicationContext), "supporters_fetch.stamp");
            if (file2.exists() && file2.delete()) {
                i++;
            }
            File file3 = new File(m0.a(applicationContext), "supporters_cache.etag");
            if (file3.exists() && file3.delete()) {
                i++;
            }
            BadgeHooks.p.set(false);
        }
        Toast.makeText((Context) this, (CharSequence) ("Support list cache cleaned: " + i), 0).show();
        a(dialog);
    }

    public static  void a(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            return;
        }
        compoundButton.setChecked(true);
    }

    public final void a(HorizontalScrollView horizontalScrollView, TextView textView, CompoundButton compoundButton, boolean z2) {
        ta.a().getClass();
        ta.d().g(z2);
        horizontalScrollView.setVisibility(z2 ? 0 : 8);
        textView.setVisibility(z2 ? 0 : 8);
        ThemeHooks.a = 0;
        ThemeHooks.b = 0;
        C();
    }

    public final FrameLayout a(final int i, boolean z2) {
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
        view.setVisibility(z2 ? 0 : 4);
        frameLayout.addView(view, new FrameLayout.LayoutParams(iA2, iA2));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i);
        if (!z2) {
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
                le.this.a(frameLayout, i, view3);
            }
        });
        return frameLayout;
    }

    public final void a(FrameLayout frameLayout, int i, View view) {
        int iIndexOfChild = this.v.indexOfChild(frameLayout);
        if (Build.VERSION.SDK_INT >= 31 && iIndexOfChild == 0) {
            i = 0;
        }
        ta.a().getClass();
        ta.d().a(i);
        ThemeHooks.a = 0;
        ThemeHooks.b = 0;
        ThemeHooks.d = false;
        int i2 = 0;
        while (i2 < this.v.getChildCount()) {
            FrameLayout frameLayout2 = (FrameLayout) this.v.getChildAt(i2);
            boolean z2 = i2 == iIndexOfChild;
            View childAt = frameLayout2.getChildAt(0);
            GradientDrawable gradientDrawable = (GradientDrawable) frameLayout2.getChildAt(1).getBackground();
            if (z2) {
                gradientDrawable.setCornerRadius(a(8.0f));
                childAt.setVisibility(0);
            } else {
                gradientDrawable.setCornerRadius(a(32.0f) / 2.0f);
                childAt.setVisibility(4);
            }
            i2++;
        }
        ThemeHooks.d = true;
        C();
    }

    public final void a(View view, boolean z2) {
        ta.a().getClass();
        ta.d().e(z2);
        view.setVisibility(z2 ? 0 : 8);
        this.n.setVisibility(z2 ? 0 : 8);
        this.m.setVisibility(z2 ? 0 : 8);
        Z.t.b();
    }

    public final LinearLayout a(final j6 j6Var, boolean z2) {
        int iA = a(46.0f);
        int iA2 = a(4.0f);
        int i = (iA2 * 2) + iA;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setTag(j6Var.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = a(12.0f);
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        int iA3 = a(12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(iA2 + iA3);
        gradientDrawable.setStroke(a(2.0f), t());
        View view = new View(this);
        view.setBackground(gradientDrawable);
        view.setVisibility(z2 ? 0 : 4);
        frameLayout.addView(view, new FrameLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(this);
        Drawable drawableA = k6.a(this, j6Var);
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
        imageView.setOutlineProvider(new ee(iA3));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = 17;
        frameLayout.addView(imageView, layoutParams2);
        linearLayout.addView(frameLayout);
        TextView textView = new TextView(this);
        textView.setText(j6Var.a());
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setTextColor(z2 ? t() : B);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(a(8.0f) + i, -2);
        layoutParams3.topMargin = a(6.0f);
        linearLayout.addView(textView, layoutParams3);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                le.this.a(j6Var, view2);
            }
        });
        return linearLayout;
    }

    public final void a(ta taVar, TimePicker timePicker, int i, int i2) {
        taVar.getClass();
        ta.d().a(i, i2);
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(String.format(Locale.US, "%02d:%02d", Integer.valueOf(d5.a().p), Integer.valueOf(d5.a().q)));
        }
        Z.t.b();
    }

    public final void a(List list, RadioGroup radioGroup, int i) {
        if (i < 0 || i >= list.size()) {
            return;
        }
        String str = ((String[]) list.get(i))[0];
        ta.a().getClass();
        ta.d().c(str);
        FontHooks.a = null;
        FontHooks.b = null;
        FontHooks.c.clear();
        K();
        C();
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
        linearLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), null, new ColorDrawable(-1)));
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(b(str));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setTextColor(this.b ? -1 : -16777216);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(textView2, layoutParams);
        if (textView != null) {
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(B);
            textView.setSingleLine(true);
            linearLayout.addView(textView);
        }
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageBitmap(b("ic_arrow_right"));
        imageView2.setColorFilter(D);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams2.leftMargin = a(8.0f);
        linearLayout.addView(imageView2, layoutParams2);
        return linearLayout;
    }

    public final void a(long j) {
        ta.a().getClass();
        ta.d().a(j);
        J();
        C();
    }

    public final void a(String str, String str2, long j, final he heVar) {
        final ge geVarA = a(str, str2);
        final EditText editText = geVarA.a;
        editText.setInputType(2);
        editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        if (j > 0) {
            editText.setText(String.valueOf(j));
        }
        editText.setSelection(editText.getText().length());
        Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                le.a(editText, geVarA);
            }
        };
        editText.addTextChangedListener(new ke(runnable));
        runnable.run();
        geVarA.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.a(editText, heVar, geVarA, view);
            }
        });
        geVarA.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.a(editText, heVar, view);
            }
        });
        geVarA.e.run();
    }

    public static  void a(EditText editText, ge geVar) {
        String strTrim = editText.getText().toString().trim();
        if (strTrim.isEmpty()) {
            geVar.a((String) null);
            geVar.a(true);
            return;
        }
        try {
            if (Long.parseLong(strTrim) > 100000000000L) {
                geVar.a(l6.a("filter_error_too_big"));
                geVar.a(false);
            } else {
                geVar.a((String) null);
                geVar.a(true);
            }
        } catch (NumberFormatException e) {
            geVar.a(l6.a("filter_error_too_big"));
            geVar.a(false);
        }
    }

    public static  void a(EditText editText, he heVar, ge geVar, View view) {
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
        heVar.a(j);
        geVar.f.run();
    }

    public static  void a(EditText editText, he heVar, View view) {
        editText.setText("");
        heVar.a(0L);
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
                le.this.a(jArr, textView, datePicker, i, i2, i3);
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

    public final void a(long[] jArr, Dialog dialog, View view) {
        ta taVarA = ta.a();
        long jMax = Math.max(0L, jArr[0]);
        taVarA.getClass();
        ta.d().b(jMax);
        J();
        C();
        try {
            dialog.dismiss();
        } catch (Throwable th) {
        }
    }

    public final ge a(String str, String str2) {
        boolean z2 = this.b;
        int i = z2 ? -14935010 : -1;
        int color = z2 ? -1 : Color.parseColor("#161823");
        boolean z3 = this.b;
        int i2 = z3 ? -6579293 : -9210757;
        int i3 = z3 ? -12961220 : -2434337;
        int color2 = z3 ? -13882322 : Color.parseColor("#F1F1F2");
        int i4 = B;
        int iT = t();
        int color3 = this.b ? -13882322 : Color.parseColor("#F1F1F2");
        int i5 = this.b ? -1 : -16777216;
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
        textView3.setText(l6.a("filter_input_from"));
        textView3.setTextSize(2, 16.0f);
        textView3.setTextColor(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.rightMargin = a(12.0f);
        linearLayout2.addView(textView3, layoutParams3);
        int i6 = this.b ? -1 : -16777216;
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
        textView4.setText(l6.a("filter_reset"));
        textView4.setTextSize(2, 16.0f);
        textView4.setTextColor(iT);
        textView4.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView4.setPadding(a(12.0f), a(8.0f), a(4.0f), a(8.0f));
        linearLayout2.addView(textView4, new LinearLayout.LayoutParams(-2, -2));
        TextView textView5 = new TextView(this);
        textView5.setText("");
        textView5.setGravity(17);
        textView5.setTextSize(2, 13.5f);
        textView5.setTextColor(iT);
        textView5.setSingleLine(true);
        textView5.setVisibility(4);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = a(12.0f);
        linearLayout.addView(textView5, layoutParams4);
        TextView textView6 = new TextView(this);
        textView6.setText(l6.a("filter_save"));
        textView6.setGravity(17);
        textView6.setTextColor(-1);
        textView6.setTextSize(2, 15.0f);
        textView6.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, a(52.0f));
        layoutParams5.topMargin = a(24.0f);
        linearLayout.addView(textView6, layoutParams5);
        TextView textView7 = new TextView(this);
        textView7.setText(l6.a("filter_cancel"));
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
        final Dialog dialogA = wa.a((Activity) this);
        dialogA.setContentView(wa.a((Activity) this, (ViewGroup) linearLayout, -2, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                le.a(dialogA, view);
            }
        }));
        dialogA.setCancelable(true);
        wa.a(dialogA, linearLayout, i, 0.55f);
        Window window = dialogA.getWindow();
        if (window != null) {
            window.setSoftInputMode(20);
        }
        final ge geVar = new ge();
        geVar.a = editText;
        geVar.b = textView5;
        geVar.c = textView6;
        geVar.d = textView4;
        geVar.g = iT;
        geVar.h = (16777215 & iT) | Integer.MIN_VALUE;
        geVar.i = a(26.0f);
        geVar.j = i6;
        geVar.k = iT;
        geVar.f = new Runnable() {
            @Override
            public final void run() {
                le.b(dialogA);
            }
        };
        geVar.e = new Runnable() {
            @Override
            public final void run() {
                le.this.a(dialogA, editText);
            }
        };
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                geVar.f.run();
            }
        });
        geVar.a(true);
        return geVar;
    }

    public static  void a(Dialog dialog, View view) {
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

    public final void a() {
        if (this.a.compareAndSet(false, true)) {
            Toast.makeText((Context) this, (CharSequence) l6.a("check_updates_checking"), 0).show();
            nb nbVar = new nb() {
                @Override
                public final void a(ob obVar) {
                    le.this.a(obVar);
                }
            };
            pb pbVar = pb.a;
            pb.a.getClass();
            pb.a(true, nbVar);
        }
    }

    public final  void a(ob obVar) {
        this.a.set(false);
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (obVar == ob.a) {
            Toast.makeText((Context) this, (CharSequence) l6.a("check_updates_up_to_date"), 0).show();
        } else if (obVar == ob.d) {
            Toast.makeText((Context) this, (CharSequence) l6.a("check_updates_failed"), 0).show();
        }
    }

    public final  void a(boolean z2, int i, String str) {
        String string;
        if (z2) {
            string = "Support list refreshed: " + i;
        } else {
            StringBuilder sbAppend = new StringBuilder().append("Support list refresh failed: ");
            if (TextUtils.isEmpty(str)) {
                str = "unknown error";
            }
            string = sbAppend.append(str).toString();
        }
        Toast.makeText((Context) this, (CharSequence) string, 1).show();
    }

    public final  void a(g6 g6Var) {
        Toast.makeText((Context) this, (CharSequence) String.format(Locale.US, "Logs exported: %s (%d files, %.1f KiB)", g6Var.a, Integer.valueOf(g6Var.c), Double.valueOf(g6Var.b / 1024.0d)), 1).show();
    }

    public final  void a(t5 t5Var) {
        Toast.makeText((Context) this, (CharSequence) String.format(Locale.US, "Heap dump exported: %s (%.1f MiB)", t5Var.a, Double.valueOf(t5Var.b / 1048576.0d)), 1).show();
    }

    public final  void a(Throwable th) {
        Toast.makeText((Context) this, (CharSequence) ("Heap dump export failed: " + th.getMessage()), 1).show();
    }

    public static void a(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Throwable th) {
            }
        }
    }

    public final FrameLayout a(BitmapDrawable bitmapDrawable, String str, String str2, final String str3, int i, boolean z2, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = new FrameLayout(this);
        int iA = a(str2 != null ? 12.0f : 14.0f);
        frameLayout.setPadding(0, iA, 0, iA);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? A : -1);
        gradientDrawable.setCornerRadii(a(i));
        frameLayout.setBackground(gradientDrawable);
        boolean z3 = (str3 == null && onClickListener == null) ? false : true;
        if (z3) {
            frameLayout.setOnClickListener(onClickListener != null ? onClickListener : new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    le.this.a(str3, view);
                }
            });
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(-1);
            gradientDrawable2.setCornerRadii(a(i));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(this.b ? A : -1);
            gradientDrawable3.setCornerRadii(a(i));
            frameLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), gradientDrawable3, gradientDrawable2));
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
        textView.setTextColor(this.b ? -1 : -16777216);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout.addView(textView);
        if (str2 != null) {
            TextView textView2 = new TextView(this);
            textView2.setText(str2);
            textView2.setTextSize(2, 14.0f);
            textView2.setTextColor(B);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = a(4.0f);
            linearLayout.addView(textView2, layoutParams2);
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = a(48.0f);
        layoutParams3.rightMargin = z3 ? a(52.0f) : a(16.0f);
        layoutParams3.gravity = 19;
        frameLayout.addView(linearLayout, layoutParams3);
        if (z3) {
            if (z2) {
                TextView textView3 = new TextView(this);
                textView3.setText(l6.a("mod_update_download"));
                textView3.setTextSize(2, 13.0f);
                textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
                textView3.setTextColor(-1);
                textView3.setGravity(17);
                textView3.setPadding(a(14.0f), a(6.0f), a(14.0f), a(6.0f));
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setColor(t());
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
            imageView2.setColorFilter(D);
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
        textView.setTextColor(C);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setPadding(a(28.0f), a(16.0f), 0, a(12.0f));
        return textView;
    }

    public static StateListDrawable a(ContextThemeWrapper contextThemeWrapper, boolean z2, int i) {
        String str;
        String str2;
        BitmapDrawable bitmapDrawable;
        int color = Color.parseColor((z2 ? "#555555" : "#BBBBBB"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        Bitmap bitmapA = a(contextThemeWrapper, "ic_check_active");
        BitmapDrawable bitmapDrawable2 = null;
        if (bitmapA == null) {
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(contextThemeWrapper.getResources(), bitmapA);
            bitmapDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        Bitmap bitmapA2 = a(contextThemeWrapper, "ic_check_inactive");
        if (bitmapA2 != null) {
            bitmapDrawable2 = new BitmapDrawable(contextThemeWrapper.getResources(), bitmapA2);
            bitmapDrawable2.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        if (bitmapDrawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_checked}, bitmapDrawable);
        }
        if (bitmapDrawable2 != null) {
            stateListDrawable.addState(new int[0], bitmapDrawable2);
        }
        return stateListDrawable;
    }

    public final CheckBox a(String str, String str2, boolean z2, final je jeVar, final boolean z3) {
        BitmapDrawable bitmapDrawable;
        CheckBox checkBox = new CheckBox(this);
        checkBox.setSaveEnabled(false);
        checkBox.setText(str);
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(Typeface.create("sans-serif-medium", 0));
        checkBox.setMinHeight(a(48.0f));
        checkBox.setTextColor(this.b ? -1 : -16777216);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        checkBox.setPadding(a(16.0f), 0, a(16.0f), 0);
        StateListDrawable stateListDrawableA = a((ContextThemeWrapper) this, this.b, t());
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
        stateListDrawableA.setBounds(0, 0, iA, iA);
        checkBox.setCompoundDrawables(bitmapDrawable, null, stateListDrawableA, null);
        checkBox.setCompoundDrawablePadding(a(12.0f));
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        checkBox.setChecked(z2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                le.this.a(jeVar, z3, compoundButton, z4);
            }
        });
        checkBox.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), null, new ColorDrawable(-1)));
        return checkBox;
    }

    public final  void a(je jeVar, boolean z2, CompoundButton compoundButton, boolean z3) {
        if (jeVar != null) {
            jeVar.a(z3);
        }
        if (z2) {
            C();
        }
    }

    public final int a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream inputStreamOpen = ResourceOverlay.open(context, "mod_icons/" + str + ".png");
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

    public final FrameLayout a(String str, String str2, String str3, String str4, int i, boolean z2, View.OnClickListener onClickListener) {
        BitmapDrawable bitmapDrawable;
        if (!z2) {
            Bitmap bitmapB = b(str);
            bitmapDrawable = bitmapB != null ? new BitmapDrawable(getResources(), bitmapB) : null;
        } else {
            int iT = t();
            Bitmap bitmapB2 = b(str);
            BitmapDrawable bitmapDrawable2 = bitmapB2 != null ? new BitmapDrawable(getResources(), bitmapB2) : null;
            if (bitmapDrawable2 != null) {
                bitmapDrawable2.setColorFilter(iT, PorterDuff.Mode.SRC_IN);
            }
            bitmapDrawable = bitmapDrawable2;
        }
        return a(bitmapDrawable, str2, str3, str4, i, z2, onClickListener);
    }
}
