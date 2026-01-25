package fake.com.bytedance.fakemodel;

import X.07M4;
import android.os.SystemClock;
import com.bytedance.librarian.Librarian;

public class NativeLib {
    static {
        INVOKESTATIC_fake_com_bytedance_fakemodel_NativeLib_com_ss_android_ugc_aweme_lancet_LoadSoLancet_loadLibrary("fakemodel");
    }

    public native String stringFromJNI();

    public static void INVOKESTATIC_fake_com_bytedance_fakemodel_NativeLib_com_ss_android_ugc_aweme_lancet_LoadSoLancet_loadLibrary(String str) {
        07M4.LIZIZ(str);
        long jUptimeMillis = SystemClock.uptimeMillis();
        Librarian.LJ(str);
        07M4.LIZJ(jUptimeMillis, str);
        07M4.LIZ(str);
    }
}
