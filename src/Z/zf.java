package Z;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Objects;

public final class zf {
    public final sf a;
    public final hi b;

    public zf(sf sfVar, hi hiVar) {
        this.a = sfVar;
        this.b = hiVar;
    }

    public final TextView a(String str) {
        TextView textView = new TextView(this.a);
        textView.setText(str);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(-7171947);
        textView.setTypeface(hi.f());
        textView.setPadding(this.b.a(20.0f), this.b.a(20.0f), this.b.a(20.0f), this.b.a(12.0f));
        return textView;
    }

    public final TextView b(String str) {
        TextView textView = new TextView(this.a);
        textView.setText(str);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(hi.f());
        textView.setTextColor(this.b.e());
        return textView;
    }

    public final LinearLayout a(String str, String str2) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(this.b.a(52.0f));
        linearLayout.setPadding(this.b.a(20.0f), this.b.a(12.0f), this.b.a(20.0f), this.b.a(12.0f));
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, str));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = this.b.a(12.0f);
        linearLayout.addView(b(str2), layoutParams);
        return linearLayout;
    }

    public final LinearLayout a(String str, String str2, TextView textView, final Runnable runnable) {
        LinearLayout linearLayoutA = a(str, str2);
        linearLayoutA.setClickable(true);
        linearLayoutA.setFocusable(true);
        linearLayoutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                runnable.run();
            }
        });
        this.b.a(linearLayoutA);
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = this.b.a(12.0f);
            linearLayoutA.addView(textView, layoutParams2);
        }
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, "ic_arrow_right"));
        imageView.setColorFilter(-5461328);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f));
        layoutParams3.leftMargin = this.b.a(12.0f);
        linearLayoutA.addView(imageView, layoutParams3);
        return linearLayoutA;
    }

    public final TextView a() {
        TextView textView = new TextView(this.a);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(-7171947);
        textView.setTypeface(hi.f());
        textView.setSingleLine(true);
        return textView;
    }

    public final CheckBox a(String str, String str2, boolean z, final gi giVar, boolean z2) {
        CheckBox checkBox = new CheckBox(this.a);
        checkBox.setSaveEnabled(false);
        checkBox.setText(str2);
        checkBox.setTextSize(2, 16.0f);
        checkBox.setTypeface(hi.f());
        checkBox.setTextColor(this.b.e());
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setBackground(null);
        checkBox.setMinHeight(this.b.a(44.0f));
        checkBox.setMinimumHeight(this.b.a(44.0f));
        if (z2) {
            checkBox.setPadding(this.b.a(12.0f), this.b.a(12.0f), this.b.a(12.0f), this.b.a(12.0f));
        } else {
            checkBox.setPadding(this.b.a(20.0f), this.b.a(16.0f), this.b.a(20.0f), this.b.a(16.0f));
        }
        int iA = this.b.a(20.0f);
        BitmapDrawable bitmapDrawableB = this.b.b(str);
        if (bitmapDrawableB != null) {
            bitmapDrawableB.setBounds(0, 0, iA, iA);
        }
        StateListDrawable stateListDrawableA = hi.a((Context) this.a, this.b.b, hi.a());
        stateListDrawableA.setBounds(0, 0, iA, iA);
        checkBox.setCompoundDrawables(bitmapDrawableB, null, stateListDrawableA, null);
        checkBox.setCompoundDrawablePadding(this.b.a(12.0f));
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        checkBox.setChecked(z);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                zf.this.a(giVar, compoundButton, z3);
            }
        });
        this.b.a(checkBox);
        return checkBox;
    }

    public final void a(gi giVar, CompoundButton compoundButton, boolean z) {
        if (giVar != null) {
            giVar.a(z);
        }
        Runnable runnable = this.b.c;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final LinearLayout a(String str, String str2, boolean z, final gi giVar) {
        LinearLayout linearLayoutC = this.b.c();
        linearLayoutC.setOrientation(0);
        linearLayoutC.setGravity(16);
        linearLayoutC.setPadding(this.b.a(20.0f), this.b.a(16.0f), this.b.a(20.0f), this.b.a(16.0f));
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, str));
        linearLayoutC.addView(imageView, new LinearLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = this.b.a(12.0f);
        layoutParams.rightMargin = this.b.a(12.0f);
        linearLayoutC.addView(b(str2), layoutParams);
        final yf yfVar = new yf(this.a, this.b, z);
        yfVar.setListener(new gi() {
            @Override
            public final void a(boolean z2) {
                zf.this.a(giVar, z2);
            }
        });
        linearLayoutC.addView(yfVar, new LinearLayout.LayoutParams(this.b.a(48.0f), this.b.a(26.0f)));
        linearLayoutC.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                zf.a(yfVar, view);
            }
        });
        return linearLayoutC;
    }

    public final void a(gi giVar, boolean z) {
        if (giVar != null) {
            giVar.a(z);
        }
        Runnable runnable = this.b.c;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final LinearLayout a(String str, String str2, String str3, int i, final fi fiVar) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(this.b.a(12.0f), this.b.a(12.0f), this.b.a(12.0f), this.b.a(12.0f));
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageBitmap(hi.a(this.b.a, str));
        linearLayout2.addView(imageView, new LinearLayout.LayoutParams(this.b.a(20.0f), this.b.a(20.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = this.b.a(12.0f);
        linearLayout2.addView(b(str2), layoutParams);
        final TextView textViewA = a();
        textViewA.setText(i + "%");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = this.b.a(12.0f);
        linearLayout2.addView(textViewA, layoutParams2);
        linearLayout.addView(linearLayout2);
        xf xfVar = new xf(this.a, this.b, i);
        xfVar.setListener(new fi() {
            @Override
            public final void a(int i2) {
                zf.a(textViewA, fiVar, i2);
            }
        });
        final hi hiVar = this.b;
        Objects.requireNonNull(hiVar);
        xfVar.setOnReleased(new Runnable() {
            @Override
            public final void run() {
                hiVar.d();
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, this.b.a(31.0f));
        layoutParams3.topMargin = this.b.a(4.0f);
        linearLayout.addView(xfVar, layoutParams3);
        TextView textView = new TextView(this.a);
        textView.setText(str3);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(-7171947);
        textView.setTypeface(hi.f());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = this.b.a(4.0f);
        linearLayout.addView(textView, layoutParams4);
        return linearLayout;
    }

    public static  void a(TextView textView, fi fiVar, int i) {
        textView.setText(i + "%");
        if (fiVar != null) {
            fiVar.a(i);
        }
    }

    public static void a(boolean z, View view) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(z, viewGroup.getChildAt(i));
            }
        }
    }

    public static void a(yf yfVar, View view) {
        if (yfVar.isEnabled()) {
            boolean z = yfVar.f;
            yfVar.f = !z;
            yfVar.a(!z ? 1.0f : 0.0f);
            gi giVar = yfVar.i;
            if (giVar != null) {
                giVar.a(yfVar.f);
            }
        }
    }
}
