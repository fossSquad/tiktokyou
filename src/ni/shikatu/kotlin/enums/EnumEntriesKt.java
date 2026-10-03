package ni.shikatu.kotlin.enums;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NotImplementedError;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0010\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0088\u0004b\u0010\b\u0004\u0012\f\b\u0005\u0012\b\b\fJ\u0004\b\t0\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r0\fH\u0081\u0080\u0004b\u0002\b\u000eb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u001aI\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0081\u0080\u0004b\u0002\b\u000eb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000fb\u0002\b\u0012¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"enumEntries", "Lni/shikatu/kotlin/enums/EnumEntries;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.0", "E", "entriesProvider", "Lni/shikatu/kotlin/Function0;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/PublishedApi;", "1.8", "entries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "Lni/shikatu/kotlin/internal/UsedFromCompilerGeneratedCode;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class EnumEntriesKt {

    public static final  <T extends Enum<T>> EnumEntries<T> enumEntries() {
        throw new NotImplementedError(null, 1, 0 == true ? 1 : 0);
    }

    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(Function0<E[]> function0) {
        Intrinsics.checkNotNullParameter(function0, "entriesProvider");
        return new EnumEntriesList(function0.invoke());
    }

    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "entries");
        return new EnumEntriesList(eArr);
    }
}
