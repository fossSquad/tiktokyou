package X;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class m5 {
    private static volatile Parcelable.Creator<PackageInfo> c;
    private static volatile boolean d;
    private static volatile boolean e;
    private static volatile boolean f;
    private static final ThreadLocal<Boolean> g = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });
    private static final String a = "308203873082026fa003020102020432c7a2f7300d06092a864886f70d01010b05003074310b30090603550406130238363111300f060355040813085368616e676861693111300f060355040713085368616e6768616931183016060355040a130f6d75736963616c2e6c7920496e632e3110300e060355040b1307616e64726f6964311330110603550403130a6d75736963616c2e6c79301e170d3135303432383034323731375a170d3430303432313034323731375a3074310b30090603550406130238363111300f060355040813085368616e676861693111300f060355040713085368616e6768616931183016060355040a130f6d75736963616c2e6c7920496e632e3110300e060355040b1307616e64726f6964311330110603550403130a6d75736963616c2e6c7930820122300d06092a864886f70d01010105000382010f003082010a0282010100af12e34c0b031e41e6c99ac3b636d4253aa7584ebc9ae4c59244b02979b80969279f32e6e3dfe01a0d7cb6ed4000e8923dd90d7171a337864f6a64c590db204baab97f013fe8c7defe3cab4c16b24cb6959a3cffb9905723c0a1116d002a9cfd721c1e7a16383d47e27ed4387f8dccba6e44d5741da5cb7a295f8c32b52750c3ed5a56f494ff3d667ca3d59c9c3573bf6856677279b84d45d80c53b3a941911abbe9b15cea636abf9ba63e99b2c9ed7afa48fa2f09681fdd559f4792ecf5a26040018efaf7bd411adb0d52e2a5ad8424a776f543583a7e926c6b0337caa4aefa23f9afe52c9933a1fc6e73bc93db8d4e2ab450c2de90648dd19cd7d09c5652bf0203010001a321301f301d0603551d0e0416041422eb1a0c5448d5ffb28177f145dff7ecf6c1fe21300d06092a864886f70d01010b050003820101002f3427639582fa699602cb08659baaf722cc11ce2e29784130f6b46a5a20637eae4f19106a2433aad8433e1f3e26c2904895666f9f4f461c36f37029c251c7060d9c55453ad390375a34bb7855900238590046d7618e02a2cc91bebf9a1fadb9d220bc92c184723c366b6cbffe938bb0ae802f960f87039d1b7c613ba84282845b97fcecad7468decea3d836f7545369193df04d7406c6a02d0bf70dff36476d3d4b578c229296bf8a357049fe7e577993707d2942c4998b2335c0da96894afbd638a17d863c97f7fde2a87845f87b770200df2e8eb720ad3f4fa9fce89ea29e6cfa2fd0d3c4e7eb10f3b4a29a50dbea3bda6ff378c1d14bc009af66db0a16d2";
    private static Signature b = new Signature(a);
    public static volatile ThreadLocal<Boolean> h = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.TRUE;
        }
    });

    public class a extends HookMethod {
        public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            if (Boolean.TRUE.equals(m5.h.get())) {
                hookMethodParam.setResult(m5.j());
            }
        }
    }

    public class b extends HookMethod {
        public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            if (Boolean.TRUE.equals(m5.h.get())) {
                hookMethodParam.setResult(m5.j());
            }
        }
    }

    public class c extends HookMethod {
        public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            if (Boolean.TRUE.equals(m5.h.get())) {
                hookMethodParam.setResult(Boolean.FALSE);
            }
        }
    }

    public class d extends HookMethod {
        public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            PackageInfo packageInfoA;
            if (Boolean.FALSE.equals(m5.h.get())) {
                return;
            }
            Object[] objArr = hookMethodParam.args;
            if (objArr.length == 0 || !(objArr[0] instanceof String) || (packageInfoA = m5.a((PackageInfo) hookMethodParam.getResult())) == null) {
                return;
            }
            hookMethodParam.setResult(packageInfoA);
        }
    }

    public class e extends HookMethod {
        public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            if (Boolean.FALSE.equals(m5.h.get())) {
                return;
            }
            Object[] objArr = hookMethodParam.args;
            if (objArr.length <= 0 || !"com.zhiliaoapp.musically".equals(objArr[0])) {
                return;
            }
            hookMethodParam.setResult("com.android.vending");
        }
    }

    public class f extends HookMethod {
        public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            if (Boolean.FALSE.equals(m5.h.get())) {
                return;
            }
            Object[] objArr = hookMethodParam.args;
            if (objArr.length <= 0 || !"com.zhiliaoapp.musically".equals(objArr[0])) {
                return;
            }
            m5.a(hookMethodParam.getResult());
        }
    }

    public class g extends HookMethod {
        public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
            if (Boolean.FALSE.equals(m5.h.get())) {
                return;
            }
            Object result = hookMethodParam.getResult();
            if (result instanceof List) {
                m5.a((List<?>) result);
                hookMethodParam.setResult(result);
            }
        }
    }

    public static final class i implements InvocationHandler {
        private final Object a;

        private i(Object obj) {
            this.a = obj;
        }

        @Override
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                Object objInvoke = method.invoke(this.a, objArr);
                String name = method.getName();
                return ("getPackageInfo".equals(name) || "getPackageInfoVersioned".equals(name)) ? m5.a((PackageInfo) objInvoke) : objInvoke;
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        }
    }

    public static void a(Runnable runnable) {
        Boolean bool = h.get();
        h.set(Boolean.FALSE);
        try {
            runnable.run();
        } finally {
            h.set(bool);
        }
    }

    private static void b(Method method) {
        if (method.getParameterTypes().length == 0 || method.getParameterTypes()[0] != String.class) {
            return;
        }
        HookBridge.hookMethod(method, new e());
    }

    public static void c() {
        e();
    }

    private static void d() {
        for (Method method : Class.forName("android.app.ApplicationPackageManager").getDeclaredMethods()) {
            String name = method.getName();
            if ("getPackageInfo".equals(name) || "getPackageArchiveInfo".equals(name) || "getInstalledPackages".equals(name) || "getInstallerPackageName".equals(name) || "getInstallSourceInfo".equals(name)) {
                if ("getInstallerPackageName".equals(name)) {
                    b(method);
                } else if ("getInstallSourceInfo".equals(name)) {
                    a(method);
                } else if (method.getReturnType() == PackageInfo.class || method.getReturnType() == List.class) {
                    if ("getInstalledPackages".equals(name)) {
                        c(method);
                    } else if (method.getParameterTypes().length != 0 && method.getReturnType() == PackageInfo.class && method.getParameterTypes()[0] == String.class) {
                        HookBridge.hookMethod(method, new d());
                    }
                }
            }
        }
    }

    public static void e() {
        if (f) {
            return;
        }
        f = true;
        try {
            HookBridge.disableHiddenApiRestrictions();
            g();
            f();
            if (Build.VERSION.SDK_INT >= 28) {
                HookBridge.hookMethod(SigningInfo.class.getMethod("getApkContentsSigners", null), new a());
                HookBridge.hookMethod(SigningInfo.class.getMethod("getSigningCertificateHistory", null), new b());
                HookBridge.hookMethod(SigningInfo.class.getMethod("hasMultipleSigners", null), new c());
            }
            d();
            int i2 = v3.a;
        } catch (Throwable th) {
            f = false;
            int i3 = v3.a;
        }
    }

    private static void f() {
        if (e) {
            return;
        }
        try {
            Field fieldA = e4.a(Class.forName("android.app.ActivityThread"), "sPackageManager");
            Object obj = fieldA.get(null);
            if (obj != null && !Proxy.isProxyClass(obj.getClass())) {
                Class<?> cls = Class.forName("android.content.pm.IPackageManager");
                fieldA.set(null, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new i(obj)));
                e = true;
                return;
            }
            e = obj != null;
        } catch (Throwable th) {
            int i2 = v3.a;
        }
    }

    private static void g() {
        if (d) {
            return;
        }
        try {
            Parcelable.Creator<PackageInfo> creator = PackageInfo.CREATOR;
            if (c == null) {
                c = creator;
            }
            e4.a(PackageInfo.class, "CREATOR").set(null, new h());
            a();
            d = true;
        } catch (Throwable th) {
            int i2 = v3.a;
        }
    }

    public static Signature[] j() {
        return new Signature[]{b};
    }

    private static void c(Method method) {
        HookBridge.hookMethod(method, new g());
    }

    private static void b(Object obj) {
        if (obj == null) {
            return;
        }
        a(obj, "signatures", j());
        a(obj, "mSignatures", j());
        a(obj, "pastSigningCertificates", j());
        a(obj, "mPastSigningCertificates", j());
        a(obj, "signatureSchemeVersion", 3);
        a(obj, "mSignatureSchemeVersion", 3);
    }

    private static Object a(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return e4.a(obj.getClass(), str).get(obj);
        } catch (Throwable th) {
            return null;
        }
    }

    private static void a(Object obj, String str, Object obj2) {
        try {
            e4.a(obj.getClass(), str).set(obj, obj2);
        } catch (Throwable th) {
        }
    }

    private static Object b() {
        Class<?> clsA = a("android.content.pm.SigningDetails");
        if (clsA == null) {
            clsA = a("android.content.pm.PackageParser$SigningDetails");
        }
        if (clsA == null) {
            return null;
        }
        try {
            return a(clsA, (Class<?>[]) new Class[]{Signature[].class, Integer.TYPE});
        } catch (Throwable th) {
            try {
                return a(clsA, (Class<?>[]) new Class[]{Signature[].class, Integer.TYPE, Class.forName("android.util.ArraySet"), Signature[].class});
            } catch (Throwable th2) {
                try {
                    return a(clsA, (Class<?>[]) new Class[]{Signature[].class, Integer.TYPE, Class.forName("android.util.ArraySet"), Signature[].class, String[].class});
                } catch (Throwable th3) {
                    return null;
                }
            }
        }
    }

    private static void a(Method method) {
        if (method.getParameterTypes().length == 0 || method.getParameterTypes()[0] != String.class) {
            return;
        }
        HookBridge.hookMethod(method, new f());
    }

    public static PackageInfo a(PackageInfo packageInfo) {
        if (packageInfo == null || Boolean.FALSE.equals(h.get()) || !"com.zhiliaoapp.musically".equals(packageInfo.packageName)) {
            return packageInfo;
        }
        packageInfo.signatures = j();
        if (Build.VERSION.SDK_INT >= 28 && packageInfo.signingInfo == null) {
            packageInfo.signingInfo = new SigningInfo();
        }
        a(packageInfo.signingInfo);
        return packageInfo;
    }

    public class h implements Parcelable.Creator<PackageInfo> {
        @Override

        public PackageInfo createFromParcel(Parcel parcel) {
            Parcelable.Creator creator = m5.c;
            if (creator != null && creator != this) {
                Boolean bool = Boolean.TRUE;
                ThreadLocal threadLocal = m5.g;
                if (!bool.equals(threadLocal.get())) {
                    Boolean bool2 = (Boolean) threadLocal.get();
                    threadLocal.set(bool);
                    try {
                        return m5.a((PackageInfo) creator.createFromParcel(parcel));
                    } finally {
                        m5.g.set(bool2);
                    }
                }
            }
            int i = v3.a;
            return new PackageInfo();
        }

        @Override

        public PackageInfo[] newArray(int i) {
            Parcelable.Creator creator = m5.c;
            if (creator != null && creator != this) {
                return (PackageInfo[]) creator.newArray(i);
            }
            return new PackageInfo[i];
        }
    }

    public static void a(Object obj) {
        if (obj == null) {
            return;
        }
        a(obj, "mInitiatingPackageName", "com.android.vending");
        a(obj, "mInstallingPackageName", "com.android.vending");
        a(obj, "mOriginatingPackageName", "com.android.vending");
        a(obj, "mUpdateOwnerPackageName", "com.android.vending");
    }

    public static void a(List<?> list) {
        if (list == null) {
            return;
        }
        for (Object obj : list) {
            if (obj instanceof PackageInfo) {
                a((PackageInfo) obj);
            }
        }
    }

    private static void a(SigningInfo signingInfo) {
        if (Build.VERSION.SDK_INT < 28 || signingInfo == null) {
            return;
        }
        Object objA = a(signingInfo, "mSigningDetails");
        if (objA == null) {
            objA = b();
            a(signingInfo, "mSigningDetails", objA);
        }
        b(objA);
        a(signingInfo, "mSigningDetails", objA);
    }

    private static Object a(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        Object[] objArr = new Object[clsArr.length];
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            Class<?> cls2 = clsArr[i2];
            if (cls2 == Signature[].class) {
                objArr[i2] = j();
            } else if (cls2 == Integer.TYPE) {
                objArr[i2] = 3;
            } else {
                objArr[i2] = null;
            }
        }
        return declaredConstructor.newInstance(objArr);
    }

    private static void a() {
        try {
            Object obj = e4.a(PackageManager.class, "sPackageInfoCache").get(null);
            if (obj != null) {
                e4.a(obj.getClass(), "clear", new Class[0]).invoke(obj, null);
            }
        } catch (Throwable th) {
        }
        try {
            Map map = (Map) e4.a(Parcel.class, "mCreators").get(null);
            if (map != null) {
                map.clear();
            }
        } catch (Throwable th2) {
        }
        try {
            Map map2 = (Map) e4.a(Parcel.class, "sPairedCreators").get(null);
            if (map2 != null) {
                map2.clear();
            }
        } catch (Throwable th3) {
        }
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
