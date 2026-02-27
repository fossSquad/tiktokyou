package ni.shikatu.kotlin.uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0001\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0006H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0001H\u0087\b\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\f\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u000eH\u0080\b¨\u0006\u000f"}, d2 = {"secureRandomUuid", "Lni/shikatu/kotlin/uuid/Uuid;", "serializedUuid", "", "uuid", "toKotlinUuid", "Ljava/util/UUID;", "toJavaUuid", "getUuid", "Ljava/nio/ByteBuffer;", "index", "", "putUuid", "reverseBytes", "", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/uuid/UuidKt")
class UuidKt__UuidJVMKt {
    public static final Uuid secureRandomUuid() {
        byte[] randomBytes = new byte[16];
        SecureRandomHolder.INSTANCE.getInstance().nextBytes(randomBytes);
        return UuidKt.uuidFromRandomBytes(randomBytes);
    }

    public static final Object serializedUuid(Uuid uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
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
