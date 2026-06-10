package X;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class v8 implements TextWatcher {
    public final  EditText a;
    public final  w8 b;

    public v8(w8 w8Var, EditText editText) {
        this.b = w8Var;
        this.a = editText;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        w8 w8Var = this.b;
        if (w8Var.p) {
            return;
        }
        w8Var.a(editable != null ? editable.toString() : "", this.a);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
