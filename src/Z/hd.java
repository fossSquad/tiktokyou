package Z;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.ies.foundation.activity.BaseActivity;
import com.windukk.stable.ResourceOverlay;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public abstract class hd {
    public static Bitmap a(BaseActivity baseActivity, String str) {
        try {
            InputStream inputStreamOpen = ResourceOverlay.open(baseActivity, str);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return bitmapDecodeStream;
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
        } catch (IOException e) {
            return null;
        }
    }

    public static Drawable a(BaseActivity baseActivity, ed edVar, int i) {
        String strDecrypt;
        if (edVar == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(Color.parseColor("#444444"));
            gradientDrawable.setSize(i, i);
            return gradientDrawable;
        }
        String str = edVar.d;
        Bitmap bitmapA = null;
        Bitmap bitmapA2 = hd$$ExternalSyntheticBackport0.m(str) ? null : a(baseActivity, "mod_icons/flags_new/ic_flag_" + str.toLowerCase(Locale.ROOT) + ".png");
        if (bitmapA2 != null) {
            bitmapA = bitmapA2;
        } else {
            String str2 = edVar.b;
            if (!hd$$ExternalSyntheticBackport0.m(str2)) {
                switch (str2.hashCode()) {
                    case -1990164040:
                        strDecrypt = !str2.equals("region_usa") ? null : "ic_flag_usa";
                        break;
                    case -1394777067:
                        strDecrypt = !str2.equals("region_poland") ? null : "ic_flag_poland";
                        break;
                    case -1302302896:
                        strDecrypt = !str2.equals("region_egypt") ? null : "ic_flag_egypt";
                        break;
                    case -743130581:
                        strDecrypt = !str2.equals("region_finland") ? null : "ic_flag_finland";
                        break;
                    case -254844880:
                        strDecrypt = !str2.equals("region_ukraine") ? null : "ic_flag_ukraine";
                        break;
                    case -114852787:
                        strDecrypt = !str2.equals("region_belarus") ? null : "ic_flag_belarus";
                        break;
                    case 1093032083:
                        strDecrypt = !str2.equals("region_kazakhstan") ? null : "ic_flag_kazakhstan";
                        break;
                    default:
                        strDecrypt = null;
                        break;
                }
                if (strDecrypt != null) {
                    bitmapA = a(baseActivity, new StringBuilder().append("mod_icons/").append(strDecrypt).append(".png").toString());
                }
            }
        }
        if (bitmapA == null) {
            bitmapA = a(baseActivity, "mod_icons/ic_flag_custom.png");
        }
        if (bitmapA == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(Color.parseColor("#444444"));
            gradientDrawable2.setSize(i, i);
            return gradientDrawable2;
        }
        Resources resources = baseActivity.getResources();
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA, i, i, true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        float f = i / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
        return new BitmapDrawable(resources, bitmapCreateBitmap);
    }
}
