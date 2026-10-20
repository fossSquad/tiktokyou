package Z;

import android.content.Context;
import android.content.SharedPreferences;
import com.windukk.mod.Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;

public final class g0 {
    public static final g0 a;
    public static volatile LinkedHashMap b;
    public static final ExecutorService c;

    static {
        a = new g0();
        c = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return g0.a(runnable);
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
            obj = ResultCompat.constructor(Main.getApplicationContext());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        if (ResultCompat.isFailure(obj)) {
            obj = null;
        }
        Context context = (Context) obj;
        if (context != null) {
            return context.getSharedPreferences("ttmod_streak_recipients", 0);
        }
        return null;
    }

    public static void c() throws NoWhenBranchMatchedException {
        l0 l0VarC = z.c();
        if (l0VarC instanceof k0) {
            g7.a(4, g7.a("Recipient refresh skipped: " + ((k0) l0VarC).a, new Object[0]), (Throwable) null);
            return;
        }
        if (!(l0VarC instanceof j0)) {
            throw new NoWhenBranchMatchedException();
        }
        j0 j0Var = (j0) l0VarC;
        ArrayList arrayList = j0Var.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            d0 d0Var = (d0) obj;
            a.getClass();
            a(d0Var.c, d0Var.a, true);
        }
        a((List) j0Var.a);
        g7.a(4, g7.a((new StringBuilder().append("Recipient refresh: ").append(j0Var.a.size())).append(" streak partner(s)").toString(), new Object[0]), (Throwable) null);
    }

    public static void a(Object obj, String str, boolean z) {
        Object obj2;
        String str2;
        String str3;
        String string;
        String str4;
        String string2;
        if (StringsKt.isBlank(str)) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            SharedPreferences sharedPreferencesB = b();
            if (sharedPreferencesB == null) {
                return;
            }
            String str5 = null;
            String string3 = sharedPreferencesB.getString(str, null);
            if (!z && string3 != null) {
                return;
            }
            Object objA = z ? a(str) : null;
            String strB = b(objA);
            if (strB == null) {
                strB = a(obj, str);
            }
            if (strB != null) {
                CharSequence charSequenceB = v1.b((CharSequence) strB);
                String string4 = charSequenceB != null ? charSequenceB.toString() : null;
                if (string4 == null || (string2 = StringsKt.trim(string4).toString()) == null || StringsKt.isBlank(string2)) {
                    string2 = null;
                }
                if (string2 != null) {
                    str2 = string2;
                } else if (string3 != null) {
                    str2 = null;
                } else {
                    str2 = null;
                }
            } else if (string3 != null || StringsKt.isBlank(string3) || (str3 = (String) CollectionsKt.getOrNull(StringsKt.split$default(string3, new char[]{1}, false, 2, 2, (Object) null), 0)) == null) {
                str2 = null;
            } else {
                CharSequence charSequenceB2 = v1.b((CharSequence) str3);
                String string5 = charSequenceB2 != null ? charSequenceB2.toString() : null;
                if (string5 == null || (string = StringsKt.trim(string5).toString()) == null || StringsKt.isBlank(string)) {
                    str2 = null;
                } else {
                    str2 = string;
                }
            }
            String strA = a(objA);
            if (strA != null) {
                str5 = strA;
            } else if (string3 != null && !StringsKt.isBlank(string3) && (str4 = (String) CollectionsKt.getOrNull(StringsKt.split$default(string3, new char[]{1}, false, 2, 2, (Object) null), 1)) != null && !StringsKt.isBlank(str4)) {
                str5 = str4;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (str5 == null) {
                str5 = "";
            }
            String str6 = str2 + "\u0001" + str5;
            if (!Intrinsics.areEqual(string3, str6)) {
                sharedPreferencesB.edit().putString(str, str6).apply();
            }
            obj2 = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj2);
        if (th2 != null) {
            g7.a(6, g7.a("Failed to remember recipient", new Object[0]), th2);
        }
    }

    public static void b(final Function0 function0) {
        c.execute(new Runnable() {
            @Override
            public final void run() {
                g0.a(function0);
            }
        });
    }

    public static String b(Object obj) {
        if (obj == null) {
            return null;
        }
        Iterator it = CollectionsKt.listOf(new String[]{"getDisplayName", "getNickName", "getRawNickNameForDisplay"}).iterator();
        while (it.hasNext()) {
            Object objB = se.b(obj, (String) it.next());
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
        String string;
        Integer num;
        g0 g0Var = a;
        try {
            Result.Companion companion = Result.Companion;
            g0Var.getClass();
            SharedPreferences sharedPreferencesB = b();
            if (sharedPreferencesB == null) {
                listSortedWith = CollectionsKt.emptyList();
            } else {
                LinkedHashMap linkedHashMap = b;
                Map<String, ?> all = sharedPreferencesB.getAll();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    String str = null;
                    e0 e0Var = null;
                    str = null;
                    if (linkedHashMap == null || linkedHashMap.containsKey(key)) {
                        String str2 = value instanceof String ? (String) value : null;
                        List listSplit$default = str2 != null ? StringsKt.split$default(str2, new char[]{1}, false, 2, 2, (Object) null) : null;
                        if (listSplit$default == null) {
                            listSplit$default = CollectionsKt.emptyList();
                        }
                        String str3 = (String) CollectionsKt.getOrNull(listSplit$default, 0);
                        if (str3 == null) {
                            string = null;
                        } else {
                            CharSequence charSequenceB = v1.b((CharSequence) str3);
                            String string2 = charSequenceB != null ? charSequenceB.toString() : null;
                            if (string2 == null || (string = StringsKt.trim(string2).toString()) == null || StringsKt.isBlank(string)) {
                                string = null;
                            }
                        }
                        String str4 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
                        if (str4 != null && !StringsKt.isBlank(str4)) {
                            str = str4;
                        }
                        e0Var = new e0(key, string, str, (linkedHashMap == null || (num = (Integer) linkedHashMap.get(key)) == null) ? 0 : num.intValue());
                    }
                    if (e0Var != null) {
                        arrayList.add(e0Var);
                    }
                }
                listSortedWith = CollectionsKt.sortedWith(arrayList, new f0());
            }
            obj = ResultCompat.constructor(listSortedWith);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Failed to read recipients", new Object[0]), th2);
        }
        List listEmptyList = CollectionsKt.emptyList();
        if (ResultCompat.isFailure(obj)) {
            obj = listEmptyList;
        }
        return (List) obj;
    }

    public static final void a(Function0 function0) {
        Object obj;
        g0 g0Var = a;
        try {
            Result.Companion companion = Result.Companion;
            g0Var.getClass();
            c();
            obj = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Recipient refresh failed", new Object[0]), th2);
        }
        function0.invoke();
    }

    public static Object a(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = ResultCompat.constructor(m8.b.a(m8.a.a(), String.class).invoke(null, str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("IMUser lookup failed for uid=%s", new Object[]{str}), th2);
        }
        if (ResultCompat.isFailure(obj)) {
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
            Object objB = se.b(obj, (String) it.next());
            if (objB == null || (listA = se.a(objB, "getUrlList")) == null || (objFirstOrNull = CollectionsKt.firstOrNull(listA)) == null || (string = objFirstOrNull.toString()) == null || StringsKt.isBlank(string)) {
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
            Object obj5 = se.a((Class) obj.getClass(), "userStreak").get(obj);
            obj2 = ResultCompat.constructor(obj5 instanceof List ? (List) obj5 : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        if (ResultCompat.isFailure(obj2)) {
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
                    obj4 = ResultCompat.constructor(Boolean.valueOf(Intrinsics.areEqual(String.valueOf(se.a((Class) next.getClass(), "uid").getLong(next)), str)));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj4 = ResultCompat.constructor(ResultKt.createFailure(th2));
                }
                Boolean bool = Boolean.FALSE;
                if (ResultCompat.isFailure(obj4)) {
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
                Object obj6 = se.a((Class) next.getClass(), str2).get(next);
                obj3 = ResultCompat.constructor(obj6 instanceof String ? (String) obj6 : null);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.Companion;
                obj3 = ResultCompat.constructor(ResultKt.createFailure(th3));
            }
            if (ResultCompat.isFailure(obj3)) {
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

    public static void a(List list) {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d0 d0Var = (d0) it.next();
            String str = d0Var.a;
            g0 g0Var = a;
            Object obj2 = d0Var.c;
            g0Var.getClass();
            try {
                Result.Companion companion = Result.Companion;
                Object obj3 = se.a((Class) obj2.getClass(), "streak").get(obj2);
                obj = ResultCompat.constructor(obj3 instanceof Integer ? (Integer) obj3 : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th));
            }
            Integer num = (Integer) (ResultCompat.isFailure(obj) ? null : obj);
            Pair pair = TuplesKt.to(str, Integer.valueOf(num != null ? num.intValue() : 0));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        b = linkedHashMap;
    }
}
