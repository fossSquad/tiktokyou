package Z;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.text.StringsKt;

public final class ng {
    public static final LocalDate l;
    public final i0 a;
    public final hi b;
    public final zf c;
    public final LinearLayout d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public LinearLayout i;
    public bi j;
    public bi k;

    static {
        l = LocalDate.of(2026, 1, 25);
    }

    public ng(i0 i0Var, hi hiVar) {
        this.a = i0Var;
        this.b = hiVar;
        this.c = new zf(i0Var, hiVar);
        LinearLayout linearLayout = new LinearLayout(i0Var);
        this.d = linearLayout;
        linearLayout.setOrientation(1);
    }

    public final void a(LinearLayout linearLayout) {
        linearLayout.addView(this.c.a("ic_autotease", k7.a("auto_streak_toggle"), y5.a().t, new gi() {
            @Override
            public final void a(boolean z) {
                this.f$0.a(z);
            }
        }));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.b.a(4.0f);
        LinearLayout linearLayout2 = this.d;
        LinearLayout linearLayoutC = this.b.c();
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        linearLayout3.setPadding(this.b.a(10.0f), this.b.a(10.0f), this.b.a(10.0f), this.b.a(10.0f));
        linearLayoutC.addView(linearLayout3);
        String strDecrypt = "ic_arrow_right";
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, strDecrypt));
        int iE = this.b.e();
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(iE, mode);
        imageView.setScaleX(-1.0f);
        linearLayout3.addView(imageView, new LinearLayout.LayoutParams(this.b.a(24.0f), this.b.a(24.0f)));
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setImageBitmap(hi.a(this.b.a, "ic_avatar_default"));
        imageView2.setClipToOutline(true);
        imageView2.setOutlineProvider(new lg());
        linearLayout3.addView(imageView2, a(30, 30, 10));
        TextView textViewB = this.c.b("TikTok You");
        textViewB.setSingleLine(true);
        linearLayout3.addView(textViewB, a(-2, -2, 10));
        ImageView imageView3 = new ImageView(this.a);
        hi hiVar = this.b;
        String strDecrypt2 = "ic_streak_badge";
        this.b.getClass();
        imageView3.setImageDrawable(hiVar.b(hi.a(), strDecrypt2));
        linearLayout3.addView(imageView3, a(20, 20, 6));
        ImageView imageView4 = new ImageView(this.a);
        imageView4.setImageBitmap(hi.a(this.b.a, "ic_streak_flame_gray"));
        linearLayout3.addView(imageView4, a(14, 14, 4));
        TextView textView = new TextView(this.a);
        textView.setText(String.valueOf(ChronoUnit.DAYS.between(l, LocalDate.now())));
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(hi.f());
        textView.setTextColor(-5723992);
        linearLayout3.addView(textView, a(-2, -2, 2));
        linearLayout3.addView(new View(this.a), new LinearLayout.LayoutParams(0, 1, 1.0f));
        String strDecrypt3 = "ic_star";
        ImageView imageView5 = new ImageView(this.a);
        imageView5.setImageBitmap(hi.a(this.b.a, strDecrypt3));
        imageView5.setColorFilter(this.b.e(), mode);
        linearLayout3.addView(imageView5, a(25, 25, 10));
        String strDecrypt4 = "ic_more_horizontal";
        ImageView imageView6 = new ImageView(this.a);
        imageView6.setImageBitmap(hi.a(this.b.a, strDecrypt4));
        imageView6.setColorFilter(this.b.e(), mode);
        linearLayout3.addView(imageView6, a(24, 24, 16));
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        linearLayout4.setOrientation(1);
        linearLayout4.setPadding(this.b.a(20.0f), 0, this.b.a(20.0f), this.b.a(16.0f));
        linearLayoutC.addView(linearLayout4);
        TextView textView2 = new TextView(this.a);
        this.f = textView2;
        textView2.setTextSize(2, 12.0f);
        this.f.setTextColor(-8158333);
        this.f.setGravity(17);
        this.f.setPadding(this.b.a(10.0f), this.b.a(10.0f), this.b.a(10.0f), this.b.a(10.0f));
        linearLayout4.addView(this.f, new LinearLayout.LayoutParams(-1, -2));
        ImageView imageView7 = new ImageView(this.a);
        imageView7.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView7.setClipToOutline(true);
        imageView7.setOutlineProvider(new mg(this));
        this.h = imageView7;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.b.a(106.0f), this.b.a(106.0f));
        layoutParams2.gravity = 8388613;
        layoutParams2.topMargin = this.b.a(16.0f);
        linearLayout4.addView(this.h, layoutParams2);
        linearLayout2.addView(linearLayoutC, layoutParams);
        this.d.addView(this.c.a(k7.a("auto_streak_settings_section")));
        this.d.addView(c());
        linearLayout.addView(this.d);
        String str = String.format(Locale.US, "%02d:%02d", Integer.valueOf(y5.a().u), Integer.valueOf(y5.a().v));
        this.e.setText(str);
        this.f.setText(String.format(k7.a("auto_streak_preview_today"), str));
        f();
        r0.a(this.a, new ng$$ExternalSyntheticLambda5(this));
        e();
        ac.a().getClass();
        boolean z = ac.e().t;
        if (!z && this.i.getVisibility() == 0) {
            this.i.setVisibility(8);
        }
        this.d.setAlpha(z ? 1.0f : 0.3f);
        zf.a(z, this.d);
    }

    public final  void b() {
        h0.a(this.a, new Runnable() {
            @Override
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public final LinearLayout c() {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setClipToOutline(true);
        linearLayoutC.addView(d());
        linearLayoutC.addView(g());
        linearLayoutC.addView(this.c.a("ic_autotease_opt", k7.a("auto_streak_sticker"), (TextView) null, new Runnable() {
            @Override
            public final void run() {
                this.f$0.a();
            }
        }));
        TextView textView = new TextView(this.a);
        this.g = textView;
        textView.setTextSize(2, 14.0f);
        this.g.setTextColor(-7171947);
        this.g.setSingleLine(true);
        linearLayoutC.addView(this.c.a("ic_autotease_order", k7.a("auto_streak_recipients"), this.g, new Runnable() {
            @Override
            public final void run() {
                this.f$0.b();
            }
        }));
        return linearLayoutC;
    }

    public final LinearLayout d() {
        LinearLayout linearLayoutA = this.c.a("ic_clock", k7.a("auto_streak_nudge_time"));
        linearLayoutA.setPadding(this.b.a(20.0f), this.b.a(12.0f), this.b.a(20.0f), this.b.a(12.0f));
        linearLayoutA.setClickable(true);
        linearLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        this.b.a(linearLayoutA);
        TextView textView = new TextView(this.a);
        this.e = textView;
        textView.setTextSize(2, 14.0f);
        this.e.setTypeface(hi.f());
        this.e.setTextColor(this.b.e());
        this.e.setGravity(17);
        this.e.setPadding(this.b.a(6.0f), 0, this.b.a(6.0f), 0);
        TextView textView2 = this.e;
        hi hiVar = this.b;
        int i = hiVar.b ? -13882322 : -657931;
        float fA = hiVar.a(4.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        textView2.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.b.a(28.0f));
        layoutParams.leftMargin = this.b.a(12.0f);
        linearLayoutA.addView(this.e, layoutParams);
        return linearLayoutA;
    }

    public final void e() {
        ac.a().getClass();
        if (ac.c()) {
            this.g.setText(k7.a("auto_streak_recipients_all"));
            return;
        }
        TextView textView = this.g;
        Locale locale = Locale.getDefault();
        String strA = k7.a("auto_streak_recipients_selected");
        List<e0> listA = g0.a();
        int i = 0;
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            for (e0 e0Var : listA) {
                ac acVar = ac.a;
                String str = e0Var.a;
                acVar.getClass();
                if (ac.c() || (str != null && !ac.b().contains(str))) {
                    i++;
                    if (i < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        textView.setText(String.format(locale, strA, Integer.valueOf(i)));
    }

    public final void f() {
        String string;
        ImageView imageView = this.h;
        BaseActivity baseActivity = this.a;
        d2 d2Var = r0.a;
        u0.a.getClass();
        ac.a.getClass();
        SharedPreferences sharedPreferences = ac.b;
        String strDecrypt = "";
        if (sharedPreferences != null && (string = sharedPreferences.getString("auto_streak_sticker_url", "")) != null) {
            strDecrypt = string;
        }
        if (StringsKt.isBlank(strDecrypt)) {
            strDecrypt = "https://p16-tiktokcdn-com.akamaized.net/obj/im-resource-tiktok/fire.webp";
        }
        d2 d2Var2 = r0.a;
        r0.a(strDecrypt, (Activity) baseActivity, imageView);
    }

    public final LinearLayout g() {
        ac acVarA = ac.a();
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.b.a(20.0f), this.b.a(12.0f), this.b.a(20.0f), this.b.a(12.0f));
        linearLayout.setVisibility(8);
        this.i = linearLayout;
        i0 i0Var = this.a;
        hi hiVar = this.b;
        acVarA.getClass();
        this.j = new bi(i0Var, hiVar, 24, ac.e().u);
        this.k = new bi(this.a, this.b, 60, ac.e().v);
        this.j.setListener(new ai() {
            @Override
            public final void a(int i) {
                this.f$0.a(i);
            }
        });
        this.k.setListener(new ai() {
            @Override
            public final void a(int i) {
                this.f$0.b(i);
            }
        });
        linearLayout.addView(this.j, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = this.b.a(12.0f);
        linearLayout.addView(this.k, layoutParams);
        return linearLayout;
    }

    public final void b(int i) {
        ac acVarA = ac.a();
        int selected = this.j.getSelected();
        int selected2 = this.k.getSelected();
        acVarA.getClass();
        ac.e().a(selected, selected2);
        String str = String.format(Locale.US, "%02d:%02d", Integer.valueOf(y5.a().u), Integer.valueOf(y5.a().v));
        this.e.setText(str);
        this.f.setText(String.format(k7.a("auto_streak_preview_today"), str));
        b0.b();
    }

    public final void a(boolean z) {
        ac.a().getClass();
        bc bcVarE = ac.e();
        bcVarE.t = z;
        bcVarE.a.edit().putBoolean("auto_streak_nudge_enabled", z).apply();
        b0.b();
        ac.a().getClass();
        boolean z2 = ac.e().t;
        if (!z2 && this.i.getVisibility() == 0) {
            this.i.setVisibility(8);
        }
        this.d.setAlpha(z2 ? 1.0f : 0.3f);
        zf.a(z2, this.d);
    }

    public final  void a() {
        r0.b(this.a, new ng$$ExternalSyntheticLambda5(this));
    }

    public final void a(View view) {
        boolean z = this.i.getVisibility() != 0;
        if (z) {
            ac acVarA = ac.a();
            bi biVar = this.j;
            acVarA.getClass();
            biVar.setValue(ac.e().u);
            this.k.setValue(ac.e().v);
        }
        this.i.setVisibility(z ? 0 : 8);
    }

    public final void a(int i) {
        ac acVarA = ac.a();
        int selected = this.j.getSelected();
        int selected2 = this.k.getSelected();
        acVarA.getClass();
        ac.e().a(selected, selected2);
        String str = String.format(Locale.US, "%02d:%02d", Integer.valueOf(y5.a().u), Integer.valueOf(y5.a().v));
        this.e.setText(str);
        this.f.setText(String.format(k7.a("auto_streak_preview_today"), str));
        b0.b();
    }

    public final LinearLayout.LayoutParams a(int i, int i2, int i3) {
        if (i > 0) {
            i = this.b.a(i);
        }
        if (i2 > 0) {
            i2 = this.b.a(i2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = this.b.a(i3);
        return layoutParams;
    }
}
