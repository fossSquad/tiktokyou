package ni.shikatu.kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lni/shikatu/kotlin/enums/EnumEntriesList;", "T", "", "Lni/shikatu/kotlin/enums/EnumEntries;", "Lni/shikatu/kotlin/collections/AbstractList;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "entries", "", "<init>", "([Ljava/lang/Enum;)V", "[Ljava/lang/Enum;", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Enum;", "contains", "", "element", "(Ljava/lang/Enum;)Z", "indexOf", "(Ljava/lang/Enum;)I", "lastIndexOf", "writeReplace", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, Serializable {
    private final T[] entries;

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

    public EnumEntriesList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entries");
        this.entries = tArr;
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
        return indexOf((Object) t);
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }
}
