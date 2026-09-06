package Z;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public final class f5 implements TextWatcher {
    public final  TextView a;

    public f5(TextView textView) {
        this.a = textView;
    }

    @Override
    public final void afterTextChanged(Editable editable) {
        this.a.setVisibility(editable.toString().trim().length() > 0 ? 0 : 8);
    }

    @Override
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
