package Z;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.View;

public final class z6 extends View {
    public static final int[] k = {-32616, -53161, -3601089};
    public static final float[] l = {0.0f, 0.42f, 1.0f};
    public static final int[] m = {-2130720042, 1224700041, 16724055};
    public static final float[] n = {0.0f, 0.42f, 1.0f};
    public final int[] a;
    public final int[] b;
    public final Paint c;
    public final Paint d;
    public final Matrix e;
    public float f;
    public float g;
    public final y6 h;
    public boolean i;
    public long j;

    public z6(sf sfVar, int i) {
        super(sfVar);
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = new Matrix();
        this.h = new y6(this);
        setWillNotDraw(false);
        this.a = a(k, i);
        this.b = a(m, i);
    }

    public static int[] a(int[] iArr, int i) {
        float f;
        if ((i | (-16777216)) == -119980) {
            return iArr;
        }
        float[] fArrA = a(-119980);
        float[] fArrA2 = a(i);
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float[] fArrA3 = a(iArr[i2]);
            float f2 = (((fArrA2[0] + fArrA3[0]) - fArrA[0]) + 360.0f) % 360.0f;
            float f3 = fArrA[1];
            float f4 = 0.0f;
            float fMax = f3 > 0.0f ? Math.max(0.0f, Math.min(1.0f, (fArrA2[1] * fArrA3[1]) / f3)) : fArrA2[1];
            float fMax2 = Math.max(0.04f, Math.min(0.97f, (fArrA2[2] + fArrA3[2]) - fArrA[2]));
            int i3 = iArr[i2] & (-16777216);
            float fAbs = (1.0f - Math.abs((fMax2 * 2.0f) - 1.0f)) * fMax;
            float fAbs2 = (1.0f - Math.abs(((f2 / 60.0f) % 2.0f) - 1.0f)) * fAbs;
            float f5 = fMax2 - (fAbs / 2.0f);
            if (f2 < 60.0f) {
                fAbs2 = 0.0f;
                f4 = fAbs;
                fAbs = fAbs2;
            } else {
                if (f2 < 120.0f) {
                    f = fAbs2;
                    fAbs2 = 0.0f;
                } else if (f2 >= 180.0f) {
                    if (f2 < 240.0f) {
                        f = fAbs;
                        fAbs = fAbs2;
                    } else {
                        f = fAbs;
                        fAbs = 0.0f;
                        f4 = f2 < 300.0f ? fAbs2 : 0.0f;
                    }
                    fAbs2 = f;
                }
                f4 = f;
            }
            iArr2[i2] = Math.round((fAbs2 + f5) * 255.0f) | (Math.round((f4 + f5) * 255.0f) << 16) | (Math.round((fAbs + f5) * 255.0f) << 8) | i3;
        }
        return iArr2;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = SystemClock.uptimeMillis();
        a();
    }

    @Override
    public final void onDetachedFromWindow() {
        this.i = false;
        removeCallbacks(this.h);
        super.onDetachedFromWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        Shader shader = this.c.getShader();
        Shader shader2 = this.d.getShader();
        if (width <= 0 || height <= 0 || shader == null || shader2 == null) {
            return;
        }
        float fUptimeMillis = (SystemClock.uptimeMillis() - this.j) * 3.926991E-4f;
        float f = width;
        float fSin = ((float) Math.sin(fUptimeMillis)) * f * 0.07f;
        float f2 = height;
        float fCos = ((float) Math.cos(0.65f * fUptimeMillis)) * f2 * 0.025f;
        float fSin2 = (((float) Math.sin(fUptimeMillis * 1.4f)) * 0.06f) + 0.94f;
        this.e.setTranslate(0.0f, -fCos);
        shader.setLocalMatrix(this.e);
        float f3 = 1.0f / fSin2;
        this.e.setScale(f3, f3);
        Matrix matrix = this.e;
        float f4 = this.f;
        float f5 = f4 - ((fSin + f4) * f3);
        float f6 = this.g;
        matrix.postTranslate(f5, f6 - ((fCos + f6) * f3));
        shader2.setLocalMatrix(this.e);
        canvas.drawRect(0.0f, 0.0f, f, f2, this.c);
        canvas.drawRect(0.0f, 0.0f, f, f2, this.d);
    }

    @Override
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        Paint paint = this.c;
        float f = i2;
        int[] iArr = this.a;
        float[] fArr = l;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f, iArr, fArr, tileMode));
        float f2 = i;
        this.f = 0.5f * f2;
        this.g = 0.14f * f;
        this.d.setShader(new RadialGradient(this.f, this.g, Math.max(1.0f, Math.max(f2, f * 0.48f) * 0.72f), this.b, n, tileMode));
    }

    @Override
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            a();
        } else {
            this.i = false;
            removeCallbacks(this.h);
        }
    }

    @Override
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            a();
        } else {
            this.i = false;
            removeCallbacks(this.h);
        }
    }

    public static float[] a(int i) {
        float f;
        float f2 = ((i >> 16) & 255) / 255.0f;
        float f3 = ((i >> 8) & 255) / 255.0f;
        float f4 = (i & 255) / 255.0f;
        float fMax = Math.max(f2, Math.max(f3, f4));
        float fMin = Math.min(f2, Math.min(f3, f4));
        float f5 = fMax - fMin;
        float f6 = (fMin + fMax) / 2.0f;
        if (f5 == 0.0f) {
            return new float[]{0.0f, 0.0f, f6};
        }
        float fAbs = f5 / (1.0f - Math.abs((f6 * 2.0f) - 1.0f));
        if (fMax == f2) {
            f = ((f3 - f4) / f5) % 6.0f;
        } else {
            f = fMax == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
        }
        float f7 = f * 60.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        return new float[]{f7, fAbs, f6};
    }

    public final void a() {
        if (!this.i && isAttachedToWindow() && getVisibility() == 0 && getWindowVisibility() == 0) {
            this.i = true;
            postOnAnimation(this.h);
        }
    }
}
