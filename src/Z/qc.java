package Z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.windukk.stable.ResourceOverlay;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.ToLongFunction;
import ni.shikatu.kotlin.collections.MapsKt;

public abstract class qc {
    public static final char[] a;
    public static final ConcurrentHashMap b;
    public static final t1 c;
    public static final ConcurrentHashMap d;
    public static final Map e;
    public static final Map f;
    public static final Map g;
    public static volatile Method h;
    public static volatile boolean i;
    public static volatile pc j;

    static {
        a = new char[]{'.', 'i', 'm', 'g'};
        b = new ConcurrentHashMap();
        c = new t1(16777216);
        d = new ConcurrentHashMap();
        e = Collections.synchronizedMap(new WeakHashMap());
        f = Collections.synchronizedMap(new WeakHashMap());
        g = Collections.synchronizedMap(new WeakHashMap());
    }

    public static void a(View view) {
        String string = null;
        String str;
        ViewGroup viewGroup;
        nc ncVar;
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
            str = (String) b.get(string);
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
        }
        if (str == null) {
            WeakReference weakReference = (WeakReference) f.remove(view);
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null) {
                if (view2.getBackground() instanceof oc) {
                    view2.setBackground(((oc) view2.getBackground()).a);
                } else if (view2.getBackground() instanceof nc) {
                    view2.setBackground(null);
                }
            }
            e.remove(view);
            g.remove(view);
            return;
        }
        Bitmap bitmap = (Bitmap) c.get(str);
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
            if ((view.getBackground() instanceof nc) && str.equals(e.get(view))) {
                return;
            }
            view.setBackground(new nc(bitmap, c()));
            e.put(view, str);
            f.put(view, new WeakReference(view));
            return;
        }
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        view.getLocationInWindow(iArr2);
        viewGroup.getLocationInWindow(iArr3);
        int i2 = iArr2[1] - iArr3[1];
        pc pcVarC = c();
        Map map = g;
        Integer numValueOf = (Integer) map.get(view);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(i2);
            map.put(view, numValueOf);
        }
        int iMin = Math.min(0, i2 - numValueOf.intValue());
        float width2 = viewGroup.getWidth();
        pcVarC.getClass();
        int iMax = Math.max(1, Math.round(width2 * 0.9292929f)) + iMin;
        Map map2 = f;
        WeakReference weakReference2 = (WeakReference) map2.get(view);
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        if (view3 != null && view3 != viewGroup) {
            if (view3.getBackground() instanceof oc) {
                view3.setBackground(((oc) view3.getBackground()).a);
            } else if (view3.getBackground() instanceof nc) {
                view3.setBackground(null);
            }
            map.remove(view);
        }
        Drawable background = viewGroup.getBackground();
        boolean z = background instanceof oc;
        if (z) {
            ncVar = ((oc) background).b;
            if (ncVar.a != bitmap) {
                if (z) {
                    background = ((oc) background).a;
                }
                ncVar = new nc(bitmap, pcVarC);
                viewGroup.setBackground(new oc(background, ncVar));
            }
        } else {
            if (z) {
                background = ((oc) background).a;
            }
            ncVar = new nc(bitmap, pcVarC);
            viewGroup.setBackground(new oc(background, ncVar));
        }
        if (ncVar.f != pcVarC) {
            ncVar.f = pcVarC;
            ncVar.invalidateSelf();
        }
        if (!ncVar.g || ncVar.h != iMin || ncVar.i != iMax) {
            ncVar.g = true;
            ncVar.h = iMin;
            ncVar.i = iMax;
            ncVar.invalidateSelf();
        }
        e.put(view, str + "@" + System.identityHashCode(viewGroup));
        map2.put(view, new WeakReference(viewGroup));
        h(view);
    }

    public static void b(final View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public final void onGlobalLayout() {
                qc.a(view);
            }
        });
        viewTreeObserver.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public final void onScrollChanged() {
                qc.a(view);
            }
        });
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public final boolean onPreDraw() {
                return qc.e(view);
            }
        });
        view.post(new Runnable() {
            @Override
            public final void run() {
                qc.a(view);
            }
        });
    }

    public static  boolean e(View view) {
        h(view);
        return true;
    }

    public static void h(View view) {
        int i2;
        int iAlpha;
        int i3;
        WeakReference weakReference = (WeakReference) f.get(view);
        View view2 = null;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if ((view3 instanceof ViewGroup) && (view3.getBackground() instanceof oc)) {
            nc ncVar = ((oc) view3.getBackground()).b;
            View viewFindViewById = view3.findViewById(2131383448);
            if (viewFindViewById == null) {
                viewFindViewById = view3.getRootView().findViewById(2131383448);
            }
            if (viewFindViewById != null) {
                Object parent = viewFindViewById.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    if (!"com.bytedance.tux.navigation.TuxNavBar".equals(view2.getClass().getName())) {
                        view2 = viewFindViewById;
                    }
                } else {
                    view2 = viewFindViewById;
                }
            }
            if (view2 == null || !(view2.getBackground() instanceof ColorDrawable)) {
                i2 = 0;
                iAlpha = 0;
                i3 = 0;
            } else {
                int color = ((ColorDrawable) view2.getBackground()).getColor();
                i2 = (-16777216) | color;
                iAlpha = Color.alpha(color);
                int[] iArr = new int[2];
                view2.getLocationInWindow(iArr);
                int i4 = iArr[1];
                view3.getLocationInWindow(iArr);
                i3 = i4 - iArr[1];
            }
            if (ncVar.j == i2 && ncVar.k == iAlpha && ncVar.l == i3) {
                return;
            }
            ncVar.j = i2;
            ncVar.k = iAlpha;
            ncVar.l = i3;
            ncVar.invalidateSelf();
        }
    }

    public static pc c() {
        pc pcVar;
        pc pcVar2 = j;
        if (pcVar2 != null) {
            return pcVar2;
        }
        synchronized (qc.class) {
            pcVar = j;
            if (pcVar == null) {
                pcVar = pc.e;
                try {
                    z7 z7Var = f9.a;
                    w6 w6Var = z7Var.a;
                    if (w6Var == null) {
                        throw new IllegalStateException("Field mapping has no owner: " + z7Var.b);
                    }
                    if (Boolean.TRUE.equals(z7Var.a(Class.forName(w6Var.b)).get(null))) {
                        pcVar = pc.d;
                    }
                    j = pcVar;
                } catch (Throwable th) {
                    String strDecrypt = "Failed to resolve profile_left_align; using centered profile";
                    Object obj = h6.a;
                    h6.a(6, String.valueOf(strDecrypt), th);
                }
            }
        }
        return pcVar;
    }

    public static void b(File file) {
        File parentFile = file != null ? file.getParentFile() : null;
        File[] fileArrListFiles = parentFile != null ? parentFile.listFiles(new FileFilter() {
            @Override
            public final boolean accept(File file2) {
                return qc.a(file2);
            }
        }) : null;
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        long jMax = 0;
        for (File file2 : fileArrListFiles) {
            jMax += Math.max(0L, file2.length());
        }
        if (jMax <= 67108864) {
            return;
        }
        Arrays.sort(fileArrListFiles, Comparator.comparingLong(new ToLongFunction() {
            @Override
            public final long applyAsLong(Object obj) {
                return ((File) obj).lastModified();
            }
        }));
        for (File file3 : fileArrListFiles) {
            if (jMax <= 67108864) {
                return;
            }
            if (file == null || !file.equals(file3)) {
                long jMax2 = Math.max(0L, file3.length());
                if (file3.delete()) {
                    jMax -= jMax2;
                }
            }
        }
    }

    public static Method a() {
        if (!i) {
            synchronized (qc.class) {
                if (!i) {
                    try {
                        h = Class.forName("androidx.fragment.app.FragmentManager").getMethod("findFragment", View.class);
                    } catch (Throwable th) {
                        h = null;
                    }
                    i = true;
                }
            }
        }
        return h;
    }

    public static void a(Context context, final String str, View view) {
        if (c.get(str) == null && d.putIfAbsent(str, Boolean.TRUE) == null) {
            final Context applicationContext = context.getApplicationContext();
            final WeakReference weakReference = new WeakReference(view);
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    qc.a(str, applicationContext, weakReference);
                }
            }, "profile-banner-" + Integer.toHexString(str.hashCode())).start();
        }
    }

    public static void a(String str, Context context, WeakReference weakReference) {
        final View view;
        Bitmap bitmapA = null;
        try {
            if (str.startsWith("asset:")) {
                InputStream inputStreamOpen = ResourceOverlay.open(context, str.substring("asset:".length()));
                try {
                    Bitmap bitmapA2 = h4.a(a(inputStreamOpen), 1280);
                    inputStreamOpen.close();
                    bitmapA = bitmapA2;
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
                c.put(str, bitmapA);
            }
        } catch (Throwable th3) {
            try {
                h6.a(6, h6.a("Load failed for %s", new Object[]{str}), th3);
            } catch (Throwable th4) {
                d.remove(str);
                throw th4;
            }
        }
        d.remove(str);
        if (bitmapA == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.post(new Runnable() {
            @Override
            public final void run() {
                qc.a(view);
            }
        });
    }

    public static Bitmap a(Context context, String str) throws Exception {
        File cacheDir = context.getCacheDir() != null ? context.getCacheDir() : context.getFilesDir();
        Bitmap bitmapA = null;
        File file = cacheDir == null ? null : new File(new File(cacheDir, "tty_banners"), v5.a(str.getBytes(StandardCharsets.UTF_8)) + new String(a));
        boolean z = file != null && file.exists() && file.length() > 0;
        if (z && System.currentTimeMillis() - file.lastModified() < 10800000) {
            Bitmap bitmapA2 = h4.a(file, 1280);
            if (bitmapA2 != null) {
                b(file);
            }
            if (bitmapA2 != null) {
                return bitmapA2;
            }
        }
        try {
            String strDecrypt = "TTMod-ProfileBanner/1.0";
            AtomicBoolean atomicBoolean = p.a;
            byte[] bArr;
            try {
                bArr = p.a(str, strDecrypt, 25165824, MapsKt.emptyMap(), (String) null).b;
            } catch (Exception ex9) {
                bArr = null;
            }
            if (bArr == null || bArr.length == 0) {
                if (!z) {
                    return null;
                }
                Bitmap bitmapA3 = h4.a(file, 1280);
                if (bitmapA3 != null) {
                    b(file);
                }
                return bitmapA3;
            }
            Bitmap bitmapA4 = h4.a(bArr, 1280);
            if (bitmapA4 != null && file != null) {
                try {
                    h4.a(file, bitmapA4);
                    b(file);
                    return bitmapA4;
                } catch (IOException e2) {
                    h6.a(6, h6.a("Cache write failed for %s: %s", new Object[]{v5.a(str.getBytes(StandardCharsets.UTF_8)), e2.getMessage()}), (Throwable) null);
                }
            }
            return bitmapA4;
        } catch (Exception e3) {
            if (z && (bitmapA = h4.a(file, 1280)) != null) {
                b(file);
            }
            if (bitmapA != null) {
                return bitmapA;
            }
            throw e3;
        }
    }

    public static  boolean a(File file) {
        return file.isFile() && file.getName().endsWith(new String(a));
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                if (byteArrayOutputStream.size() <= 25165824 - i2) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    throw new IOException(new StringBuilder().append("Banner image exceeds ").append(25165824).append(" bytes").toString());
                }
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
