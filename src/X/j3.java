package X;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class j3 implements TextWatcher {
    public final  EditText a;
    public final  k3 b;

    public j3(k3 k3Var, EditText editText) {
        this.b = k3Var;
        this.a = editText;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        k3 k3Var = this.b;
        if (k3Var.p) {
            return;
        }
        k3Var.a(editable != null ? editable.toString() : "", this.a);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
