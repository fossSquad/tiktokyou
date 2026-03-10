package X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import de.robv.android.xposed.XC_MethodHook;
import java.io.InputStream;
import java.util.ArrayList;

class e4 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Context contextB = g1.b();
        if (contextB == null) {
            return;
        }
        try {
            InputStream inputStreamOpen = contextB.getAssets().open("ic_mod_logo_status.png");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (bitmapDecodeStream != null) {
                    int iRound = Math.round(contextB.getResources().getDisplayMetrics().density * 24.0f);
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, iRound, iRound, true);
                    if (bitmapDecodeStream != bitmapCreateScaledBitmap) {
                        bitmapDecodeStream.recycle();
                    }
                    methodHookParam.args[0] = Icon.createWithBitmap(bitmapCreateScaledBitmap);
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
            ArrayList arrayList = g1.a;
        }
    }
}
