package X;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class wa implements TextWatcher {
    public final  EditText a;
    public final  xa b;

    public wa(xa xaVar, EditText editText) {
        this.b = xaVar;
        this.a = editText;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        xa xaVar = this.b;
        if (xaVar.p) {
            return;
        }
        xaVar.a(editable != null ? editable.toString() : "", this.a);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
