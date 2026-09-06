package Z;

import android.content.ContentValues;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.text.StringsKt;

public abstract class c4 {
    public static final AtomicLong a = new AtomicLong(1);
    public static final Map b = Collections.synchronizedMap(new WeakHashMap());
    public static final ThreadLocal c = new ThreadLocal();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    public static void a(a4 a4Var) {
        b.remove(a4Var.b);
        String str = a4Var.h;
        if (str != null) {
        }
        a(Long.valueOf(a4Var.a));
    }

    public static Object a(a4 a4Var, Function0 function0) {
        ThreadLocal threadLocal = c;
        a4 a4Var2 = (a4) threadLocal.get();
        threadLocal.set(a4Var);
        try {
            return function0.invoke();
        } finally {
            c.set(a4Var2);
        }
    }

    public static b4 a(ContentValues contentValues) {
        Object next;
        a();
        String asString = contentValues.getAsString("_display_name");
        if (asString == null) {
            asString = "";
        }
        String asString2 = contentValues.getAsString("relative_path");
        String str = asString2 != null ? asString2 : "";
        Collection collectionValues = d.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            b4 b4Var = (b4) obj;
            if (StringsKt.contains$default(asString, b4Var.b, false, 2, (Object) null) || StringsKt.contains$default(str, b4Var.b, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long j = ((b4) next).f;
                do {
                    Object next2 = it.next();
                    long j2 = ((b4) next2).f;
                    if (j > j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        b4 b4Var2 = (b4) next;
        if (b4Var2 == null) {
            return null;
        }
        d.remove(b4Var2.b, b4Var2);
        a(Long.valueOf(b4Var2.a), asString);
        return b4Var2;
    }

    public static void a(Object... objArr) {
        Arrays.copyOf(objArr, objArr.length);
    }

    public static void a() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Set setEntrySet = d.entrySet();
        final Function1 function1 = new Function1() {
            public final Object invoke(Object obj) {
                return Boolean.valueOf(c4.a(jElapsedRealtime, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() {
            @Override
            public final boolean test(Object obj) {
                return c4.a(function1, obj);
            }
        });
    }

    public static final boolean a(long j, Map.Entry entry) {
        return j - ((b4) entry.getValue()).f > 300000;
    }

    public static final boolean a(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }
}
