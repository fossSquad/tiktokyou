package Z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public final class ce extends Drawable {
    public final Bitmap a;
    public final Paint b = new Paint(3);
    public final Paint c;
    public final Paint d;
    public final Matrix e;
    public ee f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public ce(Bitmap bitmap, ee eeVar) {
        Paint paint = new Paint();
        this.c = paint;
        this.d = new Paint();
        this.e = new Matrix();
        this.a = bitmap;
        this.f = eeVar;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    public final void draw(Canvas canvas) {
        Bitmap bitmap;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        if (iWidth <= 0 || (bitmap = this.a) == null || bitmap.getWidth() <= 0 || this.a.getHeight() <= 0) {
            return;
        }
        int i = bounds.top;
        boolean z = this.g;
        int i2 = i + (z ? this.h : 0);
        int iHeight = i + (z ? this.i : bounds.height());
        int i3 = iHeight - i2;
        if (i3 > 0 && iHeight > bounds.top && i2 < bounds.bottom) {
            int iSave = canvas.save();
            int i4 = bounds.left;
            canvas.clipRect(i4, i2, i4 + iWidth, iHeight);
            int i5 = bounds.left;
            float f = i2;
            int iSaveLayer = canvas.saveLayer(i5, f, i5 + iWidth, iHeight, null);
            int i6 = bounds.left;
            float f2 = iWidth;
            float f3 = i3;
            float fMax = Math.max(f2 / this.a.getWidth(), f3 / this.a.getHeight());
            float width = ((f2 - (this.a.getWidth() * fMax)) / 2.0f) + i6;
            float height = ((f3 - (this.a.getHeight() * fMax)) / 2.0f) + f;
            this.e.setScale(fMax, fMax);
            this.e.postTranslate(width, height);
            canvas.drawBitmap(this.a, this.e, this.b);
            int i7 = bounds.left;
            int i8 = this.f.a << 24;
            Paint paint = this.c;
            float f4 = i2 + i3;
            int[] iArr = {0, i8, i8, 0};
            ee eeVar = this.f;
            paint.setShader(new LinearGradient(0.0f, f, 0.0f, f4, iArr, new float[]{0.0f, eeVar.b, eeVar.c, 1.0f}, Shader.TileMode.CLAMP));
            canvas.drawRect(i7, f, i7 + iWidth, f4, this.c);
            canvas.restoreToCount(iSaveLayer);
            canvas.restoreToCount(iSave);
        }
        if (this.k <= 0 || this.l <= 0) {
            return;
        }
        this.d.setColor(this.j);
        this.d.setAlpha(this.k);
        int i9 = bounds.left;
        int i10 = bounds.top;
        canvas.drawRect(i9, i10, i9 + iWidth, i10 + this.l, this.d);
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void setAlpha(int i) {
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
