package X;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class i3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = l3.b;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            threadLocal.set(Boolean.FALSE);
            Uri uri = (Uri) hookMethodParam.getResult();
            if (uri != null) {
                ((ConcurrentHashMap.KeySetView) l3.a).add(uri.toString());
                int i = g5.a;
            }
        }
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Uri uri;
        try {
            ContentValues contentValues = (ContentValues) hookMethodParam.args[1];
            if (contentValues == null) {
                return;
            }
            l3.b(contentValues);
            if (l3.a(contentValues)) {
                Object[] objArr = hookMethodParam.args;
                Object obj = objArr[0];
                if (obj instanceof Uri) {
                    String string = ((Uri) obj).toString();
                    if (string != null) {
                        String strReplace = string.replace("/video/media", "/audio/media");
                        if (strReplace.equals(string)) {
                            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                            int i = g5.a;
                        } else {
                            uri = Uri.parse(strReplace);
                            int i2 = g5.a;
                        }
                    } else {
                        uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        int i3 = g5.a;
                    }
                    objArr[0] = uri;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            int i4 = g5.a;
        }
    }
}
