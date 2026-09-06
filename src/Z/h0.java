package Z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import com.windukk.mod.hooks.ThemeHooks;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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

public final class h0 {
    public static final t1 a = new t1(2097152);
    public static final ExecutorService b = Executors.newFixedThreadPool(2, new ThreadFactory() {
        @Override
        public final Thread newThread(Runnable runnable) {
            return h0.a(runnable);
        }
    });

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "ttmod-streak-sticker-image");
        thread.setDaemon(true);
        return thread;
    }

    public static final void b(Activity activity, Dialog dialog, e0 e0Var, List list) {
        if (activity.isFinishing() || activity.isDestroyed() || !dialog.isShowing()) {
            return;
        }
        e0Var.a(list, false);
    }

    public static final void a(final le leVar, Runnable runnable) {
        Object obj;
        if (leVar.isFinishing() || leVar.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Pair pairB = b(leVar, runnable);
            final Dialog dialog = (Dialog) pairB.component1();
            final e0 e0Var = (e0) pairB.component2();
            k0 k0Var = k0.a;
            Function1 function1 = new Function1() {
                public final Object invoke(Object obj2) {
                    return h0.a(leVar, dialog, e0Var, (List) obj2);
                }
            };
            k0Var.getClass();
            k0.a(function1);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Failed to show sticker sheet", new Object[0]), th2);
        }
    }

    public static Pair b(le leVar, Runnable runnable) {
        int color;
        boolean z = (leVar.getResources().getConfiguration().uiMode & 48) == 32;
        int i = z ? -14935010 : -1;
        int color2 = z ? -1 : Color.parseColor("#161823");
        int i2 = z ? -6579293 : -9210757;
        int i3 = z ? -13882322 : -855307;
        if (ta.a.f()) {
            color = ThemeHooks.a();
        } else {
            color = Color.parseColor("#FE2B54");
        }
        LinearLayout linearLayout = new LinearLayout(leVar);
        linearLayout.setOrientation(1);
        float f = 20;
        linearLayout.setPadding((int) (leVar.getResources().getDisplayMetrics().density * f), (int) (10 * leVar.getResources().getDisplayMetrics().density), (int) (leVar.getResources().getDisplayMetrics().density * f), (int) (22 * leVar.getResources().getDisplayMetrics().density));
        float f2 = (int) (f * leVar.getResources().getDisplayMetrics().density);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout.setBackground(gradientDrawable);
        View view = new View(leVar);
        int i4 = z ? -12961220 : -2434337;
        float f3 = 2;
        float f4 = (int) (leVar.getResources().getDisplayMetrics().density * f3);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i4);
        gradientDrawable2.setCornerRadius(f4);
        view.setBackground(gradientDrawable2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (38 * leVar.getResources().getDisplayMetrics().density), (int) (4 * leVar.getResources().getDisplayMetrics().density));
        layoutParams.gravity = 1;
        float f5 = 18;
        layoutParams.bottomMargin = (int) (leVar.getResources().getDisplayMetrics().density * f5);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(leVar);
        textView.setText(l6.a("auto_streak_sticker_title"));
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setTextColor(color2);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(leVar);
        textView2.setText(l6.a("auto_streak_sticker_desc"));
        textView2.setGravity(17);
        textView2.setTextSize(13.5f);
        textView2.setTextColor(i2);
        textView2.setLineSpacing((int) (f3 * leVar.getResources().getDisplayMetrics().density), 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = (int) (6 * leVar.getResources().getDisplayMetrics().density);
        linearLayout.addView(textView2, layoutParams2);
        final Dialog dialogA = wa.a((Activity) leVar);
        LinearLayout linearLayout2 = new LinearLayout(leVar);
        linearLayout2.setOrientation(1);
        e0 e0Var = new e0(leVar, linearLayout2, new ArrayList(), i3, color, i2, runnable);
        ScrollView scrollView = new ScrollView(leVar);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(linearLayout2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        layoutParams3.topMargin = (int) (14 * leVar.getResources().getDisplayMetrics().density);
        linearLayout.addView(scrollView, layoutParams3);
        TextView textView3 = new TextView(leVar);
        textView3.setText(l6.a("filter_save"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(15.0f);
        textView3.setTypeface(Typeface.create("sans-serif-medium", 1));
        float f6 = (int) (26 * leVar.getResources().getDisplayMetrics().density);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(color);
        gradientDrawable3.setCornerRadius(f6);
        textView3.setBackground(gradientDrawable3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                h0.b(dialogA, view2);
            }
        });
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) (52 * leVar.getResources().getDisplayMetrics().density));
        layoutParams4.topMargin = (int) (f5 * leVar.getResources().getDisplayMetrics().density);
        linearLayout.addView(textView3, layoutParams4);
        dialogA.setContentView(wa.a((Activity) leVar, (ViewGroup) linearLayout, Math.min((int) (leVar.getResources().getDisplayMetrics().heightPixels * 0.82f), (int) (680 * leVar.getResources().getDisplayMetrics().density)), new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                h0.a(dialogA, view2);
            }
        }));
        dialogA.setCancelable(true);
        wa.a(dialogA, linearLayout, i, 0.55f);
        k0.a.getClass();
        e0Var.a(CollectionsKt.listOf(new d0("spark_v1", null, null, "https://p16-tiktokcdn-com.akamaized.net/obj/im-resource-tiktok/fire.webp", true)), true);
        dialogA.show();
        return TuplesKt.to(dialogA, e0Var);
    }

    public static final Unit a(final Activity activity, final Dialog dialog, final e0 e0Var, final List list) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                h0.b(activity, dialog, e0Var, list);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void a(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final LinearLayout a(le leVar, int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(leVar);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        float f = 8;
        linearLayout.setPadding(0, a((Context) leVar, 18), 0, (int) (leVar.getResources().getDisplayMetrics().density * f));
        ProgressBar progressBar = new ProgressBar(leVar);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(i));
        float f2 = 28;
        linearLayout.addView(progressBar, new LinearLayout.LayoutParams((int) (leVar.getResources().getDisplayMetrics().density * f2), (int) (f2 * leVar.getResources().getDisplayMetrics().density)));
        TextView textView = new TextView(leVar);
        textView.setText(l6.a("auto_streak_sticker_loading"));
        textView.setGravity(17);
        textView.setTextSize(13.5f);
        textView.setTextColor(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (f * leVar.getResources().getDisplayMetrics().density);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        return linearLayout;
    }

    public static final void a(le leVar, LinearLayout linearLayout, List list, String str, int i, int i2, Function2 function2) {
        String strA;
        int i3;
        int i4 = 8;
        int iA = a((Context) leVar, 8);
        int i5 = 0;
        int i6 = 0;
        while (i6 < list.size()) {
            LinearLayout linearLayout2 = new LinearLayout(leVar);
            linearLayout2.setOrientation(i5);
            linearLayout2.setGravity(16);
            int i7 = i5;
            while (i7 < 4) {
                d0 d0Var = (d0) CollectionsKt.getOrNull(list, i6 + i7);
                if (d0Var == null) {
                    linearLayout2.addView(new Space(leVar), new LinearLayout.LayoutParams(i5, i5, 1.0f));
                    i3 = i5;
                } else {
                    f0 f0Var = new f0(leVar);
                    a(f0Var, i, i2, Intrinsics.areEqual(d0Var.a, str));
                    float f = (int) (14 * leVar.getResources().getDisplayMetrics().density);
                    ImageView imageView = new ImageView(leVar);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setClipToOutline(true);
                    imageView.setOutlineProvider(new g0(f));
                    int i8 = (int) (i4 * leVar.getResources().getDisplayMetrics().density);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(i8, i8, i8, i8);
                    Unit unit = Unit.INSTANCE;
                    f0Var.addView(imageView, layoutParams);
                    a(d0Var.d, (Activity) leVar, imageView);
                    ImageView imageView2 = new ImageView(leVar);
                    Bitmap bitmapA = le.a((Context) leVar, "ic_check_active");
                    if (bitmapA != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(leVar.getResources(), bitmapA);
                        bitmapDrawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
                        imageView2.setImageDrawable(bitmapDrawable);
                    }
                    imageView2.setVisibility(Intrinsics.areEqual(d0Var.a, str) ? 0 : 8);
                    if (d0Var.e) {
                        strA = l6.a("auto_streak_sticker_default");
                    } else {
                        strA = l6.a("auto_streak_sticker");
                    }
                    f0Var.setContentDescription(strA);
                    float f2 = 16;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (leVar.getResources().getDisplayMetrics().density * f2), (int) (f2 * leVar.getResources().getDisplayMetrics().density));
                    layoutParams2.gravity = 8388661;
                    float f3 = 6;
                    layoutParams2.topMargin = (int) (leVar.getResources().getDisplayMetrics().density * f3);
                    layoutParams2.setMarginEnd((int) (f3 * leVar.getResources().getDisplayMetrics().density));
                    f0Var.addView(imageView2, layoutParams2);
                    f0Var.setTag(imageView2);
                    function2.invoke(f0Var, d0Var);
                    i3 = 0;
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                    if (i7 > 0) {
                        layoutParams3.setMarginStart(iA);
                    }
                    linearLayout2.addView(f0Var, layoutParams3);
                }
                i7++;
                i5 = i3;
                i4 = 8;
            }
            int i9 = i5;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            if (i6 > 0) {
                layoutParams4.topMargin = iA;
            }
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(linearLayout2, layoutParams4);
            i6 += 4;
            i5 = i9;
            i4 = 8;
        }
    }

    public static void a(View view, int i, int i2, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        Context context = view.getContext();
        gradientDrawable.setCornerRadius(a(context, 16));
        if (z) {
            Context context2 = view.getContext();
            gradientDrawable.setStroke(a(context2, 2), i2);
        }
        view.setBackground(gradientDrawable);
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
                h0.b(str, activity, imageView);
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

    public static final void b(Dialog dialog, View view) {
        dialog.dismiss();
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
            h6.a(6, h6.a("Sticker image decode failed", new Object[0]), th2);
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
                h0.a(activity, bitmap, imageView);
            }
        });
    }
}
