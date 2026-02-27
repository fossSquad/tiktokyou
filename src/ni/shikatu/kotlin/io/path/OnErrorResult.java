package ni.shikatu.kotlin.io.path;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/io/path/OnErrorResult;", "", "<init>", "(Ljava/lang/String;I)V", "SKIP_SUBTREE", "TERMINATE", "ni.shikatu.kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum OnErrorResult {
    SKIP_SUBTREE,
    TERMINATE;

    private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<OnErrorResult> getEntries() {
        return $ENTRIES;
    }
}
