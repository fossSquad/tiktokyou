package ni.shikatu.kotlin.uuid;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.ByteCompanionObject;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlin.time.Clock;
import ni.shikatu.kotlin.time.Instant;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Utf8;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u00013B\u0019\bB\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJa\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u001126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00110\u0013H\u0087\u0088\u0004b\u0002\b\u0017ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0016Ja\u0010\u0018\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u001126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00110\u0013H\u0087\u0088\u0004b\u0002\b\u0017ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0016J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004J\n\u0010\u001c\u001a\u00020\u001bH\u0086\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001bH\u0086\u0080\u0004J\n\u0010\u001e\u001a\u00020\u001fH\u0086\u0080\u0004J\u0015\u0010 \u001a\u00020!H\u0087\u0080\u0004b\u0002\b$¢\u0006\u0004\b\"\u0010#J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0082\u0004J\u0012\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020\u0000H\u0096\u0082\u0004J\n\u0010+\u001a\u00020*H\u0096\u0080\u0004J\n\u0010,\u001a\u00020(H\u0082\u0080\u0004J\u001b\u0010-\u001a\u00020.2\n\u0010/\u001a\u000600j\u0002`1H\u0082\u0080\u0004¢\u0006\u0002\u00102R!\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0084\br\u0002\b\r¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR!\u0010\u0006\u001a\u00020\u00058\u0000X\u0081\u0084\br\u0002\b\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fÊ\u0001\f\b5\u0012\b\b6\u0012\u0004\b\b(7Ê\u0001\u0010\b8\u0012\f\b9\u0012\b\b\fJ\u0004\b\t0:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Lni/shikatu/kotlin/uuid/Uuid;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "mostSignificantBits", _UrlKt.FRAGMENT_ENCODE_SET, "leastSignificantBits", "<init>", "(JJ)V", "getMostSignificantBits$annotations", "()V", "getMostSignificantBits", "()J", "Lni/shikatu/kotlin/PublishedApi;", "getLeastSignificantBits$annotations", "getLeastSignificantBits", "toLongs", "T", "action", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lni/shikatu/kotlin/internal/InlineOnly;", "toULongs", "Lni/shikatu/kotlin/ULong;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "toHexDashString", "toHexString", "toByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "toUByteArray", "Lni/shikatu/kotlin/UByteArray;", "toUByteArray-TcUX1vc", "()[B", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "compareTo", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "writeReplace", "readObject", _UrlKt.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInputStream;", "Lni/shikatu/kotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.4", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/uuid/ExperimentalUuidApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Uuid implements Comparable<Uuid>, Serializable {
    public static final Companion Companion = new Companion(null);
    private static final Uuid NIL = new Uuid(0, 0);
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    public  Uuid(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public static  void getLeastSignificantBits$annotations() {
    }

    public static  void getMostSignificantBits$annotations() {
    }

    private Uuid(long mostSignificantBits, long leastSignificantBits) {
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
        return function2.invoke(ULong.m174boximpl(ULong.m180constructorimpl(getMostSignificantBits())), ULong.m174boximpl(ULong.m180constructorimpl(getLeastSignificantBits())));
    }

    public String toString() {
        return toHexDashString();
    }

    public final String toHexDashString() {
        byte[] bytes = new byte[36];
        UuidKt.formatBytesInto(this.mostSignificantBits, bytes, 0, 0, 4);
        bytes[8] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bytes, 9, 4, 6);
        bytes[13] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bytes, 14, 6, 8);
        bytes[18] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bytes, 19, 0, 2);
        bytes[23] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bytes, 24, 2, 8);
        return StringsKt.decodeToString(bytes);
    }

    public final String toHexString() {
        byte[] bytes = new byte[32];
        UuidKt.formatBytesInto(this.mostSignificantBits, bytes, 0, 0, 8);
        UuidKt.formatBytesInto(this.leastSignificantBits, bytes, 16, 0, 8);
        return StringsKt.decodeToString(bytes);
    }

    public final byte[] toByteArray() {
        byte[] bytes = new byte[16];
        UuidKt.setLongAt(bytes, 0, this.mostSignificantBits);
        UuidKt.setLongAt(bytes, 8, this.leastSignificantBits);
        return bytes;
    }

    public final byte[] m1528toUByteArrayTcUX1vc() {
        return UByteArray.m77constructorimpl(toByteArray());
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

    @Override
    public int compareTo(Uuid other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.mostSignificantBits != other.mostSignificantBits) {
            return Long.compareUnsigned(ULong.m180constructorimpl(this.mostSignificantBits), ULong.m180constructorimpl(other.mostSignificantBits));
        }
        return Long.compareUnsigned(ULong.m180constructorimpl(this.leastSignificantBits), ULong.m180constructorimpl(other.leastSignificantBits));
    }

    public int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    private final Object writeReplace() {
        return UuidKt.serializedUuid(this);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0080\u0004J!\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0080\u0004J\u001d\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0087\u0080\u0004b\u0002\b\u001b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0012\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u001eH\u0086\u0080\u0004J\u0012\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u001eH\u0086\u0080\u0004J\n\u0010&\u001a\u00020\u0005H\u0086\u0080\u0004J\u001c\u0010'\u001a\u00020\u0005H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J\u001c\u0010,\u001a\u00020\u0005H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J$\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J\u0017\u0010,\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0080\u0080\u0004¢\u0006\u0002\b2R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000Ry\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000504j\b\u0012\u0004\u0012\u00020\u0005`58FX\u0087\u0084\br\u0002\b+r0\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\"\b<\u0012\u001e\b\u000bB\u001a\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\f\b@\u0012\b\b\fJ\u0004\b\b(Ar\u0016\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\b\bE\u0012\u0004\b\b(F¢\u0006\f\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u00108¨\u0006G"}, d2 = {"Lni/shikatu/kotlin/uuid/Uuid$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "NIL", "Lni/shikatu/kotlin/uuid/Uuid;", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BYTES", _UrlKt.FRAGMENT_ENCODE_SET, "SIZE_BITS", "fromLongs", "mostSignificantBits", _UrlKt.FRAGMENT_ENCODE_SET, "leastSignificantBits", "fromULongs", "Lni/shikatu/kotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "fromByteArray", "byteArray", _UrlKt.FRAGMENT_ENCODE_SET, "fromUByteArray", "ubyteArray", "Lni/shikatu/kotlin/UByteArray;", "fromUByteArray-GBYM_sE", "([B)Lkotlin/uuid/Uuid;", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "parse", "uuidString", _UrlKt.FRAGMENT_ENCODE_SET, "parseOrNull", "parseHexDash", "hexDashString", "parseHexDashOrNull", "parseHex", "hexString", "parseHexOrNull", "random", "generateV4", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.3", "Lni/shikatu/kotlin/uuid/ExperimentalUuidApi;", "generateV7", "generateV7NonMonotonicAt", "timestamp", "Lni/shikatu/kotlin/time/Instant;", "clock", "Lni/shikatu/kotlin/time/Clock;", "generateV7$kotlin_stdlib", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "getLEXICAL_ORDER$annotations", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use naturalOrder<Uuid>() instead", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "naturalOrder<Uuid>()", "imports", "ni.shikatu.kotlin.comparisons.naturalOrder", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "2.1", "errorSince", "2.4", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use naturalOrder<Uuid>() instead", replaceWith = @ReplaceWith(expression = "naturalOrder<Uuid>()", imports = {"ni.shikatu.kotlin.comparisons.naturalOrder"}))
        @DeprecatedSinceKotlin(errorSince = "2.4", warningSince = "2.1")
        public static  void getLEXICAL_ORDER$annotations() {
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
            return new Uuid(mostSignificantBits, leastSignificantBits, null);
        }

        public final Uuid m1530fromULongseb3DHEI(long mostSignificantBits, long leastSignificantBits) {
            return fromLongs(mostSignificantBits, leastSignificantBits);
        }

        public final Uuid fromByteArray(byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            if (!(byteArray.length == 16)) {
                throw new IllegalArgumentException(("Expected exactly 16 bytes, but was " + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(byteArray, 32) + " of size " + byteArray.length).toString());
            }
            return fromLongs(UuidKt.getLongAt(byteArray, 0), UuidKt.getLongAt(byteArray, 8));
        }

        public final Uuid m1529fromUByteArrayGBYM_sE(byte[] ubyteArray) {
            Intrinsics.checkNotNullParameter(ubyteArray, "ubyteArray");
            return fromByteArray(ubyteArray);
        }

        public final Uuid parse(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            switch (uuidString.length()) {
                case 32:
                    return UuidKt.uuidParseHex(uuidString);
                case 36:
                    return UuidKt.uuidParseHexDash(uuidString);
                default:
                    throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(uuidString, 64) + "\" of length " + uuidString.length());
            }
        }

        public final Uuid parseOrNull(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            switch (uuidString.length()) {
                case 32:
                    return parseHexOrNull(uuidString);
                case 36:
                    return parseHexDashOrNull(uuidString);
                default:
                    return null;
            }
        }

        public final Uuid parseHexDash(String hexDashString) {
            Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
            if (hexDashString.length() == 36) {
                return UuidKt.uuidParseHexDash(hexDashString);
            }
            throw new IllegalArgumentException(("Expected a 36-char string in the standard hex-and-dash UUID format, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexDashString, 64) + "\" of length " + hexDashString.length()).toString());
        }

        public final Uuid parseHexDashOrNull(String hexDashString) {
            Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
            if (hexDashString.length() != 36) {
                return null;
            }
            return UuidKt.uuidParseHexDashOrNull(hexDashString);
        }

        public final Uuid parseHex(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (hexString.length() == 32) {
                return UuidKt.uuidParseHex(hexString);
            }
            throw new IllegalArgumentException(("Expected a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexString, 64) + "\" of length " + hexString.length()).toString());
        }

        public final Uuid parseHexOrNull(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (hexString.length() != 32) {
                return null;
            }
            return UuidKt.uuidParseHexOrNull(hexString);
        }

        public final Uuid random() {
            return generateV4();
        }

        public final Uuid generateV4() {
            return UuidKt.secureRandomUuid();
        }

        public final Uuid generateV7() {
            return generateV7$kotlin_stdlib(Clock.System.INSTANCE);
        }

        public final Uuid generateV7NonMonotonicAt(Instant timestamp) {
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            byte[] randomBytes = new byte[10];
            UuidKt.secureRandomBytes(randomBytes);
            int verAndRandA = (((randomBytes[8] & 15) | 112) << 8) | (randomBytes[9] & UByte.MAX_VALUE);
            long tsVerAndRandA = (timestamp.toEpochMilliseconds() << 16) | ((long) verAndRandA);
            randomBytes[0] = (byte) (((byte) (randomBytes[0] & Utf8.REPLACEMENT_BYTE)) | ByteCompanionObject.MIN_VALUE);
            long varAndRandB = UuidKt.getLongAt(randomBytes, 0);
            return fromLongs(tsVerAndRandA, varAndRandB);
        }

        public final Uuid generateV7$kotlin_stdlib(Clock clock) {
            Intrinsics.checkNotNullParameter(clock, "clock");
            return UuidV7Generator.INSTANCE.generate(clock);
        }

        public final Comparator<Uuid> getLEXICAL_ORDER() {
            return ComparisonsKt.naturalOrder();
        }
    }
}
