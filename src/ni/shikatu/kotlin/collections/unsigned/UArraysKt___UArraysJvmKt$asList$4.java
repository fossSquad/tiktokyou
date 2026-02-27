package ni.shikatu.kotlin.collections.unsigned;

import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"ni/shikatu/kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$4", "Lni/shikatu/kotlin/collections/AbstractList;", "Lni/shikatu/kotlin/UShort;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "isEmpty", "", "contains", "element", "contains-xj2QHRw", "(S)Z", "get", "index", "get-Mh2AYeg", "(I)S", "indexOf", "indexOf-xj2QHRw", "(S)I", "lastIndexOf", "lastIndexOf-xj2QHRw", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UArraysKt___UArraysJvmKt$asList$4 extends AbstractList<UShort> implements RandomAccess {
    final  short[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$4(short[] $receiver) {
        this.$this_asList = $receiver;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof UShort) {
            return m528containsxj2QHRw(((UShort) element).m335unboximpl());
        }
        return false;
    }

    @Override
    public /* bridge */  Object get(int index) {
        return UShort.m279boximpl(m529getMh2AYeg(index));
    }

    @Override
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof UShort) {
            return m530indexOfxj2QHRw(((UShort) element).m335unboximpl());
        }
        return -1;
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof UShort) {
            return m531lastIndexOfxj2QHRw(((UShort) element).m335unboximpl());
        }
        return -1;
    }

    @Override
    public int getSize() {
        return UShortArray.m344getSizeimpl(this.$this_asList);
    }

    @Override
    public boolean isEmpty() {
        return UShortArray.m346isEmptyimpl(this.$this_asList);
    }

    public boolean m528containsxj2QHRw(short element) {
        return UShortArray.m339containsxj2QHRw(this.$this_asList, element);
    }

    public short m529getMh2AYeg(int index) {
        return UShortArray.m343getMh2AYeg(this.$this_asList, index);
    }

    public int m530indexOfxj2QHRw(short element) {
        return ArraysKt.indexOf(this.$this_asList, element);
    }

    public int m531lastIndexOfxj2QHRw(short element) {
        return ArraysKt.lastIndexOf(this.$this_asList, element);
    }
}
