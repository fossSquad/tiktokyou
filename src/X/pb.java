package X;

import android.widget.SeekBar;
import android.widget.TextView;

public final class pb implements SeekBar.OnSeekBarChangeListener {
    public final  TextView a;
    public final  sb b;
    public final  vb c;

    public pb(vb vbVar, TextView textView, sb sbVar) {
        this.c = vbVar;
        this.a = textView;
        this.b = sbVar;
    }

    @Override
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        sb sbVar;
        this.a.setText(i + "%");
        if (!z || (sbVar = this.b) == null) {
            return;
        }
        sbVar.a(i);
        this.c.s();
    }

    @Override
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
