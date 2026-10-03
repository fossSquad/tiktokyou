package ni.shikatu.okhttp3.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u0005H&¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H¦\u0002¢\u0006\u0002\u0010\u000b\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lni/shikatu/okhttp3/internal/Tags;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "plus", "T", "key", "Lni/shikatu/kotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/internal/Tags;", "get", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Lni/shikatu/okhttp3/internal/EmptyTags;", "Lni/shikatu/okhttp3/internal/LinkedTags;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class Tags {
    public  Tags(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract <T> T get(KClass<T> kClass);

    public abstract <T> Tags plus(KClass<T> kClass, T t);

    private Tags() {
    }
}
