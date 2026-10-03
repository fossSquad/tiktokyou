package ni.shikatu.kotlinx.serialization.internal;

import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.MissingFieldException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0087\u0080\u0004\u001a\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0087\u0080\u0004¨\u0006\b"}, d2 = {"jsonCachedSerialNames", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "missingFieldExceptionWithNewMessage", "Lni/shikatu/kotlinx/serialization/MissingFieldException;", "exception", "message", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonInternalDependenciesKt {
    @CoreFriendModuleApi
    public static final Set<String> jsonCachedSerialNames(SerialDescriptor $this$jsonCachedSerialNames) {
        Intrinsics.checkNotNullParameter($this$jsonCachedSerialNames, "<this>");
        return Platform_commonKt.cachedSerialNames($this$jsonCachedSerialNames);
    }

    @CoreFriendModuleApi
    @ExperimentalSerializationApi
    public static final MissingFieldException missingFieldExceptionWithNewMessage(MissingFieldException exception, String message) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(message, "message");
        return exception.withNewMessageInternal$kotlinx_serialization_core(message);
    }
}
