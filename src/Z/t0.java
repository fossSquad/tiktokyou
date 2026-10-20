package Z;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
public final class t0 extends ContextWrapper {
    public final s0 a;

    public t0(Context context) {
        super(context);
        Resources resources = context.getResources();
        this.a = new s0(resources);
    }

    @Override
    public final Resources getResources() {
        return this.a;
    }
}
