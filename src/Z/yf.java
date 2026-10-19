package Z;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public final class yf extends View {
    public final Paint a;
    public final RectF b;
    public final int c;
    public final int d;
    public final int e;
    public boolean f;
    public float g;
    public ValueAnimator h;
    public gi i;

    public yf(sf sfVar, hi hiVar, boolean z) {
        super(sfVar);
        this.a = new Paint(1);
        this.b = new RectF();
        hiVar.getClass();
        this.c = hi.a();
        this.d = hiVar.b ? -12961220 : -1842202;
        this.e = hiVar.a(3.0f);
        this.f = z;
        this.g = z ? 1.0f : 0.0f;
        setClickable(true);
        setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
    }

    public final void a(View view) {
        if (isEnabled()) {
            boolean z = this.f;
            this.f = !z;
            a(!z ? 1.0f : 0.0f);
            gi giVar = this.i;
            if (giVar != null) {
                giVar.a(this.f);
            }
        }
    }

    @Override
    public final void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        float f = height / 2.0f;
        Paint paint = this.a;
        int i = this.d;
        int i2 = this.c;
        float f2 = this.g;
        paint.setColor(Color.argb((int) (((Color.alpha(i2) - Color.alpha(i)) * f2) + Color.alpha(i)), (int) (((Color.red(i2) - Color.red(i)) * f2) + Color.red(i)), (int) (((Color.green(i2) - Color.green(i)) * f2) + Color.green(i)), (int) (((Color.blue(i2) - Color.blue(i)) * f2) + Color.blue(i))));
        this.b.set(0.0f, 0.0f, width, height);
        canvas.drawRoundRect(this.b, f, f, this.a);
        float f3 = this.e;
        float f4 = f - f3;
        float f5 = f3 + f4;
        this.a.setColor(-1);
        canvas.drawCircle(((((width - f3) - f4) - f5) * this.g) + f5, f, f4, this.a);
    }

    public void setListener(gi giVar) {
        this.i = giVar;
    }

    public final void a(float f) {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.g, f);
        this.h = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(180L);
        this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.a(valueAnimator2);
            }
        });
        this.h.start();
    }

    public final  void a(ValueAnimator valueAnimator) {
        this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }
}
