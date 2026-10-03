package Z;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

public final class j0 extends ContextWrapper {
    public final i0 a;

    public j0(Context context) {
        super(context);
        Resources resources = context.getResources();
        this.a = new i0(resources);
    }

    @Override
    public final Resources getResources() {
        return this.a;
    }
}
