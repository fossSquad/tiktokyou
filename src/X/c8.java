package X;

import android.text.Spanned;
import android.widget.TextView;

public final class c8 implements Runnable {
    public final  TextView a;

    public c8(TextView textView) {
        this.a = textView;
    }

    @Override
    public final void run() {
        d7 d7VarA = d7.a();
        if (d7VarA != null && d7VarA.q) {
            CharSequence text = this.a.getText();
            if (text instanceof Spanned) {
                Spanned spanned = (Spanned) text;
                if (((e8[]) spanned.getSpans(0, spanned.length(), e8.class)).length > 0) {
                    this.a.invalidate();
                    this.a.postDelayed(this, 40L);
                    return;
                }
            }
        }
        f8.b.remove(this.a);
    }
}
