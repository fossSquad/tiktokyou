package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/reflect/KVariance;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public enum KVariance {
    INVARIANT,
    IN,
    OUT;

    private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<KVariance> getEntries() {
        return $ENTRIES;
    }
}
