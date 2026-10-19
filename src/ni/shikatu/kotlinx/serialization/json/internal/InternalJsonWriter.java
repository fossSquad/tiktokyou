package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0012\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004J\u0012\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH¦\u0080\u0004J\u0012\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦\u0080\u0004J\u0012\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦\u0080\u0004J\n\u0010\r\u001a\u00020\u0003H¦\u0080\u0004¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", _UrlKt.FRAGMENT_ENCODE_SET, "writeLong", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "writeChar", "char", _UrlKt.FRAGMENT_ENCODE_SET, "write", "text", _UrlKt.FRAGMENT_ENCODE_SET, "writeQuoted", "release", "Companion", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@JsonFriendModuleApi
public interface InternalJsonWriter {
    public static final Companion Companion = Companion.$$INSTANCE;

    void release();

    void write(String str);

    void writeChar(char c);

    void writeLong(long j);

    void writeQuoted(String str);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072K\u0010\b\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\tH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "doWriteEscaping", _UrlKt.FRAGMENT_ENCODE_SET, "text", _UrlKt.FRAGMENT_ENCODE_SET, "writeImpl", "Lni/shikatu/kotlin/Function3;", "Lni/shikatu/kotlin/ParameterName;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "startIndex", "endIndex", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final void doWriteEscaping(String text, Function3<? super String, ? super Integer, ? super Integer, Unit> function3) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(function3, "writeImpl");
            int lastPos = 0;
            int length = text.length();
            for (int i = 0; i < length; i++) {
                int c = text.charAt(i);
                if (c < StringOpsKt.getESCAPE_STRINGS().length && StringOpsKt.getESCAPE_STRINGS()[c] != null) {
                    function3.invoke(text, Integer.valueOf(lastPos), Integer.valueOf(i));
                    String escape = StringOpsKt.getESCAPE_STRINGS()[c];
                    Intrinsics.checkNotNull(escape);
                    function3.invoke(escape, 0, Integer.valueOf(escape.length()));
                    lastPos = i + 1;
                }
            }
            function3.invoke(text, Integer.valueOf(lastPos), Integer.valueOf(text.length()));
        }
    }
}
