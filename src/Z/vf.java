package Z;

import android.view.MotionEvent;
import android.widget.ScrollView;

public final class vf extends ScrollView {
    public float a;
    public float b;
    public boolean c;
    public final  wf d;

    public vf(wf wfVar, sf sfVar) {
        super(sfVar);
        this.d = wfVar;
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.d.g.get()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.a = motionEvent.getY();
            this.c = false;
        } else if (motionEvent.getActionMasked() == 2 && getScrollY() <= 0 && motionEvent.getY() - this.a > this.d.b.a(12.0f)) {
            this.c = true;
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d.g.get() && !this.c) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            if (this.c) {
                this.c = false;
                if (this.b >= this.d.b.a(72.0f)) {
                    this.d.b();
                } else if (!this.d.g.get()) {
                    this.b = 0.0f;
                    this.d.f();
                }
                this.b = 0.0f;
                return true;
            }
        } else if (actionMasked == 2) {
            if (!this.c && getScrollY() <= 0 && motionEvent.getY() - this.a > this.d.b.a(12.0f)) {
                this.c = true;
            }
            if (this.c) {
                float fMin = Math.min(Math.max(0.0f, (motionEvent.getY() - this.a) * 0.45f), this.d.b.a(120.0f));
                this.b = fMin;
                this.d.a(fMin);
                return true;
            }
        } else if (actionMasked == 3) {
            if (this.c) {
                this.c = false;
                if (this.b >= this.d.b.a(72.0f)) {
                    this.d.b();
                } else if (!this.d.g.get()) {
                    this.b = 0.0f;
                    this.d.f();
                }
                this.b = 0.0f;
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
