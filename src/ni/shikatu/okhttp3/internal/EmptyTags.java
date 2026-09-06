package ni.shikatu.okhttp3.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\b\u0010\t\u001a\u0004\u0018\u0001H\u0005H\u0016¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0096\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lni/shikatu/okhttp3/internal/EmptyTags;", "Lni/shikatu/okhttp3/internal/Tags;", "<init>", "()V", "plus", "T", _UrlKt.FRAGMENT_ENCODE_SET, "key", "Lni/shikatu/kotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/internal/Tags;", "get", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmptyTags extends Tags {
    public static final EmptyTags INSTANCE = new EmptyTags();

    private EmptyTags() {
        super(null);
    }

    @Override
    public <T> Tags plus(KClass<T> kClass, T t) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        return t != null ? new LinkedTags(kClass, t, this) : this;
    }

    @Override
    public <T> T get(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        return null;
    }

    public String toString() {
        return "{}";
    }
}
