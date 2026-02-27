package ni.shikatu.kotlin.collections.unsigned;

import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"ni/shikatu/kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Lni/shikatu/kotlin/collections/AbstractList;", "Lni/shikatu/kotlin/ULong;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "isEmpty", "", "contains", "element", "contains-VKZWuLQ", "(J)Z", "get", "index", "get-s-VKNKU", "(I)J", "indexOf", "indexOf-VKZWuLQ", "(J)I", "lastIndexOf", "lastIndexOf-VKZWuLQ", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    final  long[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$2(long[] $receiver) {
        this.$this_asList = $receiver;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof ULong) {
            return m520containsVKZWuLQ(((ULong) element).m230unboximpl());
        }
        return false;
    }

    @Override
    public /* bridge */  Object get(int index) {
        return ULong.m172boximpl(m521getsVKNKU(index));
    }

    @Override
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof ULong) {
            return m522indexOfVKZWuLQ(((ULong) element).m230unboximpl());
        }
        return -1;
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof ULong) {
            return m523lastIndexOfVKZWuLQ(((ULong) element).m230unboximpl());
        }
        return -1;
    }

    @Override
    public int getSize() {
        return ULongArray.m239getSizeimpl(this.$this_asList);
    }

    @Override
    public boolean isEmpty() {
        return ULongArray.m241isEmptyimpl(this.$this_asList);
    }

    public boolean m520containsVKZWuLQ(long element) {
        return ULongArray.m234containsVKZWuLQ(this.$this_asList, element);
    }

    public long m521getsVKNKU(int index) {
        return ULongArray.m238getsVKNKU(this.$this_asList, index);
    }

    public int m522indexOfVKZWuLQ(long element) {
        return ArraysKt.indexOf(this.$this_asList, element);
    }

    public int m523lastIndexOfVKZWuLQ(long element) {
        return ArraysKt.lastIndexOf(this.$this_asList, element);
    }
}
