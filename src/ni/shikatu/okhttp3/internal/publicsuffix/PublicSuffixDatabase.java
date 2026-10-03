package ni.shikatu.okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.util.List;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/okhttp3/internal/publicsuffix/PublicSuffixDatabase;", _UrlKt.FRAGMENT_ENCODE_SET, "publicSuffixList", "Lni/shikatu/okhttp3/internal/publicsuffix/PublicSuffixList;", "<init>", "(Lokhttp3/internal/publicsuffix/PublicSuffixList;)V", "getEffectiveTldPlusOne", _UrlKt.FRAGMENT_ENCODE_SET, "domain", "splitDomain", _UrlKt.FRAGMENT_ENCODE_SET, "findMatchingRule", "domainLabels", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    private final PublicSuffixList publicSuffixList;
    public static final Companion Companion = new Companion(null);
    private static final ByteString WILDCARD_LABEL = ByteString.Companion.of(42);
    private static final List<String> PREVAILING_RULE = CollectionsKt.listOf("*");
    private static PublicSuffixDatabase instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));

    public PublicSuffixDatabase(PublicSuffixList publicSuffixList) {
        Intrinsics.checkNotNullParameter(publicSuffixList, "publicSuffixList");
        this.publicSuffixList = publicSuffixList;
    }

    public final String getEffectiveTldPlusOne(String domain) {
        int firstLabelOffset;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNull(unicodeDomain);
        List<String> listSplitDomain = splitDomain(unicodeDomain);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            firstLabelOffset = listSplitDomain.size() - listFindMatchingRule.size();
        } else {
            firstLabelOffset = listSplitDomain.size() - (listFindMatchingRule.size() + 1);
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(splitDomain(domain)), firstLabelOffset), ".", null, null, 0, null, null, 62, null);
    }

    private final List<String> splitDomain(String domain) {
        List<String> listSplit$default = StringsKt.split$default((CharSequence) domain, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(CollectionsKt.last((List) listSplit$default), _UrlKt.FRAGMENT_ENCODE_SET)) {
            return CollectionsKt.dropLast(listSplit$default, 1);
        }
        return listSplit$default;
    }

    private final List<String> findMatchingRule(List<String> list) {
        List<String> listEmptyList;
        List<String> listEmptyList2;
        this.publicSuffixList.ensureLoaded();
        int size = list.size();
        ByteString[] domainLabelsUtf8Bytes = new ByteString[size];
        for (int i = 0; i < size; i++) {
            domainLabelsUtf8Bytes[i] = ByteString.Companion.encodeUtf8(list.get(i));
        }
        String exactMatch = null;
        int length = domainLabelsUtf8Bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            String rule = Companion.binarySearch(this.publicSuffixList.getBytes(), domainLabelsUtf8Bytes, i2);
            if (rule != null) {
                exactMatch = rule;
                break;
            }
        }
        String wildcardMatch = null;
        if (domainLabelsUtf8Bytes.length > 1) {
            ByteString[] labelsWithWildcard = (ByteString[]) domainLabelsUtf8Bytes.clone();
            int length2 = labelsWithWildcard.length - 1;
            for (int labelIndex = 0; labelIndex < length2; labelIndex++) {
                labelsWithWildcard[labelIndex] = WILDCARD_LABEL;
                String rule2 = Companion.binarySearch(this.publicSuffixList.getBytes(), labelsWithWildcard, labelIndex);
                if (rule2 != null) {
                    wildcardMatch = rule2;
                    break;
                }
            }
        }
        String exception = null;
        if (wildcardMatch != null) {
            int length3 = domainLabelsUtf8Bytes.length - 1;
            for (int labelIndex2 = 0; labelIndex2 < length3; labelIndex2++) {
                String rule3 = Companion.binarySearch(this.publicSuffixList.getExceptionBytes(), domainLabelsUtf8Bytes, labelIndex2);
                if (rule3 != null) {
                    exception = rule3;
                    break;
                }
            }
        }
        if (exception != null) {
            return StringsKt.split$default((CharSequence) (EXCEPTION_MARKER + exception), new char[]{'.'}, false, 0, 6, (Object) null);
        }
        if (exactMatch == null && wildcardMatch == null) {
            return PREVAILING_RULE;
        }
        if (exactMatch == null || (listEmptyList = StringsKt.split$default((CharSequence) exactMatch, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (wildcardMatch == null || (listEmptyList2 = StringsKt.split$default((CharSequence) wildcardMatch, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        if (listEmptyList.size() > listEmptyList2.size()) {
            return listEmptyList;
        }
        return listEmptyList2;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lni/shikatu/okhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "WILDCARD_LABEL", "Lni/shikatu/okio/ByteString;", "PREVAILING_RULE", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "EXCEPTION_MARKER", _UrlKt.FRAGMENT_ENCODE_SET, "instance", "Lni/shikatu/okhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", _UrlKt.FRAGMENT_ENCODE_SET, "labelIndex", _UrlKt.FRAGMENT_ENCODE_SET, "(Lokio/ByteString;[Lokio/ByteString;I)Ljava/lang/String;", "resetForTests", _UrlKt.FRAGMENT_ENCODE_SET, "resetForTests$okhttp", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        public final String binarySearch(ByteString $this$binarySearch, ByteString[] labels, int labelIndex) {
            int byte0;
            int compareResult;
            int low = 0;
            int high = $this$binarySearch.size();
            while (low < high) {
                int mid = (low + high) / 2;
                while (mid > -1 && $this$binarySearch.getByte(mid) != 10) {
                    mid--;
                }
                int mid2 = mid + 1;
                int end = 1;
                while ($this$binarySearch.getByte(mid2 + end) != 10) {
                    end++;
                }
                int publicSuffixLength = (mid2 + end) - mid2;
                int currentLabelIndex = labelIndex;
                int currentLabelByteIndex = 0;
                int publicSuffixByteIndex = 0;
                boolean expectDot = false;
                while (true) {
                    if (!expectDot) {
                        byte0 = _UtilCommonKt.and(labels[currentLabelIndex].getByte(currentLabelByteIndex), KotlinVersion.MAX_COMPONENT_VALUE);
                    } else {
                        byte0 = 46;
                        expectDot = false;
                    }
                    int byte1 = _UtilCommonKt.and($this$binarySearch.getByte(mid2 + publicSuffixByteIndex), KotlinVersion.MAX_COMPONENT_VALUE);
                    compareResult = byte0 - byte1;
                    if (compareResult != 0) {
                        break;
                    }
                    publicSuffixByteIndex++;
                    currentLabelByteIndex++;
                    if (publicSuffixByteIndex == publicSuffixLength) {
                        break;
                    }
                    if (labels[currentLabelIndex].size() == currentLabelByteIndex) {
                        if (currentLabelIndex == labels.length - 1) {
                            break;
                        }
                        currentLabelIndex++;
                        currentLabelByteIndex = -1;
                        expectDot = true;
                    }
                }
                if (compareResult < 0) {
                    high = mid2 - 1;
                } else if (compareResult > 0) {
                    low = mid2 + end + 1;
                } else {
                    int publicSuffixBytesLeft = publicSuffixLength - publicSuffixByteIndex;
                    int labelBytesLeft = labels[currentLabelIndex].size() - currentLabelByteIndex;
                    int low2 = low;
                    int low3 = labels.length;
                    for (int i = currentLabelIndex + 1; i < low3; i++) {
                        labelBytesLeft += labels[i].size();
                    }
                    if (labelBytesLeft < publicSuffixBytesLeft) {
                        high = mid2 - 1;
                        low = low2;
                    } else if (labelBytesLeft > publicSuffixBytesLeft) {
                        low = mid2 + end + 1;
                    } else {
                        int low4 = mid2 + publicSuffixLength;
                        String match = $this$binarySearch.substring(mid2, low4).string(Charsets.UTF_8);
                        return match;
                    }
                }
            }
            return null;
        }

        public final void resetForTests$okhttp() {
            PublicSuffixDatabase.instance = new PublicSuffixDatabase(PublicSuffixList_androidKt.getDefault(PublicSuffixList.Companion));
        }
    }
}
