package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/WriteMode;", _UrlKt.FRAGMENT_ENCODE_SET, "begin", _UrlKt.FRAGMENT_ENCODE_SET, "end", "<init>", "(Ljava/lang/String;ICC)V", "OBJ", "LIST", "MAP", "POLY_OBJ", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum WriteMode {
    OBJ(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ),
    LIST(AbstractJsonLexerKt.BEGIN_LIST, AbstractJsonLexerKt.END_LIST),
    MAP(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ),
    POLY_OBJ(AbstractJsonLexerKt.BEGIN_LIST, AbstractJsonLexerKt.END_LIST);

    public final char begin;
    public final char end;
    private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<WriteMode> getEntries() {
        return $ENTRIES;
    }

    WriteMode(char begin, char end) {
        this.begin = begin;
        this.end = end;
    }
}
