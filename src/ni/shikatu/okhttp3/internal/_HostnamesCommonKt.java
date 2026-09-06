package ni.shikatu.okhttp3.internal;

import java.io.EOFException;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.Regex;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.idn.IdnaMappingTableInstanceKt;
import ni.shikatu.okhttp3.internal.idn.Punycode;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a0\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"VERIFY_AS_IP_ADDRESS", "Lni/shikatu/kotlin/text/Regex;", "canParseAsIpAddress", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "containsInvalidLabelLengths", "containsInvalidHostnameAsciiCodes", "decodeIpv6", _UrlKt.FRAGMENT_ENCODE_SET, "input", "pos", _UrlKt.FRAGMENT_ENCODE_SET, "limit", "decodeIpv4Suffix", "address", "addressOffset", "inet6AddressToAscii", "canonicalizeInetAddress", "isMappedIpv4Address", "inet4AddressToAscii", "toCanonicalHost", "idnToAscii", "host", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _HostnamesCommonKt {
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String $this$canParseAsIpAddress) {
        Intrinsics.checkNotNullParameter($this$canParseAsIpAddress, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches($this$canParseAsIpAddress);
    }

    public static final boolean containsInvalidLabelLengths(String $this$containsInvalidLabelLengths) {
        Intrinsics.checkNotNullParameter($this$containsInvalidLabelLengths, "<this>");
        int length = $this$containsInvalidLabelLengths.length();
        if (!(1 <= length && length < 254)) {
            return true;
        }
        int labelStart = 0;
        while (true) {
            int dot = StringsKt.indexOf$default((CharSequence) $this$containsInvalidLabelLengths, '.', labelStart, false, 4, (Object) null);
            int labelLength = dot == -1 ? $this$containsInvalidLabelLengths.length() - labelStart : dot - labelStart;
            if (!(1 <= labelLength && labelLength < 64)) {
                return true;
            }
            if (dot == -1 || dot == $this$containsInvalidLabelLengths.length() - 1) {
                return false;
            }
            labelStart = dot + 1;
        }
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String $this$containsInvalidHostnameAsciiCodes) {
        Intrinsics.checkNotNullParameter($this$containsInvalidHostnameAsciiCodes, "<this>");
        int length = $this$containsInvalidHostnameAsciiCodes.length();
        for (int i = 0; i < length; i++) {
            char c = $this$containsInvalidHostnameAsciiCodes.charAt(i);
            if (Intrinsics.compare((int) c, 31) <= 0 || Intrinsics.compare((int) c, 127) >= 0 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", c, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final byte[] decodeIpv6(String input, int pos, int limit) {
        String input2;
        int value;
        int groupLength;
        int hexDigit;
        Intrinsics.checkNotNullParameter(input, "input");
        byte[] address = new byte[16];
        int b = 0;
        int compress = -1;
        int groupOffset = -1;
        int i = pos;
        while (i < limit) {
            if (b == address.length) {
                return null;
            }
            if (i + 2 <= limit) {
                input2 = input;
                if (StringsKt.startsWith$default(input2, "::", i, false, 4, (Object) null)) {
                    if (compress != -1) {
                        return null;
                    }
                    i += 2;
                    b += 2;
                    compress = b;
                    if (i == limit) {
                        break;
                    }
                    value = 0;
                    groupOffset = i;
                    while (i < limit) {
                        hexDigit = _UtilCommonKt.parseHexDigit(input2.charAt(i));
                        if (hexDigit != -1) {
                            break;
                        }
                        value = (value << 4) + hexDigit;
                        i++;
                    }
                    groupLength = i - groupOffset;
                    if (groupLength != 0 || groupLength > 4) {
                        return null;
                    }
                    int b2 = b + 1;
                    address[b] = (byte) ((value >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                    b = b2 + 1;
                    address[b2] = (byte) (value & KotlinVersion.MAX_COMPONENT_VALUE);
                    input = input2;
                }
            } else {
                input2 = input;
            }
            if (b != 0) {
                if (StringsKt.startsWith$default(input2, ":", i, false, 4, (Object) null)) {
                    i++;
                } else {
                    if (!StringsKt.startsWith$default(input2, ".", i, false, 4, (Object) null) || !decodeIpv4Suffix(input2, groupOffset, limit, address, b - 2)) {
                        return null;
                    }
                    b += 2;
                    break;
                }
            }
            value = 0;
            groupOffset = i;
            while (i < limit) {
                hexDigit = _UtilCommonKt.parseHexDigit(input2.charAt(i));
                if (hexDigit != -1) {
                    break;
                    break;
                }
                value = (value << 4) + hexDigit;
                i++;
            }
            groupLength = i - groupOffset;
            if (groupLength != 0) {
            }
            return null;
        }
        if (b != address.length) {
            if (compress == -1) {
                return null;
            }
            ArraysKt.copyInto(address, address, address.length - (b - compress), compress, b);
            ArraysKt.fill(address, (byte) 0, compress, (address.length - b) + compress);
        }
        return address;
    }

    public static final boolean decodeIpv4Suffix(String input, int pos, int limit, byte[] address, int addressOffset) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(address, "address");
        int b = addressOffset;
        int i = pos;
        while (i < limit) {
            if (b == address.length) {
                return false;
            }
            if (b != addressOffset) {
                if (input.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int value = 0;
            int groupOffset = i;
            while (i < limit) {
                char c = input.charAt(i);
                if (Intrinsics.compare((int) c, 48) < 0 || Intrinsics.compare((int) c, 57) > 0) {
                    break;
                }
                if ((value == 0 && groupOffset != i) || (value = ((value * 10) + c) - 48) > 255) {
                    return false;
                }
                i++;
            }
            int groupLength = i - groupOffset;
            if (groupLength == 0) {
                return false;
            }
            address[b] = (byte) value;
            b++;
        }
        return b == addressOffset + 4;
    }

    public static final String inet6AddressToAscii(byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        int longestRunOffset = -1;
        int longestRunLength = 0;
        int i = 0;
        while (i < address.length) {
            int currentRunOffset = i;
            while (i < 16 && address[i] == 0 && address[i + 1] == 0) {
                i += 2;
            }
            int currentRunLength = i - currentRunOffset;
            if (currentRunLength > longestRunLength && currentRunLength >= 4) {
                longestRunOffset = currentRunOffset;
                longestRunLength = currentRunLength;
            }
            i += 2;
        }
        Buffer result = new Buffer();
        int i2 = 0;
        while (i2 < address.length) {
            if (i2 == longestRunOffset) {
                result.writeByte(58);
                i2 += longestRunLength;
                if (i2 == 16) {
                    result.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    result.writeByte(58);
                }
                int group = (_UtilCommonKt.and(address[i2], KotlinVersion.MAX_COMPONENT_VALUE) << 8) | _UtilCommonKt.and(address[i2 + 1], KotlinVersion.MAX_COMPONENT_VALUE);
                result.writeHexadecimalUnsignedLong(group);
                i2 += 2;
            }
        }
        return result.readUtf8();
    }

    public static final byte[] canonicalizeInetAddress(byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return isMappedIpv4Address(address) ? ArraysKt.sliceArray(address, RangesKt.until(12, 16)) : address;
    }

    private static final boolean isMappedIpv4Address(byte[] address) {
        if (address.length != 16) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (address[i] != 0) {
                return false;
            }
        }
        int i2 = address[10];
        return i2 == -1 && address[11] == -1;
    }

    public static final String inet4AddressToAscii(byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (!(address.length == 4)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return new Buffer().writeDecimalLong(_UtilCommonKt.and(address[0], KotlinVersion.MAX_COMPONENT_VALUE)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[1], KotlinVersion.MAX_COMPONENT_VALUE)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[2], KotlinVersion.MAX_COMPONENT_VALUE)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[3], KotlinVersion.MAX_COMPONENT_VALUE)).readUtf8();
    }

    public static final String toCanonicalHost(String $this$toCanonicalHost) {
        Intrinsics.checkNotNullParameter($this$toCanonicalHost, "<this>");
        if (StringsKt.contains$default((CharSequence) $this$toCanonicalHost, (CharSequence) ":", false, 2, (Object) null)) {
            byte[] inetAddressByteArray = (StringsKt.startsWith$default($this$toCanonicalHost, "[", false, 2, (Object) null) && StringsKt.endsWith$default($this$toCanonicalHost, "]", false, 2, (Object) null)) ? decodeIpv6($this$toCanonicalHost, 1, $this$toCanonicalHost.length() - 1) : decodeIpv6($this$toCanonicalHost, 0, $this$toCanonicalHost.length());
            if (inetAddressByteArray == null) {
                return null;
            }
            byte[] address = canonicalizeInetAddress(inetAddressByteArray);
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            if (address.length == 4) {
                return inet4AddressToAscii(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + $this$toCanonicalHost + '\'');
        }
        String result = idnToAscii($this$toCanonicalHost);
        if (result == null) {
            return null;
        }
        if ((result.length() == 0) || containsInvalidHostnameAsciiCodes(result) || containsInvalidLabelLengths(result)) {
            return null;
        }
        return result;
    }

    public static final String idnToAscii(String host) throws EOFException {
        Intrinsics.checkNotNullParameter(host, "host");
        Buffer bufferA = new Buffer().writeUtf8(host);
        Buffer bufferB = new Buffer();
        while (!bufferA.exhausted()) {
            int codePoint = bufferA.readUtf8CodePoint();
            if (!IdnaMappingTableInstanceKt.getIDNA_MAPPING_TABLE().map(codePoint, bufferB)) {
                return null;
            }
        }
        String normalized = _NormalizeJvmKt.normalizeNfc(bufferB.readUtf8());
        bufferA.writeUtf8(normalized);
        String decoded = Punycode.INSTANCE.decode(bufferA.readUtf8());
        if (decoded != null && Intrinsics.areEqual(decoded, _NormalizeJvmKt.normalizeNfc(decoded))) {
            return Punycode.INSTANCE.encode(decoded);
        }
        return null;
    }
}
