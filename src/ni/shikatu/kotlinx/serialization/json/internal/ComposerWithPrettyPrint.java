package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u000bH\u0096\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\tX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/ComposerWithPrettyPrint;", "Lni/shikatu/kotlinx/serialization/json/internal/Composer;", "writer", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/json/Json;)V", "level", _UrlKt.FRAGMENT_ENCODE_SET, "indent", _UrlKt.FRAGMENT_ENCODE_SET, "unIndent", "nextItem", "nextItemIfNotFirst", "space", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComposerWithPrettyPrint extends Composer {
    private final Json json;
    private int level;

    public ComposerWithPrettyPrint(InternalJsonWriter writer, Json json) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(json, "json");
        this.json = json;
    }

    @Override
    public void indent() {
        setWritingFirst(true);
        this.level++;
    }

    @Override
    public void unIndent() {
        this.level--;
    }

    @Override
    public void nextItem() {
        setWritingFirst(false);
        print("\n");
        int i = this.level;
        for (int i2 = 0; i2 < i; i2++) {
            print(this.json.getConfiguration().getPrettyPrintIndent());
        }
    }

    @Override
    public void nextItemIfNotFirst() {
        if (!getWritingFirst()) {
            nextItem();
        } else {
            setWritingFirst(false);
        }
    }

    @Override
    public void space() {
        print(' ');
    }
}
