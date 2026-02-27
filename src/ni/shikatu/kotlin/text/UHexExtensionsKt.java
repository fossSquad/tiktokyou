package ni.shikatu.kotlin.text;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\r\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0012\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00132\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00182\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u001d2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u001d*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"toHexString", "", "Lni/shikatu/kotlin/UByteArray;", "format", "Lni/shikatu/kotlin/text/HexFormat;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByteArray", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "Lni/shikatu/kotlin/UByte;", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByte", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "Lni/shikatu/kotlin/UShort;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUShort", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "Lni/shikatu/kotlin/UInt;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUInt", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "Lni/shikatu/kotlin/ULong;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToULong", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UHexExtensionsKt {

    static  String m1347toHexStringzHuV2wU$default(byte[] $this$toHexString_u2dzHuV2wU_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$toHexString_u2dzHuV2wU_u24default, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dzHuV2wU_u24default, format);
    }

    private static final String m1346toHexStringzHuV2wU(byte[] $this$toHexString_u2dzHuV2wU, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString_u2dzHuV2wU, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dzHuV2wU, format);
    }

    static  String m1343toHexStringlZCiFrA$default(byte[] $this$toHexString_u2dlZCiFrA_u24default, int startIndex, int endIndex, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            startIndex = 0;
        }
        if ((i & 2) != 0) {
            endIndex = UByteArray.m81getSizeimpl($this$toHexString_u2dlZCiFrA_u24default);
        }
        if ((i & 4) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$toHexString_u2dlZCiFrA_u24default, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dlZCiFrA_u24default, startIndex, endIndex, format);
    }

    private static final String m1342toHexStringlZCiFrA(byte[] $this$toHexString_u2dlZCiFrA, int startIndex, int endIndex, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString_u2dlZCiFrA, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dlZCiFrA, startIndex, endIndex, format);
    }

    static  byte[] hexToUByteArray$default(String $this$hexToUByteArray_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUByteArray_u24default, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByteArray.m75constructorimpl(HexExtensionsKt.hexToByteArray($this$hexToUByteArray_u24default, format));
    }

    private static final byte[] hexToUByteArray(String $this$hexToUByteArray, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUByteArray, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByteArray.m75constructorimpl(HexExtensionsKt.hexToByteArray($this$hexToUByteArray, format));
    }

    static  String m1341toHexStringZQbaR00$default(byte $this$toHexString_u2dZQbaR00_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dZQbaR00_u24default, format);
    }

    private static final String m1340toHexStringZQbaR00(byte $this$toHexString_u2dZQbaR00, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dZQbaR00, format);
    }

    static  byte hexToUByte$default(String $this$hexToUByte_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUByte_u24default, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByte.m22constructorimpl(HexExtensionsKt.hexToByte($this$hexToUByte_u24default, format));
    }

    private static final byte hexToUByte(String $this$hexToUByte, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUByte, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByte.m22constructorimpl(HexExtensionsKt.hexToByte($this$hexToUByte, format));
    }

    static  String m1345toHexStringr3ox_E0$default(short $this$toHexString_u2dr3ox_E0_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dr3ox_E0_u24default, format);
    }

    private static final String m1344toHexStringr3ox_E0(short $this$toHexString_u2dr3ox_E0, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2dr3ox_E0, format);
    }

    static  short hexToUShort$default(String $this$hexToUShort_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUShort_u24default, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UShort.m285constructorimpl(HexExtensionsKt.hexToShort($this$hexToUShort_u24default, format));
    }

    private static final short hexToUShort(String $this$hexToUShort, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUShort, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UShort.m285constructorimpl(HexExtensionsKt.hexToShort($this$hexToUShort, format));
    }

    static  String m1337toHexString8M7LxHw$default(int $this$toHexString_u2d8M7LxHw_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8M7LxHw_u24default, format);
    }

    private static final String m1336toHexString8M7LxHw(int $this$toHexString_u2d8M7LxHw, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8M7LxHw, format);
    }

    static  int hexToUInt$default(String $this$hexToUInt_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToUInt_u24default, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UInt.m99constructorimpl(HexExtensionsKt.hexToInt($this$hexToUInt_u24default, format));
    }

    private static final int hexToUInt(String $this$hexToUInt, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToUInt, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UInt.m99constructorimpl(HexExtensionsKt.hexToInt($this$hexToUInt, format));
    }

    static  String m1339toHexString8UJCmI$default(long $this$toHexString_u2d8UJCm_u2dI_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8UJCm_u2dI_u24default, format);
    }

    private static final String m1338toHexString8UJCmI(long $this$toHexString_u2d8UJCm_u2dI, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString_u2d8UJCm_u2dI, format);
    }

    static  long hexToULong$default(String $this$hexToULong_u24default, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter($this$hexToULong_u24default, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ULong.m178constructorimpl(HexExtensionsKt.hexToLong($this$hexToULong_u24default, format));
    }

    private static final long hexToULong(String $this$hexToULong, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToULong, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ULong.m178constructorimpl(HexExtensionsKt.hexToLong($this$hexToULong, format));
    }
}
