package ni.shikatu.kotlin.io.encoding;

import java.io.IOException;
import java.nio.charset.Charset;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.CharsKt;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Utf8;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000 F2\u00020\u0001:\u0002EFB)\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bH\u0087\u0080\u0004b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J8\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J&\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004JE\u0010\"\u001a\u0002H#\"\f\b\u0000\u0010#*\u00060$j\u0002`%2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u0002H#2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0087\u0080\bb\u0002\b'¢\u0006\u0002\u0010&J&\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J8\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J&\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020*2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J8\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J'\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b,J7\u0010-\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b.J\u0017\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b1J\n\u00102\u001a\u00020\u0003H\u0082\u0080\u0004J2\u00103\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0082\u0080\u0004J'\u00104\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b5J'\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b7J\u0017\u00108\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u0019H\u0080\u0080\u0004¢\u0006\u0002\b9J*\u0010:\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0082\u0080\u0004J\u0012\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u00020\u0006H\u0082\u0080\u0004J\"\u0010?\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0082\u0080\u0004J'\u0010@\u001a\u00020>2\u0006\u00100\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\bAJ\"\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006H\u0082\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u00020\u0006X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u00020\bX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000f\u0010\u0012\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(HÊ\u0001\u0010\bI\u0012\f\bJ\u0012\b\b\fJ\u0004\b\t0K¨\u0006G"}, d2 = {"Lni/shikatu/kotlin/io/encoding/Base64;", _UrlKt.FRAGMENT_ENCODE_SET, "isUrlSafe", _UrlKt.FRAGMENT_ENCODE_SET, "isMimeScheme", "mimeLineLength", _UrlKt.FRAGMENT_ENCODE_SET, "paddingOption", "Lni/shikatu/kotlin/io/encoding/Base64$PaddingOption;", "<init>", "(ZZILkotlin/io/encoding/Base64$PaddingOption;)V", "isUrlSafe$kotlin_stdlib", "()Z", "isMimeScheme$kotlin_stdlib", "getMimeLineLength$kotlin_stdlib", "()I", "getPaddingOption$kotlin_stdlib", "()Lkotlin/io/encoding/Base64$PaddingOption;", "mimeGroupsPerLine", "withPadding", "option", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.0", "encodeToByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "source", "startIndex", "endIndex", "encodeIntoByteArray", "destination", "destinationOffset", "encode", _UrlKt.FRAGMENT_ENCODE_SET, "encodeToAppendable", "A", "Ljava/lang/Appendable;", "Lni/shikatu/kotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "decode", "decodeIntoByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "sourceSize", "encodeSize$kotlin_stdlib", "shouldPadOnEncode", "decodeImpl", "decodeSize", "decodeSize$kotlin_stdlib", "charsToBytesImpl", "charsToBytesImpl$kotlin_stdlib", "bytesToStringImpl", "bytesToStringImpl$kotlin_stdlib", "handlePaddingSymbol", "padIndex", "byteStart", "checkPaddingIsAllowed", _UrlKt.FRAGMENT_ENCODE_SET, "skipIllegalSymbolsIfMime", "checkSourceBounds", "checkSourceBounds$kotlin_stdlib", "checkDestinationBounds", "destinationSize", "capacityNeeded", "PaddingOption", "Default", "ni.shikatu.kotlin-stdlib", "2.2", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/io/encoding/ExperimentalEncodingApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Base64 {
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int lineLengthPem = 64;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;
    private final int mimeGroupsPerLine;
    private final int mimeLineLength;
    private final PaddingOption paddingOption;
    public static final Default Default = new Default(null);
    private static final byte[] mimeLineSeparatorSymbols = {13, 10};
    private static final Base64 UrlSafe = new Base64(true, false, -1, PaddingOption.PRESENT);
    private static final int lineLengthMime = 76;
    private static final Base64 Mime = new Base64(false, true, lineLengthMime, PaddingOption.PRESENT);
    private static final Base64 Pem = new Base64(false, true, 64, PaddingOption.PRESENT);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/io/encoding/Base64$PaddingOption;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "PRESENT", "ABSENT", "PRESENT_OPTIONAL", "ABSENT_OPTIONAL", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.0"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public enum PaddingOption {
        PRESENT,
        ABSENT,
        PRESENT_OPTIONAL,
        ABSENT_OPTIONAL;

        private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<PaddingOption> getEntries() {
            return $ENTRIES;
        }
    }

    public  Base64(boolean z, boolean z2, int i, PaddingOption paddingOption, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, i, paddingOption);
    }

    private Base64(boolean isUrlSafe, boolean isMimeScheme, int mimeLineLength, PaddingOption paddingOption) {
        this.isUrlSafe = isUrlSafe;
        this.isMimeScheme = isMimeScheme;
        this.mimeLineLength = mimeLineLength;
        this.paddingOption = paddingOption;
        if (!((this.isUrlSafe && this.isMimeScheme) ? false : true)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.mimeGroupsPerLine = this.mimeLineLength / 4;
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final int getMimeLineLength$kotlin_stdlib() {
        return this.mimeLineLength;
    }

    public final PaddingOption getPaddingOption$kotlin_stdlib() {
        return this.paddingOption;
    }

    public final Base64 withPadding(PaddingOption option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return this.paddingOption == option ? this : new Base64(this.isUrlSafe, this.isMimeScheme, this.mimeLineLength, option);
    }

    public static  byte[] encodeToByteArray$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.encodeToByteArray(bArr, i, i2);
    }

    public final byte[] encodeToByteArray(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex);
    }

    public static  int encodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
        }
        if ((i4 & 4) != 0) {
            i = 0;
        }
        if ((i4 & 8) != 0) {
            i2 = 0;
        }
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return base64.encodeIntoByteArray(bArr, bArr2, i, i2, i3);
    }

    public final int encodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, destinationOffset, startIndex, endIndex);
    }

    public static  String encode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.encode(bArr, i, i2);
    }

    public final String encode(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
    }

    public static  Appendable encodeToAppendable$default(Base64 base64, byte[] bArr, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        return base64.encodeToAppendable(bArr, appendable, i, i2);
    }

    @IgnorableReturnValue
    public final <A extends Appendable> A encodeToAppendable(byte[] source, A a, int startIndex, int endIndex) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(a, "destination");
        String stringResult = new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
        a.append(stringResult);
        return a;
    }

    public static  byte[] decode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.decode(bArr, i, i2);
    }

    public final byte[] decode(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        int decodeSize = decodeSize$kotlin_stdlib(source, startIndex, endIndex);
        byte[] destination = new byte[decodeSize];
        int bytesWritten = decodeImpl(source, destination, 0, startIndex, endIndex);
        if (!(bytesWritten == destination.length)) {
            throw new IllegalStateException("Check failed.");
        }
        return destination;
    }

    public static  int decodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        if ((i4 & 4) != 0) {
            i = 0;
        }
        if ((i4 & 8) != 0) {
            i2 = 0;
        }
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return base64.decodeIntoByteArray(bArr, bArr2, i, i2, i3);
    }

    public final int decodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        checkDestinationBounds(destination.length, destinationOffset, decodeSize$kotlin_stdlib(source, startIndex, endIndex));
        return decodeImpl(source, destination, destinationOffset, startIndex, endIndex);
    }

    public static  byte[] decode$default(Base64 base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return base64.decode(charSequence, i, i2);
    }

    public final byte[] decode(CharSequence source, int startIndex, int endIndex) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof String) {
            checkSourceBounds$kotlin_stdlib(((String) source).length(), startIndex, endIndex);
            String strSubstring = ((String) source).substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, "getBytes(...)");
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        byte[] byteSource = bArrCharsToBytesImpl$kotlin_stdlib;
        return decode$default(this, byteSource, 0, 0, 6, (Object) null);
    }

    public static  int decodeIntoByteArray$default(Base64 base64, CharSequence charSequence, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        if ((i4 & 4) != 0) {
            i = 0;
        }
        if ((i4 & 8) != 0) {
            i2 = 0;
        }
        if ((i4 & 16) != 0) {
            i3 = charSequence.length();
        }
        return base64.decodeIntoByteArray(charSequence, bArr, i, i2, i3);
    }

    public final int decodeIntoByteArray(CharSequence source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (source instanceof String) {
            checkSourceBounds$kotlin_stdlib(((String) source).length(), startIndex, endIndex);
            String strSubstring = ((String) source).substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, "getBytes(...)");
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        byte[] byteSource = bArrCharsToBytesImpl$kotlin_stdlib;
        return decodeIntoByteArray$default(this, byteSource, destination, destinationOffset, 0, 0, 24, (Object) null);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        int encodeSize = encodeSize$kotlin_stdlib(endIndex - startIndex);
        byte[] destination = new byte[encodeSize];
        encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, 0, startIndex, endIndex);
        return destination;
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        checkDestinationBounds(destination.length, destinationOffset, encodeSize$kotlin_stdlib(endIndex - startIndex));
        byte[] encodeMap = this.isUrlSafe ? Base64Kt.base64UrlEncodeMap : Base64Kt.base64EncodeMap;
        int sourceIndex = startIndex;
        int destinationIndex = destinationOffset;
        int groupsPerLine = this.isMimeScheme ? this.mimeGroupsPerLine : IntCompanionObject.MAX_VALUE;
        while (true) {
            if (sourceIndex + 2 >= endIndex) {
                break;
            }
            int groups = Math.min((endIndex - sourceIndex) / 3, groupsPerLine);
            int i = 0;
            while (i < groups) {
                int sourceIndex2 = sourceIndex + 1;
                int byte1 = source[sourceIndex] & KotlinVersion.MAX_COMPONENT_VALUE;
                int sourceIndex3 = sourceIndex2 + 1;
                int byte2 = source[sourceIndex2] & KotlinVersion.MAX_COMPONENT_VALUE;
                int sourceIndex4 = sourceIndex3 + 1;
                int byte3 = source[sourceIndex3] & KotlinVersion.MAX_COMPONENT_VALUE;
                int bits = (byte1 << 16) | (byte2 << 8) | byte3;
                int destinationIndex2 = destinationIndex + 1;
                destination[destinationIndex] = encodeMap[bits >>> 18];
                int destinationIndex3 = destinationIndex2 + 1;
                destination[destinationIndex2] = encodeMap[(bits >>> 12) & 63];
                int destinationIndex4 = destinationIndex3 + 1;
                destination[destinationIndex3] = encodeMap[(bits >>> 6) & 63];
                destinationIndex = destinationIndex4 + 1;
                destination[destinationIndex4] = encodeMap[bits & 63];
                i++;
                sourceIndex = sourceIndex4;
            }
            if (groups == groupsPerLine && sourceIndex != endIndex) {
                int destinationIndex5 = destinationIndex + 1;
                destination[destinationIndex] = mimeLineSeparatorSymbols[0];
                destinationIndex = destinationIndex5 + 1;
                destination[destinationIndex5] = mimeLineSeparatorSymbols[1];
            }
        }
        switch (endIndex - sourceIndex) {
            case 1:
                int byte4 = sourceIndex + 1;
                int byte5 = source[sourceIndex] & KotlinVersion.MAX_COMPONENT_VALUE;
                int bits2 = byte5 << 4;
                int destinationIndex6 = destinationIndex + 1;
                destination[destinationIndex] = encodeMap[bits2 >>> 6];
                destinationIndex = destinationIndex6 + 1;
                destination[destinationIndex6] = encodeMap[bits2 & 63];
                if (!shouldPadOnEncode()) {
                    sourceIndex = byte4;
                } else {
                    int destinationIndex7 = destinationIndex + 1;
                    destination[destinationIndex] = padSymbol;
                    destinationIndex = destinationIndex7 + 1;
                    destination[destinationIndex7] = padSymbol;
                    sourceIndex = byte4;
                }
                break;
            case 2:
                int sourceIndex5 = sourceIndex + 1;
                int byte6 = source[sourceIndex] & KotlinVersion.MAX_COMPONENT_VALUE;
                int sourceIndex6 = sourceIndex5 + 1;
                int bits3 = (byte6 << 10) | ((source[sourceIndex5] & KotlinVersion.MAX_COMPONENT_VALUE) << 2);
                int destinationIndex8 = destinationIndex + 1;
                destination[destinationIndex] = encodeMap[bits3 >>> 12];
                int destinationIndex9 = destinationIndex8 + 1;
                destination[destinationIndex8] = encodeMap[(bits3 >>> 6) & 63];
                int destinationIndex10 = destinationIndex9 + 1;
                destination[destinationIndex9] = encodeMap[bits3 & 63];
                if (!shouldPadOnEncode()) {
                    sourceIndex = sourceIndex6;
                    destinationIndex = destinationIndex10;
                } else {
                    destinationIndex = destinationIndex10 + 1;
                    destination[destinationIndex10] = padSymbol;
                    sourceIndex = sourceIndex6;
                }
                break;
        }
        if (!(sourceIndex == endIndex)) {
            throw new IllegalStateException("Check failed.");
        }
        return destinationIndex - destinationOffset;
    }

    public final int encodeSize$kotlin_stdlib(int sourceSize) {
        int groups = sourceSize / 3;
        int trailingBytes = sourceSize % 3;
        int size = groups * 4;
        if (trailingBytes != 0) {
            size += shouldPadOnEncode() ? 4 : trailingBytes + 1;
        }
        if (size < 0) {
            throw new IllegalArgumentException("Input is too big");
        }
        if (this.isMimeScheme) {
            size += ((size - 1) / this.mimeLineLength) * 2;
        }
        if (size < 0) {
            throw new IllegalArgumentException("Input is too big");
        }
        return size;
    }

    private final boolean shouldPadOnEncode() {
        return this.paddingOption == PaddingOption.PRESENT || this.paddingOption == PaddingOption.PRESENT_OPTIONAL;
    }

    private final int decodeImpl(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        int i;
        int symbol;
        int symbolBits;
        int[] decodeMap;
        int[] decodeMap2 = this.isUrlSafe ? Base64Kt.base64UrlDecodeMap : Base64Kt.base64DecodeMap;
        int payload = 0;
        int byteStart = -8;
        int symbol1 = startIndex;
        int destinationIndex = destinationOffset;
        boolean hasPadding = false;
        while (true) {
            if (symbol1 >= endIndex) {
                i = 8;
                break;
            }
            if (byteStart != -8 || symbol1 + 3 >= endIndex) {
                i = 8;
                symbol = source[symbol1] & UByte.MAX_VALUE;
                symbolBits = decodeMap2[symbol];
                if (symbolBits < 0) {
                    if (symbolBits == -2) {
                        hasPadding = true;
                        symbol1 = handlePaddingSymbol(source, symbol1, endIndex, byteStart);
                        break;
                    }
                    if (this.isMimeScheme) {
                        symbol1++;
                    } else {
                        StringBuilder sbAppend = new StringBuilder().append("Invalid symbol '").append((char) symbol).append("'(");
                        String string = Integer.toString(symbol, CharsKt.checkRadix(i));
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        throw new IllegalArgumentException(sbAppend.append(string).append(") at index ").append(symbol1).toString());
                    }
                } else {
                    decodeMap = decodeMap2;
                    symbol1++;
                    payload = (payload << 6) | symbolBits;
                    byteStart += 6;
                    if (byteStart >= 0) {
                        decodeMap2 = decodeMap;
                    } else {
                        destination[destinationIndex] = (byte) (payload >>> byteStart);
                        payload &= (1 << byteStart) - 1;
                        byteStart -= 8;
                        destinationIndex++;
                        decodeMap2 = decodeMap;
                    }
                }
            } else {
                int sourceIndex = symbol1 + 1;
                int symbol2 = decodeMap2[source[symbol1] & KotlinVersion.MAX_COMPONENT_VALUE];
                int sourceIndex2 = sourceIndex + 1;
                int symbol3 = decodeMap2[source[sourceIndex] & KotlinVersion.MAX_COMPONENT_VALUE];
                int sourceIndex3 = sourceIndex2 + 1;
                i = 8;
                int symbol4 = decodeMap2[source[sourceIndex2] & UByte.MAX_VALUE];
                int sourceIndex4 = sourceIndex3 + 1;
                int symbol5 = decodeMap2[source[sourceIndex3] & UByte.MAX_VALUE];
                int bits = (symbol2 << 18) | (symbol3 << 12) | (symbol4 << 6) | symbol5;
                if (bits >= 0) {
                    int destinationIndex2 = destinationIndex + 1;
                    destination[destinationIndex] = (byte) (bits >> 16);
                    int destinationIndex3 = destinationIndex2 + 1;
                    destination[destinationIndex2] = (byte) (bits >> 8);
                    destination[destinationIndex3] = (byte) bits;
                    destinationIndex = destinationIndex3 + 1;
                    symbol1 = sourceIndex4;
                } else {
                    symbol1 = sourceIndex4 - 4;
                    symbol = source[symbol1] & UByte.MAX_VALUE;
                    symbolBits = decodeMap2[symbol];
                    if (symbolBits < 0) {
                        if (symbolBits == -2) {
                            hasPadding = true;
                            symbol1 = handlePaddingSymbol(source, symbol1, endIndex, byteStart);
                            break;
                        }
                        if (this.isMimeScheme) {
                            symbol1++;
                        } else {
                            StringBuilder sbAppend2 = new StringBuilder().append("Invalid symbol '").append((char) symbol).append("'(");
                            String string2 = Integer.toString(symbol, CharsKt.checkRadix(i));
                            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                            throw new IllegalArgumentException(sbAppend2.append(string2).append(") at index ").append(symbol1).toString());
                        }
                    } else {
                        decodeMap = decodeMap2;
                        symbol1++;
                        payload = (payload << 6) | symbolBits;
                        byteStart += 6;
                        if (byteStart >= 0) {
                            decodeMap2 = decodeMap;
                        } else {
                            destination[destinationIndex] = (byte) (payload >>> byteStart);
                            payload &= (1 << byteStart) - 1;
                            byteStart -= 8;
                            destinationIndex++;
                            decodeMap2 = decodeMap;
                        }
                    }
                }
            }
        }
        if (byteStart == -2) {
            throw new IllegalArgumentException("The last unit of input does not have enough bits");
        }
        if (byteStart != -8 && !hasPadding && this.paddingOption == PaddingOption.PRESENT) {
            throw new IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
        }
        if (payload != 0) {
            throw new IllegalArgumentException("The pad bits must be zeros");
        }
        int sourceIndex5 = skipIllegalSymbolsIfMime(source, symbol1, endIndex);
        if (sourceIndex5 < endIndex) {
            int symbol6 = source[sourceIndex5] & UByte.MAX_VALUE;
            StringBuilder sbAppend3 = new StringBuilder().append("Symbol '").append((char) symbol6).append("'(");
            String string3 = Integer.toString(symbol6, CharsKt.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            throw new IllegalArgumentException(sbAppend3.append(string3).append(") at index ").append(sourceIndex5 - 1).append(" is prohibited after the pad character").toString());
        }
        return destinationIndex - destinationOffset;
    }

    public final int decodeSize$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        int symbols = endIndex - startIndex;
        if (symbols == 0) {
            return 0;
        }
        if (symbols == 1) {
            throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + startIndex + ", endIndex: " + endIndex);
        }
        if (this.isMimeScheme) {
            for (int index = startIndex; index < endIndex; index++) {
                int symbol = source[index] & KotlinVersion.MAX_COMPONENT_VALUE;
                int symbolBits = Base64Kt.base64DecodeMap[symbol];
                if (symbolBits < 0) {
                    if (symbolBits == -2) {
                        symbols -= endIndex - index;
                        break;
                    }
                    symbols--;
                }
            }
        } else {
            int index2 = endIndex - 1;
            if (source[index2] == 61) {
                symbols--;
                if (source[endIndex - 2] == 61) {
                    symbols--;
                }
            }
        }
        return (int) ((((long) symbols) * ((long) 6)) / ((long) 8));
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence source, int startIndex, int endIndex) {
        int length;
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
        byte[] byteArray = new byte[endIndex - startIndex];
        int length2 = 0;
        for (int index = startIndex; index < endIndex; index++) {
            int symbol = source.charAt(index);
            if (symbol <= 255) {
                length = length2 + 1;
                byteArray[length2] = (byte) symbol;
            } else {
                length = length2 + 1;
                byteArray[length2] = Utf8.REPLACEMENT_BYTE;
            }
            length2 = length;
        }
        return byteArray;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        StringBuilder stringBuilder = new StringBuilder(source.length);
        for (byte b : source) {
            stringBuilder.append((char) b);
        }
        return stringBuilder.toString();
    }

    private final int handlePaddingSymbol(byte[] source, int padIndex, int endIndex, int byteStart) {
        switch (byteStart) {
            case -8:
                throw new IllegalArgumentException("Redundant pad character at index " + padIndex);
            case -7:
            case -5:
            case -3:
            default:
                throw new IllegalStateException("Unreachable".toString());
            case -6:
                checkPaddingIsAllowed(padIndex);
                return padIndex + 1;
            case -4:
                checkPaddingIsAllowed(padIndex);
                int secondPadIndex = skipIllegalSymbolsIfMime(source, padIndex + 1, endIndex);
                if (secondPadIndex == endIndex || source[secondPadIndex] != 61) {
                    throw new IllegalArgumentException("Missing one pad character at index " + secondPadIndex);
                }
                return secondPadIndex + 1;
            case -2:
                return padIndex + 1;
        }
    }

    private final void checkPaddingIsAllowed(int padIndex) {
        if (this.paddingOption == PaddingOption.ABSENT) {
            throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + padIndex);
        }
    }

    private final int skipIllegalSymbolsIfMime(byte[] source, int startIndex, int endIndex) {
        if (!this.isMimeScheme) {
            return startIndex;
        }
        int sourceIndex = startIndex;
        while (sourceIndex < endIndex) {
            int symbol = source[sourceIndex] & KotlinVersion.MAX_COMPONENT_VALUE;
            if (Base64Kt.base64DecodeMap[symbol] != -1) {
                return sourceIndex;
            }
            sourceIndex++;
        }
        return sourceIndex;
    }

    public final void checkSourceBounds$kotlin_stdlib(int sourceSize, int startIndex, int endIndex) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, sourceSize);
    }

    private final void checkDestinationBounds(int destinationSize, int destinationOffset, int capacityNeeded) {
        if (destinationOffset < 0 || destinationOffset > destinationSize) {
            throw new IndexOutOfBoundsException("destination offset: " + destinationOffset + ", destination size: " + destinationSize);
        }
        int destinationEndIndex = destinationOffset + capacityNeeded;
        if (destinationEndIndex < 0 || destinationEndIndex > destinationSize) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + destinationOffset + ", destination size: " + destinationSize + ", capacity needed: " + capacityNeeded);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\nX\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u0015\u0010\r\u001a\u00020\u000eX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0016\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlin/io/encoding/Base64$Default;", "Lni/shikatu/kotlin/io/encoding/Base64;", "<init>", "()V", "bitsPerByte", _UrlKt.FRAGMENT_ENCODE_SET, "bitsPerSymbol", "bytesPerGroup", "symbolsPerGroup", "padSymbol", _UrlKt.FRAGMENT_ENCODE_SET, "lineLengthMime", "lineLengthPem", "mimeLineSeparatorSymbols", _UrlKt.FRAGMENT_ENCODE_SET, "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "UrlSafe", "getUrlSafe", "()Lkotlin/io/encoding/Base64;", "Mime", "getMime", "Pem", "getPem", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Default extends Base64 {
        public  Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Default() {
            super(false, false, -1, PaddingOption.PRESENT, null);
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.mimeLineSeparatorSymbols;
        }

        public final Base64 getUrlSafe() {
            return Base64.UrlSafe;
        }

        public final Base64 getMime() {
            return Base64.Mime;
        }

        public final Base64 getPem() {
            return Base64.Pem;
        }
    }
}
