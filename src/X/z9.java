package X;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class z9 extends LayerDrawable {
    public final Drawable a;
    public final y9 b;

    public z9(Drawable drawable, y9 y9Var) {
        super(drawable != null ? new Drawable[]{drawable, y9Var} : new Drawable[]{y9Var});
        this.a = drawable;
        this.b = y9Var;
    }
}
