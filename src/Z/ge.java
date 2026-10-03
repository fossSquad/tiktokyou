package Z;

import android.graphics.drawable.GradientDrawable;
import android.widget.EditText;
import android.widget.TextView;

public final class ge {
    public EditText a;
    public TextView b;
    public TextView c;
    public TextView d;
    public Runnable e;
    public Runnable f;
    public int g;
    public int h;
    public float i;
    public int j;
    public int k;

    public final void a(String str) {
        if (str == null) {
            this.b.setText("");
            this.b.setVisibility(4);
            this.a.setTextColor(this.j);
        } else {
            this.b.setText(str);
            this.b.setVisibility(0);
            this.a.setTextColor(this.k);
        }
    }

    public final void a(boolean z) {
        this.c.setEnabled(z);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(z ? this.g : this.h);
        gradientDrawable.setCornerRadius(this.i);
        this.c.setBackground(gradientDrawable);
    }
}
