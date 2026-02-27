package ni.shikatu.kotlin.concurrent;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lni/shikatu/kotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ThreadsKt {
    public static  Thread thread$default(boolean z, boolean z2, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            classLoader = null;
        }
        if ((i2 & 8) != 0) {
            str = null;
        }
        if ((i2 & 16) != 0) {
            i = -1;
        }
        int i3 = i;
        String str2 = str;
        return thread(z, z2, classLoader, str2, i3, function0);
    }

    public static final Thread thread(boolean start, boolean isDaemon, ClassLoader contextClassLoader, String name, int priority, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        ?? r0 = new Thread() {
            @Override
            public void run() {
                function0.invoke();
            }
        };
        if (isDaemon) {
            r0.setDaemon(true);
        }
        if (priority > 0) {
            r0.setPriority(priority);
        }
        if (name != null) {
            r0.setName(name);
        }
        if (contextClassLoader != null) {
            r0.setContextClassLoader(contextClassLoader);
        }
        if (start) {
            r0.start();
        }
        return (Thread) r0;
    }

    private static final <T> T getOrSet(ThreadLocal<T> threadLocal, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(threadLocal, "<this>");
        Intrinsics.checkNotNullParameter(function0, "default");
        T t = threadLocal.get();
        if (t != null) {
            return t;
        }
        T tInvoke = function0.invoke();
        threadLocal.set(tInvoke);
        return tInvoke;
    }
}
