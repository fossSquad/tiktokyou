package Z;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import java.util.Locale;

public final class bi extends View {
    public final Paint a;
    public final Paint b;
    public final RectF c;
    public final OverScroller d;
    public final int e;
    public final int f;
    public final float g;
    public final int h;
    public final int i;
    public VelocityTracker j;
    public ai k;
    public float l;
    public float m;
    public float n;
    public boolean o;
    public int p;

    public bi(i0 i0Var, hi hiVar, int i, int i2) {
        super(i0Var);
        Paint paint = new Paint(1);
        this.a = paint;
        Paint paint2 = new Paint(1);
        this.b = paint2;
        this.c = new RectF();
        this.i = i;
        int iA = hiVar.a(37.0f);
        this.e = iA;
        this.f = hiVar.a(8.0f) + iA;
        this.g = hiVar.a(4.0f);
        this.d = new OverScroller(i0Var);
        this.h = ViewConfiguration.get(i0Var).getScaledTouchSlop();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.create("sans-serif-medium", 0));
        paint.setTextSize(TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        paint.setColor(hiVar.e());
        paint2.setColor(hiVar.b ? -13882322 : -657931);
        setValue(i2);
    }

    public final void a(int i) {
        int iMax = Math.max(0, Math.min(this.i - 1, i));
        int iRound = Math.round(this.l);
        this.l = iRound;
        int i2 = (iMax * this.f) - iRound;
        this.d.startScroll(0, iRound, 0, i2, Math.max(220, Math.min(900, (Math.abs(i2) * 60) / this.f)));
    }

    @Override
    public final void computeScroll() {
        int iRound;
        int iRound2;
        if (!this.d.computeScrollOffset()) {
            if ((!this.o || this.j == null) && (iRound = Math.round(this.l / this.f)) != this.p && Math.abs(this.l - (this.f * iRound)) < 1.0f) {
                this.p = iRound;
                ai aiVar = this.k;
                if (aiVar != null) {
                    aiVar.a(iRound);
                    return;
                }
                return;
            }
            return;
        }
        this.l = this.d.getCurrY();
        postInvalidateOnAnimation();
        if (!this.d.isFinished() || (iRound2 = Math.round(this.l / this.f)) == this.p || Math.abs(this.l - (this.f * iRound2)) >= 1.0f) {
            return;
        }
        this.p = iRound2;
        ai aiVar2 = this.k;
        if (aiVar2 != null) {
            aiVar2.a(iRound2);
        }
    }

    public int getSelected() {
        return this.p;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        float f = this.f * 2;
        this.c.set(0.0f, f, getWidth(), this.e + f);
        RectF rectF = this.c;
        float f2 = this.g;
        canvas.drawRoundRect(rectF, f2, f2, this.b);
        float f3 = this.l / this.f;
        double d = f3;
        int iMin = Math.min(this.i - 1, ((int) Math.ceil(d)) + 4);
        float width = getWidth() / 2.0f;
        float fAscent = (this.a.ascent() + this.a.descent()) / 2.0f;
        for (int iMax = Math.max(0, ((int) Math.floor(d)) - 3); iMax <= iMin; iMax++) {
            float f4 = ((iMax + 2) - f3) * this.f;
            if (this.e + f4 >= 0.0f && f4 <= getHeight()) {
                canvas.drawText(String.format(Locale.US, "%02d", Integer.valueOf(iMax)), width, ((this.e / 2.0f) + f4) - fAscent, this.a);
            }
        }
    }

    @Override
    public final void onMeasure(int i, int i2) {
        int i3 = this.e;
        int i4 = (this.f - i3) * 3;
        setMeasuredDimension(View.MeasureSpec.getSize(i), i4 + (i3 * 4));
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
        this.j.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.d.forceFinished(true);
                float y = motionEvent.getY();
                this.m = y;
                this.n = y;
                this.o = false;
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 1:
                if (this.o) {
                    this.j.computeCurrentVelocity(1000);
                    this.d.fling(0, (int) this.l, 0, (int) (-this.j.getYVelocity()), 0, 0, 0, (this.i - 1) * this.f);
                    int finalY = this.d.getFinalY();
                    this.d.forceFinished(true);
                    a(Math.round(finalY / this.f));
                } else {
                    a(this.p + (((int) Math.floor(motionEvent.getY() / this.f)) - 2));
                }
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.j = null;
                }
                postInvalidateOnAnimation();
                return true;
            case 2:
                float y2 = motionEvent.getY();
                if (!this.o && Math.abs(y2 - this.n) > this.h) {
                    this.o = true;
                }
                if (this.o) {
                    this.l = Math.max(0.0f, Math.min((this.i - 1) * this.f, (this.l + this.m) - y2));
                    invalidate();
                }
                this.m = y2;
                return true;
            case 3:
                VelocityTracker velocityTracker2 = this.j;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.j = null;
                }
                a(Math.round(this.l / this.f));
                postInvalidateOnAnimation();
                return true;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public void setListener(ai aiVar) {
        this.k = aiVar;
    }

    public void setValue(int i) {
        this.p = Math.max(0, Math.min(this.i - 1, i));
        this.d.forceFinished(true);
        this.l = this.p * this.f;
        invalidate();
    }
}
