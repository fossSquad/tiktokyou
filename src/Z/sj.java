package Z;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

public final class sj extends View {
    public final int a;
    public final float b;
    public final Paint c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public final RectF g;
    public Drawable h;
    public final PorterDuffColorFilter i;
    public final PorterDuffColorFilter j;
    public final int k;
    public final int l;
    public int m;
    public boolean n;

    public sj(u uVar, int i, boolean z) {
        super(uVar);
        Paint paint = new Paint(1);
        this.c = paint;
        Paint paint2 = new Paint(1);
        this.d = paint2;
        Paint paint3 = new Paint(1);
        this.e = paint3;
        Paint paint4 = new Paint(1);
        this.f = paint4;
        this.g = new RectF();
        this.a = i;
        float f = uVar.getResources().getDisplayMetrics().density;
        this.b = f;
        int i2 = z ? -11908532 : -3355444;
        this.l = z ? -12961220 : -3289651;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Style style2 = Paint.Style.FILL;
        paint2.setStyle(style2);
        paint2.setColor(i2);
        paint3.setStyle(style);
        paint3.setColor(i2);
        paint3.setStrokeWidth(f);
        paint3.setPathEffect(new DashPathEffect(new float[]{3.0f * f, f * 2.0f}, 0.0f));
        paint4.setStyle(style2);
        this.k = z ? -13882322 : -723724;
        int i3 = z ? -7434605 : -5723987;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.i = new PorterDuffColorFilter(i3, mode);
        this.j = new PorterDuffColorFilter(-1, mode);
    }

    public final void a(Canvas canvas, float f, float f2, float f3, boolean z) {
        if (z) {
            canvas.drawCircle(f, f2, f3 - (this.e.getStrokeWidth() / 2.0f), this.e);
        } else {
            canvas.drawCircle(f, f2, f3, this.d);
        }
    }

    @Override
    public final void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float width = getWidth();
        float height = getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f4 = this.n ? 2.0f : 1.0f;
        float f5 = this.b;
        float f6 = f4 * f5;
        float f7 = f6 / 2.0f;
        float f8 = (f5 * 16.0f) - f7;
        this.c.setStrokeWidth(f6);
        this.c.setColor(this.n ? this.m : this.l);
        this.g.set(f7, f7, width - f7, height - f7);
        canvas.drawRoundRect(this.g, f8, f8, this.c);
        int i = this.a;
        if (i == 2) {
            float f9 = width / 2.0f;
            float f10 = height / 2.0f;
            float f11 = (this.b * 44.0f) / 2.0f;
            this.g.set(f9 - f11, f10 - f11, f9 + f11, f11 + f10);
            this.f.setColor(this.n ? this.m : this.k);
            RectF rectF = this.g;
            float f12 = this.b * 12.0f;
            canvas.drawRoundRect(rectF, f12, f12, this.f);
            if (this.h != null) {
                int iRound = Math.round(this.b * 10.0f);
                this.h.setColorFilter(this.n ? this.j : this.i);
                this.h.setBounds(Math.round(f9) - iRound, Math.round(f10) - iRound, Math.round(f9) + iRound, Math.round(f10) + iRound);
                this.h.draw(canvas);
                return;
            }
            return;
        }
        int i2 = 0;
        boolean z = i == 1;
        float f13 = width * 0.065f;
        float f14 = height * 0.09f;
        a(canvas, width * 0.16f, f14, f13, z);
        boolean z2 = z;
        if (!z2) {
            float f15 = width * 0.21f;
            float f16 = width * 0.045f;
            a(canvas, width * 0.26f, f14, f15, f16, false);
            a(canvas, width * 0.52f, f14, f15, f16, false);
        }
        float f17 = width * 0.84f;
        a(canvas, f17, f14, f13, false);
        a(canvas, f17, height * 0.36f, f13, z2);
        a(canvas, f17, height * 0.45f, f13, z2);
        a(canvas, f17, height * 0.54f, f13, z2);
        a(canvas, f17, height * 0.8f, f13, z2);
        float f18 = 0.018f * height;
        float f19 = width * 0.1f;
        a(canvas, f19, height * 0.775f, width * 0.41f, f18, z2);
        a(canvas, f19, height * 0.805f, width * 0.29f, f18, z2);
        a(canvas, f19, height * 0.835f, width * 0.4f, f18, false);
        float f20 = f19;
        float f21 = height * 0.915f;
        float f22 = width * 0.035f;
        float[] fArr = z2 ? new float[]{0.23f, 0.5f, 0.77f} : new float[]{0.16f, 0.33f, 0.5f, 0.67f, 0.84f};
        while (i2 < fArr.length) {
            float f23 = width * fArr[i2];
            if (z2 || i2 != 2) {
                float f24 = f21;
                float f25 = f22;
                a(canvas, f23, f24, f25, false);
                f = f24;
                f2 = f25;
                float f26 = f20;
                a(canvas, f23 - (f20 / 2.0f), (f2 * 1.9f) + f, f26, height * 0.008f, false);
                f3 = f26;
            } else {
                float f27 = width * 0.14f;
                a(canvas, f23 - (f27 / 2.0f), (0.6f * f22) + f21, f27, f22 * 1.6f, false);
                f3 = f20;
                f = f21;
                f2 = f22;
            }
            i2++;
            f20 = f3;
            f21 = f;
            f22 = f2;
        }
    }

    @Override
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, Math.round(size * 1.78f));
    }

    public void setCenterIcon(Drawable drawable) {
        this.h = drawable;
        invalidate();
    }

    public final void a(Canvas canvas, float f, float f2, float f3, float f4, boolean z) {
        float f5 = f4 / 2.0f;
        this.g.set(f, f2 - f5, f3 + f, f2 + f5);
        if (z) {
            canvas.drawRoundRect(this.g, f5, f5, this.e);
        } else {
            canvas.drawRoundRect(this.g, f5, f5, this.d);
        }
    }
}
