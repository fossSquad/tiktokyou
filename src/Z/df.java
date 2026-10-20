package Z;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.windukk.hook.HookBridge;
import java.io.OutputStream;
import java.lang.reflect.Field;

public abstract class df {
    public static void a() {
        try {
            v9 v9Var = sa.a;
            HookBridge.hookAllMethods(Class.forName("X.0hTg"), sa.a.c[0], new cf());
        } catch (Exception e) {
            String strDecrypt = "Exception during init";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), e);
        }
    }

    public static void a(Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        try {
            se.a(obj.getClass(), "invoke", Object.class).invoke(obj, Boolean.valueOf(z));
        } catch (Exception e) {
            String strDecrypt = "Failed to invoke callback";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), e);
        }
    }

    public static Object a(Class cls, Object obj) {
        if (obj == null) {
            return null;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if (cls.isAssignableFrom(field.getType())) {
                    try {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            return obj2;
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            }
        }
        return null;
    }

    public static boolean a(Activity activity, Bitmap bitmap) {
        Throwable thU = null;
        Exception eU = null;
        OutputStream outputStreamOpenOutputStream;
        OutputStream outputStream = null;
        try {
            try {
                String str = System.currentTimeMillis() + ".jpg";
                ContentResolver contentResolver = activity.getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", str);
                contentValues.put("mime_type", "image/jpeg");
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    String strDecrypt = "relative_path";
                    w3 w3Var = w3.a;
                    String strDecrypt2 = "Photos";
                    w3Var.getClass();
                    contentValues.put(strDecrypt, w3.b(strDecrypt2));
                    contentValues.put("is_pending", (Integer) 1);
                }
                Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (uriInsert == null) {
                    return false;
                }
                outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                if (outputStreamOpenOutputStream != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                        outputStreamOpenOutputStream.close();
                        if (i >= 29) {
                            contentValues.clear();
                            contentValues.put("is_pending", (Integer) 0);
                            contentResolver.update(uriInsert, contentValues, null, null);
                        }
                        try {
                            outputStreamOpenOutputStream.close();
                            return true;
                        } catch (Exception e) {
                            return true;
                        }
                    } catch (Exception e2) {
                        eU = e2;
                        outputStream = outputStreamOpenOutputStream;
                    } catch (Throwable th) {
                        th = th;
                        outputStream = outputStreamOpenOutputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        throw th;
                    }
                } else {
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    return false;
                }
            } catch (Exception e5) {
                eU = e5;
            }
            if (outputStream != null) {
                outputStreamOpenOutputStream = outputStream;
                outputStreamOpenOutputStream.close();
            }
            return false;
        } catch (Throwable th2) {
            thU = th2;
        }
        String strDecrypt3 = "Error saving bitmap";
        Object obj = g7.a;
        g7.a(6, String.valueOf(strDecrypt3), eU);
        return false;
    }
}
