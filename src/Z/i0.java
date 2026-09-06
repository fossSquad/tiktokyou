package Z;

import android.content.res.Resources;
public final class i0 extends Resources {
    public final Resources a;

    public i0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = resources;
    }

    @Override
    public final String getString(int i) {
        try {
            return this.a.getString(i);
        } catch (Resources.NotFoundException e) {
            h6.a(6, h6.a("Missing string resource 0x%s", new Object[]{Integer.toHexString(i)}), (Throwable) null);
            return "";
        }
    }

    @Override
    public final CharSequence getText(int i) {
        try {
            return this.a.getText(i);
        } catch (Resources.NotFoundException e) {
            h6.a(6, h6.a("Missing text resource 0x%s", new Object[]{Integer.toHexString(i)}), (Throwable) null);
            return "";
        }
    }

    @Override
    public final CharSequence getText(int i, CharSequence charSequence) {
        try {
            CharSequence text = this.a.getText(i, charSequence);
            if (text == null) {
                return charSequence == null ? "" : charSequence;
            }
            return text;
        } catch (Resources.NotFoundException e) {
            return charSequence == null ? "" : charSequence;
        }
    }
}
