package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004¨\u0006\t"}, d2 = {"lazy", "Lni/shikatu/kotlin/Lazy;", "T", "initializer", "Lni/shikatu/kotlin/Function0;", "mode", "Lni/shikatu/kotlin/LazyThreadSafetyMode;", "lock", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/LazyKt")
public class LazyKt__LazyJVMKt {

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            try {
                iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        DefaultConstructorMarker defaultConstructorMarker = null;
        return new SynchronizedLazyImpl(function0, defaultConstructorMarker, 2, defaultConstructorMarker);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode mode, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
            case 1:
                DefaultConstructorMarker defaultConstructorMarker = null;
                return new SynchronizedLazyImpl(function0, defaultConstructorMarker, 2, defaultConstructorMarker);
            case 2:
                return new SafePublicationLazyImpl(function0);
            case 3:
                return new UnsafeLazyImpl(function0);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final <T> Lazy<T> lazy(Object lock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new SynchronizedLazyImpl(function0, lock);
    }
}
