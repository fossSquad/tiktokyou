package Z;

import android.content.Context;
import android.content.SharedPreferences;
import com.windukk.mod.Main;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class k0 {
    public static final k0 a;
    public static final ExecutorService b;
    public static final Object c;
    public static boolean d;
    public static Object e;
    public static volatile Object f;

    static {
        a = new k0();
        b = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return k0.a(runnable);
            }
        });
        c = new Object();
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "ttmod-streak-stickers");
        thread.setDaemon(true);
        return thread;
    }

    public static final void b(Function1 function1) {
        Object obj;
        k0 k0Var = a;
        try {
            Result.Companion companion = Result.Companion;
            k0Var.getClass();
            obj = RCompat.m6constructorimpl(c());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Failed to load streak stickers", new Object[0]), th2);
        }
        a.getClass();
        List listListOf = CollectionsKt.listOf(new d0("spark_v1", null, null, "https://p16-tiktokcdn-com.akamaized.net/obj/im-resource-tiktok/fire.webp", true));
        if (RCompat.m12isFailureimpl(obj)) {
            obj = listListOf;
        }
        function1.invoke((List) obj);
    }

    public static List c() {
        Object obj;
        List listEmptyList;
        String strC;
        d0 d0Var;
        d0 d0Var2 = new d0("spark_v1", null, null, "https://p16-tiktokcdn-com.akamaized.net/obj/im-resource-tiktok/fire.webp", true);
        LinkedHashSet linkedHashSetLinkedSetOf = SetsKt.linkedSetOf(new String[]{d0Var2.a});
        try {
            Result.Companion companion = Result.Companion;
            Object objF = f();
            if (objF != null) {
                d(objF);
            }
            List listA = a();
            if (objF == null) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                List listE = e(objF);
                if (listE.isEmpty() && listA.isEmpty()) {
                    for (int i = 0; i < 16; i++) {
                        Thread.sleep(250L);
                        listE = e(objF);
                        listE.isEmpty();
                    }
                    listEmptyList = listE;
                } else {
                    listEmptyList = listE;
                }
            }
            List listPlus = CollectionsKt.plus(listA, listEmptyList);
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listPlus) {
                String strF = f(obj2);
                if (strF == null) {
                    d0Var = null;
                } else {
                    Object objH = h(obj2);
                    String strC2 = c(dd.b(objH, "getSetId"));
                    if (strC2 == null) {
                        String strC3 = c(dd.a(objH, "setId", Object.class));
                        strC = strC3 == null ? c(dd.a(obj2, "setId", Object.class)) : strC3;
                    } else {
                        strC = strC2;
                    }
                    d0Var = new d0(strF, strF, strC, g(obj2), false);
                }
                if (d0Var != null) {
                    arrayList.add(d0Var);
                }
            }
            obj = RCompat.m6constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Favorite stickers lookup failed", new Object[0]), th2);
        }
        List listEmptyList2 = CollectionsKt.emptyList();
        if (RCompat.m12isFailureimpl(obj)) {
            obj = listEmptyList2;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : (List) obj) {
            d0 d0Var3 = (d0) obj3;
            String str = d0Var3.d;
            if (str != null && !StringsKt.isBlank(str) && linkedHashSetLinkedSetOf.add(d0Var3.a)) {
                arrayList2.add(obj3);
            }
        }
        return CollectionsKt.plus(CollectionsKt.listOf(d0Var2), arrayList2);
    }

    public static void d(Object obj) {
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls = obj.getClass();
            String strDecrypt = "refreshFavouriteStickers";
            Class cls2 = Boolean.TYPE;
            Method methodA = dd.a(cls, strDecrypt, cls2, cls2, String.class);
            String strDecrypt2 = "favourite_tab";
            Boolean bool = Boolean.TRUE;
            obj2 = RCompat.m6constructorimpl(methodA.invoke(obj, bool, bool, strDecrypt2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj2);
        if (th2 != null) {
            h6.a(6, h6.a("Favorite refresh failed", new Object[0]), th2);
        }
    }

    public static List e(Object obj) {
        Object objB = dd.b(obj, "getFavouriteStickersFlow");
        List listEmptyList = objB == null ? CollectionsKt.emptyList() : i(dd.b(objB, "getValue"));
        Object objB2 = dd.b(obj, "getRecentStickersFlow");
        return CollectionsKt.plus(listEmptyList, objB2 == null ? CollectionsKt.emptyList() : i(dd.b(objB2, "getValue")));
    }

    public static Object f() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Constructor<?> declaredConstructor = Class.forName("X.0GLu").getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            obj = RCompat.m6constructorimpl(declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Sticker store unavailable", new Object[0]), th2);
        }
        if (RCompat.m12isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static String g(Object obj) {
        Object objA;
        Object objFirstOrNull;
        String string;
        Object objH = h(obj);
        Object objB = dd.b(objH, "getAnimateUrl");
        if (objB == null) {
            objB = dd.b(objH, "getStaticUrl");
        }
        Iterator it = CollectionsKt.listOf(new String[]{"getHighResolutionUrl", "getMidResolutionUrl", "getLowResolutionUrl"}).iterator();
        do {
            if (!it.hasNext()) {
                objA = null;
                break;
            }
            objA = dd.b(objB, (String) it.next());
        } while (objA == null);
        if (objA == null && (objA = dd.a(objB, "highResolutionUrl", Object.class)) == null && (objA = dd.a(objB, "midResolutionUrl", Object.class)) == null) {
            objA = dd.a(objB, "lowResolutionUrl", Object.class);
        }
        String strA = a(objA);
        if (strA != null) {
            return strA;
        }
        Object objA2 = dd.a(obj, "stickerBase", Object.class);
        Object objA3 = dd.a(objA2, "image", Object.class);
        if (objA3 == null) {
            objA3 = dd.a(objA2, "thumbnail", Object.class);
        }
        String strA2 = a(objA3);
        if (strA2 != null) {
            return strA2;
        }
        List list = (List) dd.a(objA3, "urlList", List.class);
        if (list == null || (objFirstOrNull = CollectionsKt.firstOrNull(list)) == null || (string = objFirstOrNull.toString()) == null || !StringsKt.startsWith$default(string, "http", false, 2, (Object) null)) {
            return null;
        }
        return string;
    }

    public static Object h(Object obj) {
        Object obj2;
        Method method;
        Object objInvoke;
        String name = obj.getClass().getName();
        if (StringsKt.endsWith$default(name, ".SetSticker", false, 2, (Object) null)) {
            return obj;
        }
        try {
            Result.Companion companion = Result.Companion;
            Method[] declaredMethods = Class.forName("X.10ja").getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    String name2 = parameterTypes[0].getName();
                    if (StringsKt.endsWith$default(name2, ".StickerItem", false, 2, (Object) null)) {
                        String name3 = method.getReturnType().getName();
                        if (StringsKt.endsWith$default(name3, ".SetSticker", false, 2, (Object) null)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            }
            if (method != null) {
                method.setAccessible(true);
                objInvoke = method.invoke(null, obj);
            } else {
                objInvoke = null;
            }
            obj2 = RCompat.m6constructorimpl(objInvoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj2)) {
            return null;
        }
        return obj2;
    }

    public static List i(Object obj) {
        Object obj2;
        if (obj == null) {
            return CollectionsKt.emptyList();
        }
        if (obj instanceof List) {
            return CollectionsKt.filterNotNull((Iterable) obj);
        }
        try {
            Result.Companion companion = Result.Companion;
            obj2 = RCompat.m6constructorimpl(y7.a.a(obj.getClass(), new Class[0]).invoke(obj, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj2)) {
            obj2 = null;
        }
        List list = obj2 instanceof List ? (List) obj2 : null;
        List listFilterNotNull = list != null ? CollectionsKt.filterNotNull(list) : null;
        return listFilterNotNull == null ? CollectionsKt.emptyList() : listFilterNotNull;
    }

    public static void a(final Function1 function1) {
        b.execute(new Runnable() {
            @Override
            public final void run() {
                k0.b(function1);
            }
        });
    }

    public static boolean a(String str, String str2) {
        Object obj;
        Object objNewInstance;
        Object[] enumConstants;
        Object obj2;
        int length;
        int i;
        Object obj3;
        j0 j0VarE;
        String string;
        if (StringsKt.isBlank(str2)) {
            return false;
        }
        ta.a.getClass();
        SharedPreferences sharedPreferences = ta.b;
        String str3 = "";
        if (sharedPreferences != null && (string = sharedPreferences.getString("auto_streak_sticker", "")) != null) {
            str3 = string;
        }
        if (!StringsKt.isBlank(str3) && !Intrinsics.areEqual(str3, "spark_v1")) {
            try {
                Object objD = d();
                if (objD == null) {
                    h6.a(6, h6.a("Favorite send skipped for conv=%s: sticker not in flow/api", new Object[]{str2}), (Throwable) null);
                } else {
                    Object objB = b();
                    if (objB == null) {
                        h6.a(6, h6.a("Favorite send skipped for conv=%s: IMStickerApi is null", new Object[]{str2}), (Throwable) null);
                    } else {
                        Object objInvoke = dd.a(objB.getClass(), "getImStickerMessageService", new Class[0]).invoke(objB, null);
                        if (objInvoke == null) {
                            h6.a(6, h6.a("Favorite send skipped for conv=%s: message service is null", new Object[]{str2}), (Throwable) null);
                        } else {
                            Class<?> cls = Class.forName("X.0wbh");
                            Object[] enumConstants2 = cls.getEnumConstants();
                            if (enumConstants2 != null) {
                                int length2 = enumConstants2.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length2) {
                                        obj2 = null;
                                        break;
                                    }
                                    obj2 = enumConstants2[i2];
                                    if (Intrinsics.areEqual(((Enum) obj2).name(), "FAVOURITE_TAB")) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (obj2 == null) {
                                    enumConstants = cls.getEnumConstants();
                                    if (enumConstants != null) {
                                        length = enumConstants.length;
                                        i = 0;
                                        while (true) {
                                            if (i < length) {
                                                obj3 = null;
                                                break;
                                            }
                                            obj3 = enumConstants[i];
                                            if (Intrinsics.areEqual(((Enum) obj3).name(), "DM_STICKER_PANEL")) {
                                                break;
                                            }
                                            i++;
                                        }
                                        obj2 = obj3;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 == null) {
                                        h6.a(6, h6.a("Favorite send skipped for conv=%s: send source enum missing", new Object[]{str2}), (Throwable) null);
                                    } else {
                                        j0VarE = e();
                                        if (j0VarE == null) {
                                            h6.a(6, h6.a("Favorite send skipped for conv=%s: context is null", new Object[]{str2}), (Throwable) null);
                                        } else {
                                            dd.b(objInvoke.getClass(), j8.a.c[0], null, 13, Context.class).invoke(objInvoke, j0VarE, null, null, obj2, objD, null, null, null, str2, null, null, null, Boolean.TRUE);
                                            return true;
                                        }
                                    }
                                } else {
                                    j0VarE = e();
                                    if (j0VarE == null) {
                                        h6.a(6, h6.a("Favorite send skipped for conv=%s: context is null", new Object[]{str2}), (Throwable) null);
                                    } else {
                                        dd.b(objInvoke.getClass(), j8.a.c[0], null, 13, Context.class).invoke(objInvoke, j0VarE, null, null, obj2, objD, null, null, null, str2, null, null, null, Boolean.TRUE);
                                        return true;
                                    }
                                }
                            } else {
                                enumConstants = cls.getEnumConstants();
                                if (enumConstants != null) {
                                    length = enumConstants.length;
                                    i = 0;
                                    while (true) {
                                        if (i < length) {
                                            obj3 = null;
                                            break;
                                        }
                                        obj3 = enumConstants[i];
                                        if (Intrinsics.areEqual(((Enum) obj3).name(), "DM_STICKER_PANEL")) {
                                            break;
                                        }
                                        i++;
                                    }
                                    obj2 = obj3;
                                } else {
                                    obj2 = null;
                                }
                                if (obj2 == null) {
                                    h6.a(6, h6.a("Favorite send skipped for conv=%s: send source enum missing", new Object[]{str2}), (Throwable) null);
                                } else {
                                    j0VarE = e();
                                    if (j0VarE == null) {
                                        h6.a(6, h6.a("Favorite send skipped for conv=%s: context is null", new Object[]{str2}), (Throwable) null);
                                    } else {
                                        dd.b(objInvoke.getClass(), j8.a.c[0], null, 13, Context.class).invoke(objInvoke, j0VarE, null, null, obj2, objD, null, null, null, str2, null, null, null, Boolean.TRUE);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                h6.a(6, h6.a("Favorite sticker send failed for conv=%s", new Object[]{str2}), th);
                return false;
            }
        }
        try {
            Class<?> cls2 = Class.forName("com.ss.android.ugc.aweme.im.lightinteract.impl.serviceimpl.LightInteractionManager");
            Class<?> superclass = cls2;
            loop2: while (true) {
                if (superclass == null) {
                    obj = null;
                    break;
                }
                for (Field field : superclass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) && cls2.isAssignableFrom(field.getType())) {
                        field.setAccessible(true);
                        obj = field.get(null);
                        if (cls2.isInstance(obj)) {
                            break loop2;
                        }
                    }
                }
                superclass = superclass.getSuperclass();
            }
            if (obj != null) {
                objNewInstance = obj;
            } else {
                Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                objNewInstance = declaredConstructor.newInstance(null);
            }
            if (objNewInstance != null) {
                dd.b(cls2, null, Void.TYPE, 11, String.class, String.class, String.class, Map.class, Map.class).invoke(objNewInstance, "spark_v1", str2, str, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enter_from", "streak_inbox"), TuplesKt.to("enter_method", "auto_streak")}), null, null, null, null, null, null, null);
                return true;
            }
            return false;
        } catch (Throwable th2) {
            h6.a(6, h6.a("Fire send failed for uid=%s conv=%s", new Object[]{str, str2}), th2);
            return false;
        }
    }

    public static j0 e() {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            z7 z7Var = o7.a;
            Class<?> cls = Class.forName("X.02r4");
            Object obj3 = o7.a.a(cls).get(null);
            Context context = obj3 instanceof Context ? (Context) obj3 : null;
            if (context == null) {
                Object objInvoke = o7.b.a(cls, new Class[0]).invoke(null, null);
                context = objInvoke instanceof Context ? (Context) objInvoke : null;
            }
            obj = RCompat.m6constructorimpl(context);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Host application context lookup failed", new Object[0]), th2);
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        Context context2 = (Context) obj;
        if (context2 == null && (context2 = Main.mainApplication) == null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj2 = RCompat.m6constructorimpl(Main.getApplicationContext());
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th3));
            }
            if (RCompat.m12isFailureimpl(obj2)) {
                obj2 = null;
            }
            context2 = (Context) obj2;
        }
        if (context2 == null) {
            return null;
        }
        return new j0(context2);
    }

    public static String f(Object obj) {
        Object objH = h(obj);
        String strC = c(dd.b(objH, "getStickerId"));
        if (strC == null) {
            strC = c(dd.a(objH, "stickerId", Object.class));
        }
        return strC != null ? strC : c(dd.a(dd.a(obj, "stickerBase", Object.class), "id", Object.class));
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        String name = obj.getClass().getName();
        return StringsKt.endsWith$default(name, "GetStickerFavoritesResp", false, 2, (Object) null) || dd.a(obj, "stickers", List.class) != null;
    }

    public static Object b() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            z7 z7Var = h8.a;
            Field fieldA = h8.a.a(Class.forName("com.ss.android.ugc.aweme.im.sticker.api.IMStickerApi"));
            fieldA.setAccessible(true);
            Object obj2 = fieldA.get(null);
            obj = RCompat.m6constructorimpl(obj2 == null ? null : i8.a.a(obj2.getClass(), new Class[0]).invoke(obj2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("IMStickerApi unavailable", new Object[0]), th2);
        }
        if (RCompat.m12isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static Object d() throws InterruptedException {
        String strDecrypt;
        String strDecrypt2;
        List listA;
        Object objA;
        List listCreateListBuilder;
        ArrayList arrayList;
        Object objA2;
        String strF;
        int i;
        Object objA3;
        Object obj;
        synchronized (c) {
            if (d) {
                return e;
            }
            Unit unit = Unit.INSTANCE;
            ta taVar = ta.a;
            taVar.getClass();
            SharedPreferences sharedPreferences = ta.b;
            if (sharedPreferences == null || (strDecrypt = sharedPreferences.getString("auto_streak_sticker_id", "")) == null) {
                strDecrypt = "";
            }
            if (StringsKt.isBlank(strDecrypt)) {
                a.getClass();
                taVar.getClass();
                SharedPreferences sharedPreferences2 = ta.b;
                if (sharedPreferences2 == null || (strDecrypt = sharedPreferences2.getString("auto_streak_sticker", "")) == null) {
                    strDecrypt = "";
                }
                if (StringsKt.isBlank(strDecrypt)) {
                    strDecrypt = "spark_v1";
                }
            }
            taVar.getClass();
            SharedPreferences sharedPreferences3 = ta.b;
            if (sharedPreferences3 == null || (strDecrypt2 = sharedPreferences3.getString("auto_streak_sticker", "")) == null) {
                strDecrypt2 = "";
            }
            if (StringsKt.isBlank(strDecrypt2)) {
                strDecrypt2 = "spark_v1";
            }
            Object objF = f();
            if (objF != null) {
                objA2 = a(strDecrypt, strDecrypt2, e(objF), "flow");
                if (objA2 == null) {
                    d(objF);
                    objA2 = a(strDecrypt, strDecrypt2, e(objF), "flow-after-refresh");
                    if (objA2 == null) {
                        listA = a();
                        objA = a(strDecrypt, strDecrypt2, listA, "api");
                        if (objA != null) {
                            objA2 = objA;
                        } else if (objF != null) {
                            i = 0;
                            while (true) {
                                if (i < 16) {
                                    Thread.sleep(250L);
                                    a.getClass();
                                    objA3 = a(strDecrypt, strDecrypt2, e(objF), "flow-wait");
                                    if (objA3 != null) {
                                        objA2 = objA3;
                                    } else {
                                        i++;
                                    }
                                } else {
                                    listCreateListBuilder = CollectionsKt.createListBuilder();
                                    if (objF != null) {
                                        a.getClass();
                                        listCreateListBuilder.addAll(e(objF));
                                    }
                                    listCreateListBuilder.addAll(listA);
                                    List listBuild = CollectionsKt.build(listCreateListBuilder);
                                    arrayList = new ArrayList();
                                    for (Object obj2 : listBuild) {
                                        a.getClass();
                                        strF = f(obj2);
                                        if (strF != null) {
                                            arrayList.add(strF);
                                        }
                                    }
                                    objA2 = null;
                                    h6.a(6, h6.a("Selected sticker not found: wantedId=%s wantedName=%s repo=%s available=%s", new Object[]{strDecrypt, strDecrypt2, Boolean.valueOf(objF != null), CollectionsKt.take(CollectionsKt.distinct(arrayList), 20)}), (Throwable) null);
                                }
                            }
                        } else {
                            listCreateListBuilder = CollectionsKt.createListBuilder();
                            if (objF != null) {
                                a.getClass();
                                listCreateListBuilder.addAll(e(objF));
                            }
                            listCreateListBuilder.addAll(listA);
                            List listBuild2 = CollectionsKt.build(listCreateListBuilder);
                            arrayList = new ArrayList();
                            for (Object obj2 : listBuild2) {
                                a.getClass();
                                strF = f(obj2);
                                if (strF != null) {
                                    arrayList.add(strF);
                                }
                            }
                            objA2 = null;
                            h6.a(6, h6.a("Selected sticker not found: wantedId=%s wantedName=%s repo=%s available=%s", new Object[]{strDecrypt, strDecrypt2, Boolean.valueOf(objF != null), CollectionsKt.take(CollectionsKt.distinct(arrayList), 20)}), (Throwable) null);
                        }
                    }
                }
            } else {
                listA = a();
                objA = a(strDecrypt, strDecrypt2, listA, "api");
                if (objA != null) {
                    objA2 = objA;
                } else if (objF != null) {
                    i = 0;
                    while (true) {
                        if (i < 16) {
                            Thread.sleep(250L);
                            a.getClass();
                            objA3 = a(strDecrypt, strDecrypt2, e(objF), "flow-wait");
                            if (objA3 != null) {
                                objA2 = objA3;
                            } else {
                                i++;
                            }
                        } else {
                            listCreateListBuilder = CollectionsKt.createListBuilder();
                            if (objF != null) {
                                a.getClass();
                                listCreateListBuilder.addAll(e(objF));
                            }
                            listCreateListBuilder.addAll(listA);
                            List listBuild3 = CollectionsKt.build(listCreateListBuilder);
                            arrayList = new ArrayList();
                            for (Object obj2 : listBuild3) {
                                a.getClass();
                                strF = f(obj2);
                                if (strF != null) {
                                    arrayList.add(strF);
                                }
                            }
                            objA2 = null;
                            h6.a(6, h6.a("Selected sticker not found: wantedId=%s wantedName=%s repo=%s available=%s", new Object[]{strDecrypt, strDecrypt2, Boolean.valueOf(objF != null), CollectionsKt.take(CollectionsKt.distinct(arrayList), 20)}), (Throwable) null);
                        }
                    }
                } else {
                    listCreateListBuilder = CollectionsKt.createListBuilder();
                    if (objF != null) {
                        a.getClass();
                        listCreateListBuilder.addAll(e(objF));
                    }
                    listCreateListBuilder.addAll(listA);
                    List listBuild4 = CollectionsKt.build(listCreateListBuilder);
                    arrayList = new ArrayList();
                    for (Object obj2 : listBuild4) {
                        a.getClass();
                        strF = f(obj2);
                        if (strF != null) {
                            arrayList.add(strF);
                        }
                    }
                    objA2 = null;
                    h6.a(6, h6.a("Selected sticker not found: wantedId=%s wantedName=%s repo=%s available=%s", new Object[]{strDecrypt, strDecrypt2, Boolean.valueOf(objF != null), CollectionsKt.take(CollectionsKt.distinct(arrayList), 20)}), (Throwable) null);
                }
            }
            synchronized (c) {
                if (!d) {
                    e = objA2;
                    d = true;
                }
                obj = e;
            }
            return obj;
        }
    }

    public static Object a(Class cls) throws IllegalAccessException, ClassNotFoundException {
        Object obj = f;
        if (obj != null) {
            return obj;
        }
        ClassLoader classLoader = cls.getClassLoader();
        z7 z7Var = x7.a;
        Class<?> cls2 = Class.forName("X.03We", false, classLoader);
        Object obj2;
        try {
            obj2 = x7.a.a(cls2).get(null);
        } catch (Throwable t) {
            obj2 = null;
        }
        if (obj2 != null) {
            f = obj2;
            return obj2;
        }
        throw new IllegalStateException(new StringBuilder().append(cls2.getName()).append(".INSTANCE is null").toString());
    }

    public static List a() {
        Object obj;
        Throwable th;
        List listEmptyList;
        List listEmptyList2;
        List listFilterNotNull;
        try {
            Result.Companion companion = Result.Companion;
            p8 p8Var = aa.a;
            Object objInvoke = aa.a.a(Class.forName("X.0BoX"), new Class[0]).invoke(null, null);
            if (objInvoke == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                Class<?> cls = Class.forName("X.03XF");
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final Object[] objArr = new Object[1];
                final Object objA = a((Class) cls);
                Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                    @Override
                    public final Object invoke(Object obj2, Method method, Object[] objArr2) {
                        return k0.a(objA, objArr, countDownLatch, obj2, method, objArr2);
                    }
                });
                Class<?> cls2 = objInvoke.getClass();
                String strDecrypt = "LJFF";
                Class cls3 = Long.TYPE;
                Object objInvoke2 = dd.b(cls2, strDecrypt, null, 5, cls3, cls3, Boolean.TYPE, String.class).invoke(objInvoke, 0L, 80L, Boolean.FALSE, "favourite_tab", objNewProxyInstance);
                if (!b(objInvoke2)) {
                    if (!countDownLatch.await(8L, TimeUnit.SECONDS)) {
                        h6.a(6, h6.a("Favorites API timed out", new Object[0]), (Throwable) null);
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        objInvoke2 = objArr[0];
                    }
                }
                if (objInvoke2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    if (!(objInvoke2 instanceof Throwable)) {
                        String name = objInvoke2.getClass().getName();
                        if (!StringsKt.endsWith$default(name, "Failure", false, 2, (Object) null) && !StringsKt.contains$default(name, "Result$Failure", false, 2, (Object) null)) {
                            List listA = (List) dd.a(objInvoke2, "stickers", List.class);
                            if (listA == null) {
                                listA = dd.a(objInvoke2, "getStickers");
                            }
                            listFilterNotNull = listA != null ? CollectionsKt.filterNotNull(listA) : null;
                            if (listFilterNotNull == null) {
                                listEmptyList2 = CollectionsKt.emptyList();
                            }
                            obj = RCompat.m6constructorimpl(listFilterNotNull);
                            th = RCompat.m9exceptionOrNullimpl(obj);
                            if (th != null) {
                                h6.a(6, h6.a("Favorites API lookup failed", new Object[0]), th);
                            }
                            listEmptyList = CollectionsKt.emptyList();
                            if (RCompat.m12isFailureimpl(obj)) {
                                obj = listEmptyList;
                            }
                            return (List) obj;
                        }
                    }
                    h6.a(6, h6.a("Favorites API failed: %s", new Object[]{objInvoke2}), (Throwable) null);
                    listEmptyList2 = CollectionsKt.emptyList();
                }
            }
            listFilterNotNull = listEmptyList2;
            obj = RCompat.m6constructorimpl(listFilterNotNull);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
        }
        th = RCompat.m9exceptionOrNullimpl(obj);
        if (th != null) {
            h6.a(6, h6.a("Favorites API lookup failed", new Object[0]), th);
        }
        listEmptyList = CollectionsKt.emptyList();
        if (RCompat.m12isFailureimpl(obj)) {
            obj = listEmptyList;
        }
        return (List) obj;
    }

    public static final Object a(Object obj, Object[] objArr, CountDownLatch countDownLatch, Object obj2, Method method, Object[] objArr2) {
        String name = method.getName();
        if (Intrinsics.areEqual(name, "getContext")) {
            return obj;
        }
        if (Intrinsics.areEqual(name, "resumeWith")) {
            objArr[0] = objArr2 != null ? ArraysKt.firstOrNull(objArr2) : null;
            countDownLatch.countDown();
        }
        return null;
    }

    public static String a(Object obj) {
        Object objFirstOrNull;
        String string;
        if (obj == null) {
            return null;
        }
        List listA = dd.a(obj, "getUrlList");
        if (listA == null) {
            listA = (List) dd.a(obj, "urlList", List.class);
        }
        if (listA == null || (objFirstOrNull = CollectionsKt.firstOrNull(listA)) == null || (string = objFirstOrNull.toString()) == null || !StringsKt.startsWith$default(string, "http", false, 2, (Object) null)) {
            return null;
        }
        return string;
    }

    public static final Object a(String str, String str2, List list, String str3) {
        Object next;
        List listListOfNotNull;
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            a.getClass();
            String strF = f(next);
            Object objH = h(next);
            String strC = c(dd.b(objH, "getSetId"));
            if (strC == null && (strC = c(dd.a(objH, "setId", Object.class))) == null) {
                strC = c(dd.a(next, "setId", Object.class));
            }
            listListOfNotNull = CollectionsKt.listOfNotNull(new String[]{strF, strC});
            if (listListOfNotNull.contains(str)) {
                break;
            }
        } while (!listListOfNotNull.contains(str2));
        if (next != null) {
            h6.a(4, h6.a("Resolved favorite sticker from %s: %s", new Object[]{str3, str}), (Throwable) null);
        }
        return next;
    }

    public static String c(Object obj) {
        if (obj instanceof Long) {
            if (((Number) obj).longValue() == 0) {
                obj = null;
            }
            Long l = (Long) obj;
            if (l != null) {
                return String.valueOf(l.longValue());
            }
            return null;
        }
        if (!(obj instanceof Number)) {
            if (!(obj instanceof String)) {
                return null;
            }
            if (StringsKt.isBlank((String) obj)) {
                obj = null;
            }
            return (String) obj;
        }
        long jLongValue = ((Number) obj).longValue();
        Long lValueOf = Long.valueOf(jLongValue);
        if (jLongValue == 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            return String.valueOf(lValueOf.longValue());
        }
        return null;
    }
}
