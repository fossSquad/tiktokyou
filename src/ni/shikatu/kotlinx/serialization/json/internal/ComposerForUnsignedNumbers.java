package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0096\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lni/shikatu/kotlinx/serialization/json/internal/Composer;", "writer", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "print", _UrlKt.FRAGMENT_ENCODE_SET, "v", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean forceQuoting) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = forceQuoting;
    }

    @Override
    public void print(int v) {
        if (this.forceQuoting) {
            printQuoted(Integer.toUnsignedString(UInt.m101constructorimpl(v)));
        } else {
            print(Integer.toUnsignedString(UInt.m101constructorimpl(v)));
        }
    }

    @Override
    public void print(long v) {
        if (this.forceQuoting) {
            printQuoted(Long.toUnsignedString(ULong.m180constructorimpl(v)));
        } else {
            print(Long.toUnsignedString(ULong.m180constructorimpl(v)));
        }
    }

    @Override
    public void print(byte v) {
        if (this.forceQuoting) {
            printQuoted(UByte.m68toStringimpl(UByte.m24constructorimpl(v)));
        } else {
            print(UByte.m68toStringimpl(UByte.m24constructorimpl(v)));
        }
    }

    @Override
    public void print(short v) {
        if (this.forceQuoting) {
            printQuoted(UShort.m331toStringimpl(UShort.m287constructorimpl(v)));
        } else {
            print(UShort.m331toStringimpl(UShort.m287constructorimpl(v)));
        }
    }
}
