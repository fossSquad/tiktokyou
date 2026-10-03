package ni.shikatu.kotlin.internal.jdk8;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.jdk7.JDK7PlatformImplementations;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.Random;
import ni.shikatu.kotlin.random.jdk8.PlatformThreadLocalRandom;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.text.MatchGroup;
import ni.shikatu.kotlin.time.Clock;
import ni.shikatu.kotlin.time.Instant;
import ni.shikatu.kotlin.time.jdk8.InstantConversionsJDK8Kt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001fB\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082\u0080\u0004J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0080\u0004JA\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000f0\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0014\u001a\u0002H\u000fH\u0096\u0080\u0004¢\u0006\u0002\u0010\u0015JN\u0010\u0016\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000f\"\n\b\u0002\u0010\u0017*\u0004\b\u0002H\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000f0\u00182\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0019\u001a\u0002H\u0017H\u0096\u0080\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004\u0082\u0002\u0004\n\u0002\b9¨\u0006 "}, d2 = {"Lni/shikatu/kotlin/internal/jdk8/JDK8PlatformImplementations;", "Lni/shikatu/kotlin/internal/jdk7/JDK7PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", _UrlKt.FRAGMENT_ENCODE_SET, "version", _UrlKt.FRAGMENT_ENCODE_SET, "getMatchResultNamedGroup", "Lni/shikatu/kotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "getOrDefault", "V", "K", "map", _UrlKt.FRAGMENT_ENCODE_SET, "key", "default", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent", "NewV", "Ljava/util/concurrent/ConcurrentMap;", "newValue", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "defaultPlatformRandom", "Lni/shikatu/kotlin/random/Random;", "getSystemClock", "Lni/shikatu/kotlin/time/Clock;", "ReflectSdkVersion", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\u0007¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "sdkVersion", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/Integer;", "Lni/shikatu/kotlin/jvm/JvmField;", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = new ReflectSdkVersion();
        public static final Integer sdkVersion;

        private ReflectSdkVersion() {
        }

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable th) {
                num = null;
            }
            if (num != null) {
                int it = num.intValue();
                if (it > 0) {
                    num2 = num;
                }
            }
            sdkVersion = num2;
        }
    }

    private final boolean sdkIsNullOrAtLeast(int version) {
        return ReflectSdkVersion.sdkVersion == null || ReflectSdkVersion.sdkVersion.intValue() >= version;
    }

    @Override
    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        IntRange range = new IntRange(matcher.start(name), matcher.end(name) - 1);
        if (range.getStart().intValue() < 0) {
            return null;
        }
        String strGroup = matcher.group(name);
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return new MatchGroup(strGroup, range);
    }

    @Override
    public <K, V> V getOrDefault(Map<K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (sdkIsNullOrAtLeast(24)) {
            return map.getOrDefault(k, v);
        }
        V v2 = map.get(k);
        if (v2 != null) {
            return v2;
        }
        if (map.containsKey(k)) {
            return null;
        }
        return v;
    }

    @Override
    public <K, V, NewV extends V> V computeIfAbsent(ConcurrentMap<K, V> concurrentMap, K k, final NewV newv) {
        Intrinsics.checkNotNullParameter(concurrentMap, "map");
        Intrinsics.checkNotNullParameter(newv, "newValue");
        if (sdkIsNullOrAtLeast(24)) {
            final Function1 function1 = new Function1() {
                @Override
                public final Object invoke(Object obj) {
                    return JDK8PlatformImplementations.computeIfAbsent$lambda$0(newv, obj);
                }
            };
            return concurrentMap.computeIfAbsent(k, new Function() {
                @Override
                public final Object apply(Object obj) {
                    return function1.invoke(obj);
                }
            });
        }
        V vPutIfAbsent = concurrentMap.putIfAbsent(k, newv);
        return vPutIfAbsent == null ? newv : vPutIfAbsent;
    }

    public static final Object computeIfAbsent$lambda$0(Object $newValue, Object it) {
        return $newValue;
    }

    @Override
    public Random defaultPlatformRandom() {
        return sdkIsNullOrAtLeast(34) ? new PlatformThreadLocalRandom() : super.defaultPlatformRandom();
    }

    @Override
    public Clock getSystemClock() {
        return sdkIsNullOrAtLeast(26) ? new Clock() {
            @Override
            public Instant now() {
                java.time.Instant instantNow = java.time.Instant.now();
                Intrinsics.checkNotNullExpressionValue(instantNow, "now(...)");
                return InstantConversionsJDK8Kt.toKotlinInstant(instantNow);
            }
        } : new Clock() {
            @Override
            public Instant now() {
                return Instant.Companion.fromEpochMilliseconds(System.currentTimeMillis());
            }
        };
    }
}
