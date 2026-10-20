package Z;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.windukk.mod.Main;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.IntConsumer;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;

public abstract class h0 {
    public static final d2 a = new d2(2097152);
    public static final ExecutorService b = Executors.newFixedThreadPool(2, new ThreadFactory() {
        @Override
        public final Thread newThread(Runnable runnable) {
            return h0.a(runnable);
        }
    });

    public static final Unit a(Set set, e0 e0Var, Runnable runnable, boolean z) {
        if (z) {
            set.remove(e0Var.a);
        } else {
            set.add(e0Var.a);
        }
        ac.a.getClass();
        ac.a(set);
        runnable.run();
        return Unit.INSTANCE;
    }

    public static void b(Activity activity, List list, final Runnable runnable) {
        fc fcVarA = new fc(activity).b((CharSequence) k7.a("auto_streak_recipients_title")).a((CharSequence) k7.a("auto_streak_recipients_desc"));
        ac.a.getClass();
        final Set mutableSet = CollectionsKt.toMutableSet(ac.b());
        final ArrayList arrayList = new ArrayList();
        fcVarA.a().addView(fcVarA.a(new String[]{k7.a("auto_streak_recipients_mode_all"), k7.a("auto_streak_recipients_mode_selected")}, !ac.c() ? 1 : 0, new IntConsumer() {
            @Override
            public final void accept(int i) {
                h0.a(runnable, arrayList, i);
            }
        }));
        LinearLayout linearLayoutA = fcVarA.a(4);
        if (list.isEmpty()) {
            CharSequence charSequenceA = k7.a("auto_streak_recipients_empty");
            TextView textViewA = fcVarA.a(14.0f, false, fcVarA.i);
            textViewA.setLineSpacing(Main.dp(2.0f), 1.0f);
            textViewA.setText(charSequenceA);
            textViewA.setGravity(17);
            textViewA.setPadding(Main.dp(8.0f), Main.dp(16.0f), Main.dp(8.0f), Main.dp(16.0f));
            linearLayoutA.addView(textViewA);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final e0 e0Var = (e0) it.next();
                LinearLayout linearLayoutA2 = a(fcVarA, e0Var, !mutableSet.contains(e0Var.a), new Function1() {
                    public final Object invoke(Object obj) {
                        return h0.a(mutableSet, e0Var, runnable, ((Boolean) obj).booleanValue());
                    }
                });
                linearLayoutA.addView(linearLayoutA2);
                arrayList.add(linearLayoutA2);
            }
        }
        ac.a.getClass();
        a(arrayList, ac.c());
        fcVarA.a().addView(fcVarA.a(linearLayoutA, 0.55f));
        fcVarA.b(k7.a("filter_save"), (Runnable) null);
        fcVarA.x = new Runnable() {
            @Override
            public final void run() {
                h0.a();
            }
        };
        fcVarA.g();
    }

    public static void a(final Activity activity, final e0 e0Var, final ImageView imageView) {
        final String str = e0Var.c;
        if (str == null) {
            return;
        }
        Bitmap bitmap = (Bitmap) a.get(str);
        if (bitmap != null) {
            if (bitmap.isRecycled()) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            imageView.setBackground(null);
            return;
        }
        b.execute(new Runnable() {
            @Override
            public final void run() {
                h0.a(str, activity, e0Var, imageView);
            }
        });
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "ttmod-recipient-avatar");
        thread.setDaemon(true);
        return thread;
    }

    public static final void a(final i0 i0Var, final Runnable runnable) {
        g0 g0Var = g0.a;
        Function0 function0 = new Function0() {
            public final Object invoke() {
                return h0.a((Activity) i0Var, runnable);
            }
        };
        g0Var.getClass();
        g0.b(function0);
    }

    public static final Unit a(final Activity activity, final Runnable runnable) {
        final List listA = g0.a();
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                h0.a(activity, listA, runnable);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void a(Activity activity, List list, Runnable runnable) {
        Object obj;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            b(activity, list, runnable);
            obj = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Failed to show recipients sheet", new Object[0]), th2);
        }
    }

    public static final void a(Runnable runnable, List list, int i) {
        boolean z = i == 0;
        ac.a.getClass();
        if (ac.c() != z) {
            ac.b(z);
            a(list, z);
            runnable.run();
        }
    }

    public static final void a() {
        Object obj;
        b0.a.getClass();
        ac.a.getClass();
        ac.e().a("");
        try {
            Result.Companion companion = Result.Companion;
            obj = ResultCompat.constructor(Main.getApplicationContext());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        if (ResultCompat.isFailure(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context == null) {
            return;
        }
        b0.a(context, "recipients", 1000L);
    }

    public static LinearLayout a(final fc fcVar, e0 e0Var, boolean z, final Function1 function1) {
        CharSequence charSequenceA;
        Activity activity = fcVar.a;
        final LinearLayout linearLayoutE = fcVar.e();
        ImageView imageView = new ImageView(activity);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int i = fcVar.d ? -12961220 : -1710619;
        float fA = Main.dp(12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        imageView.setBackground(gradientDrawable);
        linearLayoutE.addView(imageView, new LinearLayout.LayoutParams(Main.dp(24.0f), Main.dp(24.0f)));
        String str = e0Var.b;
        if (str == null || (charSequenceA = v1.a(e0Var.a, str)) == null) {
            charSequenceA = e0Var.a();
        }
        TextView textViewA = fcVar.a(14.0f, true, fcVar.h);
        textViewA.setText(charSequenceA);
        textViewA.setMaxLines(1);
        textViewA.setEllipsize(TextUtils.TruncateAt.END);
        linearLayoutE.addView(textViewA, fc.h());
        if (e0Var.d > 0) {
            LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.addView(fcVar.a(fcVar.k, "ic_fire"), new LinearLayout.LayoutParams(Main.dp(16.0f), Main.dp(16.0f)));
            TextView textViewA2 = fcVar.a(12.0f, false, fcVar.k);
            textViewA2.setText(String.valueOf(e0Var.d));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart(Main.dp(4.0f));
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(textViewA2, layoutParams);
            linearLayoutE.addView(linearLayout);
        }
        final ImageView imageViewA = fcVar.a(z);
        imageViewA.setContentDescription(e0Var.a());
        linearLayoutE.addView(imageViewA);
        fcVar.a(linearLayoutE, new Runnable() {
            @Override
            public final void run() {
                h0.a(linearLayoutE, imageViewA, fcVar, function1);
            }
        });
        a(activity, e0Var, imageView);
        return linearLayoutE;
    }

    public static final void a(LinearLayout linearLayout, ImageView imageView, fc fcVar, Function1 function1) {
        if (linearLayout.isEnabled()) {
            boolean z = !imageView.isSelected();
            fcVar.a(imageView, z);
            function1.invoke(Boolean.valueOf(z));
        }
    }

    public static final void a(String str, final Activity activity, e0 e0Var, final ImageView imageView) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Bitmap bitmapA = a(str);
            obj = ResultCompat.constructor(bitmapA != null ? a(bitmapA) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Avatar decode failed for uid=%s", new Object[]{e0Var.a}), th2);
        }
        final Bitmap bitmap = (Bitmap) (ResultCompat.isFailure(obj) ? null : obj);
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

    public static final void a(Activity activity, Bitmap bitmap, ImageView imageView) {
        if (activity.isFinishing() || activity.isDestroyed() || bitmap.isRecycled()) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setBackground(null);
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
            while (i2 / i > 64 && i3 / i > 64) {
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

    public static Bitmap a(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        if (iMin <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        float f = iMin / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (iMin - bitmap.getWidth()) / 2.0f, (iMin - bitmap.getHeight()) / 2.0f, paint);
        return bitmapCreateBitmap;
    }

    public static final void a(List list, boolean z) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            view.setAlpha(z ? 0.45f : 1.0f);
            boolean z2 = !z;
            view.setEnabled(z2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    viewGroup.getChildAt(i).setEnabled(z2);
                }
            }
        }
    }
}
