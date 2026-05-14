package X;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class t4 implements TextWatcher {
    public final  EditText a;
    public final  u4 b;

    public t4(u4 u4Var, EditText editText) {
        this.b = u4Var;
        this.a = editText;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        u4 u4Var = this.b;
        if (u4Var.p) {
            return;
        }
        u4Var.a(editable != null ? editable.toString() : "", this.a);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
