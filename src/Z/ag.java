package Z;

import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.function.Consumer;

public final class ag {
    public final sf a;
    public final hi b;
    public final int c;
    public final int d;
    public final Consumer e;
    public String f;
    public String g;
    public Runnable h;
    public ImageView i;

    public ag(sf sfVar, hi hiVar, int i, int i2, Consumer consumer) {
        this.a = sfVar;
        this.b = hiVar;
        this.c = i;
        this.d = i2;
        this.e = consumer;
    }

    public final FrameLayout a(String str, Consumer consumer) {
        boolean z = this.b.b;
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setTag("ModSettingsView");
        frameLayout.setBackgroundColor(z ? -16777216 : hi.d);
        this.e.accept(frameLayout);
        final ScrollView scrollView = new ScrollView(this.a);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setPadding(0, this.b.a(56.0f) + this.c, 0, this.d);
        scrollView.setClipToPadding(false);
        frameLayout.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        if (this.f != null) {
            this.i = a();
        }
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(this.b.a(8.0f), 0, this.b.a(8.0f), this.b.a(20.0f) + this.d);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        final TextView textView = new TextView(this.a);
        textView.setText(str);
        textView.setTextSize(2, 28.0f);
        textView.setTextColor(this.b.e());
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.b.a(16.0f);
        layoutParams.topMargin = this.b.a(8.0f);
        layoutParams.bottomMargin = this.b.a(14.0f);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        consumer.accept(linearLayout);
        final TextView textView2 = new TextView(this.a);
        textView2.setText(str);
        textView2.setTextSize(2, 16.0f);
        (textView2).setTypeface(android.graphics.Typeface.create("sans-serif", 1));
        textView2.setTextColor(this.b.e());
        textView2.setVisibility(4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = this.b.a(16.0f) + this.c;
        textView2.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(this.b.b ? -16777216 : hi.d);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 48;
        frameLayout.addView(linearLayout2, layoutParams3);
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        frameLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, this.b.a(56.0f) + this.c));
        frameLayout2.addView(textView2);
        linearLayout2.addView(frameLayout2);
        a(frameLayout);
        View view = this.i;
        if (view != null) {
            frameLayout.addView(view);
        }
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public final void onScrollChanged() {
                ag.this.a(scrollView, textView, textView2);
            }
        });
        scrollView.post(new Runnable() {
            @Override
            public final void run() {
                ag.this.b(scrollView, textView, textView2);
            }
        });
        return frameLayout;
    }

    public final void b(ScrollView scrollView, TextView textView, TextView textView2) {
        textView2.setVisibility(scrollView.getScrollY() >= textView.getHeight() + textView.getTop() ? 0 : 4);
    }

    public final  void b(View view) {
        this.a.finish();
    }

    public final void a(ScrollView scrollView, TextView textView, TextView textView2) {
        textView2.setVisibility(scrollView.getScrollY() >= textView.getHeight() + textView.getTop() ? 0 : 4);
    }

    public final void a(FrameLayout frameLayout) {
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, "ic_back"));
        imageView.setColorFilter(this.b.b ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                ag.this.b(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.b.a(24.0f), this.b.a(24.0f));
        layoutParams.leftMargin = this.b.a(16.0f);
        layoutParams.topMargin = this.b.a(16.0f) + this.c;
        layoutParams.gravity = 51;
        frameLayout.addView(imageView, layoutParams);
    }

    public final ImageView a() {
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, this.f));
        imageView.setColorFilter(this.b.b ? -1 : -16777216, PorterDuff.Mode.SRC_IN);
        imageView.setContentDescription(this.g);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                ag.this.a(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.b.a(24.0f), this.b.a(24.0f));
        layoutParams.rightMargin = this.b.a(16.0f);
        layoutParams.topMargin = this.b.a(16.0f) + this.c;
        layoutParams.gravity = 53;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public final  void a(View view) {
        this.h.run();
    }
}
