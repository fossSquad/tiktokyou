package ni.shikatu.okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\r\u0010\u0018\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u001aR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lni/shikatu/okio/HashingSink;", "Lni/shikatu/okio/ForwardingSink;", "Lni/shikatu/okio/Sink;", "sink", "digest", "Ljava/security/MessageDigest;", "<init>", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "algorithm", _UrlKt.FRAGMENT_ENCODE_SET, "(Lokio/Sink;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "key", "Lni/shikatu/okio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "messageDigest", "write", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/Buffer;", "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "hash", "()Lokio/ByteString;", "-deprecated_hash", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HashingSink extends ForwardingSink implements Sink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public HashingSink(Sink sink, MessageDigest digest) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    public HashingSink(Sink sink, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
        this(sink, messageDigest);
    }

    public HashingSink(Sink sink, Mac mac) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    public HashingSink(Sink sink, ByteString key, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        try {
            Mac $this$_init__u24lambda_u240 = Mac.getInstance(algorithm);
            $this$_init__u24lambda_u240.init(new SecretKeySpec(key.toByteArray(), algorithm));
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNull($this$_init__u24lambda_u240);
            this(sink, $this$_init__u24lambda_u240);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void write(Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, byteCount);
        long hashedCount = 0;
        Segment s = source.head;
        Intrinsics.checkNotNull(s);
        while (hashedCount < byteCount) {
            long a$iv = byteCount - hashedCount;
            int b$iv = s.limit - s.pos;
            int toHash = (int) Math.min(a$iv, b$iv);
            if (this.messageDigest != null) {
                this.messageDigest.update(s.data, s.pos, toHash);
            } else {
                Mac mac = this.mac;
                Intrinsics.checkNotNull(mac);
                mac.update(s.data, s.pos, toHash);
            }
            hashedCount += (long) toHash;
            Segment segment = s.next;
            Intrinsics.checkNotNull(segment);
            s = segment;
        }
        super.write(source, byteCount);
    }

    public final ByteString hash() {
        byte[] result;
        if (this.messageDigest != null) {
            result = this.messageDigest.digest();
        } else {
            Mac mac = this.mac;
            Intrinsics.checkNotNull(mac);
            result = mac.doFinal();
        }
        Intrinsics.checkNotNull(result);
        return new ByteString(result);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))

    public final ByteString m1770deprecated_hash() {
        return hash();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u0010"}, d2 = {"Lni/shikatu/okio/HashingSink$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "md5", "Lni/shikatu/okio/HashingSink;", "sink", "Lni/shikatu/okio/Sink;", "sha1", "sha256", "sha512", "hmacSha1", "key", "Lni/shikatu/okio/ByteString;", "hmacSha256", "hmacSha512", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HashingSink md5(Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        public final HashingSink sha1(Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        public final HashingSink sha256(Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @JvmStatic
        public final HashingSink sha512(Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        @JvmStatic
        public final HashingSink hmacSha1(Sink sink, ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSink hmacSha256(Sink sink, ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSink hmacSha512(Sink sink, ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }
    }

    @JvmStatic
    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    @JvmStatic
    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    @JvmStatic
    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    @JvmStatic
    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    @JvmStatic
    public static final HashingSink hmacSha1(Sink sink, ByteString key) {
        return Companion.hmacSha1(sink, key);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(Sink sink, ByteString key) {
        return Companion.hmacSha256(sink, key);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(Sink sink, ByteString key) {
        return Companion.hmacSha512(sink, key);
    }
}
