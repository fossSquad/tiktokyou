package Z;

import android.widget.SeekBar;
import android.widget.TextView;

public final class fe implements SeekBar.OnSeekBarChangeListener {
    public final  TextView a;
    public final  ie b;
    public final  le c;

    public fe(le leVar, TextView textView, ie ieVar) {
        this.c = leVar;
        this.a = textView;
        this.b = ieVar;
    }

    @Override
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        ie ieVar;
        this.a.setText(i + "%");
        if (!z || (ieVar = this.b) == null) {
            return;
        }
        ieVar.a(i);
        this.c.C();
    }

    @Override
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
