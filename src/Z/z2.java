package Z;

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

public abstract class z2 {
    public static final ThreadLocal a = new ThreadLocal();
    public static final Set b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    public static Method c;

    public static void a() {
        try {
            v9 v9Var = c8.a;
            HookBridge.hookAllMethods(Class.forName("X.17WX"), c8.a.c[0], new v2());
            v9 v9Var2 = d8.a;
            HookBridge.hookAllMethods(Class.forName("X.17WZ"), d8.a.c[0], new w2());
            String strDecrypt = "Initialised";
            Object obj = g7.a;
            g7.a(4, String.valueOf(strDecrypt), (Throwable) null);
        } catch (Throwable th) {
            String strDecrypt2 = "Init error";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th);
        }
    }

    public static void b(final String str, Context context, final String str2) {
        final Context applicationContext = context != null ? context.getApplicationContext() : Main.getApplicationContext();
        if (str == null) {
            b(applicationContext, k7.a("sticker_unavailable"));
        } else {
            b(applicationContext, k7.a("sticker_downloading"));
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    z2.a(str, applicationContext, str2);
                }
            }, "ttmod-sticker-dl").start();
        }
    }

    public static Object b(Object obj) throws Throwable {
        if (c == null) {
            for (Method method : Class.forName("X.0dnr").getDeclaredMethods()) {
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

    public static void a(View view, Object obj, y2 y2Var) throws Throwable {
        View view2 = null;
        ViewGroup viewGroup;
        View view3 = null;
        String str;
        ViewGroup.LayoutParams layoutParams;
        int marginStart;
        if (view != null && b.add(view)) {
            try {
                Object objA = a(view, d8.b.c[0]);
                view2 = objA instanceof View ? (View) objA : null;
            } catch (Throwable th) {
            }
            if (view2 == null || (viewGroup = (ViewGroup) view2.getParent()) == null) {
                return;
            }
            try {
                Object objA2 = a(view, d8.c.c[0]);
                view3 = objA2 instanceof View ? (View) objA2 : null;
            } catch (Throwable th2) {
            }
            View view4 = view3 != null ? view3 : view2;
            int iIndexOfChild = viewGroup.indexOfChild(view4) + 1;
            if (iIndexOfChild <= 0) {
                iIndexOfChild = viewGroup.getChildCount();
            }
            Context context = view2.getContext();
            v9 v9Var = qb.a;
            TextView textView = (TextView) Class.forName("X.0Coz").getConstructor(Context.class).newInstance(context);
            textView.setText(k7.a("sticker_download"));
            if (view3 != null) {
                str = b8.c.c[0];
            } else {
                str = b8.b.c[0];
            }
            try {
                Object objA3 = a(obj, str);
                if (objA3 != null) {
                    Object objA4 = a(objA3, a8.a.c[0]);
                    if (objA4 instanceof Integer) {
                        qb.a.a(Class.forName("X.0Coz"), Integer.TYPE).invoke(textView, (Integer) objA4);
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
            String strATmp = a(y2Var.a);
            if (strATmp == null) {
                try {
                    strATmp = a(a(obj, b8.a.c[0]));
                } catch (Throwable th4) {
                    strATmp = null;
                }
            }
            final String strA = strATmp;
            final String str2 = y2Var.b;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view5) {
                    z2.b(strA, view5.getContext(), str2);
                }
            });
            viewGroup.addView(textView, iIndexOfChild);
            g7.a(4, g7.a("Download button added (url=%s)", new Object[]{Boolean.valueOf(strA != null)}), (Throwable) null);
        }
    }

    public static void a(String str, Context context, String str2) {
        String str3;
        String str4;
        try {
            byte[] bArrA = a(str);
            if (bArrA != null && bArrA.length != 0) {
                b(context, k7.a((a(context, bArrA, a(bArrA), str2) != null ? "sticker_saved" : "sticker_save_error")));
                return;
            }
            throw new Exception("empty response");
        } catch (Throwable th) {
            String strDecrypt = "Download failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
            b(context, k7.a("sticker_download_error"));
        }
    }

    public static byte[] a(String str) throws Throwable {
        Throwable thU = null;
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
                        throw thU;
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

    public static x2 a(byte[] bArr) {
        if (bArr.length >= 12 && bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 87 && bArr[9] == 69 && bArr[10] == 66 && bArr[11] == 80) {
            return new x2("webp", "image/webp", false);
        }
        if (bArr.length >= 8 && (bArr[0] & 255) == 137 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
            return new x2("png", "image/png", false);
        }
        if (bArr.length >= 4 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56) {
            return new x2("gif", "image/gif", false);
        }
        if (bArr.length >= 3 && (bArr[0] & 255) == 255 && (bArr[1] & 255) == 216 && (bArr[2] & 255) == 255) {
            return new x2("jpg", "image/jpeg", false);
        }
        if (bArr.length >= 12 && bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112) {
            return new x2("mp4", "video/mp4", true);
        }
        return new x2("webp", "image/webp", false);
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

    public static Uri a(Context context, byte[] bArr, x2 x2Var, String str) throws Exception {
        String strDecrypt;
        File file;
        Uri uri;
        String strB;
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
        String str2 = strDecrypt + "_" + System.currentTimeMillis() + "." + x2Var.a;
        if (Build.VERSION.SDK_INT >= 29) {
            ContentResolver contentResolver = context.getContentResolver();
            boolean z = x2Var.c;
            if (z) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            }
            if (z) {
                strB = w3.a();
            } else {
                w3 w3Var = w3.a;
                String strDecrypt2 = "Photos";
                w3Var.getClass();
                strB = w3.b(strDecrypt2);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str2);
            contentValues.put("mime_type", x2Var.b);
            contentValues.put("relative_path", strB);
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
        if (x2Var.c) {
            w3 w3Var2 = w3.a;
            String strDecrypt3 = "Videos";
            w3Var2.getClass();
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "TikTokYou/" + strDecrypt3);
            file.mkdirs();
        } else {
            w3 w3Var3 = w3.a;
            String strDecrypt4 = "Photos";
            w3Var3.getClass();
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "TikTokYou/" + strDecrypt4);
            file.mkdirs();
        }
        file.mkdirs();
        File file2 = new File(file, str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            try {
                MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, new String[]{x2Var.b}, null);
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

    public static Object a(Object obj, String str) throws Throwable {
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
