package Z;

import android.widget.TextView;
import com.vapro.vae.stringfog.StringFogRuntime;

public abstract  class c5 {
    public static void a(String str, String str2, String str3, TextView textView) {
        textView.setText(l6.a(StringFogRuntime.decrypt(str, str2, str3)));
    }
}
