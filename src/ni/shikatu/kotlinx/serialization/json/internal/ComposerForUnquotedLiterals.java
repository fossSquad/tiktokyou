package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/ComposerForUnquotedLiterals;", "Lni/shikatu/kotlinx/serialization/json/internal/Composer;", "writer", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "printQuoted", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComposerForUnquotedLiterals extends Composer {
    private final boolean forceQuoting;

    public ComposerForUnquotedLiterals(InternalJsonWriter writer, boolean forceQuoting) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = forceQuoting;
    }

    @Override
    public void printQuoted(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.forceQuoting) {
            super.printQuoted(value);
        } else {
            super.print(value);
        }
    }
}
