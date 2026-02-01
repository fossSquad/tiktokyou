package fake.com.bytedance.ttc2pa.localfiles;

import X.0aDx;
import android.content.Context;
import android.content.SharedPreferences;
import fake.com.bytedance.ttc2pa.utils.Logger;
import fake.d.c;

public final class SharedPreferencesUtils {
    public static final SharedPreferencesUtils INSTANCE = new SharedPreferencesUtils();
    public static final String TAG = "SharedPreferencesUtils";

    public final String loadLocalConfig(Context context, String str) {
        c.b(context, "context");
        c.b(str, "key");
        try {
            return 0aDx.LIZJ(context, 0, "ttc2pa_main_process_config").getString(str, "");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void saveData(Context context, String str, String str2) {
        c.b(context, "context");
        c.b(str, "key");
        c.b(str2, "data");
        Logger.INSTANCE.d(TAG, "data changed, save to sp: ".concat(str2));
        try {
            SharedPreferences.Editor editorEdit = 0aDx.LIZJ(context, 0, "ttc2pa_main_process_config").edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
