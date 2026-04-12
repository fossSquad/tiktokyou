package X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import java.util.ArrayList;

public final class c0 extends DynamicDrawableSpan {
    public final BitmapDrawable a;
    public final d0 b;

    public c0(BitmapDrawable bitmapDrawable, d0 d0Var) {
        this.a = bitmapDrawable;
        this.b = d0Var;
    }

    @Override
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (k0.a(this.a)) {
            Rect bounds = this.a.getBounds();
            if (bounds.isEmpty()) {
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i6 = fontMetricsInt.descent;
            int iHeight = ((i4 + i6) - ((i6 - fontMetricsInt.ascent) / 2)) - (bounds.height() / 2);
            canvas.save();
            canvas.translate(f, iHeight);
            try {
                this.a.draw(canvas);
            } catch (Throwable th) {
                th.getMessage();
                ArrayList arrayList = q2.a;
            }
            canvas.restore();
        }
    }

    @Override
    public final Drawable getDrawable() {
        return this.a;
    }

    @Override
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (!k0.a(this.a)) {
            return 0;
        }
        Rect bounds = this.a.getBounds();
        if (bounds.isEmpty()) {
            return 0;
        }
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.descent;
            int i4 = fontMetricsInt2.ascent;
            int i5 = bounds.bottom - bounds.top;
            int i6 = (((i3 - i4) / 2) + i4) - (i5 / 2);
            fontMetricsInt.ascent = i6;
            fontMetricsInt.top = i6;
            int i7 = i6 + i5;
            fontMetricsInt.descent = i7;
            fontMetricsInt.bottom = i7;
        }
        return bounds.right;
    }
}
