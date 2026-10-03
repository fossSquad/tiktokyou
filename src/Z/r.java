package Z;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public abstract class r {
    public static String a() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objInvoke;
        z7 z7Var = g8.a;
        Class<?> cls = Class.forName("X.03XD");
        p8 p8Var = g8.b;
        Method methodA = p8Var.a(cls, new Class[0]);
        if (Modifier.isStatic(methodA.getModifiers())) {
            objInvoke = methodA.invoke(null, null);
        } else {
            Field fieldA = g8.a.a(cls);
            fieldA.setAccessible(true);
            Object obj = fieldA.get(null);
            if (obj == null) {
                return null;
            }
            objInvoke = p8Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
        }
        if (objInvoke == null || !Intrinsics.areEqual(dd.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null), Boolean.TRUE)) {
            return null;
        }
        Object objInvoke2 = dd.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
        String str = objInvoke2 instanceof String ? (String) objInvoke2 : null;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return str;
    }

    public static List b() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException {
        Object obj;
        z7 z7Var = ea.a;
        Field fieldA = ea.a.a(Class.forName("X.0BjO"));
        fieldA.setAccessible(true);
        Object obj2 = fieldA.get(null);
        if (obj2 == null) {
            return null;
        }
        Class<?> cls = Class.forName("X.0CbP");
        ArrayList arrayList = new ArrayList(2);
        String[] strArr = {"USER", "CONVERSATION"};
        int i = 0;
        for (int i2 = 2; i < i2; i2 = 2) {
            String str = strArr[i];
            Object[] enumConstants = cls.getEnumConstants();
            if (enumConstants == null) {
                obj = null;
                break;
            }
            int length = enumConstants.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    obj = null;
                    break;
                }
                obj = enumConstants[i3];
                if (Intrinsics.areEqual(((Enum) obj).name(), str)) {
                    break;
                }
                i3++;
            }
            if (obj == null) {
                h6.a(6, h6.a("Target type unavailable: %s", new Object[]{str}), (Throwable) null);
            } else {
                arrayList.add(obj);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Object objInvoke;
        try {
            objInvoke = da.a.a(obj2.getClass(), List.class).invoke(obj2, arrayList);
        } catch (Throwable t) {
            objInvoke = null;
        }
        if (objInvoke instanceof List) {
            return (List) objInvoke;
        }
        return null;
    }

    public static c0 c() {
        Object b0Var;
        Object a0Var;
        String strA;
        try {
            Result.Companion companion = Result.Companion;
            String strA2 = a();
            if (strA2 == null) {
                a0Var = new b0("current user is unavailable");
            } else {
                List listB = b();
                if (listB == null) {
                    a0Var = new b0("streak list is null");
                } else {
                    ArrayList arrayList = new ArrayList(listB.size());
                    HashSet hashSet = new HashSet(listB.size());
                    for (Object obj : listB) {
                        if (obj != null && a(obj)) {
                            Object obj2 = dd.a((Class) obj.getClass(), "convId").get(obj);
                            String str = obj2 instanceof String ? (String) obj2 : null;
                            if (str != null) {
                                String str2 = StringsKt.isBlank(str) ? null : str;
                                if (str2 != null && (strA = a(obj, strA2)) != null && hashSet.add(str2)) {
                                    arrayList.add(new v(obj, strA, str2));
                                }
                            }
                        }
                    }
                    a0Var = new a0(arrayList);
                }
            }
            b0Var = RCompat.m6constructorimpl(a0Var);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            b0Var = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(b0Var);
        if (th2 != null) {
            h6.a(6, h6.a("Streak snapshot failed", new Object[0]), th2);
            String message = th2.getMessage();
            if (message == null) {
                message = "snapshot failed";
            }
            b0Var = new b0(message);
        }
        return (c0) b0Var;
    }

    public static boolean a(Object obj) {
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            obj2 = RCompat.m6constructorimpl(Boolean.valueOf(Intrinsics.areEqual(fa.a.a(Class.forName("X.0H7z"), obj.getClass()).invoke(null, obj), Boolean.TRUE)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (RCompat.m12isFailureimpl(obj2)) {
            obj2 = bool;
        }
        return ((Boolean) obj2).booleanValue();
    }

    public static String a(Object obj, String str) throws IllegalAccessException {
        Object obj2;
        Object obj3;
        try {
            obj3 = dd.a((Class) obj.getClass(), "userStreak").get(obj);
        } catch (Throwable t) {
            obj3 = null;
        }
        List list = obj3 instanceof List ? (List) obj3 : null;
        if (list == null) {
            return null;
        }
        String str2 = null;
        for (Object obj4 : list) {
            if (obj4 != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = RCompat.m6constructorimpl(String.valueOf(dd.a((Class) obj4.getClass(), "uid").getLong(obj4)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                }
                if (RCompat.m12isFailureimpl(obj2)) {
                    obj2 = null;
                }
                String str3 = (String) obj2;
                if (str3 != null && !Intrinsics.areEqual(str3, "0")) {
                    if (str2 == null) {
                        str2 = str3;
                    }
                    if (!Intrinsics.areEqual(str3, str)) {
                        return str3;
                    }
                }
            }
        }
        if (str2 == null || Intrinsics.areEqual(str2, str)) {
            return null;
        }
        return str2;
    }
}
