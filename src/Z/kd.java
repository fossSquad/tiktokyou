package Z;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class kd implements TextWatcher {
    public final  EditText a;
    public final  ld b;

    public kd(ld ldVar, EditText editText) {
        this.b = ldVar;
        this.a = editText;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        ld ldVar = this.b;
        if (ldVar.p) {
            return;
        }
        ldVar.a(editable != null ? editable.toString() : "", this.a);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
