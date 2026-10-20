package Z;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class ze implements TextWatcher {
    public final  EditText a;
    public final  af b;

    public ze(af afVar, EditText editText) {
        this.b = afVar;
        this.a = editText;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        af afVar = this.b;
        if (afVar.p) {
            return;
        }
        afVar.a(editable != null ? editable.toString() : "", this.a);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
