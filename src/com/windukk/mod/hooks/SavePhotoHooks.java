package com.windukk.mod.hooks;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.windukk.hook.HookBridge;
import java.io.OutputStream;
import java.lang.reflect.Field;

public abstract class SavePhotoHooks {
    public static void a() {
        try {
            p8 p8Var = l9.a;
            HookBridge.hookAllMethods(Class.forName("X.1EDU"), l9.a.c[0], new nd());
        } catch (Exception e) {
            String strDecrypt = "Exception during init";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), e);
        }
    }

    public static void a(Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        try {
            dd.a(obj.getClass(), "invoke", Object.class).invoke(obj, Boolean.valueOf(z));
        } catch (Exception e) {
            String strDecrypt = "Failed to invoke callback";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), e);
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
                    contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/TikTok");
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
                        e = e2;
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
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
        String strDecrypt = "Error saving bitmap";
        Object obj = h6.a;
        h6.a(6, String.valueOf(strDecrypt), e);
        if (outputStream != null) {
            outputStreamOpenOutputStream = outputStream;
            outputStreamOpenOutputStream.close();
        }
        return false;
    }
}
