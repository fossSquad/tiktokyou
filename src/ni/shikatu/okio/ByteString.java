package ni.shikatu.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.internal.ByteStringNonJs;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0005\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ^2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001^B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0000J\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016J\u001d\u0010$\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0000H\u0010¢\u0006\u0002\b%J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0000H\u0016J\b\u0010)\u001a\u00020\u0000H\u0016J\u001c\u0010*\u001a\u00020\u00002\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\nH\u0017J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\nH\u0010¢\u0006\u0002\b0J\u0016\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b3J\r\u00105\u001a\u00020\nH\u0010¢\u0006\u0002\b6J\b\u00107\u001a\u00020\u0004H\u0016J\r\u00108\u001a\u00020\u0004H\u0010¢\u0006\u0002\b9J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J%\u0010<\u001a\u00020=2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0010¢\u0006\u0002\bDJ(\u0010E\u001a\u00020F2\u0006\u0010B\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J(\u0010E\u001a\u00020F2\u0006\u0010B\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J,\u0010I\u001a\u00020=2\b\b\u0002\u0010B\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00042\b\b\u0002\u0010K\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J\u000e\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u0000J\u000e\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u0004J\u000e\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020\u0000J\u000e\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020\u0004J\u001a\u0010P\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\nH\u0007J\u001a\u0010P\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00042\b\b\u0002\u0010Q\u001a\u00020\nH\u0017J\u001a\u0010R\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\nH\u0007J\u001a\u0010R\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00042\b\b\u0002\u0010Q\u001a\u00020\nH\u0017J\u0013\u0010S\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010TH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010U\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u0000H\u0096\u0002J\b\u0010V\u001a\u00020\u0010H\u0016J\u0010\u0010W\u001a\u00020=2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020=2\u0006\u0010>\u001a\u00020[H\u0002J\u0015\u00103\u001a\u00020.2\u0006\u00102\u001a\u00020\nH\u0007¢\u0006\u0002\b\\J\r\u00104\u001a\u00020\nH\u0007¢\u0006\u0002\b]R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u00104\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b4\u0010\f¨\u0006_"}, d2 = {"Lni/shikatu/okio/ByteString;", "Ljava/io/Serializable;", _UrlKt.FRAGMENT_ENCODE_SET, "data", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([B)V", "getData$okio", "()[B", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "utf8", _UrlKt.FRAGMENT_ENCODE_SET, "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "string", "charset", "Ljava/nio/charset/Charset;", "base64", "md5", "sha1", "sha256", "sha512", "digest", "algorithm", "digest$okio", "hmacSha1", "key", "hmacSha256", "hmacSha512", "hmac", "hmac$okio", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "substring", "beginIndex", "endIndex", "internalGet", _UrlKt.FRAGMENT_ENCODE_SET, "pos", "internalGet$okio", "get", "index", "getByte", "size", "getSize", "getSize$okio", "toByteArray", "internalArray", "internalArray$okio", "asByteBuffer", "Ljava/nio/ByteBuffer;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "out", "Ljava/io/OutputStream;", "buffer", "Lni/shikatu/okio/Buffer;", "offset", "byteCount", "write$okio", "rangeEquals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "otherOffset", "copyInto", "target", "targetOffset", "startsWith", "prefix", "endsWith", "suffix", "indexOf", "fromIndex", "lastIndexOf", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "compareTo", "toString", "readObject", "in", "Ljava/io/ObjectInputStream;", "writeObject", "Ljava/io/ObjectOutputStream;", "-deprecated_getByte", "-deprecated_size", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public final int indexOf(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int indexOf(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    public ByteString(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public final void setHashCode$okio(int i) {
        this.hashCode = i;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public String utf8() {
        String result$iv = getUtf8$okio();
        if (result$iv != null) {
            return result$iv;
        }
        String result$iv2 = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(result$iv2);
        return result$iv2;
    }

    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.data, charset);
    }

    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest $this$digest_u24lambda_u240 = MessageDigest.getInstance(algorithm);
        $this$digest_u24lambda_u240.update(this.data, 0, size());
        byte[] digestBytes = $this$digest_u24lambda_u240.digest();
        Intrinsics.checkNotNull(digestBytes);
        return new ByteString(digestBytes);
    }

    public ByteString hmacSha1(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public String hex() {
        char[] result$iv = new char[getData$okio().length * 2];
        int c$iv = 0;
        for (int b$iv : getData$okio()) {
            int c$iv2 = c$iv + 1;
            int other$iv$iv = b$iv >> 4;
            result$iv[c$iv] = ni.shikatu.okio.internal.ByteString.getHEX_DIGIT_CHARS()[other$iv$iv & 15];
            c$iv = c$iv2 + 1;
            int other$iv$iv2 = 15 & b$iv;
            result$iv[c$iv2] = ni.shikatu.okio.internal.ByteString.getHEX_DIGIT_CHARS()[other$iv$iv2];
        }
        return StringsKt.concatToString(result$iv);
    }

    public ByteString toAsciiLowercase() {
        for (int i$iv = 0; i$iv < getData$okio().length; i$iv++) {
            byte c$iv = getData$okio()[i$iv];
            if (c$iv >= 65 && c$iv <= 90) {
                byte[] data$okio = getData$okio();
                byte[] lowercase$iv = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(lowercase$iv, "copyOf(...)");
                int i$iv2 = i$iv + 1;
                lowercase$iv[i$iv] = (byte) (c$iv + 32);
                while (i$iv2 < lowercase$iv.length) {
                    byte c$iv2 = lowercase$iv[i$iv2];
                    if (c$iv2 < 65 || c$iv2 > 90) {
                        i$iv2++;
                    } else {
                        lowercase$iv[i$iv2] = (byte) (c$iv2 + 32);
                        i$iv2++;
                    }
                }
                return new ByteString(lowercase$iv);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        for (int i$iv = 0; i$iv < getData$okio().length; i$iv++) {
            byte c$iv = getData$okio()[i$iv];
            if (c$iv >= 97 && c$iv <= 122) {
                byte[] data$okio = getData$okio();
                byte[] lowercase$iv = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(lowercase$iv, "copyOf(...)");
                int i$iv2 = i$iv + 1;
                lowercase$iv[i$iv] = (byte) (c$iv - 32);
                while (i$iv2 < lowercase$iv.length) {
                    byte c$iv2 = lowercase$iv[i$iv2];
                    if (c$iv2 < 97 || c$iv2 > 122) {
                        i$iv2++;
                    } else {
                        lowercase$iv[i$iv2] = (byte) (c$iv2 - 32);
                        i$iv2++;
                    }
                }
                return new ByteString(lowercase$iv);
            }
        }
        return this;
    }

    public static  ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.substring(i, i2);
    }

    public ByteString substring(int beginIndex, int endIndex) {
        int endIndex$iv = SegmentedByteString.resolveDefaultParameter(this, endIndex);
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (!(endIndex$iv <= getData$okio().length)) {
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        int subLen$iv = endIndex$iv - beginIndex;
        if (subLen$iv >= 0) {
            return (beginIndex == 0 && endIndex$iv == getData$okio().length) ? this : new ByteString(ArraysKt.copyOfRange(getData$okio(), beginIndex, endIndex$iv));
        }
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    }

    public byte internalGet$okio(int pos) {
        return getData$okio()[pos];
    }

    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    public final int size() {
        return getSize$okio();
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    public void write(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        out.write(this.data);
    }

    public void write$okio(Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ni.shikatu.okio.internal.ByteString.commonWrite(this, buffer, offset, byteCount);
    }

    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(otherOffset, getData$okio(), offset, byteCount);
    }

    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= getData$okio().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && SegmentedByteString.arrayRangeEquals(getData$okio(), offset, other, otherOffset, byteCount);
    }

    public static  void copyInto$default(ByteString byteString, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        byteString.copyInto(i, bArr, i2, i3);
    }

    public void copyInto(int offset, byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt.copyInto(getData$okio(), target, targetOffset, offset, offset + byteCount);
    }

    public final boolean startsWith(ByteString prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public final boolean startsWith(byte[] prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public final boolean endsWith(ByteString suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public final boolean endsWith(byte[] suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public static  int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(byteString2, i);
    }

    public final int indexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf(other.internalArray$okio(), fromIndex);
    }

    public static  int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(bArr, i);
    }

    public int indexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int limit$iv = getData$okio().length - other.length;
        int i$iv = Math.max(fromIndex, 0);
        if (i$iv <= limit$iv) {
            while (!SegmentedByteString.arrayRangeEquals(getData$okio(), i$iv, other, 0, other.length)) {
                if (i$iv != limit$iv) {
                    i$iv++;
                }
            }
            return i$iv;
        }
        return -1;
    }

    public static  int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i);
    }

    public final int lastIndexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int fromIndex$iv = lastIndexOf(other.internalArray$okio(), fromIndex);
        return fromIndex$iv;
    }

    public static  int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(bArr, i);
    }

    public int lastIndexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int fromIndex$iv = SegmentedByteString.resolveDefaultParameter(this, fromIndex);
        int limit$iv = getData$okio().length - other.length;
        for (int i$iv = Math.min(fromIndex$iv, limit$iv); -1 < i$iv; i$iv--) {
            if (SegmentedByteString.arrayRangeEquals(getData$okio(), i$iv, other, 0, other.length)) {
                return i$iv;
            }
        }
        return -1;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            return ((ByteString) other).size() == getData$okio().length && ((ByteString) other).rangeEquals(0, getData$okio(), 0, getData$okio().length);
        }
        return false;
    }

    public int hashCode() {
        int result$iv = getHashCode$okio();
        if (result$iv != 0) {
            return result$iv;
        }
        int it$iv = Arrays.hashCode(getData$okio());
        setHashCode$okio(it$iv);
        return it$iv;
    }

    @Override
    public int compareTo(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int sizeA$iv = size();
        int sizeB$iv = other.size();
        int size$iv = Math.min(sizeA$iv, sizeB$iv);
        for (int i$iv = 0; i$iv < size$iv; i$iv++) {
            int $this$and$iv$iv = getByte(i$iv);
            int byteA$iv = $this$and$iv$iv & KotlinVersion.MAX_COMPONENT_VALUE;
            byte $this$and$iv$iv2 = other.getByte(i$iv);
            int byteB$iv = $this$and$iv$iv2 & UByte.MAX_VALUE;
            if (byteA$iv != byteB$iv) {
                return byteA$iv < byteB$iv ? -1 : 1;
            }
        }
        if (sizeA$iv == sizeB$iv) {
            return 0;
        }
        return sizeA$iv < sizeB$iv ? -1 : 1;
    }

    public String toString() {
        String str;
        String string;
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int i$iv = ni.shikatu.okio.internal.ByteString.codePointIndexToCharIndex(getData$okio(), 64);
        if (i$iv == -1) {
            if (getData$okio().length <= 64) {
                string = "[hex=" + hex() + AbstractJsonLexerKt.END_LIST;
            } else {
                StringBuilder sbAppend = new StringBuilder().append("[size=").append(getData$okio().length).append(" hex=");
                ByteString $this$commonSubstring$iv$iv = this;
                int endIndex$iv$iv = SegmentedByteString.resolveDefaultParameter($this$commonSubstring$iv$iv, 64);
                if (!(endIndex$iv$iv <= $this$commonSubstring$iv$iv.getData$okio().length)) {
                    throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring$iv$iv.getData$okio().length + ')').toString());
                }
                int subLen$iv$iv = endIndex$iv$iv - 0;
                if (!(subLen$iv$iv >= 0)) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                if (endIndex$iv$iv != $this$commonSubstring$iv$iv.getData$okio().length) {
                    $this$commonSubstring$iv$iv = new ByteString(ArraysKt.copyOfRange($this$commonSubstring$iv$iv.getData$okio(), 0, endIndex$iv$iv));
                }
                string = sbAppend.append($this$commonSubstring$iv$iv.hex()).append("…]").toString();
            }
            return string;
        }
        String text$iv = utf8();
        String strSubstring = text$iv.substring(0, i$iv);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String safeText$iv = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (i$iv < text$iv.length()) {
            str = "[size=" + getData$okio().length + " text=" + safeText$iv + "…]";
        } else {
            str = "[text=" + safeText$iv + AbstractJsonLexerKt.END_LIST;
        }
        return str;
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException {
        int dataLength = in.readInt();
        ByteString byteString = Companion.read(in, dataLength);
        Field field = ByteString.class.getDeclaredField("data");
        field.setAccessible(true);
        field.set(this, byteString.data);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))

    public final byte m1753deprecated_getByte(int index) {
        return getByte(index);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))

    public final int m1754deprecated_size() {
        return size();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u00020\n\"\u00020\u000bH\u0007J%\u0010\f\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\bJ\u0011\u0010\f\u001a\u00020\u0007*\u00020\u0010H\u0007¢\u0006\u0002\b\bJ\f\u0010\u0011\u001a\u00020\u0007*\u00020\u0012H\u0007J\u001b\u0010\u0013\u001a\u00020\u0007*\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0007J\f\u0010\u0018\u001a\u00020\u0007*\u00020\u0012H\u0007J\u0019\u0010\u0019\u001a\u00020\u0007*\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\u001bJ\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u001dJ\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u001eJ\u001d\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u001fJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0012H\u0007¢\u0006\u0002\b J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\"J%\u0010\b\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\"J\u001d\u0010\u001b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\b%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lni/shikatu/okio/ByteString$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "EMPTY", "Lni/shikatu/okio/ByteString;", "of", "data", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "toByteString", "offset", _UrlKt.FRAGMENT_ENCODE_SET, "byteCount", "Ljava/nio/ByteBuffer;", "encodeUtf8", _UrlKt.FRAGMENT_ENCODE_SET, "encode", "charset", "Ljava/nio/charset/Charset;", "encodeString", "decodeBase64", "decodeHex", "readByteString", "Ljava/io/InputStream;", "read", "string", "-deprecated_decodeBase64", "-deprecated_decodeHex", "-deprecated_encodeString", "-deprecated_encodeUtf8", "buffer", "-deprecated_of", "array", "inputstream", "-deprecated_read", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ByteString of(byte... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            return new ByteString(bArrCopyOf);
        }

        public static  ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i, i2);
        }

        @JvmStatic
        public final ByteString of(byte[] $this$toByteString, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter($this$toByteString, "<this>");
            int byteCount$iv = SegmentedByteString.resolveDefaultParameter($this$toByteString, byteCount);
            SegmentedByteString.checkOffsetAndCount($this$toByteString.length, offset, byteCount$iv);
            return new ByteString(ArraysKt.copyOfRange($this$toByteString, offset, offset + byteCount$iv));
        }

        @JvmStatic
        public final ByteString of(ByteBuffer $this$toByteString) {
            Intrinsics.checkNotNullParameter($this$toByteString, "<this>");
            byte[] copy = new byte[$this$toByteString.remaining()];
            $this$toByteString.get(copy);
            return new ByteString(copy);
        }

        @JvmStatic
        public final ByteString encodeUtf8(String $this$encodeUtf8) {
            Intrinsics.checkNotNullParameter($this$encodeUtf8, "<this>");
            ByteString byteString$iv = new ByteString(_JvmPlatformKt.asUtf8ToByteArray($this$encodeUtf8));
            byteString$iv.setUtf8$okio($this$encodeUtf8);
            return byteString$iv;
        }

        public static  ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.encodeString(str, charset);
        }

        @JvmStatic
        public final ByteString encodeString(String $this$encode, Charset charset) {
            Intrinsics.checkNotNullParameter($this$encode, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = $this$encode.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return new ByteString(bytes);
        }

        @JvmStatic
        public final ByteString decodeBase64(String $this$decodeBase64) {
            Intrinsics.checkNotNullParameter($this$decodeBase64, "<this>");
            byte[] decoded$iv = Base64.decodeBase64ToArray($this$decodeBase64);
            if (decoded$iv != null) {
                return new ByteString(decoded$iv);
            }
            return null;
        }

        @JvmStatic
        public final ByteString decodeHex(String $this$decodeHex) {
            Intrinsics.checkNotNullParameter($this$decodeHex, "<this>");
            if (!($this$decodeHex.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + $this$decodeHex).toString());
            }
            byte[] result$iv = new byte[$this$decodeHex.length() / 2];
            int length = result$iv.length;
            for (int i$iv = 0; i$iv < length; i$iv++) {
                int d1$iv = ByteStringNonJs.decodeHexDigit($this$decodeHex.charAt(i$iv * 2)) << 4;
                int d2$iv = ByteStringNonJs.decodeHexDigit($this$decodeHex.charAt((i$iv * 2) + 1));
                result$iv[i$iv] = (byte) (d1$iv + d2$iv);
            }
            return new ByteString(result$iv);
        }

        @JvmStatic
        public final ByteString read(InputStream $this$readByteString, int byteCount) throws IOException {
            Intrinsics.checkNotNullParameter($this$readByteString, "<this>");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            byte[] result = new byte[byteCount];
            int offset = 0;
            while (offset < byteCount) {
                int read = $this$readByteString.read(result, offset, byteCount - offset);
                if (read == -1) {
                    throw new EOFException();
                }
                offset += read;
            }
            return new ByteString(result);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"ni.shikatu.okio.ByteString.Companion.decodeBase64"}))

        public final ByteString m1755deprecated_decodeBase64(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeBase64(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"ni.shikatu.okio.ByteString.Companion.decodeHex"}))

        public final ByteString m1756deprecated_decodeHex(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeHex(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"ni.shikatu.okio.ByteString.Companion.encode"}))

        public final ByteString m1757deprecated_encodeString(String string, Charset charset) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"ni.shikatu.okio.ByteString.Companion.encodeUtf8"}))

        public final ByteString m1758deprecated_encodeUtf8(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"ni.shikatu.okio.ByteString.Companion.toByteString"}))

        public final ByteString m1759deprecated_of(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            return of(buffer);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"ni.shikatu.okio.ByteString.Companion.toByteString"}))

        public final ByteString m1760deprecated_of(byte[] array, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(array, "array");
            return of(array, offset, byteCount);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"ni.shikatu.okio.ByteString.Companion.readByteString"}))

        public final ByteString m1761deprecated_read(InputStream inputstream, int byteCount) {
            Intrinsics.checkNotNullParameter(inputstream, "inputstream");
            return read(inputstream, byteCount);
        }
    }

    @JvmStatic
    public static final ByteString of(byte... data) {
        return Companion.of(data);
    }

    @JvmStatic
    public static final ByteString of(byte[] $this$of, int offset, int byteCount) {
        return Companion.of($this$of, offset, byteCount);
    }

    @JvmStatic
    public static final ByteString of(ByteBuffer $this$of) {
        return Companion.of($this$of);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String $this$encodeUtf8) {
        return Companion.encodeUtf8($this$encodeUtf8);
    }

    @JvmStatic
    public static final ByteString encodeString(String $this$encodeString, Charset charset) {
        return Companion.encodeString($this$encodeString, charset);
    }

    @JvmStatic
    public static final ByteString decodeBase64(String $this$decodeBase64) {
        return Companion.decodeBase64($this$decodeBase64);
    }

    @JvmStatic
    public static final ByteString decodeHex(String $this$decodeHex) {
        return Companion.decodeHex($this$decodeHex);
    }

    @JvmStatic
    public static final ByteString read(InputStream $this$read, int byteCount) throws IOException {
        return Companion.read($this$read, byteCount);
    }
}
