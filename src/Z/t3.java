package Z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
public final class t3 extends Drawable {
    public final Paint a;
    public final Path b;

    public t3() {
        Paint paint = new Paint(1);
        paint.setColor(-5723992);
        paint.setStyle(Paint.Style.FILL);
        this.a = paint;
        Path path = new Path();
        path.moveTo(7.25591f, 7.25591f);
        path.lineTo(1.30053f, 13.2113f);
        path.cubicTo(1.13782f, 13.374f, 0.87399f, 13.374f, 0.711282f, 13.2113f);
        path.lineTo(0.122032f, 12.622f);
        path.cubicTo(-0.0406766f, 12.4593f, -0.0406766f, 12.1955f, 0.122032f, 12.0328f);
        path.lineTo(5.48816f, 6.66666f);
        path.lineTo(0.122031f, 1.30053f);
        path.cubicTo(-0.0406771f, 1.13782f, -0.0406771f, 0.87399f, 0.122031f, 0.711281f);
        path.lineTo(0.711281f, 0.122031f);
        path.cubicTo(0.87399f, -0.0406771f, 1.13782f, -0.0406771f, 1.30053f, 0.122031f);
        path.lineTo(7.25591f, 6.07741f);
        path.cubicTo(7.58136f, 6.40282f, 7.58136f, 6.93049f, 7.25591f, 7.25591f);
        path.close();
        this.b = path;
    }

    @Override
    public final void draw(Canvas canvas) {
        float fMin = Math.min(getBounds().width() / 20.0f, getBounds().height() / 20.0f);
        float fWidth = ((getBounds().width() - (7.5f * fMin)) / 2.0f) + getBounds().left;
        float fHeight = ((getBounds().height() - (13.3333f * fMin)) / 2.0f) + getBounds().top;
        int iSave = canvas.save();
        canvas.translate(fWidth, fHeight);
        canvas.scale(fMin, fMin);
        canvas.drawPath(this.b, this.a);
        canvas.restoreToCount(iSave);
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void setAlpha(int i) {
        this.a.setAlpha(i);
        invalidateSelf();
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
