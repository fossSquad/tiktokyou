package Z;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.function.Supplier;

public final class tf {
    public final sf a;
    public final hi b;
    public final int c;
    public final Supplier d;
    public FrameLayout e;

    public tf(sf sfVar, hi hiVar, int i, Supplier supplier) {
        this.a = sfVar;
        this.b = hiVar;
        this.c = i;
        this.d = supplier;
    }

    public final FrameLayout a() {
        boolean z = this.b.b;
        FrameLayout frameLayout = new FrameLayout(this.a);
        int iA = this.b.a(16.0f);
        int iA2 = this.b.a(16.0f);
        frameLayout.setPadding(iA, iA2, iA, iA2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(z ? -1 : Color.parseColor("#1E1E1E"));
        gradientDrawable.setCornerRadius(this.b.a(8.0f));
        frameLayout.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(this.b.a(8.0f), 0, this.b.a(8.0f), 0);
        frameLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(this.a);
        String strA = k7.a("bulletin_button");
        textView.setText(strA);
        textView.setTextColor(-1);
        textView.setTextSize(2, 14.0f);
        x5.a("8M1U8KtD+t2LqruxLKriZcLjRWSw2b0Pb/jsFHpxbeb841qNS5g4R24NHyoBeumt", "tz1oMaYvXPdgeZS4", "aes", 0, textView);
        textView.setGravity(17);
        textView.setPadding(this.b.a(20.0f), 0, this.b.a(20.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(hi.a());
        gradientDrawable2.setCornerRadius(this.b.a(68.0f));
        textView.setBackground(gradientDrawable2);
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(2, 14.0f, this.a.getResources().getDisplayMetrics()));
        int iA3 = this.b.a(16.0f) + this.b.a(40.0f) + ((int) paint.measureText(strA));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        TextView textView2 = new TextView(this.a);
        textView2.setText(k7.a("bulletin_title"));
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(z ? -16777216 : -1);
        x5.a("vMuoHcfEepIc1wPA/QLONEHuu7NeZlG5DmB0u2Grhj2Bi88BVmVLOzml0iTHPuvO", "qie21Lqblglkh2gD", "aes", 1, textView2);
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this.a);
        textView3.setText(k7.a("bulletin_subtitle"));
        textView3.setTextSize(2, 12.0f);
        textView3.setTextColor(Color.parseColor("#838383"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = this.b.a(2.0f);
        linearLayout.addView(textView3, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 19;
        layoutParams3.rightMargin = iA3;
        frameLayout.addView(linearLayout, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, this.b.a(36.0f));
        layoutParams4.gravity = 21;
        frameLayout.addView(textView, layoutParams4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        return frameLayout;
    }

    public final void b() {
        FrameLayout frameLayout;
        if (this.e == null && (frameLayout = (FrameLayout) this.d.get()) != null) {
            this.e = a();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            layoutParams.setMargins(this.b.a(8.0f), 0, this.b.a(8.0f), this.b.a(16.0f) + this.c);
            this.e.setTranslationY(this.b.a(100.0f));
            this.e.setAlpha(0.0f);
            frameLayout.addView(this.e, layoutParams);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationY", this.b.a(100.0f), 0.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "alpha", 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            animatorSet.setDuration(300L);
            animatorSet.start();
        }
    }

    public final void a(View view) {
        Intent launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(335544320);
            this.a.startActivity(launchIntentForPackage);
        }
        Runtime.getRuntime().exit(0);
    }
}
