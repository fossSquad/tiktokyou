package ni.shikatu.kotlin.io.path;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006Ê\u0001\u0010\b\b\u0012\f\b\t\u0012\b\b\fJ\u0004\b\t0\nÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/io/path/PathWalkOption;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "ni.shikatu.kotlin-stdlib-jdk7", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/io/path/ExperimentalPathApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public enum PathWalkOption {
    INCLUDE_DIRECTORIES,
    BREADTH_FIRST,
    FOLLOW_LINKS;

    private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<PathWalkOption> getEntries() {
        return $ENTRIES;
    }
}
