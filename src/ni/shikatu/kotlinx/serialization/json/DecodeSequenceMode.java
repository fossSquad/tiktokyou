package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/DecodeSequenceMode;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "WHITESPACE_SEPARATED", "ARRAY_WRAPPED", "AUTO_DETECT", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public enum DecodeSequenceMode {
    WHITESPACE_SEPARATED,
    ARRAY_WRAPPED,
    AUTO_DETECT;

    private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<DecodeSequenceMode> getEntries() {
        return $ENTRIES;
    }
}
