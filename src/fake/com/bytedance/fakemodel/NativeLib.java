package fake.com.bytedance.fakemodel;

import X.0Bc5;
import android.os.SystemClock;
import com.bytedance.librarian.Librarian;

public class NativeLib {
    static {
        INVOKESTATIC_fake_com_bytedance_fakemodel_NativeLib_com_ss_android_ugc_aweme_lancet_LoadSoLancet_loadLibrary("fakemodel");
    }

    public static void INVOKESTATIC_fake_com_bytedance_fakemodel_NativeLib_com_ss_android_ugc_aweme_lancet_LoadSoLancet_loadLibrary(String str) {
        0Bc5.LIZIZ(str);
        long jUptimeMillis = SystemClock.uptimeMillis();
        Librarian.LJ(str);
        0Bc5.LIZJ(jUptimeMillis, str);
        0Bc5.LIZ(str);
    }

    public native String stringFromJNI();
}
