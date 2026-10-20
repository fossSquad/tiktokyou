package Z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public final class w extends Drawable {
    public final Paint a;
    public final int b;

    public w(int i, int i2) {
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = i2;
        paint.setColor(i);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(i2 * 2.0f);
    }

    @Override
    public final void draw(Canvas canvas) {
        float f = getBounds().left;
        float f2 = getBounds().top;
        for (int i = 0; i < 3; i++) {
            int i2 = this.b;
            float f3 = f2 + (((i * 6) + 2) * i2);
            canvas.drawCircle((i2 * 2) + f, f3, i2 * 1.3f, this.a);
            int i3 = this.b;
            canvas.drawLine(f + (i3 * 7), f3, f + (i3 * 21), f3, this.a);
        }
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.b * 16;
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.b * 22;
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
