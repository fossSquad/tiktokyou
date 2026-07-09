package X;

import android.text.Spanned;
import android.widget.TextView;

public final class da implements Runnable {
    public final  TextView a;

    public da(TextView textView) {
        this.a = textView;
    }

    @Override
    public final void run() {
        l8 l8VarA = l8.a();
        if (l8VarA != null && l8VarA.r) {
            CharSequence text = this.a.getText();
            if (text instanceof Spanned) {
                Spanned spanned = (Spanned) text;
                if (((fa[]) spanned.getSpans(0, spanned.length(), fa.class)).length > 0) {
                    this.a.invalidate();
                    this.a.postDelayed(this, 40L);
                    return;
                }
            }
        }
        ga.b.remove(this.a);
    }
}
