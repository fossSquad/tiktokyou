package ni.shikatu.kotlin.uuid;

import java.io.Serializable;
import java.util.Comparator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.HexExtensionsKt;
import ni.shikatu.kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0001#B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\\\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0014J\\\u0010\u0015\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"Lni/shikatu/kotlin/uuid/Uuid;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "mostSignificantBits", "", "leastSignificantBits", "<init>", "(JJ)V", "getMostSignificantBits$annotations", "()V", "getMostSignificantBits", "()J", "getLeastSignificantBits$annotations", "getLeastSignificantBits", "toLongs", "T", "action", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toULongs", "Lni/shikatu/kotlin/ULong;", "toString", "", "toHexString", "toByteArray", "", "equals", "", "other", "", "hashCode", "", "writeReplace", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Uuid implements Serializable {
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;
    public static final Companion Companion = new Companion(null);
    private static final Uuid NIL = new Uuid(0, 0);
    private static final Comparator<Uuid> LEXICAL_ORDER = new Comparator() {
        @Override
        public final int compare(Object obj, Object obj2) {
            return Uuid.LEXICAL_ORDER$lambda$0((Uuid) obj, (Uuid) obj2);
        }
    };

    public static  void getLeastSignificantBits$annotations() {
    }

    public static  void getMostSignificantBits$annotations() {
    }

    public Uuid(long mostSignificantBits, long leastSignificantBits) {
        this.mostSignificantBits = mostSignificantBits;
        this.leastSignificantBits = leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return function2.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    private final <T> T toULongs(Function2<? super ULong, ? super ULong, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return function2.invoke(ULong.m172boximpl(ULong.m178constructorimpl(getMostSignificantBits())), ULong.m172boximpl(ULong.m178constructorimpl(getLeastSignificantBits())));
    }

    public String toString() {
        byte[] bytes = new byte[36];
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.leastSignificantBits, bytes, 24, 6);
        bytes[23] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.leastSignificantBits >>> 48, bytes, 19, 2);
        bytes[18] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits, bytes, 14, 2);
        bytes[13] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits >>> 16, bytes, 9, 2);
        bytes[8] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits >>> 32, bytes, 0, 4);
        return StringsKt.decodeToString(bytes);
    }

    public final String toHexString() {
        byte[] bytes = new byte[32];
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.leastSignificantBits, bytes, 16, 8);
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits, bytes, 0, 8);
        return StringsKt.decodeToString(bytes);
    }

    public final byte[] toByteArray() {
        byte[] bytes = new byte[16];
        UuidKt__UuidKt.toByteArray$UuidKt__UuidKt(this.mostSignificantBits, bytes, 0);
        UuidKt__UuidKt.toByteArray$UuidKt__UuidKt(this.leastSignificantBits, bytes, 8);
        return bytes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Uuid) {
            return this.mostSignificantBits == ((Uuid) other).mostSignificantBits && this.leastSignificantBits == ((Uuid) other).leastSignificantBits;
        }
        return false;
    }

    public int hashCode() {
        long x = this.mostSignificantBits ^ this.leastSignificantBits;
        return ((int) (x >> 32)) ^ ((int) x);
    }

    private final Object writeReplace() {
        return UuidKt.serializedUuid(this);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R#\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001dj\b\u0012\u0004\u0012\u00020\u0005`\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lni/shikatu/kotlin/uuid/Uuid$Companion;", "", "<init>", "()V", "NIL", "Lni/shikatu/kotlin/uuid/Uuid;", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BYTES", "", "SIZE_BITS", "fromLongs", "mostSignificantBits", "", "leastSignificantBits", "fromULongs", "Lni/shikatu/kotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "fromByteArray", "byteArray", "", "parse", "uuidString", "", "parseHex", "hexString", "random", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "Ljava/util/Comparator;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uuid getNIL() {
            return Uuid.NIL;
        }

        public final Uuid fromLongs(long mostSignificantBits, long leastSignificantBits) {
            if (mostSignificantBits == 0 && leastSignificantBits == 0) {
                return getNIL();
            }
            return new Uuid(mostSignificantBits, leastSignificantBits);
        }

        public final Uuid m1495fromULongseb3DHEI(long mostSignificantBits, long leastSignificantBits) {
            return fromLongs(mostSignificantBits, leastSignificantBits);
        }

        public final Uuid fromByteArray(byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            if (byteArray.length == 16) {
                return fromLongs(UuidKt__UuidKt.toLong$UuidKt__UuidKt(byteArray, 0), UuidKt__UuidKt.toLong$UuidKt__UuidKt(byteArray, 8));
            }
            throw new IllegalArgumentException("Expected exactly 16 bytes".toString());
        }

        public final Uuid parse(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            if (!(uuidString.length() == 36)) {
                throw new IllegalArgumentException("Expected a 36-char string in the standard uuid format.".toString());
            }
            long part1 = HexExtensionsKt.hexToLong$default(uuidString, 0, 8, null, 4, null);
            UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(uuidString, 8);
            long part2 = HexExtensionsKt.hexToLong$default(uuidString, 9, 13, null, 4, null);
            UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(uuidString, 13);
            long part3 = HexExtensionsKt.hexToLong$default(uuidString, 14, 18, null, 4, null);
            UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(uuidString, 18);
            long part4 = HexExtensionsKt.hexToLong$default(uuidString, 19, 23, null, 4, null);
            UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(uuidString, 23);
            long part5 = HexExtensionsKt.hexToLong$default(uuidString, 24, 36, null, 4, null);
            long msb = (part1 << 32) | (part2 << 16) | part3;
            long lsb = (part4 << 48) | part5;
            return fromLongs(msb, lsb);
        }

        public final Uuid parseHex(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (!(hexString.length() == 32)) {
                throw new IllegalArgumentException("Expected a 32-char hexadecimal string.".toString());
            }
            long msb = HexExtensionsKt.hexToLong$default(hexString, 0, 16, null, 4, null);
            long lsb = HexExtensionsKt.hexToLong$default(hexString, 16, 32, null, 4, null);
            return fromLongs(msb, lsb);
        }

        public final Uuid random() {
            return UuidKt.secureRandomUuid();
        }

        public final Comparator<Uuid> getLEXICAL_ORDER() {
            return Uuid.LEXICAL_ORDER;
        }
    }

    public static final int LEXICAL_ORDER$lambda$0(Uuid a, Uuid b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a.mostSignificantBits != b.mostSignificantBits) {
            return Long.compareUnsigned(ULong.m178constructorimpl(a.mostSignificantBits), ULong.m178constructorimpl(b.mostSignificantBits));
        }
        return Long.compareUnsigned(ULong.m178constructorimpl(a.leastSignificantBits), ULong.m178constructorimpl(b.leastSignificantBits));
    }
}
