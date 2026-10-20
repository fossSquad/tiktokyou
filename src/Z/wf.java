package Z;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.foundation.activity.BaseActivity;
import com.windukk.mod.Main;
import com.windukk.mod.hooks.SettingsHooks;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public final class wf {
    public ImageView A;
    public final sf a;
    public final hi b;
    public final int c;
    public final int d;
    public final int e;
    public final Consumer f;
    public final SettingsHooks h;
    public LinearLayout i;
    public LinearLayout j;
    public vf k;
    public LinearLayout l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public GradientDrawable p;
    public GradientDrawable q;
    public GradientDrawable r;
    public View s;
    public int t;
    public int u;
    public ImageView w;
    public ObjectAnimator x;
    public TextView y;
    public LinearLayout z;
    public final AtomicBoolean g = new AtomicBoolean(false);
    public int v = -1;

    static {
    }

    public wf(sf sfVar, hi hiVar, int i, int i2, int i3, Consumer consumer) {
        this.a = sfVar;
        this.b = hiVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = consumer;
        this.h = new SettingsHooks(sfVar);
    }

    public final FrameLayout a() {
        String str;
        String str2;
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setTag("ModSettingsView");
        frameLayout.setClickable(true);
        frameLayout.setFocusableInTouchMode(true);
        frameLayout.setBackgroundColor(this.b.b ? -16777216 : hi.d);
        this.f.accept(frameLayout);
        sf sfVar = this.a;
        this.b.getClass();
        frameLayout.addView(new z6(sfVar, hi.a()), new FrameLayout.LayoutParams(-1, -1));
        vf vfVar = new vf(this, this.a);
        this.k = vfVar;
        vfVar.setVerticalScrollBarEnabled(false);
        this.k.setOverScrollMode(2);
        this.k.setFillViewport(true);
        frameLayout.addView(this.k, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.i = linearLayout;
        linearLayout.setOrientation(1);
        this.k.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        frameLayout2.addView(new Space(this.a), new FrameLayout.LayoutParams(-1, this.e));
        LinearLayout linearLayoutE = e();
        this.j = linearLayoutE;
        frameLayout2.addView(linearLayoutE);
        linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        this.u = this.b.a(56.0f) + this.c;
        linearLayout2.setMinimumHeight(Math.max(0, this.a.getResources().getDisplayMetrics().heightPixels - this.u));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        this.s = new View(this.a);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b.b ? -12961220 : -2763302);
        gradientDrawable.setCornerRadius(this.b.a(2.0f));
        this.s.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b.a(48.0f), this.b.a(4.0f));
        layoutParams.gravity = 1;
        layoutParams.topMargin = this.b.a(8.0f);
        layoutParams.bottomMargin = this.b.a(8.0f);
        linearLayout2.addView(this.s, layoutParams);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(1);
        linearLayout3.setPadding(this.b.a(8.0f), 0, this.b.a(8.0f), this.b.a(20.0f) + this.d);
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.addView(g());
        hi hiVar = this.b;
        String strA = k7.a("settings_community");
        hiVar.getClass();
        TextView textView = new TextView(hiVar.a);
        textView.setText(strA);
        textView.setTextSize(2, 14.0f);
        int i = hi.g;
        textView.setTextColor(i);
        textView.setTypeface(hi.f());
        textView.setPadding(hiVar.a(8.0f), hiVar.a(16.0f), hiVar.a(8.0f), hiVar.a(8.0f));
        linearLayout3.addView(textView);
        linearLayout3.addView(c());
        hi hiVar2 = this.b;
        String strA2 = k7.a("settings_more");
        hiVar2.getClass();
        TextView textView2 = new TextView(hiVar2.a);
        textView2.setText(strA2);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(i);
        textView2.setTypeface(hi.f());
        textView2.setPadding(hiVar2.a(8.0f), hiVar2.a(16.0f), hiVar2.a(8.0f), hiVar2.a(8.0f));
        linearLayout3.addView(textView2);
        linearLayout3.addView(o());
        String strA3 = k7.a("settings_legal_prefix");
        SpannableString spannableString = new SpannableString(strA3 + k7.a("settings_legal_link"));
        int color = this.b.b ? -1 : Color.parseColor("#161823");
        spannableString.setSpan(new uf(this, color), strA3.length(), spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(color), strA3.length(), spannableString.length(), 33);
        TextView textView3 = new TextView(this.a);
        textView3.setText(spannableString);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        textView3.setHighlightColor(0);
        textView3.setTextSize(2, 13.0f);
        textView3.setTextColor(hi.f);
        textView3.setGravity(17);
        textView3.setPadding(this.b.a(12.0f), this.b.a(18.0f), this.b.a(12.0f), this.b.a(8.0f));
        linearLayout3.addView(textView3);
        a(frameLayout);
        ImageView imageViewA = this.b.a("ic_back");
        this.n = imageViewA;
        imageViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                wf.this.a(view);
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.b.a(36.0f), this.b.a(36.0f));
        layoutParams2.leftMargin = this.b.a(8.0f);
        layoutParams2.topMargin = this.b.a(8.0f) + this.c;
        layoutParams2.gravity = 51;
        frameLayout.addView(this.n, layoutParams2);
        ImageView imageViewA2 = this.b.a("ic_more");
        this.o = imageViewA2;
        imageViewA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                wf.this.b(view);
            }
        });
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.b.a(36.0f), this.b.a(36.0f));
        layoutParams3.rightMargin = this.b.a(8.0f);
        layoutParams3.topMargin = this.b.a(8.0f) + this.c;
        layoutParams3.gravity = 53;
        frameLayout.addView(this.o, layoutParams3);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(872415231);
        this.p = gradientDrawable2;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(1);
        gradientDrawable3.setColor(872415231);
        this.q = gradientDrawable3;
        this.n.setBackground(this.p);
        this.o.setBackground(this.q);
        ImageView imageView = this.n;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(-1, mode);
        this.o.setColorFilter(-1, mode);
        this.k.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public final void onScrollChanged() {
                wf.this.h();
            }
        });
        this.t = Color.parseColor((this.b.b ? "#141414" : "#F3F3F5"));
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        this.r = gradientDrawable4;
        gradientDrawable4.setColor(this.t);
        float fA = this.b.a(28.0f);
        this.r.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout2.setBackground(this.r);
        linearLayout2.setPadding(0, this.b.a(4.0f), 0, 0);
        frameLayout.setBackgroundColor(this.t);
        a(0);
        return frameLayout;
    }

    public final  void b(View view) {
        a(this.o);
    }

    public final LinearLayout c() {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setPadding(0, this.b.a(4.0f), 0, this.b.a(4.0f));
        hi hiVar = this.b;
        String strDecrypt = "ic_telegram";
        linearLayoutC.addView(hiVar.a(hiVar.b(strDecrypt), k7.a("settings_telegram"), "https://t.me/tikyoutok", 0, null));
        hi hiVar2 = this.b;
        String strDecrypt2 = "ic_startup_faq";
        linearLayoutC.addView(hiVar2.a(hiVar2.b(strDecrypt2), k7.a("settings_faq"), "https://tiktokyou.ru/knowledge.html", 3, null));
        hi hiVar3 = this.b;
        linearLayoutC.addView(hiVar3.a(hiVar3.a(this.b.b(), "developer.png"), k7.a("settings_support"), null, 1, new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                wf.this.c(view);
            }
        }));
        return linearLayoutC;
    }

    public final  boolean d(View view) {
        this.h.g();
        return true;
    }

    public final void e(View view) {
    }

    public final  void f(View view) {
        b();
    }

    public final LinearLayout g() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.addView(a(a(null, k7.a("section_region"), false, new Runnable() {
            @Override
            public final void run() {
                wf.this.i();
            }
        }, true), a(this.b.b("ic_live"), k7.a("settings_feed"), true, new Runnable() {
            @Override
            public final void run() {
                wf.this.j();
            }
        }, false)));
        linearLayout.addView(a(a(this.b.b("ic_risovalca"), k7.a("section_appearance"), true, new Runnable() {
            @Override
            public final void run() {
                wf.this.k();
            }
        }, false), a(this.b.b("ic_autotease"), k7.a("settings_streak"), true, new Runnable() {
            @Override
            public final void run() {
                wf.this.l();
            }
        }, false)));
        return linearLayout;
    }

    public final  void h() {
        a(this.k.getScrollY());
    }

    public final  void i() {
        this.a.startActivityForResult(new Intent((Context) this.a, (Class<?>) af.class), 1002);
    }

    public final  void j() {
        this.a.startActivity(new Intent((Context) this.a, (Class<?>) t5.class));
    }

    public final  void k() {
        this.a.startActivity(new Intent((Context) this.a, (Class<?>) u.class));
    }

    public final  void l() {
        this.a.startActivity(new Intent((Context) this.a, (Class<?>) i0.class));
    }

    public final  void m() {
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setRotation(0.0f);
        }
    }

    public final void n() {
        this.h.g();
    }

    public final LinearLayout o() {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setPadding(0, this.b.a(4.0f), 0, this.b.a(4.0f));
        hi hiVar = this.b;
        String strA = k7.a("startup_auto_updates");
        String strDecrypt = "ic_download";
        boolean z = y5.a().F;
        final ac acVarA = ac.a();
        Objects.requireNonNull(acVarA);
        linearLayoutC.addView(hiVar.a(strA, strDecrypt, z, new gi() {
            @Override
            public final void a(boolean z2) {
                acVarA.c(z2);
            }
        }));
        hi hiVar2 = this.b;
        String strA2 = k7.a("startup_statistics");
        String strDecrypt2 = "ic_startup_stats";
        boolean z2 = y5.a().E;
        final ac acVarA2 = ac.a();
        Objects.requireNonNull(acVarA2);
        linearLayoutC.addView(hiVar2.a(strA2, strDecrypt2, z2, new gi() {
            @Override
            public final void a(boolean z3) {
                acVarA2.i(z3);
            }
        }));
        return linearLayoutC;
    }

    public final void p() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/octet-stream");
        this.a.startActivityForResult(intent, 1005);
    }

    public final void q() {
        ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.x = null;
        }
        ImageView imageView = this.w;
        if (imageView == null) {
            return;
        }
        imageView.animate().cancel();
        float rotation = this.w.getRotation() % 360.0f;
        if (rotation < 0.0f) {
            rotation += 360.0f;
        }
        this.w.setRotation(rotation);
        if (rotation <= 1.0f) {
            this.w.setRotation(0.0f);
        } else {
            this.w.animate().rotation(360.0f).setDuration(Math.max(60L, (long) (((360.0f - rotation) * 800.0f) / 360.0f))).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    wf.this.m();
                }
            }).start();
        }
    }

    public final void b() {
        if (this.g.compareAndSet(false, true)) {
            a(true);
            bd bdVar = new bd() {
                @Override
                public final void a(cd cdVar) {
                    wf.this.a(cdVar);
                }
            };
            dd ddVar = dd.a;
            dd.a.getClass();
            dd.a(true, bdVar);
        }
    }

    public final void d() {
        ClipboardManager clipboardManager;
        Object objInvoke;
        String strTrim = null;
        try {
            e9 e9Var = l9.a;
            Class<?> cls = Class.forName("X.03Rm");
            v9 v9Var = l9.b;
            Method methodA = v9Var.a(cls, new Class[0]);
            if (!Modifier.isStatic(methodA.getModifiers())) {
                Object obj = l9.a.a(cls).get(null);
                if (obj != null) {
                    objInvoke = v9Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
                }
                if (TextUtils.isEmpty(strTrim)) {
                    Toast.makeText((Context) this.a, (CharSequence) k7.a("copy_uid_unavailable"), 0).show();
                    return;
                }
                clipboardManager = (ClipboardManager) this.a.getSystemService(ClipboardManager.class);
                if (clipboardManager == null) {
                    Toast.makeText((Context) this.a, (CharSequence) k7.a("copy_uid_failed"), 0).show();
                } else {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("uid", strTrim));
                    Toast.makeText((Context) this.a, (CharSequence) k7.a("copy_uid_copied"), 0).show();
                }
            }
            objInvoke = methodA.invoke(null, null);
            if (objInvoke != null) {
                if (Boolean.TRUE.equals(se.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                    Object objInvoke2 = se.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
                    if (objInvoke2 instanceof String) {
                        String str = (String) objInvoke2;
                        if (!StringUtils.isBlank(str)) {
                            strTrim = str.trim();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            String strDecrypt = "Failed to resolve current uid: %s";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
        if (TextUtils.isEmpty(strTrim)) {
            Toast.makeText((Context) this.a, (CharSequence) k7.a("copy_uid_unavailable"), 0).show();
            return;
        }
        clipboardManager = (ClipboardManager) this.a.getSystemService(ClipboardManager.class);
        if (clipboardManager == null) {
            Toast.makeText((Context) this.a, (CharSequence) k7.a("copy_uid_failed"), 0).show();
        } else {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("uid", strTrim));
            Toast.makeText((Context) this.a, (CharSequence) k7.a("copy_uid_copied"), 0).show();
        }
    }

    public final LinearLayout e() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.b.a(8.0f) + this.c;
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.a);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, "ic_hub_logo_bg"));
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setImageBitmap(hi.a(this.b.a, "ic_hub_logo_fg"));
        frameLayout.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public final boolean onLongClick(View view) {
                return wf.this.d(view);
            }
        });
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(this.b.a(96.0f), this.b.a(96.0f)));
        TextView textView = new TextView(this.a);
        textView.setText("TikTok You");
        textView.setTextColor(-1);
        textView.setTextSize(2, 22.0f);
        (textView).setTypeface(android.graphics.Typeface.create("sans-serif-medium", 1));
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = this.b.a(12.0f);
        linearLayout.addView(textView, layoutParams2);
        TextView textView2 = new TextView(this.a);
        textView2.setText(String.format(Locale.getDefault(), k7.a("settings_version_line"), Main.MOD_VERSION, String.valueOf(Main.versionCode)));
        textView2.setTextColor(-419430401);
        textView2.setTextSize(2, 14.0f);
        textView2.setGravity(17);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                wf.this.e(view);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = this.b.a(4.0f);
        linearLayout.addView(textView2, layoutParams3);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding(this.b.a(14.0f), this.b.a(10.0f), this.b.a(16.0f), this.b.a(10.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(872415231);
        gradientDrawable.setCornerRadius(this.b.a(20.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                wf.this.f(view);
            }
        });
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = this.b.a(16.0f);
        linearLayout.addView(linearLayout2, layoutParams4);
        ImageView imageView3 = new ImageView(this.a);
        imageView3.setImageBitmap(hi.a(this.b.a, "ic_refresh"));
        imageView3.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        imageView3.setPivotX(this.b.a(8.0f));
        imageView3.setPivotY(this.b.a(8.0f));
        linearLayout2.addView(imageView3, new LinearLayout.LayoutParams(this.b.a(16.0f), this.b.a(16.0f)));
        this.w = imageView3;
        TextView textView3 = new TextView(this.a);
        this.y = textView3;
        textView3.setText(k7.a("settings_check_updates"));
        this.y.setTextColor(-1);
        this.y.setTextSize(2, 14.0f);
        (this.y).setTypeface(android.graphics.Typeface.create("sans-serif-medium", 0));
        this.y.setGravity(17);
        TextView textView4 = this.y;
        textView4.setMinWidth(Math.max((int) Math.ceil(textView4.getPaint().measureText(k7.a("settings_check_updates"))), (int) Math.ceil(this.y.getPaint().measureText(k7.a("settings_check_updates_progress")))));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = this.b.a(8.0f);
        linearLayout2.addView(this.y, layoutParams5);
        this.z = linearLayout2;
        return linearLayout;
    }

    public final void f() {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.animate().translationY(0.0f).setDuration(180L).start();
        }
        ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.x = null;
        }
        ImageView imageView = this.w;
        if (imageView == null) {
            return;
        }
        imageView.animate().cancel();
        this.w.animate().rotation(0.0f).setDuration(180L).start();
    }

    public final void c(View view) {
        BaseActivity baseActivity = this.a;
        String[] strArr = v1.a;
        x1.a();
        v1.b((Activity) baseActivity, (Fragment) null);
    }

    public final  void a(View view) {
        this.a.finish();
    }

    public final LinearLayout a(LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.b.a(8.0f);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout3.addView(linearLayout, new LinearLayout.LayoutParams(0, this.b.a(91.0f), 1.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, this.b.a(91.0f), 1.0f);
        layoutParams2.leftMargin = this.b.a(8.0f);
        linearLayout3.addView(linearLayout2, layoutParams2);
        return linearLayout3;
    }

    public final LinearLayout a(BitmapDrawable bitmapDrawable, String str, boolean z, final Runnable runnable, boolean z2) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(this.b.a(16.0f), this.b.a(16.0f), this.b.a(16.0f), this.b.a(14.0f));
        this.b.a(linearLayout, 16.0f);
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (z2) {
            this.A = imageView;
            ac.a().getClass();
            this.A.setImageDrawable(we.a(this.a, ac.d(), this.b.a(20.0f)));
        } else if (bitmapDrawable != null) {
            imageView.setImageDrawable(bitmapDrawable);
            if (z) {
                imageView.setColorFilter(this.b.b ? -1 : Color.parseColor("#2A2A2A"), PorterDuff.Mode.SRC_IN);
            }
        }
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f)));
        TextView textView = new TextView(this.a);
        textView.setText(str);
        textView.setTextSize(2, 16.0f);
        (textView).setTypeface(android.graphics.Typeface.create("sans-serif-medium", 1));
        textView.setTextColor(this.b.e());
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.b.a(16.0f);
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                runnable.run();
            }
        });
        return linearLayout;
    }

    public final void a(int i, int i2, Intent intent) {
        if (i == 1002) {
            if (i2 == -1) {
                if (this.A != null) {
                    ac.a().getClass();
                    this.A.setImageDrawable(we.a(this.a, ac.d(), this.b.a(20.0f)));
                }
                Runnable runnable = this.b.c;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            return;
        }
        if (i != 1005 || i2 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data = intent.getData();
        try {
            this.a.getContentResolver().takePersistableUriPermission(data, 1);
        } catch (Throwable th) {
        }
        Intent intent2 = new Intent((Context) this.a, (Class<?>) ei.class);
        intent2.setData(data);
        intent2.setClipData(ClipData.newRawUri("", data));
        intent2.addFlags(1);
        intent2.putExtra("fromSettings", true);
        this.a.startActivity(intent2);
    }

    public final void a(FrameLayout frameLayout) {
        this.u = this.b.a(56.0f) + this.c;
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.l = linearLayout;
        linearLayout.setOrientation(1);
        linearLayout.setClickable(false);
        linearLayout.setFocusable(false);
        linearLayout.setVisibility(8);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return wf.this.a(view, motionEvent);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        frameLayout.addView(linearLayout, layoutParams);
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, this.u));
        TextView textView = new TextView(this.a);
        this.m = textView;
        textView.setText("TikTok You");
        textView.setTextSize(2, 16.0f);
        (textView).setTypeface(android.graphics.Typeface.create("sans-serif", 1));
        textView.setTextColor(this.b.e());
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, this.b.a(36.0f));
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = this.b.a(8.0f) + this.c;
        frameLayout2.addView(textView, layoutParams2);
        linearLayout.addView(frameLayout2);
    }

    public final  boolean a(View view, MotionEvent motionEvent) {
        vf vfVar = this.k;
        return vfVar != null && vfVar.dispatchTouchEvent(motionEvent);
    }

    public final void a(int i) {
        float fMax = Math.max(0.0f, Math.min(1.0f, i / Math.max(1, this.e - this.u)));
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.setAlpha(1.0f - fMax);
            this.j.setVisibility(fMax >= 1.0f ? 4 : 0);
        }
        LinearLayout linearLayout2 = this.l;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(fMax > 0.01f ? 0 : 8);
            this.l.setBackgroundColor((Math.round(255.0f * fMax) << 24) | (this.t & 16777215));
        }
        if (this.m != null) {
            this.m.setAlpha(Math.max(0.0f, (fMax - 0.5f) * 2.0f));
        }
        if (this.r != null) {
            float fA = (1.0f - fMax) * this.b.a(28.0f);
            this.r.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        View view = this.s;
        if (view != null) {
            view.setAlpha(1.0f - fMax);
        }
        if (this.n != null && this.o != null) {
            int iArgb = Color.argb(Math.round((1.0f - fMax) * 51.0f), 255, 255, 255);
            GradientDrawable gradientDrawable = this.p;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(iArgb);
            }
            GradientDrawable gradientDrawable2 = this.q;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(iArgb);
            }
            int iE = this.b.e();
            float fAlpha = Color.alpha(-1);
            float fRed = Color.red(-1);
            float fGreen = Color.green(-1);
            float fBlue = Color.blue(-1);
            int iArgb2 = Color.argb(Math.round(((Color.alpha(iE) - fAlpha) * fMax) + fAlpha), Math.round(((Color.red(iE) - fRed) * fMax) + fRed), Math.round(((Color.green(iE) - fGreen) * fMax) + fGreen), Math.round(((Color.blue(iE) - fBlue) * fMax) + fBlue));
            ImageView imageView = this.n;
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            imageView.setColorFilter(iArgb2, mode);
            this.o.setColorFilter(iArgb2, mode);
        }
        Window window = this.a.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i2 = !this.b.b ? 1808 : 1792;
        if (!this.b.b && fMax >= 0.45f) {
            i2 |= 8192;
        }
        if (i2 == this.v) {
            return;
        }
        this.v = i2;
        window.getDecorView().setSystemUiVisibility(i2);
    }

    public final void a(ImageView imageView) {
        new a7(this.a, this.b, new Runnable() {
            @Override
            public final void run() {
                wf.this.d();
            }
        }, new Runnable() {
            @Override
            public final void run() {
                wf.this.p();
            }
        }, new Runnable() {
            @Override
            public final void run() {
                wf.this.n();
            }
        }).a(imageView);
    }

    public final void a(boolean z) {
        String str;
        String str2;
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.animate().translationY(0.0f).setDuration(180L).start();
        }
        if (z) {
            if (this.w != null) {
                ObjectAnimator objectAnimator = this.x;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                    this.x = null;
                }
                this.w.animate().cancel();
                float rotation = this.w.getRotation();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.w, (Property<View, Float>) View.ROTATION, rotation, 360.0f + rotation);
                objectAnimatorOfFloat.setDuration(800L);
                objectAnimatorOfFloat.setRepeatCount(-1);
                objectAnimatorOfFloat.setRepeatMode(1);
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat.start();
                this.x = objectAnimatorOfFloat;
            }
        } else {
            q();
        }
        TextView textView = this.y;
        if (textView == null) {
            return;
        }
        textView.setText(k7.a((z ? "settings_check_updates_progress" : "settings_check_updates")));
        LinearLayout linearLayout2 = this.z;
        if (linearLayout2 != null) {
            linearLayout2.setEnabled(!z);
            this.z.setAlpha(z ? 0.72f : 1.0f);
        }
    }

    public final void a(float f) {
        if (this.g.get()) {
            return;
        }
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.animate().cancel();
            this.i.setTranslationY(f);
        }
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.animate().cancel();
            float fA = this.b.a(72.0f);
            this.w.setRotation(fA > 0.0f ? (f / fA) * 360.0f : 0.0f);
        }
    }

    public final  void a(cd cdVar) {
        this.g.set(false);
        a(false);
        if (this.a.isFinishing() || this.a.isDestroyed()) {
            return;
        }
        if (cdVar == cd.UP_TO_DATE) {
            Toast.makeText((Context) this.a, (CharSequence) k7.a("check_updates_up_to_date"), 0).show();
        } else if (cdVar == cd.FAILED) {
            Toast.makeText((Context) this.a, (CharSequence) k7.a("check_updates_failed"), 0).show();
        }
    }
}
