package ni.shikatu.kotlin.coroutines.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\nH\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\rH\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0016H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007\u001a$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u001cH\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¨\u0006\u001d"}, d2 = {"boxBoolean", "Ljava/lang/Boolean;", TreeJsonEncoderKt.PRIMITIVE_TAG, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/PublishedApi;", "boxByte", "Ljava/lang/Byte;", _UrlKt.FRAGMENT_ENCODE_SET, "boxShort", "Ljava/lang/Short;", _UrlKt.FRAGMENT_ENCODE_SET, "boxInt", "Ljava/lang/Integer;", _UrlKt.FRAGMENT_ENCODE_SET, "boxLong", "Ljava/lang/Long;", _UrlKt.FRAGMENT_ENCODE_SET, "boxFloat", "Ljava/lang/Float;", _UrlKt.FRAGMENT_ENCODE_SET, "boxDouble", "Ljava/lang/Double;", _UrlKt.FRAGMENT_ENCODE_SET, "boxChar", "Ljava/lang/Character;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class Boxing {
    public static final Boolean boxBoolean(boolean primitive) {
        return Boolean.valueOf(primitive);
    }

    public static final Byte boxByte(byte primitive) {
        return Byte.valueOf(primitive);
    }

    public static final Short boxShort(short primitive) {
        return new Short(primitive);
    }

    public static final Integer boxInt(int primitive) {
        return new Integer(primitive);
    }

    public static final Long boxLong(long primitive) {
        return new Long(primitive);
    }

    public static final Float boxFloat(float primitive) {
        return new Float(primitive);
    }

    public static final Double boxDouble(double primitive) {
        return new Double(primitive);
    }

    public static final Character boxChar(char primitive) {
        return new Character(primitive);
    }
}
