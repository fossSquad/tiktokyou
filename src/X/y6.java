package X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import com.windukk.hook.HookMethod;
import java.io.InputStream;

class y6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context contextC = v3.c();
        if (contextC == null) {
            return;
        }
        try {
            InputStream inputStreamOpen = contextC.getAssets().open("ic_mod_logo_status.png");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (bitmapDecodeStream != null) {
                    int iRound = Math.round(contextC.getResources().getDisplayMetrics().density * 24.0f);
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, iRound, iRound, true);
                    if (bitmapDecodeStream != bitmapCreateScaledBitmap) {
                        bitmapDecodeStream.recycle();
                    }
                    hookMethodParam.args[0] = Icon.createWithBitmap(bitmapCreateScaledBitmap);
                }
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            e.getMessage();
            int i = v3.a;
        }
    }
}
