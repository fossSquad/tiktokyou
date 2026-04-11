package X;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class i3 implements TextWatcher {
    public final  EditText a;
    public final  j3 b;

    public i3(j3 j3Var, EditText editText) {
        this.b = j3Var;
        this.a = editText;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        j3 j3Var = this.b;
        if (j3Var.p) {
            return;
        }
        j3Var.a(editable != null ? editable.toString() : "", this.a);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
