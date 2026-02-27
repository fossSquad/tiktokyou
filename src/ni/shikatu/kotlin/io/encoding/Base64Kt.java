package ni.shikatu.kotlin.io.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0005¨\u0006\r"}, d2 = {"base64EncodeMap", "", "base64DecodeMap", "", "getBase64DecodeMap$annotations", "()V", "base64UrlEncodeMap", "base64UrlDecodeMap", "getBase64UrlDecodeMap$annotations", "isInMimeAlphabet", "", "symbol", "", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Base64Kt {
    private static final int[] base64DecodeMap;

    // bytes: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
    private static final byte[] base64EncodeMap = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final int[] base64UrlDecodeMap;
    private static final byte[] base64UrlEncodeMap;

    private static  void getBase64DecodeMap$annotations() {
    }

    private static  void getBase64UrlDecodeMap$annotations() {
    }

    static {
        int[] $this$base64DecodeMap_u24lambda_u241 = new int[256];
        ArraysKt.fill$default($this$base64DecodeMap_u24lambda_u241, -1, 0, 0, 6, (Object) null);
        $this$base64DecodeMap_u24lambda_u241[61] = -2;
        byte[] $this$forEachIndexed$iv = base64EncodeMap;
        int index$iv = 0;
        int length = $this$forEachIndexed$iv.length;
        int i = 0;
        while (i < length) {
            byte item$iv = $this$forEachIndexed$iv[i];
            $this$base64DecodeMap_u24lambda_u241[item$iv] = index$iv;
            i++;
            index$iv++;
        }
        base64DecodeMap = $this$base64DecodeMap_u24lambda_u241;
        base64UrlEncodeMap = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        int[] $this$base64UrlDecodeMap_u24lambda_u243 = new int[256];
        ArraysKt.fill$default($this$base64UrlDecodeMap_u24lambda_u243, -1, 0, 0, 6, (Object) null);
        $this$base64UrlDecodeMap_u24lambda_u243[61] = -2;
        byte[] $this$forEachIndexed$iv2 = base64UrlEncodeMap;
        int index$iv2 = 0;
        int length2 = $this$forEachIndexed$iv2.length;
        int i2 = 0;
        while (i2 < length2) {
            byte item$iv2 = $this$forEachIndexed$iv2[i2];
            $this$base64UrlDecodeMap_u24lambda_u243[item$iv2] = index$iv2;
            i2++;
            index$iv2++;
        }
        base64UrlDecodeMap = $this$base64UrlDecodeMap_u24lambda_u243;
    }

    public static final boolean isInMimeAlphabet(int symbol) {
        return (symbol >= 0 && symbol < base64DecodeMap.length) && base64DecodeMap[symbol] != -1;
    }
}
