package Z;

import Z.h6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import com.windukk.stable.ResourceOverlay;
import java.io.InputStream;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.CloseableKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$1", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SettingsHooks$before$3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Context contextA = Main.getApplicationContext();
            try {
                InputStream inputStreamOpen = ResourceOverlay.open(contextA, "ic_mod_logo_status.png");
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (bitmapDecodeStream != null) {
                        int iRound = Math.round(contextA.getResources().getDisplayMetrics().density * 24.0f);
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, iRound, iRound, true);
                        if (bitmapDecodeStream != bitmapCreateScaledBitmap) {
                            bitmapDecodeStream.recycle();
                        }
                        hookMethodParam.args[0] = Icon.createWithBitmap(bitmapCreateScaledBitmap);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStreamOpen, (Throwable) null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpen, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                h6.a(6, h6.a("Error setting small icon", new Object[0]), th3);
            }
        } catch (Throwable th4) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th4);
        }
    }
}
