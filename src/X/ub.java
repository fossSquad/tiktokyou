package X;

import android.text.Editable;
import android.text.TextWatcher;

public final class ub implements TextWatcher {
    public final Runnable a;

    public ub(Runnable runnable) {
        this.a = runnable;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        this.a.run();
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
