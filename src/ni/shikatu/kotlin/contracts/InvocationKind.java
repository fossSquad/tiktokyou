package ni.shikatu.kotlin.contracts;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0006\b\u0004\u0012\u0002\b\u0005j\u0006\b\u0006\u0012\u0002\b\u0005j\u0006\b\u0007\u0012\u0002\b\u0005j\u0006\b\b\u0012\u0002\b\u0005Ê\u0001\u0002\b\u0005Ê\u0001\u0002\b\nÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/contracts/InvocationKind;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "Lni/shikatu/kotlin/internal/ContractsDsl;", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/contracts/ExperimentalContracts;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
public enum InvocationKind {
    AT_MOST_ONCE,
    AT_LEAST_ONCE,
    EXACTLY_ONCE,
    UNKNOWN;

    private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<InvocationKind> getEntries() {
        return $ENTRIES;
    }
}
