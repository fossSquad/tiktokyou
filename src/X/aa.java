package X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.ss.android.ugc.profile.platform.base.component.BaseContainerComponent;
import com.windukk.hook.HookBridge;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public abstract class aa {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final Map d = Collections.synchronizedMap(new WeakHashMap());
    public static final Map e = Collections.synchronizedMap(new WeakHashMap());
    public static final Map f = Collections.synchronizedMap(new WeakHashMap());
    public static volatile Method g;
    public static volatile boolean h;

    public static void a(View view) {
        String string;
        String str;
        ViewGroup viewGroup;
        y9 y9Var;
        Object objInvoke;
        Object objInvoke2;
        Object objInvoke3;
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        try {
            Method methodA = a();
            string = (methodA == null || (objInvoke = methodA.invoke(null, view)) == null || (objInvoke2 = objInvoke.getClass().getMethod("getUser", null).invoke(objInvoke, null)) == null || (objInvoke3 = objInvoke2.getClass().getMethod("getUid", null).invoke(objInvoke2, null)) == null) ? null : objInvoke3.toString();
        } catch (Throwable th) {
        }
        if (TextUtils.isEmpty(string)) {
            str = null;
        } else {
            str = (String) a.get(string);
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
        }
        if (str == null) {
            View view2 = (View) e.remove(view);
            if (view2 != null) {
                if (view2.getBackground() instanceof z9) {
                    view2.setBackground(((z9) view2.getBackground()).a);
                } else if (view2.getBackground() instanceof y9) {
                    view2.setBackground(null);
                }
            }
            d.remove(view);
            f.remove(view);
            return;
        }
        Bitmap bitmap = (Bitmap) b.get(str);
        if (bitmap == null) {
            a(view.getContext(), str, view);
            return;
        }
        int[] iArr = new int[2];
        ViewParent parent = view.getParent();
        while (true) {
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
                if (viewGroup.getId() != 16908290 && !viewGroup.getClass().getName().contains("DecorView")) {
                    viewGroup.getLocationInWindow(iArr);
                    if (iArr[1] <= 24) {
                        break;
                    } else {
                        parent = viewGroup.getParent();
                    }
                }
            }
            viewGroup = null;
            break;
        }
        if (viewGroup == null) {
            if ((view.getBackground() instanceof y9) && str.equals(d.get(view))) {
                return;
            }
            view.setBackground(new y9(bitmap));
            d.put(view, str);
            e.put(view, view);
            return;
        }
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        view.getLocationInWindow(iArr2);
        viewGroup.getLocationInWindow(iArr3);
        int i = iArr2[1] - iArr3[1];
        Map map = f;
        int[] iArr4 = (int[]) map.get(view);
        if (iArr4 == null) {
            iArr4 = new int[]{i, view.getHeight() + i};
            map.put(view, iArr4);
        } else {
            int i2 = iArr4[0];
            if (i <= i2) {
                iArr4[1] = view.getHeight() + i2;
            }
        }
        int iMin = Math.min(0, i - iArr4[0]);
        int height2 = view.getHeight() + i;
        Map map2 = e;
        View view3 = (View) map2.get(view);
        if (view3 != null && view3 != viewGroup) {
            if (view3.getBackground() instanceof z9) {
                view3.setBackground(((z9) view3.getBackground()).a);
            } else if (view3.getBackground() instanceof y9) {
                view3.setBackground(null);
            }
            map.remove(view);
        }
        Drawable background = viewGroup.getBackground();
        boolean z = background instanceof z9;
        if (z) {
            y9Var = ((z9) background).b;
            if (y9Var.a != bitmap) {
                if (z) {
                    background = ((z9) background).a;
                }
                y9Var = new y9(bitmap);
                viewGroup.setBackground(new z9(background, y9Var));
            }
        } else {
            if (z) {
                background = ((z9) background).a;
            }
            y9Var = new y9(bitmap);
            viewGroup.setBackground(new z9(background, y9Var));
        }
        if (!y9Var.h || y9Var.i != iMin || y9Var.j != height2) {
            y9Var.h = true;
            y9Var.i = iMin;
            y9Var.j = height2;
            y9Var.invalidateSelf();
        }
        int i3 = iArr4[1];
        if (y9Var.k != i3) {
            y9Var.k = i3;
            y9Var.invalidateSelf();
        }
        boolean z2 = (view.getContext().getResources().getConfiguration().uiMode & 48) == 32;
        if (y9Var.l != z2) {
            y9Var.l = z2;
            y9Var.invalidateSelf();
        }
        d.put(view, str + "@" + System.identityHashCode(viewGroup));
        map2.put(view, viewGroup);
        h(view);
    }

    public static void b() {
        try {
            HookBridge.hookAllMethods(BaseContainerComponent.class, "onViewCreated", new x9());
            int i = g5.a;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }

    public static  boolean e(View view) {
        h(view);
        return true;
    }

    public static void h(View view) {
        int i;
        int iAlpha;
        int i2;
        View view2 = (View) e.get(view);
        if ((view2 instanceof ViewGroup) && (view2.getBackground() instanceof z9)) {
            y9 y9Var = ((z9) view2.getBackground()).b;
            View viewFindViewById = view2.findViewById(2131382614);
            if (viewFindViewById == null) {
                viewFindViewById = view2.getRootView().findViewById(2131382614);
            }
            if (viewFindViewById == null || !(viewFindViewById.getBackground() instanceof ColorDrawable)) {
                i = 0;
                iAlpha = 0;
                i2 = 0;
            } else {
                int color = ((ColorDrawable) viewFindViewById.getBackground()).getColor();
                i = (-16777216) | color;
                iAlpha = Color.alpha(color);
                int[] iArr = new int[2];
                viewFindViewById.getLocationInWindow(iArr);
                int i3 = iArr[1];
                view2.getLocationInWindow(iArr);
                i2 = i3 - iArr[1];
            }
            if (y9Var.m == i && y9Var.n == iAlpha && y9Var.o == i2) {
                return;
            }
            y9Var.m = i;
            y9Var.n = iAlpha;
            y9Var.o = i2;
            y9Var.invalidateSelf();
        }
    }

    public static void b(final View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public final void onGlobalLayout() {
                aa.a(view);
            }
        });
        viewTreeObserver.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public final void onScrollChanged() {
                aa.a(view);
            }
        });
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public final boolean onPreDraw() {
                return aa.e(view);
            }
        });
        view.post(new Runnable() {
            @Override
            public final void run() {
                aa.a(view);
            }
        });
    }

    public static Method a() {
        if (!h) {
            synchronized (aa.class) {
                if (!h) {
                    try {
                        g = Class.forName("androidx.fragment.app.FragmentManager").getMethod("findFragment", View.class);
                    } catch (Throwable th) {
                        g = null;
                    }
                    h = true;
                }
            }
        }
        return g;
    }

    public static void a(Context context, final String str, View view) {
        if (!b.containsKey(str) && c.putIfAbsent(str, Boolean.TRUE) == null) {
            final Context applicationContext = context.getApplicationContext();
            final WeakReference weakReference = new WeakReference(view);
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    aa.a(str, applicationContext, weakReference);
                }
            }, "profile-banner-" + Integer.toHexString(str.hashCode())).start();
        }
    }

    public static void a(String str, Context context, WeakReference weakReference) {
        final View view;
        Bitmap bitmapA = null;
        try {
            if (str.startsWith("asset:")) {
                InputStream inputStreamOpen = context.getAssets().open(str.substring(6));
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    bitmapA = bitmapDecodeStream;
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
            } else {
                bitmapA = a(context, str);
            }
            if (bitmapA != null) {
                b.put(str, bitmapA);
            }
        } catch (Throwable th3) {
            try {
                th3.getMessage();
                int i = g5.a;
            } catch (Throwable th4) {
                c.remove(str);
                throw th4;
            }
        }
        c.remove(str);
        if (bitmapA == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.post(new Runnable() {
            @Override
            public final void run() {
                aa.a(view);
            }
        });
    }

    public static Bitmap a(Context context, String str) {
        File file;
        String hexString;
        byte[] byteArray;
        Bitmap bitmapDecodeFile;
        File cacheDir = context.getCacheDir() != null ? context.getCacheDir() : context.getFilesDir();
        if (cacheDir == null) {
            file = null;
        } else {
            File file2 = new File(cacheDir, "ttmod_banners");
            StringBuilder sb = new StringBuilder();
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
                StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
                for (byte b2 : bArrDigest) {
                    sb2.append(Character.forDigit((b2 >> 4) & 15, 16));
                    sb2.append(Character.forDigit(b2 & 15, 16));
                }
                hexString = sb2.toString();
            } catch (Throwable th) {
                hexString = Integer.toHexString(str.hashCode());
            }
            file = new File(file2, sb.append(hexString).append(".img").toString());
        }
        boolean z = file != null && file.exists() && file.length() > 0;
        if (z && System.currentTimeMillis() - file.lastModified() < 10800000 && (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) != null) {
            return bitmapDecodeFile;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() / 100 != 2) {
                httpURLConnection.disconnect();
                byteArray = null;
            } else {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                        httpURLConnection.disconnect();
                        throw th;
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
            if (byteArray == null || byteArray.length == 0) {
                if (z) {
                    return BitmapFactory.decodeFile(file.getAbsolutePath());
                }
                return null;
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            if (bitmapDecodeByteArray != null && file != null) {
                try {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(byteArray);
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                        }
                        throw th4;
                    }
                } catch (Throwable th6) {
                    th6.getMessage();
                    int i2 = g5.a;
                }
            }
            return bitmapDecodeByteArray;
        } catch (Throwable th7) {
            httpURLConnection.disconnect();
            throw th7;
        }
    }
}
