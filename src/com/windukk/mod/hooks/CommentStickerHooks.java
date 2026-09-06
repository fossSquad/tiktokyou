package com.windukk.mod.hooks;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class CommentStickerHooks {
    public static final ThreadLocal a;
    public static final Set b;
    public static Method c;

    static {
        a = new ThreadLocal();
        b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    }

    public static void a() {
        try {
            p8 p8Var = c7.a;
            HookBridge.hookAllMethods(Class.forName("X.0GXA"), c7.a.c[0], new k2());
            p8 p8Var2 = d7.a;
            HookBridge.hookAllMethods(Class.forName("X.1JIQ"), d7.a.c[0], new l2());
            String strDecrypt = "Initialised";
            Object obj = h6.a;
            h6.a(4, String.valueOf(strDecrypt), (Throwable) null);
        } catch (Throwable th) {
            String strDecrypt2 = "Init error";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th);
        }
    }

    public static void b(final String str, Context context, final String str2) {
        final Context applicationContext = context != null ? context.getApplicationContext() : Main.a();
        if (str == null) {
            b(applicationContext, l6.a("sticker_unavailable"));
        } else {
            b(applicationContext, l6.a("sticker_downloading"));
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    CommentStickerHooks.a(str, applicationContext, str2);
                }
            }, "ttmod-sticker-dl").start();
        }
    }

    public static Object b(Object obj) throws NoSuchMethodException {
        if (c == null) {
            for (Method method : Class.forName("X.10ja").getDeclaredMethods()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].getName().endsWith(".StickerItem") && method.getReturnType().getName().endsWith(".SetSticker")) {
                    method.setAccessible(true);
                    c = method;
                    break;
                }
            }
        }
        Method method2 = c;
        if (method2 != null) {
            return method2.invoke(null, obj);
        }
        throw new NoSuchMethodException("SetSticker resolver");
    }

    public static void b(final Context context, final String str) {
        if (context == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public final void run() {
                Toast.makeText(context, str, 0).show();
            }
        });
    }

    public static void a(View view, Object obj, n2 n2Var) {
        View view2;
        ViewGroup viewGroup;
        View view3;
        String str;
        ViewGroup.LayoutParams layoutParams;
        int marginStart;
        if (view != null && b.add(view)) {
            try {
                Object objA = a(view, d7.b.c[0]);
                view2 = objA instanceof View ? (View) objA : null;
            } catch (Throwable th) {
            }
            if (view2 == null || (viewGroup = (ViewGroup) view2.getParent()) == null) {
                return;
            }
            try {
                Object objA2 = a(view, d7.c.c[0]);
                view3 = objA2 instanceof View ? (View) objA2 : null;
            } catch (Throwable th2) {
            }
            View view4 = view3 != null ? view3 : view2;
            int iIndexOfChild = viewGroup.indexOfChild(view4) + 1;
            if (iIndexOfChild <= 0) {
                iIndexOfChild = viewGroup.getChildCount();
            }
            Context context = view2.getContext();
            p8 p8Var = ia.a;
            TextView textView = (TextView) Class.forName("X.0CCt").getConstructor(Context.class).newInstance(context);
            textView.setText(l6.a("sticker_download"));
            if (view3 != null) {
                str = b7.c.c[0];
            } else {
                str = b7.b.c[0];
            }
            try {
                Object objA3 = a(obj, str);
                if (objA3 != null) {
                    Object objA4 = a(objA3, a7.a.c[0]);
                    if (objA4 instanceof Integer) {
                        ia.a.a(Class.forName("X.0CCt"), Integer.TYPE).invoke(textView, (Integer) objA4);
                    }
                }
            } catch (Throwable th3) {
            }
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(layoutParams3.width, layoutParams3.height, layoutParams3.weight);
                layoutParams4.gravity = layoutParams3.gravity;
                layoutParams4.setMargins(layoutParams3.leftMargin, layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                layoutParams = layoutParams4;
            } else if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) layoutParams2);
            } else if (layoutParams2 != null) {
                layoutParams = new ViewGroup.LayoutParams(layoutParams2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ViewGroup.LayoutParams layoutParams5 = view4.getLayoutParams();
                if (!(layoutParams5 instanceof ViewGroup.MarginLayoutParams)) {
                    marginStart = 0;
                } else {
                    marginStart = ((ViewGroup.MarginLayoutParams) layoutParams5).getMarginStart();
                }
                marginLayoutParams.setMarginStart(marginStart);
            }
            textView.setLayoutParams(layoutParams);
            final String strA = a(n2Var.a);
            if (strA == null) {
                try {
                    strA = a(a(obj, b7.a.c[0]));
                } catch (Throwable th4) {
                    strA = null;
                }
            }
            final String str2 = n2Var.b;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view5) {
                    CommentStickerHooks.b(strA, view5.getContext(), str2);
                }
            });
            viewGroup.addView(textView, iIndexOfChild);
            h6.a(4, h6.a("Download button added (url=%s)", new Object[]{Boolean.valueOf(strA != null)}), (Throwable) null);
        }
    }

    public static void a(String str, Context context, String str2) {
        String str3;
        String str4;
        try {
            byte[] bArrA = a(str);
            if (bArrA != null && bArrA.length != 0) {
                b(context, l6.a((a(context, bArrA, a(bArrA), str2) != null ? "sticker_saved" : "sticker_save_error")));
                return;
            }
            throw new Exception("empty response");
        } catch (Throwable th) {
            String strDecrypt = "Download failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
            b(context, l6.a("sticker_download_error"));
        }
    }

    public static byte[] a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setRequestProperty("User-Agent", "TikTok");
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, httpURLConnection.getContentLength()));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            inputStream.close();
                            httpURLConnection.disconnect();
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            throw new Exception("http " + responseCode);
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    public static m2 a(byte[] bArr) {
        if (bArr.length >= 12 && bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 87 && bArr[9] == 69 && bArr[10] == 66 && bArr[11] == 80) {
            return new m2("webp", "image/webp", false);
        }
        if (bArr.length >= 8 && (bArr[0] & 255) == 137 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
            return new m2("png", "image/png", false);
        }
        if (bArr.length >= 4 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56) {
            return new m2("gif", "image/gif", false);
        }
        if (bArr.length >= 3 && (bArr[0] & 255) == 255 && (bArr[1] & 255) == 216 && (bArr[2] & 255) == 255) {
            return new m2("jpg", "image/jpeg", false);
        }
        if (bArr.length >= 12 && bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112) {
            return new m2("mp4", "video/mp4", true);
        }
        return new m2("webp", "image/webp", false);
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod("getUrlList", null);
            method.setAccessible(true);
            Object objInvoke = method.invoke(obj, null);
            if (objInvoke instanceof List) {
                for (Object obj2 : (List) objInvoke) {
                    if ((obj2 instanceof String) && ((String) obj2).startsWith("http")) {
                        return (String) obj2;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static Uri a(Context context, byte[] bArr, m2 m2Var, String str) throws Exception {
        String strDecrypt;
        Uri uri;
        if (str != null && !str.trim().isEmpty()) {
            strDecrypt = str.replaceAll("[^a-zA-Z0-9_\\-]", "_");
            if (strDecrypt.length() > 40) {
                strDecrypt = strDecrypt.substring(0, 40);
            }
            if (strDecrypt.isEmpty()) {
                strDecrypt = "sticker";
            }
        } else {
            strDecrypt = "sticker";
        }
        String str2 = strDecrypt + "_" + System.currentTimeMillis() + "." + m2Var.a;
        if (Build.VERSION.SDK_INT >= 29) {
            ContentResolver contentResolver = context.getContentResolver();
            if (m2Var.c) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            }
            String strA = new StringBuilder().append(m2Var.c ? Environment.DIRECTORY_MOVIES : Environment.DIRECTORY_PICTURES).append(File.separator).append("TikTok Stickers").toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str2);
            contentValues.put("mime_type", m2Var.b);
            contentValues.put("relative_path", strA);
            contentValues.put("is_pending", (Integer) 1);
            Uri uriInsert = contentResolver.insert(uri, contentValues);
            if (uriInsert != null) {
                OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                try {
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.write(bArr);
                        outputStreamOpenOutputStream.close();
                        contentValues.clear();
                        contentValues.put("is_pending", (Integer) 0);
                        contentResolver.update(uriInsert, contentValues, null, null);
                        return uriInsert;
                    }
                    throw new Exception("openOutputStream null");
                } catch (Throwable th) {
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            throw new Exception("insert returned null");
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(m2Var.c ? Environment.DIRECTORY_MOVIES : Environment.DIRECTORY_PICTURES), "TikTok Stickers");
        file.mkdirs();
        File file2 = new File(file, str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            try {
                MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, new String[]{m2Var.b}, null);
            } catch (Throwable th3) {
            }
            return Uri.fromFile(file2);
        } catch (Throwable th4) {
            try {
                fileOutputStream.close();
            } catch (Throwable th5) {
                th4.addSuppressed(th5);
            }
            throw th4;
        }
    }

    public static Object a(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(str);
    }
}
