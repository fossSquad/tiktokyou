package ni.shikatu.kotlin.collections.unsigned;

import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"ni/shikatu/kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$1", "Lni/shikatu/kotlin/collections/AbstractList;", "Lni/shikatu/kotlin/UInt;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "isEmpty", "", "contains", "element", "contains-WZ4Q5Ns", "(I)Z", "get", "index", "get-pVg5ArA", "(I)I", "indexOf", "indexOf-WZ4Q5Ns", "lastIndexOf", "lastIndexOf-WZ4Q5Ns", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UArraysKt___UArraysJvmKt$asList$1 extends AbstractList<UInt> implements RandomAccess {
    final  int[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$1(int[] $receiver) {
        this.$this_asList = $receiver;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UInt) {
            return m516containsWZ4Q5Ns(((UInt) element).m151unboximpl());
        }
        return false;
    }

    @Override
    public /* bridge */  Object get(int index) {
        return UInt.m93boximpl(m517getpVg5ArA(index));
    }

    @Override
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof UInt) {
            return m518indexOfWZ4Q5Ns(((UInt) element).m151unboximpl());
        }
        return -1;
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof UInt) {
            return m519lastIndexOfWZ4Q5Ns(((UInt) element).m151unboximpl());
        }
        return -1;
    }

    @Override
    public int getSize() {
        return UIntArray.m160getSizeimpl(this.$this_asList);
    }

    @Override
    public boolean isEmpty() {
        return UIntArray.m162isEmptyimpl(this.$this_asList);
    }

    public boolean m516containsWZ4Q5Ns(int element) {
        return UIntArray.m155containsWZ4Q5Ns(this.$this_asList, element);
    }

    public int m517getpVg5ArA(int index) {
        return UIntArray.m159getpVg5ArA(this.$this_asList, index);
    }

    public int m518indexOfWZ4Q5Ns(int element) {
        return ArraysKt.indexOf(this.$this_asList, element);
    }

    public int m519lastIndexOfWZ4Q5Ns(int element) {
        return ArraysKt.lastIndexOf(this.$this_asList, element);
    }
}
