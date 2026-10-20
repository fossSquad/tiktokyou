package Z;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
public final class uf extends ClickableSpan {
    public final  int a;
    public final  wf b;

    public uf(wf wfVar, int i) {
        this.b = wfVar;
        this.a = i;
    }

    @Override
    public final void onClick(View view) {
        try {
            this.b.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://tiktokyou.ru/legal.html")));
        } catch (Throwable th) {
        }
    }

    @Override
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.a);
    }
}
