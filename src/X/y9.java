package X;

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

public final class y9 extends Drawable {
    public final Bitmap a;
    public final Bitmap b;
    public final Paint c = new Paint(3);
    public final Paint d = new Paint();
    public final Paint e = new Paint();
    public final Paint f = new Paint();
    public final Matrix g = new Matrix();
    public boolean h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;

    public y9(Bitmap bitmap) {
        this.a = bitmap;
        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            try {
                int iMax = Math.max(1, Math.round((20 * bitmap.getHeight()) / bitmap.getWidth()));
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, 20, iMax, true);
                for (int i = 0; i < 2; i++) {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, Math.max(1, 6), Math.max(1, iMax / 3), true), 20, iMax, true);
                }
                bitmap = bitmapCreateScaledBitmap;
            } catch (Throwable th) {
            }
        }
        this.b = bitmap;
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    public final void draw(Canvas canvas) {
        Bitmap bitmap;
        int i;
        int iSaveLayer;
        float f;
        float f2;
        int i2;
        float f3;
        Canvas canvas2;
        Canvas canvas3 = canvas;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        if (iWidth <= 0 || (bitmap = this.a) == null || bitmap.getWidth() <= 0 || this.a.getHeight() <= 0) {
            return;
        }
        int i3 = bounds.top;
        boolean z = this.h;
        int i4 = i3 + (z ? this.i : 0);
        int iHeight = i3 + (z ? this.j : bounds.height());
        int i5 = iHeight - i4;
        if (i5 <= 0 || iHeight <= bounds.top || i4 >= bounds.bottom) {
            i = iWidth;
        } else {
            int iSave = canvas3.save();
            int i6 = bounds.left;
            canvas3.clipRect(i6, i4, i6 + iWidth, iHeight);
            float f4 = i5;
            int iRound = Math.round(0.03f * f4);
            int iSaveLayer2 = -1;
            if (iRound > 0) {
                int i7 = bounds.left;
                iSaveLayer = canvas3.saveLayer(i7, i4, i7 + iWidth, iHeight, null);
            } else {
                iSaveLayer = -1;
            }
            int i8 = bounds.left;
            Bitmap bitmap2 = this.b;
            if (bitmap2 == null || bitmap2.getWidth() <= 0 || this.b.getHeight() <= 0) {
                f = 2.0f;
            } else {
                float f5 = iWidth;
                f = 2.0f;
                float fMax = Math.max(f5 / this.b.getWidth(), f4 / this.b.getHeight());
                float width = ((f5 - (this.b.getWidth() * fMax)) / 2.0f) + i8;
                float height = ((f4 - (this.b.getHeight() * fMax)) / 2.0f) + i4;
                this.g.setScale(fMax, fMax);
                this.g.postTranslate(width, height);
                canvas3.drawBitmap(this.b, this.g, this.c);
            }
            int i9 = bounds.left;
            int i10 = this.k;
            if (i10 <= 0) {
                i10 = i5;
            }
            float f6 = i10;
            float height2 = f6 / this.a.getHeight();
            float width2 = this.a.getWidth() * height2;
            int i11 = iSaveLayer;
            float f7 = i9;
            float f8 = (iWidth - width2) / f;
            float f9 = f7 + f8;
            int i12 = i4 + i5;
            i = iWidth;
            int i13 = i12 - i10;
            int iRound2 = Math.round(f9);
            int iRound3 = Math.round(f9 + width2);
            int i14 = i5 - i10;
            int iMin = i14 > 0 ? Math.min(Math.round(f6 * 0.18f), i14) : 0;
            int iRound4 = Math.round(f8);
            int iMin2 = iRound4 > 0 ? Math.min(Math.round(width2 * 0.18f), iRound4) : 0;
            boolean z2 = iMin > 0 || iMin2 > 0;
            if (z2) {
                f2 = height2;
                i2 = i12;
                iSaveLayer2 = canvas3.saveLayer(f7, i13, i9 + i, i12, null);
            } else {
                f2 = height2;
                i2 = i12;
            }
            this.g.setScale(f2, f2);
            float f10 = i13;
            this.g.postTranslate(f9, f10);
            canvas3.drawBitmap(this.a, this.g, this.c);
            if (iMin > 0) {
                float f11 = i13 + iMin;
                this.d.setShader(new LinearGradient(0.0f, f10, 0.0f, f11, 0, -16777216, Shader.TileMode.CLAMP));
                f3 = f10;
                canvas3.drawRect(f7, f3, i9 + i, f11, this.d);
            } else {
                f3 = f10;
            }
            if (iMin2 > 0) {
                Paint paint = this.d;
                float f12 = iRound2;
                float f13 = iRound2 + iMin2;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new LinearGradient(f12, 0.0f, f13, 0.0f, 0, -16777216, tileMode));
                float f14 = i2;
                canvas.drawRect(f12, f3, f13, f14, this.d);
                float f15 = iRound3 - iMin2;
                float f16 = iRound3;
                this.d.setShader(new LinearGradient(f15, 0.0f, f16, 0.0f, -16777216, 0, tileMode));
                canvas2 = canvas;
                canvas2.drawRect(f15, f3, f16, f14, this.d);
            } else {
                canvas2 = canvas;
            }
            if (z2) {
                canvas2.restoreToCount(iSaveLayer2);
            }
            int i15 = bounds.left;
            int i16 = this.l ? 0 : 16777215;
            int i17 = (-1728053248) | i16;
            int i18 = 939524096 | i16;
            Paint paint2 = this.f;
            float f17 = i4;
            float f18 = i2;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            paint2.setShader(new LinearGradient(0.0f, f17, 0.0f, f18, new int[]{i17, i18, i18, i17}, new float[]{0.0f, 0.3f, 0.7f, 1.0f}, tileMode2));
            canvas2.drawRect(i15, f17, i15 + i, f18, this.f);
            if (iRound > 0) {
                float f19 = i4 + iRound;
                this.d.setShader(new LinearGradient(0.0f, f17, 0.0f, f19, 0, -16777216, tileMode2));
                int i19 = bounds.left;
                canvas.drawRect(i19, f17, i19 + i, f19, this.d);
                float f20 = iHeight - iRound;
                float f21 = iHeight;
                this.d.setShader(new LinearGradient(0.0f, f20, 0.0f, f21, -16777216, 0, tileMode2));
                int i20 = bounds.left;
                canvas3 = canvas;
                canvas3.drawRect(i20, f20, i20 + i, f21, this.d);
                canvas3.restoreToCount(i11);
            } else {
                canvas3 = canvas;
            }
            canvas3.restoreToCount(iSave);
        }
        if (this.n <= 0 || this.o <= 0) {
            return;
        }
        this.e.setColor(this.m);
        this.e.setAlpha(this.n);
        int i21 = bounds.left;
        int i22 = bounds.top;
        canvas3.drawRect(i21, i22, i21 + i, i22 + this.o, this.e);
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
