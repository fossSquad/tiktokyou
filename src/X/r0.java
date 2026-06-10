package X;

import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public final class r0 extends ClickableSpan {
    public final  Context a;
    public final  int b;

    public r0(Activity activity, int i) {
        this.a = activity;
        this.b = i;
    }

    @Override
    public final void onClick(View view) {
        a1.c(this.a);
    }

    @Override
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.b);
        textPaint.setUnderlineText(false);
    }
}
