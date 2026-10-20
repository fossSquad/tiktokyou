package Z;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public final class xf extends View {
    public final Paint a;
    public final RectF b;
    public final hi c;
    public final int d;
    public int e;
    public fi f;
    public Runnable g;

    public xf(sf sfVar, hi hiVar, int i) {
        super(sfVar);
        this.a = new Paint(1);
        this.b = new RectF();
        this.c = hiVar;
        hiVar.getClass();
        this.d = hi.a();
        this.e = Math.max(0, Math.min(100, i));
    }

    public final void a(float f) {
        int iMax;
        float fA = this.c.a(10.0f);
        float fA2 = this.c.a(2.0f);
        float width = (getWidth() - fA) - (fA2 * 2.0f);
        if (width > 0.0f && (iMax = Math.max(0, Math.min(100, Math.round((((f - fA2) - (fA / 2.0f)) / width) * 100.0f)))) != this.e) {
            this.e = iMax;
            invalidate();
            fi fiVar = this.f;
            if (fiVar != null) {
                fiVar.a(this.e);
            }
        }
    }

    @Override
    public final void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight() / 2.0f;
        float fA = this.c.a(10.0f);
        float fA2 = this.c.a(15.0f);
        float fA3 = this.c.a(5.0f);
        float fA4 = this.c.a(2.0f);
        float fA5 = this.c.a(2.0f);
        float f = ((((width - fA) - (fA4 * 2.0f)) * this.e) / 100.0f) + fA4;
        float f2 = f - fA4;
        if (f2 > 0.0f) {
            this.a.setColor(this.d);
            float f3 = fA3 / 2.0f;
            this.b.set(0.0f, height - f3, f2, f3 + height);
            canvas.drawRoundRect(this.b, fA5, fA5, this.a);
        }
        float f4 = fA + f;
        float f5 = fA4 + f4;
        if (f5 < width) {
            this.a.setColor((this.d & 16777215) | 1711276032);
            float f6 = fA3 / 2.0f;
            this.b.set(f5, height - f6, width, f6 + height);
            canvas.drawRoundRect(this.b, fA5, fA5, this.a);
        }
        this.a.setColor(this.d);
        float f7 = fA2 / 2.0f;
        this.b.set(f, height - f7, f4, height + f7);
        canvas.drawRoundRect(this.b, this.c.a(4.0f), this.c.a(4.0f), this.a);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                a(motionEvent.getX());
                return true;
            case 1:
            case 3:
                a(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(false);
                Runnable runnable = this.g;
                if (runnable != null) {
                    runnable.run();
                }
                return true;
            case 2:
                a(motionEvent.getX());
                return true;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public void setListener(fi fiVar) {
        this.f = fiVar;
    }

    public void setOnReleased(Runnable runnable) {
        this.g = runnable;
    }
}
