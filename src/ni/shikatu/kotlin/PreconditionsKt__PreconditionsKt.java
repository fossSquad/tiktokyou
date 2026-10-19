package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\u0004b\u0002\b\u0004ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a8\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\tH\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001aI\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\f\u001a!\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a2\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\u0004b\u0002\b\u0004ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a8\u0010\u000e\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\tH\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001aI\u0010\u000e\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\f\u001a\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"require", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "lazyMessage", "Lni/shikatu/kotlin/Function0;", _UrlKt.FRAGMENT_ENCODE_SET, "requireNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "check", "checkNotNull", "error", _UrlKt.FRAGMENT_ENCODE_SET, "message", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/PreconditionsKt")
class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    private static final void require(boolean value) {
        if (!value) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final void require(boolean value, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!value) {
            Object message = function0.invoke();
            throw new IllegalArgumentException(message.toString());
        }
    }

    @IgnorableReturnValue
    private static final <T> T requireNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @IgnorableReturnValue
    private static final <T> T requireNotNull(T t, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (t == null) {
            Object message = function0.invoke();
            throw new IllegalArgumentException(message.toString());
        }
        return t;
    }

    private static final void check(boolean value) {
        if (!value) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private static final void check(boolean value, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!value) {
            Object message = function0.invoke();
            throw new IllegalStateException(message.toString());
        }
    }

    @IgnorableReturnValue
    private static final <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @IgnorableReturnValue
    private static final <T> T checkNotNull(T t, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (t == null) {
            Object message = function0.invoke();
            throw new IllegalStateException(message.toString());
        }
        return t;
    }

    private static final Void error(Object message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new IllegalStateException(message.toString());
    }
}
