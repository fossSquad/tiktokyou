package Z;

import android.text.Editable;
import android.text.TextWatcher;

public final class dc implements TextWatcher {
    public final  ec a;

    public dc(ec ecVar) {
        this.a = ecVar;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        ec ecVar = this.a;
        boolean z = ecVar.b.getText().length() == 0;
        ecVar.b.setTextSize(2, z ? 14.0f : 16.0f);
        ecVar.b.setTypeface(z ? fc.b() : fc.f());
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
