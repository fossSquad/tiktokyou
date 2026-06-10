package X;

import android.widget.SeekBar;
import android.widget.TextView;

public final class n9 implements SeekBar.OnSeekBarChangeListener {
    public final  TextView a;
    public final  o9 b;
    public final  q9 c;

    public n9(q9 q9Var, TextView textView, o9 o9Var) {
        this.c = q9Var;
        this.a = textView;
        this.b = o9Var;
    }

    @Override
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        o9 o9Var;
        this.a.setText(i + "%");
        if (!z || (o9Var = this.b) == null) {
            return;
        }
        o9Var.a(i);
        this.c.m();
    }

    @Override
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
