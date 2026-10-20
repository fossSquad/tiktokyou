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

public abstract class r4 {
    public static final AtomicLong a = new AtomicLong(1);
    public static final Map b = Collections.synchronizedMap(new WeakHashMap());
    public static final ThreadLocal c = new ThreadLocal();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    public static void a(p4 p4Var) {
        b.remove(p4Var.b);
        String str = p4Var.h;
        if (str != null) {
        }
        a(Long.valueOf(p4Var.a));
    }

    public static Object a(p4 p4Var, Function0 function0) {
        ThreadLocal threadLocal = c;
        p4 p4Var2 = (p4) threadLocal.get();
        threadLocal.set(p4Var);
        try {
            return function0.invoke();
        } finally {
            c.set(p4Var2);
        }
    }

    public static q4 a(ContentValues contentValues) {
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
            q4 q4Var = (q4) obj;
            if (StringsKt.contains$default(asString, q4Var.b, false, 2, (Object) null) || StringsKt.contains$default(str, q4Var.b, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long j = ((q4) next).f;
                do {
                    Object next2 = it.next();
                    long j2 = ((q4) next2).f;
                    if (j > j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        q4 q4Var2 = (q4) next;
        if (q4Var2 == null) {
            return null;
        }
        d.remove(q4Var2.b, q4Var2);
        a(Long.valueOf(q4Var2.a), asString);
        return q4Var2;
    }

    public static void a(Object... objArr) {
        Arrays.copyOf(objArr, objArr.length);
    }

    public static void a() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Set setEntrySet = d.entrySet();
        final Function1 function1 = new Function1() {
            public final Object invoke(Object obj) {
                return Boolean.valueOf(r4.a(jElapsedRealtime, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() {
            @Override
            public final boolean test(Object obj) {
                return r4.a(function1, obj);
            }
        });
    }

    public static final boolean a(long j, Map.Entry entry) {
        return j - ((q4) entry.getValue()).f > 300000;
    }

    public static final boolean a(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }
}
