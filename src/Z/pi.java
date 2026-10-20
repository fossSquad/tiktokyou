package Z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public final class pi extends Drawable {
    public final float a;
    public final float b;
    public final Paint c;
    public final Path d;
    public final RectF e;
    public boolean f;
    public float g;

    public pi(int i, float f, float f2) {
        this.a = f;
        this.b = f2;
        Paint paint = new Paint(1);
        paint.setColor(i);
        this.c = paint;
        this.d = new Path();
        this.e = new RectF();
        this.f = true;
    }

    @Override
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.e.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        if (this.f) {
            this.e.top += this.a;
        } else {
            this.e.bottom -= this.a;
        }
        float fHeight = this.e.height() / 2.0f;
        this.d.reset();
        this.d.addRoundRect(this.e, fHeight, fHeight, Path.Direction.CW);
        float f = bounds.left + this.g;
        float f2 = this.b / 2.0f;
        float f3 = this.a * 0.25f;
        if (this.f) {
            this.d.moveTo(f - f2, this.e.top + 1.0f);
            this.d.lineTo(f - f3, (this.e.top - this.a) + f3);
            Path path = this.d;
            float f4 = this.e.top - this.a;
            path.quadTo(f, f4, f + f3, f3 + f4);
            this.d.lineTo(f + f2, this.e.top + 1.0f);
        } else {
            this.d.moveTo(f - f2, this.e.bottom - 1.0f);
            this.d.lineTo(f - f3, (this.e.bottom + this.a) - f3);
            Path path2 = this.d;
            float f5 = this.e.bottom + this.a;
            path2.quadTo(f, f5, f + f3, f5 - f3);
            this.d.lineTo(f + f2, this.e.bottom - 1.0f);
        }
        this.d.close();
        canvas.drawPath(this.d, this.c);
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void setAlpha(int i) {
        this.c.setAlpha(i);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }
}
