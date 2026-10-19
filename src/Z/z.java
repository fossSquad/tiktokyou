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

public abstract class z {
    public static String a() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objInvoke;
        e9 e9Var = l9.a;
        Class<?> cls = Class.forName("X.03Rm");
        v9 v9Var = l9.b;
        Method methodA = v9Var.a(cls, new Class[0]);
        if (Modifier.isStatic(methodA.getModifiers())) {
            objInvoke = methodA.invoke(null, null);
        } else {
            Field fieldA = l9.a.a(cls);
            fieldA.setAccessible(true);
            Object obj = fieldA.get(null);
            if (obj == null) {
                return null;
            }
            objInvoke = v9Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
        }
        if (objInvoke == null || !Intrinsics.areEqual(se.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null), Boolean.TRUE)) {
            return null;
        }
        Object objInvoke2 = se.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
        String str = objInvoke2 instanceof String ? (String) objInvoke2 : null;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return str;
    }

    public static List b() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException {
        Object obj;
        e9 e9Var = mb.a;
        Field fieldA = mb.a.a(Class.forName("X.0Bh7"));
        fieldA.setAccessible(true);
        Object obj2 = fieldA.get(null);
        if (obj2 == null) {
            return null;
        }
        Class<?> cls = Class.forName("X.0CXa");
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
                g7.a(6, g7.a("Target type unavailable: %s", new Object[]{str}), (Throwable) null);
            } else {
                arrayList.add(obj);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Object objInvoke = lb.a.a(obj2.getClass(), List.class).invoke(obj2, arrayList);
        if (objInvoke instanceof List) {
            return (List) objInvoke;
        }
        return null;
    }

    public static l0 c() {
        Object k0Var;
        Object j0Var;
        String strA;
        try {
            Result.Companion companion = Result.Companion;
            String strA2 = a();
            if (strA2 == null) {
                j0Var = new k0("current user is unavailable");
            } else {
                List listB = b();
                if (listB == null) {
                    j0Var = new k0("streak list is null");
                } else {
                    ArrayList arrayList = new ArrayList(listB.size());
                    HashSet hashSet = new HashSet(listB.size());
                    for (Object obj : listB) {
                        if (obj != null && a(obj)) {
                            Object obj2 = se.a((Class) obj.getClass(), "convId").get(obj);
                            String str = obj2 instanceof String ? (String) obj2 : null;
                            if (str != null) {
                                String str2 = StringsKt.isBlank(str) ? null : str;
                                if (str2 != null && (strA = a(obj, strA2)) != null && hashSet.add(str2)) {
                                    arrayList.add(new d0(obj, strA, str2));
                                }
                            }
                        }
                    }
                    j0Var = new j0(arrayList);
                }
            }
            k0Var = Result.constructor-impl(j0Var);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            k0Var = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(k0Var);
        if (th2 != null) {
            g7.a(6, g7.a("Streak snapshot failed", new Object[0]), th2);
            String message = th2.getMessage();
            if (message == null) {
                message = "snapshot failed";
            }
            k0Var = new k0(message);
        }
        return (l0) k0Var;
    }

    public static boolean a(Object obj) {
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(nb.a.a(Class.forName("X.0IT2"), obj.getClass()).invoke(null, obj), Boolean.TRUE)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.isFailure-impl(obj2)) {
            obj2 = bool;
        }
        return ((Boolean) obj2).booleanValue();
    }

    public static String a(Object obj, String str) throws IllegalAccessException {
        Object obj2;
        Object obj3 = se.a((Class) obj.getClass(), "userStreak").get(obj);
        List list = obj3 instanceof List ? (List) obj3 : null;
        if (list == null) {
            return null;
        }
        String str2 = null;
        for (Object obj4 : list) {
            if (obj4 != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.constructor-impl(String.valueOf(se.a((Class) obj4.getClass(), "uid").getLong(obj4)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj2)) {
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
