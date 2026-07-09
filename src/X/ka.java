package X;

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
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public abstract class ka {
    public static Bitmap a(BaseActivity baseActivity, String str) {
        try {
            InputStream inputStreamOpen = baseActivity.getAssets().open(str);
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

    public static Drawable a(BaseActivity baseActivity, ia iaVar, int i) {
        String str;
        if (iaVar == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(Color.parseColor("#444444"));
            gradientDrawable.setSize(i, i);
            return gradientDrawable;
        }
        String str2 = iaVar.c;
        Bitmap bitmapA = null;
        Bitmap bitmapA2 = d1$$ExternalSyntheticBackport0.m(str2) ? null : a(baseActivity, "mod_icons/flags_new/ic_flag_" + str2.toLowerCase(Locale.ROOT) + ".png");
        if (bitmapA2 != null) {
            bitmapA = bitmapA2;
        } else {
            String str3 = iaVar.a;
            if (!d1$$ExternalSyntheticBackport0.m(str3)) {
                switch (str3) {
                    case "region_usa":
                        str = "ic_flag_usa";
                        break;
                    case "region_poland":
                        str = "ic_flag_poland";
                        break;
                    case "region_egypt":
                        str = "ic_flag_egypt";
                        break;
                    case "region_finland":
                        str = "ic_flag_finland";
                        break;
                    case "region_ukraine":
                        str = "ic_flag_ukraine";
                        break;
                    case "region_belarus":
                        str = "ic_flag_belarus";
                        break;
                    case "region_kazakhstan":
                        str = "ic_flag_kazakhstan";
                        break;
                    default:
                        str = null;
                        break;
                }
                if (str != null) {
                    bitmapA = a(baseActivity, "mod_icons/" + str + ".png");
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
