package Z;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.windukk.mod.Main;
import com.windukk.stable.ResourceOverlay;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.function.IntConsumer;

public final class fc {
    public final Activity a;
    public final jc b;
    public final LinearLayout c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final LinearLayout o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public LinearLayout s;
    public LinearLayout t;
    public boolean w;
    public Runnable x;
    public float u = 0.5f;
    public boolean v = true;
    public final ArrayList y = new ArrayList();

    public fc(Activity activity) {
        int iA;
        this.a = activity;
        this.d = (activity.getResources().getConfiguration().uiMode & 48) == 32;
        try {
            iA = ac.a().g() ? zh.a() : -119980;
        } catch (Throwable th) {
            iA = -119980;
        }
        this.e = iA;
        boolean z = this.d;
        this.f = z ? -14803426 : -657931;
        this.g = z ? -13882324 : -1;
        this.h = z ? -1 : -16777216;
        this.i = -6316129;
        this.j = z ? -7697782 : -8158333;
        this.k = -5723992;
        this.l = z ? -10066330 : -4473925;
        this.m = z ? 587202559 : 402653184;
        this.n = z ? -11184811 : -4473925;
        jc jcVar = new jc(activity);
        try {
            jcVar.requestWindowFeature(1);
        } catch (Throwable th2) {
        }
        this.b = jcVar;
        LinearLayout linearLayout = new LinearLayout(activity);
        this.c = linearLayout;
        linearLayout.setOrientation(1);
        int i = this.f;
        float fA = Main.dp(24.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(Main.dp(16.0f), Main.dp(12.0f), Main.dp(16.0f), Main.dp(24.0f));
        linearLayout.setClickable(true);
        linearLayout.setClipToOutline(true);
        View view = new View(activity);
        int i2 = this.l;
        float fA2 = Main.dp(2.0f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i2);
        gradientDrawable2.setCornerRadius(fA2);
        view.setBackground(gradientDrawable2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Main.dp(48.0f), Main.dp(4.0f));
        layoutParams.gravity = 1;
        linearLayout.addView(view, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        this.o = linearLayout2;
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        linearLayout2.setVisibility(8);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
    }

    public static Typeface f() {
        return Build.VERSION.SDK_INT >= 28 ? Typeface.create(Typeface.SANS_SERIF, 600, false) : Typeface.create("sans-serif-medium", 0);
    }

    public static LinearLayout.LayoutParams h() {
        return new LinearLayout.LayoutParams(0, -2, 1.0f);
    }

    public final fc a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.r;
            if (textView != null) {
                textView.setVisibility(8);
            }
            return this;
        }
        if (this.r == null) {
            TextView textViewA = a(14.0f, false, this.i);
            this.r = textViewA;
            textViewA.setGravity(17);
            this.r.setLineSpacing(Main.dp(2.0f), 1.0f);
            this.o.addView(this.r, new LinearLayout.LayoutParams(-1, -2));
        }
        this.r.setVisibility(0);
        this.r.setText(charSequence);
        this.o.setVisibility(0);
        d();
        return this;
    }

    public final fc b(String str) {
        if (this.p == null) {
            ImageView imageView = new ImageView(this.a);
            this.p = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Main.dp(86.0f), Main.dp(86.0f));
            layoutParams.topMargin = Main.dp(24.0f);
            this.o.addView(this.p, 0, layoutParams);
        }
        this.p.setImageDrawable(a(str));
        this.o.setVisibility(0);
        d();
        return this;
    }

    public final TextView c(CharSequence charSequence, final Runnable runnable) {
        TextView textViewA = a(charSequence, false);
        textViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                fc.c(runnable, view);
            }
        });
        if (this.t == null) {
            LinearLayout linearLayoutA = a(12);
            this.t = linearLayoutA;
            this.c.addView(linearLayoutA, new LinearLayout.LayoutParams(-1, -2));
            c();
        }
        this.t.addView(textViewA, new LinearLayout.LayoutParams(-1, -2));
        return textViewA;
    }

    public final void d(CharSequence charSequence, final Runnable runnable) {
        c(charSequence, new Runnable() {
            @Override
            public final void run() {
                fc.this.c(runnable);
            }
        });
    }

    public final LinearLayout e() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(Main.dp(16.0f), Main.dp(16.0f), Main.dp(16.0f), Main.dp(16.0f));
        float fA = Main.dp(16.0f);
        int i = this.g;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setMinimumHeight(Main.dp(52.0f));
        a(linearLayout, 12);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    public final boolean g() {
        try {
            this.b.setContentView(kc.a(this.a, this.c, new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    fc.this.a(view);
                }
            }));
            this.b.setCancelable(this.v);
            if (this.x != null) {
                this.b.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public final void onDismiss(DialogInterface dialogInterface) {
                        fc.this.a(dialogInterface);
                    }
                });
            }
            kc.a(this.b, this.c, this.f, this.u);
            Window window = this.b.getWindow();
            if (window != null) {
                window.setSoftInputMode((this.w ? 4 : 2) | 16);
            }
            this.b.show();
            ArrayList arrayList = this.y;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
            return true;
        } catch (Throwable th) {
            String strDecrypt = "Mod sheet show failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
            return false;
        }
    }

    public final void d() {
        TextView textView = this.q;
        if (textView != null) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = Main.dp(20.0f);
        }
        TextView textView2 = this.r;
        if (textView2 != null) {
            ((LinearLayout.LayoutParams) textView2.getLayoutParams()).topMargin = this.q != null ? Main.dp(9.0f) : Main.dp(20.0f);
        }
        this.o.requestLayout();
        c();
    }

    public static  void c(Runnable runnable, View view) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public final fc b(CharSequence charSequence) {
        if (this.q == null) {
            TextView textViewA = a(16.0f, true, this.h);
            this.q = textViewA;
            textViewA.setGravity(17);
            this.o.addView(this.q, this.p == null ? 0 : 1, new LinearLayout.LayoutParams(-1, -2));
        }
        this.q.setText(charSequence);
        this.o.setVisibility(0);
        d();
        return this;
    }

    public final void c() {
        int iA;
        int iA2;
        boolean z = this.o.getVisibility() == 0 && !(this.q == null && this.r == null);
        LinearLayout linearLayout = this.s;
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            if (z) {
                iA2 = Main.dp(20.0f);
            } else {
                iA2 = Main.dp(24.0f);
            }
            layoutParams.topMargin = iA2;
        }
        LinearLayout linearLayout2 = this.t;
        if (linearLayout2 != null) {
            boolean z2 = this.s == null && z;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
            if (z2) {
                iA = Main.dp(20.0f);
            } else {
                iA = Main.dp(24.0f);
            }
            layoutParams2.topMargin = iA;
        }
    }

    public final LinearLayout a() {
        if (this.s == null) {
            this.s = a(12);
            LinearLayout linearLayout = this.t;
            this.c.addView(this.s, linearLayout != null ? this.c.indexOfChild(linearLayout) : this.c.getChildCount(), new LinearLayout.LayoutParams(-1, -2));
            c();
        }
        return this.s;
    }

    public static  void b(Runnable runnable, View view) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void b(CharSequence charSequence, final Runnable runnable) {
        a(charSequence, new Runnable() {
            @Override
            public final void run() {
                fc.this.c(runnable);
            }
        });
    }

    public final void b(ImageView imageView, boolean z) {
        String str;
        String str2;
        BitmapDrawable bitmapDrawableA = a((z ? "ic_radio_active" : "ic_radio_inactive"));
        if (bitmapDrawableA != null) {
            bitmapDrawableA.setColorFilter(z ? this.e : this.n, PorterDuff.Mode.SRC_IN);
        }
        imageView.setImageDrawable(bitmapDrawableA);
        imageView.setSelected(z);
    }

    public final TextView a(CharSequence charSequence, final Runnable runnable) {
        TextView textViewA = a(charSequence, true);
        textViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                fc.b(runnable, view);
            }
        });
        if (this.t == null) {
            LinearLayout linearLayoutA = a(12);
            this.t = linearLayoutA;
            this.c.addView(linearLayoutA, new LinearLayout.LayoutParams(-1, -2));
            c();
        }
        this.t.addView(textViewA, new LinearLayout.LayoutParams(-1, -2));
        return textViewA;
    }

    public static Typeface b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Typeface.create(Typeface.SANS_SERIF, 500, false);
        }
        return Typeface.create("sans-serif", 0);
    }

    public static void a(TextView textView, boolean z) {
        textView.setEnabled(z);
        textView.setAlpha(z ? 1.0f : 0.5f);
    }

    public final void a(View view) {
        if (this.v) {
            c((Runnable) null);
        }
    }

    public final  void a(DialogInterface dialogInterface) {
        this.x.run();
    }

    public final void c(Runnable runnable) {
        try {
            jc jcVar = this.b;
            if (jcVar instanceof jc) {
                if (runnable != null) {
                    jcVar.h.add(runnable);
                }
                jcVar.dismiss();
            } else {
                try {
                    jcVar.dismiss();
                } catch (Throwable th) {
                }
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Throwable th2) {
            String strDecrypt = "Mod sheet dismiss failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th2);
        }
    }

    public final LinearLayout a(int i) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        a(linearLayout, i);
        return linearLayout;
    }

    public final LinearLayout a(String str, String str2, String str3, ImageView imageView, Runnable runnable) {
        LinearLayout linearLayoutE = e();
        if (str != null) {
            linearLayoutE.addView(a(this.k, str), new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        }
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        TextView textViewA = a(14.0f, true, this.h);
        textViewA.setText(str2);
        linearLayout.addView(textViewA, new LinearLayout.LayoutParams(-1, -2));
        if (!TextUtils.isEmpty(str3)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = Main.dp(5.0f);
            TextView textViewA2 = a(14.0f, false, this.i);
            textViewA2.setLineSpacing(Main.dp(2.0f), 1.0f);
            textViewA2.setText(str3);
            linearLayout.addView(textViewA2, layoutParams);
        }
        linearLayoutE.addView(linearLayout, h());
        if (!TextUtils.isEmpty(str3)) {
            linearLayoutE.setPadding(Main.dp(16.0f), Main.dp(14.0f), Main.dp(16.0f), Main.dp(14.0f));
        }
        if (imageView != null) {
            linearLayoutE.addView(imageView);
        }
        if (runnable != null) {
            a(linearLayoutE, runnable);
        }
        return linearLayoutE;
    }

    public final void a(LinearLayout linearLayout, final Runnable runnable) {
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        float fA = Main.dp(16.0f);
        int i = this.g;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.m);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(fA);
        linearLayout.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable, gradientDrawable2));
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                runnable.run();
            }
        });
    }

    public final TextView a(float f, boolean z, int i) {
        TextView textView = new TextView(this.a);
        textView.setTextSize(2, f);
        textView.setTextColor(i);
        textView.setTypeface(z ? f() : b());
        textView.setIncludeFontPadding(false);
        return textView;
    }

    public final ImageView a(int i, String str) {
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        BitmapDrawable bitmapDrawableA = a(str);
        if (bitmapDrawableA != null && i != 0) {
            bitmapDrawableA.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        imageView.setImageDrawable(bitmapDrawableA);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        return imageView;
    }

    public final ImageView a(boolean z) {
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        a(imageView, z);
        return imageView;
    }

    public final void a(ImageView imageView, boolean z) {
        String str;
        String str2;
        BitmapDrawable bitmapDrawableA = a((z ? "ic_check_active" : "ic_check_inactive"));
        if (bitmapDrawableA != null) {
            bitmapDrawableA.setColorFilter(z ? this.e : this.n, PorterDuff.Mode.SRC_IN);
        }
        imageView.setImageDrawable(bitmapDrawableA);
        imageView.setSelected(z);
    }

    public final LinearLayout a(CharSequence[] charSequenceArr, int i, final IntConsumer intConsumer) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(Main.dp(4.0f), Main.dp(4.0f), Main.dp(4.0f), Main.dp(4.0f));
        int i2 = this.g;
        float fA = Main.dp(99.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        a(linearLayout, 4);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        final TextView[] textViewArr = new TextView[charSequenceArr.length];
        for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
            TextView textViewA = a(14.0f, false, this.j);
            textViewA.setText(charSequenceArr[i3]);
            textViewA.setGravity(17);
            textViewA.setSingleLine(true);
            textViewA.setEllipsize(TextUtils.TruncateAt.END);
            textViewA.setPadding(Main.dp(12.0f), Main.dp(12.0f), Main.dp(12.0f), Main.dp(12.0f));
            final int index = i3;
            textViewA.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    fc.this.a(textViewArr, index, intConsumer, view);
                }
            });
            textViewArr[i3] = textViewA;
            linearLayout.addView(textViewA, h());
        }
        a(textViewArr, i);
        return linearLayout;
    }

    public final  void a(TextView[] textViewArr, int i, IntConsumer intConsumer, View view) {
        a(textViewArr, i);
        if (intConsumer != null) {
            intConsumer.accept(i);
        }
    }

    public final void a(TextView[] textViewArr, int i) {
        GradientDrawable gradientDrawable;
        int i2 = 0;
        while (i2 < textViewArr.length) {
            boolean z = i2 == i;
            textViewArr[i2].setTextColor(z ? this.h : this.j);
            textViewArr[i2].setTypeface(z ? f() : b());
            TextView textView = textViewArr[i2];
            if (z) {
                int i3 = this.f;
                float fA = Main.dp(99.0f);
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i3);
                gradientDrawable.setCornerRadius(fA);
            } else {
                gradientDrawable = null;
            }
            textView.setBackground(gradientDrawable);
            i2++;
        }
    }

    public final cc a(LinearLayout linearLayout, float f) {
        cc ccVar = new cc(this.a, (int) (this.a.getResources().getDisplayMetrics().heightPixels * f));
        ccVar.setVerticalScrollBarEnabled(false);
        ccVar.setOverScrollMode(2);
        ccVar.setClipToPadding(false);
        ccVar.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        ccVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return ccVar;
    }

    public final BitmapDrawable a(String str) {
        if (str == null) {
            return null;
        }
        try {
            InputStream inputStreamOpen = ResourceOverlay.open(this.a, "mod_icons/" + str + ".png");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                BitmapDrawable bitmapDrawable = bitmapDecodeStream != null ? new BitmapDrawable(this.a.getResources(), bitmapDecodeStream) : null;
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return bitmapDrawable;
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
        } catch (Throwable th3) {
            return null;
        }
    }

    public final TextView a(CharSequence charSequence, boolean z) {
        TextView textViewA = a(16.0f, true, z ? -1 : this.h);
        textViewA.setText(charSequence);
        textViewA.setGravity(17);
        textViewA.setSingleLine(true);
        textViewA.setEllipsize(TextUtils.TruncateAt.END);
        textViewA.setPadding(Main.dp(10.0f), Main.dp(10.0f), Main.dp(10.0f), Main.dp(10.0f));
        textViewA.setMinHeight(Main.dp(48.0f));
        textViewA.setClickable(true);
        textViewA.setFocusable(true);
        float fA = Main.dp(68.0f);
        int i = z ? this.e : 0;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(z ? 872415231 : this.m);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(fA);
        textViewA.setBackground(new RippleDrawable(colorStateListValueOf, gradientDrawable, gradientDrawable2));
        return textViewA;
    }

    public static void a(LinearLayout linearLayout, int i) {
        if (i <= 0) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        int iA = Main.dp(i);
        gradientDrawable.setSize(iA, iA);
        linearLayout.setDividerDrawable(gradientDrawable);
        linearLayout.setShowDividers(2);
    }

    public final void a(EditText editText) {
        if (Build.VERSION.SDK_INT >= 29) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.h);
            gradientDrawable.setSize(Main.dp(1.0f), Main.dp(20.0f));
            editText.setTextCursorDrawable(gradientDrawable);
        }
    }
}
