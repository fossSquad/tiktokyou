package ni.shikatu.kotlin.internal.jdk8;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.jdk7.JDK7PlatformImplementations;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.Random;
import ni.shikatu.kotlin.random.jdk8.PlatformThreadLocalRandom;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.text.MatchGroup;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlin/internal/jdk8/JDK8PlatformImplementations;", "Lni/shikatu/kotlin/internal/jdk7/JDK7PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", "", "version", "", "getMatchResultNamedGroup", "Lni/shikatu/kotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "defaultPlatformRandom", "Lni/shikatu/kotlin/random/Random;", "ReflectSdkVersion", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "<init>", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
    public Random defaultPlatformRandom() {
        return sdkIsNullOrAtLeast(34) ? new PlatformThreadLocalRandom() : super.defaultPlatformRandom();
    }
}
