package Z;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class oc extends LayerDrawable {
    public final Drawable a;
    public final nc b;

    public oc(Drawable drawable, nc ncVar) {
        super(drawable != null ? new Drawable[]{drawable, ncVar} : new Drawable[]{ncVar});
        this.a = drawable;
        this.b = ncVar;
    }
}
