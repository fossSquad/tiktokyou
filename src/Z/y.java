package Z;

import android.content.Context;
import android.content.SharedPreferences;
import com.windukk.mod.Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class y {
    public static final y a;
    public static final ExecutorService b;

    static {
        a = new y();
        b = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return y.a(runnable);
            }
        });
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "ttmod-recipients-refresh");
        thread.setDaemon(true);
        return thread;
    }

    public static SharedPreferences b() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(Main.getApplicationContext());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context != null) {
            return context.getSharedPreferences("ttmod_streak_recipients", 0);
        }
        return null;
    }

    public static void c() throws NoWhenBranchMatchedException {
        c0 c0VarC = r.c();
        if (c0VarC instanceof b0) {
            h6.a(4, h6.a(new StringBuilder().append("Recipient refresh skipped: ").append(((b0) c0VarC).a).toString(), new Object[0]), (Throwable) null);
            return;
        }
        if (!(c0VarC instanceof a0)) {
            throw new NoWhenBranchMatchedException();
        }
        a0 a0Var = (a0) c0VarC;
        ArrayList arrayList = a0Var.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            v vVar = (v) obj;
            a.getClass();
            a(vVar.c, vVar.a, true);
        }
        h6.a(4, h6.a(new StringBuilder().append("Recipient refresh: ").append(a0Var.a.size()).append(" streak partner(s)").toString(), new Object[0]), (Throwable) null);
    }

    public static void a(Object obj, String str, boolean z) {
        Object obj2;
        String str2;
        if (StringsKt.isBlank(str)) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            SharedPreferences sharedPreferencesB = b();
            if (sharedPreferencesB == null) {
                return;
            }
            String str3 = null;
            String string = sharedPreferencesB.getString(str, null);
            if (!z && string != null) {
                return;
            }
            Object objA = z ? a(str) : null;
            String strB = b(objA);
            if (strB == null) {
                strB = a(obj, str);
            }
            String str4 = strB;
            String strA = a(objA);
            if (strA != null) {
                str3 = strA;
            } else if (string != null && !StringsKt.isBlank(string) && (str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default(string, new char[]{1}, false, 2, 2, (Object) null), 1)) != null && !StringsKt.isBlank(str2)) {
                str3 = str2;
            }
            if (str4 == null) {
                str4 = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            String str5 = str4 + "\u0001" + str3;
            if (!Intrinsics.areEqual(string, str5)) {
                sharedPreferencesB.edit().putString(str, str5).apply();
            }
            obj2 = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj2);
        if (th2 != null) {
            h6.a(6, h6.a("Failed to remember recipient", new Object[0]), th2);
        }
    }

    public static void b(final Function0 function0) {
        b.execute(new Runnable() {
            @Override
            public final void run() {
                y.a(function0);
            }
        });
    }

    public static String b(Object obj) {
        if (obj == null) {
            return null;
        }
        Iterator it = CollectionsKt.listOf(new String[]{"getDisplayName", "getNickName", "getRawNickNameForDisplay"}).iterator();
        while (it.hasNext()) {
            Object objB = dd.b(obj, (String) it.next());
            String str = objB instanceof String ? (String) objB : null;
            if (str == null || StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        return null;
    }

    public static final List a() {
        Object obj;
        List listSortedWith;
        y yVar = a;
        try {
            Result.Companion companion = Result.Companion;
            yVar.getClass();
            SharedPreferences sharedPreferencesB = b();
            if (sharedPreferencesB == null) {
                listSortedWith = CollectionsKt.emptyList();
            } else {
                Map<String, ?> all = sharedPreferencesB.getAll();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    String str = null;
                    String str2 = value instanceof String ? (String) value : null;
                    List listSplit$default = str2 != null ? StringsKt.split$default(str2, new char[]{1}, false, 2, 2, (Object) null) : null;
                    if (listSplit$default == null) {
                        listSplit$default = CollectionsKt.emptyList();
                    }
                    String str3 = (String) CollectionsKt.getOrNull(listSplit$default, 0);
                    if (str3 == null || StringsKt.isBlank(str3)) {
                        str3 = null;
                    }
                    String str4 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
                    if (str4 != null && !StringsKt.isBlank(str4)) {
                        str = str4;
                    }
                    arrayList.add(new w(key, str3, str));
                }
                listSortedWith = CollectionsKt.sortedWith(arrayList, new x());
            }
            obj = RCompat.m6constructorimpl(listSortedWith);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Failed to read recipients", new Object[0]), th2);
        }
        List listEmptyList = CollectionsKt.emptyList();
        if (RCompat.m12isFailureimpl(obj)) {
            obj = listEmptyList;
        }
        return (List) obj;
    }

    public static final void a(Function0 function0) {
        Object obj;
        y yVar = a;
        try {
            Result.Companion companion = Result.Companion;
            yVar.getClass();
            c();
            obj = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Recipient refresh failed", new Object[0]), th2);
        }
        function0.invoke();
    }

    public static Object a(String str) {
        Object obj;
        Throwable th;
        Object objInvoke;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            Object obj3 = m7.b.a(m7.a.a()).get(null);
            if (obj3 != null && (objInvoke = n7.a.a(obj3.getClass(), new Class[0]).invoke(obj3, null)) != null) {
                String[] strArr = (String[]) m7.c.c.clone();
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String str2 = strArr[i];
                        try {
                            Result.Companion companion2 = Result.Companion;
                            obj2 = RCompat.m6constructorimpl(((java.lang.reflect.Method) dd.a(objInvoke.getClass(), str2, String.class)).invoke(objInvoke, str));
                        } catch (Throwable th2) {
                            Result.Companion companion3 = Result.Companion;
                            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
                        }
                        if (RCompat.m12isFailureimpl(obj2)) {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            break;
                        }
                        i++;
                    }
                }
                obj = RCompat.m6constructorimpl(obj2);
                th = RCompat.m9exceptionOrNullimpl(obj);
                if (th != null) {
                    h6.a(6, h6.a("IMUser lookup failed for uid=%s", new Object[]{str}), th);
                }
                if (RCompat.m12isFailureimpl(obj)) {
                    return null;
                }
                return obj;
            }
            obj2 = null;
            obj = RCompat.m6constructorimpl(obj2);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th3));
        }
        th = RCompat.m9exceptionOrNullimpl(obj);
        if (th != null) {
            h6.a(6, h6.a("IMUser lookup failed for uid=%s", new Object[]{str}), th);
        }
        if (RCompat.m12isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static String a(Object obj) {
        String string;
        List listA;
        Object objFirstOrNull;
        if (obj == null) {
            return null;
        }
        Iterator it = CollectionsKt.listOf(new String[]{"getDisplayAvatar", "getAvatarMedium", "getAvatarThumb"}).iterator();
        while (it.hasNext()) {
            Object objB = dd.b(obj, (String) it.next());
            if (objB == null || (listA = dd.a(objB, "getUrlList")) == null || (objFirstOrNull = CollectionsKt.firstOrNull(listA)) == null || (string = objFirstOrNull.toString()) == null || StringsKt.isBlank(string)) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        return null;
    }

    public static String a(Object obj, String str) {
        Object obj2;
        Object next;
        Object obj3;
        Object obj4;
        try {
            Result.Companion companion = Result.Companion;
            Object obj5 = dd.a((Class) obj.getClass(), "userStreak").get(obj);
            obj2 = RCompat.m6constructorimpl(obj5 instanceof List ? (List) obj5 : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj2)) {
            obj2 = null;
        }
        List list = (List) obj2;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj4 = RCompat.m6constructorimpl(Boolean.valueOf(Intrinsics.areEqual(String.valueOf(dd.a((Class) next.getClass(), "uid").getLong(next)), str)));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj4 = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
                }
                Boolean bool = Boolean.FALSE;
                if (RCompat.m12isFailureimpl(obj4)) {
                    obj4 = bool;
                }
                if (((Boolean) obj4).booleanValue()) {
                    break;
                }
            }
        }
        if (next == null) {
            return null;
        }
        for (String str2 : CollectionsKt.listOf(new String[]{"nickname", "nickName", "userName", "name"})) {
            try {
                Result.Companion companion5 = Result.Companion;
                Object obj6 = dd.a((Class) next.getClass(), str2).get(next);
                obj3 = RCompat.m6constructorimpl(obj6 instanceof String ? (String) obj6 : null);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.Companion;
                obj3 = RCompat.m6constructorimpl(ResultKt.createFailure(th3));
            }
            if (RCompat.m12isFailureimpl(obj3)) {
                obj3 = null;
            }
            String str3 = (String) obj3;
            if (str3 == null || StringsKt.isBlank(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                return str3;
            }
        }
        return null;
    }
}
