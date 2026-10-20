package Z;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class de extends LayerDrawable {
    public final Drawable a;
    public final ce b;

    public de(Drawable drawable, ce ceVar) {
        super(drawable != null ? new Drawable[]{drawable, ceVar} : new Drawable[]{ceVar});
        this.a = drawable;
        this.b = ceVar;
    }
}
