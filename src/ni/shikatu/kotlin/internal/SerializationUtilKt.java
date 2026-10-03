package ni.shikatu.kotlin.internal;

import java.io.InvalidObjectException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0081\u0088\u0004b\u0002\b\u0002ø\u0001\u0000*\f\b\u0000\u0010\u0007\"\u00020\b2\u00020\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"throwReadObjectNotSupported", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "wrapAsDeserializationException", _UrlKt.FRAGMENT_ENCODE_SET, "action", "Lni/shikatu/kotlin/Function0;", "ReadObjectParameterType", "Ljava/io/ObjectInputStream;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class SerializationUtilKt {
    private static final Void throwReadObjectNotSupported() throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private static final void wrapAsDeserializationException(Function0<Unit> function0) throws Throwable {
        Intrinsics.checkNotNullParameter(function0, "action");
        try {
            function0.invoke();
        } catch (Throwable e) {
            Throwable thInitCause = new InvalidObjectException(e.getMessage()).initCause(e);
            Intrinsics.checkNotNullExpressionValue(thInitCause, "initCause(...)");
            throw thInitCause;
        }
    }
}
