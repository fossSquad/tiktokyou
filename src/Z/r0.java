package Z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class r0 {
    public static final d2 a = new d2(2097152);
    public static final ExecutorService b = Executors.newFixedThreadPool(2, new ThreadFactory() {
        @Override
        public final Thread newThread(Runnable runnable) {
            return r0.a(runnable);
        }
    });

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "ttmod-streak-sticker-image");
        thread.setDaemon(true);
        return thread;
    }

    public static final void b(final i0 i0Var, Runnable runnable) {
        Object obj;
        if (i0Var.isFinishing() || i0Var.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Pair pairC = c(i0Var, runnable);
            final Dialog dialog = (Dialog) pairC.component1();
            final o0 o0Var = (o0) pairC.component2();
            u0 u0Var = u0.a;
            Function1 function1 = new Function1() {
                public final Object invoke(Object obj2) {
                    return r0.a(i0Var, dialog, o0Var, (List) obj2);
                }
            };
            u0Var.getClass();
            u0.a(function1);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Failed to show sticker sheet", new Object[0]), th2);
        }
    }

    public static Pair c(i0 i0Var, Runnable runnable) {
        fc fcVarA = new fc(i0Var).b((CharSequence) k7.a("auto_streak_sticker_title")).a((CharSequence) k7.a("auto_streak_sticker_desc"));
        LinearLayout linearLayout = new LinearLayout(i0Var);
        linearLayout.setOrientation(1);
        o0 o0Var = new o0(i0Var, linearLayout, new ArrayList(), fcVarA.g, fcVarA.e, fcVarA.i, runnable);
        fcVarA.a().addView(fcVarA.a(linearLayout, 0.6f));
        fcVarA.b(k7.a("filter_save"), (Runnable) null);
        u0 u0Var = u0.a;
        List listListOf = u0.g;
        if (listListOf == null) {
            u0Var.getClass();
            listListOf = CollectionsKt.listOf(new m0("spark_v1", null, null, "https://p16-tiktokcdn-com.akamaized.net/obj/im-resource-tiktok/fire.webp", true));
        } else {
            u0Var.getClass();
        }
        u0Var.getClass();
        o0Var.a(listListOf, !(u0.g != null));
        fcVarA.g();
        return TuplesKt.to(fcVarA.b, o0Var);
    }

    public static final Unit a(final Activity activity, final Dialog dialog, final o0 o0Var, final List list) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                r0.b(activity, dialog, o0Var, list);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void a(final i0 i0Var, final Runnable runnable) {
        u0 u0Var = u0.a;
        Function1 function1 = new Function1() {
            public final Object invoke(Object obj) {
                return r0.a(i0Var, runnable, (List) obj);
            }
        };
        u0Var.getClass();
        u0.a(function1);
    }

    public static final Unit a(final Activity activity, final Runnable runnable, List list) {
        String string;
        String string2;
        String strDecrypt;
        Object next;
        String str;
        String str2;
        SharedPreferences sharedPreferences;
        String string3;
        Object next2;
        u0.a.getClass();
        ac acVar = ac.a;
        acVar.getClass();
        SharedPreferences sharedPreferences2 = ac.b;
        String str3 = "";
        if (sharedPreferences2 == null || (string = sharedPreferences2.getString("auto_streak_sticker", "")) == null) {
            string = "";
        }
        if (!StringsKt.isBlank(string) && !Intrinsics.areEqual(string, "spark_v1")) {
            acVar.getClass();
            SharedPreferences sharedPreferences3 = ac.b;
            if (sharedPreferences3 == null || (string2 = sharedPreferences3.getString("auto_streak_sticker_id", "")) == null) {
                string2 = "";
            }
            acVar.getClass();
            SharedPreferences sharedPreferences4 = ac.b;
            if (sharedPreferences4 == null || (strDecrypt = sharedPreferences4.getString("auto_streak_sticker", "")) == null) {
                strDecrypt = "";
            }
            if (StringsKt.isBlank(strDecrypt)) {
                strDecrypt = "spark_v1";
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                m0 m0Var = (m0) next;
                if (!m0Var.e && !StringsKt.isBlank(string2) && Intrinsics.areEqual(m0Var.b, string2)) {
                    break;
                }
            }
            m0 m0Var2 = (m0) next;
            if (m0Var2 == null) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    m0 m0Var3 = (m0) next2;
                    if (!m0Var3.e && Intrinsics.areEqual(m0Var3.a, strDecrypt)) {
                        break;
                    }
                }
                m0Var2 = (m0) next2;
                if (m0Var2 != null) {
                    str = m0Var2.d;
                    if (str != null) {
                        str2 = StringsKt.isBlank(str) ? null : str;
                        if (str2 != null) {
                            ac.a.getClass();
                            sharedPreferences = ac.b;
                            if (sharedPreferences != null && (string3 = sharedPreferences.getString("auto_streak_sticker_url", "")) != null) {
                                str3 = string3;
                            }
                            if (!Intrinsics.areEqual(str2, str3)) {
                                ac.c(str2);
                            }
                        }
                    }
                }
            } else {
                str = m0Var2.d;
                if (str != null) {
                    if (StringsKt.isBlank(str)) {
                    }
                    if (str2 != null) {
                        ac.a.getClass();
                        sharedPreferences = ac.b;
                        if (sharedPreferences != null) {
                            str3 = string3;
                        }
                        if (!Intrinsics.areEqual(str2, str3)) {
                            ac.c(str2);
                        }
                    }
                }
            }
        }
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                r0.a(activity, runnable);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void b(Activity activity, Dialog dialog, o0 o0Var, List list) {
        if (activity.isFinishing() || activity.isDestroyed() || !dialog.isShowing()) {
            return;
        }
        o0Var.getClass();
        if (o0Var.j || !Intrinsics.areEqual(o0Var.h, list)) {
            o0Var.a(list, false);
        }
    }

    public static final void b(String str, final Activity activity, final ImageView imageView) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(a(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Sticker image decode failed", new Object[0]), th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        final Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            return;
        }
        a.put(str, bitmap);
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                r0.a(activity, bitmap, imageView);
            }
        });
    }

    public static final void a(Activity activity, Runnable runnable) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        runnable.run();
    }

    public static final LinearLayout a(i0 i0Var, int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(i0Var);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        float f = 8;
        linearLayout.setPadding(0, a((Context) i0Var, 18), 0, (int) (i0Var.getResources().getDisplayMetrics().density * f));
        ProgressBar progressBar = new ProgressBar(i0Var);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(i));
        float f2 = 28;
        linearLayout.addView(progressBar, new LinearLayout.LayoutParams((int) (i0Var.getResources().getDisplayMetrics().density * f2), (int) (f2 * i0Var.getResources().getDisplayMetrics().density)));
        TextView textView = new TextView(i0Var);
        textView.setText(k7.a("auto_streak_sticker_loading"));
        textView.setGravity(17);
        textView.setTextSize(13.5f);
        textView.setTextColor(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (f * i0Var.getResources().getDisplayMetrics().density);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        return linearLayout;
    }

    public static final void a(i0 i0Var, LinearLayout linearLayout, List list, String str, int i, int i2, Function2 function2) {
        int i3;
        String strA;
        int i4;
        int i5 = 4;
        int iA = a((Context) i0Var, 4);
        int i6 = 0;
        int i7 = 0;
        while (i7 < list.size()) {
            LinearLayout linearLayout2 = new LinearLayout(i0Var);
            linearLayout2.setOrientation(i6);
            int i8 = 16;
            linearLayout2.setGravity(16);
            int i9 = i6;
            while (i9 < i5) {
                m0 m0Var = (m0) CollectionsKt.getOrNull(list, i7 + i9);
                if (m0Var == null) {
                    linearLayout2.addView(new Space(i0Var), new LinearLayout.LayoutParams(i6, i6, 1.0f));
                    i3 = i5;
                    i4 = i6;
                } else {
                    q0 q0Var = new q0(i0Var);
                    float f = (int) (i8 * i0Var.getResources().getDisplayMetrics().density);
                    q0Var.setClipToOutline(true);
                    q0Var.setOutlineProvider(new p0(f));
                    ImageView imageView = new ImageView(i0Var);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    q0Var.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
                    a(m0Var.d, (Activity) i0Var, imageView);
                    ImageView imageView2 = new ImageView(i0Var);
                    String strDecrypt = "ic_check_active";
                    int i10 = sf.h;
                    Bitmap bitmapA = hi.a((Context) i0Var, strDecrypt);
                    if (bitmapA == null) {
                        i3 = i5;
                    } else {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(i0Var.getResources(), bitmapA);
                        bitmapDrawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setShape(1);
                        gradientDrawable.setColor(-1);
                        i3 = 4;
                        imageView2.setBackground(new InsetDrawable((Drawable) gradientDrawable, (int) (4 * i0Var.getResources().getDisplayMetrics().density)));
                        imageView2.setImageDrawable(bitmapDrawable);
                    }
                    if (m0Var.e) {
                        strA = k7.a("auto_streak_sticker_default");
                    } else {
                        strA = k7.a("auto_streak_sticker");
                    }
                    q0Var.setContentDescription(strA);
                    float f2 = 20;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (i0Var.getResources().getDisplayMetrics().density * f2), (int) (f2 * i0Var.getResources().getDisplayMetrics().density));
                    layoutParams.gravity = 8388661;
                    float f3 = 6;
                    layoutParams.topMargin = (int) (i0Var.getResources().getDisplayMetrics().density * f3);
                    layoutParams.setMarginEnd((int) (f3 * i0Var.getResources().getDisplayMetrics().density));
                    Unit unit = Unit.INSTANCE;
                    q0Var.addView(imageView2, layoutParams);
                    q0Var.setTag(imageView2);
                    a(q0Var, i, i2, Intrinsics.areEqual(m0Var.a, str));
                    function2.invoke(q0Var, m0Var);
                    i4 = 0;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                    if (i9 > 0) {
                        layoutParams2.setMarginStart(iA);
                    }
                    linearLayout2.addView(q0Var, layoutParams2);
                }
                i9++;
                i5 = i3;
                i6 = i4;
                i8 = 16;
            }
            int i11 = i5;
            int i12 = i6;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            if (i7 > 0) {
                layoutParams3.topMargin = iA;
            }
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(linearLayout2, layoutParams3);
            i7 += 4;
            i5 = i11;
            i6 = i12;
        }
    }

    public static void a(View view, int i, int i2, boolean z) {
        GradientDrawable gradientDrawable;
        Context context = view.getContext();
        float fA = a(context, 16);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i);
        gradientDrawable2.setCornerRadius(fA);
        view.setBackground(gradientDrawable2);
        if (z) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            gradientDrawable.setCornerRadius(fA);
            Context context2 = view.getContext();
            gradientDrawable.setStroke(a(context2, 2), i2);
        } else {
            gradientDrawable = null;
        }
        view.setForeground(gradientDrawable);
        Object tag = view.getTag();
        ImageView imageView = tag instanceof ImageView ? (ImageView) tag : null;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public static void a(final String str, final Activity activity, final ImageView imageView) {
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        Bitmap bitmap = (Bitmap) a.get(str);
        if (bitmap != null) {
            if (bitmap.isRecycled()) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            return;
        }
        b.execute(new Runnable() {
            @Override
            public final void run() {
                r0.b(str, activity, imageView);
            }
        });
    }

    public static final void a(Activity activity, Bitmap bitmap, ImageView imageView) {
        if (activity.isFinishing() || activity.isDestroyed() || bitmap.isRecycled()) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    public static Bitmap a(String str) throws IOException {
        byte[] byteArray;
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setInstanceFollowRedirects(true);
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.min(524288, 16384));
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 < 0) {
                        byteArray = byteArrayOutputStream.toByteArray();
                        break;
                    }
                    i += i2;
                    if (i > 524288) {
                        byteArray = null;
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                CloseableKt.closeFinally(inputStream, (Throwable) null);
                if (byteArray == null) {
                    httpURLConnection.disconnect();
                    return null;
                }
                Bitmap bitmapA = a(byteArray);
                httpURLConnection.disconnect();
                return bitmapA;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    public static Bitmap a(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth > 0 && options.outHeight > 0) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            while (i2 / i > 128 && i3 / i > 128) {
                i *= 2;
            }
            options2.inSampleSize = i;
            options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
            if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getWidth() > 0 && bitmapDecodeByteArray.getHeight() > 0) {
                return bitmapDecodeByteArray;
            }
        }
        return null;
    }

    public static int a(Context context, int i) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }
}
