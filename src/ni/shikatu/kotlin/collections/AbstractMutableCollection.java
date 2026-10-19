package ni.shikatu.kotlin.collections;

import java.util.Collection;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableCollection;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H§\u0080\bb\u0002\b\n¢\u0006\u0002\u0010\tÊ\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractMutableCollection;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/AbstractCollection;", "<init>", "()V", "add", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;)Z", "Lni/shikatu/kotlin/IgnorableReturnValue;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractMutableCollection<E> extends java.util.AbstractCollection<E> implements Collection<E>, KMutableCollection {
    @Override
    @IgnorableReturnValue
    public abstract boolean add(E e);

    public abstract int getSize();

    protected AbstractMutableCollection() {
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }
}
