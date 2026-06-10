package X;

import android.graphics.PorterDuff;
import android.widget.ImageView;

public final class d8 implements Runnable {
    public final  ImageView a;

    public d8(ImageView imageView) {
        this.a = imageView;
    }

    @Override
    public final void run() {
        d7 d7VarA = d7.a();
        if (d7VarA == null || !d7VarA.q || !f8.a(this.a)) {
            this.a.clearColorFilter();
            f8.c.remove(this.a);
            return;
        }
        ImageView imageView = this.a;
        float fCurrentTimeMillis = (System.currentTimeMillis() % 1800) / 1800.0f;
        int[] iArr = f8.a;
        float f = fCurrentTimeMillis * 5;
        int iMin = Math.min(4, (int) f);
        float f2 = f - iMin;
        int i = iArr[iMin];
        int i2 = iArr[iMin + 1];
        int i3 = (i >>> 24) & 255;
        int i4 = (i >>> 16) & 255;
        int i5 = (i >>> 8) & 255;
        int i6 = i & 255;
        imageView.setColorFilter(Math.round((((i2 & 255) - i6) * f2) + i6) | (Math.round(((((i2 >>> 24) & 255) - i3) * f2) + i3) << 24) | (Math.round(((((i2 >>> 16) & 255) - i4) * f2) + i4) << 16) | (Math.round(((((i2 >>> 8) & 255) - i5) * f2) + i5) << 8), PorterDuff.Mode.SRC_IN);
        this.a.invalidate();
        this.a.postDelayed(this, 40L);
    }
}
