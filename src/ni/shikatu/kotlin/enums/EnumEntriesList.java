package ni.shikatu.kotlin.enums;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u00062\u00060\u0007j\u0002`\bB\u0017\bF\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0096\u0082\u0004¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001aJ\n\u0010\u001c\u001a\u00020\u001dH\u0082\u0080\u0004J\u001b\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060!j\u0002`\"H\u0082\u0080\u0004¢\u0006\u0002\u0010#R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\rR\u0015\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\b('¨\u0006$"}, d2 = {"Lni/shikatu/kotlin/enums/EnumEntriesList;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/enums/EnumEntries;", "Lni/shikatu/kotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "entries", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([Ljava/lang/Enum;)V", "[Ljava/lang/Enum;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "getSize", "()I", "get", "index", "(I)Ljava/lang/Enum;", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Enum;)Z", "indexOf", "(Ljava/lang/Enum;)I", "lastIndexOf", "writeReplace", _UrlKt.FRAGMENT_ENCODE_SET, "readObject", _UrlKt.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInputStream;", "Lni/shikatu/kotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.8"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, RandomAccess, Serializable {
    private final T[] entries;

    public EnumEntriesList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entries");
        this.entries = tArr;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof Enum) {
            return contains((Enum) element);
        }
        return false;
    }

    @Override
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof Enum) {
            return indexOf((Enum) element);
        }
        return -1;
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof Enum) {
            return lastIndexOf((Enum) element);
        }
        return -1;
    }

    @Override
    public int getSize() {
        return this.entries.length;
    }

    @Override
    public T get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.entries.length);
        return this.entries[index];
    }

    public boolean contains(T t) {
        Intrinsics.checkNotNullParameter(t, "element");
        Enum target = (Enum) ArraysKt.getOrNull(this.entries, t.ordinal());
        return target == t;
    }

    public int indexOf(T t) {
        Intrinsics.checkNotNullParameter(t, "element");
        int ordinal = t.ordinal();
        Enum target = (Enum) ArraysKt.getOrNull(this.entries, ordinal);
        if (target == t) {
            return ordinal;
        }
        return -1;
    }

    public int lastIndexOf(T t) {
        Intrinsics.checkNotNullParameter(t, "element");
        return indexOf((Enum) t);
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }
}
