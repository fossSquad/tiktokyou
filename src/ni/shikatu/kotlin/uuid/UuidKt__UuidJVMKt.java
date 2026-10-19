package ni.shikatu.kotlin.uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u0016\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0080\u0080\u0004\u001a.\u0010\f\u001a\u00020\u0001*\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\u0080\u0004\u001a\u001e\u0010\u0011\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0080\u0080\u0004\u001a\u0012\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0081\u0080\u0004b\u0002\b\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u0015H\u0081\u0080\u0004b\u0002\b\u0017\u001a.\u0010\u001b\u001a\u00020\u0007*\u00020\u001cH\u0087\u0088\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a.\u0010\"\u001a\u00020\u001c*\u00020\u0007H\u0087\u0088\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a.\u0010#\u001a\u00020\u0007*\u00020$H\u0087\u0080\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a6\u0010#\u001a\u00020\u0007*\u00020$2\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0080\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017\u001a:\u0010%\u001a\u00020$*\u00020$2\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0080\bb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017b\u0002\b&\u001aB\u0010%\u001a\u00020$*\u00020$2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0080\bb\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\t0\u0017b\u0002\b&\u001a\u000e\u0010'\u001a\u00020\t*\u00020\tH\u0080\u0088\u0004¨\u0006("}, d2 = {"secureRandomBytes", _UrlKt.FRAGMENT_ENCODE_SET, "destination", _UrlKt.FRAGMENT_ENCODE_SET, "serializedUuid", _UrlKt.FRAGMENT_ENCODE_SET, "uuid", "Lni/shikatu/kotlin/uuid/Uuid;", "getLongAt", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "formatBytesInto", "dst", "dstOffset", "startIndex", "endIndex", "setLongAt", "value", "uuidParseHexDash", "hexDashString", _UrlKt.FRAGMENT_ENCODE_SET, "uuidParseHexDashOrNull", "Lni/shikatu/kotlin/uuid/ExperimentalUuidApi;", "uuidParseHex", "hexString", "uuidParseHexOrNull", "toKotlinUuid", "Ljava/util/UUID;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.4", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "toJavaUuid", "getUuid", "Ljava/nio/ByteBuffer;", "putUuid", "Lni/shikatu/kotlin/IgnorableReturnValue;", "reverseBytes", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/uuid/UuidKt")
class UuidKt__UuidJVMKt {
    public static final void secureRandomBytes(byte[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        SecureRandomHolder.INSTANCE.getInstance().nextBytes(destination);
    }

    public static final Object serializedUuid(Uuid uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final long getLongAt(byte[] $this$getLongAt, int index) {
        Intrinsics.checkNotNullParameter($this$getLongAt, "<this>");
        return UuidKt.getLongAtCommonImpl($this$getLongAt, index);
    }

    public static final void formatBytesInto(long $this$formatBytesInto, byte[] dst, int dstOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UuidKt.formatBytesIntoCommonImpl($this$formatBytesInto, dst, dstOffset, startIndex, endIndex);
    }

    public static final void setLongAt(byte[] $this$setLongAt, int index, long value) {
        Intrinsics.checkNotNullParameter($this$setLongAt, "<this>");
        UuidKt.setLongAtCommonImpl($this$setLongAt, index, value);
    }

    public static final Uuid uuidParseHexDash(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        return UuidKt.uuidParseHexDashCommonImpl(hexDashString);
    }

    public static final Uuid uuidParseHexDashOrNull(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        return UuidKt.uuidParseHexDashOrNullCommonImpl(hexDashString);
    }

    public static final Uuid uuidParseHex(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        return UuidKt.uuidParseHexCommonImpl(hexString);
    }

    public static final Uuid uuidParseHexOrNull(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        return UuidKt.uuidParseHexOrNullCommonImpl(hexString);
    }

    public static final Uuid toKotlinUuid(UUID $this$toKotlinUuid) {
        Intrinsics.checkNotNullParameter($this$toKotlinUuid, "<this>");
        return Uuid.Companion.fromLongs($this$toKotlinUuid.getMostSignificantBits(), $this$toKotlinUuid.getLeastSignificantBits());
    }

    public static final UUID toJavaUuid(Uuid $this$toJavaUuid) {
        Intrinsics.checkNotNullParameter($this$toJavaUuid, "<this>");
        long mostSignificantBits = $this$toJavaUuid.getMostSignificantBits();
        long leastSignificantBits = $this$toJavaUuid.getLeastSignificantBits();
        return new UUID(mostSignificantBits, leastSignificantBits);
    }

    public static final Uuid getUuid(ByteBuffer $this$getUuid) {
        Intrinsics.checkNotNullParameter($this$getUuid, "<this>");
        if ($this$getUuid.position() + 15 >= $this$getUuid.limit()) {
            throw new BufferUnderflowException();
        }
        long msb = $this$getUuid.getLong();
        long lsb = $this$getUuid.getLong();
        if (Intrinsics.areEqual($this$getUuid.order(), ByteOrder.LITTLE_ENDIAN)) {
            long $this$reverseBytes$iv = Long.reverseBytes(msb);
            msb = $this$reverseBytes$iv;
            long $this$reverseBytes$iv2 = Long.reverseBytes(lsb);
            lsb = $this$reverseBytes$iv2;
        }
        return Uuid.Companion.fromLongs(msb, lsb);
    }

    public static final Uuid getUuid(ByteBuffer $this$getUuid, int index) {
        Intrinsics.checkNotNullParameter($this$getUuid, "<this>");
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index: " + index);
        }
        if (index + 15 >= $this$getUuid.limit()) {
            throw new IndexOutOfBoundsException("Not enough bytes to read a uuid at index: " + index + ", with limit: " + $this$getUuid.limit() + ' ');
        }
        long msb = $this$getUuid.getLong(index);
        long lsb = $this$getUuid.getLong(index + 8);
        if (Intrinsics.areEqual($this$getUuid.order(), ByteOrder.LITTLE_ENDIAN)) {
            long $this$reverseBytes$iv = Long.reverseBytes(msb);
            msb = $this$reverseBytes$iv;
            long $this$reverseBytes$iv2 = Long.reverseBytes(lsb);
            lsb = $this$reverseBytes$iv2;
        }
        return Uuid.Companion.fromLongs(msb, lsb);
    }

    @IgnorableReturnValue
    public static final ByteBuffer putUuid(ByteBuffer $this$putUuid, Uuid uuid) {
        ByteBuffer byteBufferPutLong;
        Intrinsics.checkNotNullParameter($this$putUuid, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        if ($this$putUuid.position() + 15 >= $this$putUuid.limit()) {
            throw new BufferOverflowException();
        }
        if (Intrinsics.areEqual($this$putUuid.order(), ByteOrder.BIG_ENDIAN)) {
            $this$putUuid.putLong(msb);
            byteBufferPutLong = $this$putUuid.putLong(lsb);
        } else {
            long $this$reverseBytes$iv = Long.reverseBytes(msb);
            $this$putUuid.putLong($this$reverseBytes$iv);
            long $this$reverseBytes$iv2 = Long.reverseBytes(lsb);
            byteBufferPutLong = $this$putUuid.putLong($this$reverseBytes$iv2);
        }
        Intrinsics.checkNotNullExpressionValue(byteBufferPutLong, "toLongs(...)");
        return byteBufferPutLong;
    }

    @IgnorableReturnValue
    public static final ByteBuffer putUuid(ByteBuffer $this$putUuid, int index, Uuid uuid) {
        ByteBuffer byteBufferPutLong;
        Intrinsics.checkNotNullParameter($this$putUuid, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index: " + index);
        }
        if (index + 15 >= $this$putUuid.limit()) {
            throw new IndexOutOfBoundsException("Not enough capacity to write a uuid at index: " + index + ", with limit: " + $this$putUuid.limit() + ' ');
        }
        if (Intrinsics.areEqual($this$putUuid.order(), ByteOrder.BIG_ENDIAN)) {
            $this$putUuid.putLong(index, msb);
            byteBufferPutLong = $this$putUuid.putLong(index + 8, lsb);
        } else {
            long $this$reverseBytes$iv = Long.reverseBytes(msb);
            $this$putUuid.putLong(index, $this$reverseBytes$iv);
            long $this$reverseBytes$iv2 = Long.reverseBytes(lsb);
            byteBufferPutLong = $this$putUuid.putLong(index + 8, $this$reverseBytes$iv2);
        }
        Intrinsics.checkNotNullExpressionValue(byteBufferPutLong, "toLongs(...)");
        return byteBufferPutLong;
    }

    public static final long reverseBytes(long $this$reverseBytes) {
        return Long.reverseBytes($this$reverseBytes);
    }
}
