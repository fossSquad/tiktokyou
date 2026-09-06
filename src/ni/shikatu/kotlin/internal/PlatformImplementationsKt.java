package ni.shikatu.kotlin.internal;

import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.jdk8.JDK8PlatformImplementations;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0081\u0080\u0004b\u0002\b\u000fb\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0002¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"IMPLEMENTATIONS", "Lni/shikatu/kotlin/internal/PlatformImplementations;", "Lni/shikatu/kotlin/jvm/JvmField;", "castToBaseType", "T", _UrlKt.FRAGMENT_ENCODE_SET, "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lni/shikatu/kotlin/internal/InlineOnly;", "apiVersionIsAtLeast", _UrlKt.FRAGMENT_ENCODE_SET, "major", _UrlKt.FRAGMENT_ENCODE_SET, "minor", "patch", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        JDK8PlatformImplementations jDK8PlatformImplementations = new JDK8PlatformImplementations();
        try {
            IMPLEMENTATIONS = jDK8PlatformImplementations;
        } catch (ClassCastException e) {
            ClassLoader classLoader = jDK8PlatformImplementations.getClass().getClassLoader();
            ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
            if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
            }
            throw e;
        }
    }

    private static final  <T> T castToBaseType(Object obj) throws ClassNotFoundException {
        try {
            Intrinsics.reifiedOperationMarker(1, "T");
            return (T) obj;
        } catch (ClassCastException e) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
            }
            throw e;
        }
    }

    public static final boolean apiVersionIsAtLeast(int major, int minor, int patch) {
        return KotlinVersion.CURRENT.isAtLeast(major, minor, patch);
    }
}
