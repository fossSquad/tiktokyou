package Z;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.windukk.mod.Main;
import com.windukk.mod.hooks.ThemeHooks;
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
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;

public abstract class z {
    public static final t1 a = new t1(2097152);
    public static final ExecutorService b = Executors.newFixedThreadPool(2, new ThreadFactory() {
        @Override
        public final Thread newThread(Runnable runnable) {
            return z.a(runnable);
        }
    });

    public static final Unit a(Set set, w wVar, Runnable runnable, boolean z) {
        if (z) {
            set.remove(wVar.a);
        } else {
            set.add(wVar.a);
        }
        ta.a.getClass();
        ta.a(set);
        runnable.run();
        return Unit.INSTANCE;
    }

    public static void b(Activity activity, List list, final Runnable runnable) {
        LinearLayout linearLayout;
        String str;
        int i;
        final ArrayList arrayList;
        ViewGroup viewGroup;
        boolean z = (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int i2 = z ? -14935010 : -1;
        String str2 = "aes";
        int color = z ? -1 : Color.parseColor("#161823");
        int i3 = z ? -6579293 : -9210757;
        int iA = ta.a.f() ? ThemeHooks.a() : Color.parseColor("#FE2B54");
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(activity, z ? R.style.Theme.DeviceDefault : R.style.Theme.DeviceDefault.Light);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        float f = 20;
        linearLayout2.setPadding((int) (activity.getResources().getDisplayMetrics().density * f), (int) (10 * activity.getResources().getDisplayMetrics().density), (int) (activity.getResources().getDisplayMetrics().density * f), (int) (22 * activity.getResources().getDisplayMetrics().density));
        float f2 = (int) (activity.getResources().getDisplayMetrics().density * f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout2.setBackground(gradientDrawable);
        View view = new View(activity);
        int i4 = z ? -12961220 : -2434337;
        float f3 = 2;
        float f4 = (int) (activity.getResources().getDisplayMetrics().density * f3);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i4);
        gradientDrawable2.setCornerRadius(f4);
        view.setBackground(gradientDrawable2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (38 * activity.getResources().getDisplayMetrics().density), (int) (4 * activity.getResources().getDisplayMetrics().density));
        layoutParams.gravity = 1;
        float f5 = 18;
        layoutParams.bottomMargin = (int) (activity.getResources().getDisplayMetrics().density * f5);
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(view, layoutParams);
        TextView textView = new TextView(activity);
        textView.setText(l6.a("auto_streak_recipients_title"));
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setTextColor(color);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText(l6.a("auto_streak_recipients_desc"));
        textView2.setGravity(17);
        textView2.setTextSize(13.5f);
        textView2.setTextColor(i3);
        textView2.setLineSpacing((int) (f3 * activity.getResources().getDisplayMetrics().density), 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = (int) (6 * activity.getResources().getDisplayMetrics().density);
        linearLayout2.addView(textView2, layoutParams2);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        final Set mutableSet = CollectionsKt.toMutableSet(ta.b());
        ArrayList arrayList2 = new ArrayList();
        String strA = l6.a("auto_streak_recipients_all_toggle");
        SharedPreferences sharedPreferences = ta.b;
        CheckBox checkBoxA = a(contextThemeWrapper, strA, sharedPreferences != null ? sharedPreferences.getBoolean("auto_streak_recipients_all", true) : true, color, z, iA, false);
        ArrayList arrayList3 = arrayList2;
        linearLayout3.addView(checkBoxA, new LinearLayout.LayoutParams(-1, -2));
        if (list.isEmpty()) {
            TextView textView3 = new TextView(activity);
            textView3.setText(l6.a("auto_streak_recipients_empty"));
            textView3.setTextSize(14.0f);
            textView3.setTextColor(i3);
            textView3.setGravity(17);
            float f6 = 8;
            textView3.setPadding((int) (activity.getResources().getDisplayMetrics().density * f6), (int) (f * activity.getResources().getDisplayMetrics().density), (int) (f6 * activity.getResources().getDisplayMetrics().density), (int) (12 * activity.getResources().getDisplayMetrics().density));
            linearLayout3.addView(textView3);
            linearLayout = linearLayout3;
            str = "aes";
            i = iA;
            arrayList = arrayList3;
            viewGroup = linearLayout2;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final w wVar = (w) it.next();
                boolean z2 = !mutableSet.contains(wVar.a);
                Function1 function1 = new Function1() {
                    public final Object invoke(Object obj) {
                        return z.a(mutableSet, wVar, runnable, ((Boolean) obj).booleanValue());
                    }
                };
                Set set = mutableSet;
                int i5 = iA;
                Iterator it2 = it;
                int i6 = color;
                ArrayList arrayList4 = arrayList3;
                String str3 = str2;
                boolean z3 = z;
                LinearLayout linearLayout4 = linearLayout3;
                ContextThemeWrapper contextThemeWrapper2 = contextThemeWrapper;
                LinearLayout linearLayout5 = linearLayout2;
                LinearLayout linearLayoutA = a(activity, contextThemeWrapper2, wVar, z2, i6, z3, i5, function1);
                ta.a.getClass();
                SharedPreferences sharedPreferences2 = ta.b;
                boolean z4 = sharedPreferences2 != null ? sharedPreferences2.getBoolean("auto_streak_recipients_all", true) : true;
                boolean z5 = !z4;
                linearLayoutA.setEnabled(z5);
                linearLayoutA.setAlpha(!z4 ? 1.0f : 0.45f);
                linearLayoutA.setEnabled(z5);
                int i7 = 0;
                for (int childCount = linearLayoutA.getChildCount(); i7 < childCount; childCount = childCount) {
                    linearLayoutA.getChildAt(i7).setEnabled(z5);
                    i7++;
                }
                linearLayout4.addView(linearLayoutA);
                arrayList4.add(linearLayoutA);
                linearLayout2 = linearLayout5;
                str2 = str3;
                linearLayout3 = linearLayout4;
                mutableSet = set;
                contextThemeWrapper = contextThemeWrapper2;
                color = i6;
                z = z3;
                iA = i5;
                arrayList3 = arrayList4;
                it = it2;
            }
            linearLayout = linearLayout3;
            str = str2;
            i = iA;
            arrayList = arrayList3;
            viewGroup = linearLayout2;
        }
        checkBoxA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                z.a(arrayList, runnable, compoundButton, z6);
            }
        });
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        layoutParams3.topMargin = (int) (14 * activity.getResources().getDisplayMetrics().density);
        Unit unit2 = Unit.INSTANCE;
        viewGroup.addView(scrollView, layoutParams3);
        final Dialog dialogA = wa.a(activity);
        TextView textView4 = new TextView(activity);
        textView4.setText(l6.a("filter_save"));
        textView4.setGravity(17);
        textView4.setTextColor(-1);
        textView4.setTextSize(15.0f);
        textView4.setTypeface(Typeface.create("sans-serif-medium", 1));
        float f7 = (int) (26 * activity.getResources().getDisplayMetrics().density);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(i);
        gradientDrawable3.setCornerRadius(f7);
        textView4.setBackground(gradientDrawable3);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                z.a(dialogA, view2);
            }
        });
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) (52 * activity.getResources().getDisplayMetrics().density));
        layoutParams4.topMargin = (int) (f5 * activity.getResources().getDisplayMetrics().density);
        viewGroup.addView(textView4, layoutParams4);
        dialogA.setContentView(wa.a(activity, viewGroup, Math.min((int) (activity.getResources().getDisplayMetrics().heightPixels * 0.82f), (int) (680 * activity.getResources().getDisplayMetrics().density)), new View.OnClickListener() {
            @Override
            public final void onClick(View view2) {
                z.b(dialogA, view2);
            }
        }));
        dialogA.setCancelable(true);
        dialogA.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public final void onDismiss(DialogInterface dialogInterface) {
                z.a(dialogInterface);
            }
        });
        wa.a(dialogA, viewGroup, i2, 0.55f);
        dialogA.show();
    }

    public static void a(final Activity activity, final w wVar, final ImageView imageView) {
        final String str = wVar.c;
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
                z.a(str, activity, wVar, imageView);
            }
        });
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "ttmod-recipient-avatar");
        thread.setDaemon(true);
        return thread;
    }

    public static final void a(final le leVar, final Runnable runnable) {
        y yVar = y.a;
        Function0 function0 = new Function0() {
            public final Object invoke() {
                return z.a(leVar, runnable);
            }
        };
        yVar.getClass();
        y.b(function0);
    }

    public static final Unit a(final Activity activity, final Runnable runnable) {
        final List listA = y.a();
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                z.a(activity, listA, runnable);
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
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Failed to show recipients sheet", new Object[0]), th2);
        }
    }

    public static final void a(List list, Runnable runnable, CompoundButton compoundButton, boolean z) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutBoolean;
        ta.a.getClass();
        SharedPreferences sharedPreferences = ta.b;
        if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorPutBoolean = editorEdit.putBoolean("auto_streak_recipients_all", z)) != null) {
            editorPutBoolean.apply();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            boolean z2 = !z;
            view.setEnabled(z2);
            view.setAlpha(z ? 0.45f : 1.0f);
            view.setEnabled(z2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    viewGroup.getChildAt(i).setEnabled(z2);
                }
            }
        }
        runnable.run();
    }

    public static final void a(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void a(DialogInterface dialogInterface) {
        Object obj;
        t.a.getClass();
        ta.a.getClass();
        ta.d().a("");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Main.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context == null) {
            return;
        }
        t.a(context, "recipients", 1000L);
    }

    public static LinearLayout a(Activity activity, ContextThemeWrapper contextThemeWrapper, w wVar, boolean z, int i, boolean z2, int i2, final Function1 function1) {
        final LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(a(activity, 52));
        linearLayout.setPadding(a(activity, 4), 0, a(activity, 4), 0);
        final CheckBox checkBoxA = a(contextThemeWrapper, "", z, i, z2, i2, true);
        checkBoxA.setContentDescription(wVar.a());
        checkBoxA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                z.a(function1, compoundButton, z3);
            }
        });
        linearLayout.addView(checkBoxA, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(activity);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        float fA = a(activity, 14);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-12961220);
        gradientDrawable.setCornerRadius(fA);
        imageView.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(activity, 28), a(activity, 28));
        layoutParams.setMarginStart(a(activity, 8));
        layoutParams.setMarginEnd(a(activity, 10));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(activity);
        textView.setText(wVar.a());
        textView.setTextSize(15.0f);
        textView.setTextColor(i);
        textView.setGravity(16);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                z.a(linearLayout, checkBoxA, view);
            }
        });
        a(activity, wVar, imageView);
        return linearLayout;
    }

    public static final void a(Function1 function1, CompoundButton compoundButton, boolean z) {
        function1.invoke(Boolean.valueOf(z));
    }

    public static final void a(LinearLayout linearLayout, CheckBox checkBox, View view) {
        if (linearLayout.isEnabled()) {
            checkBox.toggle();
        }
    }

    public static CheckBox a(ContextThemeWrapper contextThemeWrapper, String str, boolean z, int i, boolean z2, int i2, boolean z3) {
        CheckBox checkBox = new CheckBox(contextThemeWrapper);
        checkBox.setText(str);
        checkBox.setTextSize(15.0f);
        checkBox.setTextColor(i);
        checkBox.setGravity(16);
        checkBox.setSaveEnabled(false);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        int iA = a(contextThemeWrapper, 20);
        StateListDrawable stateListDrawableA = le.a(contextThemeWrapper, z2, i2);
        stateListDrawableA.setBounds(0, 0, iA, iA);
        checkBox.setCompoundDrawablesRelative(stateListDrawableA, null, null, null);
        if (z3) {
            checkBox.setMinWidth(0);
            checkBox.setMinimumWidth(0);
            checkBox.setMinHeight(0);
            checkBox.setPadding(0, 0, 0, 0);
            checkBox.setCompoundDrawablePadding(0);
        } else {
            checkBox.setMinHeight((int) (52 * contextThemeWrapper.getResources().getDisplayMetrics().density));
            float f = 4;
            checkBox.setPadding((int) (contextThemeWrapper.getResources().getDisplayMetrics().density * f), 0, (int) (f * contextThemeWrapper.getResources().getDisplayMetrics().density), 0);
            checkBox.setCompoundDrawablePadding((int) (12 * contextThemeWrapper.getResources().getDisplayMetrics().density));
        }
        checkBox.setChecked(z);
        checkBox.setImportantForAutofill(2);
        return checkBox;
    }

    public static final void a(String str, final Activity activity, w wVar, final ImageView imageView) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Bitmap bitmapA = a(str);
            obj = Result.constructor-impl(bitmapA != null ? a(bitmapA) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Avatar decode failed for uid=%s", new Object[]{wVar.a}), th2);
        }
        final Bitmap bitmap = (Bitmap) (Result.isFailure-impl(obj) ? null : obj);
        if (bitmap == null) {
            return;
        }
        a.put(str, bitmap);
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                z.a(activity, bitmap, imageView);
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

    public static int a(ContextThemeWrapper contextThemeWrapper, int i) {
        return (int) (i * contextThemeWrapper.getResources().getDisplayMetrics().density);
    }

    public static final void b(Dialog dialog, View view) {
        dialog.dismiss();
    }
}
