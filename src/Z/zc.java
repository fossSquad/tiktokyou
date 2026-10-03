package Z;

import android.text.Spanned;
import android.widget.TextView;

public final class zc implements Runnable {
    public final  TextView a;

    public zc(TextView textView) {
        this.a = textView;
    }

    @Override
    public final void run() {
        if (ta.a() != null && ta.d().s) {
            CharSequence text = this.a.getText();
            if (text instanceof Spanned) {
                Spanned spanned = (Spanned) text;
                if (((bd[]) spanned.getSpans(0, spanned.length(), bd.class)).length > 0) {
                    this.a.invalidate();
                    this.a.postDelayed(this, 40L);
                    return;
                }
            }
        }
        cd.b.remove(this.a);
    }
}
