package ni.shikatu.kotlin.collections;

import java.util.List;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableList;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H§\u0082\bb\u0002\b\u000b¢\u0006\u0002\u0010\nJ\u001b\u0010\f\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH§\u0080\bb\u0002\b\u000b¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\u0010Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractMutableList;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/AbstractList;", "<init>", "()V", "set", "index", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "removeAt", "(I)Ljava/lang/Object;", "add", _UrlKt.FRAGMENT_ENCODE_SET, "(ILjava/lang/Object;)V", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractMutableList<E> extends java.util.AbstractList<E> implements List<E>, KMutableList {
    @Override
    public abstract void add(int i, E e);

    public abstract int getSize();

    @IgnorableReturnValue
    public abstract E removeAt(int i);

    @IgnorableReturnValue
    public abstract E set(int i, E e);

    protected AbstractMutableList() {
    }

    @IgnorableReturnValue
    public final /* bridge */ E remove(int index) {
        return removeAt(index);
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }
}
