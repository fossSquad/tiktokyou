package Z;

import android.text.Spanned;
import android.widget.TextView;

public final class oe implements Runnable {
    public final  TextView a;

    public oe(TextView textView) {
        this.a = textView;
    }

    @Override
    public final void run() {
        if (ac.a() != null && ac.e().x) {
            CharSequence text = this.a.getText();
            if (text instanceof Spanned) {
                Spanned spanned = (Spanned) text;
                if (((qe[]) spanned.getSpans(0, spanned.length(), qe.class)).length > 0) {
                    this.a.invalidate();
                    this.a.postDelayed(this, 40L);
                    return;
                }
            }
        }
        re.b.remove(this.a);
    }
}
