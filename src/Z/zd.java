package Z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public final class zd extends Drawable {
    public final int a;
    public final float[] b;
    public final Paint c;
    public final Path d;

    public zd(int i, float f, int i2, float[] fArr) {
        this.a = i2;
        this.b = fArr;
        Paint paint = new Paint(1);
        paint.setColor(i);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        this.c = paint;
        this.d = new Path();
    }

    @Override
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float fWidth = bounds.width();
        float fHeight = bounds.height();
        this.d.reset();
        int i = 0;
        while (true) {
            int i2 = i + 1;
            float[] fArr = this.b;
            if (i2 >= fArr.length) {
                canvas.drawPath(this.d, this.c);
                return;
            }
            float f = (fArr[i] * fWidth) + bounds.left;
            float f2 = (fArr[i2] * fHeight) + bounds.top;
            if (i == 0) {
                this.d.moveTo(f, f2);
            } else {
                this.d.lineTo(f, f2);
            }
            i += 2;
        }
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
        this.c.setAlpha(i);
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }
}
