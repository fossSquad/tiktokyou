package ni.shikatu.kotlin.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.MatchResult;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.FallbackThreadLocalRandom;
import ni.shikatu.kotlin.random.Random;
import ni.shikatu.kotlin.text.MatchGroup;
import ni.shikatu.kotlin.time.Clock;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\"B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0080\u0004J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0080\u0004J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004JA\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00160\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001b\u001a\u0002H\u0016H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001cJN\u0010\u001d\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0016\"\n\b\u0002\u0010\u001e*\u0004\b\u0002H\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00160\u001f2\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010 \u001a\u0002H\u001eH\u0096\u0080\u0004ø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0004\n\u0002\b9¨\u0006#"}, d2 = {"Lni/shikatu/kotlin/internal/PlatformImplementations;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "addSuppressed", _UrlKt.FRAGMENT_ENCODE_SET, "cause", _UrlKt.FRAGMENT_ENCODE_SET, "exception", "getSuppressed", _UrlKt.FRAGMENT_ENCODE_SET, "getMatchResultNamedGroup", "Lni/shikatu/kotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "defaultPlatformRandom", "Lni/shikatu/kotlin/random/Random;", "getSystemClock", "Lni/shikatu/kotlin/time/Clock;", "getOrDefault", "V", "K", "map", _UrlKt.FRAGMENT_ENCODE_SET, "key", "default", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent", "NewV", "Ljava/util/concurrent/ConcurrentMap;", "newValue", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "ReflectThrowable", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/internal/PlatformImplementations$ReflectThrowable;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "Lni/shikatu/kotlin/jvm/JvmField;", "getSuppressed", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = new ReflectThrowable();
        public static final Method addSuppressed;
        public static final Method getSuppressed;

        private ReflectThrowable() {
        }

        static {
            Method method;
            Method it;
            boolean z;
            Method[] throwableMethods = Throwable.class.getMethods();
            Intrinsics.checkNotNull(throwableMethods);
            int length = throwableMethods.length;
            int i = 0;
            while (true) {
                method = null;
                if (i >= length) {
                    it = null;
                    break;
                }
                it = throwableMethods[i];
                if (Intrinsics.areEqual(it.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = it.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                    if (Intrinsics.areEqual(ArraysKt.singleOrNull(parameterTypes), Throwable.class)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    break;
                } else {
                    i++;
                }
            }
            addSuppressed = it;
            for (Method it2 : throwableMethods) {
                if (Intrinsics.areEqual(it2.getName(), "getSuppressed")) {
                    method = it2;
                    break;
                }
            }
            getSuppressed = method;
        }
    }

    public void addSuppressed(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public List<Throwable> getSuppressed(Throwable exception) {
        Object it;
        List<Throwable> listAsList;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.getSuppressed;
        if (method != null && (it = method.invoke(exception, new Object[0])) != null && (listAsList = ArraysKt.asList((Throwable[]) it)) != null) {
            return listAsList;
        }
        return CollectionsKt.emptyList();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    public Clock getSystemClock() {
        throw new UnsupportedOperationException("getSystemClock should not be called on the base PlatformImplementations.");
    }

    public <K, V> V getOrDefault(Map<K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "map");
        throw new UnsupportedOperationException("getOrDefault should not be called on the base PlatformImplementations.");
    }

    public <K, V, NewV extends V> V computeIfAbsent(ConcurrentMap<K, V> concurrentMap, K k, NewV newv) {
        Intrinsics.checkNotNullParameter(concurrentMap, "map");
        Intrinsics.checkNotNullParameter(newv, "newValue");
        throw new UnsupportedOperationException("computeIfAbsent should not be called on the base PlatformImplementations.");
    }
}
