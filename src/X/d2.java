package X;

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

public abstract class d2 {
    public static final ThreadLocal a = new ThreadLocal();
    public static final Set b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    public static Method c;

    public static void a() {
        try {
            t6 t6Var = u5.a;
            HookBridge.hookAllMethods(Class.forName("X.0HP0"), u5.a.c[0], new z1());
            t6 t6Var2 = v5.a;
            HookBridge.hookAllMethods(Class.forName("X.0HP7"), v5.a.c[0], new a2());
            int i = g5.a;
        } catch (Throwable th) {
            String.valueOf(th);
            int i2 = g5.a;
        }
    }

    public static void b(final String str, Context context, final String str2) {
        final Context applicationContext = context != null ? context.getApplicationContext() : g5.c();
        if (str == null) {
            b(applicationContext, f5.a().a("sticker_unavailable"));
        } else {
            b(applicationContext, f5.a().a("sticker_downloading"));
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    d2.a(str, applicationContext, str2);
                }
            }, "ttmod-sticker-dl").start();
        }
    }

    public static Object b(Object obj) throws NoSuchMethodException {
        if (c == null) {
            for (Method method : Class.forName("X.0HO8").getDeclaredMethods()) {
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

    public static void a(View view, Object obj, c2 c2Var) {
        View view2;
        ViewGroup viewGroup;
        View view3;
        String str;
        ViewGroup.LayoutParams layoutParams;
        int marginStart;
        if (view != null && b.add(view)) {
            final String strA = null;
            try {
                Object objA = a(view, v5.b.c[0]);
                view2 = objA instanceof View ? (View) objA : null;
            } catch (Throwable th) {
            }
            if (view2 == null || (viewGroup = (ViewGroup) view2.getParent()) == null) {
                return;
            }
            try {
                Object objA2 = a(view, v5.c.c[0]);
                view3 = objA2 instanceof View ? (View) objA2 : null;
            } catch (Throwable th2) {
            }
            View view4 = view3 != null ? view3 : view2;
            int iIndexOfChild = viewGroup.indexOfChild(view4) + 1;
            if (iIndexOfChild <= 0) {
                iIndexOfChild = viewGroup.getChildCount();
            }
            Context context = view2.getContext();
            t6 t6Var = c8.a;
            TextView textView = (TextView) Class.forName("X.13pP").getConstructor(Context.class).newInstance(context);
            textView.setText(f5.a().a("sticker_download"));
            if (view3 != null) {
                str = t5.c.c[0];
            } else {
                str = t5.b.c[0];
            }
            try {
                Object objA3 = a(obj, str);
                if (objA3 != null) {
                    Object objA4 = a(objA3, s5.a.c[0]);
                    if (objA4 instanceof Integer) {
                        c8.a.a(Class.forName("X.13pP"), Integer.TYPE).invoke(textView, (Integer) objA4);
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
            String strA2 = a(c2Var.a);
            if (strA2 != null) {
                strA = strA2;
            } else {
                try {
                    strA = a(a(obj, t5.a.c[0]));
                } catch (Throwable th4) {
                }
            }
            final String str2 = c2Var.b;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view5) {
                    d2.b(strA, view5.getContext(), str2);
                }
            });
            viewGroup.addView(textView, iIndexOfChild);
            int i = g5.a;
        }
    }

    public static void a(String str, Context context, String str2) {
        try {
            byte[] bArrA = a(str);
            if (bArrA != null && bArrA.length != 0) {
                b(context, f5.a().a(a(context, bArrA, a(bArrA), str2) != null ? "sticker_saved" : "sticker_save_error"));
                return;
            }
            throw new Exception("empty response");
        } catch (Throwable th) {
            String.valueOf(th);
            int i = g5.a;
            b(context, f5.a().a("sticker_download_error"));
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

    public static b2 a(byte[] bArr) {
        if (bArr.length >= 12 && bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 87 && bArr[9] == 69 && bArr[10] == 66 && bArr[11] == 80) {
            return new b2("webp", "image/webp", false);
        }
        if (bArr.length >= 8 && (bArr[0] & 255) == 137 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
            return new b2("png", "image/png", false);
        }
        if (bArr.length >= 4 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56) {
            return new b2("gif", "image/gif", false);
        }
        if (bArr.length >= 3 && (bArr[0] & 255) == 255 && (bArr[1] & 255) == 216 && (bArr[2] & 255) == 255) {
            return new b2("jpg", "image/jpeg", false);
        }
        if (bArr.length >= 12 && bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112) {
            return new b2("mp4", "video/mp4", true);
        }
        return new b2("webp", "image/webp", false);
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

    public static Uri a(Context context, byte[] bArr, b2 b2Var, String str) throws Exception {
        Uri uri;
        String str2 = "sticker";
        if (str != null && !str.trim().isEmpty()) {
            String strReplaceAll = str.replaceAll("[^a-zA-Z0-9_\\-]", "_");
            if (strReplaceAll.length() > 40) {
                strReplaceAll = strReplaceAll.substring(0, 40);
            }
            if (!strReplaceAll.isEmpty()) {
                str2 = strReplaceAll;
            }
        }
        String str3 = str2 + "_" + System.currentTimeMillis() + "." + b2Var.a;
        if (Build.VERSION.SDK_INT >= 29) {
            ContentResolver contentResolver = context.getContentResolver();
            if (b2Var.c) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            }
            String str4 = (b2Var.c ? Environment.DIRECTORY_MOVIES : Environment.DIRECTORY_PICTURES) + File.separator + "TikTok Stickers";
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str3);
            contentValues.put("mime_type", b2Var.b);
            contentValues.put("relative_path", str4);
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
        File file = new File(Environment.getExternalStoragePublicDirectory(b2Var.c ? Environment.DIRECTORY_MOVIES : Environment.DIRECTORY_PICTURES), "TikTok Stickers");
        file.mkdirs();
        File file2 = new File(file, str3);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            try {
                MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, new String[]{b2Var.b}, null);
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
