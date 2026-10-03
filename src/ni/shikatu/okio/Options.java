package ni.shikatu.okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0016B!\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lni/shikatu/okio/Options;", "Lni/shikatu/kotlin/collections/AbstractList;", "Lni/shikatu/okio/ByteString;", "Ljava/util/RandomAccess;", "Lni/shikatu/kotlin/collections/RandomAccess;", "byteStrings", _UrlKt.FRAGMENT_ENCODE_SET, "trie", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lni/shikatu/okio/ByteString;", "getTrie$okio", "()[I", "size", _UrlKt.FRAGMENT_ENCODE_SET, "getSize", "()I", "get", "index", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public  Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    private Options(ByteString[] byteStrings, int[] trie) {
        this.byteStrings = byteStrings;
        this.trie = trie;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof ByteString) {
            return contains((ByteString) element);
        }
        return false;
    }

    @Override
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof ByteString) {
            return indexOf((ByteString) element);
        }
        return -1;
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof ByteString) {
            return lastIndexOf((ByteString) element);
        }
        return -1;
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\tJT\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012H\u0002R\u0018\u0010\u0016\u001a\u00020\r*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lni/shikatu/okio/Options$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "of", "Lni/shikatu/okio/Options;", "byteStrings", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/ByteString;", "([Lokio/ByteString;)Lokio/Options;", "buildTrieRecursive", _UrlKt.FRAGMENT_ENCODE_SET, "nodeOffset", _UrlKt.FRAGMENT_ENCODE_SET, "node", "Lni/shikatu/okio/Buffer;", "byteStringOffset", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "fromIndex", "toIndex", "indexes", "intCount", "getIntCount", "(Lokio/Buffer;)J", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Options of(ByteString... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List list = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.sort(list);
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(-1);
            }
            ArrayList indexes = arrayList;
            int index$iv = 0;
            int length = byteStrings.length;
            int i2 = 0;
            while (i2 < length) {
                int index$iv2 = index$iv + 1;
                int callerIndex = index$iv;
                List list2 = list;
                int sortedIndex = CollectionsKt.binarySearch$default(list2, byteStrings[i2], 0, 0, 6, (Object) null);
                list = list2;
                indexes.set(sortedIndex, Integer.valueOf(callerIndex));
                i2++;
                index$iv = index$iv2;
            }
            if (!(((ByteString) list.get(0)).size() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            for (int a = 0; a < list.size(); a++) {
                ByteString prefix = (ByteString) list.get(a);
                int b = a + 1;
                while (b < list.size()) {
                    ByteString byteString = (ByteString) list.get(b);
                    if (!byteString.startsWith(prefix)) {
                        break;
                    }
                    if (!(byteString.size() != prefix.size())) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString).toString());
                    }
                    if (((Number) indexes.get(b)).intValue() > ((Number) indexes.get(a)).intValue()) {
                        list.remove(b);
                        ((Number) indexes.remove(b)).intValue();
                    } else {
                        b++;
                    }
                }
            }
            Buffer trieBytes = new Buffer();
            buildTrieRecursive$default(this, 0L, trieBytes, 0, list, 0, 0, indexes, 53, null);
            int intCount = (int) getIntCount(trieBytes);
            int[] trie = new int[intCount];
            for (int i3 = 0; i3 < intCount; i3++) {
                trie[i3] = trieBytes.readInt();
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            return new Options((ByteString[]) objArrCopyOf, trie, defaultConstructorMarker);
        }

        static  void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0L : j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> list, int fromIndex, int toIndex, List<Integer> list2) {
            int fromIndex2;
            ByteString from;
            int fromIndex3;
            int prefixIndex;
            Buffer childNodes;
            long childNodesOffset;
            int prefixIndex2;
            Companion companion = this;
            int prefixIndex3 = byteStringOffset;
            if (!(fromIndex < toIndex)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i = fromIndex; i < toIndex; i++) {
                if (!(list.get(i).size() >= prefixIndex3)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString from2 = list.get(fromIndex);
            ByteString to = list.get(toIndex - 1);
            if (prefixIndex3 != from2.size()) {
                fromIndex2 = fromIndex;
                from = from2;
                fromIndex3 = -1;
            } else {
                int prefixIndex4 = list2.get(fromIndex).intValue();
                int fromIndex4 = fromIndex + 1;
                fromIndex2 = fromIndex4;
                from = list.get(fromIndex4);
                fromIndex3 = prefixIndex4;
            }
            if (from.getByte(prefixIndex3) != to.getByte(prefixIndex3)) {
                int selectChoiceCount = 1;
                for (int i2 = fromIndex2 + 1; i2 < toIndex; i2++) {
                    if (list.get(i2 - 1).getByte(prefixIndex3) != list.get(i2).getByte(prefixIndex3)) {
                        selectChoiceCount++;
                    }
                }
                long childNodesOffset2 = nodeOffset + companion.getIntCount(node) + ((long) 2) + ((long) (selectChoiceCount * 2));
                node.writeInt(selectChoiceCount);
                node.writeInt(fromIndex3);
                for (int i3 = fromIndex2; i3 < toIndex; i3++) {
                    byte rangeByte = list.get(i3).getByte(prefixIndex3);
                    if (i3 == fromIndex2 || rangeByte != list.get(i3 - 1).getByte(prefixIndex3)) {
                        int other$iv = 255 & rangeByte;
                        node.writeInt(other$iv);
                    }
                }
                Buffer childNodes2 = new Buffer();
                int rangeStart = fromIndex2;
                while (rangeStart < toIndex) {
                    byte rangeByte2 = list.get(rangeStart).getByte(prefixIndex3);
                    int rangeEnd = toIndex;
                    int selectChoiceCount2 = selectChoiceCount;
                    int selectChoiceCount3 = rangeStart + 1;
                    while (selectChoiceCount3 < toIndex) {
                        int i4 = selectChoiceCount3;
                        if (rangeByte2 == list.get(selectChoiceCount3).getByte(prefixIndex3)) {
                            selectChoiceCount3 = i4 + 1;
                        } else {
                            rangeEnd = i4;
                            break;
                        }
                    }
                    int i5 = rangeStart + 1;
                    if (i5 != rangeEnd) {
                        prefixIndex = fromIndex3;
                    } else {
                        prefixIndex = fromIndex3;
                        if (prefixIndex3 + 1 == list.get(rangeStart).size()) {
                            node.writeInt(list2.get(rangeStart).intValue());
                            childNodes = childNodes2;
                            childNodesOffset = childNodesOffset2;
                            prefixIndex2 = prefixIndex;
                        }
                        rangeStart = rangeEnd;
                        childNodesOffset2 = childNodesOffset;
                        childNodes2 = childNodes;
                        fromIndex3 = prefixIndex2;
                        selectChoiceCount = selectChoiceCount2;
                        prefixIndex3 = byteStringOffset;
                    }
                    node.writeInt(((int) (childNodesOffset2 + companion.getIntCount(childNodes2))) * (-1));
                    int i6 = prefixIndex3 + 1;
                    childNodes = childNodes2;
                    childNodesOffset = childNodesOffset2;
                    prefixIndex2 = prefixIndex;
                    companion = this;
                    companion.buildTrieRecursive(childNodesOffset, childNodes, i6, list, rangeStart, rangeEnd, list2);
                    rangeStart = rangeEnd;
                    childNodesOffset2 = childNodesOffset;
                    childNodes2 = childNodes;
                    fromIndex3 = prefixIndex2;
                    selectChoiceCount = selectChoiceCount2;
                    prefixIndex3 = byteStringOffset;
                }
                Long.valueOf(node.writeAll(childNodes2));
                return;
            }
            int prefixIndex5 = fromIndex3;
            int scanByteCount = 0;
            int iMin = Math.min(from.size(), to.size());
            for (int i7 = byteStringOffset; i7 < iMin && from.getByte(i7) == to.getByte(i7); i7++) {
                scanByteCount++;
            }
            long childNodesOffset3 = nodeOffset + companion.getIntCount(node) + ((long) 2) + ((long) scanByteCount) + 1;
            node.writeInt(-scanByteCount);
            node.writeInt(prefixIndex5);
            int i8 = byteStringOffset + scanByteCount;
            for (int i9 = byteStringOffset; i9 < i8; i9++) {
                byte $this$and$iv = from.getByte(i9);
                node.writeInt($this$and$iv & UByte.MAX_VALUE);
            }
            int i10 = fromIndex2 + 1;
            if (i10 == toIndex) {
                if (!(byteStringOffset + scanByteCount == list.get(fromIndex2).size())) {
                    throw new IllegalStateException("Check failed.");
                }
                node.writeInt(list2.get(fromIndex2).intValue());
            } else {
                Buffer childNodes3 = new Buffer();
                node.writeInt(((int) (companion.getIntCount(childNodes3) + childNodesOffset3)) * (-1));
                int scanByteCount2 = fromIndex2;
                companion.buildTrieRecursive(childNodesOffset3, childNodes3, byteStringOffset + scanByteCount, list, scanByteCount2, toIndex, list2);
                Long.valueOf(node.writeAll(childNodes3));
            }
        }

        private final long getIntCount(Buffer $this$intCount) {
            return $this$intCount.size() / ((long) 4);
        }
    }

    @JvmStatic
    public static final Options of(ByteString... byteStrings) {
        return Companion.of(byteStrings);
    }
}
