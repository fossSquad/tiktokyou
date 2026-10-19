package Z;

import android.graphics.Typeface;
import android.widget.TextView;
import com.vapro.vae.stringfog.StringFogRuntime;

public abstract  class x5 {
    public static void a(String str, String str2, String str3, int i, TextView textView) {
        textView.setTypeface(Typeface.create(StringFogRuntime.decrypt(str, str2, str3), i));
    }
}
