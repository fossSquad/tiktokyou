package Z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.windukk.mod.Main;
import Z.ThemeHooks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.IntIterator;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;

public final class x3 {
    public static final x3 a = new x3();

    public static String a(b3 b3Var) {
        String strA;
        String str = b3Var.p;
        String upperCase = null;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null && (strA = a(str)) != null) {
                return strA;
            }
        }
        String str2 = b3Var.q;
        if (str2 != null) {
            if (StringsKt.isBlank(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                upperCase = str2.toUpperCase(Locale.US);
            }
        }
        return upperCase == null ? "" : upperCase;
    }

    public static String c(b3 b3Var) {
        if (b3Var.b()) {
            return l6.a("download_quality_audio_only", "Только звук");
        }
        int i = b3Var.l;
        return i > 0 ? i + "p" : l6.a("download_quality_unknown", "Неизвестно");
    }

    public final boolean b(final Activity activity, s3 s3Var, final c3 c3Var) {
        Throwable th = null;
        Object r7;
        int iA;
        Object obj = null;
        Object r8;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            Function0 function0 = null;
            r3 r3Var = s3Var instanceof r3 ? (r3) s3Var : null;
            List listEmptyList = r3Var != null ? r3Var.a : null;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            boolean z = (activity.getResources().getConfiguration().uiMode & 48) == 32;
            iA = a();
            int i = z ? -14803426 : -657931;
            final int i2 = z ? -13882324 : -1;
            final int i3 = z ? -1 : -16777216;
            int i4 = z ? -10066330 : -4473925;
            final int i5 = z ? 587202559 : 402653184;
            List list = listEmptyList;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final Dialog A = wa.a(activity);
            final LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(1);
            float fA = Main.dp(24.0f);
            try {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i);
                gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
                linearLayout.setBackground(gradientDrawable);
                linearLayout.setPadding(Main.dp(16.0f), Main.dp(12.0f), Main.dp(16.0f), Main.dp(24.0f));
                linearLayout.setClickable(true);
                linearLayout.setClipToOutline(true);
                View view = new View(activity);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Main.dp(48.0f), Main.dp(4.0f));
                layoutParams.gravity = 1;
                view.setLayoutParams(layoutParams);
                float fA2 = Main.dp(50.0f);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(i4);
                gradientDrawable2.setCornerRadius(fA2);
                view.setBackground(gradientDrawable2);
                linearLayout.addView(view);
                final TextView textView = new TextView(activity);
                textView.setText(l6.a("download_quality_title", "Качество загрузки"));
                textView.setGravity(17);
                textView.setTextColor(-8026747);
                textView.setTextSize(2, 14.0f);
                int i6 = 0;
                try {
                    textView.setTypeface(Typeface.create("sans-serif-medium", 0));
                    textView.setIncludeFontPadding(false);
                    try {
                        textView.setMaxLines(1);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, Main.dp(17.0f));
                        layoutParams2.topMargin = Main.dp(24.0f);
                        textView.setLayoutParams(layoutParams2);
                        linearLayout.addView(textView);
                        final LinearLayout linearLayout2 = new LinearLayout(activity);
                        linearLayout2.setOrientation(1);
                        final ScrollView scrollView = new ScrollView(activity);
                        scrollView.setFillViewport(false);
                        scrollView.setVerticalScrollBarEnabled(false);
                        scrollView.setClipToPadding(false);
                        scrollView.addView(linearLayout2, new FrameLayout.LayoutParams(-1, -2));
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams3.topMargin = Main.dp(17.0f);
                        Unit unit = Unit.INSTANCE;
                        linearLayout.addView(scrollView, layoutParams3);
                        TextView textView2 = new TextView(activity);
                        textView2.setText(l6.a("download_quality_cancel", "Отмена"));
                        textView2.setGravity(17);
                        textView2.setTextColor(i3);
                        textView2.setTextSize(2, 16.0f);
                        i6 = 0;
                        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
                        textView2.setIncludeFontPadding(false);
                        textView2.setClickable(true);
                        textView2.setFocusable(true);
                        float fA3 = Main.dp(68.0f);
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i5);
                        try {
                            GradientDrawable gradientDrawable3 = new GradientDrawable();
                            final int i7 = i;
                            try {
                                gradientDrawable3.setColor(0);
                                gradientDrawable3.setCornerRadius(fA3);
                                GradientDrawable gradientDrawable4 = new GradientDrawable();
                                gradientDrawable4.setColor(-1);
                                gradientDrawable4.setCornerRadius(fA3);
                                textView2.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable3, gradientDrawable4));
                                textView2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public final void onClick(View view2) {
                                        x3.a(x3.this, linearLayout, A, view2);
                                    }
                                });
                                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, Main.dp(48.0f));
                                layoutParams4.topMargin = Main.dp(24.0f);
                                linearLayout.addView(textView2, layoutParams4);
                                FrameLayout frameLayout = new FrameLayout(activity);
                                frameLayout.setClickable(true);
                                frameLayout.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public final void onClick(View view2) {
                                        x3.b(x3.this, linearLayout, A, view2);
                                    }
                                });
                                frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 80));
                                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                objectRef.element = a(list);
                                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                                objectRef2.element = CollectionsKt.firstOrNull(list);
                                final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                                final int i8 = -6316129;
                                final int i9 = i4;
                                final int i10 = -8026747;
                                try {
                                    final int iAF = iA;
                                    objectRef3.element = new Function0() {
                                        public final Object invoke() {
                                            return x3.a(textView, linearLayout2, objectRef, x3.this, objectRef2, atomicBoolean, linearLayout, A, c3Var, activity, i2, i3, i8, iAF, i5, i7, i9, i10, scrollView);
                                        }
                                    };
                                    r7 = scrollView;
                                    final Object r7F = r7;
                                    Function0 function1 = new Function0() {
                                        public final Object invoke() {
                                            return x3.a(textView, linearLayout2, activity, x3.this, iAF, i8, (ScrollView) r7F);
                                        }
                                    };
                                    try {
                                        try {
                                            if (s3Var instanceof q3) {
                                                function1.invoke();
                                                r7 = "aes";
                                            } else {
                                                if (!(s3Var instanceof r3)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                Object obj2 = objectRef3.element;
                                                if (obj2 == null) {
                                                    String str2 = "aes";
                                                    str = str2;
                                                } else {
                                                    str = "aes";
                                                    function0 = (Function0) obj2;
                                                }
                                                function0.invoke();
                                                r7 = str;
                                            }
                                            A.setContentView(frameLayout);
                                            iA = 0;
                                            A.setCancelable(false);
                                            A.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                                @Override
                                                public final void onDismiss(DialogInterface dialogInterface) {
                                                    x3.a(atomicBoolean, c3Var, dialogInterface);
                                                }
                                            });
                                            A.setOnKeyListener(new DialogInterface.OnKeyListener() {
                                                @Override
                                                public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                                                    return x3.a(x3.this, linearLayout, A, dialogInterface, i11, keyEvent);
                                                }
                                            });
                                            wa.a((Dialog) A, (ViewGroup) linearLayout, i7, 0.5f);
                                            A.show();
                                            a(activity, (LinearLayout) linearLayout, (Dialog) A);
                                            linearLayout.getViewTreeObserver().addOnPreDrawListener(new w3(linearLayout));
                                            if (s3Var instanceof q3) {
                                                a(activity, (Dialog) A, atomicBoolean, ((q3) s3Var).a, new Function1() {
                                                    public final Object invoke(Object obj3) {
                                                        return x3.a(objectRef, x3.this, objectRef2, objectRef3, (List) obj3);
                                                    }
                                                }, new v3(atomicBoolean, this, linearLayout, A, c3Var));
                                            }
                                            obj = RCompat.m6constructorimpl(Boolean.TRUE);
                                            r8 = r7;
                                        } catch (Throwable th_2) {
                                            th = th_2;
                                            Result.Companion companion2 = Result.Companion;
                                            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                                            r8 = r7;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r7 = r7;
                                        iA = 0;
                                        Result.Companion companion3 = Result.Companion;
                                        obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                                        r8 = r7;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r7 = "aes";
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                iA = 0;
                                r7 = "aes";
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            r7 = "aes";
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r7 = "aes";
                    }
                } catch (Throwable th7) {
                    th = th7;
                    r7 = "aes";
                    iA = i6;
                }
            } catch (Throwable th8) {
                th = th8;
                r7 = "aes";
                iA = 0;
            }
        } catch (Throwable th9) {
            th = th9;
            r7 = "aes";
            iA = 0;
        }
        Throwable th10 = RCompat.m9exceptionOrNullimpl(obj);
        if (th10 != null) {
            h6.a(6, h6.a("Download quality bottom sheet unavailable", new Object[iA]), th10);
        }
        Boolean bool = Boolean.FALSE;
        if (RCompat.m12isFailureimpl(obj)) {
            obj = bool;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static final void a(Activity activity, s3 s3Var, c3 c3Var) {
        if (a.b(activity, s3Var, c3Var)) {
            return;
        }
        c3Var.a();
    }

    public static final Unit a(c3 c3Var, b3 b3Var) {
        c3Var.a(b3Var);
        return Unit.INSTANCE;
    }

    public static final void c(x3 x3Var, LinearLayout linearLayout, Dialog dialog, View view) {
        x3Var.a(linearLayout, dialog, (Function0) null);
    }

    public static final void a(AtomicBoolean atomicBoolean, x3 x3Var, LinearLayout linearLayout, Dialog dialog, final c3 c3Var) {
        if (atomicBoolean.compareAndSet(false, true)) {
            x3Var.a(linearLayout, dialog, new Function0() {
                public final Object invoke() {
                    return x3.a(c3Var);
                }
            });
        }
    }

    public static final Unit a(c3 c3Var) {
        c3Var.a();
        return Unit.INSTANCE;
    }

    public static final void a(Activity activity, LinearLayout linearLayout, x3 x3Var, ScrollView scrollView) {
        int i = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.58f);
        IntIterator it = RangesKt.until(0, linearLayout.getChildCount()).iterator();
        int iCoerceAtLeast = 0;
        while (it.hasNext()) {
            iCoerceAtLeast += RangesKt.coerceAtLeast(linearLayout.getChildAt(it.nextInt()).getLayoutParams().height, 0);
        }
        x3Var.getClass();
        int iMin = Math.min(i, RangesKt.coerceAtLeast(iCoerceAtLeast, Main.dp(64.0f)));
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.height = iMin;
        scrollView.setLayoutParams(layoutParams2);
        scrollView.scrollTo(0, 0);
    }

    public static final void a(LinearLayout linearLayout, Activity activity, x3 x3Var, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, final Function0 function0) {
        if (linearLayout.getChildCount() > 0) {
            linearLayout.addView(new View(activity), new LinearLayout.LayoutParams(-1, Main.dp(4.0f)));
        }
        FrameLayout frameLayoutA = a(activity, str, str2, str3, z, i, i2, i3, i4, i5, z2);
        frameLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                x3.a(function0, view);
            }
        });
        linearLayout.addView(frameLayoutA);
    }

    public static final void a(Function0 function0, View view) {
        function0.invoke();
    }

    public static final void a(AtomicBoolean atomicBoolean, final x3 x3Var, LinearLayout linearLayout, Dialog dialog, final Dialog dialog2, final c3 c3Var, final b3 b3Var, View view) {
        if (atomicBoolean.compareAndSet(false, true)) {
            x3Var.a(linearLayout, dialog, new Function0() {
                public final Object invoke() {
                    return x3.a(x3Var, dialog2, c3Var, b3Var);
                }
            });
        }
    }

    public static final Unit a(x3 x3Var, Dialog dialog, c3 c3Var, b3 b3Var) {
        x3Var.getClass();
        a(dialog);
        c3Var.a(b3Var);
        return Unit.INSTANCE;
    }

    public static final Unit a(final x3 x3Var, LinearLayout linearLayout, Dialog dialog, final LinearLayout linearLayout2, final Dialog dialog2) {
        x3Var.a(linearLayout, dialog, new Function0() {
            public final Object invoke() {
                return x3.a(x3Var, linearLayout2, dialog2);
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit a(TextView textView, LinearLayout linearLayout, Ref.ObjectRef objectRef, final x3 x3Var, Ref.ObjectRef objectRef2, final AtomicBoolean atomicBoolean, final LinearLayout linearLayout2, final Dialog dialog, final c3 c3Var, final Activity activity, final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7, final int i8, ScrollView scrollView) {
        String strDecrypt;
        String str;
        String str2;
        textView.setText(l6.a("download_quality_title", "Качество загрузки"));
        linearLayout.removeAllViews();
        for (final n3 n3Var : (Iterable<n3>) (Iterable) objectRef.element) {
            final b3 b3Var = (b3) CollectionsKt.singleOrNull(n3Var.b);
            if (b3Var != null) {
                x3Var.getClass();
                a(linearLayout, activity, x3Var, i, i2, i3, i4, i5, c(b3Var), a(b3Var), b(b3Var), false, Intrinsics.areEqual(b3Var, objectRef2.element), new Function0() {
                    public final Object invoke() {
                        return x3.a(b3Var, atomicBoolean, x3Var, linearLayout2, dialog, c3Var);
                    }
                });
            } else {
                String str3 = n3Var.a;
                List list = n3Var.b;
                x3Var.getClass();
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str4 = ((b3) it.next()).p;
                    if (str4 != null) {
                        arrayList.add(str4);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    arrayList2.add(a((String) obj));
                }
                String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.distinct(arrayList2), "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                int size2 = n3Var.b.size();
                if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "ru")) {
                    int i10 = size2 % 100;
                    int i11 = size2 % 10;
                    if (11 <= i10 && i10 < 15) {
                        strDecrypt = "download_quality_option_many";
                    } else if (i11 == 1) {
                        strDecrypt = "download_quality_option_one";
                    } else if (2 <= i11 && i11 < 5) {
                        strDecrypt = "download_quality_option_few";
                    } else {
                        strDecrypt = "download_quality_option_many";
                    }
                } else if (size2 == 1) {
                    strDecrypt = "download_quality_option_one";
                } else {
                    strDecrypt = "download_quality_option_many";
                }
                String strDecrypt2 = (size2 == 1 ? "%d вариант" : "%d вариантов");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str5 = String.format(Locale.getDefault(), l6.a(strDecrypt, strDecrypt2), Arrays.copyOf(new Object[]{Integer.valueOf(size2)}, 1));
                a(linearLayout, activity, x3Var, i, i2, i3, i4, i5, str3, strJoinToString$default, str5, true, CollectionsKt.contains(n3Var.b, objectRef2.element), new Function0() {
                    public final Object invoke() {
                        return x3.a(n3Var, x3Var, activity, i6, i7, i8, i, i2, i3, i4, i5, atomicBoolean, dialog, c3Var, linearLayout2);
                    }
                });
            }
        }
        a(activity, linearLayout, x3Var, scrollView);
        return Unit.INSTANCE;
    }

    public static final Unit a(b3 b3Var, AtomicBoolean atomicBoolean, x3 x3Var, LinearLayout linearLayout, Dialog dialog, c3 c3Var) {
        b(b3Var, atomicBoolean, x3Var, linearLayout, dialog, c3Var);
        return Unit.INSTANCE;
    }

    public static final Unit a(n3 n3Var, x3 x3Var, Activity activity, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, AtomicBoolean atomicBoolean, Dialog dialog, c3 c3Var, LinearLayout linearLayout) {
        b(n3Var, x3Var, activity, i, i2, i3, i4, i5, i6, i7, i8, atomicBoolean, dialog, c3Var, linearLayout);
        return Unit.INSTANCE;
    }

    public static final Unit a(TextView textView, LinearLayout linearLayout, Activity activity, x3 x3Var, int i, int i2, ScrollView scrollView) {
        textView.setText(l6.a("download_quality_title", "Качество загрузки"));
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        x3Var.getClass();
        linearLayout2.setMinimumHeight(Main.dp(64.0f));
        ProgressBar progressBar = new ProgressBar(activity);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(i));
        linearLayout2.addView(progressBar, new LinearLayout.LayoutParams(Main.dp(30.0f), Main.dp(30.0f)));
        TextView textView2 = new TextView(activity);
        textView2.setText(l6.a("download_quality_loading", "Загрузка…"));
        textView2.setGravity(17);
        textView2.setTextColor(i2);
        textView2.setTextSize(2, 13.5f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = Main.dp(8.0f);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(textView2, layoutParams);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, Main.dp(64.0f)));
        a(activity, linearLayout, x3Var, scrollView);
        return unit;
    }

    public static final void a(AtomicBoolean atomicBoolean, c3 c3Var, DialogInterface dialogInterface) {
        if (atomicBoolean.compareAndSet(false, true) && c3Var.a.compareAndSet(false, true)) {
            AtomicLong atomicLong = c4.a;
            c4.a(Long.valueOf(c3Var.b.a));
            c4.a(c3Var.b);
        }
    }

    public static final boolean a(x3 x3Var, LinearLayout linearLayout, Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        x3Var.a(linearLayout, dialog, (Function0) null);
        return true;
    }

    public static final Unit a(Ref.ObjectRef objectRef, x3 x3Var, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, List list) {
        Function0 function0;
        x3Var.getClass();
        objectRef.element = a(list);
        objectRef2.element = CollectionsKt.firstOrNull(list);
        Object obj = objectRef3.element;
        if (obj == null) {
            function0 = null;
        } else {
            function0 = (Function0) obj;
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static void a(final Activity activity, final Dialog dialog, final AtomicBoolean atomicBoolean, p3 p3Var, final Function1 function1, v3 v3Var) {
        Throwable th = null;
        v3 v3Var2;
        Object obj = null;
        try {
            Result.Companion companion = Result.Companion;
            v3Var2 = v3Var;
            try {
                final v3 v3Var2F = v3Var2;
                p3Var.a(new o3() {
                    @Override
                    public final void a(List list) {
                        x3.a(activity, atomicBoolean, dialog, v3Var2F, function1, list);
                    }
                });
                obj = RCompat.m6constructorimpl(Unit.INSTANCE);
            } catch (Throwable th_2) {
                th = th_2;
                Result.Companion companion2 = Result.Companion;
                obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
            v3Var2 = v3Var;
        }
        Throwable th3 = RCompat.m9exceptionOrNullimpl(obj);
        if (th3 != null) {
            h6.a(6, h6.a("Download quality loading failed", new Object[0]), th3);
            v3Var2.invoke();
        }
    }

    public static final void a(Activity activity, final AtomicBoolean atomicBoolean, final Dialog dialog, final Function0 function0, final Function1 function1, final List list) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                x3.a(atomicBoolean, dialog, list, function0, function1);
            }
        });
    }

    public static final void a(AtomicBoolean atomicBoolean, Dialog dialog, List list, Function0 function0, Function1 function1) {
        if (atomicBoolean.get() || !dialog.isShowing()) {
            return;
        }
        if (list.isEmpty()) {
            function0.invoke();
        } else {
            function1.invoke(list);
        }
    }

    public static final void b(final b3 b3Var, AtomicBoolean atomicBoolean, x3 x3Var, LinearLayout linearLayout, Dialog dialog, final c3 c3Var) {
        if (atomicBoolean.compareAndSet(false, true)) {
            x3Var.a(linearLayout, dialog, new Function0() {
                public final Object invoke() {
                    return x3.a(c3Var, b3Var);
                }
            });
        }
    }

    public static final void b(n3 n3Var, final x3 x3Var, Activity activity, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, final AtomicBoolean atomicBoolean, final Dialog dialog, final c3 c3Var, final LinearLayout linearLayout) {
        Object obj = null;
        Activity activity2 = activity;
        try {
            Result.Companion companion = Result.Companion;
            Dialog dialogA = wa.a(activity2);
            LinearLayout linearLayout2 = new LinearLayout(activity2);
            linearLayout2.setOrientation(1);
            x3Var.getClass();
            float fA = Main.dp(24.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
            linearLayout2.setBackground(gradientDrawable);
            linearLayout2.setPadding(Main.dp(16.0f), Main.dp(12.0f), Main.dp(16.0f), Main.dp(24.0f));
            linearLayout2.setClickable(true);
            linearLayout2.setClipToOutline(true);
            View view = new View(activity2);
            float fA2 = Main.dp(50.0f);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(i2);
            gradientDrawable2.setCornerRadius(fA2);
            view.setBackground(gradientDrawable2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Main.dp(48.0f), Main.dp(4.0f));
            layoutParams.gravity = 1;
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(view, layoutParams);
            TextView textView = new TextView(activity2);
            textView.setText(l6.a("download_quality_variants_title", "Варианты загрузки"));
            textView.setGravity(17);
            textView.setTextColor(i3);
            textView.setTextSize(2, 14.0f);
            textView.setTypeface(Typeface.create("sans-serif-medium", 0));
            textView.setIncludeFontPadding(false);
            textView.setMaxLines(1);
            int i9 = -1;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, Main.dp(17.0f));
            layoutParams2.topMargin = Main.dp(24.0f);
            linearLayout2.addView(textView, layoutParams2);
            LinearLayout linearLayout3 = new LinearLayout(activity2);
            linearLayout3.setOrientation(1);
            for (final b3 b3Var : (Iterable<b3>) (Iterable) n3Var.b) {
                if (linearLayout3.getChildCount() > 0) {
                    linearLayout3.addView(new View(activity2), new LinearLayout.LayoutParams(i9, Main.dp(4.0f)));
                }
                final LinearLayout linearLayout4 = linearLayout2;
                LinearLayout linearLayout5 = linearLayout3;
                FrameLayout frameLayoutA = a(activity2, c(b3Var), a(b3Var), b(b3Var), false, i4, i5, i6, i7, i8, Intrinsics.areEqual(b3Var, CollectionsKt.firstOrNull(n3Var.b)));
                final Dialog dialog2 = dialogA;
                frameLayoutA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view2) {
                        x3.a(atomicBoolean, x3Var, linearLayout4, dialog2, dialog, c3Var, b3Var, view2);
                    }
                });
                linearLayout5.addView(frameLayoutA);
                dialogA = dialog2;
                linearLayout2 = linearLayout4;
                activity2 = activity2;
                linearLayout3 = linearLayout5;
                i9 = -1;
            }
            Activity activity3 = activity2;
            final LinearLayout linearLayout6 = linearLayout2;
            LinearLayout linearLayout7 = linearLayout3;
            final Dialog dialog3 = dialogA;
            ScrollView scrollView = new ScrollView(activity3);
            scrollView.setFillViewport(false);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setClipToPadding(false);
            scrollView.addView(linearLayout7, new FrameLayout.LayoutParams(-1, -2));
            int i10 = (int) (activity3.getResources().getDisplayMetrics().heightPixels * 0.58f);
            IntIterator it = RangesKt.until(0, linearLayout7.getChildCount()).iterator();
            int iCoerceAtLeast = 0;
            while (it.hasNext()) {
                iCoerceAtLeast += RangesKt.coerceAtLeast(linearLayout7.getChildAt(it.nextInt()).getLayoutParams().height, 0);
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, Math.min(i10, RangesKt.coerceAtLeast(iCoerceAtLeast, Main.dp(64.0f))));
            layoutParams3.topMargin = Main.dp(17.0f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout6.addView(scrollView, layoutParams3);
            final Function0 function0 = new Function0() {
                public final Object invoke() {
                    return x3.a(x3Var, linearLayout6, dialog3, linearLayout, dialog);
                }
            };
            TextView textView2 = new TextView(activity3);
            textView2.setText(l6.a("download_quality_cancel", "Отмена"));
            textView2.setGravity(17);
            textView2.setTextColor(i5);
            textView2.setTextSize(2, 16.0f);
            textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
            textView2.setIncludeFontPadding(false);
            textView2.setClickable(true);
            textView2.setFocusable(true);
            float fA3 = Main.dp(68.0f);
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i8);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(0);
            gradientDrawable3.setCornerRadius(fA3);
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setColor(-1);
            gradientDrawable4.setCornerRadius(fA3);
            textView2.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable3, gradientDrawable4));
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view2) {
                    x3.b(function0, view2);
                }
            });
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, Main.dp(48.0f));
            layoutParams4.topMargin = Main.dp(24.0f);
            linearLayout6.addView(textView2, layoutParams4);
            FrameLayout frameLayout = new FrameLayout(activity3);
            frameLayout.setClickable(true);
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view2) {
                    x3.c(x3Var, linearLayout6, dialog3, view2);
                }
            });
            frameLayout.addView(linearLayout6, new FrameLayout.LayoutParams(-1, -2, 80));
            dialog3.setContentView(frameLayout);
            dialog3.setCancelable(false);
            dialog3.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                    return x3.b(x3Var, linearLayout6, dialog3, dialogInterface, i11, keyEvent);
                }
            });
            wa.a(dialog3, linearLayout6, i, 0.0f);
            dialog3.show();
            a(activity3, linearLayout6, dialog3);
            linearLayout6.getViewTreeObserver().addOnPreDrawListener(new w3(linearLayout6));
            obj = RCompat.m6constructorimpl(unit2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Download quality variants sheet unavailable", new Object[0]), th2);
        }
    }

    public static ArrayList a(List list) {
        String strA;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!((b3) obj).b()) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList2.get(i);
            i++;
            b3 b3Var = (b3) obj2;
            Integer numValueOf = Integer.valueOf(b3Var.l);
            Object arrayList3 = linkedHashMap.get(numValueOf);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList3);
            }
            ((Collection) arrayList3).add(b3Var);
        }
        for (Map.Entry entry : (java.util.Set<Map.Entry>) linkedHashMap.entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            List list2 = (List) entry.getValue();
            if (iIntValue > 0) {
                strA = iIntValue + "p";
            } else {
                strA = l6.a("download_quality_unknown", "Неизвестно");
            }
            arrayList.add(new n3(strA, list2));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (((b3) obj3).b()) {
                arrayList4.add(obj3);
            }
        }
        if (!arrayList4.isEmpty()) {
            arrayList.add(new n3(l6.a("download_quality_audio_only", "Только звук"), arrayList4));
        }
        return arrayList;
    }

    public static final void b(Function0 function0, View view) {
        function0.invoke();
    }

    public static final boolean b(x3 x3Var, LinearLayout linearLayout, Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        x3Var.a(linearLayout, dialog, (Function0) null);
        return true;
    }

    public static String b(b3 b3Var) {
        String strA;
        ArrayList arrayList = new ArrayList();
        long j = b3Var.g;
        if (j > 0) {
            arrayList.add(a(j));
        }
        int i = b3Var.h;
        if (i > 0) {
            if (i >= 1000000) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                strA = String.format(Locale.US, "%.1f Mbps", Arrays.copyOf(new Object[]{Float.valueOf(i / 1000000.0f)}, 1));
            } else {
                strA = new StringBuilder().append(Math.max(1, i / 1000)).append(" Kbps").toString();
            }
            arrayList.add(strA);
        }
        if (b3Var.b()) {
            return CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return strJoinToString$default.length() == 0 ? g4.a(b3Var) : strJoinToString$default;
    }

    public static final void b(x3 x3Var, LinearLayout linearLayout, Dialog dialog, View view) {
        x3Var.a(linearLayout, dialog, (Function0) null);
    }

    public static void a(Activity activity, final LinearLayout linearLayout, final Dialog dialog) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(activity);
        final int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        final float scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 4.0f;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return x3.a(linearLayout, floatRef, floatRef2, booleanRef, objectRef, scaledTouchSlop, scaledMinimumFlingVelocity, dialog, view, motionEvent);
            }
        });
    }

    public static final boolean a(View view, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, int i, float f, Dialog dialog, View view2, MotionEvent motionEvent) {
        float yVelocity;
        switch (motionEvent.getActionMasked()) {
            case 0:
                view.animate().cancel();
                floatRef.element = motionEvent.getRawY();
                floatRef2.element = view.getTranslationY();
                booleanRef.element = false;
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                velocityTrackerObtain.addMovement(motionEvent);
                objectRef.element = velocityTrackerObtain;
                return true;
            case 1:
            case 3:
                VelocityTracker velocityTracker = (VelocityTracker) objectRef.element;
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.addMovement(motionEvent);
                    velocityTracker.computeCurrentVelocity(1000);
                    yVelocity = velocityTracker.getYVelocity();
                    velocityTracker.recycle();
                }
                objectRef.element = null;
                boolean z = booleanRef.element;
                if (z && motionEvent.getActionMasked() == 1) {
                    if (view.getTranslationY() <= view.getHeight() * 0.35f && yVelocity <= f) {
                        view.animate().translationY(0.0f).setDuration(200L).start();
                        return z;
                    }
                    a.a(view, dialog, (Function0) null);
                }
                return z;
            case 2:
                float rawY = motionEvent.getRawY() - floatRef.element;
                if (!booleanRef.element && rawY > i) {
                    booleanRef.element = true;
                }
                if (booleanRef.element) {
                    view.setTranslationY(Math.max(0.0f, floatRef2.element + rawY));
                    VelocityTracker velocityTracker2 = (VelocityTracker) objectRef.element;
                    if (velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public static final void a(x3 x3Var, LinearLayout linearLayout, Dialog dialog, View view) {
        x3Var.a(linearLayout, dialog, (Function0) null);
    }

    public static final Unit a(x3 x3Var, LinearLayout linearLayout, Dialog dialog) {
        x3Var.a(linearLayout, dialog, (Function0) null);
        return Unit.INSTANCE;
    }

    public final void a(View view, final Dialog dialog, final Function0 function0) {
        Object obj = null;
        try {
            Result.Companion companion = Result.Companion;
            view.animate().translationY(view.getHeight()).setDuration(220L).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    x3.a(x3.this, dialog, function0);
                }
            }).start();
            obj = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m9exceptionOrNullimpl(obj) != null) {
            a(dialog);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void a(x3 x3Var, Dialog dialog, Function0 function0) {
        x3Var.getClass();
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

    public final u3 a(Context context, final s3 s3Var, final c3 c3Var) {
        Activity activity;
        List list;
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                if (!(context instanceof Activity)) {
                    activity = (Activity) u2.f.get();
                    if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                        break;
                    }
                    activity = null;
                    break;
                }
                activity = (Activity) context;
                break;
            }
        }
        r3 r3Var = s3Var instanceof r3 ? (r3) s3Var : null;
        Integer numValueOf = (r3Var == null || (list = r3Var.a) == null) ? null : Integer.valueOf(list.size());
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && (numValueOf == null || numValueOf.intValue() != 0)) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                if (b(activity, s3Var, c3Var)) {
                    return u3.a;
                }
                c3Var.a();
                return u3.c;
            }
            final Activity activityF = activity;
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    x3.a(activityF, s3Var, c3Var);
                }
            });
            return u3.b;
        }
        h6.a(6, h6.a("Quality sheet unavailable: activity=%s choices=%d", new Object[]{activity != null ? activity.getClass().getName() : "null", Integer.valueOf(numValueOf != null ? numValueOf.intValue() : -1)}), (Throwable) null);
        c3Var.a();
        return u3.c;
    }

    public static int a() {
        Object obj = null;
        int color;
        try {
            Result.Companion companion = Result.Companion;
            if (!ta.a().f()) {
                color = Color.parseColor("#FE2B54");
            } else {
                color = ThemeHooks.a();
            }
            obj = RCompat.m6constructorimpl(Integer.valueOf(color));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Integer numValueOf = Integer.valueOf(Color.parseColor("#FE2B54"));
        if (RCompat.m12isFailureimpl(obj)) {
            obj = numValueOf;
        }
        return ((Number) obj).intValue();
    }

    public static FrameLayout a(Activity activity, String str, String str2, String str3, boolean z, int i, int i2, int i3, int i4, int i5, boolean z2) {
        int iA;
        int iArgb = z2 ? Color.argb(41, Color.red(i4), Color.green(i4), Color.blue(i4)) : i;
        int i6 = z2 ? i4 : i2;
        int iArgb2 = z2 ? Color.argb(153, Color.red(i4), Color.green(i4), Color.blue(i4)) : i3;
        int iArgb3 = z2 ? Color.argb(56, Color.red(i4), Color.green(i4), Color.blue(i4)) : i5;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        float fA = Main.dp(z2 ? 12.0f : 16.0f);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iArgb3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iArgb);
        gradientDrawable.setCornerRadius(fA);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(fA);
        frameLayout.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable, gradientDrawable2));
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, Main.dp(StringsKt.isBlank("") ? 64.0f : 82.0f)));
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        if (z2 && z) {
            iA = Main.dp(124.0f);
        } else if (z2) {
            iA = Main.dp(103.0f);
        } else {
            iA = z ? Main.dp(52.0f) : Main.dp(16.0f);
        }
        linearLayout.setPadding(Main.dp(16.0f), 0, iA, 0);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(activity);
        textView.setText(str);
        textView.setTextColor(i6);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(1);
        linearLayout2.addView(textView);
        if (!StringsKt.isBlank(str2)) {
            TextView textView2 = new TextView(activity);
            textView2.setText(str2);
            textView2.setTextColor(iArgb2);
            textView2.setTextSize(2, 14.0f);
            textView2.setIncludeFontPadding(false);
            textView2.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart(Main.dp(8.0f));
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(textView2, layoutParams);
        }
        linearLayout.addView(linearLayout2);
        if (!StringsKt.isBlank(str3)) {
            TextView textView3 = new TextView(activity);
            textView3.setText(str3);
            textView3.setTextColor(iArgb2);
            textView3.setTextSize(2, 14.0f);
            textView3.setIncludeFontPadding(false);
            textView3.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = Main.dp(5.0f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(textView3, layoutParams2);
        }
        if (!StringsKt.isBlank("")) {
            TextView textView4 = new TextView(activity);
            textView4.setText("");
            textView4.setTextColor(iArgb2);
            textView4.setTextSize(2, 11.0f);
            textView4.setIncludeFontPadding(false);
            textView4.setMaxLines(1);
            textView4.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = Main.dp(3.0f);
            Unit unit3 = Unit.INSTANCE;
            linearLayout.addView(textView4, layoutParams3);
        }
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 16));
        if (z2) {
            TextView textView5 = new TextView(activity);
            textView5.setText(l6.a("download_quality_best", "Лучшее"));
            textView5.setGravity(17);
            textView5.setTextColor((Color.blue(i4) * 114) + ((Color.green(i4) * 587) + (Color.red(i4) * 299)) > 186000 ? -16777216 : -1);
            textView5.setTextSize(2, 12.0f);
            textView5.setTypeface(Typeface.create("sans-serif-medium", 0));
            textView5.setIncludeFontPadding(false);
            textView5.setMinWidth(Main.dp(71.0f));
            textView5.setPadding(Main.dp(12.0f), 0, Main.dp(12.0f), 0);
            float fA2 = Main.dp(60.0f);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(i4);
            gradientDrawable3.setCornerRadius(fA2);
            textView5.setBackground(gradientDrawable3);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, Main.dp(29.0f), 8388629);
            layoutParams4.setMarginEnd(z ? Main.dp(44.0f) : Main.dp(16.0f));
            Unit unit4 = Unit.INSTANCE;
            frameLayout.addView(textView5, layoutParams4);
        }
        if (z) {
            ImageView imageView = new ImageView(activity);
            imageView.setImageDrawable(new t3());
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f), 8388629);
            layoutParams5.setMarginEnd(Main.dp(16.0f));
            Unit unit5 = Unit.INSTANCE;
            frameLayout.addView(imageView, layoutParams5);
        }
        return frameLayout;
    }

    public static String a(long j) {
        if (j >= 1048576) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1048576.0f)}, 1));
            return str;
        }
        if (j >= 1024) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1024.0f)}, 1));
            return str2;
        }
        return j + " B";
    }

    public static java.lang.String a(java.lang.String r5) {

        throw new UnsupportedOperationException("Method not decompiled: Z.x3.a(java.lang.String):java.lang.String");
    }
}
