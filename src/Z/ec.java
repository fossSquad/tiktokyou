package Z;

import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.windukk.mod.Main;

public final class ec {
    public final LinearLayout a;
    public final EditText b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public LinearLayout f;
    public final  fc g;

    public ec(fc fcVar) {
        this.g = fcVar;
        LinearLayout linearLayout = new LinearLayout(fcVar.a);
        this.a = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = fcVar.g;
        float fA = Main.dp(16.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(fA);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setPadding(Main.dp(16.0f), 0, Main.dp(16.0f), 0);
        linearLayout.setMinimumHeight(Main.dp(48.0f));
        fc.a(linearLayout, 12);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        EditText editText = new EditText(fcVar.a);
        this.b = editText;
        editText.setBackground(null);
        editText.setPadding(0, Main.dp(14.0f), 0, Main.dp(14.0f));
        editText.setTextSize(2, 16.0f);
        editText.setTypeface(fc.f());
        editText.setTextColor(fcVar.h);
        editText.setHintTextColor(fcVar.j);
        editText.setSingleLine(true);
        editText.setIncludeFontPadding(false);
        editText.setInputType(1);
        fcVar.a(editText);
        linearLayout.addView(editText, fc.h());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
    }

    public final  void a(View view) {
        a();
    }

    public final LinearLayout b() {
        if (this.f == null) {
            LinearLayout linearLayoutA = this.g.a(12);
            this.f = linearLayoutA;
            linearLayoutA.addView(this.a);
            fc fcVar = this.g;
            TextView textViewA = fcVar.a(14.0f, false, fcVar.e);
            textViewA.setGravity(17);
            textViewA.setText(" ");
            this.e = textViewA;
            textViewA.setVisibility(4);
            LinearLayout linearLayout = this.f;
            TextView textView = this.e;
            this.g.getClass();
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        }
        return this.f;
    }

    public final void a(String str, final Runnable runnable) {
        if (this.d == null) {
            fc fcVar = this.g;
            ImageView imageViewA = fcVar.a(fcVar.k, str);
            this.d = imageViewA;
            imageViewA.setPadding(0, 0, 0, 0);
            this.a.addView(this.d, new LinearLayout.LayoutParams(Main.dp(20.0f), Main.dp(20.0f)));
        }
        BitmapDrawable bitmapDrawableA = this.g.a(str);
        if (bitmapDrawableA != null) {
            bitmapDrawableA.setColorFilter(this.g.k, PorterDuff.Mode.SRC_IN);
        }
        this.d.setImageDrawable(bitmapDrawableA);
        this.d.setOnClickListener(runnable == null ? null : new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                runnable.run();
            }
        });
    }

    public final void a() {
        this.b.requestFocus();
        EditText editText = this.b;
        editText.setSelection(editText.getText().length());
        InputMethodManager inputMethodManager = (InputMethodManager) this.g.a.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.b, 1);
        }
    }
}
