package Z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public final class g3 extends Drawable {
    public final int a;
    public final Paint b;

    public g3(float f, int i) {
        this.a = i;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.b = paint;
    }

    @Override
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float fWidth = bounds.width() * 0.2f;
        float f = bounds.left + fWidth;
        float f2 = bounds.top + fWidth;
        float f3 = bounds.right - fWidth;
        float f4 = bounds.bottom - fWidth;
        canvas.drawLine(f, f2, f3, f4, this.b);
        canvas.drawLine(f3, f2, f, f4, this.b);
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.a;
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.a;
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
