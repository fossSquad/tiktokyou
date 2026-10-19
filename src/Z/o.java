package Z;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class o extends LinearLayout {
    public final hi a;
    public final LinearLayout b;
    public final ImageView c;
    public final LinearLayout d;
    public final ImageView e;
    public boolean f;

    public o(t5 t5Var, hi hiVar) {
        super(t5Var);
        this.a = hiVar;
        setOrientation(1);
        float fA = hiVar.a(12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(fA);
        setBackground(gradientDrawable);
        setClipToOutline(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(hiVar.a(24.0f), 0, hiVar.a(24.0f), 0);
        TextView textView = new TextView(getContext());
        textView.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(-1);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLetterSpacing(-0.02f);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        a(linearLayout, "ic_preview_signal", 18, 0);
        a(linearLayout, "ic_preview_wifi", 17, 4);
        a(linearLayout, "ic_preview_battery", 27, 4);
        this.b = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, hiVar.a(56.0f)));
        FrameLayout frameLayout = new FrameLayout(t5Var);
        frameLayout.setPadding(hiVar.a(16.0f), hiVar.a(16.0f), hiVar.a(16.0f), hiVar.a(16.0f));
        addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(t5Var);
        this.c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(hiVar.a(24.0f), hiVar.a(24.0f), 8388659));
        LinearLayout linearLayout2 = new LinearLayout(t5Var);
        this.d = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(49);
        linearLayout2.addView(a(k7.a("antiburnout_preview_following"), false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = hiVar.a(10.0f);
        linearLayout2.addView(a(k7.a("antiburnout_preview_for_you"), true), layoutParams);
        frameLayout.addView(linearLayout2, new FrameLayout.LayoutParams(-2, -2, 49));
        ImageView imageView2 = new ImageView(t5Var);
        this.e = imageView2;
        imageView2.setImageBitmap(hi.a(hiVar.a, "ic_search"));
        imageView2.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        frameLayout.addView(imageView2, new FrameLayout.LayoutParams(hiVar.a(24.0f), hiVar.a(24.0f), 8388661));
        a();
    }

    public final void a(View view) {
        if (y5.a().g) {
            this.f = !this.f;
            a();
        }
    }

    public void setActive(boolean z) {
        this.f = z;
        a();
    }

    public final void a() {
        String str;
        String str2;
        String strDecrypt;
        float f;
        boolean z = y5.a().g;
        int i = 0;
        boolean z2 = z && this.f;
        LinearLayout linearLayout = this.b;
        if (z2 && ac.e().i) {
            i = 4;
        }
        linearLayout.setVisibility(i);
        if (z) {
            strDecrypt = (z2 ? "ic_settings_burn-in-on" : "ic_settings_burn-in-off");
        } else {
            strDecrypt = "ic_live_badge";
        }
        this.c.setImageBitmap(hi.a(this.a.a, strDecrypt));
        if (z2) {
            int i2 = ac.e().s;
            if (i2 >= 100) {
                f = 0.0f;
            } else if (i2 <= 0) {
                f = 1.0f;
            } else {
                f = (100 - i2) / 100.0f;
            }
        } else {
            f = 1.0f;
        }
        this.d.setAlpha(f);
        this.e.setAlpha(f);
        this.c.setAlpha(z2 ? Math.max(f, 0.4f) : 1.0f);
    }

    public final void a(LinearLayout linearLayout, String str, int i, int i2) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(hi.a(this.a.a, str));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.a.a(i), this.a.a(14.0f));
        layoutParams.leftMargin = this.a.a(i2);
        linearLayout.addView(imageView, layoutParams);
    }

    public final LinearLayout a(String str, boolean z) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(0, 0, 0, this.a.a(10.0f));
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(hi.f());
        textView.setLetterSpacing(-0.07f);
        textView.setTextColor(z ? -1 : -2130706433);
        textView.setSingleLine(true);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        if (z) {
            View view = new View(getContext());
            float fA = this.a.a(1.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(fA);
            view.setBackground(gradientDrawable);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.a.a(22.0f), this.a.a(2.0f));
            layoutParams.topMargin = this.a.a(7.0f);
            linearLayout.addView(view, layoutParams);
        }
        return linearLayout;
    }
}
