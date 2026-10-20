package Z;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlinx.serialization.json.Json;

public final class rj {
    public final qj a;
    public final hi b;
    public LinearLayout c;
    public ImageView d;

    public rj(qj qjVar, hi hiVar) {
        this.a = qjVar;
        this.b = hiVar;
    }

    public final void a(wj wjVar, View view) {
        xj.a(wjVar.a, wjVar.e, wjVar.d);
        pj.i();
        b();
    }

    public final void b() {
        LinearLayout linearLayout = this.c;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setVisibility(xj.a().isEmpty() ? 8 : 0);
        }
        List<wj> listA = xj.a();
        boolean z = true;
        if (listA.isEmpty()) {
            LinearLayout linearLayout2 = this.c;
            LinearLayout linearLayout3 = new LinearLayout(this.a);
            linearLayout3.setOrientation(1);
            linearLayout3.setGravity(1);
            linearLayout3.setPadding(this.b.a(16.0f), this.b.a(16.0f), this.b.a(16.0f), this.b.a(16.0f));
            hi hiVar = this.b;
            int i = hiVar.b ? hi.e : -1;
            float fA = hiVar.a(16.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(fA);
            linearLayout3.setBackground(gradientDrawable);
            TextView textView = new TextView(this.a);
            textView.setText(k7.a("ui_hide_empty_title"));
            textView.setTextSize(2, 16.0f);
            textView.setTypeface(fc.f());
            textView.setTextColor(this.b.e());
            textView.setIncludeFontPadding(false);
            textView.setGravity(17);
            linearLayout3.addView(textView);
            TextView textView2 = new TextView(this.a);
            textView2.setText(k7.a("ui_hide_empty_hint"));
            textView2.setTextSize(2, 12.0f);
            textView2.setTypeface(fc.f());
            textView2.setTextColor(-7171947);
            textView2.setIncludeFontPadding(false);
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.b.a(8.0f);
            linearLayout3.addView(textView2, layoutParams);
            linearLayout2.addView(linearLayout3);
            return;
        }
        String strB = xj.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (wj wjVar : listA) {
            if (strB.equals(wjVar.d)) {
                arrayList.add(wjVar);
            } else {
                arrayList2.add(wjVar);
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            LinearLayout linearLayoutA = a((wj) obj, z);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            if (this.c.getChildCount() > 0) {
                layoutParams2.topMargin = this.b.a(4.0f);
            }
            this.c.addView(linearLayoutA, layoutParams2);
            z = true;
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        LinearLayout linearLayout4 = this.c;
        String strA = k7.a("ui_hide_inactive");
        TextView textView3 = new TextView(this.a);
        textView3.setText(strA);
        textView3.setTextSize(2, 13.0f);
        textView3.setTextColor(hi.f);
        textView3.setPadding(this.b.a(16.0f), this.b.a(12.0f), this.b.a(16.0f), this.b.a(12.0f));
        linearLayout4.addView(textView3);
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            LinearLayout linearLayoutA2 = a((wj) obj2, false);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            if (this.c.getChildCount() > 0) {
                layoutParams3.topMargin = this.b.a(4.0f);
            }
            this.c.addView(linearLayoutA2, layoutParams3);
        }
    }

    public final void a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.b.a(10.0f);
        linearLayout2.setLayoutParams(layoutParams);
        this.c = linearLayout2;
        b();
        linearLayout.addView(linearLayout2);
    }

    public final void a() {
        Json json = xj.a;
        xj.a(CollectionsKt.emptyList());
        pj.i();
        b();
    }

    public final LinearLayout a(final wj wjVar, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        final LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(this.b.a(16.0f), this.b.a(16.0f), this.b.a(16.0f), this.b.a(16.0f));
        linearLayout.setMinimumHeight(this.b.a(52.0f));
        linearLayout.setAlpha(z ? 1.0f : 0.55f);
        this.b.a(linearLayout, 16.0f);
        if (z) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    rj.this.a(linearLayout, wjVar, view);
                }
            });
        }
        final LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setAlpha(wjVar.f ? 1.0f : 0.5f);
        TextView textView = new TextView(this.a);
        textView.setText(wjVar.b);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(fc.f());
        textView.setTextColor(this.b.e());
        textView.setIncludeFontPadding(false);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout2.addView(textView);
        String strDecrypt = (wjVar.a() ? "ic_delete" : "ic_hideui_opacity");
        ImageView imageView = new ImageView(this.a);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        imageView.setScaleType(scaleType);
        imageView.setImageDrawable(this.b.b(-5723992, strDecrypt));
        imageView.setContentDescription(k7.a((wjVar.a() ? "ui_hide_type_gone_short" : "ui_hide_type_alpha_short")));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b.a(12.0f), this.b.a(12.0f));
        layoutParams.setMarginStart(this.b.a(4.0f));
        linearLayout2.addView(imageView, layoutParams);
        if (z) {
            final ImageView imageView2 = new ImageView(this.a);
            imageView2.setScaleType(scaleType);
            imageView2.setContentDescription(wjVar.b);
            a(imageView2, wjVar.f);
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    rj.this.a(imageView2, wjVar, linearLayout2, view);
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f));
            layoutParams2.setMarginEnd(this.b.a(12.0f));
            linearLayout.addView(imageView2, layoutParams2);
        }
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        String strDecrypt2 = "ic_close";
        ImageView imageView3 = new ImageView(this.a);
        imageView3.setScaleType(scaleType);
        imageView3.setImageDrawable(this.b.b(-5723992, strDecrypt2));
        imageView3.setContentDescription(k7.a("ui_hide_restore"));
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                rj.this.a(wjVar, view);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f));
        layoutParams3.setMarginStart(this.b.a(12.0f));
        linearLayout.addView(imageView3, layoutParams3);
        return linearLayout;
    }

    public final void a(LinearLayout linearLayout, wj wjVar, View view) {
        zj.a((Activity) this.a, wjVar.a, wjVar.e, new Runnable() {
            @Override
            public final void run() {
                rj.this.b();
            }
        });
    }

    public final void a(ImageView imageView, wj wjVar, LinearLayout linearLayout, View view) {
        boolean zIsSelected = imageView.isSelected();
        boolean z = !zIsSelected;
        List<wj> listA = xj.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        for (wj wjVar2 : listA) {
            if (wjVar2.a(wjVar)) {
                wjVar2 = new wj(wjVar2.a, wjVar2.b, wjVar2.c, wjVar2.d, wjVar2.e, z);
            }
            arrayList.add(wjVar2);
        }
        xj.a(arrayList);
        pj.i();
        a(imageView, z);
        linearLayout.setAlpha(!zIsSelected ? 1.0f : 0.5f);
    }

    public final void a(ImageView imageView, boolean z) {
        String str;
        String str2;
        hi hiVar = this.b;
        int iA = hiVar.b ? -11184811 : -4473925;
        String strDecrypt = (z ? "ic_check_active" : "ic_check_inactive");
        if (z) {
            this.b.getClass();
            iA = hi.a();
        }
        imageView.setImageDrawable(hiVar.b(iA, strDecrypt));
        imageView.setSelected(z);
    }
}
