package Z;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.windukk.mod.Main;
import com.windukk.stable.ResourceOverlay;
import java.io.IOException;
import java.io.InputStream;

public final class hi {
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public final Context a;
    public final boolean b;
    public final Runnable c;

    static {
        d = Color.parseColor("#F5F5F5");
        e = Color.parseColor("#1E1E1E");
        f = Color.parseColor("#858585");
        g = Color.parseColor("#888888");
        h = Color.parseColor("#777778");
    }

    public hi(Context context, boolean z, Runnable runnable) {
        this.a = context;
        this.b = z;
        this.c = runnable;
    }

    public static int c(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Typeface f() {
        return Build.VERSION.SDK_INT >= 28 ? Typeface.create(Typeface.SANS_SERIF, 600, false) : Typeface.create("sans-serif-medium", 0);
    }

    public final int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, this.a.getResources().getDisplayMetrics());
    }

    public final int b() {
        if (ac.a() == null || ac.e().r != 0) {
            return -185258;
        }
        try {
            int identifier = this.a.getResources().getIdentifier("system_accent3_400", "color", "android");
            if (identifier != 0) {
                return this.a.getResources().getColor(identifier, null);
            }
        } catch (Throwable th) {
        }
        Context contextA = Main.getApplicationContext();
        if (contextA == null) {
            return -16524603;
        }
        return zh.a(contextA);
    }

    public final void d() {
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final int e() {
        return this.b ? -1 : -16777216;
    }

    public final LinearLayout c() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? e : -1);
        gradientDrawable.setCornerRadius(a(16.0f));
        linearLayout.setBackground(gradientDrawable);
        return linearLayout;
    }

    public static int a() {
        if (ac.a().g()) {
            return zh.a();
        }
        return Color.parseColor("#FE2B54");
    }

    public static boolean a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static void a(sf sfVar, boolean z) {
        Window window = sfVar.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        int i = !z ? 9984 : 1792;
        if (!z) {
            i |= 16;
        }
        window.getDecorView().setSystemUiVisibility(i);
    }

    public static int b(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final BitmapDrawable b(String str) {
        Bitmap bitmapA = a(this.a, str);
        if (bitmapA != null) {
            return new BitmapDrawable(this.a.getResources(), bitmapA);
        }
        return null;
    }

    public final BitmapDrawable b(int i, String str) {
        BitmapDrawable bitmapDrawableB = b(str);
        if (bitmapDrawableB != null) {
            bitmapDrawableB.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        return bitmapDrawableB;
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
        } catch (IOException e2) {
            return null;
        }
    }

    public static StateListDrawable a(Context context, boolean z, int i) {
        String str;
        String str2;
        BitmapDrawable bitmapDrawable;
        int color = Color.parseColor((z ? "#555555" : "#BBBBBB"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        Bitmap bitmapA = a(context, "ic_check_active");
        BitmapDrawable bitmapDrawable2 = null;
        if (bitmapA == null) {
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapA);
            bitmapDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        Bitmap bitmapA2 = a(context, "ic_check_inactive");
        if (bitmapA2 != null) {
            bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmapA2);
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

    public final CheckBox a(String str, String str2, boolean z, final gi giVar) {
        CheckBox checkBox = new CheckBox(this.a);
        final boolean z2 = false;
        checkBox.setSaveEnabled(false);
        checkBox.setText(str);
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(f());
        checkBox.setMinHeight(a(48.0f));
        checkBox.setTextColor(e());
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        checkBox.setPadding(a(16.0f), 0, a(16.0f), 0);
        StateListDrawable stateListDrawableA = a(this.a, this.b, a());
        BitmapDrawable bitmapDrawableB = b(str2);
        int iA = a(20.0f);
        if (bitmapDrawableB != null) {
            bitmapDrawableB.setBounds(0, 0, iA, iA);
        }
        stateListDrawableA.setBounds(0, 0, iA, iA);
        checkBox.setCompoundDrawables(bitmapDrawableB, null, stateListDrawableA, null);
        checkBox.setCompoundDrawablePadding(a(12.0f));
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        checkBox.setChecked(z);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                this.f$0.a(giVar, z2, compoundButton, z3);
            }
        });
        a(checkBox);
        return checkBox;
    }

    public final void a(gi giVar, boolean z, CompoundButton compoundButton, boolean z2) {
        Runnable runnable;
        if (giVar != null) {
            giVar.a(z2);
        }
        if (!z || (runnable = this.c) == null) {
            return;
        }
        runnable.run();
    }

    public final RadioButton a(int i, String str, String str2) {
        String str3;
        String str4;
        RadioButton radioButton = new RadioButton(this.a);
        radioButton.setId(i);
        radioButton.setSaveEnabled(false);
        radioButton.setText(str);
        radioButton.setTextSize(2, 16.0f);
        radioButton.setTypeface(f());
        radioButton.setMinHeight(a(48.0f));
        radioButton.setTextColor(e());
        radioButton.setButtonDrawable((Drawable) null);
        radioButton.setBackground(null);
        radioButton.setPadding(a(16.0f), 0, a(16.0f), 0);
        int color = Color.parseColor((this.b ? "#555555" : "#BBBBBB"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, b(a(), "ic_radio_active"));
        stateListDrawable.addState(new int[0], b(color, "ic_radio_inactive"));
        BitmapDrawable bitmapDrawableB = b(str2);
        int iA = a(20.0f);
        if (bitmapDrawableB != null) {
            bitmapDrawableB.setBounds(0, 0, iA, iA);
        }
        stateListDrawable.setBounds(0, 0, iA, iA);
        radioButton.setCompoundDrawables(bitmapDrawableB, null, stateListDrawable, null);
        radioButton.setCompoundDrawablePadding(a(12.0f));
        radioButton.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a(radioButton);
        return radioButton;
    }

    public final LinearLayout a(String str, String str2, TextView textView, final Runnable runnable) {
        LinearLayout linearLayout = new LinearLayout(this.a);
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
        a(linearLayout);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(a(this.a, str));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(a(20.0f), a(20.0f)));
        TextView textView2 = new TextView(this.a);
        textView2.setText(str2);
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(f());
        textView2.setTextColor(e());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = a(12.0f);
        linearLayout.addView(textView2, layoutParams);
        if (textView != null) {
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(f);
            textView.setSingleLine(true);
            linearLayout.addView(textView);
        }
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setImageBitmap(a(this.a, "ic_arrow_right"));
        imageView2.setColorFilter(h);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams2.leftMargin = a(8.0f);
        linearLayout.addView(imageView2, layoutParams2);
        return linearLayout;
    }

    public final FrameLayout a(BitmapDrawable bitmapDrawable, String str, final String str2, int i, View.OnClickListener onClickListener) {
        int iA;
        FrameLayout frameLayout = new FrameLayout(this.a);
        int iA2 = a(14.0f);
        frameLayout.setPadding(0, iA2, 0, iA2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? e : -1);
        gradientDrawable.setCornerRadii(a(i));
        frameLayout.setBackground(gradientDrawable);
        boolean z = (str2 == null && onClickListener == null) ? false : true;
        if (z) {
            if (onClickListener == null) {
                onClickListener = new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        this.f$0.a(str2, view);
                    }
                };
            }
            frameLayout.setOnClickListener(onClickListener);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(-1);
            gradientDrawable2.setCornerRadii(a(i));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(this.b ? e : -1);
            gradientDrawable3.setCornerRadii(a(i));
            frameLayout.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), gradientDrawable3, gradientDrawable2));
        }
        ImageView imageView = new ImageView(this.a);
        imageView.setImageDrawable(bitmapDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(20.0f), a(20.0f));
        layoutParams.leftMargin = a(16.0f);
        layoutParams.gravity = 19;
        frameLayout.addView(imageView, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.a);
        textView.setText(str);
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(e());
        textView.setTypeface(f());
        linearLayout.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = a(48.0f);
        if (!z) {
            iA = a(16.0f);
        } else {
            iA = a(52.0f);
        }
        layoutParams2.rightMargin = iA;
        layoutParams2.gravity = 19;
        frameLayout.addView(linearLayout, layoutParams2);
        if (z) {
            ImageView imageView2 = new ImageView(this.a);
            imageView2.setImageBitmap(a(this.a, "ic_arrow_right"));
            imageView2.setColorFilter(h);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a(20.0f), a(20.0f));
            layoutParams3.rightMargin = a(16.0f);
            layoutParams3.gravity = 21;
            frameLayout.addView(imageView2, layoutParams3);
        }
        return frameLayout;
    }

    public final  void a(String str, View view) {
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final ImageView a(String str) {
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(a(this.a, str));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(a(8.0f), a(8.0f), a(8.0f), a(8.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(872415231);
        imageView.setBackground(gradientDrawable);
        imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        return imageView;
    }

    public final void a(View view, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b ? e : -1);
        gradientDrawable.setCornerRadius(a(f2));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(a(f2));
        view.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), gradientDrawable, gradientDrawable2));
    }

    public final void a(View view) {
        view.setBackground(new RippleDrawable(ColorStateList.valueOf(this.b ? 872415231 : 520093696), null, new ColorDrawable(-1)));
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

    public final BitmapDrawable a(int i, String str) {
        Bitmap bitmapDecodeStream;
        try {
            InputStream inputStreamOpen = ResourceOverlay.open(this.a, str);
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
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
        } catch (IOException e2) {
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        boolean z = zh.d;
        zh.d = false;
        try {
            paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            zh.d = z;
            canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
            return new BitmapDrawable(this.a.getResources(), bitmapCreateBitmap);
        } catch (Throwable th3) {
            zh.d = z;
            throw th3;
        }
    }
}
