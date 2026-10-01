package Z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.windukk.mod.Main;
import Z.ThemeHooks;
import com.windukk.stable.ResourceOverlay;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;

public final class qe {
    public static final qe a;
    public static final Handler b;
    public static final AtomicBoolean c;

    static {
        a = new qe();
        b = new Handler(Looper.getMainLooper());
        c = new AtomicBoolean(false);
    }

    public static void a(final int i) {
        b.postDelayed(new Runnable() {
            @Override
            public final void run() {
                qe.b(i);
            }
        }, i == 0 ? 1500L : 1000L);
    }

    public static final Unit b() {
        pb.a.getClass();
        pb.a(false, (nb) null);
        return Unit.INSTANCE;
    }

    public final void a(final Activity activity) {
        Throwable th = null;
        int i;
        Object obj = null;
        View view;
        View view2;
        ta.a.getClass();
        if (!ta.d().B && c.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                boolean z = (activity.getResources().getConfiguration().uiMode & 48) == 32;
                int iA = a();
                int i2 = z ? -14803426 : -657931;
                int i3 = z ? -13882324 : -1;
                int i4 = z ? -1 : -16777216;
                int i5 = z ? -10066330 : -4473925;
                int i6 = z ? 587202559 : 402653184;
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                booleanRef2.element = true;
                final Ref.IntRef intRef = new Ref.IntRef();
                i = 6;
                try {
                    intRef.element = 4;
                    final Dialog dialogA = wa.a(activity);
                    final LinearLayout linearLayout = new LinearLayout(activity);
                    linearLayout.setOrientation(1);
                    float fA = Main.dp(24.0f);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(i2);
                    gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
                    linearLayout.setBackground(gradientDrawable);
                    linearLayout.setPadding(Main.dp(16.0f), Main.dp(12.0f), Main.dp(16.0f), Main.dp(16.0f));
                    linearLayout.setClickable(true);
                    linearLayout.setClipToOutline(true);
                    View view3 = new View(activity);
                    float fA2 = Main.dp(50.0f);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setColor(i5);
                    gradientDrawable2.setCornerRadius(fA2);
                    view3.setBackground(gradientDrawable2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Main.dp(48.0f), Main.dp(4.0f));
                    layoutParams.gravity = 1;
                    Unit unit = Unit.INSTANCE;
                    linearLayout.addView(view3, layoutParams);
                    LinearLayout linearLayout2 = new LinearLayout(activity);
                    linearLayout2.setOrientation(1);
                    linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    ImageView imageView = new ImageView(activity);
                    imageView.setImageDrawable(a((Context) activity, "ic_startup_logo"));
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setAdjustViewBounds(true);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Main.dp(86.0f), Main.dp(86.0f));
                    layoutParams2.gravity = 1;
                    layoutParams2.topMargin = Main.dp(24.0f);
                    linearLayout2.addView(imageView, layoutParams2);
                    LinearLayout linearLayout3 = new LinearLayout(activity);
                    linearLayout3.setOrientation(1);
                    linearLayout3.setGravity(1);
                    TextView textView = new TextView(activity);
                    textView.setText(l6.a("startup_title", "TikTok You"));
                    textView.setGravity(17);
                    textView.setTextColor(i4);
                    textView.setTextSize(2, 16.0f);
                    textView.setTypeface(Typeface.create("sans-serif-medium", 0));
                    textView.setIncludeFontPadding(false);
                    linearLayout3.addView(textView);
                    TextView textView2 = new TextView(activity);
                    textView2.setText(l6.a("startup_subtitle", "Прежде чем продолжить"));
                    textView2.setGravity(17);
                    textView2.setTextColor(-6316129);
                    textView2.setTextSize(2, 14.0f);
                    textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
                    textView2.setIncludeFontPadding(false);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams3.topMargin = Main.dp(16.0f);
                    linearLayout3.addView(textView2, layoutParams3);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams4.topMargin = Main.dp(24.0f);
                    linearLayout2.addView(linearLayout3, layoutParams4);
                    LinearLayout linearLayout4 = new LinearLayout(activity);
                    linearLayout4.setOrientation(1);
                    linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    LinearLayout linearLayout5 = new LinearLayout(activity);
                    linearLayout5.setOrientation(1);
                    linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    int i7 = i2;
                    int i8 = i4;
                    linearLayout5.addView(a(activity, "ic_startup_faq", l6.a("startup_faq", "Ознакомьтесь с нашим FAQ"), i3, i8, i6, 12.0f, new Function0() {
                        public final Object invoke() {
                            return qe.a(qe.this, activity);
                        }
                    }), new LinearLayout.LayoutParams(-1, -2));
                    LinearLayout linearLayoutA = a(activity, "ic_startup_legal", l6.a("privacy_information", "Правовая информация"), i3, i8, i6, 16.0f, new Function0() {
                        public final Object invoke() {
                            return qe.b(qe.this, activity);
                        }
                    });
                    int i9 = i3;
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams5.topMargin = Main.dp(4.0f);
                    linearLayout5.addView(linearLayoutA, layoutParams5);
                    linearLayout4.addView(linearLayout5, new LinearLayout.LayoutParams(-1, -2));
                    LinearLayout linearLayout6 = new LinearLayout(activity);
                    linearLayout6.setOrientation(1);
                    linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    final int i10 = -5723992;
                    objectRef.element = a(activity, "ic_startup_download", l6.a("startup_auto_updates", "Автоматические обновления"), l6.a("startup_auto_updates_desc", "Получать и устанавливать их"), i9, i8, i6, new Function0() {
                        public final Object invoke() {
                            return qe.a(booleanRef, qe.this, activity, objectRef, i10, objectRef2, booleanRef2);
                        }
                    });
                    objectRef2.element = a(activity, "ic_startup_stats", l6.a("startup_statistics", "Делиться анонимной статистикой"), l6.a("startup_statistics_desc", "Помогите улучшить приложение"), i9, i8, i6, new Function0() {
                        public final Object invoke() {
                            return qe.a(booleanRef2, qe.this, activity, objectRef, booleanRef, i10, objectRef2);
                        }
                    });
                    Object obj2 = objectRef.element;
                    if (obj2 == null) {
                        view = null;
                    } else {
                        view = (View) obj2;
                    }
                    linearLayout6.addView(view, new LinearLayout.LayoutParams(-1, -2));
                    Object obj3 = objectRef2.element;
                    if (obj3 == null) {
                        view2 = null;
                    } else {
                        view2 = (View) obj3;
                    }
                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams6.topMargin = Main.dp(4.0f);
                    linearLayout6.addView(view2, layoutParams6);
                    LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams7.topMargin = Main.dp(12.0f);
                    linearLayout4.addView(linearLayout6, layoutParams7);
                    b(booleanRef, this, activity, objectRef, -5723992, objectRef2, booleanRef2);
                    LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams8.topMargin = Main.dp(24.0f);
                    linearLayout2.addView(linearLayout4, layoutParams8);
                    TextView textView3 = new TextView(activity);
                    textView3.setGravity(17);
                    textView3.setTextColor(-1);
                    textView3.setTextSize(2, 16.0f);
                    textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
                    textView3.setIncludeFontPadding(false);
                    textView3.setClickable(false);
                    textView3.setEnabled(false);
                    textView3.setFocusable(false);
                    textView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public final void onClick(View view4) {
                            qe.a(intRef, qe.this, booleanRef, booleanRef2, linearLayout, dialogA, view4);
                        }
                    });
                    a(intRef, textView3, this, iA);
                    LinearLayout linearLayout7 = new LinearLayout(activity);
                    linearLayout7.setOrientation(1);
                    linearLayout7.addView(textView3, new LinearLayout.LayoutParams(-1, Main.dp(48.0f)));
                    TextView textView4 = new TextView(activity);
                    textView4.setText(l6.a("startup_close", "Закрыть приложение"));
                    textView4.setGravity(17);
                    textView4.setTextColor(i8);
                    textView4.setTextSize(2, 16.0f);
                    textView4.setTypeface(Typeface.create("sans-serif-medium", 0));
                    textView4.setIncludeFontPadding(false);
                    textView4.setClickable(true);
                    textView4.setFocusable(true);
                    float fA3 = Main.dp(68.0f);
                    ColorStateList colorStateListValueOf = ColorStateList.valueOf(i6);
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setColor(0);
                    gradientDrawable3.setCornerRadius(fA3);
                    GradientDrawable gradientDrawable4 = new GradientDrawable();
                    gradientDrawable4.setColor(-1);
                    gradientDrawable4.setCornerRadius(fA3);
                    textView4.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable3, gradientDrawable4));
                    textView4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public final void onClick(View view4) {
                            qe.a(qe.this, activity, view4);
                        }
                    });
                    LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, Main.dp(48.0f));
                    layoutParams9.topMargin = Main.dp(12.0f);
                    linearLayout7.addView(textView4, layoutParams9);
                    LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams10.topMargin = Main.dp(24.0f);
                    linearLayout2.addView(linearLayout7, layoutParams10);
                    ScrollView scrollView = new ScrollView(activity);
                    scrollView.setFillViewport(false);
                    scrollView.setVerticalScrollBarEnabled(false);
                    scrollView.setOverScrollMode(2);
                    scrollView.setClipToPadding(false);
                    scrollView.addView(linearLayout2, new FrameLayout.LayoutParams(-1, -2));
                    linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, -2));
                    FrameLayout frameLayout = new FrameLayout(activity);
                    frameLayout.setClickable(true);
                    frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 80));
                    oe oeVar = new oe(dialogA, intRef, textView3, this, iA);
                    final Runnable[] runnableArr = {oeVar};
                    dialogA.setContentView(frameLayout);
                    dialogA.setCancelable(false);
                    dialogA.setCanceledOnTouchOutside(false);
                    dialogA.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        @Override
                        public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                            return qe.a(dialogInterface, i11, keyEvent);
                        }
                    });
                    dialogA.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public final void onDismiss(DialogInterface dialogInterface) {
                            qe.a(runnableArr, dialogInterface);
                        }
                    });
                    wa.a(dialogA, linearLayout, i7, 0.5f);
                    dialogA.show();
                    linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ne(linearLayout, activity, linearLayout2, scrollView));
                    linearLayout.getViewTreeObserver().addOnPreDrawListener(new pe(linearLayout));
                    b.postDelayed(oeVar, 1000L);
                    h6.a(4, h6.a("Shown", new Object[0]), (Throwable) null);
                    obj = RCompat.m6constructorimpl(Boolean.TRUE);
                } catch (Throwable th_2) {
                    th = th_2;
                    Result.Companion companion2 = Result.Companion;
                    obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                th = th2;
                i = 6;
            }
            Throwable th3 = RCompat.m9exceptionOrNullimpl(obj);
            if (th3 != null) {
                c.set(false);
                h6.a(i, h6.a("Show failed", new Object[0]), th3);
            }
            Boolean bool = Boolean.FALSE;
            if (RCompat.m12isFailureimpl(obj)) {
                obj = bool;
            }
            ((Boolean) obj).getClass();
        }
    }

    public static final void b(int i) {
        ta.a.getClass();
        if (ta.d().B) {
            return;
        }
        Activity activity = (Activity) u2.f.get();
        qe qeVar = a;
        qeVar.getClass();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            qeVar.a(activity);
        } else if (i < 20) {
            a(i + 1);
        }
    }

    public static final Unit b(qe qeVar, Activity activity) {
        String strDecrypt = "https://tiktokyou.ru/legal.html";
        qeVar.getClass();
        a(activity, strDecrypt);
        return Unit.INSTANCE;
    }

    public static final void b(Ref.BooleanRef booleanRef, qe qeVar, Activity activity, Ref.ObjectRef objectRef, int i, Ref.ObjectRef objectRef2, Ref.BooleanRef booleanRef2) {
        View view;
        Object obj = objectRef.element;
        View view2 = null;
        if (obj == null) {
            view = null;
        } else {
            view = (View) obj;
        }
        boolean z = booleanRef.element;
        qeVar.getClass();
        a(activity, view, z, i);
        Object obj2 = objectRef2.element;
        if (obj2 == null) {
        } else {
            view2 = (View) obj2;
        }
        a(activity, view2, booleanRef2.element, i);
    }

    public static final void b(Function0 function0, View view) {
        function0.invoke();
    }

    public static final Unit a(qe qeVar, Activity activity) {
        String strDecrypt = "https://tiktokyou.ru/knowledge.html";
        qeVar.getClass();
        a(activity, strDecrypt);
        return Unit.INSTANCE;
    }

    public static final Unit a(Ref.BooleanRef booleanRef, qe qeVar, Activity activity, Ref.ObjectRef objectRef, int i, Ref.ObjectRef objectRef2, Ref.BooleanRef booleanRef2) {
        booleanRef.element = !booleanRef.element;
        b(booleanRef, qeVar, activity, objectRef, i, objectRef2, booleanRef2);
        return Unit.INSTANCE;
    }

    public static final Unit a(Ref.BooleanRef booleanRef, qe qeVar, Activity activity, Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef2, int i, Ref.ObjectRef objectRef2) {
        booleanRef.element = !booleanRef.element;
        b(booleanRef2, qeVar, activity, objectRef, i, objectRef2, booleanRef);
        return Unit.INSTANCE;
    }

    public static final void a(Ref.IntRef intRef, TextView textView, qe qeVar, int i) {
        if (intRef.element > 0) {
            textView.setEnabled(false);
            textView.setClickable(false);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            CharSequence charSequence = String.format(Locale.getDefault(), l6.a("startup_accept_countdown", "Принять через %d..."), Arrays.copyOf(new Object[]{Integer.valueOf(intRef.element)}, 1));
            textView.setText(charSequence);
            qeVar.getClass();
            int iArgb = Color.argb(128, Color.red(i), Color.green(i), Color.blue(i));
            float fA = Main.dp(68.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArgb);
            gradientDrawable.setCornerRadius(fA);
            textView.setBackground(gradientDrawable);
            return;
        }
        textView.setEnabled(true);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setText(l6.a("startup_accept", "Принимаю"));
        qeVar.getClass();
        float fA2 = Main.dp(68.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i);
        gradientDrawable2.setCornerRadius(fA2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(-1);
        gradientDrawable3.setCornerRadius(fA2);
        textView.setBackground(new RippleDrawable(ColorStateList.valueOf(872415231), gradientDrawable2, gradientDrawable3));
    }

    public static final void a(Ref.IntRef intRef, qe qeVar, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, LinearLayout linearLayout, Dialog dialog, View view) {
        if (intRef.element > 0) {
            return;
        }
        boolean z = booleanRef.element;
        boolean z2 = booleanRef2.element;
        qeVar.getClass();
        ta.a.getClass();
        ta.d().f(z);
        ta.d().n(z2);
        ta.d().a();
        qeVar.a(linearLayout, dialog, new Function0() {
            public final Object invoke() {
                return qe.b();
            }
        });
    }

    public static final void a(qe qeVar, Activity activity, View view) {
        qeVar.getClass();
        try {
            Result.Companion companion = Result.Companion;
            activity.finishAffinity();
            RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Process.killProcess(Process.myPid());
    }

    public static final boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            return keyEvent.getAction() == 0 || keyEvent.getAction() == 1;
        }
        return false;
    }

    public static final void a(Runnable[] runnableArr, DialogInterface dialogInterface) {
        Runnable runnable = runnableArr[0];
        if (runnable != null) {
            b.removeCallbacks(runnable);
        }
        c.set(false);
    }

    public static void a(Activity activity, String str) {
        Object obj = null;
        try {
            Result.Companion companion = Result.Companion;
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            obj = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Open url failed", new Object[0]), th2);
        }
    }

    public static LinearLayout a(Activity activity, String str, String str2, int i, int i2, int i3, float f, final Function0 function0) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a.getClass();
        linearLayout.setPadding(Main.dp(16.0f), Main.dp(16.0f), Main.dp(16.0f), Main.dp(16.0f));
        float fA = Main.dp(16.0f);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(fA);
        linearLayout.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable, gradientDrawable2));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                qe.a(function0, view);
            }
        });
        ImageView imageView = new ImageView(activity);
        imageView.setImageDrawable(a((Context) activity, str));
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        imageView.setScaleType(scaleType);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        TextView textView = new TextView(activity);
        textView.setText(str2);
        textView.setTextColor(i2);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(Main.dp(f));
        layoutParams.setMarginEnd(Main.dp(12.0f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        ImageView imageView2 = new ImageView(activity);
        imageView2.setImageDrawable(a((Context) activity, "ic_startup_chevron"));
        imageView2.setScaleType(scaleType);
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        return linearLayout;
    }

    public static final void a(Function0 function0, View view) {
        function0.invoke();
    }

    public static LinearLayout a(Activity activity, String str, String str2, String str3, int i, int i2, int i3, final Function0 function0) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a.getClass();
        linearLayout.setPadding(Main.dp(16.0f), Main.dp(16.0f), Main.dp(16.0f), Main.dp(16.0f));
        float fA = Main.dp(16.0f);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(fA);
        linearLayout.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable, gradientDrawable2));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                qe.b(function0, view);
            }
        });
        ImageView imageView = new ImageView(activity);
        imageView.setImageDrawable(a((Context) activity, str));
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        imageView.setScaleType(scaleType);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(activity);
        textView.setText(str2);
        textView.setTextColor(i2);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(2);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(activity);
        textView2.setText(str3);
        textView2.setTextColor(-6316129);
        textView2.setTextSize(2, 14.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setIncludeFontPadding(false);
        textView2.setMaxLines(2);
        textView2.setEllipsize(truncateAt);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = Main.dp(4.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(textView2, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart(Main.dp(16.0f));
        layoutParams2.setMarginEnd(Main.dp(12.0f));
        linearLayout.addView(linearLayout2, layoutParams2);
        ImageView imageView2 = new ImageView(activity);
        imageView2.setTag("startup_check");
        imageView2.setScaleType(scaleType);
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        return linearLayout;
    }

    public static void a(Activity activity, View view, boolean z, int i) {
        ImageView imageView = (ImageView) view.findViewWithTag("startup_check");
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(a((Context) activity, "ic_startup_check"));
            imageView.setImageTintList(null);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(0);
        a.getClass();
        gradientDrawable.setStroke(Main.dp(1.5f), i);
        gradientDrawable.setSize(Main.dp(20.0f), Main.dp(20.0f));
        imageView.setImageDrawable(gradientDrawable);
        imageView.setImageTintList(null);
    }

    public final void a(LinearLayout linearLayout, final Dialog dialog, final Function0 function0) {
        Object obj = null;
        try {
            Result.Companion companion = Result.Companion;
            linearLayout.animate().translationY(linearLayout.getHeight()).setDuration(220L).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    qe.a(qe.this, dialog, function0);
                }
            }).start();
            obj = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m9exceptionOrNullimpl(obj) != null) {
            a.getClass();
            a(dialog);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void a(qe qeVar, Dialog dialog, Function0 function0) {
        qeVar.getClass();
        a(dialog);
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static void a(Dialog dialog) {
        try {
            Result.Companion companion = Result.Companion;
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static int a() {
        Object obj = null;
        int color;
        try {
            Result.Companion companion = Result.Companion;
            if (!ta.a().f()) {
                color = Color.parseColor("#FD2C56");
            } else {
                color = ThemeHooks.a();
            }
            obj = RCompat.m6constructorimpl(Integer.valueOf(color));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Integer numValueOf = Integer.valueOf(Color.parseColor("#FD2C56"));
        if (RCompat.m12isFailureimpl(obj)) {
            obj = numValueOf;
        }
        return ((Number) obj).intValue();
    }

    public static Drawable a(Context context, String str) {
        Object obj = null;
        BitmapDrawable bitmapDrawable;
        try {
            Result.Companion companion = Result.Companion;
            InputStream inputStreamOpen = ResourceOverlay.open(context, "mod_icons/" + str + ".png");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (bitmapDecodeStream == null) {
                    bitmapDrawable = null;
                } else {
                    bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                }
                CloseableKt.closeFinally(inputStreamOpen, (Throwable) null);
                obj = RCompat.m6constructorimpl(bitmapDrawable);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th3));
        }
        return (Drawable) (RCompat.m12isFailureimpl(obj) ? null : obj);
    }
}
